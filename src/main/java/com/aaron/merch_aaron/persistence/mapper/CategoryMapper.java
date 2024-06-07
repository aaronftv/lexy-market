package com.aaron.merch_aaron.persistence.mapper;

import com.aaron.merch_aaron.persistence.entity.CategoryEnt;
import com.aaron.merch_aaron.domain.Category;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mappings({
            @Mapping(source = "categoryId", target = "categoryId"),
            @Mapping(source = "description", target = "category"),
            @Mapping(source = "status", target = "active")
    })
    Category toCategory(CategoryEnt category);

    @InheritInverseConfiguration
    @Mapping(target = "products", ignore = true)
    CategoryEnt toCategory(Category category);

}
