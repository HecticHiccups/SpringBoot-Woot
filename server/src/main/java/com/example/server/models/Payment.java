package com.example.server.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name="payment")
public class Payment {

	@Id
	@Column(name = "ccNum")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ccNum;

	@Column(name = "cardHolder")
	private String cardHolder;

	@Column(name = "cvvNum", length = 30)
	private int cvvNum;

	@Column(name = "expirationDate")
	private Date expiration;


	/**
	 * Quickest way to form 1-1 Relationship
	 * Creates FK_userID
	 * MapsID that is necessary
	 */
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="userID")
	@MapsId
	private User user;

}
