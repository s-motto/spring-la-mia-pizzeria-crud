package org.lessons.java.pizzeria.controller;

import java.util.List;


import org.lessons.java.pizzeria.model.Ingredient;

import org.lessons.java.pizzeria.service.IngredientService;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/ingredients")
public class IngredientController {
	
	@Autowired
	private IngredientService service;
	
	
	@GetMapping("/index")
	public String index(Model model, @RequestParam(name="name", required=false) String name) {
		
		model.addAttribute("ingredientName", name);
		// prendo i dati da consegnare a books/index
		List<Ingredient> ingredients;
		
		if (name!=null && !name.isEmpty()) {
			ingredients=service.findByNameContaining(name);
		} else {
			ingredients=service.findAll();
		}
		// li inserisco nel modello
		model.addAttribute("ingredients", ingredients);
		
		return "/ingredients/index";
	
	}
	
	
	@GetMapping("/show/{id}")
	public String show(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("ingredients", service.getById(id));
		return "/ingredients/show";
	}
	
	
	@GetMapping("/create")
	public String create(Model model ) {
		model.addAttribute("ingredients", new Ingredient());
		return "/ingredients/create";
	}
	
	@PostMapping("/create")
	public String store(@Valid @ModelAttribute("ingredients") Ingredient formIngredient, 
			            BindingResult bindingResult,
			            Model model,
			            RedirectAttributes attributes) 
	{
		if (bindingResult.hasErrors()) {
			return "/ingredients/create";
		}else {
			service.create(formIngredient);
			attributes.addFlashAttribute("successMessage",  "L'ingrediente "+ formIngredient.getName() + " è stato aggiunto con successo");
			return "redirect:/ingredients/index";
		}
		
		
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, Model model) {
		
		
		
		model.addAttribute("ingredients", service.getById(id));
		return "/ingredients/edit";
	}
	
	
	@PostMapping("/edit/{id}")
	public String update(@Valid @ModelAttribute("ingredients") Ingredient updatedFormIngredient, 
            BindingResult bindingResult,
            Model model,
            RedirectAttributes attributes) 
			{
			if (bindingResult.hasErrors()) {
			return "/ingredients/edit";
			}else {
			service.update(updatedFormIngredient);
			attributes.addFlashAttribute("successMessage",  "L'ingrediente "+ updatedFormIngredient.getName() + " è stato modificato con successo");
			return "redirect:/ingredients/index";
			}
	}
	
	@PostMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id,
			RedirectAttributes attributes) {
		service.delete(id);
		attributes.addFlashAttribute("successMessage",  "L'ingrediente è stato cancellato con successo");
		return"redirect:/ingredients";
	}

	

}
