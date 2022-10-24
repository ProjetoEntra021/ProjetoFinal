package com.entra21.config;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.entra21.entities.Address;
import com.entra21.entities.Booking;
import com.entra21.entities.Category;
import com.entra21.entities.Client;
import com.entra21.entities.Company;
import com.entra21.entities.Contact;
import com.entra21.entities.User;
import com.entra21.entities.Vehicle;
import com.entra21.entities.VehicleExpense;
import com.entra21.entities.VehicleRevenue;
import com.entra21.entities.dto.RentalAddDTO;
import com.entra21.entities.enums.BookingStatus;
import com.entra21.entities.enums.ContactType;
import com.entra21.entities.enums.GenderType;
import com.entra21.entities.enums.RentalStatus;
import com.entra21.entities.enums.RentalType;
import com.entra21.entities.enums.VehicleStatus;
import com.entra21.repositories.AddressRepository;
import com.entra21.repositories.BookingRepository;
import com.entra21.repositories.CategoryRepository;
import com.entra21.repositories.ClientRepository;
import com.entra21.repositories.CompanyRepository;
import com.entra21.repositories.ContactRepository;
import com.entra21.repositories.UserRepository;
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
	private RentalService rentalService;

	@Autowired
	private PaymentService paymentService;

	@Autowired
	private VehicleExpenseRepository vehicleERepository;

	@Autowired
	private VehicleRevenueRepository vehicleRRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CompanyRepository companyRepository;

	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Override
	public void run(String... args) throws Exception {

		Company company1 = new Company(null, "Locadora do Jorge", "009312123");

		Company company2 = new Company(null, "Locadora do Pedro", "97741231093");
		companyRepository.saveAll(Arrays.asList(company1, company2));

		Category cat1 = new Category(null, "Hatch-Back", 450.00, 70.00, company1);

		Category cat2 = new Category(null, "Sedã", 550.00, 90.00, company1);

		Category cat3 = new Category(null, "Sedã Luxo", 700.00, 110.00, company1);

		Category cat4 = new Category(null, "Hatch-Back", 500.00, 80.00, company2);

		Category cat5 = new Category(null, "Sedã", 600.00, 100.00, company2);

		Category cat6 = new Category(null, "Sedã Luxo", 750.00, 120.00, company2);

		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6));

		Vehicle v1 = new Vehicle(null, "Corsa", "LXE9446", "24696979285", 10000.00, "70741781280", "2020", cat1,
				VehicleStatus.AVAILABLE);

		Vehicle v2 = new Vehicle(null, "Sandero", "MLB8850", "21314092991", 10000.00, "92133184317", "2021", cat1,
				VehicleStatus.AVAILABLE);

		Vehicle v3 = new Vehicle(null, "Ka", "MFT6466", "25935026492", 10000.00, "76710426801", "2022", cat1,
				VehicleStatus.AVAILABLE);

		Vehicle v4 = new Vehicle(null, "Kwid", "LYY1868", "41001452871", 10000.00, "97975210273", "2018", cat3,
				VehicleStatus.AVAILABLE, company1);

		Vehicle v5 = new Vehicle(null, "Palio", "MFS6847", "21396710891", 10000.00, "62369002407", "2019", cat1,
				VehicleStatus.DISABLE);

		Vehicle v6 = new Vehicle(null, "Vectra", "LWV9173", "68166657819", 10000.00, "06236821066", "2017", cat2,
				VehicleStatus.UNAVAILABLE);

		Vehicle v7 = new Vehicle(null, "Gol", "MAA4331", "83495378698", 10000.00, "80215152415", "2016", cat1,
				VehicleStatus.MAINTENANCE);

		Vehicle v8 = new Vehicle(null, "Corsa", "LXX3836", "38734852600", 10000.00, "68705136859", "2018", cat1,
				VehicleStatus.AVAILABLE);

		Vehicle v9 = new Vehicle(null, "Sandero", "MES7643", "09099488799", 10000.00, "90308275883", "2019", cat1,
				VehicleStatus.AVAILABLE);

		Vehicle v10 = new Vehicle(null, "Ka", "LWV8655", "90703795471", 10000.00, "49732711404", "2019", cat1,
				VehicleStatus.AVAILABLE);

		Vehicle v11 = new Vehicle(null, "Kwid", "LYY4017", "51024308588", 10000.00, "00238215881", "2020", cat1,
				VehicleStatus.AVAILABLE);

		Vehicle v12 = new Vehicle(null, "Palio", "MMK2101", "06927352348", 10000.00, "86391449483", "2020", cat1,
				VehicleStatus.DISABLE);

		Vehicle v13 = new Vehicle(null, "Vectra", "MCK5963", "07779019751", 10000.00, "73403735853", "2022", cat1,
				VehicleStatus.UNAVAILABLE);

		Vehicle v14 = new Vehicle(null, "Gol", "MGU0119", "36982630329", 10000.00, "11441406438", "2019", cat1,
				VehicleStatus.MAINTENANCE);

		Vehicle v15 = new Vehicle(null, "Cronos", "MEP8332", "96304471907", 10000.00, "99972027458", "2018", cat2,
				VehicleStatus.AVAILABLE);

		Vehicle v16 = new Vehicle(null, "Virtus", "MDJ3645", "21450621334", 10000.00, "78044143792", "2019", cat2,
				VehicleStatus.DISABLE);

		Vehicle v17 = new Vehicle(null, "Virtus", "MLK6568", "58377177628", 10000.00, "14669417327", "2021", cat2,
				VehicleStatus.UNAVAILABLE);

		Vehicle v18 = new Vehicle(null, "Onix", "LZH5511", "41595141355", 10000.00, "38461743415", "2017", cat2,
				VehicleStatus.MAINTENANCE);

		Vehicle v19 = new Vehicle(null, "Grand Siena", "MBR0133", "22866406774", 10000.00, "00847957543", "2019", cat2,
				VehicleStatus.AVAILABLE);

		Vehicle v20 = new Vehicle(null, "HB20S", "LWR7262", "93655615198", 10000.00, "58279053667", "2019", cat2,
				VehicleStatus.DISABLE);

		Vehicle v21 = new Vehicle(null, "Azera Exclusive V6", "MMB5510", "51575561268", 10000.00, "40674712896", "2020",
				cat3,
				VehicleStatus.UNAVAILABLE);

		Vehicle v22 = new Vehicle(null, "A200", "MBS6233", "09436803174", 10000.00, "64649034712", "2019", cat3,
				VehicleStatus.MAINTENANCE);

		vehicleRepository.saveAll(Arrays.asList(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14,
				v15, v16, v17, v18, v19, v20, v21, v22));

		VehicleExpense ve1 = new VehicleExpense(null, "Revisão 5000km", LocalDate.now(), 110.00, v1);

		VehicleRevenue vr1 = new VehicleRevenue(null, "Aluguel 1 semana", LocalDate.now(), 500.00, v1);

		VehicleExpense ve2 = new VehicleExpense(null, "Revisão 10000km", LocalDate.now(), 130.00, v1);

		VehicleRevenue vr2 = new VehicleRevenue(null, "Aluguel 2 semanas", LocalDate.now(), 1000.00, v1);

		vehicleERepository.saveAll(Arrays.asList(ve1, ve2));

		vehicleRRepository.saveAll(Arrays.asList(vr1, vr2));

		// Payment pay1 = new Payment(null, LocalDate.parse("15/11/2022", formatter),
		// 700.00, 0.00, PaymentStatus.WAITINGPAYMENT, r1);
		// Payment pay2 = new Payment(null, LocalDate.parse("15/12/2022", formatter),
		// 700.00, 0.00, PaymentStatus.WAITINGPAYMENT, r1);
		// Payment pay3 = new Payment(null, LocalDate.parse("15/01/2023", formatter),
		// 700.00, 0.00, PaymentStatus.WAITINGPAYMENT, r1);
		//
		// paymentRepository.saveAll(Arrays.asList(pay1,pay2,pay3));

		// create test registration client Pablo
		Client c2 = new Client(null, "Pablo Alexandre M Pamplona", "24066019943", "54732759400",
				LocalDate.parse("24/07/1980", formatter), GenderType.MASCULINO);
		Client c3 = new Client(null, "Tatiani Pereira Rodrigues", "02889793974", "13036097905",
				LocalDate.parse("30/10/1995", formatter), GenderType.FEMININO);
		Client c4 = new Client(null, "Victor Woleck", "89125375989", "26853219973",
				LocalDate.parse("03/08/1998", formatter), GenderType.MASCULINO);
		Client c5 = new Client(null, "Machado de Assis", "02616067943", "35647143254",
				LocalDate.parse("21/06/1839", formatter), GenderType.MASCULINO);
		Client c6 = new Client(null, "Jorge Amado", "46023254918", "98034459903",
				LocalDate.parse("10/08/1912", formatter), GenderType.MASCULINO);
		Client c7 = new Client(null, "Carlos Drummond de Andrade", "31299470947", "07292959714",
				LocalDate.parse("31/10/1902", formatter), GenderType.MASCULINO);
		Client c8 = new Client(null, "Clarice Lispector", "16945992993", "63376766209",
				LocalDate.parse("09/12/1977", formatter), GenderType.FEMININO);
		Client c9 = new Client(null, "Cecília Meireles", "91323213929", "66006115720",
				LocalDate.parse("01/11/1901", formatter), GenderType.FEMININO);
		Client c10 = new Client(null, "Vinicius de Moraes", "54680362901", "47220510534",
				LocalDate.parse("19/10/1913", formatter), GenderType.MASCULINO);
		Client c11 = new Client(null, "Lygia Fagundes Telles", "41981919996", "05517472580",
				LocalDate.parse("19/04/1917", formatter), GenderType.FEMININO);
		Client c12 = new Client(null, "Moacyr Scliar", "23421224978", "44751013955",
				LocalDate.parse("23/03/1937", formatter), GenderType.MASCULINO);
		Client c13 = new Client(null, "Conceição Evaristo", "72092369962", "35485409593",
				LocalDate.parse("30/10/1946", formatter), GenderType.FEMININO);
		Client c14 = new Client(null, "Lima Barreto", "03419615906", "22001336178",
				LocalDate.parse("09/12/1881", formatter), GenderType.MASCULINO);
		Client c15 = new Client(null, "Lygia Fagundes Teles ", "91561538990", "28047346343",
				LocalDate.parse("01/11/1923", formatter), GenderType.FEMININO);
		clientRepository.saveAll(Arrays.asList(c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15));

		Address ad2 = new Address(null, "88095000", "Av Marinheiro Max Schramm", "Estreito", "Florianopolis", "SC",
				"2428", "Bloco 4 Apto 301",
				c2);

		addressRepository.save(ad2);

		Contact ct1 = new Contact(null, ContactType.EMAIL, "mateus@gmail.com", c1);
		Contact ct2 = new Contact(null, ContactType.PHONE, "48988765432", c1);
		Contact ct3 = new Contact(null, ContactType.EMAIL, "pablompamplona@gmail.com", c2);
		Contact ct4 = new Contact(null, ContactType.PHONE, "48988328778", c2);
		Contact ct5 = new Contact(null, ContactType.EMAIL, "rodriguespereiratatiani@gmail.com", c3);

		contactRepository.saveAll(Arrays.asList(ct1, ct2, ct3, ct4, ct5));

		Booking bk1 = new Booking(null, c1, LocalDate.parse("2022-10-05"), LocalDate.parse("2022-10-26"),
				cat1.getDayPrice(), 1400.00, cat1.getWeekPrice(), cat1, BookingStatus.ACTIVE, null, company1);

		Booking bk2 = new Booking(null, c2, LocalDate.parse("2005-10-20"),
				LocalDate.parse("2005-10-30"), cat1.getDayPrice(), cat1.getWeekPrice(), 0.0, cat1,
				BookingStatus.ACTIVE, null, company1);
		Booking bk6 = new Booking(null, c2, LocalDate.parse("2022-03-13"),
				LocalDate.parse("2022-07-13"), cat1.getDayPrice(), cat1.getWeekPrice(), 0.0, cat1,
				BookingStatus.FINISHED, null, company1);
		Booking bk3 = new Booking(null, c3, LocalDate.parse("2022-10-30"),
				LocalDate.parse("2022-12-30"), cat1.getDayPrice(), cat1.getWeekPrice(), 0.0, cat1,
				BookingStatus.CANCELED, null, company1);
		Booking bk4 = new Booking(null, c3, LocalDate.parse("2022-10-22"),
				LocalDate.parse("2022-11-22"), cat1.getDayPrice(), cat1.getWeekPrice(), 0.0, cat1,
				BookingStatus.PENDING, null, company1);
		Booking bk5 = new Booking(null, c3, LocalDate.parse("2022-10-20"),
				LocalDate.parse("2022-12-27"), cat1.getDayPrice(), cat1.getWeekPrice(), 0.0, cat1,
				BookingStatus.PENDING, null, company1);
		Booking bk7 = new Booking(null, c4, LocalDate.parse("2022-11-20"),
				LocalDate.parse("2023-11-20"), cat1.getDayPrice(), cat1.getWeekPrice(), 0.0, cat1,
				BookingStatus.ACTIVE, null, company1);
		Booking bk8 = new Booking(null, c4, LocalDate.parse("2022-10-30"),
				LocalDate.parse("2023-03-30"), cat1.getDayPrice(), cat1.getWeekPrice(), 0.0, cat1,
				BookingStatus.ACTIVE, null, company1);
		Booking bk9 = new Booking(null, c5, LocalDate.parse("2005-10-20"),
				LocalDate.parse("2005-10-30"), cat1.getDayPrice(), cat1.getWeekPrice(), 0.0, cat1,
				BookingStatus.FINISHED, null, company1);
		Booking bk10 = new Booking(null, c6, LocalDate.parse("2022-10-30"),
				LocalDate.parse("2023-04-30"), cat1.getDayPrice(), cat1.getWeekPrice(), 0.0, cat1,
				BookingStatus.CANCELED, null, company1);
		Booking bk11 = new Booking(null, c7, LocalDate.parse("2022-10-20"),
				LocalDate.parse("2023-10-30"), cat1.getDayPrice(), cat1.getWeekPrice(), 0.0, cat1,
				BookingStatus.PENDING, null, company1);
		Booking bk12 = new Booking(null, c8, LocalDate.parse("2022-10-20"),
				LocalDate.parse("2023-10-30"), cat1.getDayPrice(), cat1.getWeekPrice(), 0.0, cat1,
				BookingStatus.PENDING, null, company2);
		Booking bk13 = new Booking(null, c9, LocalDate.parse("2023-01-20"),
				LocalDate.parse("2023-10-30"), cat1.getDayPrice(), cat1.getWeekPrice(), 0.0, cat1,
				BookingStatus.ACTIVE, null, company2);
		Booking bk14 = new Booking(null, c9, LocalDate.parse("2022-10-30"),
				LocalDate.parse("2022-12-30"), cat1.getDayPrice(), cat1.getWeekPrice(), 0.0, cat1,
				BookingStatus.ACTIVE, null, company2);
		Booking bk15 = new Booking(null, c9, LocalDate.parse("2023-02-20"),
				LocalDate.parse("2023-10-20"), cat1.getDayPrice(), cat1.getWeekPrice(), 0.0, cat1,
				BookingStatus.FINISHED, null, company2);
		Booking bk16 = new Booking(null, c10, LocalDate.parse("2022-11-03"),
				LocalDate.parse("2022-11-07"), cat1.getDayPrice(), cat1.getWeekPrice(), 0.0, cat1,
				BookingStatus.CANCELED, null, company2);
		Booking bk17 = new Booking(null, c11, LocalDate.parse("2022-10-14"),
				LocalDate.parse("2022-10-30"), cat1.getDayPrice(), cat1.getWeekPrice(), 0.0, cat1,
				BookingStatus.PENDING, null, company2);
		Booking bk18 = new Booking(null, c11, LocalDate.parse("2022-10-20"),
				LocalDate.parse("2022-10-30"), cat1.getDayPrice(), cat1.getWeekPrice(), 0.0, cat1,
				BookingStatus.PENDING, null, company2);
		Booking bk19 = new Booking(null, c12, LocalDate.parse("2023-02-20"),
				LocalDate.parse("2023-10-30"), cat1.getDayPrice(), cat1.getWeekPrice(), 0.0, cat1,
				BookingStatus.ACTIVE, null, company2);

		bookingRepository
				.saveAll(Arrays.asList(bk1, bk2, bk6, bk5, bk4, bk3, bk2, bk7, bk8, bk9, bk10, bk11, bk12, bk13, bk14,
						bk15, bk16, bk17, bk18, bk19));

		RentalAddDTO r1 = new RentalAddDTO(bk1.getPickUpDate(), bk1.getDropOffDate(), 1350.0, RentalStatus.PENDING,
				RentalType.APP_DRIVER, bk1.getId(), v1.getId(), company1.getId());
		rentalService.insert(r1);

		RentalAddDTO r2 = new RentalAddDTO(bk2.getPickUpDate(), bk2.getDropOffDate(), 1400.0, RentalStatus.PENDING,
				RentalType.PERSONAL, bk2.getId(), v2.getId(), company1.getId());

		rentalService.insert(r2);

		paymentService.dailyUpdatePaymentStatus();

		String password1 = passwordEncoder.encode("jorge123");
		User user1 = new User(null, "jorgeLocadora", password1, company1);

		String password2 = passwordEncoder.encode("pedro123");
		User user2 = new User(null, "pedroLocadora", password2, company2);

		userRepository.saveAll(Arrays.asList(user1, user2));
	}

}
