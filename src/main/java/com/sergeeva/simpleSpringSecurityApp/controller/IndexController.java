package com.sergeeva.simpleSpringSecurityApp.controller;

import com.sergeeva.simpleSpringSecurityApp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RestController
public class IndexController {
    @Autowired
    StudentService studentService;

    @RequestMapping("/")
    public ModelAndView index() {

        Map<String, String> map = new HashMap<>();
        map.put("name", "Xenia");

        return new ModelAndView("index", map);
    }
}
