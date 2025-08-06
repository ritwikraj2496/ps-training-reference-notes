package com.ps.junittesting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Product Service Tests")
public class ProductServiceTest {

    private ProductService productService;

    @BeforeEach
    void setup() {
        productService = new ProductService();
        productService.addProduct(new Product("Laptop", 75000));
        productService.addProduct(new Product("Tablet", 80000));
    }

    @Nested
    @DisplayName("Add and Existence Tests")
    class AddandExistsProductTests {

        @Test
        @DisplayName("Should return true if it exists")
        void shouldReturnTrueIfProductExists() {
            assertTrue(productService.productExists("Laptop"));
        }

        @Test
        @DisplayName("Should return false if product does not exist")
        void shouldReturnFalseIfProductNotExists() {
            assertFalse(productService.productExists("Phone"));
        }
    }

    @Nested
    @DisplayName("Get Product Tests")
    class GetProductTests {

        @Test
        @DisplayName("Should return product when product exists")
        void shouldReturnProductIfExists() {
            Product product = productService.getProduct("Tablet");
            assertNotNull(product);
            assertEquals(80000, product.getPrice());
        }

        @Test
        @DisplayName("Should throw exception when product not found")
        void shouldThrowIfProductNotFound() {
            assertThrows(NoSuchElementException.class, () -> {
                productService.getProduct("Camera");
            });
        }
    }

    @Nested
    @DisplayName("Delete Product Tests")
    class DeleteProductTests {

        @Test
        @DisplayName("Should delete existing product successfully")
        void shouldDeleteProduct() {
            productService.deleteProduct("Laptop");
            assertFalse(productService.productExists("Laptop"));
        }

        @Test
        @DisplayName("Should throw exception when deleting non-existing product")
        void shouldThrowWhenDeletingUnknownProduct() {
            assertThrows(NoSuchElementException.class, () -> {
                productService.deleteProduct("Printer");
            });
        }
    }
}
