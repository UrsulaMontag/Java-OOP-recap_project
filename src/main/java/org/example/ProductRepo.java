package org.example;

import java.util.List;
import java.util.Objects;

public class ProductRepo {
    private List<Product> products;

    public ProductRepo(List<Product> products) {
        this.products = products;
    }

    int getIndex(String id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).id().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    List<Product> getAllProducts() {
        return products;
    }

    Product getProductById(String id) {
        int index = getIndex(id);
        if (index != -1) {
            return products.get(index);
        }
        System.out.println("Product not found");
        return null;
    }

    void addProduct(Product product) {
        products.add(product);
    }

    void removeProduct(String id) {
        products.removeIf(product -> product.id().equals(id));
    }


}
