package com.inventory.order.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name ="order")
public class Order {
	

	@JsonIgnoreProperties("order")
    @OneToMany(mappedBy = "order",cascade = {CascadeType.ALL})
    List<OrderDetail> orderDetailList;

	
	@JsonIgnoreProperties({"order","item"})
    @OneToMany(mappedBy = "order",cascade = {CascadeType.ALL})
    List<OrderHistory> orderHistory;


	@JsonIgnoreProperties("order")
    @OneToOne(mappedBy = "order",cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    OrderAddressDetail orderAddressDetails;
//
	
	@JsonIgnoreProperties("order")
    @OneToMany(mappedBy = "order",cascade = {CascadeType.ALL}   )
    List<PaymentDetails> paymentDetails;




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="order_id")
    private Long order_id;
    @Column(name = "order_status")
    private Integer orderStatus;
    @Column(name = "order_total_amount")
    private Double orderTotalAmount;
    @Column(name = "order_base_amount")
    private Double orderBaseAmount;
    @Column(name = "discount_amount")
    private Double discountAmount;
    @Column(name = "shipping_amount")
    private Double shippingAmount;
    @Column(name = "user_type")
    private Integer userType;
    @Column(name = "payment_status")
    private Integer paymentStatus;
    @Column(name = "discount_type")
    private Integer discountType;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
    @Column(name = "discount_code")
    private String discountCode;
    @Column(name = "busy_flag")
    private Integer busyFlag;
    @Column(name = "busy_voucher_id")
    private String busyVoucherId;
    @Column(name = "notification_type")
    private Integer notificationType;
    @Column(name = "shipping_method")
    private Integer shippingMethod;
    @Column(name = "shipping_id")
    private String shippingId;
    @Column(name = "created_by")
    private Integer createdBy;
    @Column(name = "created_date")
    private Timestamp createDate;
    @Column(name = "updated_by")
    private Integer updatedBy;
    @Column(name = "last_updated")
    private Timestamp lastUpdate;

    @Column(name="delivery_instruction")
    private String deliveryInstruction;


    public Order() {
    }

    public Order(Long id, Integer orderStatus, Double orderTotalAmount, Double orderBaseAmount, Double discountAmount, Double shippingAmount, Integer userType, Integer paymentStatus, Integer discountType, String phone, String email, String discountCode, Integer busyFlag, String busyVoucherId, Integer notificationType, Integer shippingMethod, String shippingId, Integer createdBy, Timestamp createDate, Integer updatedBy, Timestamp lastUpdate, String deliveryInstruction) {

        this.order_id = id;
        this.orderStatus = orderStatus;
        this.orderTotalAmount = orderTotalAmount;
        this.orderBaseAmount = orderBaseAmount;
        this.discountAmount = discountAmount;
        this.shippingAmount = shippingAmount;
        this.userType = userType;
        this.paymentStatus = paymentStatus;
        this.discountType = discountType;
        this.phone = phone;
        this.email = email;
        this.discountCode = discountCode;
        this.busyFlag = busyFlag;
        this.busyVoucherId = busyVoucherId;
        this.notificationType = notificationType;
        this.shippingMethod = shippingMethod;
        this.shippingId = shippingId;
        this.createdBy = createdBy;
        this.createDate = createDate;
        this.updatedBy = updatedBy;
        this.lastUpdate = lastUpdate;
        this.deliveryInstruction=deliveryInstruction;
    }

    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }

    public List<OrderHistory> getOrderHistory() {
        return orderHistory;
    }

    public void setOrderHistory(List<OrderHistory> orderHistory) {
        this.orderHistory = orderHistory;
    }

    public OrderAddressDetail getOrderAddressDetails() {
        return orderAddressDetails;
    }

    public void setOrderAddressDetails(OrderAddressDetail orderAddressDetails) {
        this.orderAddressDetails = orderAddressDetails;
    }

    public List<PaymentDetails> getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(List<PaymentDetails> paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Double getOrderTotalAmount() {
        return orderTotalAmount;
    }

    public void setOrderTotalAmount(Double orderTotalAmount) {
        this.orderTotalAmount = orderTotalAmount;
    }

    public Double getOrderBaseAmount() {
        return orderBaseAmount;
    }

    public void setOrderBaseAmount(Double orderBaseAmount) {
        this.orderBaseAmount = orderBaseAmount;
    }

    public Double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Double getShippingAmount() {
        return shippingAmount;
    }

    public void setShippingAmount(Double shippingAmount) {
        this.shippingAmount = shippingAmount;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Integer getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Integer paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Integer getDiscountType() {
        return discountType;
    }

    public void setDiscountType(Integer discountType) {
        this.discountType = discountType;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public Integer getBusyFlag() {
        return busyFlag;
    }

    public void setBusyFlag(Integer busyFlag) {
        this.busyFlag = busyFlag;
    }

    public String getBusyVoucherId() {
        return busyVoucherId;
    }

    public void setBusyVoucherId(String busyVoucherId) {
        this.busyVoucherId = busyVoucherId;
    }

    public Integer getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(Integer notificationType) {
        this.notificationType = notificationType;
    }

    public Integer getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(Integer shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public String getShippingId() {
        return shippingId;
    }

    public void setShippingId(String shippingId) {
        this.shippingId = shippingId;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
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

    public String getDeliveryInstruction() {
        return deliveryInstruction;
    }

    public void setDeliveryInstruction(String deliveryInstruction) {
        this.deliveryInstruction = deliveryInstruction;
    }
}
