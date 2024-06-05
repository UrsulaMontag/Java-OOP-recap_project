package org.example;

import java.util.List;

public interface OrderRepo {
    List<Order> getAllOrders();

    Order getOrderById(String id);

    void addOrder(Order order);

    void removeOrder(String id);

    void deleteAllOrders();

}
