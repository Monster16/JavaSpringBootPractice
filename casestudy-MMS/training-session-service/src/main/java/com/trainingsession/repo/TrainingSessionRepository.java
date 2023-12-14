package com.trainingsession.repo;

import com.trainingsession.entity.TrainingSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TrainingSessionRepository extends JpaRepository<TrainingSession, Long> {

    List<TrainingSession> findByMentorId(Long mentorId);

    Optional<TrainingSession> findBySessionIdAndMentorId(Long sessionId, Long mentorId);
}
