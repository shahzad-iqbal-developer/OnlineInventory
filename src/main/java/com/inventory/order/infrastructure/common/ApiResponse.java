package com.inventory.order.infrastructure.common;

import java.sql.Timestamp;

/**
 * Created by ASAD QURESHI on 1/23/2020.
 */
public class ApiResponse<T> {

    private String Status;
    Timestamp timestamp;
    Long orderId;
    String message;
    String details;
    private Object result;
    
    
    public ApiResponse(Object result,String status, Timestamp timestamp ) {
		super();
		Status = status;
		this.timestamp = timestamp;
		this.result = result;
	}

	public ApiResponse( Long orderId, String Status,  Timestamp timestamp) {

        this.orderId= orderId;
        this.Status = Status;
        this.timestamp = timestamp;


    }

    public ApiResponse( String message) {

        this.Status = message;
    }

    public ApiResponse( Timestamp timestamp,String message, String details ) {

       this.timestamp= timestamp;
       this.message = message;
       this.details= details;


    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}
    
}
