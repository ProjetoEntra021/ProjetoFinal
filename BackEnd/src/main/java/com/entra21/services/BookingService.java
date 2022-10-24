package com.entra21.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.entra21.entities.Booking;
import com.entra21.entities.enums.BookingStatus;
import com.entra21.exceptions.ResourceNotFoundException;
import com.entra21.repositories.BookingRepository;
import com.entra21.repositories.CompanyRepository;

@Service
public class BookingService {
	
	@Autowired
	private BookingRepository bookingRepository;

	@Autowired
	private CompanyRepository companyRepository;
	
	public List<Booking> findAll() {
		return bookingRepository.findAll();
	}

	public List<Booking> findAllByCompany(Long id) {
		return companyRepository.findById(id).get().getBookings();
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
		entity.setPreviewPrice(obj.getPreviewPrice());
		//Rental receives the booking, so there's no need to add rental here
	}
	public Booking cancelBooking(Long id) {
		Booking entity = bookingRepository.getReferenceById(id);
		entity.setBookingStatus(BookingStatus.CANCELED);
		
		return bookingRepository.save(entity);
	}
	
	@Scheduled(cron="0 0 0 * * *")
	public void updateBookingStatus() {
		List<Booking> bookings = bookingRepository.findAll();
		for(Booking booking : bookings) {
			booking.updateStatus();
			bookingRepository.save(booking);
		}
	}
}
