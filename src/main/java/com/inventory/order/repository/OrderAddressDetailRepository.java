package com.inventory.order.repository;

import com.inventory.order.model.OrderAddressDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderAddressDetailRepository extends JpaRepository<OrderAddressDetail, Long> {
}
