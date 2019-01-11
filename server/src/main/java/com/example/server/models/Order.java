package com.example.server.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.util.Date;


@Entity
@Table(name = "order_table")
public class Order {

	@Id
	@Column(name = "orderNum")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderNum;


	@Column(name ="order_Status")
	private String orderStatus;

	@Column(name = "order_Total")
	private double orderTotal;


	/**
	 * Ignores JSON
	 * M-1 Relationship
	 * Creates UserID Column in Orders_Table
	 */
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userID", nullable = false)
	private User user;

//
////Creating FkUserID Column in Orders Table
//	@ManyToOne(fetch = FetchType.LAZY, optional = false)
//	@JoinColumn(name = "userID", nullable = false)
//	@OnDelete(action = OnDeleteAction.CASCADE)
//	@JsonIgnore
//	private User user;


//	@OneToOne(fetch = FetchType.LAZY)
//	@MapsId
//	private Shipping shipping;

	/**
	 * Ignores JSON
	 * 1-1 Relationship
	 * Creates shipNum Column in Orders_Table
	 */
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="shipNum", nullable=false)
	private Shipping ship;


	@Column(name = "order_Date")
	private Date orderDate;

	public Date getOrderDate() {
		return orderDate;
	}

	public Shipping getShip() {
		return ship;
	}

	public void setShip(Shipping ship) {
		this.ship = ship;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Long getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Long orderNum) {
		this.orderNum = orderNum;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public double getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(double orderTotal) {
		this.orderTotal = orderTotal;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}




}
