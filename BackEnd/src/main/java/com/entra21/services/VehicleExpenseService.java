package com.entra21.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entra21.entities.VehicleExpense;
import com.entra21.exceptions.ResourceNotFoundException;
import com.entra21.repositories.VehicleExpenseRepository;

@Service
public class VehicleExpenseService {

	@Autowired
	private VehicleExpenseRepository vehicleExpenseRepository;

	public List<VehicleExpense> findAll() {
		return vehicleExpenseRepository.findAll();
	}

	public VehicleExpense findById(Long id) {
		Optional<VehicleExpense> obj = vehicleExpenseRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public VehicleExpense insert(VehicleExpense obj) {
		return vehicleExpenseRepository.save(obj);
	}

	public void delete(Long id) {
		vehicleExpenseRepository.deleteById(id);
	}

	public VehicleExpense update(Long id, VehicleExpense obj) {
		VehicleExpense entity = vehicleExpenseRepository.getReferenceById(id);
		updateData(entity, obj);
		return vehicleExpenseRepository.save(entity);
	}

	private void updateData(VehicleExpense entity, VehicleExpense obj) {
		entity.setValue(obj.getValue());
		entity.setVehicle(obj.getVehicle());
		entity.setDescription(obj.getDescription());
	}
}
