package com.test.resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.entity.Personas;
import com.test.repository.PersonasRepository;
import com.test.repository.PremiosRepository;
import com.test.service.PersonasService;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

@Controller
public class MainResource {
	
	@Autowired
	PersonasRepository personasRepository;
 
	@Autowired
     PersonasService personasService;

		@RequestMapping("/")
		public String index(Model model) {

			return "home";
		}

				
		@RequestMapping("/personas")
		public String personas(Model model) {
			model.addAttribute("PersonasForma", new Personas());
			model.addAttribute("ListaPersonas", personasService.getAllPersonas());
			return "personas";
		}
		
		@RequestMapping("/personas")
		public boolean CreatePersonas(@Valid @ModelAttribute("PersonasForma")Personas Personas, BindingResult result, ModelMap model) {
			if(result.hasErrors()) {
				model.addAttribute("PersonasForma", Personas);
				
			}else {
				try {
					PersonasService.createPersonas(Personas);
					model.addAttribute("PersonasForma", new Personas());
					

				} catch (Exception e) {
					model.addAttribute("formErrorMessage",e.getMessage());
					model.addAttribute("PersonasForma", Personas);
					//model.addAttribute("Premios",PremiosRepository.findAll());
				}
			}
			return true;
			
		}

		@RequestMapping("/premios")
		public String premios(Model model) {
			model.addAttribute("ListaPremios",personasRepository.findAll());
			return "premios";
		}
		
		
		@GetMapping("/deleteUser/{id}")
		public String deleteUser(Model model, @PathVariable(name="id") Long id) {
			try {
				PersonasService.deletePersonas(id);
			} catch (Exception e) {
				model.addAttribute("deleteError","The user could not be deleted.");
			}
			return getPersonasForma(model);
		}


		private String getPersonasForma(Model model) {
			// TODO Auto-generated method stub
			return null;
		}
			
	}
