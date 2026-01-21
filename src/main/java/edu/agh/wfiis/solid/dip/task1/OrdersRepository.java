package edu.agh.wfiis.solid.dip.task1;

import org.h2.tools.RunScript;

import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

interface OrdersRepository {
    List<Order> getOrdersForCustomer(String customerId);
   
}
