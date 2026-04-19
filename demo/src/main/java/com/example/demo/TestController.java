package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class TestController {
    private final UserRepository repo;

    public TestController(UserRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/init")
    public String init() {
        repo.save(new Users("hiro", 24));
        repo.save(new Users("taro", 30));
        repo.save(new Users("jiro", 28));
        return "initialized!";
    }

    @GetMapping("/users")
    public List<Users> getUsers() {
        return repo.findAll();
        
    }

   @GetMapping("/")
   public String hello() {
       return "Hello hogetarou!";  
   }  
}
