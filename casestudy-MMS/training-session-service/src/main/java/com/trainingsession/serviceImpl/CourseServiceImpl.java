//package com.trainingsession.serviceImpl;
//
//import com.trainingsession.entity.Course;
//import com.trainingsession.repo.CourseRepository;
//import com.trainingsession.service.CourseService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class CourseServiceImpl implements CourseService {
//
//    @Autowired
//    private CourseRepository courseRepository;
//
//    @Override
//    public Course createCourse(Course course) {
//        Course saveCourse = courseRepository.save(course);
//        return saveCourse;
//    }
//
//    @Override
//    public Course getCourseById(Long courseId) {
//        return courseRepository.findById(courseId).orElse(null);
//    }
//
//    @Override
//    public List<Course> getAllCourse() {
//        return courseRepository.findAll();
//    }
//}
