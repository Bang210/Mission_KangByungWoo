package com.ll;

class Quotation {
    private int id;
    private String content;
    private String author;
    Quotation(int id, String content, String author) {
        this.id = id;
        this.content = content;
        this.author = author;
    }
    public int getId() {
        return id;
    }
    public String getContent() {
        return content;
    }
    public String getAuthor() {
        return author;
    }
}