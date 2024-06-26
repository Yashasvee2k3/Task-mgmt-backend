package com.example.webdemo.Controller;

import com.example.webdemo.Models.User;
import com.example.webdemo.Repositories.UserRepository;
import com.example.webdemo.dto.UserDto;
import com.example.webdemo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

//import com.example.webdemo.Models.User;
//import com.example.webdemo.Repositories.UserRepository;
//import com.example.webdemo.dto.UserDto;
//import lombok.AllArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;

//import net.javaguides.springboot.exception.ResourceNotFoundException;
//import net.javaguides.springboot.model.Employee;
//import net.javaguides.springboot.repository.EmployeeRepository;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
@AllArgsConstructor     //???
public class UserController {

//    @Autowired    ????
    private UserRepository userRepository;
    private UserService userService;

    @GetMapping("/getAllUsers")
    public ResponseEntity<Iterable<User>> getAllUsers() {
        Iterable<User> userIterable = userRepository.findAll();
        System.out.println("Printing all users:");
        userIterable.forEach(user -> System.out.println(user));
        return new ResponseEntity<>(userIterable, HttpStatus.CREATED);
    }

    @PostMapping("/createUser")
    public ResponseEntity<UserDto> creatingUser(@RequestBody UserDto userDto){
        UserDto savedUser = userService.createUser(userDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @PostMapping("/verifyUser")
    public ResponseEntity<Boolean> verifyingUser(@RequestBody UserDto userDto){
        boolean response = userService.verifyUser(userDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

//    trying out native SQL queries
    @GetMapping("/getAllUsersNative")
    public ResponseEntity<List<User>> getAllUsersUsingNativeQuery(){
        List<User> resp = userService.getAllUsersNative();
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }


    @GetMapping("/searchUsersNative")
    public ResponseEntity<List<User>> searchUsersOnIdUsingNativeQuery(@RequestBody Map<String,Integer> reqbod){
        List<User> resp = userService.searchUser(reqbod.get("id"));
        return  new ResponseEntity<>(resp, HttpStatus.OK);
    }


    @PostMapping("/verifyUser2")
    public ResponseEntity<Boolean> verifyingUserLatest(@RequestBody UserDto userDto){
        User response = null;
        response = userService.verifyUser2(userDto.getName(), userDto.getPasswd(), userDto.getTeamno());
        if (response == null)
            return new ResponseEntity<>(false, HttpStatus.OK);
        else
            return new ResponseEntity<>(true, HttpStatus.OK);
    }


}
