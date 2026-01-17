package com.library.model;

import java.time.LocalDate;

public class StudyBooks extends Book{
    public StudyBooks(String name, String author, double price, int edition, LocalDate dateOfPurchase){
        super(name,author,price,edition,dateOfPurchase);
    }
}
