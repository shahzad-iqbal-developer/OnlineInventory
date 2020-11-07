package com.OnlineInventory.Order.Model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name="item")
public class OrderItem
{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;

    @Column(name = "name")
    private  String name;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "sku")
    private String sku;

    @Column(name = "busy_item_code")
    private Long busyItemCode;

    @Column(name = "long_name")
    private String longName;

    @Column(name = "description")
    private String description;

    @Column(name = "quantity")
    private  Integer quantity;

    @Column(name = "price")
    private Double price;

    @Column(name = "item_color")
    private String itemColor;

    @Column(name = "item_size")
    private String itemSize;

    @Column(name = "updated_by")
    private Integer updatedBy;

    @Column(name = "last_updated")
    private Timestamp lastUpdated;

    @Column(name = "tax_rate")
    private Double taxRate;

    @JsonIgnoreProperties("item")
    @OneToMany(mappedBy = "item")
    List<OrderDetail> orderDetails;

    @JsonIgnoreProperties("item")    
    @OneToMany(mappedBy = "item")
    List<OrderHistory> orderHistory;

    @JsonIgnoreProperties("product")
    @OneToOne
    @JoinColumn(name = "product_id" ,nullable=false)
    Product product;

    public OrderItem( String name, Integer productId, String sku, Long busyItemCode, String longName,
                     String description, Integer quantity, Double price,
                     String itemColor, String itemSize, Integer updatedBy,
                     Timestamp lastUpdated, List<OrderDetail> orderDetails, List<OrderHistory> orderHistory,Double taxRate,Product product
    ) {

        this.name = name;
        this.productId = productId;
        this.sku = sku;
        this.busyItemCode = busyItemCode;
        this.longName = longName;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.itemColor = itemColor;
        this.itemSize = itemSize;
        this.updatedBy = updatedBy;
        this.lastUpdated = lastUpdated;
        this.orderDetails = orderDetails;
        this.orderHistory = orderHistory;
        this.taxRate=taxRate;

        this.product = product;
    }

    public OrderItem() {
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Long getBusyItemCode() {
        return busyItemCode;
    }

    public void setBusyItemCode(Long busyItemCode) {
        this.busyItemCode = busyItemCode;
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getItemColor() {
        return itemColor;
    }

    public void setItemColor(String itemColor) {
        this.itemColor = itemColor;
    }

    public String getItemSize() {
        return itemSize;
    }

    public void setItemSize(String itemSize) {
        this.itemSize = itemSize;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Timestamp getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Timestamp lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public List<OrderHistory> getOrderHistory() {
        return orderHistory;
    }

    public void setOrderHistory(List<OrderHistory> orderHistory) {
        this.orderHistory = orderHistory;
    }

    public Double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Double taxRate) {
        this.taxRate = taxRate;
    }
}

