package com.inventory.order.service;

import com.inventory.order.dto.CustomerAddressDTO;
import com.inventory.order.dto.OrderDTO;
import com.inventory.order.dto.OrderReturnItemsDTO;
import com.inventory.order.model.CustomerAddress;
import com.inventory.order.model.Order;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.List;

public interface OrderService {

    ResponseEntity<Object> postOrder(OrderDTO orderDTO);

    ResponseEntity<Object> getOrderById(Long id);

    ResponseEntity<Object> getOrderListID(int createdBy);

    ResponseEntity<Object> getOrderListForAdmin(Date startDate, Date endDate);

    ResponseEntity<Object> getOrderList(int createdBy, Date startDate, Date endDate);

    ResponseEntity<Object> postCustomerAddress(CustomerAddressDTO custAddDTO);

    List<CustomerAddress> getCustomerAddress(int createdBy);

    ResponseEntity<Object> cancelOrderById(Long id);
    ResponseEntity<Object> returnOrder(OrderReturnItemsDTO returnDTO);

}