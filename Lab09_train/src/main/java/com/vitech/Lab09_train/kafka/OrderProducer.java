package com.vitech.Lab09_train.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vitech.Lab09_train.Entity.Order;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
public class OrderProducer {

    private  KafkaTemplate<String,String> kafkaTemplate;
    private  ObjectMapper objectMapper;

    public void sendOrder(Order order) throws JsonProcessingException{
        String orderJson = objectMapper.writeValueAsString(order);
        kafkaTemplate.sendDefault(orderJson);


    }

}
