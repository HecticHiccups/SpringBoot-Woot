package com.example.server.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "category")
public class Category {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "categoryID")
	private Long categoryID;

	/**
	 * TODO:Look more into..Eager vs Lazy
	 */
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "productID")
	private Product product;

	@Column(name = "updated_At", length = 30)
	private Date updatedAt;

	@Column(name = "created_At", length = 30)
	private String createdAt;


}
