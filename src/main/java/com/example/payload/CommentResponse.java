package com.example.payload;

public class CommentResponse {

    private long id;

    private String username;

    private String content;

    public CommentResponse(long id, String username, String content) {
        this.id = id;
        this.username = username;
        this.content = content;
    }


    public CommentResponse() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
