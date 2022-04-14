package mx.edu.utez.scct.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.edu.utez.scct.model.Documento;
import mx.edu.utez.scct.repository.DocumentoRepository;



@Service
public class DocumentoServiceImpl implements DocumentoService {
	@Autowired
	DocumentoRepository documentoRepository;

	public List<Documento> listarTodos() {
		return documentoRepository.findAll();
	}

	/*@Override*/
	public Documento mostrar(long id) {
		Optional<Documento> optional = documentoRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
}
