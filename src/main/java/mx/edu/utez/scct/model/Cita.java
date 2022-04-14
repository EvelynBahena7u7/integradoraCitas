package mx.edu.utez.scct.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;


@Entity
@Table(name = "citas")
public class Cita {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCita;

	@Column(nullable = false, length = 45)
	private String fecha;
	
	@Column(nullable = false, length = 45)
	private String hora;
	
	@Column(nullable = false)
	private boolean estado;


	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "citas_documentos",
			joinColumns = @JoinColumn(name="idCita"), 
			inverseJoinColumns = @JoinColumn(name="idDocumento"))
	private Set<Documento> documento;
	
	
	public Cita() {
		super();
	}

	public Cita(Long idCita, String fecha, String hora, boolean estado, Set<Documento> documento) {
		super();
		this.idCita = idCita;
		this.fecha = fecha;
		this.hora = hora;
		this.estado = estado;
		this.documento = documento;
	}

	public Long getIdCita() {
		return idCita;
	}

	public void setIdCita(Long idCita) {
		this.idCita = idCita;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Cita [idCita=" + idCita + ", fecha=" + fecha + ", hora=" + hora + ", estado=" + estado + ", documento="
				+ documento + "]";
	}
	
	
}
