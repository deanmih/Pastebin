package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class newPageController {
    @GetMapping("/new")
    public String home() {
        return "index2";
    }
}
