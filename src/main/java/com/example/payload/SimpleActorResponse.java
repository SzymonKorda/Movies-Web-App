package com.example.payload;


public class SimpleActorResponse {

    private long id;

    private String firstname;

    private String lastname;

    private Integer height;

    public SimpleActorResponse(long id, String firstname, String lastname, Integer height) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.height = height;
    }

    public SimpleActorResponse() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }
}
