package com.example.webdemo.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tasks")
public class Team {

    @Id
    @Column(name = "teamno")
    private int teamno;
}
