package com.springboot.tutorial.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springboot.tutorial.rest.model.Product;
import com.springboot.tutorial.rest.repository.ProductRepository;

@Component
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product getProduct(Integer id) {
		return productRepository.findById(id).orElse(new Product());
	}

	@Override
	public List<Product> getAllProducts() {
		
		System.out.println("GET PRODUCT by name:::");
		System.out.println(productRepository.findByProductName("Mobile"));
		
		return productRepository.findAll();
	}

	@Override
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public boolean deleteProduct(Integer id) {
		productRepository.delete(productRepository.findById(id).get());
		return true;
	}

	@Override
	public Product updateProduct(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
