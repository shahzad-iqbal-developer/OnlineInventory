package com.OnlineInventory.Order.Service;

import com.OnlineInventory.Order.Commons.ApiResponse;
import com.OnlineInventory.Order.Commons.BeanUtils;
import com.OnlineInventory.Order.DTO.BillingAddressDTO;
import com.OnlineInventory.Order.DTO.CustomerAddressDTO;
import com.OnlineInventory.Order.DTO.OrderDTO;
import com.OnlineInventory.Order.DTO.PaymentDetailDTO;
import com.OnlineInventory.Order.Model.*;
import com.OnlineInventory.Order.Repository.*;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

@Service
public class OrderService {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Autowired
    OrderHistoryRepository orderHistoryRepository;

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    CustomerAddressRepository custAddRepository;

//    @Autowired
//    OrderAddressDetailRepository orderAddressDetailRepository;

    @Autowired
    BeanUtils beanUtils;

    Logger logger = LoggerFactory.getLogger(OrderService.class);
    
    public ResponseEntity<Object> postOrder(OrderDTO orderDTO) {
        Long now =System.currentTimeMillis();
        
        logger.info("Posting Application ....");
        Order order = new Order();

        CustomerDetail customerDetail= beanUtils.saveCustomerDetails(orderDTO);
        List<OrderItem> orderItems = beanUtils.saveItem(orderDTO);
        OrderHistory orderHistory=  beanUtils.populateOrderHistory(order,orderDTO,orderItems.get(0));
        OrderAddressDetail orderAddressDetail= beanUtils.populateOrderAdressDetail(order,orderDTO);
        List<OrderDetail> orderDetail=  beanUtils.populateOrderDetail(orderDTO, order,orderItems);
        PaymentDetails paymentDetails= beanUtils.populatePaymentDetails(order, orderDTO);


        // Populating Order
        order.setOrderStatus(orderDTO.getOrderStatus());        
            order.setOrderTotalAmount(orderDTO.getPaymentDetail().getTotalPrice());
        order.setOrderBaseAmount(orderDTO.getOrderTotal());
        order.setCreatedBy(orderDTO.getCustomerDetail().getCustomerId().intValue());
        order.setUpdatedBy(orderDTO.getCustomerDetail().getCustomerId().intValue());
        order.setDiscountAmount(orderDTO.getCouponDetail().getDiscountAmt());
        order.setPhone(orderDTO.getCustomerDetail().getPhone());
        order.setShippingId(orderDTO.getShippingMethod().toString());
        order.setUpdatedBy(orderDTO.getCustomerDetail().getCustomerId().intValue());
        order.setEmail(orderDTO.getCustomerDetail().getEmail());
        order.setNotificationType(orderDTO.getNotificationId().intValue());
        order.setOrderTotalAmount(orderDTO.getOrderTotal());
        order.setPaymentStatus(orderDTO.getPaymentStatus());
        order.setShippingMethod(orderDTO.getShippingMethod());
        order.setShippingAmount(orderDTO.getShippingAmt());
        order.setLastUpdate(new Timestamp(System.currentTimeMillis()));
        order.setDiscountAmount(orderDTO.getCouponDetail().getDiscountAmt());
        order.setDiscountCode(orderDTO.getCouponDetail().getCouponName());
        order.setDiscountType(orderDTO.getCouponDetail().getDiscountType());
        order.setCreateDate(new Timestamp(now));
        order.setOrderAddressDetails(orderAddressDetail);
        order.setOrderDetailList(orderDetail);
        order.setPaymentDetails(Arrays.asList(paymentDetails));
        order.setOrderHistory(Arrays.asList(orderHistory));
        order.setDeliveryInstruction(orderDTO.getDeliveryInstruction());
        order.setCreateDate(new Timestamp(now));


        try
        {
            orderRepository.save(order);
            logger.info("{  Order Id: "+order.getOrder_id().toString()+"  "+ "Status: SUCCESS"+"Timestamp: "+new Timestamp(System.currentTimeMillis())+"  }");
            return ResponseEntity.ok(order.getOrder_id());//new ApiResponse(order.getOrder_id(),"SUCCESS", new Timestamp(System.currentTimeMillis()));
        }
        catch (Exception e)
        {
            logger.info("{  Timestamp:  "+new Timestamp( System.currentTimeMillis())+"  Status = Failed"+"  message="+e.getMessage()+"  }");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
            		//new ApiResponse(new Timestamp(System.currentTimeMillis()),"Failed",e.getMessage());
        }



    }

	public ResponseEntity<Order> getOrderById(Long id) {
		logger.info("getting order by id"+id);
		Optional<Order> order = orderRepository.findById(id);
		if(order.isPresent()) {
			return ResponseEntity.ok(order.get()); //new ApiResponse<Order>(order,"SUCCESS",new Timestamp(System.currentTimeMillis()));
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);//new ApiResponse<Order>(null,"Order Id doesn't exsist",new Timestamp(System.currentTimeMillis()));
		
		
	}

