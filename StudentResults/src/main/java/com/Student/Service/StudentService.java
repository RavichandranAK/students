package com.Student.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Student.Controller.StudentController;
import com.Student.Dao.StudentDao;
import com.Student.Entity.Results;
import com.Student.Exception.NoValueException;

import one.util.streamex.StreamEx;

@Service
public class StudentService {
	@Autowired
	StudentDao studentdao;

	
	
	public void access(Results r) {
		studentdao.access(r);
	}

	public List<Results> getTopper() {
		List<Results> list = studentdao.findAll();
		Results topper = list.stream().max(Comparator.comparing(Results::getPercentage)).get(); // to find top percentage
		List<Results> toplist = new ArrayList<>();
		list.forEach(x -> { // check if more-than one students got same top percentage
			if (x.getPercentage() == topper.getPercentage()) {
				toplist.add(x);
			}
		});

		return toplist;
	}

	public List<Results> gettopFive(int range) {
		List<Results> list = studentdao.findAll(); // next line finding top given percentage
		List<Results> top_list = StreamEx.of(list).sorted(Comparator.comparing(Results::getPercentage).reversed()).distinct(Results::getPercentage).limit(range).toList();
		List<Results> toplist_check = new ArrayList<>();
		for (int i = 0; i < top_list.size(); i++) { // check how many students in top given percentage
			for (int j = 0; j < list.size(); j++) {
				if (top_list.get(i).getPercentage() == list.get(j).getPercentage()) {
					toplist_check.add(list.get(j));
				}
			}
		}
		return toplist_check;
		
	}

	public List<Results> getByRange(int min,int max) throws NoValueException {
		List<Results> list = studentdao.findAll();
		List<Results> rangeBetween = new ArrayList<>();
		list.forEach(x -> {
			if (x.getPercentage() > min && x.getPercentage() < max) { // percentage lies between given range
				rangeBetween.add(x);
			}
		});
		
		if(rangeBetween.isEmpty()) {
			throw new NoValueException("Student not present in your given range!");
		} else {
		return rangeBetween.stream().sorted(Comparator.comparing(Results::getPercentage)).toList(); // presenting output in ascending order
		}
	}

}
