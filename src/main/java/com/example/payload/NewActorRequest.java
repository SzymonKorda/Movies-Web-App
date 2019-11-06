package com.example.payload;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NewActorRequest {

    @NotBlank(message = "First name is mandatory")
    private String firstname;

    @NotBlank(message = "Last name is mandatory")
    private String lastname;

    @NotNull(message = "Height name is mandatory")
    private Integer height;

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