    public ResponseEntity<Object> getOrderListID(int createdBy) {
        logger.info("getting order by id"+createdBy);
        Optional<ArrayList> orderList = orderRepository.findAllByCreatedBy(createdBy);
        if(orderList.isPresent()) {
            return ResponseEntity.ok(orderList.get()); //new ApiResponse<Order>(order,"SUCCESS",new Timestamp(System.currentTimeMillis()));
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);//new ApiResponse<Order>(null,"Order Id doesn't exsist",new Timestamp(System.currentTimeMillis()));

    }



    public ResponseEntity<Object> getOrderListForAdmin(Date startDate, Date endDate) {
        //logger.info("getting order by id"+createdBy);
        System.out.println("in side admin");
        Date date = new Date();
        Timestamp t1  = new Timestamp(startDate.getTime());
        System.out.println("Date t1= "+ t1  +"   || "+new Timestamp(date.getTime()));

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -60);
        Timestamp t2  = new Timestamp(endDate.getTime());
        System.out.println("Date t2= "+ t2 +"||" + new Timestamp(cal.getTime().getTime()));


        Optional<ArrayList> orderList = orderRepository.findAllByCreateDateBetween(t1, t2);
        if(orderList.isPresent()) {
            return ResponseEntity.ok(orderList.get()); //new ApiResponse<Order>(order,"SUCCESS",new Timestamp(System.currentTimeMillis()));
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);//new ApiResponse<Order>(null,"Order Id doesn't exsist",new Timestamp(System.currentTimeMillis()));

    }

    public ResponseEntity<Object> getOrderList(int createdBy, Date startDate, Date endDate) {
        logger.info("getting order by id"+createdBy);
        System.out.println("in side non ad");
        Date date = new Date();
        Timestamp t1  = new Timestamp(startDate.getTime());
        System.out.println("Date t1= "+ t1  +"   || "+new Timestamp(date.getTime()));

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -60);
        Timestamp t2  = new Timestamp(endDate.getTime());
        System.out.println("Date t2= "+ t2 +"||" + new Timestamp(cal.getTime().getTime()));


        ArrayList orderList = orderRepository.findAllByCreatedByAndCreateDateBetween(createdBy, t1, t2);

        ArrayList orderListResponse = beanUtils.populateOrderListDetail(orderList);
        if(orderListResponse.size()>0) {
            return ResponseEntity.ok(orderListResponse); //new ApiResponse<Order>(order,"SUCCESS",new Timestamp(System.currentTimeMillis()));
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);//new ApiResponse<Order>(null,"Order Id doesn't exsist",new Timestamp(System.currentTimeMillis()));

    }


    public ResponseEntity<Object> postCustomerAddress(CustomerAddressDTO custAddDTO){
        Long now =System.currentTimeMillis();
        Logger logger = LoggerFactory.getLogger(OrderService.class);
        logger.info("Posting Application ....");
        CustomerAddress custAdd = new CustomerAddress();

        custAdd.setAddressLine1(custAddDTO.getAddressLine1());
        custAdd.setAddressLine2(custAddDTO.getAddressLine2());
        custAdd.setCountry(custAddDTO.getCountry());
        custAdd.setFirstName(custAddDTO.getFirstName());
        custAdd.setMiddleName(custAddDTO.getMiddleName());
        custAdd.setLastName(custAddDTO.getLastName());
        custAdd.setBilling(custAddDTO.isBilling());
        custAdd.setCellNo(custAddDTO.getCellNo());
        custAdd.setCity(custAddDTO.getCity());
        custAdd.setFaxNo(custAddDTO.getFaxNo());
        custAdd.setLastUpdated(new Timestamp(now));
        custAdd.setMailing(custAddDTO.isMailing());
        custAdd.setPhone(custAddDTO.getPhone());
        custAdd.setPrimary(custAddDTO.isPrimary());
        custAdd.setState(custAddDTO.getState());
        custAdd.setUpdatedBy(custAddDTO.getUpdatedBy());
        custAdd.setZipCode(custAddDTO.getZipCode());
        custAdd.setCreatedBy(custAddDTO.getCreatedBy());
        custAdd.setCreatedDate(new Timestamp(now));

        try
        {
            custAddRepository.save(custAdd);
            logger.info("{Id: "+custAdd.getAddress_id().toString()+"  "+ "Status: SUCCESS"+"Timestamp: "+new Timestamp(System.currentTimeMillis())+"  }");
            return ResponseEntity.ok(custAdd.getAddress_id());
        }
        catch (Exception e)
        {
            logger.info("{Timestamp:  "+new Timestamp( System.currentTimeMillis())+"  Status = Failed"+"  message="+e.getMessage()+"  }");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    public ResponseEntity<Object> getCustomerAddress(int createdBy) {
        logger.info("getting addresses by id - "+createdBy);
        try {
            ArrayList addList = custAddRepository.findAllByCreatedBy(createdBy);
            if(addList.size()>0) {
                return ResponseEntity.ok(addList);
            }
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }catch(Exception e) {
            logger.info("{Timestamp:  "+new Timestamp( System.currentTimeMillis())+"  Status = Failed"+"  message="+e.getMessage()+"  }");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }



}
