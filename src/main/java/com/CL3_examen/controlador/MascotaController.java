package com.CL3_examen.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.CL3_examen.modelo.Mascota;
import com.CL3_examen.modelo.Tema;
import com.CL3_examen.servicio.IMascotaService;
import com.CL3_examen.servicio.ITemaService;

import jakarta.validation.Valid;


@Controller
public class MascotaController {
	
	@Autowired
	IMascotaService libroservice;
	
	@Autowired
	ITemaService temaservice;
	
	// Listar
	@GetMapping(value = "/listarmascotas")
	public String libro(Model model) {
		List<Mascota> libros = libroservice.obtenerLibros();
		List<Tema> temas = temaservice.listarTemas();
		model.addAttribute("libro", libros);
		model.addAttribute("tema", temas);
		return "/listarmascotas";
	}
	
	// Registrar  - GET
	@GetMapping(value = "/registrarmascotas")
	public String registrarLibro(Model model) {
		Mascota libros = new Mascota();
		List<Tema> temas = temaservice.listarTemas();
		
		model.addAttribute("libro", libros);
		model.addAttribute("tema", temas);
		return "/registrarmascotas";
	}
	
	// Registar  - POST
	@PostMapping(value = "/registrarmascotas")
	public String saveLibro(@Valid @ModelAttribute Mascota libro,
								BindingResult result,
								Model model,
								RedirectAttributes redirectAttributes
								) {
		List<Tema> temas = temaservice.listarTemas();
		if(result.hasErrors()) {
			model.addAttribute("libro", libro);
			model.addAttribute("tema", temas);
			return "/registrarproductos";
		}
		
		libroservice.guardar(libro);
		redirectAttributes.addFlashAttribute("mensaje", "Libro registrado exitosamente.");
		
		return "redirect:/listarmascotas";
	}

}
