package com.mentors.repo;

import com.mentors.entity.Mentors;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MentorRepository extends JpaRepository<Mentors, Long> {

    Optional<Mentors> findByMentorEmail(String mentorEmail);
}
