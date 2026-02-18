package com.alexjr.activemq.messaging;

import com.alexjr.activemq.model.Task;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class TaskConsumer {

    @JmsListener(destination = "queue.tasks")
    public void receive(Task task) {
        System.out.println("[CONSUMER] Task recebida: " + task.getId() + " - " + task.getTitle());
    }
}