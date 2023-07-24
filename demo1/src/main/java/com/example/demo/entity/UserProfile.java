package com.example.demo.entity;

public class UserProfile {
    public Integer user_id;
    public String phonenumber;
    public String email;
    public String role;

    public Integer getUser_id(){
        return this.user_id;
    }

    public String getPhonenumber(){
        return this.phonenumber;
    }
    public String getEmail(){
        return this.email;
    }

    public String getRole(){
        return this.role;
    }

    public UserProfile(Integer User_id, String Phonenumber, String Email, String Role){
        this.user_id = User_id;
        this.phonenumber = Phonenumber;
        this.email = Email;
        this.role = Role;
    }
}
