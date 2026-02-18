package com.alexjr.activemq.controller;

import com.alexjr.activemq.model.Task;
import com.alexjr.activemq.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Task> create(@RequestBody Task request) {

        int delayMs = 30000;

        Task created = service.create(request, delayMs);
        return ResponseEntity.ok(created);
    }
}