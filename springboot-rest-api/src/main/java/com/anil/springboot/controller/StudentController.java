package com.anil.springboot.controller;

import com.anil.springboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    // http://localhost:8080/student/student
    @GetMapping("student")
    public ResponseEntity<Student> getStudent(){
        Student student = new Student(
                1,
                "Anil",
                "Singh"
        );
//        return new ResponseEntity<>(student, HttpStatus.OK);
//        return ResponseEntity.ok(student);
        return ResponseEntity.ok().header("custom-header", "Anil")
                .body(student);
    }
    // http://localhost:8080/student/students
    @GetMapping("students")
    public ResponseEntity<List<Student>> getStudents(){
        List<Student> list = new ArrayList<>();
        list.add(new Student(1,"Anil","Singh"));
        list.add(new Student(2,"Amit","Singh"));
        list.add(new Student(3,"Tushar","Singh"));
        list.add(new Student(4,"Gaurav","Singh"));
        return ResponseEntity.ok(list);
    }

    // Spring boot rest api with path variable
    // {id} - URI template variable
    // http://localhost:8080/student/1
    @GetMapping("{id}/{first-name}/{last-name}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable("first-name") String studentFirstName,
                                       @PathVariable("last-name") String StudentLastName
    ){
//        return new Student(studentId,studentFirstName,StudentLastName);
        return ResponseEntity.ok(new Student(studentId,studentFirstName,StudentLastName));
    }


    // Spring boot rest api with Request Param
    // http://localhost:8080/student/query?id=1&firstName=Anil&lastName=Singh
    @GetMapping("query")
    public ResponseEntity<Student> studentRequestParam(@RequestParam int id
    ,@RequestParam String firstName
    ,@RequestParam String lastName){
        return ResponseEntity.ok(new Student(id,firstName,lastName));
    }

    // Spring boot Rest API that handles Http Post Request
    // @PostMapping and @RequestBody
    // http://localhost:8080/student/create
    @PostMapping("create")
//    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> creatStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    // Spring boot rest api that handles put request
    // @PutMapping and @RequestBody
    // http://localhost:8080/student/update/1
    @PutMapping("update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") int studentId, @RequestBody Student student){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return ResponseEntity.ok(student);
    }

    // Spring boot rest api that handles delete request
    // @DeleteMapping
    // http://localhost:8080/student/delete/1
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId){
        System.out.println(studentId);
        return ResponseEntity.ok("Student Deleted Successfully") ;
    }

}
