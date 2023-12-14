package com.trainingsession.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Duration;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    private Long courseId;
    private String courseName;
    private Duration courseDuration;
}
