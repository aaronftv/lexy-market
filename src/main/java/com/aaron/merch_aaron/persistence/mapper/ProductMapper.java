package com.aaron.merch_aaron.persistence.mapper;

import com.aaron.merch_aaron.domain.Product;
import com.aaron.merch_aaron.persistence.entity.ProductEnt;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {
    @Mappings({
            @Mapping(source = "productId", target = "productId"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "categoryId", target = "categoryId"),
            @Mapping(source = "salePrice", target = "price"),
            @Mapping(source = "stockQuantity", target = "stock"),
            @Mapping(source = "status", target = "active"),
            @Mapping(source = "category", target = "category")
    })
    Product toProduct(ProductEnt product);
    List<Product> toProducts(List<ProductEnt> products);

    @InheritInverseConfiguration
    @Mapping(target = "barCode", ignore = true)
    ProductEnt toProduct(Product product);
}
