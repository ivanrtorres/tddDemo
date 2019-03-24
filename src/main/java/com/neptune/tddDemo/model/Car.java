package com.neptune.tddDemo.model;

public class Car {
	private String brand;
	private String type;

    public Car(String brand, String type) {
		this.brand = brand;
		this.type = type;
	}

    public String getBrand() {
		return this.brand;
	}

	public String getType() {
		return this.type;
	}
}
