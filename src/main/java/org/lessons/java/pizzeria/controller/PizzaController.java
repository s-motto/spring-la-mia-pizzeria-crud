package org.lessons.java.pizzeria.controller;


import java.util.List;

import org.lessons.java.pizzeria.model.Pizza;
import org.lessons.java.pizzeria.repo.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

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
	
	
	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("pizzas", new Pizza());
		return "/pizzas/create";
	}
	
	@PostMapping("/create")
	public String store(@Valid @ModelAttribute("pizzas") Pizza formPizza, 
			            BindingResult bindingResult,
			            Model model) 
	{
		if (bindingResult.hasErrors()) {
			return "/pizzas/create";
		}else {
			repo.save(formPizza);
			return "redirect:/pizzas";
		}
		
		
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, Model model) {
		
		//trovo la pizza
		
		//lo inserisco nel model
		model.addAttribute("pizzas", repo.findById(id).get());
		return "/pizzas/edit";
	}
	
	
	@PostMapping("/edit/{id}")
	public String update(@Valid @ModelAttribute("pizzas") Pizza updatedFormPizza, 
            BindingResult bindingResult,
            Model model) 
			{
			if (bindingResult.hasErrors()) {
			return "/pizzas/edit";
			}else {
			repo.save(updatedFormPizza);
			return "redirect:/pizzas";
			}
	}
	


//@GetMapping("/findByName/{name}")
//public String findByName(@PathVariable("name") String name, Model model) {
	//model.addAttribute("pizzas", repo.findByNameContains(name));
	//return "/pizzas/index";
//}

}
