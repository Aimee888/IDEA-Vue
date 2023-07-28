package com.example.demo.entity;

public class Role {
    public String name;
    public String sex;
    public Integer age;
    public String native_;
    public String hobby;

    public String getName(){
        return this.name;
    }

    public String getSex(){
        return this.sex;
    }

    public Integer getAge() {
        return this.age;
    }

    public String getNative_(){
        return this.native_;
    }

    public String getHobby() {
        return this.hobby;
    }

    public Role(String Name, String Sex, Integer Age, String Native_, String Hobby){
        this.name = Name;
        this.sex = Sex;
        this.age = Age;
        this.native_ = Native_;
        this.hobby = Hobby;
    }
}
