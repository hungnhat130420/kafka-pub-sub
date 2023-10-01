package com.kafka.producer.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafka.producer.entity.Commodity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CommodityProducer {
    private ObjectMapper objectMapper;

    private KafkaTemplate kafkaTemplate;

    @Autowired
    public CommodityProducer(ObjectMapper objectMapper, KafkaTemplate kafkaTemplate) {
        this.objectMapper = objectMapper;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Commodity commodity) {
        try {
            var message = objectMapper.writeValueAsString(commodity);
            kafkaTemplate.send("t-commodity", commodity.getName(), message);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public static void sendMessageStatic(String message) {
        System.out.println("Static message: " + message);
    }
}
