package com.backend_wordProcessor1Java.backend.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
@RequiredArgsConstructor
public class HomeController {
        @RequestMapping("/") // website root
        public String returnIndexHTML() {
                return "Hello World (index.html)";
        }
}
