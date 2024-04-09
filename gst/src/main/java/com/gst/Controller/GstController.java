package com.gst.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gst.Entity.Gst;
import com.gst.Service.GstService;


@RestController
@RequestMapping("/gst")
public class GstController {
	@Autowired
	GstService gstser;
	
	@PostMapping("/insertAll")
	public String insertAll(@RequestBody List<Gst> g) {
		return gstser.insertAll(g);
	}
	
	@GetMapping("/findAll")
	public List<Gst> findAll() {
		return gstser.findAll();
	}
	
	@GetMapping("/getTax/{hsn}")
	public int gettax(@PathVariable int hsn) {
		return gstser.gettax(hsn);
	}
	

}
