package mx.edu.utez.scct.model;

import java.util.Date;
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

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.JoinColumn;


@Entity
@Table(name = "citas")
public class Cita {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCita;

	@Column(name = "fecha_registro", nullable = false)
	@CreationTimestamp
	private Date fecha;
	
	@Column(nullable = false, length = 45)
	private String hora;
	
	@Column(nullable = false, length = 45)
	private String horaFinal;
	
	@Column(nullable = false)
	private boolean estado;
	
	@Column(nullable = false)
	private int nVentanilla;


	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "citas_documentos",
			joinColumns = @JoinColumn(name="idCita"), 
			inverseJoinColumns = @JoinColumn(name="idDocumento"))
	private Set<Documento> documento;
	
	
	public Cita() {
		super();
	}


	public Long getIdCita() {
		return idCita;
	}


	public void setIdCita(Long idCita) {
		this.idCita = idCita;
	}
	
	


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public String getHora() {
		return hora;
	}


	public void setHora(String hora) {
		this.hora = hora;
	}


	public String getHoraFinal() {
		return horaFinal;
	}


	public void setHoraFinal(String horaFinal) {
		this.horaFinal = horaFinal;
	}


	public boolean isEstado() {
		return estado;
	}


	public void setEstado(boolean estado) {
		this.estado = estado;
	}


	public int getnVentanilla() {
		return nVentanilla;
	}


	public void setnVentanilla(int nVentanilla) {
		this.nVentanilla = nVentanilla;
	}


	public Set<Documento> getDocumento() {
		return documento;
	}


	public void setDocumento(Set<Documento> documento) {
		this.documento = documento;
	}


	@Override
	public String toString() {
		return "Cita [idCita=" + idCita + ", fecha=" + fecha + ", hora=" + hora + ", horaFinal=" + horaFinal
				+ ", estado=" + estado + ", nVentanilla=" + nVentanilla + ", documento=" + documento + "]";
	}


	

	
	
}
