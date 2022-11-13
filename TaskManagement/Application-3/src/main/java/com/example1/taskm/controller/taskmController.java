package com.example1.taskm.controller;

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

import com.example1.taskm.model.Taskm;
import com.example1.taskm.service.taskmService;

@RestController
public class taskmController {
	
	@Autowired
	private taskmService tService;
	
	// To save task
	@PostMapping("/savetask")
	public ResponseEntity<?> addTaskById(@RequestBody Taskm tsTaskm) {
		Taskm taskObj = tService.addTask(tsTaskm);
		
		if(taskObj == null)
			return	new ResponseEntity<String>("Todo item not saved", HttpStatus.BAD_REQUEST);
		
		return	new ResponseEntity<Taskm>(taskObj, HttpStatus.CREATED);
	}
	
	// To Get a all task
	@GetMapping("/tasks/all")
	public ResponseEntity<List<Taskm>> getTask() {

		return	new ResponseEntity<List<Taskm>>(tService.getTask(), HttpStatus.OK);
	}
	
	
	// To Get a task by taskHolderName
		@GetMapping("/tasks/{name}")
		public ResponseEntity<List<Taskm>> getTaskByName(@PathVariable String name) {
		
			return	new ResponseEntity<List<Taskm>>(tService.getTaskBytaskHolderName(name), HttpStatus.OK);
		
		}
	
	@PutMapping("/changestatus/{id}")
	public ResponseEntity<?> updateTask(@PathVariable String id, @RequestBody Taskm tsTaskm) {
		if(tService.updateTask(id, tsTaskm))
			return new ResponseEntity<Taskm>(tService.getTaskById(id), HttpStatus.OK);
		else
			return new ResponseEntity<String>("Bad Request", HttpStatus.BAD_REQUEST);
	}
	
	// To Delete a task by ID
	@DeleteMapping("/task/delete/{id}")
	public String deleteTaskById(@PathVariable String id) {
		if(tService.deleteTask(id))
//			System.out.println("Series Removed "+id);
//			return HttpStatus.NO_CONTENT;
			return "task Removed "+id;
		
	
		return "internal server error";
//		return	HttpStatus.INTERNAL_SERVER_ERROR;
	}

}
