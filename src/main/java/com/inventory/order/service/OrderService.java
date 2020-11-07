package com.inventory.order.service;

import com.inventory.order.dto.CustomerAddressDTO;
import com.inventory.order.dto.OrderDTO;
import com.inventory.order.model.Order;
import org.springframework.http.ResponseEntity;

import java.util.Date;

public interface OrderService {

    ResponseEntity<Object> postOrder(OrderDTO orderDTO);

    ResponseEntity<Order> getOrderById(Long id);

    ResponseEntity<Object> getOrderListID(int createdBy);

    ResponseEntity<Object> getOrderListForAdmin(Date startDate, Date endDate);

    ResponseEntity<Object> getOrderList(int createdBy, Date startDate, Date endDate);

    ResponseEntity<Object> postCustomerAddress(CustomerAddressDTO custAddDTO);

    ResponseEntity<Object> getCustomerAddress(int createdBy);

}
