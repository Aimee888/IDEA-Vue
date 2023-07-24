package com.example.demo.entity;

import java.io.Serializable;

public class UserProfileVo implements Serializable {
    private User user;
    private  UserProfile userProfile;

    public User getUser(){
        return this.user;
    }

    public UserProfile getUserProfile(){
        return this.userProfile;
    }
    public UserProfileVo(User user_obj, UserProfile userprofile_obj){
        this.user = user_obj;
        this.userProfile = userprofile_obj;
    }
}
