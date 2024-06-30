package com.example.demo.user;

import org.springframework.data.annotation.Id;

public class Admin {
    @Id
    private String Id;
    private String name;

    public Admin(String imdbId, String name) {
        this.Id = imdbId;
        this.name = name;
    }
}
