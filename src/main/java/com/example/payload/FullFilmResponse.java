package com.example.payload;

import com.example.model.Actor;

import java.util.ArrayList;
import java.util.List;

public class FullFilmResponse {

    private String title;

    private Integer boxoffice;

    private Integer duration;

    private List<SimpleActorResponse> actors = new ArrayList<>();

    public List<SimpleActorResponse> getActors() {
        return actors;
    }

    public void setActors(List<SimpleActorResponse> actors) {
        this.actors = actors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getBoxoffice() {
        return boxoffice;
    }

    public void setBoxoffice(Integer boxoffice) {
        this.boxoffice = boxoffice;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}
