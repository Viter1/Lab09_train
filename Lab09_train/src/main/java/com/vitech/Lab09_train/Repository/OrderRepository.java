package com.vitech.Lab09_train.Repository;

import com.vitech.Lab09_train.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
