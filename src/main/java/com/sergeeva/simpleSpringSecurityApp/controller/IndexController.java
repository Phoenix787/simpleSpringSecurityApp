package com.sergeeva.simpleSpringSecurityApp.controller;

import com.sergeeva.simpleSpringSecurityApp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RestController
public class IndexController {

    @RequestMapping("/")
    public ModelAndView index() {

        Map<String, String> map = new HashMap<>();
        map.put("name", "Xenia");

        return new ModelAndView("index", map);
    }

    @RequestMapping("/login")
    public ModelAndView getLogin(@RequestParam(value = "error", required = false) String error,
                           @RequestParam(value = "logout", required = false) String logout,
                           Model model){
        model.addAttribute("error", error != null);
        model.addAttribute("logout", logout != null);
        return new ModelAndView("login");

    }

}
