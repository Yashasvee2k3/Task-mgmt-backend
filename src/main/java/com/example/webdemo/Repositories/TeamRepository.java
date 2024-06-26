package com.example.webdemo.Repositories;

import com.example.webdemo.Models.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Integer> {
}
