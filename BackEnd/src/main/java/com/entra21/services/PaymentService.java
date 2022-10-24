package com.entra21.services;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.entra21.entities.Payment;
import com.entra21.entities.Rental;
import com.entra21.entities.Vehicle;
import com.entra21.entities.VehicleExpense;
import com.entra21.entities.dto.PaymentDashDTO;
import com.entra21.entities.dto.VehicleDashDTO;
import com.entra21.entities.enums.PaymentStatus;
import com.entra21.entities.enums.RentalStatus;
import com.entra21.exceptions.ResourceNotFoundException;
import com.entra21.repositories.CompanyRepository;
import com.entra21.repositories.PaymentRepository;
import com.entra21.repositories.RentalRepository;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private RentalService rentalService;
	
	@Autowired
	private RentalRepository rentalRepository;
	
	@Autowired
	private VehicleRevenueService vehicleRevenueService;
	
	@Autowired
	private CompanyRepository companyRepository;

	
	public List<Payment> findAll() {
		return paymentRepository.findAll();
	}

	public Payment findById(Long id) {
		Optional<Payment> obj = paymentRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Payment insert(Payment obj) {
		return paymentRepository.save(obj);
	}

	public void delete(Long id) {
		paymentRepository.deleteById(id);
	}

	public Payment update(Long id, Payment obj) {
		Payment entity = paymentRepository.getReferenceById(id);
		updateData(entity, obj);
		return paymentRepository.save(entity);
	}
	
	public Payment confirmPayment(Long id) {
		Payment entity = paymentRepository.getReferenceById(id);
		entity.setPaymentStatus(PaymentStatus.PAID);
		Rental paymentRental = entity.getRental();
		
		vehicleRevenueService.addVehicleRevenue(paymentRental, entity.getPaymentValue());
		
		if(paymentRental.getRentalStatus() != RentalStatus.CANCELED) {
			rentalService.checkActiveOrPendingOrFinished(paymentRental);
		}
		
		return paymentRepository.save(entity);
	}
	

	private void updateData(Payment entity, Payment obj) {
		entity.setExpirationDate(obj.getExpirationDate());
		entity.setPaymentStatus(obj.getPaymentStatus());
		entity.setPaymentValue(obj.getPaymentValue());
		entity.setDiscount(obj.getDiscount());
		entity.setRental(obj.getRental());
		//Receipt receives the rental
		//Payment receives the booking
	}
	
	@Scheduled(cron="0 0 0 * * *")
	public void dailyUpdatePaymentStatus() {
		List<Payment> payments = paymentRepository.findAll();
		for(Payment payment : payments) {
			payment.updateStatus();
		}
		paymentRepository.saveAll(payments);
		rentalService.dailyUpdateRentallStatus();
	}
	

	public List<PaymentDashDTO> findList(Long companyId) {
		PaymentDashDTO paymentDto;
		LocalDate hoje = LocalDate.now();
		List<PaymentDashDTO> list = new ArrayList<>();
		List<Payment> payments = getAllCompanyPayments(companyId);
		for(Payment payment : payments) {
			if (payment.getPaymentStatus() == PaymentStatus.PENDING) {
				paymentDto = new PaymentDashDTO();
				paymentDto.setClient(payment.getRental().getBooking().getClient().getName());
				paymentDto.setExpirationDate(payment.getExpirationDate());
				paymentDto.setPaymentValue(payment.getPaymentValue());
				paymentDto.setRentalId(payment.getRental().getId());
				list.add(paymentDto);	
			}
		}
		return list;
	}
	
	public Double totalPaymentsReceived() {
		LocalDate hoje = LocalDate.now();
		Double paymentsReceived = 0.0;
		List<Payment> list = paymentRepository.findAll();
		for (Payment p : list) {
			if (p.getExpirationDate().isAfter(hoje.minusMonths(1)) && p.getPaymentStatus() == PaymentStatus.PAID) {
				paymentsReceived += p.getPaymentValue();
			}
		}
 		return paymentsReceived;	
	}
	
	public Double totalPenddingPayments(Long companyId) {
		LocalDate hoje = LocalDate.now();
		Double totalPenddingPayments = 0.0;
		List<Payment> list = getAllCompanyPayments(companyId);
		for (Payment p : list) {
			if (p.getPaymentStatus() == PaymentStatus.PENDING) {
				totalPenddingPayments += p.getPaymentValue();
			}
		}
		return totalPenddingPayments;
	}

	
	public Double nextPayments() {
		LocalDate hoje = LocalDate.now();
		Double nextPayments = 0.0;
		List<Payment> list = paymentRepository.findAll();
		for (Payment p : list) {
			if (p.getExpirationDate().isBefore(hoje.minusDays(7)) && p.getPaymentStatus() == PaymentStatus.WAITINGPAYMENT) {
				nextPayments += p.getPaymentValue();
			}
		}
		return nextPayments;
		
	}
	
	public VehicleDashDTO findData(Long companyId) {
		List<Vehicle> vehicles = companyRepository.findById(companyId).get().getVehicles();
		LocalDate hoje = LocalDate.now();
		VehicleDashDTO data = new VehicleDashDTO();
		Double dataExpense = 0.0;
		for (Vehicle v : vehicles) {
			for (VehicleExpense expense : v.getExpenses()) {
				if (expense.getDate().isAfter(hoje.minusMonths(1))) {
					dataExpense += expense.getValue();
				}	
			}
		}
		data.setMonthExpense(dataExpense);
		data.setMonthBilling(totalPaymentsReceived());
		data.setTotalPenddingPayments(totalPenddingPayments(companyId));
		data.setNextBilling(nextPayments());
		return data;
	}

	private List<Payment> getAllCompanyPayments(Long CompanyId){
		List<Rental> rentals = companyRepository.findById(CompanyId).get().getRentals();
		List<Payment> payments = new ArrayList<>();
		for(Rental rental : rentals) {
			payments.addAll(rental.getPayments());
		}
		return payments;
	}
}
