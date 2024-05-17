package com.craft.salesordermanagementservice.model;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Entity
public class CustomerOrder {
	@Id
	private String orderId;
	private String customerId;
	@ElementCollection
	private List<Product> products;
	private double discount;
	@Embedded
	private ShippingAddress shippingAddress;
	private String notes;

}
