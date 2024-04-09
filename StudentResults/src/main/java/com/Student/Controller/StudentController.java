package com.Student.Controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.Student.Entity.Results;
import com.Student.Exception.NoValueException;
import com.Student.MarksheetEntity.MarkSheet;
import com.Student.Repository.StudentRepository;
import com.Student.Service.StudentService;
import com.StudentDetails.Entity.Student;

@RestController
@RequestMapping("/home")
public class StudentController {

	

	@Autowired
	StudentRepository studentrepo;

	@Autowired
	RestTemplate rest;

	@Autowired
	StudentService studentser;
	
	static Logger log=Logger.getLogger(StudentController.class);

	@PostMapping("/via")
	public void access() {

		String stu_url = "http://localhost:8080/home/findAll"; // getting all student details from service 8080
		String mark_url = "http://localhost:8081/home/findAll"; // getting all student marks details from service 8081
		List<Student> details = rest.exchange(stu_url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Student>>() {}).getBody(); //student details
		List<MarkSheet> marks = rest.exchange(mark_url, HttpMethod.GET, null, new ParameterizedTypeReference<List<MarkSheet>>() {}).getBody(); //mark details

		for (int i = 0; i < details.size(); i++) {
			Results r1 = new Results(); // creating object to Results for insert values in DB			
			  for (int j = 0; j < marks.size(); j++) {
				 if (details.get(i).getRollNumber() == marks.get(j).getRollNumber()) { //Compare both lists rollNUmber 
					r1.setName(details.get(i).getName()); //setName for Results object
					r1.setRollNumber(details.get(i).getRollNumber()); //setRollNUmber for Results object
					if(details.get(i).getAttendance()>=90) {
				    r1.setTotalMarks( marks.get(j).getSem1total() + marks.get(j).getSem2total()+5); //setTotalMarks+5 for Results object if attendance is >= 90
					} else {
					r1.setTotalMarks( marks.get(j).getSem1total() + marks.get(j).getSem2total());  //setTotalMarks for Results object
					}
					if(r1.getTotalMarks()>=200) {
						r1.setPercentage(100.0f); //setPercentage for Results object if totalMarks reached 200 ,setPercentage as 100.
					} else {
					r1.setPercentage(r1.getTotalMarks() / 2.0f); //setPercentage for Results object if totalMarks less-than 200 just divide by 2.
					}
					studentser.access(r1);
				}
				
			}
			
		}
	}
	
	@GetMapping("/getTopper") // for finding top percentage holder
	public List<Results> getTopper() {
		PropertyConfigurator.configure("Logger.properties");
		log.info(studentser.getTopper());
		return studentser.getTopper();
	}

	@GetMapping("/getTopFive/{range}")
	public List<Results> gettopFive(@PathVariable int range){
		PropertyConfigurator.configure("Logger.properties");
		log.info(studentser.gettopFive(range));
		return studentser.gettopFive(range);
	}
	
	@GetMapping("/getByRange/{min}/{max}")
	public List<Results> getByRange(@PathVariable int min,@PathVariable int max) throws NoValueException{
		return studentser.getByRange(min,max);
	}
	
	
	}
	
	


