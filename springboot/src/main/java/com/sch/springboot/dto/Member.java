package com.sch.springboot.dto;

public class Member {
    //필드
    private  String name;
    private  int age;
    private  String address;

    //생성자
    public Member(){}
    //매소드


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
