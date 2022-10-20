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
import com.entra21.services.BookingService;

@RestController
@RequestMapping(value = "/api/bookings/")
public class BookingController {
	
	@Autowired
	private BookingService service;
	
	@GetMapping
	public ResponseEntity<List<Booking>> findAll(){
		List<Booking> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Booking> findById(@PathVariable Long id){
		Booking obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Booking> insert(@RequestBody Booking obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Booking> update(@PathVariable Long id, @RequestBody Booking obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	@PatchMapping(value = "/{id}")
	public ResponseEntity<Booking> cancelBooking(@PathVariable Long id){
		Booking obj = service.cancelBooking(id);
		return ResponseEntity.ok().body(obj);
	}
	

}
