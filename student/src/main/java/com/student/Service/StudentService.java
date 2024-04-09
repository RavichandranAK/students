package com.student.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.Dao.StudentDao;
import com.student.entity.Student;
@Service
public class StudentService {
	@Autowired
	StudentDao studentDao;
	
	public String insertAll(List<Student> s) {
		return studentDao.insertAll(s);
	}
	
	public List<Student> findAll() {
		return studentDao.findAll();
	}
	
	public List<String> findNameByCourse(String course) {
		List<Student> temp=studentDao.findAll();
		return temp.stream().filter(x->x.getCourse().equalsIgnoreCase(course)).map(x->x.getName()).toList();
	}
	
	public Map<Integer,String> findIdAndNameBycollege(String college) {
		List<Student> temp=studentDao.findAll();
		return temp.stream().filter(x->x.getCollege().equalsIgnoreCase(college)).collect(Collectors.toMap(x->x.getId(), y->y.getName()));
	}
	
	public String deleteName(String name) {
		List<Student> temp=studentDao.findAll();
		List<Student> a=temp.stream().filter(x->x.getName().equalsIgnoreCase(name)).collect(Collectors.toList());
		for(int i=1;i<a.size();i++) {
		Student delObject=a.get(i);
		Integer delId=delObject.getId();
		studentDao.mydel(delId);
		}
		
		
		return "Duplicates Deleted";
	}

}
