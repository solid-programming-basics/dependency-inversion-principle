package edu.agh.wfiis.solid.dip.task1;

import org.h2.tools.RunScript;

import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

class OrdersRepositoryImplementation implements OrdersRepository {

    String url = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1";
    String username = "sa";
    String password = "";
    
    public OrdersRepositoryImplementation(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            
            RunScript.execute(connection, new InputStreamReader(
                    Application.class.getClassLoader().getResourceAsStream("schema.sql")
            ));
        } catch (Exception e) {
            System.err.println("Cannot initialize database:"+ e.getMessage());
        }
    }
    
    @Override
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
             System.err.println("Cannot initialize database:"+ e.getMessage());
        }

        return orders;
    }
}