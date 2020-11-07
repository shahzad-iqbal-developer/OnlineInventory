package com.inventory.order.dto;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class BillingAddressDTO {

    private Long id;

    @NotNull(message = "Please enter first name")
    private String firstName;
    @NotNull(message = "Please enter first name")
    private String middleName;
    @NotNull(message = "Please enter first name")
    private String lastName;

    @NotNull(message = "Please enter Phone")
    @Pattern(regexp = "[0-9]*", message = "Phone should be numeric")
    private String phone;


    @NotNull(message = "Please enter email")
    @Email(message = "Invalid formate of email")
    private String email;

    @NotNull(message = "Please enter Address Line 1")
    private String addressLine1;
    private String addressLine2;

    @NotNull(message = "Please enter City")
    private String city;

    @NotNull(message = "Please enter Zip code")
    @Pattern(regexp = "[0-9]*", message = "Zipcode should be numeric.")
    private String zipCode;

    @NotNull(message = "Please enter state")
    private String state;

    @NotNull(message = "Please enter country")
    private String country;

    public BillingAddressDTO() {
    }

    public BillingAddressDTO(Long id, String firstName, String middleName, String lastName, String phone, String email, String addressLine1, String addressLine2, String city, String zipCode, String state, String country) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.zipCode = zipCode;
        this.state = state;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
