package com.example1.travellist.controller;

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
import com.example1.travellist.model.TravelList;
import com.example1.travellist.service.TravelListService;

@RestController
public class TravelListController {
	
	@Autowired
	TravelListService tService;
	
	@PostMapping("/addTravel")
	public ResponseEntity<?> addTaskById(@RequestBody TravelList tList) {
		TravelList taskObj = tService.addTask(tList);
		
		if(taskObj == null)
			return	new ResponseEntity<String>("Todo item not saved", HttpStatus.BAD_REQUEST);
		
		return	new ResponseEntity<String>("Travel Added Successfully", HttpStatus.CREATED);
	}
	
	// To Get a all task
	@GetMapping("/travel")
	public ResponseEntity<List<TravelList>> getTask() {

		return	new ResponseEntity<List<TravelList>>(tService.getTask(), HttpStatus.OK);
	}
	
	@GetMapping("/travel/{id}")
	public ResponseEntity<?> getTaskById(@PathVariable String id) {
		TravelList tList = tService.getTaskById(id);
		
		if(tList == null)
			return	new ResponseEntity<String>("Todo Item doesn't exist with given ID", HttpStatus.NOT_FOUND);
		else
			return	new ResponseEntity<TravelList>(tList, HttpStatus.OK);
	}
	

	
	@PutMapping("/travel/{id}")
	public ResponseEntity<?> updateTask(@PathVariable String id, @RequestBody TravelList tList) {
		if(tService.updateTask(id, tList))
			return new ResponseEntity<String>("Travel Updated Successfully "+id, HttpStatus.OK);
		else
			return new ResponseEntity<String>("Bad Request", HttpStatus.BAD_REQUEST);
	}
	
	// To Delete a task by ID
	@DeleteMapping("/travel/{id}")
	public String deleteTaskById(@PathVariable String id) {
		if(tService.deleteTask(id))
			return "Travel Deleted Successfully "+id;
		
	
		return "internal server error";
//		return	HttpStatus.INTERNAL_SERVER_ERROR;
	}
	
	

}
