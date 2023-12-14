package com.trainingsession.dto;

import com.trainingsession.entity.Batch;
import com.trainingsession.entity.Course;
import com.trainingsession.entity.Mentors;
import com.trainingsession.entity.TrainingSession;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {

    private TrainingSession training;
    private Batch batch;
    private Mentors mentor;
    private Course course;

}

