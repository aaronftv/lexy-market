package com.aaron.merch_aaron.persistence;

import com.aaron.merch_aaron.domain.Product;
import com.aaron.merch_aaron.domain.repository.ProductRepository;
import com.aaron.merch_aaron.persistence.crud.ProductCrudRepository;
import com.aaron.merch_aaron.persistence.entity.ProductEnt;
import com.aaron.merch_aaron.persistence.mapper.ProductMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepositoryPers implements ProductRepository {
    private ProductCrudRepository productCrudRepository;
    private ProductMapper mapper;

    public List<Product> getAll() {
        List<ProductEnt> products = (List<ProductEnt>) productCrudRepository.findAll();
        return mapper.toProducts(products);
    }

    //Query Method
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<ProductEnt> products = productCrudRepository.findByCategoryIdOrderByNameAsc(categoryId);
        return Optional.of(mapper.toProducts(products));
    }
    //Native query Method
    public Optional<List<Product>> getByCategoryNative(int categoryId) {
        List<ProductEnt> products = productCrudRepository.findByCategoryIdNative(categoryId);
        return Optional.of(mapper.toProducts(products));
    }
    //Query Method
    public Optional<List<Product>> getLimitedProducts(int quantity) {
        Optional<List<ProductEnt>> products = productCrudRepository.findByStockQuantityLessThanAndStatus(quantity, true);
        return products.map(prods -> mapper.toProducts(prods));
    }

    public Optional<Product> getProduct(int productId) {
        return productCrudRepository.findById(productId).map(product -> mapper.toProduct(product));
    }

    public Product save(Product product) {
        ProductEnt productEnt = mapper.toProduct(product);
        return mapper.toProduct(productCrudRepository.save(productEnt));
    }

    public void delete(int productId) {
        productCrudRepository.deleteById(productId);
    }
}
