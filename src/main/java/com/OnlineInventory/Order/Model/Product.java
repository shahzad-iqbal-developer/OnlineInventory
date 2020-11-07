package com.OnlineInventory.Order.Model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int product_id;

    @Column(name = "sku")
    private String sku;
    @Column(name = "name")
    private String name;
    @Column(name = "long_name")
    private String long_name;
    @Column(name = "description")
    private String description;
    @Column(name = "tax_rate")
    private String tax_rate;

//	@JsonIgnoreProperties("product")
//    @OneToOne(mappedBy = "product")
//    OrderItem item;

    public Product() {

    }

    public Product(int product_id, String sku, String name, String long_name, String description, String tax_rate) {
        super();
        this.product_id = product_id;
        this.sku = sku;
        this.name = name;
        this.long_name = long_name;
        this.description = description;
        this.tax_rate = tax_rate;
        //this.item = item;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLong_name() {
        return long_name;
    }

    public void setLong_name(String long_name) {
        this.long_name = long_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTax_rate() {
        return tax_rate;
    }

    public void setTax_rate(String tax_rate) {
        this.tax_rate = tax_rate;
    }
}