package com.kafka.producer.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.producer.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EmployeeProducer {

    private ObjectMapper objectMapper;

    private KafkaTemplate kafkaTemplate;

    @Autowired
    public EmployeeProducer(KafkaTemplate kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    public void sendMessage(Employee employee) {
        try {
            var employeeJson = objectMapper.writeValueAsString(employee);
            kafkaTemplate.send("t-employee", employeeJson);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }


}
