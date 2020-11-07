package com.OnlineInventory.Order.Repository;

import com.OnlineInventory.Order.Model.CustomerAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface CustomerAddressRepository extends JpaRepository<CustomerAddress,Long>{
	ArrayList<CustomerAddress> findAllByCreatedBy(int createdBy);
}
