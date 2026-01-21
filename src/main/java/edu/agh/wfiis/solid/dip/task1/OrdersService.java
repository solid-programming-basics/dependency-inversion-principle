package edu.agh.wfiis.solid.dip.task1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class OrdersService {
    private final OrdersRepository orderRepository;

    public OrdersService(String url, String username, String password) {
        orderRepository = new OrdersRepositoryImplementation(url, username, password);
    }

    public List<Order> getOrdersForCustomer(String customerId) {
     
        return orderRepository.getOrdersForCustomer(customerId);
    }
}

