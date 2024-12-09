package com.example.guacnroll.controller;

import com.example.guacnroll.dto.OrderDTO;
import com.example.guacnroll.model.Order;
import com.example.guacnroll.model.User;
import com.example.guacnroll.service.OrderService;
import com.example.guacnroll.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<?> createOrder(@RequestBody OrderDTO orderDTO) {
        try {
            Order order = orderService.createOrder(orderDTO);
            return ResponseEntity.ok().body(Map.of(
                    "success", true,
                    "orderId", order.getId(),
                    "message", "Order placed successfully!"
            ));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of(
                    "success", false,
                    "message", e.getMessage()
            ));
        }
    }

    @GetMapping("/history")
    public String orderHistory(Model model) {
        // For now, get first user (you'll want to get the logged-in user later)
        User user = userService.getFirstUser();
        List<Order> orders = orderService.getUserOrders(user);
        model.addAttribute("orders", orders);
        return "order-history";
    }
}