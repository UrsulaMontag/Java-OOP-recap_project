package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderMapRepo implements OrderRepo {
    private Map<String, Order> orders;

    public OrderMapRepo(Map<String, Order> orders) {
        this.orders = orders;
    }

    @Override
    public List<Order> getAllOrders() {
        return new ArrayList<>(orders.values());
    }

    @Override
    public Order getOrderById(String id) {
        if (orders.containsKey(id)) {
            return orders.get(id);
        }
        System.out.println("No order for this product");
        return null;
    }

    @Override
    public void addOrder(Order order) {
        orders.put(order.productId(), order);
    }

    @Override
    public void removeOrder(String id) {
        orders.remove(id);
    }

    @Override
    public void deleteAllOrders() {
        orders.clear();
    }
}
