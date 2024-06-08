package com.aaron.merch_aaron.persistence.mapper;

import com.aaron.merch_aaron.domain.PurchaseItem;
import com.aaron.merch_aaron.persistence.entity.PurchasesProductEnt;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface PurchaseItemMapper {
    @Mappings({
            @Mapping(source = "id.productId", target = "productId"),
            @Mapping(source = "quantity", target = "quantity"),
            //This Mapping below is not required because they have the same name
            @Mapping(source = "total", target = "total"),
            @Mapping(source = "status", target = "active")
    })
    PurchaseItem toPurchaseItem(PurchasesProductEnt purchaseProduct);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "id.purchaseId", ignore = true),
            @Mapping(target = "purchase", ignore = true),
            @Mapping(target = "product", ignore = true)
    })
    PurchasesProductEnt toPurchaseProduct(PurchaseItem purchaseItem);

}
