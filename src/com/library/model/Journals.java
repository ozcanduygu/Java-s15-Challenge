package com.library.model;

import com.library.enums.BookStatus;

import java.time.LocalDate;

public class Journals extends Book{
    public Journals(String name, String author, double price, int edition, LocalDate dateOfPurchase){
        super(name,author,price,edition,dateOfPurchase);
    }
}
