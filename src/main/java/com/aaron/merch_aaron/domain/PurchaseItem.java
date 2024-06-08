package com.aaron.merch_aaron.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PurchaseItem {
    private int productId;
    private int quantity;
    private BigDecimal total;
    private boolean active;
}
