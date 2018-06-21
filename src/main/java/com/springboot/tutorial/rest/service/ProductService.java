package com.springboot.tutorial.rest.service;

import java.util.List;

import com.springboot.tutorial.rest.model.Product;

public interface ProductService {

	Product getProduct(Integer id);
	
	List<Product> getAllProducts();
	
	Product saveProduct(Product product);
	
	boolean deleteProduct(Integer id);
	
	Product updateProduct(Integer id);
}
