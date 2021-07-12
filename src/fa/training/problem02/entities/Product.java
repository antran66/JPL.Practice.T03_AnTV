/*
 * Copyright 2019 Fresher Academy
 * @author AnTV5
 * @date Nov 19, 2019
 * @version 1.0
*/
package fa.training.problem02.entities;

import java.util.Set;

public class Product {
	private int product_id;
	private String product_name;
	private String model_year;
	private double list_price;
	private Set<Brand> brands;
	public Product() {
		super();
	}
	public Product(int product_id, String product_name, String model_year, double list_price, Set<Brand> brands) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.model_year = model_year;
		this.list_price = list_price;
		this.brands = brands;
	}
	
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getModel_year() {
		return model_year;
	}
	public void setModel_year(String model_year) {
		this.model_year = model_year;
	}
	public double getList_price() {
		return list_price;
	}
	public void setList_price(double list_price) {
		this.list_price = list_price;
	}
	public Set<Brand> getBrands() {
		return brands;
	}
	public void setBrands(Set<Brand> brands) {
		this.brands = brands;
	}
	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", product_name=" + product_name + ", model_year=" + model_year
				+ ", list_price=" + list_price + ", brands=" + brands + "]";
	}
	
}
