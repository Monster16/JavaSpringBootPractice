//package com.trainingsession.controller;
//
//import com.trainingsession.entity.Course;
//import com.trainingsession.service.CourseService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("api/course")
//public class CourseController {
//
//    @Autowired
//    private CourseService courseService;
//
//    @PostMapping("/create")
//    public ResponseEntity<Object> createCourse(@RequestBody Course course){
//        Course saveCourse = courseService.createCourse(course);
//        return new ResponseEntity<>(saveCourse, HttpStatus.CREATED);
//    }
//
//    @GetMapping("{id}")
//    public ResponseEntity<Object> getCourseById(@PathVariable("id") Long courseId ){
//        Course course = courseService.getCourseById(courseId);
//        return new ResponseEntity<>(course, HttpStatus.OK);
//    }
//
//    @GetMapping("/all")
//    public ResponseEntity<Object> getAllCourse(){
//        List<Course> allCourse = courseService.getAllCourse();
//        return new ResponseEntity<>(allCourse, HttpStatus.OK);
//    }
//
//
//}
