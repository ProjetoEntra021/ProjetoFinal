package com.entra21.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.entra21.entities.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long>{

	@Query("select v from Vehicle v where v.company.id = ?1")
	List<Vehicle> findAllByCompany(Long companyId);
}
