package com.example.payload;

import javax.validation.constraints.NotBlank;

public class NewCommentRequest {

    @NotBlank
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
