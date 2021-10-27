package com.zhang.test.dao;

public class Earr {
    private String Name;
    private int Age;
    private String Sex;
    private String Phone;

    public Earr() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public Earr(String name, int age, String sex, String phone) {
        Name = name;
        Age = age;
        Sex = sex;
        Phone = phone;
    }

    @Override
    public String toString() {
        return "Earr{" +
                "Name='" + Name + '\'' +
                ", Age=" + Age +
                ", Sex='" + Sex + '\'' +
                ", Phone='" + Phone + '\'' +
                '}';
    }
}