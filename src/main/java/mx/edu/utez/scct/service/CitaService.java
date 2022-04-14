package mx.edu.utez.scct.service;

import java.util.List;

import org.springframework.stereotype.Service;

import mx.edu.utez.scct.model.Cita;


@Service
public interface CitaService {
	List<Cita> listar();
	boolean guardar(Cita cita);
	boolean eliminar(long id);
	Cita mostrar(long id);

}
