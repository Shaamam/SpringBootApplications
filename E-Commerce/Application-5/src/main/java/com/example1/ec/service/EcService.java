package com.example1.ec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example1.ec.model.Ecommerce;
import com.example1.ec.repository.EcRepository;

@Service
public class EcService {
	
	@Autowired
	EcRepository eRepository;
	
	
	public List<Ecommerce> getProductByType(Ecommerce ecommerce) {
		return (List<Ecommerce>) eRepository.findByType(ecommerce.getType());
	}
	
	public Ecommerce getProductById(Ecommerce ecommerce) {
		return  eRepository.findById(ecommerce.getProductId()).orElse(null);
	}
	
	public Ecommerce getProductByIdu(String id) {
		return  eRepository.findById(id).orElse(null);
	}
	
	
	
	public List<Ecommerce> getProducts() {
		return eRepository.findAll();
	}
	
	public Ecommerce addProduct(Ecommerce ecommerce) {
		try {
			return eRepository.save(ecommerce);
		} catch (Exception e) {
			return null;
		}	
	}
	
	public boolean updateProduct(String id, Ecommerce ecommerce) {
		try {
			if(this.getProductByIdu(id) == null)
				return false;
			return eRepository.save(ecommerce) != null;
		}
		catch (Exception e) {
			return false;
		}
	}
	
	public boolean deleteProduct(Ecommerce ecommerce) {
		try {
			if(this.getProductById(ecommerce) != null)
			eRepository.deleteById(ecommerce.getProductId());
			return true;
		} catch (Exception e) {
			System.out.println("error: " + e);
			return false;
		}	
	}
	
	

}
