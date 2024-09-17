package org.lessons.java.pizzeria.controller;


import java.util.List;

import org.lessons.java.pizzeria.model.Pizza;
import org.lessons.java.pizzeria.repo.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/pizzas")
public class PizzaController {
	
	@Autowired
	private PizzaRepository repo;
	
	@GetMapping
	public String index(Model model, @RequestParam(name="name", required=false) String name) {
		
		model.addAttribute("pizzaName", name);
		// prendo i dati da consegnare a books/index
		List<Pizza> pizzas;
		
		if (name!=null && !name.isEmpty()) {
			pizzas=repo.findByNameContaining(name);
		} else {
			pizzas=repo.findAll();
		}
		// li inserisco nel modello
		model.addAttribute("pizzas", pizzas);
		
		return "/pizzas/index";
	}
	
	
@GetMapping("/show/{id}")
public String show(@PathVariable("id") Integer id, Model model) {
	model.addAttribute("pizzas", repo.findById(id).get());
	return "/pizzas/show";
}


//@GetMapping("/findByName/{name}")
//public String findByName(@PathVariable("name") String name, Model model) {
	//model.addAttribute("pizzas", repo.findByNameContains(name));
	//return "/pizzas/index";
//}

}
