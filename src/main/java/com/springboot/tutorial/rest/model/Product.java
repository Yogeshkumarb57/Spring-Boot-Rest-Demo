package com.springboot.tutorial.rest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(description="Product model")
@Entity
@Data
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(notes = "Database generated product id",readOnly = true)
	private Integer productId;
	@ApiModelProperty(notes = "Product name")
	private String productName;
	@ApiModelProperty(notes = "Product description")
	private String productDescription;
	@ApiModelProperty(notes = "Product price")
	private Double productPrice;
	
	
	// adding getters, setters and toString, method. lombok was not working on ubuntu.
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
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
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productDescription="
				+ productDescription + ", productPrice=" + productPrice + "]";
	}
	
}
