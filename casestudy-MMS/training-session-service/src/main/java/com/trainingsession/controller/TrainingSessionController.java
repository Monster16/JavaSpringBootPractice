package com.trainingsession.controller;

import com.trainingsession.dto.ApiResponse;
import com.trainingsession.dto.ApiResponseWithoutMentorObject;
import com.trainingsession.entity.TrainingSession;
import com.trainingsession.entity.TrainingStatus;
import com.trainingsession.securityconfig.JwtHelper;
import com.trainingsession.service.TrainingSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/session")
public class TrainingSessionController {

    @Autowired
    private TrainingSessionService trainingSessionService;

    @Autowired
    private JwtHelper jwtHelper;

    /**
     * @return
     */
    @GetMapping("/all")
    public ResponseEntity<?> getAllTrainingSessions() {
        List<TrainingSession> trainingSessions = trainingSessionService.getAllTrainingSessions();
        return new ResponseEntity<>(trainingSessions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getTrainingSessionsBySessionId(@PathVariable("id") Long sessionId,
                                                                      @RequestHeader("Authorization") String token) {
//        jwtHelper.getUsername(token);
//        System.out.println(token);
        if(!jwtHelper.validateToken(token)){
            throw new RuntimeException("Bad token");
        }
        ApiResponse session = trainingSessionService.getTrainingSessionBySessionId(sessionId,token);
        return new ResponseEntity<>(session, HttpStatus.OK);
    }

    @GetMapping("/by-mentor/{id}")
    public ResponseEntity<List<TrainingSession>> getTrainingSessionsByMentorId(@PathVariable("id") Long mentorId){
        List<TrainingSession> trainingSessionList = trainingSessionService.getTrainingSessionByMentorId(mentorId);
        return new ResponseEntity<>(trainingSessionList, HttpStatus.OK);
    }

    @GetMapping("/{sessionId}/{mentorId}")
    public ResponseEntity<?> getSessionBySessionIdAndMentorId(@PathVariable Long sessionId,
                                                              @PathVariable Long mentorId) {
        ApiResponseWithoutMentorObject trainingSession = trainingSessionService.getTrainingSessionBySessionIdAndMentorId(sessionId,mentorId);
        return new ResponseEntity<>(trainingSession, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> saveTrainingSession(@RequestBody TrainingSession session,
                                                      @RequestHeader("Authorization") String token) {
        if(!jwtHelper.validateToken(token)){
            throw new RuntimeException("not good;");
        }
        TrainingSession trainingSession = trainingSessionService.saveTrainingSession(session, token);
        return new ResponseEntity<>(trainingSession, HttpStatus.CREATED);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> updateTrainingSession(@PathVariable("id") Long sessionId,
                                                   @RequestBody TrainingSession session,
                                                   @RequestHeader("Authorization") String token) {
        if(!jwtHelper.validateToken(token)){
            throw new RuntimeException("not good;");
        }
        TrainingSession trainingSession = trainingSessionService.updateTrainingSession(sessionId,session,token);
        return new ResponseEntity<>(trainingSession, HttpStatus.OK);
    }

    /**
     * http://localhost:1232/api/session/1/update-status?newStatus=IN_PROGRESS
     * @param sessionId
     * @param newStatus
     * @return
     */
    @PutMapping("/{id}/update-status")
    public ResponseEntity<?> updateTrainingSessionStatus(@PathVariable("id") Long sessionId,
                                                         @RequestParam TrainingStatus newStatus) {
        TrainingSession updateSession = trainingSessionService.updateTrainingSessionStatus(sessionId, newStatus);
        return new ResponseEntity<>(updateSession, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTrainingSession(@PathVariable("id") Long sessionId) {
        trainingSessionService.deleteTrainingSessionBytId(sessionId);
        return new ResponseEntity<>("Training Session Deleted Successfully with id: %s", HttpStatus.OK);
    }

//    @GetMapping("/completed/{id}")
//    public boolean isTrainingCompletedCompletedWithinTimeFrame(@PathVariable("id") Long sessionId) {
//        return trainingSessionService.isTrainingSessionCompletedWithinTimeFrame(sessionId);
//    }


//    @GetMapping("getSessionCourse/{id}")
//    public ResponseEntity<ApiResponse> getSessionCourse(@PathVariable("id") Long sessionId) {
//        ApiResponse session = trainingSessionService.getSessionCourseBytId(sessionId);
//        return new ResponseEntity<>(session, HttpStatus.OK);
//    }


}
