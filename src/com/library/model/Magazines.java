package com.library.model;

import java.time.LocalDate;

public class Magazines extends Book{
    public Magazines(String name, String author, double price, int edition, LocalDate dateOfPurchase){
        super(name,author,price,edition,dateOfPurchase);
    }
}
