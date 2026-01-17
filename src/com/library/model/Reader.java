package com.library.model;

import java.util.ArrayList;
import java.util.List;

public class Reader extends Person{
    private List<Book> borrowedBooks;
    private MemberRecord memberRecord;
    public Reader(String name, MemberRecord memberRecord){
        super(name);
        this.memberRecord=memberRecord;
        this.borrowedBooks= new ArrayList<>();
    }
    public void borrow_book(Book book){
        if(borrowedBooks.size()<5){
            borrowedBooks.add(book);
            System.out.println(book.getTitle()+" kitabı başarıyla ödünç alındı.");
        }else{
            System.out.println("En fazla 5 kitap ödünç alabilirsiniz.");
        }
    }
    public void return_book(Book book) {
        if (borrowedBooks.contains(book)) {
            borrowedBooks.remove(book);
            System.out.println("[Reader]: " + getName() + " kitabı elinden çıkardı: " + book.getTitle());
        }
    }
    public MemberRecord getMemberRecord() {
        return memberRecord;
    }
    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }
    @Override
    public void whoyouare(){
        System.out.println("Ben bir okuyucuyum, ismim: "+ getName());
    }
}
