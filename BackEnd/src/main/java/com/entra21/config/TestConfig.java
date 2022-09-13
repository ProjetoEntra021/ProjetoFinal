package com.entra21.config;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.entra21.entities.Address;
import com.entra21.entities.Booking;
import com.entra21.entities.Category;
import com.entra21.entities.Client;
import com.entra21.entities.Rental;
import com.entra21.entities.Vehicle;
import com.entra21.entities.enums.BookingStatus;
import com.entra21.entities.enums.RentalStatus;
import com.entra21.entities.enums.VehicleStatus;
import com.entra21.repositories.AddressRepository;
import com.entra21.repositories.BookingRepository;
import com.entra21.repositories.CategoryRepository;
import com.entra21.repositories.ClientRepository;
import com.entra21.repositories.RentalRepository;
import com.entra21.repositories.VehicleRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private RentalRepository rentalRepository;
	
	@Override
	public void run(String... args) throws Exception {

		Client c1 = new Client(null, "Mateus", "12312312312", "1233456", Instant.now());
		
		clientRepository.save(c1);
		
		Address ad1 = new Address(null, "88040425", "Servidão Maria R", "Trinda", "186", "Casa 163", c1);
		
		addressRepository.save(ad1);
				
		Category cat1 = new Category(null, 150.00, 700.00);
		
		categoryRepository.save(cat1);
		
		Booking bk1 = new Booking(null, c1, Instant.parse("2005-10-20T00:00:00Z"), Instant.parse("2005-10-30T00:00:00Z"), cat1.getDayPrice(), cat1.getWeekPrice(), cat1 , BookingStatus.ACTIVE, null);

		bookingRepository.save(bk1);
		
		Vehicle v1 = new Vehicle(null, "ABC1234", "11222333333", 10000.00, Instant.parse("2000-10-10T00:00:00Z") , cat1, VehicleStatus.AVAILABLE);
		
		vehicleRepository.save(v1);
		
		Rental r1 = new Rental(null, bk1.getPickUpDate(), bk1.getDropOffDate(), RentalStatus.PENDING, bk1, v1, null);
		
		rentalRepository.save(r1);
	}

}
