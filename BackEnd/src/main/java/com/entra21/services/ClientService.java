package com.entra21.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entra21.entities.Client;
import com.entra21.exceptions.ResourceNotFoundException;
import com.entra21.repositories.ClientRepository;
import com.entra21.repositories.CompanyRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private CompanyRepository companyRepository;
	
	public List<Client> findAll() {
		return clientRepository.findAll();
	}

	public List<Client> findAllByCompany(Long id) {
		return companyRepository.findById(id).get().getClients();
	}
	
	public Client findById(Long id) {
		Optional<Client> obj = clientRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Client findByCpf(String cpf) {
		Optional<Client> obj = Optional.ofNullable(clientRepository.findByCpf(cpf));
		return obj.orElseThrow(() -> new ResourceNotFoundException(cpf));
	}

	public Client insert(Client obj) {
		obj.getAddresses().forEach((address) -> address.setClient(obj));
		obj.getContacts().forEach((contact) -> contact.setClient(obj));
		return clientRepository.save(obj);
	}

	public void delete(Long id) {
		clientRepository.deleteById(id);
	}

	public Client update(Long id, Client obj) {
		Client entity = clientRepository.getReferenceById(id);
		updateData(entity, obj);
		return clientRepository.save(entity);
	}

	private void updateData(Client entity, Client obj) {
		entity.setName(obj.getName());
		entity.setCpf(obj.getCpf());
		entity.setCnh(obj.getCnh());
		entity.setBirthDate(obj.getBirthDate());
	}
}
