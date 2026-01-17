package com.library.model;

import com.library.enums.BookStatus;

import java.time.LocalDate;
import java.util.UUID;

public class Book {
    private String bookID;
    private String author;
    private String name;
    private double price;
    private BookStatus status;
    private int edition;
    private LocalDate dateOfPurchase;

    public Book(String name,String author, double price, int edition, LocalDate dateOfPurchase){
        this.bookID= UUID.randomUUID().toString();
        this.name=name;
        this.author= author;
        this.price= price;
        this.edition=edition;
        this.dateOfPurchase=dateOfPurchase;
        this.status = BookStatus.AVAILABLE;
    }

    public String getTitle(){return name;}
    public String getAuthor(){return author;}
    public void updateStatus(BookStatus newStatus){this.status=newStatus;}
    public void  display(){
        System.out.println("ID: "+ bookID);
        System.out.println("Kitap: "+ name+ " Yazar: "+ author);
        System.out.println("Fiyat: " + price + " TL | Baskı: " + edition);
        System.out.println("Satın Alma Tarihi: " + dateOfPurchase);
        System.out.println("Durum: " + status);
    }
    public String getBookID(){return  bookID;}
    public String getName(){return name;}
    public void setName(String name){this.name=name;}
    public void setAuthor(String author){this.author=author;}
    public double getPrice(){return price;}
    public void setPrice(double price){this.price=price;}
    public BookStatus getStatus(){return status;}
    public int getEdition(){return edition;}
    public void setEdition(int edition){this.edition=edition;}
    public LocalDate getDateOfPurchase(){return dateOfPurchase;}
    public void setDateOfPurchase(LocalDate dateOfPurchase){this.dateOfPurchase= dateOfPurchase;}
}
