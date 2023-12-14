package com.mentors.serviceImpl;

import com.mentors.dto.ApiResponseWithoutMentorObject;
import com.mentors.dto.MentorLogin;
import com.mentors.entity.CourseSessionWithMentor;
import com.mentors.entity.MentorStatus;
import com.mentors.entity.Mentors;
import com.mentors.entity.TrainingSession;
import com.mentors.exception.ResourceNotFoundException;
import com.mentors.repo.MentorRepository;
import com.mentors.securityconfig.JwtHelper;
import com.mentors.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MentorServiceImpl implements MentorService, UserDetailsService{

    @Autowired
    private MentorRepository mentorRepository;

    @Autowired
    private WebClient webClient;

    @Autowired
    private JwtHelper helper;

    @Autowired
    private AuthenticationManager authenticationManager;

//    private final String TRAINING_SERVICE_URL = "http://trainingservice"; // Replace with actual URL

    @Override
    public List<Mentors> getAllMentors() {
        return mentorRepository.findAll();
    }

    @Override
    public Mentors getMentorById(Long mentorId) {
        return mentorRepository.findById(mentorId).orElse(null);
    }

    @Override
    public Mentors createMentor(Mentors mentors) {
        Mentors mentor = new Mentors();
        mentor.setMentorName(mentors.getMentorName());
        mentor.setMentorEmail(mentors.getMentorEmail());
        mentor.setMentorPassword(mentors.getMentorPassword());
        mentor.setMentorDesignation(mentors.getMentorDesignation());
        mentor.setSkillSet(mentors.getSkillSet());
        mentor.setStatus(MentorStatus.AVAILABLE);
        mentor.setNumberOfAssignedTrainings(0);
        return mentorRepository.save(mentor);
    }

    @Override
    public Mentors updateMentorById(Mentors mentors, Long mentorId) {
        Mentors existingMentor = mentorRepository.findById(mentorId).orElseThrow(
                () -> new ResourceNotFoundException("Mentor", "id", mentorId)
        );
        existingMentor.setMentorName(mentors.getMentorName());
        existingMentor.setMentorEmail(mentors.getMentorEmail());
        existingMentor.setMentorPassword(mentors.getMentorPassword());
        existingMentor.setMentorDesignation(mentors.getMentorDesignation());
        existingMentor.setSkillSet(mentors.getSkillSet());
        existingMentor.setNumberOfAssignedTrainings(mentors.getNumberOfAssignedTrainings());
        Mentors updateMentor = mentorRepository.save(existingMentor);
        return updateMentor;
    }

    @Override
    public void deleteMentorById(Long mentorId) {
        mentorRepository.deleteById(mentorId);
    }


    @Override
    public List<TrainingSession> getSessionsByMentorId(Long mentorId) {
        mentorRepository.findById(mentorId).orElseThrow(
                () -> new ResourceNotFoundException("Mentor", "id", mentorId)
        );
        List<TrainingSession> session = webClient.get()
                .uri("http://localhost:1232/api/session/by-mentor/" + mentorId)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<TrainingSession>>() {})
                .block();
        return session;
    }

    @Override
    public ApiResponseWithoutMentorObject getTrainingByMentorIdAndSessionId(Long sessionId, Long mentorId) {
        mentorRepository.findById(mentorId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Mentor", "id", mentorId));

        ApiResponseWithoutMentorObject apiResponseWithoutMentorObject = webClient.get()
                .uri("http://localhost:1232/api/session/" + sessionId + "/" + mentorId)
                .retrieve()
                .bodyToMono(ApiResponseWithoutMentorObject.class)
                .block();
        return apiResponseWithoutMentorObject;
    }

    @Override
    public String  doLogin(MentorLogin mentorLogin) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                mentorLogin.getMentorEmail(), mentorLogin.getMentorPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = helper.generateToken(authentication);

        return token;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Mentors foundedMentors = mentorRepository.findByMentorEmail(username).orElseThrow(
                ResourceNotFoundException::new
        );
        String mentorEmail = foundedMentors.getMentorEmail();
        String mentorPassword = new BCryptPasswordEncoder().encode(foundedMentors.getMentorPassword());
        return new org.springframework.security.core.userdetails.User(mentorEmail, mentorPassword, new ArrayList<>());
    }
}

