package com.library.model;

import java.util.ArrayList;
import java.util.List;

public class Author extends Person{
    private List<Book> books;
    public Author(String name){
        super(name);
        this.books=new ArrayList<>();
    }
    @Override
    public void whoyouare(){
        System.out.println("Ben bir yazarım, ismim: "+ getName());
    }
    public void newBook(Book book){
        books.add(book);
    }
    public void show_book() {
        System.out.println(getName() + " isimli yazarın kitapları:");
        if (books.isEmpty()) {
            System.out.println("Henüz kayıtlı kitap bulunmamaktadır.");
        } else {
            // Burada öğrendiğimiz .stream() yapısını kullanabiliriz!
            books.forEach(book -> System.out.println("- " + book.getTitle()));
        }
    }
}
