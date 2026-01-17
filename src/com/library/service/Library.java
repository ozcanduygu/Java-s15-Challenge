package com.library.service;

import com.library.model.Book;
import com.library.model.Reader;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<Reader> readers;

    private Librarian librarian;

    public Library(Librarian librarian){
        this.books=new ArrayList<>();
        this.readers= new ArrayList<>();
        this.librarian= librarian;
    }
    public void add_book(Book book){
        if(book!=null){
            books.add(book);
            System.out.println("[Sistem]: '" + book.getTitle() + "' kütüphane envanterine eklendi.");
        }
    }
    public void show_book() {
        System.out.println("--- Kütüphane Listesi ---");
        for (Book b : books) {
            System.out.println(b.getTitle());
        }
    }
    // ID'ye göre kitap silme
    public void remove_book(String bookId) {
        books.removeIf(b -> b.getBookID() == bookId);
        System.out.println(bookId + " ID'li kitap silindi.");
    }

    // Yazara göre listeleme
    public void list_by_author(String author) {
        System.out.println("--- " + author + " Kitapları ---");
        for (Book b : books) {
            if (b.getAuthor().equalsIgnoreCase(author)) {
                System.out.println(b.getTitle());
            }
        }
    }

    // Kategoriye (Türe) göre listeleme
    public void list_by_category(String category) {
        System.out.println("--- " + category + " Kategorisi ---");
        for (Book b : books) {
            if (b.getClass().getSimpleName().equalsIgnoreCase(category)) {
                System.out.println(b.getTitle());
            }
        }
    }
    public void take_back_book(Book book, Reader reader) {
        System.out.println("[Library] Kitap iade alınıyor: " + book.getTitle());
        reader.return_book(book); // Reader listesinden çıkarır
        reader.getMemberRecord().dec_book_issued(); // Üyenin üzerindeki sayıyı azaltır
        book.updateStatus(com.library.enums.BookStatus.AVAILABLE); // Kitabı boşa çıkarır
    }
    public void lend_book(Book book, Reader reader) {
        System.out.println("\n[Sistem] Ödünç verme talebi alındı: " + book.getTitle());

        // 1. Librarian üzerinden işlemi onayla ve gerçekleştir
        // (Librarian sınıfındaki issue_book metodunu tetikler)
        librarian.issue_book(book, reader.getMemberRecord());

        // 2. Eğer kütüphaneci onay verdiyse (kitap ödünç alındıysa),
        // reader'ın elindeki listeye de ekleyelim.
        if (book.getStatus() == com.library.enums.BookStatus.BORROWED) {
            reader.borrow_book(book);
        }
    }

}
