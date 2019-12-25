package com.example.demo.repo;

import com.example.demo.domain.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepo extends JpaRepository<Purchase, Long> {
    Purchase findByName(String name);
}
