package com.entra21.config;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.entra21.entities.Address;
import com.entra21.entities.Booking;
import com.entra21.entities.Category;
import com.entra21.entities.Client;
import com.entra21.entities.Contact;
import com.entra21.entities.Payment;
import com.entra21.entities.Rental;
import com.entra21.entities.Vehicle;
import com.entra21.entities.VehicleExpense;
import com.entra21.entities.VehicleRevenue;
import com.entra21.entities.enums.BookingStatus;
import com.entra21.entities.enums.ContactType;
import com.entra21.entities.enums.GenderType;
import com.entra21.entities.enums.PaymentStatus;
import com.entra21.entities.enums.RentalStatus;
import com.entra21.entities.enums.VehicleStatus;
import com.entra21.repositories.AddressRepository;
import com.entra21.repositories.BookingRepository;
import com.entra21.repositories.CategoryRepository;
import com.entra21.repositories.ClientRepository;
import com.entra21.repositories.ContactRepository;
import com.entra21.repositories.PaymentRepository;
import com.entra21.repositories.RentalRepository;
import com.entra21.repositories.VehicleExpenseRepository;
import com.entra21.repositories.VehicleRepository;
import com.entra21.repositories.VehicleRevenueRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
		
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	
	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private ContactRepository contactRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private VehicleRepository vehicleRepository;

	@Autowired
	private BookingRepository bookingRepository;

	@Autowired
	private RentalRepository rentalRepository;

	@Autowired
	private VehicleExpenseRepository vehicleERepository;
	
	@Autowired
	private VehicleRevenueRepository vehicleRRepository;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Override
	public void run(String... args) throws Exception {

		// create test registration client Mateus
		Client c1 = new Client(null, "Mateus", "12312312312", "1233456", LocalDate.parse("01/10/1999", formatter), GenderType.MASCULINO);

		clientRepository.save(c1);

		Address ad1 = new Address(null, "88040425", "Servidão Maria R", "Trinda", "186", "Casa 163", "Florianopolis", "SC", c1);

		addressRepository.save(ad1);
		
		Contact ct1 = new Contact(null, ContactType.EMAIL, "mateus@gmail.com", c1);
		Contact ct2 = new Contact(null, ContactType.PHONE, "48988765432", c1);
		
		contactRepository.saveAll(Arrays.asList(ct1, ct2));

		Category cat1 = new Category(null, "Hatch-Back", 450.00, 70.00);
		
		Category cat2 = new Category(null, "Sedã", 550.00, 90.00);
		
		Category cat3 = new Category(null, "Sedã Luxo", 700.00, 110.00);

		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

		Booking bk1 = new Booking(null, c1, LocalDate.parse("2005-10-05"),
				LocalDate.parse("2005-10-10"), cat1.getDayPrice(), cat1.getWeekPrice(), cat1,
				BookingStatus.ACTIVE, null);

		bookingRepository.save(bk1);

		Vehicle v1 = new Vehicle(null, "Corsa", "ABC1234", "11222333333", 10000.00, "120983190",
				"2010", cat1, VehicleStatus.AVAILABLE);

		Vehicle v2 = new Vehicle(null, "Sandero", "DEF5678", "11222333333", 10000.00, "120983190",
				"2011", cat1, VehicleStatus.AVAILABLE);

		Vehicle v3 = new Vehicle(null, "Ka", "ABC1234", "11222333333", 10000.00, "120983190",
				"2012", cat1, VehicleStatus.AVAILABLE);

		Vehicle v4 = new Vehicle(null, "Kwid", "ABC1234", "11222333333", 10000.00, "120983190",
				"2013", cat3, VehicleStatus.AVAILABLE);

		Vehicle v5 = new Vehicle(null, "Palio", "DEF5678", "11222333333", 10000.00, "120983190",
				"2014", cat1, VehicleStatus.DISABLE);

		Vehicle v6 = new Vehicle(null, "Vectra", "ABC1234", "11222333333", 10000.00, "120983190",
				"2009", cat2, VehicleStatus.UNAVAILABLE);

		Vehicle v7 = new Vehicle(null, "Gol", "DEF5678", "11222333333", 10000.00, "120983190",
				"2010", cat1, VehicleStatus.MAINTENANCE);

		Vehicle v8 = new Vehicle(null, "Corsa", "ABC1234", "11222333333", 10000.00, "120983190",
				"2010", cat1, VehicleStatus.AVAILABLE);

		Vehicle v9 = new Vehicle(null, "Sandero", "DEF5678", "11222333333", 10000.00, "120983190",
				"2010", cat1, VehicleStatus.AVAILABLE);

		Vehicle v10 = new Vehicle(null, "Ka", "ABC1234", "11222333333", 10000.00, "120983190",
				"2010", cat1, VehicleStatus.AVAILABLE);

		Vehicle v11 = new Vehicle(null, "Kwid", "ABC1234", "11222333333", 10000.00, "120983190",
				"2010", cat1, VehicleStatus.AVAILABLE);

		Vehicle v12 = new Vehicle(null, "Palio", "DEF5678", "11222333333", 10000.00, "120983190",
				"2010", cat1, VehicleStatus.DISABLE);

		Vehicle v13 = new Vehicle(null, "Vectra", "ABC1234", "11222333333", 10000.00, "120983190",
				"2010", cat1, VehicleStatus.UNAVAILABLE);

		Vehicle v14 = new Vehicle(null, "Gol", "DEF5678", "11222333333", 10000.00, "120983190",
				"2010", cat1, VehicleStatus.MAINTENANCE);

		vehicleRepository.saveAll(Arrays.asList(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14));
		
		VehicleExpense ve1 = new VehicleExpense(null, "Revisão 5000km", LocalDate.now(), 110.00 , v1);
		
		VehicleRevenue vr1 = new VehicleRevenue(null, "Aluguel 1 semana", LocalDate.now(), 500.00 , v1);
		
		VehicleExpense ve2 = new VehicleExpense(null, "Revisão 10000km", LocalDate.now(), 130.00 , v1);
		
		VehicleRevenue vr2 = new VehicleRevenue(null, "Aluguel 2 semanas", LocalDate.now(), 1000.00 , v1);
		
		vehicleERepository.saveAll(Arrays.asList(ve1, ve2));
		
		vehicleRRepository.saveAll(Arrays.asList(vr1, vr2));
		
		Rental r1 = new Rental(null, bk1.getPickUpDate(), bk1.getDropOffDate(), RentalStatus.PENDING, bk1, v1, null, null);
		rentalRepository.save(r1);
		
		Payment pay1 = new Payment(null, LocalDate.parse("15/11/2022", formatter), 700.00, 0.00, PaymentStatus.WAITINGPAYMENT, r1);
		Payment pay2 = new Payment(null, LocalDate.parse("15/12/2022", formatter), 700.00, 0.00, PaymentStatus.WAITINGPAYMENT, r1);
		Payment pay3 = new Payment(null, LocalDate.parse("15/01/2023", formatter), 700.00, 0.00, PaymentStatus.WAITINGPAYMENT, r1);
		
		paymentRepository.saveAll(Arrays.asList(pay1,pay2,pay3));
		

		// create test registration client Pablo
		Client c2 = new Client(null, "Pablo", "00443990905", "386985233",  LocalDate.parse("24/07/1980", formatter), GenderType.MASCULINO);

		clientRepository.save(c2);

		Address ad2 = new Address(null, "88095000", "Av Marinheiro Max Schramm", "Estreito", "2428", "Bloco 4 Apto 301",
				"Florianopolis", "SC", c2);

		addressRepository.save(ad2);
		
		Contact ct3 = new Contact(null, ContactType.EMAIL, "pablompamplona@gmail.com", c2);
		Contact ct4 = new Contact(null, ContactType.PHONE, "48988328778", c2);
		
		contactRepository.saveAll(Arrays.asList(ct3, ct4));

		Booking bk2 = new Booking(null, c2, LocalDate.parse("2005-10-20"),
				LocalDate.parse("2005-10-30"), cat1.getDayPrice(), cat1.getWeekPrice(), cat1,
				BookingStatus.ACTIVE, null);

		bookingRepository.save(bk2);

	}

	
	

}
