package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepoTest {
    Product testProduct1 = new Product("test-1", "test-product1", "test-category1", "test-description", 5.98);
    Product testProduct2 = new Product("test-2", "test-product2", "test-category2", "test-description", 3.98);
    Product testProduct3 = new Product("test-3", "test-product3", "test-category3", "test-description", 4.98);

    ProductRepo testProductRepo = new ProductRepo(new ArrayList<>() {{
        add(testProduct1);
        add(testProduct2);
        add(testProduct3);
    }});


    @Test
    void getAllProducts_returnsWholeListOfProducts() {
        int expectedSize = 3;
        List<Product> products = testProductRepo.getAllProducts();
        assertEquals(expectedSize, products.size());
    }

    @Test
    void getIndex_returnsIndexOfProduct_byGivenId() {
        int expectedIndex = 1;
        assertEquals(expectedIndex, testProductRepo.getIndex("test-2"));
    }

    @Test
    void getProductById_returnsOneSingleProduct_correspondingToGivenId() {
        Product expected = testProduct2;
        assertEquals(expected, testProductRepo.getProductById("test-2"));
    }

    @Test
    void getProductById_returnsError_ifIdDoesNotExist() {
        assertNull(testProductRepo.getProductById("test-invalidId-2"));
    }

    @Test
    void addProduct_addsProductToProductRepo() {
        Product testProduct = new Product("test-4", "test-product4", "test-category4", "test-description", 5.98);
        testProductRepo.addProduct(testProduct);
        assertEquals(testProduct, testProductRepo.getProductById("test-4"));
    }

    @Test
    void removeProduct_deletesProductFromProductRepo() {
        testProductRepo.removeProduct("test-2");
        assertNull(testProductRepo.getProductById("test-2"));
    }
}