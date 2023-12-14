package com.mentors.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "mentors")
public class Mentors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mentorId;
    @Column(nullable = false)
    private String mentorName;
    @Column(nullable = false)
    private String mentorEmail;
    @Column(nullable = false)
    private String mentorPassword;
    @Column(nullable = false)
    private String mentorDesignation;
    @Column(nullable = false)
    private String skillSet;
//    private Long sessionId;
    @Enumerated(EnumType.STRING)
    private MentorStatus status;
    private int numberOfAssignedTrainings;

    @PreUpdate
    public void updateStatusBasedOnTrainings() {
        if (numberOfAssignedTrainings > 3) {
            this.status = MentorStatus.OCCUPIED;
        } else {
            this.status = MentorStatus.AVAILABLE;
        }
    }



}
