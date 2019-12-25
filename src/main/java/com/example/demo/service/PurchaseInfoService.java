package com.example.demo.service;

import com.example.demo.domain.PurchaseInfo;
import com.example.demo.repo.PurchaseInfoRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseInfoService {

    private PurchaseInfoRepo purchaseInfoRepo;

    public PurchaseInfoService(PurchaseInfoRepo purchaseInfoRepo) {
        this.purchaseInfoRepo = purchaseInfoRepo;
    }

    public List<PurchaseInfo> findAll() {
        return purchaseInfoRepo.findAll();
    }

    public List<PurchaseInfo> findMostBuy() {
        return purchaseInfoRepo.findFirstByOrderByCountDesc();
    }

    public PurchaseInfo sumHalfYear() {
        return purchaseInfoRepo.sumHalfYear();
    }
    public PurchaseInfo mostBuy() {
        return purchaseInfoRepo.sumHalfYear();
    }

    public PurchaseInfo getOne(Long id) {
        return purchaseInfoRepo.getOne(id);
    }

    public PurchaseInfo save(PurchaseInfo purchaseInfo, Long id) {
        PurchaseInfo purchase = purchaseInfoRepo.getOne(id);
        purchase.setName(purchaseInfo.getName());
        purchase.setLastname(purchaseInfo.getLastname());
        purchase.setAge(purchaseInfo.getAge());
        purchase.setCount(purchaseInfo.getCount());
        purchase.setAmount(purchaseInfo.getAmount());
        return purchaseInfoRepo.save(purchase);

    }

    public void delete(PurchaseInfo purchaseInfo) {
        purchaseInfoRepo.delete(purchaseInfo);
    }

    public PurchaseInfo update(PurchaseInfo messageFromDb, PurchaseInfo message) {
        BeanUtils.copyProperties(message, messageFromDb);
        PurchaseInfo updatedMessage = purchaseInfoRepo.save(messageFromDb);
        return updatedMessage;
    }
}
