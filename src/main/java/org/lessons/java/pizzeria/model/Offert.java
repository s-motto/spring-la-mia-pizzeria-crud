package org.lessons.java.pizzeria.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="offerts")
public class Offert {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String offertTitle;
	
	private LocalDate whenStart;
	
	private LocalDate whenEnd;
	
	
	
	@ManyToOne
	@JoinColumn(name="pizza_id", nullable=false)
	private Pizza pizza;
	
	
	

    //getter e setter

	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getOffertTitle() {
		return offertTitle;
	}



	public void setOffertTitle(String offertTitle) {
		this.offertTitle = offertTitle;
	}



	public LocalDate getWhenStart() {
		return whenStart;
	}



	public void setWhenStart(LocalDate whenStart) {
		this.whenStart = whenStart;
	}



	public LocalDate getWhenEnd() {
		return whenEnd;
	}



	public void setWhenEnd(LocalDate whenEnd) {
		this.whenEnd = whenEnd;
	}



	public Pizza getPizza() {
		return pizza;
	}



	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}
	
	

}
