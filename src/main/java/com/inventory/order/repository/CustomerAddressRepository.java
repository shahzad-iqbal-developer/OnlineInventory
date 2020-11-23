package com.inventory.order.repository;

import com.inventory.order.model.CustomerAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerAddressRepository extends JpaRepository<CustomerAddress,Long>{
	Optional<List<CustomerAddress>> findAllByCreatedBy(int createdBy);
}
