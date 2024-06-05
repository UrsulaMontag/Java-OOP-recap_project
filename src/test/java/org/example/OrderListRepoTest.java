package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class OrderListRepoTest {
    Order testOrder1 = new Order("test-1", 1, 1 * 5.98);
    Order testOrder2 = new Order("test-2", 2, 2 * 3.98);
    Order testOrder3 = new Order("test-3", 3, 3 * 4.98);

    OrderListRepo testOrderRepo = new OrderListRepo(new ArrayList<>() {{
        add(testOrder1);
        add(testOrder2);
        add(testOrder3);
    }});

    @Test
    void getAllOrders_returnWholeListOfOrders() {
        int expectedSize = 3;
        assertEquals(expectedSize, testOrderRepo.getAllOrders().size());
    }

    @Test
    void getProductById_returnsNull_ifIdDoesNotExist() {
        assertNull(testOrderRepo.getOrderById("test-invalidId-2"));
    }

    @Test
    void getOrderById_returnsSingleOrder_ofGivenProductById() {
        Order expectedOrder = testOrder2;
        assertEquals(expectedOrder, testOrderRepo.getOrderById("test-2"));
    }

    @Test
    void addOrder_addsOrderToOrderRepo() {
        Order testOrder = new Order("test-9", 1, 3 * 2.98);
        testOrderRepo.addOrder(testOrder);
        assertEquals(testOrder, testOrderRepo.getOrderById("test-9"));
    }

//    @Test
//    void addOrder_increasesOrderQuantity_whenOrderOfProductAlreadyExistsInRepo() {
//        int sizeBefore = testOrderRepo.getAllOrders().size();
//        Order testOrder = new Order("test-2", 1, 3 * 3.98);
//        testOrderRepo.addOrder(testOrder);
//        System.out.println(testOrderRepo.getOrderById("test-2"));
//        assertEquals(testOrder, testOrderRepo.getOrderById("test-2"));
//    }

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