package com.moodsync.service;

import org.springframework.stereotype.Service;
import java.util.*;
import com.moodsync.repository.TaskRepository;
import com.moodsync.model.Task;

@Service
public class TaskService {
    private final TaskRepository repo;

    public TaskService(TaskRepository repo){this.repo=repo;}

    public Task save(Task t){return repo.save(t);}

    public List<Task> suggest(String mood){
        List<Task> all=repo.findAll();
        if("TIRED".equals(mood)){
            return all.stream().limit(2).toList();
        }
        return all;
    }
}
