package com.example.demo.user;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "MovieBooking")

public class Movie {
    @Id
    private String imdbId;
    private String name;
    private String Location;
    private String Screen;
    private String Theatre;

    public Movie(String imdbId, String name, String location, String screen, String Theatre) {
        this.imdbId = imdbId;
        this.name = name;
        this.Location = location;
        this.Screen = screen;
        this.Theatre = Theatre;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getScreen() {
        return Screen;
    }

    public void setScreen(String screen) {
        Screen = screen;
    }

    public String getTheatre() {
        return Theatre;
    }

    public void setTheatre(String theatre) {
        Theatre = theatre;
    }


}
