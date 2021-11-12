package com.shf.demo10;

import java.util.Date;

public class Book {
    private String id;
    private String name;
    private String author;
    private String publisher;
    private Date publicationDate;
    private Double price;

    public Book() {
    }

    public Book(String id, String name, String author, String publisher, Date publicationDate, Double price) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.publicationDate = publicationDate;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", publicationDate=" + publicationDate +
                ", price=" + price +
                '}';
    }
}
