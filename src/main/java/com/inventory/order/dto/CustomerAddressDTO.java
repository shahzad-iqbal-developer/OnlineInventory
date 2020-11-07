package com.inventory.order.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.sql.Timestamp;

public class CustomerAddressDTO {
	//private Long id;

    @NotNull(message = "Please enter Address Line 1")
    private String addressLine1;
    private String addressLine2;
        
    @Pattern(regexp = "[0-9]*", message = "Phone should be numeric")
    private String phone;
    
    @NotNull(message = "Please enter Cell")
    @Pattern(regexp = "[0-9]*", message = "Cell should be numeric")
    private String cellNo;
    
    @Pattern(regexp = "[0-9]*", message = "Fax should be numeric")
    private String faxNo;

    @NotNull(message = "Please enter City")
    private String city;

    @NotNull(message = "Please enter Zip code")
    @Pattern(regexp = "[0-9]*", message = "Zipcode should be numeric.")
    private String zipCode;

    @NotNull(message = "Please enter state")
    private String state;

    @NotNull(message = "Please enter Country")
    private String country;
    
    @NotNull(message = "Please enter First Name")
    private String firstName;
    private String middleName;
    private String lastName;
    private boolean isPrimary;
    private boolean isMailing;
    private boolean isBilling;
    private Integer createdBy;
    private Integer updatedBy;
    private Timestamp lastUpdated;

    public CustomerAddressDTO() {
    }

	public CustomerAddressDTO(String addressLine1, String addressLine2, String phone, String cellNo,
                              String faxNo, String city, String zipCode, String state,
                              String country, String firstName, String middleName, String lastName,
                              boolean isPrimary, boolean isMailing, boolean isBilling, Integer createdBy, Integer updatedBy,
                              Timestamp lastUpdated) {
		super();
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.phone = phone;
		this.cellNo = cellNo;
		this.faxNo = faxNo;
		this.city = city;
		this.zipCode = zipCode;
		this.state = state;
		this.country = country;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.isPrimary = isPrimary;
		this.isMailing = isMailing;
		this.isBilling = isBilling;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.lastUpdated = lastUpdated;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCellNo() {
		return cellNo;
	}

	public void setCellNo(String cellNo) {
		this.cellNo = cellNo;
	}

	public String getFaxNo() {
		return faxNo;
	}

	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isPrimary() {
		return isPrimary;
	}

	public void setPrimary(boolean isPrimary) {
		this.isPrimary = isPrimary;
	}

	public boolean isMailing() {
		return isMailing;
	}

	public void setMailing(boolean isMailing) {
		this.isMailing = isMailing;
	}

	public boolean isBilling() {
		return isBilling;
	}

	public void setBilling(boolean isBilling) {
		this.isBilling = isBilling;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
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
