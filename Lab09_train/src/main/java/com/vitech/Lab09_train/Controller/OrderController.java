package com.vitech.Lab09_train.Controller;


import com.vitech.Lab09_train.Entity.Order;
import com.vitech.Lab09_train.kafka.OrderProducer;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/orders")
@RestController
public class OrderController {


    private  OrderProducer orderProducer;

    @PostMapping
    public ResponseEntity<String> createOrder(@RequestBody Order order){
        try{
            orderProducer.sendOrder(order);
            return ResponseEntity.ok("Order fue enviada a kafka");

        }catch (IOException e){
            return ResponseEntity.status(500).body("Error al envair la order a kafka");

        }

    }


}
