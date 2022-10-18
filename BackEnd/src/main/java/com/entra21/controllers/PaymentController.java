package com.entra21.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.entra21.entities.Payment;
import com.entra21.services.PaymentService;

@RestController
@RequestMapping(value="/api/payments")
public class PaymentController {

	@Autowired
	private PaymentService service;
	

	@GetMapping
	public ResponseEntity<List<Payment>> findAll(){
		List<Payment> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Payment> findById(@PathVariable Long id){
		Payment obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Payment> insert(@RequestBody Payment obj){
		Payment objPayment = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objPayment.getId()).toUri();
		return ResponseEntity.created(uri).body(objPayment);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Payment> update(@PathVariable Long id, @RequestBody Payment obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
	@PatchMapping(value = "/{id}")
	public ResponseEntity<Payment> confirmPayment(@PathVariable Long id) {
		Payment obj = service.confirmPayment(id);
		return ResponseEntity.ok().body(obj);
	}
	
		
	
	
}
