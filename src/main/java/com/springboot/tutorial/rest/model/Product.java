package com.springboot.tutorial.rest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel(description="Product model")
@Entity
@Data
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer productId;
	private String productName;
	private String productDescription;
	private Double productPrice;
}
