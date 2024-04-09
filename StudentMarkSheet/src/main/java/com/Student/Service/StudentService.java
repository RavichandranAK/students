package com.Student.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Student.Dao.StudentDao;
import com.Student.Entityy.MarkSheet;
@Service
public class StudentService {
	
	@Autowired
	StudentDao studentdao;
	
	public String insert(MarkSheet m) {
		m.setSem1total(m.getSem1theory()+m.getSem1practicals());
		m.setSem2total(m.getSem2theory()+m.getSem2practicals());
		return studentdao.insert(m);
	}
	
	public List<MarkSheet> findAll() {
		return studentdao.findAll();
	}
	
	public List<Integer> findTotal(){
		List<MarkSheet> res=studentdao.findAll();
		List<Integer> total=new ArrayList<>();
		for(MarkSheet x:res) {
			int tot = x.getSem1total()+x.getSem2total();
			total.add(tot);
		}
		return total;
	}

}
