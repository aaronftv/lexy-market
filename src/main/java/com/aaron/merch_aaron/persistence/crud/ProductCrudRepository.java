package com.aaron.merch_aaron.persistence.crud;

import com.aaron.merch_aaron.persistence.entity.ProductEnt;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductCrudRepository extends CrudRepository<ProductEnt, Integer> {

    List<ProductEnt> findByCategoryIdOrderByNameAsc(int categoryId);

    @Query(value = "SELECT * FROM productos WHERE id_categoria = ? ORDER BY name ASC", nativeQuery = true)
    List<ProductEnt> findByCategoryIdNative(int categoryId);

    Optional<List<ProductEnt>> findByStockQuantityLessThanAndStatus(int stockQuantity, boolean status);
}
