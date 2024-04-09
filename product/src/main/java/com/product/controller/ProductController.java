package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.entity.Product;
import com.product.service.ProductService;

@RestController
@RequestMapping("/home")
public class ProductController {
	@Autowired
	ProductService productser;

	@PostMapping("/insert")
	public String insert(@RequestBody List<Product> p) {
		return productser.insert(p);
	}

	@GetMapping("/findAll")
	public List<Product> findAll() {
		return productser.findAll();
	}

}
