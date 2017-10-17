package com.sergeeva.simpleSpringSecurityApp.controller;

import com.sergeeva.simpleSpringSecurityApp.domain.Course;
import com.sergeeva.simpleSpringSecurityApp.service.StudentService;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students/{studentId}/course")
    public List<Course> loadCoursesByStudent(@PathVariable String studentId) {
        return  studentService.findCourseByStudentId(studentId);
    }
}
