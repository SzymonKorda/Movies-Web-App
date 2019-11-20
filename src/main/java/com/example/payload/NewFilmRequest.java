package com.example.payload;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class NewFilmRequest {

    @NotBlank(message = "Title is mandatory")
    @Size(min = 3, max = 30)
    private String title;

    @NotBlank(message = "Description is mandatory")
    private String description;

    @NotNull(message = "Boxoffice is mandatory")
    private Integer boxoffice;

    @NotNull(message = "Duration is mandatory")
    private Integer duration;

    @NotNull(message = "Premiere year is mandatory")
    private Integer premiereYear;

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

    public Integer getPremiereYear() {
        return premiereYear;
    }

    public void setPremiereYear(Integer premiereYear) {
        this.premiereYear = premiereYear;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
