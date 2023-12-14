package com.trainingsession.serviceImpl;

import com.trainingsession.dto.ApiResponse;
import com.trainingsession.dto.ApiResponseWithoutMentorObject;
import com.trainingsession.entity.*;
import com.trainingsession.exception.ResourceNotFoundException;
import com.trainingsession.repo.TrainingSessionRepository;
import com.trainingsession.service.TrainingSessionService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class TrainingSessionServiceImpl implements TrainingSessionService {

    @Autowired
    private TrainingSessionRepository trainingSessionRepository;

//    @Value("${app.jwt-secret}")
//    private String jwtSecret;

//    @Autowired
//    private CourseRepository courseRepository;

    @Autowired
    private WebClient webClient;

    @Override
    public List<TrainingSession> getAllTrainingSessions() {
        try {
            List<TrainingSession> trainingSessionList = trainingSessionRepository.findAll();
            if (!trainingSessionList.isEmpty()) {
                return trainingSessionList;
            } else {
                throw new ResourceNotFoundException();
            }
        } catch (Exception e) {
            throw new ServiceException("Failed to retrieve training sessions: ", e);
        }
    }

    @Override
    public ApiResponse getTrainingSessionBySessionId(Long sessionId, String token) {
        TrainingSession trainingSession = trainingSessionRepository.findById(sessionId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Training", "id", sessionId)
                );
        // Fetch Mentor, Course, and Batch asynchronously
        String token1 = token.substring(7);
        Mentors mentor = webClient.get()
                .uri("http://localhost:1231/api/mentors/" + trainingSession.getMentorId())
                .headers(httpHeaders -> httpHeaders.setBearerAuth(token1))
                .retrieve()
                .bodyToMono(Mentors.class)
                .block();

        Course course = webClient.get()
                .uri("http://localhost:8082/api/courses/get/" + trainingSession.getCourseId())
                .retrieve()
                .bodyToMono(Course.class)
                .block();

        Batch batch = webClient.get()
                .uri("http://localhost:1233/api/batch/" + trainingSession.getBatchId())
                .retrieve()
                .bodyToMono(Batch.class)
                .block();

        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setTraining(trainingSession);
        apiResponse.setMentor(mentor);
        apiResponse.setCourse(course);
        apiResponse.setBatch(batch);

        return apiResponse;

    }

    @Override
    public List<TrainingSession> getTrainingSessionByMentorId(Long mentorId) {
        try {
            List<TrainingSession> trainingSessionList = trainingSessionRepository.findByMentorId(mentorId);
            if (!trainingSessionList.isEmpty()) {
                return trainingSessionList;
            } else {
                throw new ResourceNotFoundException("Training Sessions", "mentorId", mentorId);
            }
        } catch (Exception e) {
            throw new ServiceException("Failed to retrieve training sessions for mentorId: " + mentorId, e);
        }
    }

    @Override
    public ApiResponseWithoutMentorObject getTrainingSessionBySessionIdAndMentorId(Long sessionId, Long mentorId) {
        TrainingSession trainingSession = trainingSessionRepository.findBySessionIdAndMentorId(sessionId, mentorId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("TrainingSession not found for sessionId " + sessionId + " and mentorId " + mentorId));

        Course course = webClient.get()
                .uri("http://localhost:8082/api/courses/get/" + trainingSession.getCourseId())
                .retrieve()
                .bodyToMono(Course.class)
                .block();

        Batch batch = webClient.get()
                .uri("http://localhost:1233/api/batch/" + trainingSession.getBatchId())
                .retrieve()
                .bodyToMono(Batch.class)
                .block();

        ApiResponseWithoutMentorObject apiResponseWithoutMentorData = new ApiResponseWithoutMentorObject();
        apiResponseWithoutMentorData.setTraining(trainingSession);
        apiResponseWithoutMentorData.setBatch(batch);
        apiResponseWithoutMentorData.setCourse(course);

        return apiResponseWithoutMentorData;
    }


    @Override
    public TrainingSession saveTrainingSession(TrainingSession trainingSession, String token) {
        //Call MentorById
        try {
            String token1 = token.substring(7);
            Mentors mentor = webClient.get()
                    .uri("http://localhost:1231/api/mentors/" + trainingSession.getMentorId())
                    .headers(httpHeaders -> httpHeaders.setBearerAuth(token1))
                    .retrieve()
                    .bodyToMono(Mentors.class)
                    .block();
            //Call CourseById
            Course course = webClient.get()
                    .uri("http://localhost:8082/api/courses/get/" + trainingSession.getCourseId())
                    .retrieve()
                    .bodyToMono(Course.class)
                    .block();
            //Call BatchById
            Batch batch = webClient.get()
                    .uri("http://localhost:1233/api/batch/" + trainingSession.getBatchId())
                    .retrieve()
                    .bodyToMono(Batch.class)
                    .block();

            TrainingSession saveSession = new TrainingSession();
            saveSession.setStartDate(trainingSession.getStartDate());
            saveSession.setEndDate(trainingSession.getEndDate());
            saveSession.setStartTime(trainingSession.getStartTime());
            saveSession.setEndTime(trainingSession.getEndTime());
            saveSession.setMentorId(mentor.getMentorId());
            saveSession.setCourseId(course.getCourseId());
            saveSession.setBatchId(batch.getBatchId());
            saveSession.setTrainingStatus(TrainingStatus.SCHEDULED);

            // Save the TrainingSession
            return trainingSessionRepository.save(saveSession);
        } catch (Exception e) {
            throw new RuntimeException("Failed to save TrainingSession", e);
        }

    }

    @Override
    public TrainingSession updateTrainingSession(Long sessionId, TrainingSession trainingSession, String token) {
        TrainingSession existingSession = trainingSessionRepository.findById(sessionId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Training", "id", sessionId)
                );
        //Call MentorById
        String token1 = token.substring(7);
        Mentors mentor = webClient.get()
                .uri("http://localhost:1231/api/mentors/" + trainingSession.getMentorId())
                .headers(httpHeaders -> httpHeaders.setBearerAuth(token1))
                .retrieve()
                .bodyToMono(Mentors.class)
                .block();
        //Call CourseById
        Course course = webClient.get()
                .uri("http://localhost:8082/api/courses/get/" + trainingSession.getCourseId())
                .retrieve()
                .bodyToMono(Course.class)
                .block();
        //Call BatchById
        Batch batch = webClient.get()
                .uri("http://localhost:1233/api/batch/" + trainingSession.getBatchId())
                .retrieve()
                .bodyToMono(Batch.class)
                .block();

        // Combine the results of the asynchronous calls

        existingSession.setStartDate(trainingSession.getStartDate());
        existingSession.setEndDate(trainingSession.getEndDate());
        existingSession.setStartTime(trainingSession.getStartTime());
        existingSession.setEndTime(trainingSession.getEndTime());
        existingSession.setMentorId(mentor.getMentorId());
        existingSession.setCourseId(course.getCourseId());
        existingSession.setBatchId(batch.getBatchId());
        return trainingSessionRepository.save(existingSession);

    }

    @Override
    public TrainingSession updateTrainingSessionStatus(Long sessionId, TrainingStatus trainingStatus) {
        TrainingSession existingSession = trainingSessionRepository.findById(sessionId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Training", "id", sessionId)
                );
        existingSession.setTrainingStatus(trainingStatus);
        return trainingSessionRepository.save(existingSession);
    }

    @Override
    public void deleteTrainingSessionBytId(Long sessionId) {
        trainingSessionRepository.deleteById(sessionId);
    }

//    @Override
//    public ApiResponse getSessionCourseBytId(Long tId) {
//        return null;
//    }

//    @Override
//    public ApiResponse getSessionCourseBytId(Long tId) {
//        TrainingSession trainingSession = trainingSessionRepository.findById(tId).get();
//        Course course = courseRepository.findById(trainingSession.getCourseId()).get();
//        SessionCourse getSessionCourse = new SessionCourse();
//        getSessionCourse.setTrainingSession(trainingSession);
//        getSessionCourse.setCourse(course);
//        return getSessionCourse;
//    }

//    @Override
//    public boolean isTrainingSessionCompletedWithinTimeFrame(Long sessionId) {
//        TrainingSession session = getTrainingSessionBytId(sessionId);
//        return session != null && session.isCompletedWithInTimeFrame();
//    }
}
