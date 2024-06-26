package com.example.webdemo.service.impl;

import com.example.webdemo.Models.User;
import com.example.webdemo.Repositories.UserRepository;
import com.example.webdemo.dto.UserDto;
import com.example.webdemo.mapper.UserMapper;
import com.example.webdemo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


//below tells Spring to create the spring Bean userImpl class
@Service
//why is the all arg constructor req??
@AllArgsConstructor
public class UserImpl implements UserService {


    private UserRepository userRepository;


    @Override
    public UserDto createUser(UserDto userdto) {

        User user = UserMapper.mapToUser(userdto);

        User savedUser = userRepository.save(user);

        return UserMapper.mapToUserDto(savedUser);
    }

    @Override
    public boolean verifyUser(UserDto userDto) {
        List<User> users = userRepository.findAll();
        for (User user : users) {
            if (user.getName().equals(userDto.getName()) && user.getPasswd().equals(userDto.getPasswd())) {
                return true; // Found matching username and password
            }
        }
        return false; // No matching username and password found
    }

    @Override
    public List<User> getAllUsersNative() {
        return userRepository.getAll();

    }

    @Override
    public List<User> searchUser(int id) {
        return userRepository.searchUserOnId(id);
    }

    @Override
    public User verifyUser2(String name, String passwd, int teamno) {
        return userRepository.verifyUser2(name, passwd, teamno);
    }


}
