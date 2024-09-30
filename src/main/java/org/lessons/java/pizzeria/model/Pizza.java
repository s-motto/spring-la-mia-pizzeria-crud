package org.lessons.java.pizzeria.model;



import java.util.List;

import org.hibernate.annotations.Formula;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "pizzas")
public class Pizza {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Size(min=4, max=20)
	@Column(nullable=false)
	private String name;
	
	
	@Column(nullable=false)
	private String image;
	
	@NotNull
	@Size(min=10, max=250)
	@Column(nullable=false)
	private String description;
	
	@NotNull
	@Column(nullable=false)
	private double price;
	
	
	
	@OneToMany(mappedBy="pizza", cascade= {CascadeType.REMOVE})
	@Formula("(select * " +
	         "from pizzas p " +
			  "left outer join offerts o " +
	           "on p.id = o.pizza_id " +
			    "where p.id = id)")
	private List<Offert> offerts;
	
	
	@ManyToMany()
	@JoinTable(
			name = "pizza_ingredient",
			joinColumns = @JoinColumn(name = "pizza_id"),
			inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
	private List<Ingredient> ingredients;
	
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<Offert> getOfferts() {
		return offerts;
	}

	public void setOfferts(List<Offert> offerts) {
		this.offerts = offerts;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	

	

	

	

	
	
	
	
}
