package com.OnlineInventory.Order.Model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "address")
public class CustomerAddress {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long address_id;
	
	@Column(name = "add_line1")
	    private String addressLine1;
	@Column(name = "add_line2")
	    private String addressLine2;
	@Column(name = "phone_number")    
	private String phone;
	@Column(name = "cell_number")    
	private String cellNo;
	@Column(name = "fax_number")
	private String faxNo;
	@Column(name = "city")
	private String city;
	@Column(name = "zipcode")
	private String zipCode;
	@Column(name = "state")
	private String state;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "middle_name")
	private String middleName;
	@Column(name = "last_name")
	private String lastName;
	
	
	
	@Column(name = "is_primary")
	private boolean isPrimary;
	@Column(name = "is_mailing")
	private boolean isMailing;
	@Column(name = "is_billing")
	private boolean isBilling;
	
	@Column(name = "created_by")
	private Integer createdBy;
	@Column(name = "created_date")
	private Timestamp createdDate;
	
	@Column(name = "updated_by")
	private Integer updatedBy;
	@Column(name = "last_updated")
	private Timestamp lastUpdated;
	
	public CustomerAddress() {
		
	}

	public CustomerAddress(Long address_id, String addressLine1, String addressLine2, String phone, String cellNo,
                           String faxNo, String city, String zipCode, String state, String country, String firstName,
                           String middleName, String lastName, boolean isPrimary, boolean isMailing, boolean isBilling,
                           Integer createdBy, Timestamp createdDate, Integer updatedBy, Timestamp lastUpdated) {
		super();
		this.address_id = address_id;
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
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.lastUpdated = lastUpdated;
	}

	public Long getAddress_id() {
		return address_id;
	}

	public void setAddress_id(Long address_id) {
		this.address_id = address_id;
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
