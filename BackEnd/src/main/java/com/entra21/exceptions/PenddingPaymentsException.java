package com.entra21.exceptions;

public class PenddingPaymentsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PenddingPaymentsException() {
		super("Existem pagamentos pendentes. Regularize para encerrar contrato.");
	}

}
