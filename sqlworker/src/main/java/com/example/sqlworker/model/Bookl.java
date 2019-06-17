package com.example.sqlworker.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Bookl{

    @JsonProperty("method")
    private String method;

    @JsonProperty("isn")
    private String isn;

    @JsonProperty("title")
    private String title;

    @JsonProperty("publisher")
    private String publisher;

    @JsonProperty("authors")
    private String authors;

    @JsonProperty("published")
    private String published;

    public Bookl(String method, String isn, String title, String publisher, String authors, String published) {
        this.method = method;
        this.isn = isn;
        this.title = title;
        this.publisher = publisher;
        this.authors = authors;
        this.published = published;
    }

    public Bookl(String method) {
        this.method = method;
    }

    public Bookl() {
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getIsn() {
        return isn;
    }

    public void setIsn(String isn) {
        this.isn = isn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    @Override
    public String toString() {
        return "Bookl{" +
                "method='" + method + '\'' +
                ", isn='" + isn + '\'' +
                ", title='" + title + '\'' +
                ", publisher='" + publisher + '\'' +
                ", authors='" + authors + '\'' +
                ", published='" + published + '\'' +
                '}';
    }
}