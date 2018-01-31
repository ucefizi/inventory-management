package models;

import java.sql.Date;

public class Product {
	private int id;
	private String description;
	private double price;
	private Date creationDate;

	public Product(int id, double price, String description, Date date) {
		super();
		this.id = id;
		this.description = description;
		this.price = price;
		this.creationDate = date;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
