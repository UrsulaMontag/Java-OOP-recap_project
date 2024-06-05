package org.example;

import java.util.ArrayList;

public class ShopService {
    private ProductRepo existingProducts;
    private OrderListRepo requestedOrder;
    private OrderListRepo placedOrder = new OrderListRepo(new ArrayList<>());

    public ShopService(ProductRepo existingProducts, OrderListRepo requestedOrder) {
        this.existingProducts = existingProducts;
        this.requestedOrder = requestedOrder;
    }

    OrderListRepo placeOrder() {
        return placedOrder;

    }

    boolean isProductAvailable(Order order) {
        Product productToCheck = existingProducts.getProductById(order.productId());
        if (productToCheck != null && productToCheck.availableQuantity() >= order.number()) {
            return true;
        }
        System.out.println("Product is actually not available");
        return false;

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
}
