package com.inventory.order.dto;

public class CouponDetailDTO {
    String couponName;
    Integer discountType;
    Double discountAmt;

    public CouponDetailDTO() {
    }

    public CouponDetailDTO(String couponName, Integer discountType, Double discountAmt) {
        this.couponName = couponName;
        this.discountType = discountType;
        this.discountAmt = discountAmt;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public Integer getDiscountType() {
        return discountType;
    }

    public void setDiscountType(Integer discountType) {
        this.discountType = discountType;
    }

    public Double getDiscountAmt() {
        return discountAmt;
    }

    public void setDiscountAmt(Double discountAmt) {
        this.discountAmt = discountAmt;
    }
}

