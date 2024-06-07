package com.aaron.merch_aaron.domain.repository;

import com.aaron.merch_aaron.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> getAll();
    Optional<List<Product>> getByCategory(int categoryId);
    Optional<List<Product>> getLimitedProducts(int quantity);
    Optional<Product> getProduct(int productId);
    Product save(Product product);
    void delete(int product);
}
