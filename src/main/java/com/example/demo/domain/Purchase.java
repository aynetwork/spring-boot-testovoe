package com.example.demo.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="purchase")
public class Purchase implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    private String name;

    public Purchase() {
    }

    public Purchase(String name) {

        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
