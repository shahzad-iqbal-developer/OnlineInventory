package com.inventory.order.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.sql.Timestamp;

@Entity
@Table(name = "order_detail")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long order_detail_id;

//

    @Column(name = "item_status")
    private Integer itemStatus;

    @Column(name = "item_total_amount")
    private Double itemTotalAmount;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "item_price")
    private Double itemPrice;

    @Column(name = "item_tax_amount")
    private Double taxAmount;

    @Column(name = "discount_type")
    private Integer discountType;

    @Column(name = "discount_code")
    private String discountCode;

    @Column(name = "discount_amount")
    private Double discountAmount;

    @Column(name = "item_comment")
    private String itemComment;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_date")
    private Timestamp createDate;

    @Column(name = "updated_by")
    private Integer updatedBy;

    @Column(name = "last_updated")
    private Timestamp lastUpdate;


    @ManyToOne
    @JoinColumn(name = "order_id" ,nullable=false)
    Order order;

    @JsonIgnoreProperties({"orderHistory","orderDetails"})
    @ManyToOne
    @JoinColumn(name = "item_id" ,nullable=false)
    OrderItem item;

    public OrderDetail() {
    }

    public OrderDetail(Long id, Integer itemStatus, Double itemTotalAmount, Integer quantity, Double itemPrice, Double taxAmount, Integer discountType, String discountCode, Double discountAmount, String itemComment, String createdBy, Timestamp createDate, Integer updatedBy, Timestamp lastUpdate, Order order, OrderItem item) {
        this.order_detail_id = id;
        this.itemStatus = itemStatus;
        this.itemTotalAmount = itemTotalAmount;
        this.quantity = quantity;
        this.itemPrice = itemPrice;
        this.taxAmount = taxAmount;
        this.discountType = discountType;
        this.discountCode = discountCode;
        this.discountAmount = discountAmount;
        this.itemComment = itemComment;
        this.createdBy = createdBy;
        this.createDate = createDate;
        this.updatedBy = updatedBy;
        this.lastUpdate = lastUpdate;
        this.order = order;
        this.item = item;
    }

    public Long getId() {
        return order_detail_id;
    }

    public void setId(Long id) {
        this.order_detail_id = id;
    }

    public Integer getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(Integer itemStatus) {
        this.itemStatus = itemStatus;
    }

    public Double getItemTotalAmount() {
        return itemTotalAmount;
    }

    public void setItemTotalAmount(Double itemTotalAmount) {
        this.itemTotalAmount = itemTotalAmount;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(Double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public Integer getDiscountType() {
        return discountType;
    }

    public void setDiscountType(Integer discountType) {
        this.discountType = discountType;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public Double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public String getItemComment() {
        return itemComment;
    }

    public void setItemComment(String itemComment) {
        this.itemComment = itemComment;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public OrderItem getItem() {
        return item;
    }

    public void setItem(OrderItem item) {
        this.item = item;
    }
}
