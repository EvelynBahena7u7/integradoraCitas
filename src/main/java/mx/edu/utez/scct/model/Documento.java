package mx.edu.utez.scct.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "documentos")
public class Documento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDocumento;

	@Column(nullable = false, length = 45)
	private String nombre;
	
	@Column(nullable = false)
	private boolean estado;
	
	@ManyToMany(mappedBy = "documento")
    private Set<Cita> cita;

	public Documento() {
		super();
	}

	public Documento(Long idDocumento, String nombre, boolean estado) {
		super();
		this.idDocumento = idDocumento;
		this.nombre = nombre;
		this.estado = estado;
		
	}

	public Long getIdDocumento() {
		return idDocumento;
	}

	public void setIdDocumento(Long idDocumento) {
		this.idDocumento = idDocumento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	
	
}
