package com.entra21.entities.enums;

public enum BookingStatus {

	ACTIVE(1),
	FINISHED(2),
	PENDING(3),
	CANCELED(4);
	
	private int code;

	private BookingStatus(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static BookingStatus valueOf(int code) {
		for (BookingStatus value : BookingStatus.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid BookingStatus code!");
	}
}
