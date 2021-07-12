/*
 * Copyright 2019 Fresher Academy
 * @author AnTV5
 * @date Nov 19, 2019
 * @version 1.0
*/
package fa.training.problem01;

public class Car {
	private String licenseNumber;
	private String model;
	private int year;
	private String brand;
	private String color;
	public Car() {
		super();
	}
	public Car(String licenseNumber, String model, int year, String brand, String color) {
		super();
		this.licenseNumber = licenseNumber;
		this.model = model;
		this.year = year;
		this.brand = brand;
		this.color = color;
	}
	public String getLicenseNumber() {
		return licenseNumber;
	}
	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "Car [licenseNumber=" + licenseNumber + ", model=" + model + ", year=" + year + ", brand=" + brand
				+ ", color=" + color + "]";
	}
	
}
