package com.library.service;

import com.library.model.MemberRecord;
import com.library.model.Book;
import com.library.enums.BookStatus;

public class Librarian {
    private String name;
    private String password;

    public Librarian(String name, String password){
        this.name=name;
        this.password=password;
    }
    public void search_book(String title){
        System.out.println(title + " kütüphanede aranıyor...");
    }
    public boolean verify_member(MemberRecord member) {
        if (member != null) {
            System.out.println("Üye doğrulandı: " + member.getName());
            return true;
        }
        System.out.println("Hata: Üye kaydı bulunamadı!");
        return false;
    }

    public void issue_book(Book book, MemberRecord member) {
        // Önce üyeyi doğrula, sonra kitap durumuna ve limitine bak
        if (verify_member(member) && book.getStatus() == BookStatus.AVAILABLE) {
            if (member.getNoBooksIssued() < member.getMaxBookLimit()) {
                book.updateStatus(BookStatus.BORROWED);
                member.inc_book_issued();
                System.out.println("Kitap başarıyla verildi: " + book.getTitle());
            } else {
                System.out.println("Hata: Üyenin kitap limiti dolu!");
            }
        } else {
            System.out.println("Hata: Kitap müsait değil veya üye geçersiz.");
        }
    }

    public double calculate_fine(int daysLate) {
        double fineAmount = daysLate * 2.0; // Örnek: Günlük 2 birim ceza
        System.out.println(daysLate + " gün gecikme için hesaplanan ceza: " + fineAmount);
        return fineAmount;
    }
    public void create_bill(MemberRecord member, double amount) {
        if (amount > 0) {
            System.out.println("--- FATURA ---");
            System.out.println("Üye: " + member.getName());
            System.out.println("Toplam Borç: " + amount);
            System.out.println("---------------");
        }
    }

    public String getName(){return name;}
    public void setName(String name){this.name=name;}

}
