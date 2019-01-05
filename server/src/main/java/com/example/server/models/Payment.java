package com.example.server.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.OneToOne;

import java.util.Date;

public class Payment {

	private Long ccNum;

	private String cardHolder;

	private int cvvNum;

	@DateTimeFormat(pattern = "mm/yyyy")
	private Date expiration;

}
