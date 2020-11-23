package com.inventory.order.controller;

import com.inventory.order.dto.CustomerAddressDTO;
import com.inventory.order.dto.OrderDTO;
import com.inventory.order.dto.OrderReturnItemsDTO;
import com.inventory.order.infrastructure.common.Constants;
import com.inventory.order.infrastructure.exception.OnlineInventoryException;
import com.inventory.order.model.CustomerAddress;
import com.inventory.order.model.Order;
import com.inventory.order.service.OrderService;
import com.inventory.order.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/")
    public ResponseEntity<Object> createOrder(@RequestBody OrderDTO orderDTO){
        return orderService.postOrder(orderDTO);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOrderByID(@PathVariable("id") Long id){
    	return orderService.getOrderById(id);
    }


    @GetMapping("/getOrderList/{createdBy}")
    public ResponseEntity<Object> getOrderList(@PathVariable("createdBy") int createdBy){
        return orderService.getOrderListID(createdBy);
    }



    @GetMapping("/getOrderListForAdmin")
    public ResponseEntity<Object> getOrderListForAdmin(@RequestParam Map param){
        //System.out.println("param = createdBy " + param.get("createdBy"));
        System.out.println("param = startDate " + param.get("startDate"));
        System.out.println("param = endDate " + param.get("endDate"));

        Date startDate, toDate = null;
        try{
            startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse((String)param.get("startDate"));
            toDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse((String)param.get("endDate"));
        }catch(Exception e) {
            startDate = new Date();
            toDate = new Date();
        }
        if(param.containsKey("createdBy")) {
            return orderService.getOrderList(Integer.parseInt((String)param.get("createdBy")),startDate, toDate);
        }else {
            return orderService.getOrderListForAdmin(startDate, toDate);
        }
    }


    @PostMapping("/saveAddress")
    public Long saveAddress(@RequestBody CustomerAddressDTO custAddDTO){
        System.out.println("inside save address..");
        try{
            return orderService.postCustomerAddress(custAddDTO);
        } catch (OnlineInventoryException ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, Constants.SOMETHING_BAD_HAPPENED.getValue());
        }
    }

    @GetMapping("/getCustAddress/{createdBy}")
    public List<CustomerAddress> retrieveUser(@PathVariable int createdBy){
        try{
            return orderService.getCustomerAddress(createdBy);
        } catch (OnlineInventoryException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, Constants.SOMETHING_BAD_HAPPENED.getValue());
        }
    }
    @PutMapping("/cancelOrder/{orderId}")
    public ResponseEntity<Object> cancelOrder(@PathVariable Long orderId){
        // Order order = (Order)orderService.getOrderById(orderId);

        return orderService.cancelOrderById(orderId);
    }
    @PutMapping("/returnOrder")
    public ResponseEntity<Object> returnOrder(@RequestBody OrderReturnItemsDTO returnItemDTO){
        System.out.println("inside return orders..");
        return orderService.returnOrder(returnItemDTO);
    }
}
