package dev.kerimfettahoglu.secureapp1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/check")
public class CheckController {
    @GetMapping("/up")
    public String check() {
        return "Up";
    }
}
