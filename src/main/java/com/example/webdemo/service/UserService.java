package com.example.webdemo.service;

import com.example.webdemo.Models.User;
import com.example.webdemo.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userdto);
    boolean verifyUser(UserDto userDto);
    List<User> getAllUsersNative();

    List<User> searchUser(int id);

    User verifyUser2(String name, String passwd, int teamno);
}
