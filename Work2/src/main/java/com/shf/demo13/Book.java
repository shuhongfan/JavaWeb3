package com.shf.demo13;

public class Book implements Comparable<Book>{
    private String name;
    private Double price;

    public Book() {
    }

    public Book(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Book o) {
        if (this.price>o.price){
            return 1;
        } else if (this.price<o.price){
            return - 1;
        } else {
            return 0;
        }
    }
}
