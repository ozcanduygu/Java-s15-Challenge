package com.library.model;

import java.time.LocalDate;

public abstract class MemberRecord { // Abstract yaptık çünkü Student/Faculty buradan türeyecek
    private String memberId;
    private String type;
    private LocalDate dateOfMembership;
    private int noBooksIssued;
    private int maxBookLimit = 5;
    private String name;
    private String address;
    private String phoneNo;

    public MemberRecord(String memberId, String type, String name, String address, String phoneNo){
        this.memberId = memberId;
        this.type = type;
        this.name = name;
        this.address = address;
        this.phoneNo = phoneNo;
        this.dateOfMembership = LocalDate.now();
        this.noBooksIssued = 0;
    }

    // 1. inc_book_issued: Kitap ödünç alındığında sayıyı ARTIRIR (Increment)
    public void inc_book_issued() {
        if (noBooksIssued < maxBookLimit) {
            noBooksIssued++; // Önceki kodda burada hata vardı, doğrusu ++
        } else {
            System.out.println("Hata: Maksimum kitap limitine ulaşıldı!");
        }
    }

    // 2. dec_book_issued: Kitap iade edildiğinde sayıyı AZALTIR (Decrement)
    // Library sınıfındaki take_back_book metodunun aradığı metot budur!
    public void dec_book_issued() {
        if (noBooksIssued > 0) {
            noBooksIssued--;
        }
    }

    public void get_member(){
        System.out.println("Üye: " + name + " [ID: " + memberId + "] - Tip: " + type);
    }

    public void pay_bill() {
        System.out.println(name + " için ödeme işlemleri tamamlandı.");
    }

    // Getterlar
    public String getMemberId() { return memberId; }
    public String getName() { return name; }
    public int getNoBooksIssued() { return noBooksIssued; }
    public int getMaxBookLimit() { return maxBookLimit; }
}