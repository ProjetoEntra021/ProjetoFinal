package com.entra21.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entra21.entities.Contact;
import com.entra21.exceptions.ResourceNotFoundException;
import com.entra21.repositories.ContactRepository;

@Service
public class ContactService {

	@Autowired
	private ContactRepository contactRepository;

	public List<Contact> findAll() {
		return contactRepository.findAll();
	}

	public Contact findById(Long id) {
		Optional<Contact> obj = contactRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Contact insert(Contact obj) {
		return contactRepository.save(obj);
	}

	public void delete(Long id) {
		contactRepository.deleteById(id);
	}

	public Contact update(Long id, Contact obj) {
		Contact entity = contactRepository.getReferenceById(id);
		updateData(entity, obj);
		return contactRepository.save(entity);
	}

	private void updateData(Contact entity, Contact obj) {
		entity.setContactType(obj.getContactType());
		entity.setDescription(obj.getDescription());
		entity.setClient(obj.getClient());
	}
}
