package com.example.webdemo.Controller;


import com.example.webdemo.Models.Task;
import com.example.webdemo.dto.TaskDto;
import com.example.webdemo.mapper.TaskRequest;
import com.example.webdemo.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
@AllArgsConstructor
public class TaskController {

    private TaskService taskService;


    @GetMapping("/getAllTasks")
    public ResponseEntity<List<TaskDto>> getAllTasks(){
        List<TaskDto> response = taskService.getAllTasks();
        System.out.println(response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/saveAllTasks")
    public ResponseEntity<Boolean> saveAllTasks(@RequestBody List<TaskDto> taskDtoList){
        boolean response = taskService.saveTasks(taskDtoList);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @GetMapping("/getTeamTasks")
    public ResponseEntity<List<Task>> getTasksBasedOnTeam(@RequestParam("teamno") Long teamno){
        List<Task> response = taskService.getAllTasksPerTeam(teamno);
        return  new ResponseEntity<>(response, HttpStatus.OK);
    }

//    @PostMapping("/saveTeamTasks")
//    public ResponseEntity<Boolean> saveTasksBasedOnTeam(@RequestBody TaskRequest taskRequest){
//        boolean response = taskService.saveTasksPerTeam(taskRequest.getTasks(), taskRequest.getTeamno());
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }


    @PostMapping("/saveTeamTasks")
    public ResponseEntity<Boolean> saveTasksBasedOnTeam(@RequestParam("teamno") Long teamno, @RequestBody List<Task> tasks){
            System.out.println(teamno);
            boolean response = taskService.saveTasksPerTeam(tasks, teamno);
            return new ResponseEntity<>(response, HttpStatus.OK);
    }

}

