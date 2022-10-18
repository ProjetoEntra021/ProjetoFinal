package com.entra21.exceptions;

public class InvalidRentalPeriodException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidRentalPeriodException() {
		super("Prazo de locação inválido.");
	}

}
