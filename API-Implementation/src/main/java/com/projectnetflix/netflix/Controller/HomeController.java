package com.projectnetflix.netflix.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "Home Page!";
    }

    @GetMapping("/secure")
    public String secure(){
        return "You are Secure now!";
    }


}
