package com.example.demo.domain.dto;

import com.example.demo.domain.Purchase;
import com.example.demo.domain.PurchaseInfo;

public class InfoDto {
    private PurchaseInfo purchaseInfo;
    private Long sumer;

    public InfoDto(Long sumer) {
        this.sumer = sumer;
    }

    public PurchaseInfo getPurchase_id() {
        return purchaseInfo;
    }

    public void setPurchase_id(PurchaseInfo purchase_id) {
        this.purchaseInfo = purchase_id;
    }

    public Long getSumer() {
        return sumer;
    }

    public void setSumer(Long sumer) {
        this.sumer = sumer;
    }
}
