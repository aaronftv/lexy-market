package com.aaron.merch_aaron.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class Purchase {
    private int purchaseId;
    private String clientId;
    private LocalDateTime date;
    private String paymentType;
    private String comment;
    private String status;
    private List<PurchaseItem> items;
}
