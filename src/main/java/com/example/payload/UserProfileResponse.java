package com.example.payload;

import java.util.ArrayList;
import java.util.List;

public class UserProfileResponse {

    private Long id;

    private String name;

    private String username;

    private String email;

    private List<SimpleFilmResponse> userFilms = new ArrayList<>();

    public List<SimpleFilmResponse> getUserFilms() {
        return userFilms;
    }

    public void setUserFilms(List<SimpleFilmResponse> userFilms) {
        this.userFilms = userFilms;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
