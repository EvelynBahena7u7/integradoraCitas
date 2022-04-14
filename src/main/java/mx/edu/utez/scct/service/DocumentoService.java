package mx.edu.utez.scct.service;

import java.util.List;

import org.springframework.stereotype.Service;

import mx.edu.utez.scct.model.Documento;



@Service
public interface DocumentoService {
	List<Documento> listarTodos();
	Documento mostrar(long id);
}
