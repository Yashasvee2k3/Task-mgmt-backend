package com.example.webdemo.mapper;

import com.example.webdemo.Models.User;
import com.example.webdemo.dto.UserDto;

public class UserMapper {

    public static UserDto mapToUserDto(User user){

        return new UserDto(user.getId(), user.getName(), user.getPasswd(), user.getTeamno());

    }

    public static User mapToUser(UserDto userdto){
        return new User(userdto.getId(), userdto.getName(), userdto.getPasswd(), userdto.getTeamno());
    }
}
