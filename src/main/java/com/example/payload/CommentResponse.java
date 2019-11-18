package com.example.payload;

import com.example.model.audit.DateAudit;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class CommentResponse {

    private long id;

    private String username;

    private String content;

    private String createdDate;

    public CommentResponse(long id, String username, String content, String createdDate) {
        this.id = id;
        this.username = username;
        this.content = content;
        this.createdDate = createdDate;
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

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
}
