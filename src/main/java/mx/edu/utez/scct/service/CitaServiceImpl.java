package mx.edu.utez.scct.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import mx.edu.utez.scct.model.Cita;
import mx.edu.utez.scct.repository.CitaRepository;




@Service
public class CitaServiceImpl implements CitaService{
	@Autowired
	CitaRepository citaRepository;
	
	public List<Cita> listar() {
		return citaRepository.findAll();
		
	}
	public boolean guardar(Cita cita) {
		try{
			citaRepository.save(cita);
			return true;
			
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean eliminar(long id) {
		boolean existe = citaRepository.existsById(id);
		if(existe) {
			citaRepository.deleteById(id);
			return !citaRepository.existsById(id);
		}else {
			return false;
		}
	}
	public Cita mostrar(long id) {
		Optional<Cita> optional = citaRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}


}
