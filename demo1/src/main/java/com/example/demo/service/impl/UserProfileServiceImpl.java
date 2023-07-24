package com.example.demo.service.impl;


import com.example.demo.entity.UserProfile;
import com.example.demo.mapper.UserProfileMapper;
import com.example.demo.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserProfileServiceImpl implements UserProfileService {
    @Autowired
    private UserProfileMapper userprofileMapper;

    @Override
    public List<UserProfile> getUserProfileList() {
        try{
            List<UserProfile> userProfile= userprofileMapper.getUserProfileList();
            return userProfile;

        }catch (Exception e){
            //好像是 如果不throw的话，会报错。。。
            e.printStackTrace();
            throw e;
        }
    }
}
