package com.library.model;
import com.library.enums.BookStatus;
public class Librarian extends Person{
    private String password;
    public Librarian(String name, String password){
        super(name);
        this.password=password;
    }

    @Override
    public void whoyouare() {
        System.out.println("Ben kütüphane görevlisiyim. Adım: " + getName());
    }


}
