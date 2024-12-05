package com.vitech.Lab09_train.kafka;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.vitech.Lab09_train.Entity.Order;
import com.vitech.Lab09_train.Repository.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Component
public class OrderConsumer {
    private OrderRepository orderRepository;
    private ObjectMapper objectMapper;

    @KafkaListener(topics = "${spring.kafka.template.default-topic}", groupId = "order-consumer-group")
    public void consume(ConsumerRecord<String, String> record) throws IOException {
        String value = record.value();
        Order order = objectMapper.readValue(value, Order.class);

        order.setValidated(true);
        order.setValidationDate(LocalDate.now());

        orderRepository.save(order);
    }

}
