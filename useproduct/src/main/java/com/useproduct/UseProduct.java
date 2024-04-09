package com.useproduct;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.product.entity.Product;

@RestController
public class UseProduct {
	@Autowired
	RestTemplate rest;

	@GetMapping("/run")
	public List<Product> addTax() {
		String listurl="http://localhost:8080/home/findAll";
		ResponseEntity<List<Product>> res= rest.exchange(listurl, HttpMethod.GET,null,new ParameterizedTypeReference<List<Product>>(){});
		List<Product> fulllist= res.getBody();
		
		String taxurl = "http://localhost:8081/gst/getTax/";
//		ResponseEntity<Integer> res1 = rest.exchange(taxurl, HttpMethod.GET, null,Integer.class);
//		Integer taxpercentage= res1.getBody();
//		
//		List<Product> afterTax=fulllist.stream().filter(x->x.getHsn()==hsn).map(x->{
//			x.setPrice(x.getPrice()+(x.getPrice()*taxpercentage/100));
//			return x;
//		}).collect(Collectors.toList());
//		return afterTax;
		
		fulllist.forEach(x->{
			int Hsn=x.getHsn();
			Integer taxPercentage=rest.exchange(taxurl+Hsn, HttpMethod.GET,null, Integer.class).getBody();
			x.setPrice(x.getPrice()+(x.getPrice()*taxPercentage/100));
			
		});
        return fulllist;
	}

}
