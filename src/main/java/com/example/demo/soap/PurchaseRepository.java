package com.example.demo.soap;

import com.example.demo.domain.Purchase;
import com.example.demo.repo.PurchaseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Component
public class PurchaseRepository {
    private static final Map<String, Purchase> countries = new HashMap<>();


    private PurchaseRepo purchaseRepo;

    @Autowired
    public PurchaseRepository(PurchaseRepo purchaseRepo) {
        this.purchaseRepo = purchaseRepo;
    }

    @PostConstruct
    public void initData() {

        /*Set<Purchase> purchaseSet = new HashSet<Purchase>(){{
            add(new Purchase("Телевизор"));
            add(new Purchase("Смартфон"));
            add(new Purchase("Соковыжималка"));
            add(new Purchase("Наушники"));
            add(new Purchase("Клавиатура"));
        }};

        for (Purchase purchase : purchaseSet) {
            purchaseRepo.save(purchase);
        }*/


    }



}
