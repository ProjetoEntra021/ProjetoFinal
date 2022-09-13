package com.entra21.entities.enums;

public enum ContactType {

	EMAIL(1), 
	PHONE(2);

	private int code;

	private ContactType(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}
	
	public static ContactType valueOf(int code) {
		for(ContactType value : ContactType.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid ContactType code!");
	}
}
