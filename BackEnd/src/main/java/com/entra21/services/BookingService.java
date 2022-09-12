package com.entra21.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entra21.entities.Booking;
import com.entra21.exceptions.ResourceNotFoundException;
import com.entra21.repositories.BookingRepository;

@Service
public class BookingService {
	
	@Autowired
	private BookingRepository bookingRepository;

	public List<Booking> findAll() {
		return bookingRepository.findAll();
	}

	public Booking findById(Long id) {
		Optional<Booking> obj = bookingRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Booking insert(Booking obj) {
		return bookingRepository.save(obj);
	}

	public void delete(Long id) {
		bookingRepository.deleteById(id);
	}

	public Booking update(Long id, Booking obj) {
		Booking entity = bookingRepository.getReferenceById(id);
		updateData(entity, obj);
		return bookingRepository.save(entity);
	}

	private void updateData(Booking entity, Booking obj) {
		entity.setClient(obj.getClient());
		entity.setPickUpDate(obj.getPickUpDate());
		entity.setDropOffDate(obj.getDropOffDate());
		entity.setDayPrice(obj.getDayPrice());
		entity.setWeekPrice(obj.getWeekPrice());
		entity.setCategory(obj.getCategory());
		entity.setBookingStatus(obj.getBookingStatus());
		//Rental receives the booking, so there's no need to add rental here
	}
}
