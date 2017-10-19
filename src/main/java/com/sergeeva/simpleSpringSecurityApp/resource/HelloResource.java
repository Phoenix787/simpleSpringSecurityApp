package com.sergeeva.simpleSpringSecurityApp.resource;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/hello")
public class HelloResource {

    @GetMapping("/all")
    public String hello() {
        return "Hello Youtube";
    }

//    @PreAuthorize("hasRole('ADMIN')")
//    @GetMapping("/secured/all")
//    public String secureHello(){
//        return "Secured Hello";
//    }

   // @GetMapping("/secured/all/login")
    public String getLogin(@RequestParam(value = "error", required = false) String error,
                           @RequestParam(value = "logout", required = false) String logout,
                           Model model){
        model.addAttribute("error", error!=null);
        model.addAttribute("logout", logout!=null);
        return "login";

    }
}
