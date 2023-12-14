package com.trainingsession.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Mentors {
    private Long mentorId;
    private String mentorName;
    private String mentorEmail;
    private String mentorDesignation;
    private String skillSet;
}
