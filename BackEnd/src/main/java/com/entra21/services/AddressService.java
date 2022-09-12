package com.entra21.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entra21.entities.Address;
import com.entra21.exceptions.ResourceNotFoundException;
import com.entra21.repositories.AddressRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepository;

	public List<Address> findAll() {
		return addressRepository.findAll();
	}

	public Address findById(Long id) {
		Optional<Address> obj = addressRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Address insert(Address obj) {
		return addressRepository.save(obj);
	}

	public void delete(Long id) {
		addressRepository.deleteById(id);
	}

	public Address update(Long id, Address obj) {
		Address entity = addressRepository.getReferenceById(id);
		updateData(entity, obj);
		return addressRepository.save(entity);
	}

	private void updateData(Address entity, Address obj) {
		entity.setCep(obj.getCep());
		entity.setStreet(obj.getStreet());
		entity.setDistrict(obj.getDistrict());
		entity.setNumber(obj.getNumber());
		entity.setComplement(obj.getComplement());
		entity.setClient(obj.getClient());
	}

}
