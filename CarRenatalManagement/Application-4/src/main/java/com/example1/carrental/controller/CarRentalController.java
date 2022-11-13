package com.example1.carrental.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example1.carrental.model.CarRental;
import com.example1.carrental.service.CarRentalService;

@RestController
public class CarRentalController {
	
	@Autowired
	private CarRentalService cService;
	
	// To save task
	@PostMapping("/savecar")
	public ResponseEntity<?> addTaskById(@RequestBody CarRental cRental) {
		CarRental taskObj = cService.addTask(cRental);
		
		if(taskObj == null)
			return	new ResponseEntity<String>("Todo item not saved", HttpStatus.BAD_REQUEST);
		
		return	new ResponseEntity<CarRental>(taskObj, HttpStatus.CREATED);
	}
	
	// To Get a all task
	@GetMapping("/getcars")
	public ResponseEntity<List<CarRental>> getTask() {

		return	new ResponseEntity<List<CarRental>>(cService.getTask(), HttpStatus.OK);
	}
	
	@GetMapping("/getcar/{id}")
	public ResponseEntity<?> getTaskById(@PathVariable String id) {
		CarRental cRental = cService.getTaskById(id);
		
		if(cRental == null)
			return	new ResponseEntity<String>("Todo Item doesn't exist with given ID", HttpStatus.NOT_FOUND);
		else
			return	new ResponseEntity<CarRental>(cRental, HttpStatus.OK);
	}
	

	
	@PutMapping("/editcar/{id}")
	public ResponseEntity<?> updateTask(@PathVariable String id, @RequestBody CarRental cRental) {
		if(cService.updateTask(id, cRental))
			return new ResponseEntity<CarRental>(cService.getTaskById(id), HttpStatus.OK);
		else
			return new ResponseEntity<String>("Bad Request", HttpStatus.BAD_REQUEST);
	}
	
	// To Delete a task by ID
	@DeleteMapping("/deletecar/{id}")
	public String deleteTaskById(@PathVariable String id) {
		if(cService.deleteTask(id))
//			System.out.println("Series Removed "+id);
//			return HttpStatus.NO_CONTENT;
			return "Car Removed "+id;
		
	
		return "internal server error";
//		return	HttpStatus.INTERNAL_SERVER_ERROR;
	}

}
