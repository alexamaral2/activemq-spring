package com.alexjr.activemq.messaging;

import com.alexjr.activemq.model.Task;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import org.apache.activemq.ScheduledMessage;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import org.apache.activemq.ScheduledMessage;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class TaskPublisher {

    private final JmsTemplate jmsTemplate;

    public TaskPublisher(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void publish(Task task) {
        publish(task, 0);
    }

    public void publish(Task task, long delayMs) {

        jmsTemplate.convertAndSend("queue.tasks", task, message -> {
            message.setLongProperty(
                ScheduledMessage.AMQ_SCHEDULED_DELAY,
                delayMs
            );
            return message;
        });
    }
}