package com.trainingsession.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "training-session")
public class TrainingSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sessionId;

    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    @Column(nullable = false)
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime startTime;

    @Column(nullable = false)
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime endTime;

    @Column(nullable = false)
    private Long mentorId;

    @Column(nullable = false)
    private Long courseId;

    @Column(nullable = false)
    private Long batchId;

    @Enumerated(EnumType.STRING)
    private TrainingStatus trainingStatus;

}
