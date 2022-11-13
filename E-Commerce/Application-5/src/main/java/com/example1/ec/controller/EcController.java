package com.example1.ec.controller;

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

import com.example1.ec.model.Ecommerce;
import com.example1.ec.service.EcService;

@RestController
public class EcController {
	
	@Autowired
	EcService eService;
	
	@PostMapping("/saveProduct")
	public ResponseEntity<?> addProduct(@RequestBody Ecommerce ecommerce) {
		Ecommerce webObj = eService.addProduct(ecommerce);
		
		if(webObj == null)
			return	new ResponseEntity<String>("Todo item not saved", HttpStatus.BAD_REQUEST);
		
		return	new ResponseEntity<Ecommerce>(webObj, HttpStatus.CREATED);
	}
	
	// To Get a all TODO 
	@GetMapping("/getAllProduct")
	public ResponseEntity<List<Ecommerce>> getProducts() {

		return	new ResponseEntity<List<Ecommerce>>(eService.getProducts(), HttpStatus.OK);
	}
		
	// To Get a TODO by ID
	@GetMapping("/getProduct")
	public ResponseEntity<?> getProductById(@RequestBody Ecommerce ecommerce) {
		Ecommerce ecommerce2 = eService.getProductById(ecommerce);
		
		if(ecommerce2 == null)
			return	new ResponseEntity<String>("Todo Item doesn't exist with given ID", HttpStatus.NOT_FOUND);
		else
			return	new ResponseEntity<Ecommerce>(ecommerce2, HttpStatus.OK);
	
		
	
	}
	
	@GetMapping("/getByType")
	public ResponseEntity<?> getProductByType(@RequestBody Ecommerce ecommerce) {
		return	new ResponseEntity<List<Ecommerce>>(eService.getProductByType(ecommerce), HttpStatus.OK);
		
	
		
	
	}
	
	@PutMapping("/updateproduct/{id}")
	public ResponseEntity<?> updateWebseries(@PathVariable String id, @RequestBody Ecommerce ecommerce) {
		if(eService.updateProduct(id, ecommerce))
			return new ResponseEntity<Ecommerce>(eService.getProductByIdu(id), HttpStatus.OK);
		else
			return new ResponseEntity<String>("Bad Request", HttpStatus.BAD_REQUEST);
	}
	
	// To Delete a TODO by ID
	@DeleteMapping("/deleteProduct")
	public String deleteWebseriesById(@RequestBody Ecommerce ecommerce) {
		if(eService.deleteProduct(ecommerce))
//			System.out.println("Series Removed "+id);
//			return HttpStatus.NO_CONTENT;
			return "Product Removed "+ecommerce.getProductId();
		
	
		return "internal server error";
//		return	HttpStatus.INTERNAL_SERVER_ERROR;
	}

}
