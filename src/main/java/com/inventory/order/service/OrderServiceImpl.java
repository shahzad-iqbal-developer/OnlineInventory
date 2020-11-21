package com.inventory.order.service;

import com.inventory.order.dto.CustomerAddressDTO;
import com.inventory.order.dto.ItemDTO;
import com.inventory.order.dto.OrderReturnItemsDTO;
import com.inventory.order.repository.CustomerAddressRepository;
import com.inventory.order.infrastructure.util.OrderConversionUtil;
import com.inventory.order.dto.OrderDTO;
import com.inventory.order.model.*;
import com.inventory.order.repository.*;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.*;

@Service

public class OrderServiceImpl implements OrderService{

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

    @Autowired
    OrderConversionUtil orderConversionUtil;


    Logger log = LoggerFactory.getLogger(OrderService.class);
    @Override
    public ResponseEntity<Object> postOrder(OrderDTO orderDTO) {
        Long now =System.currentTimeMillis();

        log.info("Posting Application ....");
        Order order = convertOrderDtoToOrder(orderDTO, now);

        try {
            orderRepository.save(order);
            log.info("{  Order Id: "+order.getOrder_id().toString()+"  "+ "Status: SUCCESS"+"Timestamp: "+new Timestamp(System.currentTimeMillis())+"  }");
            return ResponseEntity.ok(order.getOrder_id());
        }
        catch (Exception e) {
            log.info("{  Timestamp:  "+new Timestamp( System.currentTimeMillis())+"  Status = Failed"+"  message="+e.getMessage()+"  }");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

    }

    private Order convertOrderDtoToOrder(OrderDTO orderDTO, Long now) {
        Order order = new Order();

        CustomerDetail customerDetail= orderConversionUtil.populateCustomerDetail(orderDTO);

        OrderHistory orderHistory =  orderConversionUtil.populateOrderHistory(orderDTO);
        orderHistory.setOrder(order);

        OrderAddressDetail orderAddressDetail= orderConversionUtil.populateOrderAddressDetail(orderDTO);
        orderAddressDetail.setOrder(order);

        List<OrderDetail> orderDetail=  orderConversionUtil.populateOrderDetail(orderDTO,order);
        PaymentDetails paymentDetails= orderConversionUtil.populatePaymentDetails(order, orderDTO);


        // Populating Order
        order.setOrderStatus(orderDTO.getOrderStatus());
        order.setOrderTotalAmount(orderDTO.getPaymentDetail().getTotalPrice());
        order.setOrderBaseAmount(orderDTO.getOrderTotal());
        order.setOrderTax(orderDTO.getOrderTax());
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
        return order;
    }


    @Override
    public ResponseEntity<Order> getOrderById(Long id) {
        log.info("getting order by id"+id);
        Optional<Order> order = orderRepository.findById(id);
        if(order.isPresent()) {
            return ResponseEntity.ok(order.get());
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);

    }


    public ResponseEntity<Object> getOrderListID(int createdBy) {
        log.info("getting order by id"+createdBy);
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
        log.info("getting order by id"+createdBy);
        System.out.println("in side non ad");
        Date date = new Date();
        Timestamp t1  = new Timestamp(startDate.getTime());
        System.out.println("Date t1= "+ t1  +"   || "+new Timestamp(date.getTime()));

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -60);
        Timestamp t2  = new Timestamp(endDate.getTime());
        System.out.println("Date t2= "+ t2 +"||" + new Timestamp(cal.getTime().getTime()));


        ArrayList orderList = orderRepository.findAllByCreatedByAndCreateDateBetween(createdBy, t1, t2);

        ArrayList orderListResponse = orderConversionUtil.populateOrderListDetail(orderList);
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
        log.info("getting addresses by id - "+createdBy);
        try {
            List addList = custAddRepository.findAllByCreatedBy(createdBy);
            if(addList.size()>0) {
                return ResponseEntity.ok(addList);
            }
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }catch(Exception e) {
            log.info("{Timestamp:  "+new Timestamp( System.currentTimeMillis())+"  Status = Failed"+"  message="+e.getMessage()+"  }");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    public ResponseEntity<Object> cancelOrderById(Long id) {
        log.info("inside cancel order by id - "+id);
        Optional<Order> order = orderRepository.findById(id);
        if(order.isPresent()) {
            Order newOrder = (Order)order.get();
            newOrder.setOrderStatus(5);
            orderRepository.save(newOrder);
            return ResponseEntity.ok(newOrder.getOrder_id());
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
    public ResponseEntity<Object> returnOrder(OrderReturnItemsDTO returnDTO) {
        log.info("inside return order by id - "+returnDTO.getOrderId());
        Optional<Order> order = orderRepository.findById(returnDTO.getOrderId());
        if(order.isPresent()) {
            Order newOrder = (Order)order.get();

            List <OrderDetail> items =newOrder.getOrderDetailList();
            int totalItems = items.size();
            System.out.println("total items: "+totalItems);
            int returnedItem = 0;
            for(int i=0; i<totalItems;i++) {
                if(newOrder.getOrderDetailList().get(i).getItemStatus()==6 ||
                        newOrder.getOrderDetailList().get(i).getItemStatus()==8){
                    returnedItem=returnedItem+1;
                }else {
                    for(ItemDTO item: returnDTO.getItemLists()) {
                        if(newOrder.getOrderDetailList().get(i).getItem().getId()==item.getItemId()) {
                            newOrder.getOrderDetailList().get(i).setItemStatus(6);
                            break;
                        }
                    }
                }

            }

            if(totalItems > (returnedItem + returnDTO.getItemLists().size())){
                newOrder.setOrderStatus(7);
            }else {
                newOrder.setOrderStatus(8);
            }

            orderRepository.save(newOrder);
            return ResponseEntity.ok(newOrder.getOrder_id());
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}