package com.mentors.controller;

import com.mentors.dto.ApiResponseWithoutMentorObject;
import com.mentors.dto.JwtResponse;
import com.mentors.dto.MentorLogin;
import com.mentors.entity.Mentors;
import com.mentors.entity.TrainingSession;
import com.mentors.securityconfig.JwtHelper;
import com.mentors.service.MentorService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("api/mentors")
public class MentorController {

    @Autowired
    private MentorService mentorService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;


    @Autowired
    private JwtHelper helper;

    private static final Logger LOGGER = LoggerFactory.getLogger(MentorController.class);

    @GetMapping("/all")
    public ResponseEntity<Object> getAllMentors() {
        List<Mentors> mentors = mentorService.getAllMentors();
        return new ResponseEntity<>(mentors, HttpStatus.OK);
    }

    @GetMapping("/{mentorId}")
    public ResponseEntity<Object> getMentorById(@PathVariable Long mentorId) {
        Mentors mentors = mentorService.getMentorById(mentorId);
        return new ResponseEntity<>(mentors, HttpStatus.OK);
    }

    @GetMapping("/session/{mentorId}")
    public ResponseEntity<?> getSessionByMentorId(@PathVariable Long mentorId) {
        List<TrainingSession> trainingSession = mentorService.getSessionsByMentorId(mentorId);
        return new ResponseEntity<>(trainingSession, HttpStatus.OK);
    }

    @GetMapping("/{sessionId}/{mentorId}")
    public ResponseEntity<?> getSessionBySessionIdAndMentorId(@PathVariable Long sessionId,
                                                              @PathVariable Long mentorId) {
        ApiResponseWithoutMentorObject trainingSession = mentorService.getTrainingByMentorIdAndSessionId(sessionId,mentorId);
        return new ResponseEntity<>(trainingSession, HttpStatus.OK);
    }



    @PostMapping("/create")
    public ResponseEntity<Object> createMentor(@RequestBody Mentors mentors) {
        Mentors saveMentors = mentorService.createMentor(mentors);
        return new ResponseEntity<>(saveMentors, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateMentorById(@RequestBody Mentors mentors,
                                          @PathVariable("id") Long mentorId){

        Mentors updateMentors = mentorService.updateMentorById(mentors, mentorId);
        return new ResponseEntity<>(updateMentors, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteMentor(@PathVariable("id") Long mentorId) {
        mentorService.deleteMentorById(mentorId);
        return new ResponseEntity<>("Mentor Deleted Successfully with id: " + mentorId, HttpStatus.OK);
    }



//    @GetMapping("/{mentorId}/sessions")
//    public List<TrainingSession> getSessionsByMentorId(@PathVariable Long mentorId) {
//        return mentorService.getSessionsByMentorId(mentorId);
//    }


//    @GetMapping("/{mentorId}/training-sessions")
//    public ResponseEntity<Object> getTrainingSessionsForMentor(@PathVariable Long mentorId) {
//        // Make a request to the TrainingSession microservice to get sessions for this mentor
//        CourseSessionWithMentor getCourseSessionWithMentor = mentorService.getCourseSessionWithMentor(mentorId);
//        return new ResponseEntity<>(getCourseSessionWithMentor, HttpStatus.OK);
//    }

    @PostMapping("/login")
    private ResponseEntity<?> authMentor(@RequestBody MentorLogin mentor) {
//        String email = mentor.getMentorEmail();
//        String password = mentor.getMentorPassword();
//        try
//        {
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
//            UserDetails userDetails = userDetailsService.loadUserByUsername(mentor.getMentorEmail());
//            String token = this.helper.generateToken(userDetails);
//            JwtResponse response = JwtResponse.builder()
//                    .token(token)
//                    .mentorEmail(userDetails.getUsername()).build();
//            return new ResponseEntity<>(response, HttpStatus.OK);
//        }
//        catch (Exception e)
//        {
//            return new ResponseEntity<>("Incorrect username or password!", HttpStatus.BAD_REQUEST);
//
//        }
        String token = mentorService.doLogin(mentor);

        JwtResponse jwtAuthResponse = new JwtResponse();
        jwtAuthResponse.setToken(token);
        return ResponseEntity.ok(jwtAuthResponse);
    }



}

