package com.inventory.order.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "payment_detail")
public class PaymentDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long payment_id;


    @ManyToOne
    @JoinColumn(name = "order_id" ,nullable=false)
    Order order;

    @Column(name = "payment_type")
    Integer paymentType;

    @Column(name = "card_number")
    String cardNumber;

    @Column(name = "card_expiry")
    String cardExpiry;

    @Column(name = "card_first_name")
    String cardFirstName;

    @Column(name = "card_last_name")
    String cardLastName;

    @Column(name = "bank_name")
    String bankName;

    @Column(name = "account_number")
    String accountNumber;

    @Column(name = "ifsc_code")
    String ifscCode;

    @Column(name = "order_total_amount")
    Double orderTotalAmount;

    @Column(name = "created_by")
    Integer createdBy;

    @Column(name = "created_date")
    Timestamp createdDate;

    @Column(name = "updated_by")
    Integer updatedBy;

    @Column(name = "last_updated")
    Timestamp lastUpdated;

    public PaymentDetails(Long id, Order order, Integer paymentType, String cardNumber, String cardExpiry, String cardFirstName, String cardLastName, String bankName, String accountNumber, String ifscCode, Double orderTotalAmount, Integer createdBy, Timestamp createdDate, Integer updatedBy, Timestamp lastUpdated) {
        this.payment_id = id;
        this.order = order;
        this.paymentType = paymentType;
        this.cardNumber = cardNumber;
        this.cardExpiry = cardExpiry;
        this.cardFirstName = cardFirstName;
        this.cardLastName = cardLastName;
        this.bankName = bankName;
        this.accountNumber = accountNumber;
        this.ifscCode = ifscCode;
        this.orderTotalAmount = orderTotalAmount;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.updatedBy = updatedBy;
        this.lastUpdated = lastUpdated;
    }

    public PaymentDetails() {
    }

    public Long getId() {
        return payment_id;
    }

    public void setId(Long id) {
        this.payment_id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardExpiry() {
        return cardExpiry;
    }

    public void setCardExpiry(String cardExpiry) {
        this.cardExpiry = cardExpiry;
    }

    public String getCardFirstName() {
        return cardFirstName;
    }

    public void setCardFirstName(String cardFirstName) {
        this.cardFirstName = cardFirstName;
    }

    public String getCardLastName() {
        return cardLastName;
    }

    public void setCardLastName(String cardLastName) {
        this.cardLastName = cardLastName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public Double getOrderTotalAmount() {
        return orderTotalAmount;
    }

    public void setOrderTotalAmount(Double orderTotalAmount) {
        this.orderTotalAmount = orderTotalAmount;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
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
}
