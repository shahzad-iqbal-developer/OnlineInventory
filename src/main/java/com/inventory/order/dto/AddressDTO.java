package com.inventory.order.dto;

public class AddressDTO {
    BillingAddressDTO billToAddress;
    BillingAddressDTO shipToAddress;

    public AddressDTO() {
    }

    public AddressDTO(BillingAddressDTO billToAddress, BillingAddressDTO shipToAddress) {
        this.billToAddress = billToAddress;
        this.shipToAddress = shipToAddress;
    }

    public BillingAddressDTO getBillToAddress() {
        return billToAddress;
    }

    public void setBillToAdress(BillingAddressDTO billToAdressDTO) {
        this.billToAddress = billToAdressDTO;
    }

    public BillingAddressDTO getShipToAddress() {
        return shipToAddress;
    }

    public void setShipToAddress(BillingAddressDTO shipToAddress) {
        this.shipToAddress = shipToAddress;
    }
}
