package com.entra21.entities.enums;

public enum RentalType {
	
	APP_DRIVER(1),
	PERSONAL(2);
	
	private int code;
	
	private RentalType(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}
	
	public static RentalType valueOf(int code) {
		for(RentalType value : RentalType.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid RentalType code!");
	}


}
