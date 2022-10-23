package com.entra21.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entra21.entities.Rental;
import com.entra21.entities.Vehicle;

import com.entra21.entities.VehicleExpense;
import com.entra21.entities.dto.VehicleDashDTO;
import com.entra21.entities.enums.VehicleStatus;
import com.entra21.entities.VehicleRevenue;

import com.entra21.exceptions.ResourceNotFoundException;
import com.entra21.repositories.VehicleRepository;
import com.entra21.repositories.VehicleRevenueRepository;

@Service
public class VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Autowired
	private PaymentService paymentService;
  
  @Autowired
	private VehicleRevenueRepository revenueRepository;


	public List<Vehicle> findAll() {
		return vehicleRepository.findAll();
	}

	public Vehicle findById(Long id) {
		Optional<Vehicle> obj = vehicleRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Vehicle insert(Vehicle obj) {
		return vehicleRepository.save(obj);
	}

	public void delete(Long id) {
		vehicleRepository.deleteById(id);
	}

	public Vehicle update(Long id, Vehicle obj) {
		Vehicle entity = vehicleRepository.getReferenceById(id);
		updateData(entity, obj);
		return vehicleRepository.save(entity);
	}

	private void updateData(Vehicle entity, Vehicle obj) {
		entity.setLicensePlate(obj.getLicensePlate());
		entity.setChassi(obj.getChassi());
		entity.setMileage(obj.getMileage());
		entity.setVehicleYear(obj.getVehicleYear());
		entity.setVehicleStatus(obj.getVehicleStatus());
		entity.setCategory(obj.getCategory());
		entity.setVehicleModel(obj.getVehicleModel());
	}


	public VehicleDashDTO findData() {
		List<Vehicle> vehicles = vehicleRepository.findAll();
		LocalDate hoje = LocalDate.now();
		VehicleDashDTO data = new VehicleDashDTO();
		Double dataExpense = 0.0;
		for (Vehicle v : vehicles) {
			for (VehicleExpense expense : v.getExpenses()) {
				if (expense.getDate().isAfter(hoje.minusMonths(1))) {
					dataExpense += expense.getValue();
				}	
			}
		}
		data.setMonthExpense(dataExpense);
		data.setMonthBilling(paymentService.totalPaymentsReceived());
		data.setTotalPenddingPayments(paymentService.totalPenddingPayments());
		data.setNextBilling(paymentService.nextPayments());
		return data;
	}

	
	public void addVehicleRevenue(Rental obj, Double paymentValue) {
		Long vehicleId = obj.getVehicle().getId();
		Vehicle vh = vehicleRepository.findById(vehicleId).get();
		VehicleRevenue vr = new VehicleRevenue(null, "Pagamento de locação", LocalDate.now(), paymentValue, vh);
		revenueRepository.save(vr);
	}

}
