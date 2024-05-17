package com.craft.salesordermanagementservice.service;

import com.craft.salesordermanagementservice.dto.Customer;
import com.craft.salesordermanagementservice.model.CustomerOrder;

public interface SalesService {
	void createOrder(CustomerOrder customerOrder);
	void updateOrder(CustomerOrder customerOrder);
	CustomerOrder getOrder(String orderId);
	Customer getCustomerInformation(String customerId);
}
