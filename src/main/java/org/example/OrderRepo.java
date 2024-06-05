package org.example;

import java.util.List;

public interface OrderRepo {
    List<Order> getAllOrders();

    Order getOrderById();

    void addOrder();

    void removeOrder();

    void deleteAllOrders();

}
