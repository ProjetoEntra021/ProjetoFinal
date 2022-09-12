package com.entra21.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entra21.entities.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long>{

}
