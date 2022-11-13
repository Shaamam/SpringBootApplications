package com.example1.webseries.controller;

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

import com.example1.webseries.model.webseries;
import com.example1.webseries.service.webseriesService;

@RestController
public class webseriesController {
	
	@Autowired
	private webseriesService wService;
	
	// To Add a TODO
	@PostMapping("/addwebseries")
	public ResponseEntity<?> addWebseriesById(@RequestBody webseries wserWebseries) {
		webseries webObj = wService.addWebseries(wserWebseries);
		
		if(webObj == null)
			return	new ResponseEntity<String>("Todo item not saved", HttpStatus.BAD_REQUEST);
		
		return	new ResponseEntity<webseries>(webObj, HttpStatus.CREATED);
	}
	
	// To Get a all TODO 
	@GetMapping("/webseries")
	public ResponseEntity<List<webseries>> getWebseries() {

		return	new ResponseEntity<List<webseries>>(wService.getWebseries(), HttpStatus.OK);
	}
		
	// To Get a TODO by ID
	@GetMapping("/webseries/id/{id}")
	public ResponseEntity<?> getWebseriesById(@PathVariable Long id) {
		webseries wsWebseries = wService.getWebseriesById(id);
		
		if(wsWebseries == null)
			return	new ResponseEntity<String>("Todo Item doesn't exist with given ID", HttpStatus.NOT_FOUND);
		else
			return	new ResponseEntity<webseries>(wsWebseries, HttpStatus.OK);
	
		
	
	}
	
	
	// To Get a TODO by name
		@GetMapping("/webseries/name/{name}")
		public ResponseEntity<List<webseries>> getWebseriesByName(@PathVariable String name) {
		
			return	new ResponseEntity<List<webseries>>(wService.getWebseriesByName(name), HttpStatus.OK);
		
		}
	
	@PutMapping("/updatewebseries/{id}")
	public ResponseEntity<?> updateWebseries(@PathVariable Long id, @RequestBody webseries wsWebseries) {
		if(wService.updateWebseries(id, wsWebseries))
			return new ResponseEntity<webseries>(wService.getWebseriesById(id), HttpStatus.OK);
		else
			return new ResponseEntity<String>("Bad Request", HttpStatus.BAD_REQUEST);
	}
	
	// To Delete a TODO by ID
	@DeleteMapping("/deletewebseries/{id}")
	public String deleteWebseriesById(@PathVariable long id) {
		if(wService.deleteWebseries(id))
//			System.out.println("Series Removed "+id);
//			return HttpStatus.NO_CONTENT;
			return "Series Removed "+id;
		
	
		return "internal server error";
//		return	HttpStatus.INTERNAL_SERVER_ERROR;
	}
	

}
