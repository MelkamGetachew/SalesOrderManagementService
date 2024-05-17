package com.craft.salesordermanagementservice.service;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.craft.salesordermanagementservice.dto.Customer;
import com.craft.salesordermanagementservice.exception.ResourceNotFoundException;
import com.craft.salesordermanagementservice.model.CustomerOrder;
import com.craft.salesordermanagementservice.repo.OrderRepository;

@Service
public class SalesServiceImpl implements SalesService {
	@Autowired
	public OrderRepository orderRepo;
	@Autowired
	RestTemplate restTemplate;

	@Override
	public void createOrder(CustomerOrder customerOrder) {
		// to check if customer exist and create order
		if (getCustomerInformation(customerOrder.getCustomerId()) != null) {
			String id = generateRandomId();
			customerOrder.setOrderId(id);
			orderRepo.save(customerOrder);
		}
	}
	// to create unique order Id
	public String generateRandomId() {
		Random random = new Random();
		String id;
		while (true) {
			int randomNumber = random.nextInt(10000001);
			id = "ORDER" + randomNumber;
			Optional<CustomerOrder> orderList = orderRepo.findById(id);

			if (orderList.isEmpty()) {
				break;
			}
		}
		return id;
	}

	@Override
	public void updateOrder(CustomerOrder customerOrder) {
		String orderId = customerOrder.getOrderId();
		CustomerOrder customerOrderDb = getOrder(orderId);
		customerOrderDb.setCustomerId(customerOrder.getCustomerId());
		customerOrderDb.setProducts(customerOrder.getProducts());
		customerOrderDb.setDiscount(customerOrder.getDiscount());
		customerOrderDb.setShippingAddress(customerOrder.getShippingAddress());
		customerOrderDb.setNotes(customerOrder.getNotes());

	}

	@Override
	// to get order from DB based on orderId. If the order does not exist throw custom exception
	public CustomerOrder getOrder(String orderId) {
		CustomerOrder customerOrder = orderRepo.findById(orderId)
				.orElseThrow(() -> new ResourceNotFoundException("Order", "Id", orderId));

		return customerOrder;
	}

	@Override
	public Customer getCustomerInformation(String customerId) {
		String url = "http://localhost:8080/customers/get/" + customerId;
		Customer customer = restTemplate.getForObject(url, Customer.class);
		return customer;
	}

}
