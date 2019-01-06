package com.example.server.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
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

	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_At", length = 30, insertable=false)
	private Date updatedAt;



	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_At", length = 30, insertable=false)
	private Date createdAt;


	public Long getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(Long categoryID) {
		this.categoryID = categoryID;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


}
