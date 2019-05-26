package com.example.parts.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Part {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Boolean isNeeded;
    private Integer quantity;

    public Part() {
    }

    public Part(String name, Boolean isNeeded, Integer quantity) {
        this.name = name;
        this.isNeeded = isNeeded;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getNeeded() {
        return isNeeded;
    }

    public void setNeeded(Boolean needed) {
        isNeeded = needed;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
