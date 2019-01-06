package com.example.server.models;


import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.util.Date;


public class Payment {

	private Long ccNum;

	private String cardHolder;

	private int cvvNum;

	private Date expiration;

}
