package org.example;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ShopServiceTest {
    Product testProduct1 = new Product("test-1", "test-product1", "test-category1", "test-description", 5.98, 550);
    Product testProduct2 = new Product("test-2", "test-product2", "test-category2", "test-description", 3.98, 10);
    Product testProduct3 = new Product("test-3", "test-product3", "test-category3", "test-description", 4.98, 400);

    Order testOrder1 = new Order("test-1", 1, 1 * 5.98);
    Order testOrder2 = new Order("test-2", 2, 2 * 3.98);
    Order testOrder3 = new Order("test-3", 3, 3 * 4.98);

    ProductRepo testExistingProducts = new ProductRepo(new ArrayList<>() {{
        add(testProduct1);
        add(testProduct2);
        add(testProduct3);
    }});
    OrderListRepo testRequestedOrder = new OrderListRepo(new ArrayList<>() {{
        add(testOrder1);
        add(testOrder2);
        add(testOrder3);
    }});

    private ShopService testShopService = new ShopService(testExistingProducts, testRequestedOrder);

    @Test
    void placeOrder_returnsOrderListRepo() {
        OrderListRepo expected = testShopService.placeOrder();
        assertNotNull(expected);
    }

    @Test
    void isProductAvailable_returnsTrue_whenProductIsAvailable() {
        assertTrue(testShopService.isProductAvailable(testOrder3));
        assertTrue(testShopService.isProductAvailable(new Order("test-2", 9, 9 * 3.98)));

    }

    @Test
    void isProductAvailable_returnsFalseAndPrintsMessage_whenProductIsNotAvailable() {
        assertFalse(testShopService.isProductAvailable(new Order("bad-product", 4, 7)));
        assertFalse(testShopService.isProductAvailable(new Order("test-2", 11, 11 * 3.98)));

    }
}