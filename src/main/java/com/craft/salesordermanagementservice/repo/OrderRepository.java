package com.craft.salesordermanagementservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.craft.salesordermanagementservice.model.CustomerOrder;

@Repository
public interface OrderRepository extends JpaRepository <CustomerOrder,String> {
	
}
