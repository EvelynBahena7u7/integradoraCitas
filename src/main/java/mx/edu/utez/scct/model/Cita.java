package mx.edu.utez.scct.model;


import java.sql.Time;
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
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.JoinColumn;


@Entity
@Table(name = "citas")
public class Cita {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCita;

	@Column(name = "fecha", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fecha;
	
	@Column(nullable = false, length = 45)
	@DateTimeFormat(pattern = "dd hh:mm:ss a")
	private Time hora;
	
	@Column(nullable = false, length = 45)
	@DateTimeFormat(pattern = "dd hh:mm:ss a")
	private Time horaFinal;
	@Column(nullable = false)
	private int nVentanilla;
	
	@Column(nullable = false)
	private boolean estado;
	
	

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "Documento_cita",
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


	

	public Time getHora() {
		return hora;
	}


	public void setHora(Time hora) {
		this.hora = hora;
	}


	public Time getHoraFinal() {
		return horaFinal;
	}


	public void setHoraFinal(Time horaFinal) {
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
				+ ", estado=" + estado + ", nVentanilla=" + nVentanilla + ", documento=" + documento + ", getIdCita()="
				+ getIdCita() + ", getFecha()=" + getFecha() + ", getHora()=" + getHora() + ", getHoraFinal()="
				+ getHoraFinal() + ", isEstado()=" + isEstado() + ", getnVentanilla()=" + getnVentanilla()
				+ ", getDocumento()=" + getDocumento() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}


	


	

	
	
}
