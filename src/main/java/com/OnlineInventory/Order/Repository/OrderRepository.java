package com.OnlineInventory.Order.Repository;

import com.OnlineInventory.Order.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    Optional<ArrayList> findAllByCreatedBy(int createdBy);

    Optional<ArrayList> findAllByCreateDateBetween(Date createDate_dateStart, Date createDate_dateEnd);

    ArrayList findAllByCreatedByAndCreateDateBetween(int createdBy,Date createDate_dateStart,Date createDate_dateEnd);
}
