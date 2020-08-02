package com.udemy.controller.views;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Index {

	@GetMapping("/")
    public String showIndex(){
        return "index";
    }
}