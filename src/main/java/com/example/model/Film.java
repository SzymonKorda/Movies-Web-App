package com.example.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name =  "film")
public class Film {

    @Id
    @Column(name = "film_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "boxoffice")
    private Integer boxoffice;

    @Column(name = "length")
    private Integer length;

    @ManyToMany
    @JoinTable(
            name = "Film_Actor",
            joinColumns = { @JoinColumn(name = "film_id")},
            inverseJoinColumns = { @JoinColumn(name = "actor_id") }
    )
    private List<Actor> actors = new ArrayList<>();

    public Film() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }
}
