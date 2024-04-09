package com.gst.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gst.Dao.GstDao;
import com.gst.Entity.Gst;
@Service
public class GstService {
	@Autowired
	GstDao gstdao;
	
	public String insertAll(List<Gst> g) {
		return gstdao.insertAll(g);
	}
	public List<Gst> findAll() {
		return gstdao.findAll();
	}
	
	public int gettax(int hsn) {
		return gstdao.gettax(hsn);
	}

}
