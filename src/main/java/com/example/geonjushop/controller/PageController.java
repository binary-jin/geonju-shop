package com.example.geonjushop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/geonju")
@Controller
public class PageController {

    @GetMapping( "/")
    public String main(){
        return "main";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

//    @GetMapping("/join")
//    public String join() {
//        return "join";
//    }

}
