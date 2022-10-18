package com.entra21.services;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PatchMapping;

import com.entra21.entities.Booking;
import com.entra21.entities.Payment;
import com.entra21.entities.Rental;
import com.entra21.entities.Vehicle;
import com.entra21.entities.dto.RentalAddDTO;
import com.entra21.entities.enums.PaymentStatus;
import com.entra21.entities.enums.RentalStatus;
import com.entra21.entities.enums.RentalType;
import com.entra21.exceptions.InvalidRentalPeriodException;
import com.entra21.exceptions.ResourceNotFoundException;
import com.entra21.repositories.BookingRepository;
import com.entra21.repositories.RentalRepository;
import com.entra21.repositories.VehicleRepository;

@Service
public class RentalService {

	@Autowired
	private RentalRepository rentalRepository;
	
	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Autowired
	private PaymentService paymentService;

	public List<Rental> findAll() {
		return rentalRepository.findAll();
	}

	public Rental findById(Long id) {
		Optional<Rental> obj = rentalRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Rental insert(RentalAddDTO obj) {
		Vehicle ve = vehicleRepository.findById(obj.getVehicleId()).get();
		Booking bo = bookingRepository.findById(obj.getBookingId()).get();
		Rental objRental = new Rental(0L, obj.getRentalType(), obj.getPickUpDate(), obj.getDropOffDate(), RentalStatus.ACTIVE, obj.getTotalValue(), bo, ve, new ArrayList<Payment>(), null);
		if(objRental.getRentalType() == RentalType.APP_DRIVER) {
			if(calculateRentalPeriod(objRental).getDays() % 7 == 0) {
				calculateAppPayments(objRental);
			}
			else {
				throw new InvalidRentalPeriodException();
			}
		} 
		else {
			createPersonalPayment(objRental);
		}
		
		return rentalRepository.save(objRental);
	}

	public void delete(Long id) {
		rentalRepository.deleteById(id);
	}

	public Rental update(Long id, Rental obj) {
		Rental entity = rentalRepository.getReferenceById(id);
		updateData(entity, obj);
		return rentalRepository.save(entity);
	}
	
	public Rental cancelRental(Long id) {
		LocalDate hoje = LocalDate.now();
		Rental entity = rentalRepository.getReferenceById(id);
		entity.setRentalStatus(RentalStatus.CANCELED);
		for (Payment p: entity.getPayments()) {
			if(p.getExpirationDate().isAfter(hoje) && p.getPaymentStatus() == PaymentStatus.WAITINGPAYMENT) {
				paymentService.cancelPayment(p.getId());
			}	
		}
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
	
	private Period calculateRentalPeriod(Rental obj) {
		Period rentalPeriod = Period.between(obj.getPickUpDate(), obj.getDropOffDate());
		return rentalPeriod;
	}
	
	private void calculateAppPayments(Rental obj) {
		Payment payment;
		Period rentalPeriod = Period.between(obj.getPickUpDate(), obj.getDropOffDate());
		int totalPayments = rentalPeriod.getDays() / 7;
		double paymentValue = obj.getTotalValue() / totalPayments;
		for (int i = 0 ; i < totalPayments; i++) {
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
