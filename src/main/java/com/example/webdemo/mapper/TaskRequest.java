package com.example.webdemo.mapper;

import com.example.webdemo.Models.Task;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskRequest {
    private int teamno;
    private List<Task> tasks;
}
