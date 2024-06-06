package org.example;

import java.util.ArrayList;
import java.util.HashMap;

public class ShopService {
    private ProductRepo existingProducts;
    private OrderListRepo requestedOrder;
    private OrderListRepo placedOrder = new OrderListRepo(new ArrayList<>());

    private OrderMapRepo requestedOrderMap;
    private OrderMapRepo placedOrderMap = new OrderMapRepo(new HashMap<>());

    public ShopService(ProductRepo existingProducts, OrderListRepo requestedOrder) {
        this.existingProducts = existingProducts;
        this.requestedOrder = requestedOrder;
    }

    public ShopService(ProductRepo existingProducts, OrderMapRepo requestedOrderMap) {
        this.existingProducts = existingProducts;
        this.requestedOrderMap = requestedOrderMap;
    }

    public ProductRepo getExistingProducts() {
        return existingProducts;
    }

    public OrderListRepo getRequestedOrder() {
        return requestedOrder;
    }

    public OrderListRepo getPlacedOrder() {
        return placedOrder;
    }

    public OrderMapRepo getRequestedOrderMap() {
        return requestedOrderMap;
    }

    public OrderMapRepo getPlacedOrderMap() {
        return placedOrderMap;
    }

    OrderMapRepo placeOrder(Order order) {
        if (isProductAvailable(order)) {
            Order existingOrder = placedOrderMap.getOrderById(order.productId());
            if (existingOrder != null) {
                int actualNumber = existingOrder.number();
                double actualSum = existingOrder.sum();
                placedOrderMap.addOrder(new Order(order.productId(), actualNumber + order.number(), order.sum() + actualSum));
            } else {
                placedOrderMap.addOrder(order);
            }
        }
        return placedOrderMap;

    }

    boolean isProductAvailable(Order order) {
        Product productToCheck = existingProducts.getProductById(order.productId());
        if (productToCheck != null && productToCheck.availableQuantity() >= order.number()) {
            return true;
        }
        System.out.println("Product is actually not available");
        return false;

    }


}
