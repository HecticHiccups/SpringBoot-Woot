package com.example.server.models;

import javax.persistence.OneToOne;

import java.util.Date;

public class Payment {

	private Order order;

	private Long ccNum;

	private String cardHolder;

	private int cvvNum;

	private Date expiration;

}
