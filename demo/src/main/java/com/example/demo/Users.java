package com.example.demo;

import jakarta.persistence.*;


@Entity
// @Table(name = "users")
public class Users {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int age;

    public Users() {}

    public Users(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
