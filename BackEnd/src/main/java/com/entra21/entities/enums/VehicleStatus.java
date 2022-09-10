package com.entra21.entities.enums;

public enum VehicleStatus {

	AVAILABLE(1),
	UNAVAILABLE(2),
	MAINTENANCE(3);
	
	private int code;
	
	private VehicleStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static VehicleStatus valueOf(int code) {
		for(VehicleStatus value : VehicleStatus.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid VehicleStatus code!");
	}
	
}
