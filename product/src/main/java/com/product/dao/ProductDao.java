package com.product.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.product.entity.Product;
import com.product.repository.ProductRepository;
@Repository
@RequestMapping("/home")
public class ProductDao {
	@Autowired
	ProductRepository productrepo;
	
	public String insert(List<Product> p) {
		productrepo.saveAll(p);
		return "Inserted Successfully";
	}
	
	public List<Product> findAll() {
		return productrepo.findAll();
		
	}

}
