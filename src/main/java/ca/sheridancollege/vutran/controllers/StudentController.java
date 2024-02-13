package ca.sheridancollege.vutran.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.sheridancollege.vutran.beans.Student;
import ca.sheridancollege.vutran.repo.StudentRepo;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/students/")
public class StudentController {
	private StudentRepo sr;
	@GetMapping
	public List<Student> getStudentCollection() {
		return sr.findAll();
	}
	@GetMapping(value = "{id}") 
	// *value* attribute only here to illustrate our Mappings can do more!
	// URL: /api/v1/students/5
	public Student getIndividualStudent(@PathVariable("id") Long id) {
		return sr.findById(id).get();
	}
	@PostMapping(consumes = "application/json")
	public Student postStudent(@RequestBody Student student) {
		return sr.save(student);
	}
	@PutMapping(consumes = "application/json")
	public String putStudentCollection(@RequestBody List<Student> studentList) {
		// replace .. or .. update? HTTP PUT vs PATCH respectively!
		sr.deleteAll();
		sr.saveAll(studentList);
		return "Total Records: " + sr.count();
	}
	@PutMapping(value = "{id}", consumes = "application/json")
	public Student putStudent(@RequestBody Student student, @PathVariable("id") Long id) {
		// if we save an instance with an id already present in our db, we actually update!
		// if no match is found, JPA Repository’s save method will just insert anyway
		sr.deleteById(id);
		return sr.save(student);
	}
	@DeleteMapping(value = "{id}")
	public String deleteStudent(@PathVariable("id") Long id) {
		sr.deleteById(id);
		return "Deleted id: " + id;
	}
	@DeleteMapping
	public String deleteStudentCollection() {
		sr.deleteAll();
		return "Deleted Collection";
	}
}
