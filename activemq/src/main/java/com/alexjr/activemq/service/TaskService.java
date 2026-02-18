package com.alexjr.activemq.service;

import java.util.UUID;

import com.alexjr.activemq.messaging.TaskPublisher;
import com.alexjr.activemq.model.Task;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private final TaskPublisher publisher;

    public TaskService(TaskPublisher publisher) {
        this.publisher = publisher;
    }

    public Task create(Task req, int delayMs) {
        Task task = new Task(
                UUID.randomUUID().toString(),
                req.getTitle(),
                req.getDescription()
        );

        publisher.publish(task, delayMs); 
        
        return task;
    }
}