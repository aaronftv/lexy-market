package com.aaron.merch_aaron.persistence;

import com.aaron.merch_aaron.domain.Purchase;
import com.aaron.merch_aaron.domain.repository.PurchaseRepository;
import com.aaron.merch_aaron.persistence.crud.PurchaseCrudRepository;
import com.aaron.merch_aaron.persistence.entity.PurchaseEnt;
import com.aaron.merch_aaron.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PurchaseRepositoryPers implements PurchaseRepository {
    @Autowired
    private PurchaseCrudRepository purchaseCrudRepository;
    @Autowired
    private PurchaseMapper mapper;

    @Override
    public List<Purchase> getAll() {
        return mapper.toPurchases((List<PurchaseEnt>) purchaseCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return purchaseCrudRepository.findByClientId(clientId)
                .map(purchases -> mapper.toPurchases(purchases));
    }

    @Override
    public Purchase save(Purchase purchase) {
        PurchaseEnt purchaseEnt = mapper.toPurchaseEnt(purchase);
        //Make sure all products are backwards associated to the PurchaseEnt, additional tags were added to attributes
        purchaseEnt.getProducts().forEach(product -> product.setPurchase(purchaseEnt));
        return mapper.toPurchase(purchaseCrudRepository.save(purchaseEnt));
    }
}
