package com.mentors.dto;

import com.mentors.entity.Batch;
import com.mentors.entity.Course;
import com.mentors.entity.TrainingSession;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponseWithoutMentorObject {
    private TrainingSession training;
    private Batch batch;
    private Course course;

}
