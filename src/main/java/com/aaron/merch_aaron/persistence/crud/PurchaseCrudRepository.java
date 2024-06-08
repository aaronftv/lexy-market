package com.aaron.merch_aaron.persistence.crud;

import com.aaron.merch_aaron.persistence.entity.PurchaseEnt;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PurchaseCrudRepository extends CrudRepository<PurchaseEnt, Integer> {
    Optional<List<PurchaseEnt>> findByClientId(String clientId);
}
