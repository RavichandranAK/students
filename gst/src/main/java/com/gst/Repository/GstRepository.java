package com.gst.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gst.Entity.Gst;

public interface GstRepository extends JpaRepository<Gst, Integer> {
	
	@Query(value="Select g.taxPer from Gst g where g.hsn= :hsn")
	public int gettax(int hsn);

}
