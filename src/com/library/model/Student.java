package com.library.model;

public class Student extends MemberRecord{
    public Student(String memberId, String name, String address, String phoneNo){
        super(memberId,"Student",name,address,phoneNo);
    }
}
