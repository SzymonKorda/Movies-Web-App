package com.example.payload;

import java.util.List;

public class SimpleFilmResponse {

    private Long id;

    private String title;

    private Integer premiereYear;

    private Integer duration;

    public SimpleFilmResponse() {
    }

    public SimpleFilmResponse(Long id, String title, Integer premiereYear, Integer duration) {
        this.id = id;
        this.title = title;
        this.premiereYear = premiereYear;
        this.duration = duration;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPremiereYear() {
        return premiereYear;
    }

    public void setPremiereYear(Integer premiereYear) {
        this.premiereYear = premiereYear;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}
