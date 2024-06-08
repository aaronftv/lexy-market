package com.aaron.merch_aaron.persistence.mapper;

import com.aaron.merch_aaron.domain.Purchase;
import com.aaron.merch_aaron.persistence.entity.PurchaseEnt;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PurchaseItemMapper.class})
public interface PurchaseMapper {
    @Mappings({
            //All of these below are not required because they have same name
            @Mapping(source ="purchaseId", target = "purchaseId"),
            @Mapping(source ="clientId", target = "clientId"),
            @Mapping(source ="date", target = "date"),
            @Mapping(source ="paymentType", target = "paymentType"),
            @Mapping(source ="comment", target = "comment"),
            @Mapping(source ="status", target = "status"),
            @Mapping(source ="products", target = "items"),
    })
    Purchase toPurchase(PurchaseEnt purchase);
    List<Purchase> toPurchases(List<PurchaseEnt> purchases);

    @InheritInverseConfiguration
    @Mapping(target = "costumer", ignore = true)
    PurchaseEnt toPurchaseEnt(Purchase purchase);
}
