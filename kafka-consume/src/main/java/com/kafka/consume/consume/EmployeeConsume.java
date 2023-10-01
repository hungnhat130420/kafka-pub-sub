package com.kafka.consume.consume;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.consume.entity.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EmployeeConsume {

    private static final Logger LOG = LoggerFactory.getLogger(EmployeeConsume.class);

    private ObjectMapper objectMapper;

    private KafkaTemplate kafkaTemplate;

    @Autowired
    public EmployeeConsume(KafkaTemplate kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

//    @KafkaListener(topics = "t-employee")
//    public void receiveMessage(String message) throws JsonProcessingException, JsonMappingException {
//        var employeeJson = objectMapper.readValue(message, Employee.class);
//        LOG.info("Employee is {}", employeeJson.getBirthDate());
//    }
}
