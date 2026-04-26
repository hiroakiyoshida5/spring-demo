package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class FormController {
        @GetMapping("form")
        public String form(){
            return "form";
        }

        @PostMapping("/form")
        public String result(@RequestParam String name, Model model){
            model.addAttribute("name", name);
            return "result";
        }
}
