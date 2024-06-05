package org.example;

import java.util.List;
import java.util.Objects;

public class OrderListRepo {
    List<Order> orders;

    public OrderListRepo(List<Order> orders) {
        this.orders = orders;
    }

    List<Order> getAllOrders() {
        return orders;
    }

    int getIndex(String id) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).productId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    Order getOrderById(String id) {
        int index = getIndex(id);
        if (index != -1) {
            return orders.get(index);
        }
        System.out.println("No order for this product");
        return null;
    }

    void addOrder(Order order) {
        orders.add(order);
    }

    void removeOrder(String id) {
        orders.removeIf(product -> product.productId().equals(id));
    }

    void deleteAllOrders() {
        orders.clear();
    }

    @Override
    public String toString() {
        return "OrderListRepo{" +
                "orders=" + orders +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderListRepo that = (OrderListRepo) o;
        return Objects.equals(orders, that.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(orders);
    }
}
