package com.example.payload;


public class SimpleActorResponse {

    private long id;

    private String firstName;

    private String lastName;

    private Integer height;

    private Integer bornYear;

    public SimpleActorResponse() {
    }

    public SimpleActorResponse(long id, String firstName, String lastName, Integer height, Integer bornYear) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.height = height;
        this.bornYear = bornYear;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getBornYear() {
        return bornYear;
    }

    public void setBornYear(Integer bornYear) {
        this.bornYear = bornYear;
    }
}
