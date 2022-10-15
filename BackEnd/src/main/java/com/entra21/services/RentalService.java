package com.entra21.services;

import java.time.Period;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entra21.entities.Payment;
import com.entra21.entities.Rental;
import com.entra21.entities.enums.PaymentStatus;
import com.entra21.entities.enums.RentalType;
import com.entra21.exceptions.ResourceNotFoundException;
import com.entra21.repositories.RentalRepository;

@Service
public class RentalService {

	@Autowired
	private RentalRepository rentalRepository;

	public List<Rental> findAll() {
		return rentalRepository.findAll();
	}

	public Rental findById(Long id) {
		Optional<Rental> obj = rentalRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Rental insert(Rental obj) {
		if(obj.getRentalType() == RentalType.APP_DRIVER) {
			calculateAppPayments(obj);
		} 
		else {
			createPersonalPayment(obj);
		}
		return rentalRepository.save(obj);
	}

	public void delete(Long id) {
		rentalRepository.deleteById(id);
	}

	public Rental update(Long id, Rental obj) {
		Rental entity = rentalRepository.getReferenceById(id);
		updateData(entity, obj);
		return rentalRepository.save(entity);
	}

	private void updateData(Rental entity, Rental obj) {
		entity.setPickUpDate(obj.getPickUpDate());
		entity.setDropOffDate(obj.getDropOffDate());
		entity.setRentalStatus(obj.getRentalStatus());
		entity.setVehicle(obj.getVehicle());
		entity.setBooking(obj.getBooking());
		//Receipt receives the rental
		//Rental receives the booking
	}
	
	private void calculateAppPayments(Rental obj) {
		Payment payment;
		Period rentalPeriod = Period.between(obj.getPickUpDate(), obj.getDropOffDate());
		int totalPayments = rentalPeriod.getDays() / 7;
		double paymentValue = obj.getTotalValue() / totalPayments;
		for (int i = 1 ; i <= totalPayments; i++) {
			payment = new Payment(null, obj.getPickUpDate().plusWeeks(i), paymentValue, 0.0, 
					PaymentStatus.WAITINGPAYMENT, obj);
			obj.getPayments().add(payment);
		}
	}
	
	private void createPersonalPayment(Rental obj) {
		Payment payment = new Payment(null, obj.getPickUpDate(), obj.getTotalValue(), 0.0, 
				PaymentStatus.WAITINGPAYMENT, obj);
		obj.getPayments().add(payment);
		
	}
}
