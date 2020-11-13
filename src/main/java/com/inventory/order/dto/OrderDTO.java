package com.inventory.order.dto;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class OrderDTO {

    private String customerType;
//    @NotBlank(message = "Title is required")
    CustomerDetailDTO customerDetailDTO;
    Double orderTotal;
    Integer orderStatus;
    Integer paymentStatus;
    Long notificationId;
    Integer shippingMethod;
    Double shippingAmt;
    List<ItemDTO> items;
    AddressDTO address;
    CouponDetailDTO couponDetail;
    String deliveryInstruction;
    PaymentDetailDTO paymentDetail;



    public OrderDTO() {
    }

    public OrderDTO(String customerType, CustomerDetailDTO customerDetailDTO,
                    Double orderTotal, Integer orderStatus, Integer paymentStatus,
                    Long notificationId, Integer shippingMethod, Double shippingAmt,
                    List<ItemDTO> items, AddressDTO address, CouponDetailDTO couponDetail,
                    PaymentDetailDTO paymentDetail, String deliveryInstruction) {

        this.customerType = customerType;
        this.customerDetailDTO = customerDetailDTO;
        this.orderTotal = orderTotal;
        this.orderStatus = orderStatus;
        this.paymentStatus = paymentStatus;
        this.notificationId = notificationId;
        this.shippingMethod = shippingMethod;
        this.shippingAmt = shippingAmt;
        this.items = items;
        this.address = address;
        this.couponDetail = couponDetail;
        this.paymentDetail = paymentDetail;
        this.deliveryInstruction=deliveryInstruction;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public CustomerDetailDTO getCustomerDetail() {
        return customerDetailDTO;
    }

    public void setCustomerDetail(CustomerDetailDTO customerDetailDTO) {
        this.customerDetailDTO = customerDetailDTO;
    }

    public Double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(Double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Integer paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Long getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(Long notificationId) {
        this.notificationId = notificationId;
    }

    public Integer getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(Integer shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public Double getShippingAmt() {
        return shippingAmt;
    }

    public void setShippingAmt(Double shippingAmt) {
        this.shippingAmt = shippingAmt;
    }

    public List<ItemDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemDTO> items) {
        this.items = items;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    public CouponDetailDTO getCouponDetail() {
        return couponDetail;
    }

    public void setCouponDetail(CouponDetailDTO couponDetail) {
        this.couponDetail = couponDetail;
    }

    public PaymentDetailDTO getPaymentDetail() {
        return paymentDetail;
    }

    public void setPaymentDetail(PaymentDetailDTO paymentDetail) {
        this.paymentDetail = paymentDetail;
    }

    public String getDeliveryInstruction() {
        return deliveryInstruction;
    }

    public void setDeliveryInstruction(String deliveryInstruction) {
        this.deliveryInstruction = deliveryInstruction;
    }
}
