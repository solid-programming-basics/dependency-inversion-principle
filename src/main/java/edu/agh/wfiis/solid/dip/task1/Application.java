package edu.agh.wfiis.solid.dip.task1;

import org.h2.tools.RunScript;

import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

class Application {
    public static void main(String[] args)  {
        String url = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1";
        String username = "sa";
        String password = "";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            RunScript.execute(connection, new InputStreamReader(
                    Application.class.getClassLoader().getResourceAsStream("schema.sql")
            ));
        } catch (SQLException e) {
            System.err.println("Cannot initialize database:"+ e.getMessage());
        }

        OrdersService service = new OrdersService(url, username, password);
        List<Order> orders = service.getOrdersForCustomer("C123");
        for (Order order: orders) {
            System.out.println("Order ID: " + order.id() + ", Order name: " + order.name());
        }
    }
}
