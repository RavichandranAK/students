package com.Student.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Student.Entity.Results;

public interface StudentRepository extends JpaRepository<Results, Integer> {

	}

/*    @PostMapping(value = "/insertAllStudviaEmp")
public String insertAllStu(@RequestBody List<Student> s) {
	String url = "http://localhost:8080/student/insertAll";
	ResponseEntity<String> resp = res.exchange(url, HttpMethod.POST, new HttpEntity<>(s), String.class);
	// ResponseEntity<String> resp = res.postForEntity(url, s, String.class);
	return resp.getBody();
}

@PutMapping(value = "/updateStudviaEmp")
public String updateAllStu(@RequestBody List<Student> s) {
	String url = "http://localhost:8080/student/update";
	ResponseEntity<String> resp = res.exchange(url, HttpMethod.PUT, new HttpEntity<>(s), String.class);
	return resp.getBody();
}   

public String insertResult(List<Student> stud, List<MarkSheet> mark, List<Result> res) {
	String url = "http://localhost:8080/home/getAll";
	String url1 = "http://localhost:8081/marksheet/getAllMarks";
	List<Student> name = rest.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Student>>() {
	}).getBody();
	List<MarkSheet> mar = rest
			.exchange(url1, HttpMethod.GET, null, new ParameterizedTypeReference<List<MarkSheet>>() {
			}).getBody();
	for (int i = 0; i < name.size(); i++) {
		if (mar.get(i).getRollNumber() == name.get(i).getRollNumber()) {
			res.get(i).setName(name.get(i).getName());
			res.get(i).setTotal((mar.get(i).getSem1Total() + mar.get(i).getSem2Total()) / 2);
			res.get(i).setRollNumber(name.get(i).getRollNumber());
		}
	}
	for (int i = 0; i < name.size(); i++) {
		if (name.get(i).getAttendance() > 90.0f && res.get(i).getTotal() != 100) {
			res.get(i).setTotal(res.get(i).getTotal() + 5);
		}
		res.get(i).setPercentage((res.get(i).getTotal() / 100) * 100);
	}
	return resDao.insertResult(res);
}

*/