package com.moodsync.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.moodsync.service.TaskService;
import com.moodsync.model.Task;

@RestController
@RequestMapping("/tasks")
@CrossOrigin
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService s){this.service=s;}

    @PostMapping
    public Task add(@RequestBody Task t){
        return service.save(t);
    }

    @GetMapping("/{mood}")
    public List<Task> suggest(@PathVariable String mood){
        return service.suggest(mood);
    }
}
