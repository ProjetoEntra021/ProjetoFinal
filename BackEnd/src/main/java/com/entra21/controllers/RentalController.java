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

import com.entra21.entities.Booking;
import com.entra21.entities.Rental;
import com.entra21.entities.dto.RentalAddDTO;
import com.entra21.services.RentalService;

@RestController
@RequestMapping(value="/api/rentals")
public class RentalController {

	@Autowired
	private RentalService service;
	

	@GetMapping
	public ResponseEntity<List<Rental>> findAll(){
		List<Rental> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="company/{companyId}")
	public ResponseEntity<List<Rental>> findAllByCompany(@PathVariable Long companyId){
		List<Rental> list = service.findAllByCompany(companyId);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Rental> findById(@PathVariable Long id){
		Rental obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Rental> insert(@RequestBody RentalAddDTO obj){
		Rental objRental = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objRental.getId()).toUri();
		return ResponseEntity.created(uri).body(objRental);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Rental> update(@PathVariable Long id, @RequestBody Rental obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
	@PatchMapping(value = "/{id}")
	public ResponseEntity<Rental> cancelRental(@PathVariable Long id) {
		Rental obj = service.cancelRental(id);
		return  ResponseEntity.ok().body(obj);
		
	}
}
