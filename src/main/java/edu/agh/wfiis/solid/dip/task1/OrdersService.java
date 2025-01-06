package edu.agh.wfiis.solid.dip.task1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class OrdersService {
    private final String url;
    private final String username;
    private final String password;

    public OrdersService(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public List<Order> getOrdersForCustomer(String customerId) {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT id, name FROM orders WHERE customer_id = ?";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, customerId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                orders.add(new Order(id, name));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error fetching orders from database", e);
        }

        return orders;
    }
}

