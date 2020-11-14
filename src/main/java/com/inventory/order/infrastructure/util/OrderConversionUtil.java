package com.inventory.order.infrastructure.util;
import com.inventory.order.dto.*;
import com.inventory.order.model.*;
import com.inventory.order.repository.CustomerDetailRepository;
import com.inventory.order.repository.ItemRepository;
import com.inventory.order.repository.OrderHistoryRepository;
//import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 *
 * Here we can use ModelMapper Or mapStruct Or ObjectMapper library to convert dto to model or vice versa
 *
 *
 */
@Component
//@RequiredArgsConstructor
public class OrderConversionUtil {
    @Autowired
    ModelMapper mapper;

    public OrderAddressDetail populateOrderAddressDetail(OrderDTO orderDTO) {

        BillingAddressDTO billingAddress = orderDTO.getAddress().getBillToAddress();
        BillingAddressDTO shippingAddress = orderDTO.getAddress().getShipToAddress();
        OrderAddressDetail orderAddressDetail = new OrderAddressDetail();
        orderAddressDetail.setBillToFirstName(billingAddress.getFirstName());
        orderAddressDetail.setBillToMiddleName(billingAddress.getMiddleName());
        orderAddressDetail.setBillToLastName(billingAddress.getLastName());
        orderAddressDetail.setBillToState(billingAddress.getState());
        orderAddressDetail.setBillToZipCode(billingAddress.getZipCode());
        orderAddressDetail.setBillToAddLine1(billingAddress.getAddressLine1());
        orderAddressDetail.setBillToAddLine2(billingAddress.getAddressLine2());
        orderAddressDetail.setBillToCity(billingAddress.getCity());
        orderAddressDetail.setBillToCountry(billingAddress.getCountry());
        orderAddressDetail.setBillToState(billingAddress.getState());
        orderAddressDetail.setShipToFirstName(shippingAddress.getFirstName());
        orderAddressDetail.setShipToMiddleName(shippingAddress.getMiddleName());
        orderAddressDetail.setShipToLastName(shippingAddress.getLastName());
        orderAddressDetail.setShipToState(shippingAddress.getState());
        orderAddressDetail.setShipToZipCode(shippingAddress.getZipCode());
        orderAddressDetail.setShipToAddLine1(shippingAddress.getAddressLine1());
        orderAddressDetail.setShipToAddLine2(shippingAddress.getAddressLine2());
        orderAddressDetail.setShipToCity(shippingAddress.getCity());
        orderAddressDetail.setShipToCountry(shippingAddress.getCountry());
        orderAddressDetail.setShipToState(shippingAddress.getState());
//        orderAddressDetail.setOrder(order);
        orderAddressDetail.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        orderAddressDetail.setLastUpdated(new Timestamp(System.currentTimeMillis()));
        return  orderAddressDetail;
    }


    public  List<OrderItem> populateOrderItems(OrderDTO orderDTO){
        return orderDTO.getItems().stream()
                .map(itemDto -> mapper.map(itemDto,OrderItem.class))
                .collect(Collectors.toList());
    }

    public List<OrderDetail> populateOrderDetail(OrderDTO orderDTO,Order order) {
       
        List<OrderDetail> orderDetails= new ArrayList<>();
        List<OrderItem> orderItems = populateOrderItems(orderDTO);

        for(OrderItem orderItem : orderItems) {
        	 OrderDetail orderDetail = new OrderDetail();
        	orderDetail.setCreateDate(new Timestamp(System.currentTimeMillis()));
            orderDetail.setLastUpdate(new Timestamp(System.currentTimeMillis()));
            orderDetail.setItem(orderItem);
            orderDetail.setItemTotalAmount(orderItem.getPrice()*orderItem.getQuantity());
            orderDetail.setQuantity(orderItem.getQuantity());
            orderDetail.setItemPrice(orderItem.getPrice());
            orderDetail.setCreateDate(new Timestamp(System.currentTimeMillis()));
            orderDetail.setLastUpdate(new Timestamp(System.currentTimeMillis()));
            orderDetail.setCreatedBy(orderDTO.getCustomerDetail().getCustomerId().toString());
            orderDetail.setUpdatedBy(orderDTO.getCustomerDetail().getCustomerId().intValue());
            orderDetail.setDiscountAmount(orderDTO.getCouponDetail().getDiscountAmt());
            orderDetail.setDiscountCode(orderDTO.getCouponDetail().getCouponName());
            orderDetail.setDiscountType(orderDTO.getCouponDetail().getDiscountType());
            orderDetail.setOrder(order);
            orderDetail.setDiscountAmount(orderDTO.getCouponDetail().getDiscountAmt());
            orderDetail.setItemStatus(orderDTO.getOrderStatus());
            orderDetails.add(orderDetail);

        }
        return orderDetails;
    }


    public CustomerDetail populateCustomerDetail(OrderDTO orderDTO){
        return mapper.map(orderDTO.getCustomerDetail(),CustomerDetail.class);
    }

