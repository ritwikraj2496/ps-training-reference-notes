package com.ps.junittesting;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ProductService {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public boolean productExists(String productName) {
        return products.stream().anyMatch(p -> p.getName().equalsIgnoreCase(productName));
    }

    public Product getProduct(String productName) {
        return products.stream()
                .filter(p -> p.getName().equalsIgnoreCase(productName))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Product not found: " + productName));
    }

    public void deleteProduct(String productName) {
        Product product = getProduct(productName); // reuse existing method
        products.remove(product);
    }
}
