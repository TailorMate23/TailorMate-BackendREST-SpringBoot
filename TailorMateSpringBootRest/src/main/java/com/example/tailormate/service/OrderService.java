package com.example.tailormate.service;

import com.example.tailormate.model.Colors;
import com.example.tailormate.model.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();
    Order getOrderById(int id);
    Order saveOrder(Order order);
    Order updateOrder(Order order);
    void deleteOrder(int id);
}
