package org.lessons.java.pizzeria.model;

import java.text.DecimalFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "pizzas")
public class Pizza {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false)
	private String image;
	
	@Column(nullable=false)
	private String description;
	
	@Column(nullable=false)
	private double price;
	
	@Transient
	private DecimalFormat formatter= new DecimalFormat("#,##0.00");
	
	
	
	//getter e setter
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrice() {
		return formatter.format(this.price) + '€';
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public DecimalFormat getFormatter() {
		return formatter;
	}

	public void setFormatter(DecimalFormat formatter) {
		this.formatter = formatter;
	}

	
	
	
	
}
