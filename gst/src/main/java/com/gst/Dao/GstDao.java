package com.gst.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gst.Entity.Gst;
import com.gst.Repository.GstRepository;
@Repository
public class GstDao {
	@Autowired
	GstRepository gstrepo;

	public String insertAll(List<Gst> g) {
	 gstrepo.saveAll(g);
	 return "Inserted Successfully";
	}
	
	public List<Gst> findAll() {
		return gstrepo.findAll();
	}
	
	public int gettax(int hsn) {
		return gstrepo.gettax(hsn);
	}
}
