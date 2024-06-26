package com.example.webdemo.mapper;

import com.example.webdemo.Models.Task;
import com.example.webdemo.dto.TaskDto;

public class TaskMapper {
    public static TaskDto maptoTasksDto(Task task){

        return new TaskDto(task.getId(), task.getTitle(), task.getStatus(), task.getDescription(), task.getDuedate(), task.getAssignees(), task.getTeamno());
    }

    public static Task maptoTask(TaskDto taskDto){
        return new Task(taskDto.getId(), taskDto.getTitle(), taskDto.getStatus(), taskDto.getDescription(), taskDto.getDuedate(), taskDto.getAssignees(), taskDto.getTeamno());
    }
}
