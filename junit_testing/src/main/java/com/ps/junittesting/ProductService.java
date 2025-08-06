package com.ps.junittesting;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ProductService {

    // creating an arraylist
    private List<Product> products = new ArrayList<>();

    // adding new products to my arraylist
    public void addProduct(Product product) {
        products.add(product);
    }

    // whether the product exists or not
    public boolean productExists(String productName) {
        return products.stream().anyMatch(p -> p.getName().equalsIgnoreCase(productName));
    }

    // to get the specific product
    public Product getProduct(String productName) {
        return products.stream()
                .filter(p -> p.getName().equalsIgnoreCase(productName))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Product not found: " + productName));
    }

    // to delete the product
    public void deleteProduct(String productName) {
        Product product = getProduct(productName); // reuse existing method
        products.remove(product);
    }
}
