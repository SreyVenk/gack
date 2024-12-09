package com.example.guacnroll.service;

import com.example.guacnroll.dto.OrderDTO;
import com.example.guacnroll.model.Order;
import com.example.guacnroll.model.User;
import com.example.guacnroll.model.FoodItem;
import com.example.guacnroll.repository.OrderRepository;
import com.example.guacnroll.repository.UserRepository;
import com.example.guacnroll.repository.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;


@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FoodItemRepository foodItemRepository;

    public Order createOrder(OrderDTO orderDTO) {
        User user = userRepository.findById(orderDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        FoodItem foodItem = foodItemRepository.findById(orderDTO.getFoodItemId())
                .orElseThrow(() -> new RuntimeException("Food item not found"));

        Order order = new Order();
        order.setUser(user);
        order.setFoodItem(foodItem);
        order.setOrderDate(LocalDateTime.now());
        order.setStatus("PENDING");
        order.setSpecialInstructions(orderDTO.getSpecialInstructions());
        order.setTotalAmount(foodItem.getPrice());

        return orderRepository.save(order);
    }

    public List<Order> getUserOrders(User user) {
        return orderRepository.findByUserOrderByOrderDateDesc(user);
    }
}