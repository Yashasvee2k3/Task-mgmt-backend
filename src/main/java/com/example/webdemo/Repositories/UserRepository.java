package com.example.webdemo.Repositories;

import com.example.webdemo.Models.Task;
import com.example.webdemo.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {


    @Query(value = "select * from users", nativeQuery = true)
    List<User> getAll();


    @Query(value = "select * from users u where u.id = :id", nativeQuery = true)
    List<User> searchUserOnId(@Param("id") int id);


    @Query(value = "select * from users u where u.name = :name and u.passwd = :passwd and u.teamno = :teamno", nativeQuery = true)
    User verifyUser2(@Param("name") String name, @Param("passwd") String passwd, @Param("teamno") int teamno);



}