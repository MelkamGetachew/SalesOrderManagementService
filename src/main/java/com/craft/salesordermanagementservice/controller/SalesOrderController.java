package com.craft.salesordermanagementservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.craft.salesordermanagementservice.dto.Customer;
import com.craft.salesordermanagementservice.model.CustomerOrder;
import com.craft.salesordermanagementservice.service.SalesService;

@RestController
@RequestMapping("/order")
public class SalesOrderController {
	@Autowired
	private SalesService salesService;
	
	@PostMapping("/create")
	public ResponseEntity<?> createOrder(@RequestBody CustomerOrder customerOrder){
		salesService.createOrder(customerOrder);
		 return new ResponseEntity<>(customerOrder, HttpStatus.CREATED);
	}
	@PutMapping("/update/{orderId}")
	public ResponseEntity<?> updateOrder(@RequestBody CustomerOrder customerOrder, @PathVariable String orderId){
		customerOrder.setOrderId(orderId);
		salesService.updateOrder(customerOrder);
		return new ResponseEntity<>(customerOrder, HttpStatus.OK);
	}
	@GetMapping("/getOrder")
	public ResponseEntity<?> getOrder(@RequestParam("orderId") String orderId){
		CustomerOrder customerOrder =salesService.getOrder(orderId);
		return new ResponseEntity<>(customerOrder, HttpStatus.OK);
	}
	@GetMapping("/getCustomerInfo/{customerId}")
	public ResponseEntity<?> getCustomerInfo( @PathVariable String customerId){
		
		return new ResponseEntity<>(salesService.getCustomerInformation(customerId), HttpStatus.OK);
	}
}
