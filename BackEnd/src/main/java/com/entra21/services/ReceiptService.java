package com.entra21.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entra21.entities.Receipt;
import com.entra21.exceptions.ResourceNotFoundException;
import com.entra21.repositories.ReceiptRepository;

@Service
public class ReceiptService {

	@Autowired
	private ReceiptRepository receiptRepository;

	public List<Receipt> findAll() {
		return receiptRepository.findAll();
	}

	public Receipt findById(Long id) {
		Optional<Receipt> obj = receiptRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Receipt insert(Receipt obj) {
		return receiptRepository.save(obj);
	}

	public void delete(Long id) {
		receiptRepository.deleteById(id);
	}

	public Receipt update(Long id, Receipt obj) {
		Receipt entity = receiptRepository.getReferenceById(id);
		updateData(entity, obj);
		return receiptRepository.save(entity);
	}

	private void updateData(Receipt entity, Receipt obj) {
		entity.setRental(obj.getRental());
		entity.setDiscount(obj.getDiscount());
		entity.setTotalValue(obj.getTotalValue());
	}
}
