package com.entra21.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entra21.entities.Payment;
import com.entra21.exceptions.ResourceNotFoundException;
import com.entra21.repositories.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;

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

	private void updateData(Payment entity, Payment obj) {
		entity.setExpirationDate(obj.getExpirationDate());
		entity.setPaymentStatus(obj.getPaymentStatus());
		entity.setPaymentValue(obj.getPaymentValue());
		entity.setDiscount(obj.getDiscount());
		entity.setRental(obj.getRental());
		//Receipt receives the rental
		//Payment receives the booking
	}
}
