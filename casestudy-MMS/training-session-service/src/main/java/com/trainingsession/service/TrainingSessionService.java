package com.trainingsession.service;

import com.trainingsession.dto.ApiResponse;
import com.trainingsession.dto.ApiResponseWithoutMentorObject;
import com.trainingsession.entity.TrainingSession;
import com.trainingsession.entity.TrainingStatus;

import java.util.List;

public interface TrainingSessionService {

    List<TrainingSession> getAllTrainingSessions();

    ApiResponse getTrainingSessionBySessionId(Long sessionId, String token);

    List<TrainingSession> getTrainingSessionByMentorId(Long mentorId);

    ApiResponseWithoutMentorObject getTrainingSessionBySessionIdAndMentorId(Long sessionId, Long mentorId);

    TrainingSession saveTrainingSession(TrainingSession trainingSession, String token);

    TrainingSession updateTrainingSession(Long sessionId, TrainingSession trainingSession, String token);

    TrainingSession updateTrainingSessionStatus(Long sessionId, TrainingStatus trainingStatus);

    void deleteTrainingSessionBytId(Long sessionId);

//    boolean isTrainingSessionCompletedWithinTimeFrame(Long tId);

//    ApiResponse getSessionCourseBytId(Long tId);

}

