package com.entra21.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entra21.entities.Rental;
import com.entra21.entities.Vehicle;
import com.entra21.entities.VehicleRevenue;
import com.entra21.exceptions.ResourceNotFoundException;
import com.entra21.repositories.VehicleRepository;
import com.entra21.repositories.VehicleRevenueRepository;

@Service
public class VehicleRevenueService {

	@Autowired
	private VehicleRevenueRepository vehicleRevenueRepository;
	
	@Autowired
	private VehicleRepository vehicleRepository;

	public List<VehicleRevenue> findAll() {
		return vehicleRevenueRepository.findAll();
	}

	public VehicleRevenue findById(Long id) {
		Optional<VehicleRevenue> obj = vehicleRevenueRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public VehicleRevenue insert(VehicleRevenue obj) {
		return vehicleRevenueRepository.save(obj);
	}

	public void delete(Long id) {
		vehicleRevenueRepository.deleteById(id);
	}

	public VehicleRevenue update(Long id, VehicleRevenue obj) {
		VehicleRevenue entity = vehicleRevenueRepository.getReferenceById(id);
		updateData(entity, obj);
		return vehicleRevenueRepository.save(entity);
	}

	private void updateData(VehicleRevenue entity, VehicleRevenue obj) {
		entity.setValue(obj.getValue());
		entity.setVehicle(obj.getVehicle());
		entity.setDescription(obj.getDescription());
	}
	
	public void addVehicleRevenue(Rental obj, Double paymentValue) {
		Long vehicleId = obj.getVehicle().getId();
		Vehicle vh = vehicleRepository.findById(vehicleId).get();
		VehicleRevenue vr = new VehicleRevenue(null, "Pagamento de locação", LocalDate.now(), paymentValue, vh);
		vehicleRevenueRepository.save(vr);
	}
}
