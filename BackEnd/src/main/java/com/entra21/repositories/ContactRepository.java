package com.entra21.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entra21.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long>{

}
