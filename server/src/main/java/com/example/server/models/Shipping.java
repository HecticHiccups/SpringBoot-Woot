package com.example.server.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="shipping")
public class Shipping {

	@Id

	private Long shipNum;


	private String tel;

	private String address;

	private String zip;

	private String city;

	private String country;

	private String state;
}

