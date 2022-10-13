package com.entra21.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.entra21.entities.VehicleExpense;
import com.entra21.entities.dto.VehicleExpenseDTO;
import com.entra21.services.VehicleExpenseService;

@RestController
@RequestMapping(value="/api/vehicleExpenses")
public class VehicleExpenseController {

	@Autowired
	private VehicleExpenseService service;
	

	@GetMapping
	public ResponseEntity<List<VehicleExpense>> findAll(){
		List<VehicleExpense> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<VehicleExpense> findById(@PathVariable Long id){
		VehicleExpense obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<VehicleExpense> insert(@RequestBody VehicleExpenseDTO obj){
		VehicleExpense ve = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ve.getId()).toUri();
		return ResponseEntity.created(uri).body(ve);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<VehicleExpense> update(@PathVariable Long id, @RequestBody VehicleExpense obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
