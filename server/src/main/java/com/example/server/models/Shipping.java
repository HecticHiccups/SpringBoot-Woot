package com.example.server.models;

import javax.persistence.*;

@Entity
@Table(name="shipping")
public class Shipping {

	@Id
	@Column(name ="shipNum")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long shipNum;

	@OneToOne(cascade = CascadeType.ALL, mappedBy="ship")
	private Order order;

	@Column(name ="tel")
	private String tel;

	@Column(name ="address")
	private String address;

	@Column(name = "zip")
	private String zip;

	@Column(name = "city")
	private String city;

	@Column(name ="country")
	private String country;

	@Column(name ="state")
	private String state;


	public Long getShipNum() {
		return shipNum;
	}

	public void setShipNum(Long shipNum) {
		this.shipNum = shipNum;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}


}

