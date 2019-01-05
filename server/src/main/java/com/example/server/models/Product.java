package com.example.server.models;

import javax.persistence.*;


@Entity
@Table(name = "product")
public class Product {

	@Id
	@Column(name = "productID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long productID;

	@Column(name = "product_Name")
	private String productName;

	@Column(name = "product_Description", columnDefinition="TEXT")
	private String productDescription;

	@Column(name = "product_Price")
	private Double productPrice;

	@Column(name = "product_Quantity")
	private int productQuantity;

	@Column(name = "product_Image")
	private String productImage;

	@Column(name = "created_At")
	private String createdAt;


	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public Long getProductID() {
		return productID;
	}

	public void setProductID(Long productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}


}
