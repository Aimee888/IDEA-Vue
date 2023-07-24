package com.example.demo.entity;

public class User {
    public Integer user_num;
    public String user_account;
    public String user_password;

    public Integer getUser_num(){
        return this.user_num;
    }

    public String getUser_account(){
        return this.user_account;
    }

    public String getUser_password(){
        return this.user_password;
    }

    public User(Integer User_num, String User_account, String User_password){
        this.user_num = User_num;
        this.user_account = User_account;
        this.user_password = User_password;
    }
}
