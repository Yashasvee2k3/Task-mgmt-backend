package com.example.webdemo.Models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tasks")
public class Task {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "status")
    private String status;

    @Column(name = "description")
    private String description;

    @Column(name = "duedate")
    private Date duedate;

    @Column(name = "assignees")
    private String assignees;

    @Column(name = "teamno")
    private int teamno;

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", status='" + status + '\'' +
                ", description='" + description + '\'' +
                ", duedate='" + duedate + '\'' +
                ", assignees='" + assignees + '\'' +
                ", teamno='" + teamno + '\'' +
                '}';
    }
}
