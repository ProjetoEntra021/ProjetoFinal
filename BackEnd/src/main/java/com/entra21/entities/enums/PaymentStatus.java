package com.entra21.entities.enums;

public enum PaymentStatus {
	
	WAITINGPAYMENT(1),
	PENDING(2),
	PAID(3),
	CANCELED(4);
	
private int code;
	
	private PaymentStatus(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}
	
	public static PaymentStatus valueOf(int code) {
		for(PaymentStatus value : PaymentStatus.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid PaymentStatus code!");
	}



}
