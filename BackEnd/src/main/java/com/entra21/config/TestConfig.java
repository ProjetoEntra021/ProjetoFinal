package com.entra21.config;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
import com.entra21.entities.dto.RentalAddDTO;
import com.entra21.entities.enums.BookingStatus;
import com.entra21.entities.enums.ContactType;
import com.entra21.entities.enums.GenderType;
import com.entra21.entities.enums.PaymentStatus;
import com.entra21.entities.enums.RentalStatus;
import com.entra21.entities.enums.RentalType;
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
import com.entra21.services.PaymentService;
import com.entra21.services.RentalService;

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
	private RentalService rentalService;
	
	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private VehicleExpenseRepository vehicleERepository;
	
	@Autowired
	private VehicleRevenueRepository vehicleRRepository;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Override
	public void run(String... args) throws Exception {

		// create test registration client Mateus
		Client c1 = new Client(null, "Mateus Bruscato", "12312312312", "1233456", LocalDate.parse("01/10/1999", formatter), GenderType.MASCULINO);

		clientRepository.save(c1);

		Address ad1 = new Address(null, "88040425", "Servidão Maria R", "Trinda", "Florianopolis", "SC","186", "Casa 163", c1);

		addressRepository.save(ad1);
		
		Contact ct1 = new Contact(null, ContactType.EMAIL, "mateus@gmail.com", c1);
		Contact ct2 = new Contact(null, ContactType.PHONE, "48988765432", c1);
		
		contactRepository.saveAll(Arrays.asList(ct1, ct2));

		Category cat1 = new Category(null, "Hatch-Back", 450.00, 70.00);
		
		Category cat2 = new Category(null, "Sedã", 550.00, 90.00);
		
		Category cat3 = new Category(null, "Sedã Luxo", 700.00, 110.00);

		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

		Booking bk1 = new Booking(null, c1, LocalDate.parse("2022-10-05"),
				LocalDate.parse("2022-10-26"), cat1.getDayPrice(), cat1.getWeekPrice(), cat1,
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
		
		RentalAddDTO r1 = new RentalAddDTO(bk1.getPickUpDate(), bk1.getDropOffDate(), 
				 1350.0, RentalStatus.PENDING, RentalType.APP_DRIVER, bk1.getId(), v1.getId());
		rentalService.insert(r1);
		
//		Payment pay1 = new Payment(null, LocalDate.parse("15/11/2022", formatter), 700.00, 0.00, PaymentStatus.WAITINGPAYMENT, r1);
//		Payment pay2 = new Payment(null, LocalDate.parse("15/12/2022", formatter), 700.00, 0.00, PaymentStatus.WAITINGPAYMENT, r1);
//		Payment pay3 = new Payment(null, LocalDate.parse("15/01/2023", formatter), 700.00, 0.00, PaymentStatus.WAITINGPAYMENT, r1);
//		
//		paymentRepository.saveAll(Arrays.asList(pay1,pay2,pay3));
		

		// create test registration client Pablo
		Client c2 = new Client(null, "Pablo Alexandre M Pamplona", "00443990905", "386985233",  LocalDate.parse("24/07/1980", formatter), GenderType.MASCULINO);	
		Client c3 = new Client(null, "Tatiani Pereira Rodrigues", "08856272278", "999392428",  LocalDate.parse("30/10/1995", formatter), GenderType.FEMININO);
	    Client c4 = new Client(null, "Victor Woleck", "12345678987", "234567854",  LocalDate.parse("03/08/1998", formatter), GenderType.MASCULINO);
	    Client c5 = new Client (null, "Machado de Assis", "53647829304", "476395874", LocalDate.parse("21/06/1839", formatter), GenderType.MASCULINO);
	    Client c6 = new Client (null, "Jorge Amado", "498374950684", "594038475",  LocalDate.parse("10/08/1912", formatter), GenderType.MASCULINO );
	    Client c7 = new Client (null, "Carlos Drummond de Andrade", "94857364758", "456347524", LocalDate.parse("31/10/1902", formatter), GenderType.MASCULINO );
	    Client c8 = new Client (null, "Clarice Lispector", "46374829374", "8495637484", LocalDate.parse("09/12/1977", formatter), GenderType.FEMININO);
        Client c9 = new Client (null, "Cecília Meireles", "3457239865", "47927384591",  LocalDate.parse("01/11/1901", formatter), GenderType.FEMININO);
        Client c10 = new Client (null, "Vinicius de Moraes", "403948726738", "849503728394", LocalDate.parse("19/10/1913", formatter), GenderType.MASCULINO);
        Client c11 = new Client (null, "Lygia Fagundes Telles", "53643429304", "476378874", LocalDate.parse("19/04/1917", formatter), GenderType.FEMININO);
	    Client c12 = new Client (null, "Moacyr Scliar", "498374950666", "594066475",  LocalDate.parse("23/03/1937", formatter), GenderType.MASCULINO );
	    Client c13 = new Client (null, "Conceição Evaristo", "94857364754", "456347526", LocalDate.parse("30/10/1946", formatter), GenderType.FEMININO );
	    Client c14 = new Client (null, "Lima Barreto", "46374829374", "8495637484", LocalDate.parse("09/12/1881", formatter), GenderType.MASCULINO);
        Client c15 = new Client (null, "Lygia Fagundes Teles ", "3457239095", "47927544591",  LocalDate.parse("01/11/1923", formatter), GenderType.FEMININO);
	    clientRepository.saveAll(Arrays.asList(c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15));
        

		Address ad2 = new Address(null, "88095000", "Av Marinheiro Max Schramm", "Estreito", "Florianopolis", "SC", "2428", "Bloco 4 Apto 301",
				 c2);
		
		
		addressRepository.save(ad2);
		
		Contact ct3 = new Contact(null, ContactType.EMAIL, "pablompamplona@gmail.com", c2);
		Contact ct4 = new Contact(null, ContactType.PHONE, "48988328778", c2);
		Contact ct5 = new Contact (null, ContactType.EMAIL,"rodriguespereiratatiani@gmail.com", c3);
		
		contactRepository.saveAll(Arrays.asList(ct3, ct4, ct5));

		Booking bk2 = new Booking(null, c2, LocalDate.parse("2005-10-20"),
				LocalDate.parse("2005-10-30"), cat1.getDayPrice(), cat1.getWeekPrice(), cat1,
				BookingStatus.ACTIVE, null);
		Booking bk6 = new Booking(null, c2, LocalDate.parse("2022-03-13"),
				LocalDate.parse("2022-07-13"), cat1.getDayPrice(), cat1.getWeekPrice(), cat1,
				BookingStatus.FINISHED, null);
		Booking bk3 = new Booking(null, c3, LocalDate.parse("2022-10-30"),
				LocalDate.parse("2022-12-30"), cat1.getDayPrice(), cat1.getWeekPrice(), cat1,
				BookingStatus.CANCELED, null);
		Booking bk4 = new Booking(null, c3, LocalDate.parse("2022-10-22"),
				LocalDate.parse("2022-11-22"), cat1.getDayPrice(), cat1.getWeekPrice(), cat1,
				BookingStatus.PENDING, null);
		Booking bk5 = new Booking(null, c3, LocalDate.parse("2022-10-20"),
				LocalDate.parse("2022-12-27"), cat1.getDayPrice(), cat1.getWeekPrice(), cat1,
				BookingStatus.PENDING, null);
		Booking bk7 = new Booking(null, c4, LocalDate.parse("2022-11-20"),
				LocalDate.parse("2023-11-20"), cat1.getDayPrice(), cat1.getWeekPrice(), cat1,
				BookingStatus.ACTIVE, null);
		Booking bk8 = new Booking(null, c4, LocalDate.parse("2022-10-30"),
				LocalDate.parse("2023-03-30"), cat1.getDayPrice(), cat1.getWeekPrice(), cat1,
				BookingStatus.ACTIVE, null);
		Booking bk9 = new Booking(null, c5, LocalDate.parse("2005-10-20"),
				LocalDate.parse("2005-10-30"), cat1.getDayPrice(), cat1.getWeekPrice(), cat1,
				BookingStatus.FINISHED, null);
		Booking bk10 = new Booking(null, c6, LocalDate.parse("2022-10-30"),
				LocalDate.parse("2023-04-30"), cat1.getDayPrice(), cat1.getWeekPrice(), cat1,
				BookingStatus.CANCELED, null);
		Booking bk11 = new Booking(null, c7, LocalDate.parse("2022-10-20"),
				LocalDate.parse("2023-10-30"), cat1.getDayPrice(), cat1.getWeekPrice(), cat1,
				BookingStatus.PENDING, null);
		Booking bk12 = new Booking(null, c8, LocalDate.parse("2022-10-20"),
				LocalDate.parse("2023-10-30"), cat1.getDayPrice(), cat1.getWeekPrice(), cat1,
				BookingStatus.PENDING, null);
		Booking bk13 = new Booking(null, c9, LocalDate.parse("2023-01-20"),
				LocalDate.parse("2023-10-30"), cat1.getDayPrice(), cat1.getWeekPrice(), cat1,
				BookingStatus.ACTIVE, null);
		Booking bk14 = new Booking(null, c9, LocalDate.parse("2022-10-30"),
				LocalDate.parse("2022-12-30"), cat1.getDayPrice(), cat1.getWeekPrice(), cat1,
				BookingStatus.ACTIVE, null);
		Booking bk15 = new Booking(null, c9, LocalDate.parse("2023-02-20"),
				LocalDate.parse("2023-10-20"), cat1.getDayPrice(), cat1.getWeekPrice(), cat1,
				BookingStatus.FINISHED, null);
		Booking bk16 = new Booking(null, c10, LocalDate.parse("2022-11-03"),
				LocalDate.parse("2022-11-07"), cat1.getDayPrice(), cat1.getWeekPrice(), cat1,
				BookingStatus.CANCELED, null);
		Booking bk17 = new Booking(null, c11, LocalDate.parse("2022-10-14"),
				LocalDate.parse("2022-10-30"), cat1.getDayPrice(), cat1.getWeekPrice(), cat1,
				BookingStatus.PENDING, null);
		Booking bk18 = new Booking(null, c11, LocalDate.parse("2022-10-20"),
				LocalDate.parse("2022-10-30"), cat1.getDayPrice(), cat1.getWeekPrice(), cat1,
				BookingStatus.PENDING, null);
		Booking bk19 = new Booking(null, c12, LocalDate.parse("2023-02-20"),
				LocalDate.parse("2023-10-30"), cat1.getDayPrice(), cat1.getWeekPrice(), cat1,
				BookingStatus.ACTIVE, null);
		
		bookingRepository.saveAll(Arrays.asList(bk6, bk5, bk4, bk3, bk2, bk7,bk8, bk9, bk10, bk11, bk12, bk13, bk14, bk15, bk16, bk17, bk18, bk19));
		
		RentalAddDTO r2 = new RentalAddDTO( bk1.getPickUpDate(), bk1.getDropOffDate(), 1400.0, RentalStatus.PENDING, RentalType.PERSONAL,  bk2.getId(), v2.getId());
		rentalService.insert(r2);
		
		paymentService.updatePaymentStatus();

	}

	
	

}
