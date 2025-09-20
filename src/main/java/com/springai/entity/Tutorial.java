package com.springai.entity;


public class Tutorial {

    private String title;
    private String content;
    private String createdYear;

    public Tutorial() {
    }

    public Tutorial(String title, String content, String createdYear) {
        this.title = title;
        this.content = content;
        this.createdYear = createdYear;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getCreatedYear() {
        return createdYear;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCreatedYear(String createdYear) {
        this.createdYear = createdYear;
    }
}
