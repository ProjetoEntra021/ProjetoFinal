package com.entra21.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.entra21.entities.Payment;
import com.entra21.entities.Vehicle;
import com.entra21.entities.VehicleRevenue;
import com.entra21.entities.enums.PaymentStatus;
import com.entra21.exceptions.ResourceNotFoundException;
import com.entra21.repositories.PaymentRepository;
import com.entra21.repositories.VehicleRepository;
import com.entra21.repositories.VehicleRevenueRepository;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private VehicleRevenueRepository revenueRepository;

	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Autowired
	private RentalService rentalService;
	
	public List<Payment> findAll() {
		return paymentRepository.findAll();
	}

	public Payment findById(Long id) {
		Optional<Payment> obj = paymentRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Payment insert(Payment obj) {
		return paymentRepository.save(obj);
	}

	public void delete(Long id) {
		paymentRepository.deleteById(id);
	}

	public Payment update(Long id, Payment obj) {
		Payment entity = paymentRepository.getReferenceById(id);
		updateData(entity, obj);
		return paymentRepository.save(entity);
	}
	
	public Payment confirmPayment(Long id) {
		Payment entity = paymentRepository.getReferenceById(id);
		entity.setPaymentStatus(PaymentStatus.PAID);
		Long vehicleId = entity.getRental().getVehicle().getId();
		Vehicle vh = vehicleRepository.findById(vehicleId).get();
		VehicleRevenue vr = new VehicleRevenue(null, "Pagamento de locação", LocalDate.now(), entity.getPaymentValue(), vh);
		revenueRepository.save(vr);
		rentalService.checkRentalFinishStatus(entity.getRental());
		return paymentRepository.save(entity);
	}
	

	private void updateData(Payment entity, Payment obj) {
		entity.setExpirationDate(obj.getExpirationDate());
		entity.setPaymentStatus(obj.getPaymentStatus());
		entity.setPaymentValue(obj.getPaymentValue());
		entity.setDiscount(obj.getDiscount());
		entity.setRental(obj.getRental());
		//Receipt receives the rental
		//Payment receives the booking
	}
	
	@Scheduled(cron="0 0 0 * * *")
	public void updatePaymentStatus() {
		List<Payment> payments = paymentRepository.findAll();
		for(Payment payment : payments) {
			payment.updateStatus();
			paymentRepository.save(payment);
		}
	}
}
