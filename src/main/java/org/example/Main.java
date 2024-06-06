package org.example;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {


    public static void main(String[] args) {
        Product product1 = new Product("test-1", "test-product1", "test-category1", "test-description", 5.98, 550);
        Product product2 = new Product("test-2", "test-product2", "test-category2", "test-description", 3.98, 10);
        Product product3 = new Product("test-3", "test-product3", "test-category3", "test-description", 4.98, 400);
        Product product5 = new Product("test-5", "test-product5", "test-5", "test-description", 4.98, 400);

        Order order1 = new Order("test-1", 1, 1 * 5.98);
        Order order2 = new Order("test-2", 2, 2 * 3.98);
        Order order3 = new Order("test-3", 3, 3 * 4.98);
        Order order4 = new Order("test-4", 4, 4 * 5.98);
        Order order5 = new Order("test-5", 5, 5 * 5.98);
        ProductRepo existingProducts = new ProductRepo(new ArrayList<>() {{
            add(product1);
            add(product2);
            add(product3);
        }});
        OrderMapRepo orderRepo = new OrderMapRepo(new HashMap<>() {{
            put(order1.productId(), order1);
            put(order2.productId(), order2);
            put(order3.productId(), order3);
        }});
        ShopService serviceMyShop = new ShopService(existingProducts, orderRepo);

        System.out.println("---------------------Requested Orders:---------------------------");
        System.out.println(serviceMyShop.getRequestedOrderMap());
        System.out.println("---------------------Search unavailable:---------------------------");
        System.out.println(serviceMyShop.isProductAvailable(order4));
        System.out.println("---------------------Place order:---------------------------");
        serviceMyShop.placeOrder(order1);
        System.out.println(serviceMyShop.getPlacedOrderMap());
        serviceMyShop.placeOrder(order2);
        System.out.println(serviceMyShop.getPlacedOrderMap());
        serviceMyShop.placeOrder(order3);
        System.out.println(serviceMyShop.getPlacedOrderMap());
        serviceMyShop.placeOrder(order4);
        System.out.println(serviceMyShop.getPlacedOrderMap());
        serviceMyShop.placeOrder(order5);
        System.out.println("---------------------Place existing order:---------------------------");
        Order order6 = new Order("test-3", 10, 10 * 5.98);
        serviceMyShop.placeOrder(order6);
        System.out.println(serviceMyShop.getPlacedOrderMap());
        System.out.println("---------------------Search available:---------------------------");
        System.out.println(serviceMyShop.isProductAvailable(order5));


    }


}