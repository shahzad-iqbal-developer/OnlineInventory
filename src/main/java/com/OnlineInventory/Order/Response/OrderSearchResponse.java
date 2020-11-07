package com.OnlineInventory.Order.Response;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import com.OnlineInventory.Order.Model.OrderAddressDetail;
import com.OnlineInventory.Order.Model.PaymentDetails;

public class OrderSearchResponse {

    private Long order_id;
    private int orderStatus;
    private String orderStatusDesc;
	private Double orderTotalAmount;
    private Double orderBaseAmount;
    private Double discountAmount;
    private Double shippingAmount;
    private Integer userType;
    private Integer paymentStatus;
    private Integer discountType;
    private String phone;
    private String email;
    private String discountCode;
    private Integer busyFlag;
    private String busyVoucherId;
    private Integer notificationType;
    private Integer shippingMethod;
    private String shippingId;
    private Integer createdBy;
    private Timestamp createDate;
    private Integer updatedBy;
    private Timestamp lastUpdate;
    
    private String action;
    private String deliveryDate;
    private String orderDate;

	List<ItemDetails> itemDetailList;
    OrderAddressDetail orderAddressDetails;
    List<PaymentDetails> paymentDetails;
	public Long getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}
	
	public int getOrderStatus() {
		return orderStatus;
	}
	
	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	public String getOrderStatusDesc() {
		HashMap<Integer, String> statusMap = new HashMap<Integer, String>();
		
		statusMap.put(1, "New");
		statusMap.put(2, "In Progress");
		statusMap.put(3, "Shipped");
		statusMap.put(4, "Delivered");
		statusMap.put(5, "Cancelled");
		statusMap.put(6, "Returned");
		this.orderStatusDesc = statusMap.get(this.orderStatus);
		return orderStatusDesc;
	}
	public void setOrderStatusDesc(String orderStatusDesc) {
		this.orderStatusDesc = orderStatusDesc;
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
	public List<ItemDetails> getItemDetailList() {
		return itemDetailList;
	}
	public void setItemDetailList(List<ItemDetails> itemDetailList) {
		this.itemDetailList = itemDetailList;
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
	
	public String getAction() { 
		
		if(this.orderStatus==3 || this.orderStatus==4)
			return "Return";
		else if(this.orderStatus==1 || this.orderStatus==2)
			return "Cancel";
		else
			return "-";
	}
	
	public String getDeliDate() { 
		
		Calendar calendar = Calendar.getInstance();
	    calendar.setTime(this.createDate);
	    calendar.add(Calendar.DAY_OF_MONTH, 7);
	     
	     SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
	     this.deliveryDate = format.format(calendar.getTime());
	    
		return deliveryDate;
	}
	
	public String getOrderDate() { 
		
		Calendar calendar = Calendar.getInstance();
	    calendar.setTime(this.createDate);
	     
	     SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
	     this.orderDate = format.format(calendar.getTime());
	    
		return orderDate;
	}
    
}
