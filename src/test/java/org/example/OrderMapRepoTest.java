package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class OrderMapRepoTest {
    Order testOrder1 = new Order("test-1", 1, 1 * 5.98);
    Order testOrder2 = new Order("test-2", 2, 2 * 3.98);
    Order testOrder3 = new Order("test-3", 3, 3 * 4.98);

    OrderMapRepo testOrderRepo = new OrderMapRepo(new HashMap<>() {{
        put(testOrder1.productId(), testOrder1);
        put(testOrder2.productId(), testOrder2);
        put(testOrder3.productId(), testOrder3);
    }});

    @Test
    void getAllOrders() {
        int expectedSize = 3;
        assertEquals(expectedSize, testOrderRepo.getAllOrders().size());
    }

    @Test
    void getOrderById_returnsNull_ifIdDoesNotExist() {
        assertNull(testOrderRepo.getOrderById("test-invalidId-2"));
    }

    @Test
    void getOrderById_returnsSingleOrder_ofGivenProductById() {
        Order expectedOrder = testOrder2;
        assertEquals(expectedOrder, testOrderRepo.getOrderById("test-2"));
    }

    @Test
    void _addsOrderToOrderRepo() {
        Order testOrder = new Order("test-9", 1, 3 * 2.98);
        testOrderRepo.addOrder(testOrder);
        assertEquals(testOrder, testOrderRepo.getOrderById("test-9"));
    }

    @Test
    void removeOrder_removesOrderFromOrderRepo() {
        testOrderRepo.removeOrder("test-2");
        assertNull(testOrderRepo.getOrderById("test-2"));
    }

    @Test
    void deleteAllOrders_clearsTheOrderRepo() {
        testOrderRepo.deleteAllOrders();
        assertEquals(0, testOrderRepo.getAllOrders().size());
    }
}