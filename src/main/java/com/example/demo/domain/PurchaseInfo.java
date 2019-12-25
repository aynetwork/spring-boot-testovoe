package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name="purchaseInfo")
public class PurchaseInfo implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    private String name;
    private String lastname;
    @Min(value = 0L, message = "The value must be positive")
    private Long age;
    @Min(value = 0L, message = "The value must be positive")
    private Long count;
    @Min(value = 0L, message = "The value must be positive")
    private Double amount;

    @Column(updatable = false)
    private LocalDateTime creationDate;

    @ManyToOne
    @JoinColumn(name = "purchase_id")
    private Purchase purchase;

    public PurchaseInfo() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }


    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }


}
