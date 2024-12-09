package com.example.guacnroll.repository;

import com.example.guacnroll.model.Order;
import com.example.guacnroll.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUserOrderByOrderDateDesc(User user);
}
