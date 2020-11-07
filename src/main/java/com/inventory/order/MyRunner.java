package com.inventory.order;

import com.inventory.order.repository.CustomerDetailRepository;
import com.inventory.order.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    CustomerDetailRepository customerDetailRepository;

    @Override
    public void run(String... args) throws Exception {
//        itemRepository.save(new OrderItem("ABC",1,"abc",1l,"abc","desc",3,2.0,"abc","2.",2, new Timestamp(System.currentTimeMillis()),null,null ));
//        customerDetailRepository.save(new CustomerDetail("test","","test","9898989898","test@test.com","idk","idk","idk","idk","idk","idk"));
    }
}
