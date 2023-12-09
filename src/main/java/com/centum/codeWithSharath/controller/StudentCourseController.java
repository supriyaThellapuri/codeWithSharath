package com.centum.codeWithSharath.controller;

import com.centum.codeWithSharath.entity.Course;
import com.centum.codeWithSharath.entity.Student;
import com.centum.codeWithSharath.repository.CourseRepository;
import com.centum.codeWithSharath.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/codewithsharath")
public class StudentCourseController {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;



    @PostMapping("/enrollnow")
    public Student saveStudentWithCourse(@RequestBody Student student)
    {
      return studentRepository.save(student);
    }
    @GetMapping("/getall")
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }
    @GetMapping("/get/{studentId}")
    public Student findStudent(@PathVariable Long studentId){

        return studentRepository.findById(studentId).orElse(null);
    }
    @GetMapping("/serach/{price}")
    public List<Course> findByPrice(@PathVariable double price){

        return courseRepository.findByFeeLessThan(price);
    }
    @GetMapping("/find/{name}")
    public List<Student>findstudentsbyName(@PathVariable String name){

        return studentRepository.findByName(name);
    }
//    @GetMapping("/enrollmentcount/{courseName}")
//    public int getEnrollmentCount(@PathVariable String title) {
//        return courseRepository.countEnrolledStudentsByCourseName(title);
//    }




}
