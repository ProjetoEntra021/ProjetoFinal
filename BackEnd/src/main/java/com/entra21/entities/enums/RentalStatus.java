package com.entra21.entities.enums;

public enum RentalStatus {

	ACTIVE(1), 
	FINISHED(2), 
	PENDING(3), 
	CANCELED(4);

	private int code;

	private RentalStatus(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static RentalStatus valueOf(int code) {
		for (RentalStatus value : RentalStatus.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid RentalStatus code!");
	}
}
