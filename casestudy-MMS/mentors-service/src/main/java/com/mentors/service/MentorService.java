package com.mentors.service;

import com.mentors.dto.ApiResponseWithoutMentorObject;
import com.mentors.dto.MentorLogin;
import com.mentors.entity.CourseSessionWithMentor;
import com.mentors.entity.Mentors;
import com.mentors.entity.TrainingSession;

import java.time.LocalDateTime;
import java.util.List;

public interface MentorService {

    List<Mentors> getAllMentors();

    Mentors getMentorById(Long mentorId);

//    List<MentorStatusDTO> getAllMentorsWithStatus();
    Mentors createMentor(Mentors mentors);

    Mentors updateMentorById(Mentors mentors, Long mentorId);
//    List<Mentors> getAvailableMentors(LocalDateTime startDateTime, LocalDateTime endDateTime);
    void deleteMentorById(Long mentorId);

    List<TrainingSession> getSessionsByMentorId(Long mentorId);

    ApiResponseWithoutMentorObject getTrainingByMentorIdAndSessionId(Long sessionId, Long mentorId);

//    CourseSessionWithMentor getCourseSessionWithMentor(Long mentorId);
    String doLogin(MentorLogin mentorLogin);

}

