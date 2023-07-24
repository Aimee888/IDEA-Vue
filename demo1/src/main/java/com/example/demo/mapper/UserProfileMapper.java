package com.example.demo.mapper;

import com.example.demo.entity.UserProfile;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserProfileMapper {
    @Select("select * from userprofile")
    List<UserProfile> getUserProfileList();
}
