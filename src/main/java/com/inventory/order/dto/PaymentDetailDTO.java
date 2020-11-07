package com.inventory.order.dto;

import javax.validation.constraints.NotNull;

public class PaymentDetailDTO {
    @NotNull(message = "Please select payment option")
    Integer paymentType;
    @NotNull(message = "Please select bankname")
    String bankName;
    String accountNo;
    String ifscCode;
    @NotNull(message = "Please enter card number")
    String cardNumber;
    @NotNull(message = "Please enter card user name")
    String cardUserName;
    @NotNull(message = "Please enter card expiry date")
    String cardExpiryDate;

    Double totalTax;
    Double totalPrice;
    Double totalAmount;

    public PaymentDetailDTO() {
    }

    public PaymentDetailDTO(Integer paymentType, String bankName, String accountNo, String ifscCode, String cardNumber, String cardUserName, String cardExpiryDate, Double totalTax, Double totalPrice, Double totalAmount) {
        this.paymentType = paymentType;
        this.bankName = bankName;
        this.accountNo = accountNo;
        this.ifscCode = ifscCode;
        this.cardNumber = cardNumber;
        this.cardUserName = cardUserName;
        this.cardExpiryDate = cardExpiryDate;
        this.totalTax = totalTax;
        this.totalPrice = totalPrice;
        this.totalAmount = totalAmount;
    }

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardUserName() {
        return cardUserName;
    }

    public void setCardUserName(String cardUserName) {
        this.cardUserName = cardUserName;
    }

    public String getCardExpiryDate() {
        return cardExpiryDate;
    }

    public void setCardExpiryDate(String cardExpiryDate) {
        this.cardExpiryDate = cardExpiryDate;
    }

    public Double getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(Double totalTax) {
        this.totalTax = totalTax;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
