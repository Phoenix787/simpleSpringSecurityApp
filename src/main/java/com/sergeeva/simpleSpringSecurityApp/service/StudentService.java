package com.sergeeva.simpleSpringSecurityApp.service;

import com.google.common.collect.ImmutableList;
import com.sergeeva.simpleSpringSecurityApp.domain.Course;
import com.sergeeva.simpleSpringSecurityApp.domain.Student;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

//mock-class

@Service
public class StudentService {
    private List<Student> students = new ArrayList<>();

    @PostConstruct
    public void init(){
        Course course1 = Course.builder()
                .id("1")
                .name("Spring Boot")
                .description("10 lessons")
                .steps(ImmutableList.of("Intro", "First step", "Second Step")).build();
        Course course2 = Course.builder()
                .id("2")
                .name("Spring MVC")
                .description("30 lessons")
                .steps(ImmutableList.of("Intro", "First step", "Second Step")).build();

        Student student = Student.builder().id("1").name("Alex").description("REST")
                            .courses(ImmutableList.of(course1, course2)).build();
        students.add(student);
    }

    public Student findById(String id) {

        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }

        }
        return null;
    }

    public List<Course> findCourseByStudentId(String id) {
        Student student = findById(id);
        return student.getCourses();
    }

}
