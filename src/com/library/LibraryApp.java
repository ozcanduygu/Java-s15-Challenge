package com.library;

import com.library.model.*;
import com.library.service.*;
import com.library.enums.BookStatus;
import com.library.service.Librarian;

import java.time.LocalDate;

public class LibraryApp {
    public static void main(String[] args) {
        Librarian librarian = new Librarian("Aslı Yılmaz", "secret123");

        // 2. Kütüphaneyi kuruyoruz ve kütüphaneciyi atıyoruz
        Library myLibrary = new Library(librarian);

        // 3. Kütüphaneye kitaplar ekliyoruz (new_book metodu)
        Book book1 = new StudyBooks("Java 101", "Deitel", 150.0,32, LocalDate.now());
        Book book2 = new Magazines("Bilim Teknik", "Tübitak", 25.0, 2, LocalDate.now());
        Book book3= new StudyBooks("Calculus 101", "Birisi", 840,20, LocalDate.now());
        Book book4= new Magazines("Science", "Öteki", 700, 34, LocalDate.now());

        myLibrary.add_book(book1);
        myLibrary.add_book(book2);
        myLibrary.add_book(book3);
        myLibrary.add_book(book4);

        // 4. Bir öğrenci ve onun üyelik kaydını oluşturuyoruz
        // (Student, MemberRecord'dan türüyor)
        MemberRecord studentRecord = new Student("S123", "Ahmet Demir", "İstanbul", "555-0000");
        Reader reader = new Reader("Ahmet Demir", studentRecord);

        // 5. Kütüphane envanterini gösteriyoruz
        myLibrary.show_book();

        System.out.println("\n--- İŞLEM: KİTAP ÖDÜNÇ VERME ---");
        // 6. Kitap ödünç verme (lend_book -> librarian.issue_book)
        myLibrary.lend_book(book1, reader);

        // Okuyucunun üzerindeki kitapları kontrol edelim
        System.out.println("Okuyucunun elindeki kitap sayısı: " + reader.getMemberRecord().getNoBooksIssued());

        System.out.println("\n--- İŞLEM: KİTAP İADE ETME ---");
        // 7. Kitap iade alma (take_back_book -> reader.return_book + dec_book_issued)
        myLibrary.take_back_book(book1, reader);

        // Durumu kontrol edelim
        System.out.println("İade sonrası kitap sayısı: " + reader.getMemberRecord().getNoBooksIssued());
        System.out.println("Kitabın son durumu: " + book1.getStatus());

        System.out.println("\n--- İŞLEM: CEZA HESAPLAMA ---");
        // 8. Ceza hesapla ve fatura kes
        double fine = librarian.calculate_fine(5); // 5 gün gecikmiş olsun
        librarian.create_bill(studentRecord, fine);
    }
}