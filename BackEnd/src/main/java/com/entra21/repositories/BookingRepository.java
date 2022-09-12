package com.entra21.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entra21.entities.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long>{

}
