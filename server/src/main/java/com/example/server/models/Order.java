package com.example.server.models;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

@Entity
@Table(name = "order")
public class Order {

	@Id
	@Column(name = "orderNum")
	private Long orderNum;


	@Column(name ="order_Status")
	private String orderStatus;

	@Column(name = "order_Total")
	private int orderTotal;

	/**
	 * Proper example 1 order has Many Products
	 */

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "productID")
	private List<Product> product;


	@Column(name = "order_Date")
	private String orderDate;



}