    public PaymentDetails populatePaymentDetails(Order order , OrderDTO orderDTO) {

        PaymentDetailDTO paymentDetailDTO = orderDTO.getPaymentDetail();
        PaymentDetails paymentDetails = new PaymentDetails();
        paymentDetails.setPaymentType(paymentDetailDTO.getPaymentType());
        paymentDetails.setBankName(paymentDetailDTO.getBankName());
        paymentDetails.setAccountNumber(paymentDetailDTO.getAccountNo());
        paymentDetails.setIfscCode(paymentDetailDTO.getIfscCode());
        paymentDetails.setCardNumber(paymentDetailDTO.getCardNumber());
        paymentDetails.setCreatedBy(orderDTO.getCustomerDetail().getCustomerId().intValue());
        paymentDetails.setUpdatedBy(orderDTO.getCustomerDetail().getCustomerId().intValue());
        paymentDetails.setCardExpiry(paymentDetailDTO.getCardExpiryDate());
        paymentDetails.setOrderTotalAmount(paymentDetailDTO.getTotalPrice());
        paymentDetails.setCardFirstName(paymentDetailDTO.getCardUserName().split(" ")[0]);
        paymentDetails.setCardLastName(paymentDetailDTO.getCardUserName().split(" ")[1]);
        paymentDetails.setOrder(order);
        paymentDetails.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        paymentDetails.setLastUpdated(new Timestamp(System.currentTimeMillis()));
        return paymentDetails;
    }

    public OrderHistory populateOrderHistory(OrderDTO orderDTO) {

        OrderHistory orderHistory = new OrderHistory();
//        orderHistory.setOrder(order);
        orderHistory.setItem(populateOrderItems(orderDTO).get(0));
        orderHistory.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        orderHistory.setCreatedBy(orderDTO.getCustomerDetail().getCustomerId().toString());
        orderHistory.setUpdatedBy(orderDTO.getCustomerDetail().getCustomerId().toString());
//        orderHistory.setUpdatedBy(new Timestamp(System.currentTimeMillis()));
        orderHistory.setNotificationSent(orderDTO.getNotificationId()!=null);
        orderHistory.setLastUpdated(new Timestamp(System.currentTimeMillis()));
        orderHistory.setStatusDate(new Timestamp(System.currentTimeMillis()));

        return orderHistory;
    }

    public ArrayList populateOrderListDetail(ArrayList orderList) {
        ArrayList odList = new ArrayList();

        for(int i=0; i<orderList.size();i++) {
            OrderSearchResponse osr = new OrderSearchResponse();
            Order order = (Order)orderList.get(i);

            osr.setOrder_id(order.getOrder_id());
            osr.setOrderTotalAmount(order.getOrderTotalAmount());
            osr.setOrderStatus(order.getOrderStatus());
            osr.setCreateDate(order.getCreateDate());
            osr.setCreatedBy(order.getCreatedBy());
            osr.setDiscountAmount(order.getDiscountAmount());
            osr.setDiscountCode(order.getDiscountCode());
            osr.setDiscountType(order.getDiscountType());
            osr.setEmail(order.getEmail());
            //osr.setItemDetailList(itemDetailList);
            osr.setLastUpdate(order.getLastUpdate());
            osr.setNotificationType(order.getNotificationType());
            osr.setOrderBaseAmount(order.getOrderBaseAmount());
            osr.setPaymentStatus(order.getPaymentStatus());
            osr.setPhone(order.getPhone());
            osr.setShippingAmount(order.getShippingAmount());
            osr.setShippingId(order.getShippingId());
            osr.setShippingMethod(order.getShippingMethod());
            osr.setUpdatedBy(order.getUpdatedBy());
            osr.setUserType(order.getUserType());

            ArrayList itemList = new ArrayList();
            for(int j=0;j< order.getOrderDetailList().size();j++) {
                OrderDetail orderDetail = (OrderDetail) order.getOrderDetailList().get(j);
                ItemDetails itemDetail = new ItemDetails();

                itemDetail.setItemStatus(orderDetail.getItemStatus());
                itemDetail.setItemTotalAmount(orderDetail.getItemTotalAmount());;
                itemDetail.setQuantity(orderDetail.getQuantity());
                itemDetail.setItemPrice(orderDetail.getItemPrice());
                itemDetail.setTaxAmount(orderDetail.getTaxAmount());
                itemDetail.setDiscountType(orderDetail.getDiscountType());
                itemDetail.setDiscountCode(orderDetail.getDiscountCode());
                itemDetail.setDiscountAmount(orderDetail.getDiscountAmount());
                itemDetail.setItemComment(orderDetail.getItemComment());
                itemDetail.setCreatedBy(orderDetail.getCreatedBy());
                itemDetail.setCreateDate(orderDetail.getCreateDate());
                itemDetail.setUpdatedBy(orderDetail.getUpdatedBy());
                itemDetail.setLastUpdate(orderDetail.getLastUpdate());

                itemDetail.setDescription(orderDetail.getItem().getDescription());
                itemDetail.setItemColor(orderDetail.getItem().getItemColor());
                itemDetail.setItemId(orderDetail.getItem().getId());
                itemDetail.setItemName(orderDetail.getItem().getName());
                itemDetail.setItemSize(orderDetail.getItem().getItemSize());
                itemDetail.setLongName(orderDetail.getItem().getLongName());
                itemDetail.setPrice(orderDetail.getItem().getPrice());
                itemDetail.setSku(orderDetail.getItem().getSku());

                itemDetail.setProductId(orderDetail.getItem().getProduct().getProduct_id());
                itemDetail.setProductName(orderDetail.getItem().getProduct().getName());
                itemDetail.setProductLongName(orderDetail.getItem().getProduct().getLong_name());
                itemDetail.setProdDescription(orderDetail.getItem().getProduct().getDescription());
                itemList.add(itemDetail);
            }

            osr.setItemDetailList(itemList);
            odList.add(osr);
        }

        return odList;
    }
}
