package com.inventory.order.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "orderId",
        "itemLists"
})
public class OrderReturnItemsDTO {

    @JsonProperty("orderId")
    private Long orderId;
    @JsonProperty("itemLists")
    private List<ItemDTO> itemLists = null;

    @JsonProperty("orderId")
    public Long getOrderId() {
        return orderId;
    }

    @JsonProperty("orderNumber")
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @JsonProperty("itemLists")
    public List<ItemDTO> getItemLists() {
        return itemLists;
    }

    @JsonProperty("itemLists")
    public void setItemLists(List<ItemDTO> itemLists) {
        this.itemLists = itemLists;
    }

}