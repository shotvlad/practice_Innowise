package org.com.entity;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "cars")
@AttributeOverride(name = "id", column = @Column(name = "id"))
public class Car extends AbstractEntity {
    @Column(name = "model", nullable = false, length = 50)
    private String model;

    @Column(name = "price", nullable = false, length = 50)
    private Double price;

    @Column(name = "number", nullable = false, length = 50)
    private Long number;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "brandId", nullable = false)
    @JsonProperty("brandName")
    private Brand brand;

    public Car() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    @JsonGetter("brandName")
    public String getBrandName() {
        return brand.getName();
    }
}
