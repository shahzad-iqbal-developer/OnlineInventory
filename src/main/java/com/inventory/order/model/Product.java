package com.inventory.order.model;


import javax.persistence.*;

@Entity
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

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
//        @OneToOne(fetch = FetchType.LAZY,
//                cascade =  CascadeType.ALL,
//                mappedBy = "product")
//        private OrderItem item;

    public Product() {

    }

    public Product(int id, String sku, String name, String long_name, String description, String tax_rate) {
        super();
        this.id = id;
        this.sku = sku;
        this.name = name;
        this.long_name = long_name;
        this.description = description;
        this.tax_rate = tax_rate;
        //this.item = item;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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