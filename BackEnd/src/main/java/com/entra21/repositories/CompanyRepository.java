package com.entra21.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entra21.entities.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
