package com.library.model;

public class Faculty extends MemberRecord{
    public Faculty(String memberId, String name, String address, String phoneNo){
        super(memberId, "Faculty", name,address,phoneNo);
    }
}
