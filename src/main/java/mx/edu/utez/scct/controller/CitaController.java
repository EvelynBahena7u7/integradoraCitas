package mx.edu.utez.scct.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mx.edu.utez.scct.model.Cita;
import mx.edu.utez.scct.service.CitaServiceImpl;

@Controller
@RequestMapping(value = "/citas")
public class CitaController {
	@Autowired
	private CitaServiceImpl citaService;
	
	@GetMapping(value="/crear")
	public String crearCita(Cita cita, Model modelo) {
		modelo.addAttribute("listaCitas", citaService.listar());
		return "citas/formCita";
	}
	
	
	
	@GetMapping(value = { "/listar"})
	public String listarCitas( Model model ,RedirectAttributes redirectAttributes) {
	   List<Cita> listaCitas = citaService.listar();
	   model.addAttribute("listaCitas", listaCitas);
	   return "citas/listarCitas";
	}
	
	@GetMapping("/mostrar/{id}")
	public String mostrarCita(@PathVariable long id, Model modelo, RedirectAttributes redirectAttributes) {
		Cita cita = citaService.mostrar(id);
		if(cita != null) {
			modelo.addAttribute("cita", cita);
			return "citas/mostrarCita";
		}
		redirectAttributes.addFlashAttribute("msg_error", "consulta fallida");
		return "redirect:/citas/listar";
		
		
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable long id, Model modelo, RedirectAttributes redirectAttributes) {
		Cita cita = citaService.mostrar(id);
		if(cita != null) {
			modelo.addAttribute("cita", cita);

			return "citas/formCita";
			
		}
		
		redirectAttributes.addFlashAttribute("msg_error", "Registro no encontrado");
		return "redirect:/citas/listar";
	}
	
	@PostMapping("/guardar")
	public String guardarCita(@ModelAttribute("cita") Cita cita, Model modelo, RedirectAttributes redirectAttributes){

		if (cita.getIdCita() == null) { // Create
			
		} else { // Update
			
			cita.setFecha(cita.getFecha());
			cita.setHora(cita.getHora());
			cita.setEstado(cita.isEstado());
			
		}
		
		boolean respuesta = citaService.guardar(cita);
		
		if(respuesta) {
			redirectAttributes.addFlashAttribute("msg_success", "Registro exitoso");
			return "redirect:/citas/listar";
		}else {
			redirectAttributes.addFlashAttribute("msg_error", "Registro fallido");
			return "redirect:/citas/crear";
		}
		
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarCita(@PathVariable long id, RedirectAttributes redirectAttributes) {
		
		boolean respuesta = citaService.eliminar(id);
		
		if(respuesta) {
			redirectAttributes.addFlashAttribute("msg_success", "Eliminacion exitosa");
			return "redirect:/citas/listar";
		}else {
			redirectAttributes.addFlashAttribute("msg_error", "eliminación fallida");
			return "redirect:/citas/listar";
		}
	}

}
	
