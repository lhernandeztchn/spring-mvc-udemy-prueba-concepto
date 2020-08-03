package com.udemy.controller.views;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexViewController {

	@GetMapping("/index")
    public String showIndex(){
        return "index";
    }
}