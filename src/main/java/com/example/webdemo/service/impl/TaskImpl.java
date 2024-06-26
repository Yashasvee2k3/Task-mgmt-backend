package com.example.webdemo.service.impl;

import com.example.webdemo.Models.Task;
import com.example.webdemo.Repositories.TaskRepository;
import com.example.webdemo.dto.TaskDto;
import com.example.webdemo.mapper.TaskMapper;
import com.example.webdemo.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class TaskImpl implements TaskService {


    private TaskRepository taskRepository;

    @Override
    public List<TaskDto> getAllTasks() {
        // Fetch all Task entities
        List<Task> tasks = taskRepository.findAll();

        // Convert Task entities to TaskDto objects
        return tasks.stream()
                .map(TaskMapper::maptoTasksDto)
                .collect(Collectors.toList());
    }



    @Override
    public boolean saveTasks(List<TaskDto> taskDtoList) {
        List<Task> tasks = taskDtoList.stream()
                .map(TaskMapper::maptoTask)
                .collect(Collectors.toList());

        try {
            // Delete all existing records in the database
            taskRepository.deleteAll();

            // Save the new list of Task objects
            taskRepository.saveAll(tasks);

            return true; // Indicate successful save operation
        } catch (Exception e) {
            // Handle exception, log error, etc.
            e.printStackTrace();
            return false; // Indicate failure in save operation
        }
    }

    @Override
    public List<Task> getAllTasksPerTeam(Long teamno) {
        return taskRepository.getTasksUsingTeamNo(teamno);
    }

    @Transactional
    @Override
    public boolean saveTasksPerTeam(List<Task> tasks, Long teamno) {
            try {
                taskRepository.deleteTasksUsingTeamNo(teamno);
                taskRepository.saveAll(tasks);
                return true;
            }
            catch (Error e){
                return false;
            }
    }
}
