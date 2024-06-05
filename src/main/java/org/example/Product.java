package org.example;

public record Product(String id, String name, String category, String description, double price,
                      int availableQuantity) {
}
