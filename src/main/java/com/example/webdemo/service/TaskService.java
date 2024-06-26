package com.example.webdemo.service;

import com.example.webdemo.Models.Task;
import com.example.webdemo.dto.TaskDto;

import java.util.List;

public interface TaskService {

    List<TaskDto> getAllTasks();
    boolean saveTasks(List<TaskDto> taskDtoList);

    List<Task> getAllTasksPerTeam(Long teamno);
    boolean saveTasksPerTeam(List<Task> tasks, Long teamno);

}
