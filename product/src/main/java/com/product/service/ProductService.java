package com.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.dao.ProductDao;
import com.product.entity.Product;
@Service
public class ProductService {
	@Autowired
	ProductDao productdao;
	
	public String insert(List<Product> p) {
		return productdao.insert(p);
	}
	
	public List<Product> findAll() {
		return productdao.findAll();
	}

}
