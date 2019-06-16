package Modelo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Cita implements Serializable {
	private String idCita;
	private Paciente paciente;
	private Medico medico;
	private DiasDeLaSemana dia;
	private boolean confirmacionDeAsistencia = false;
	private String observaciones;
	private LocalDateTime fechaCita;

	public Cita(String idCita, Paciente paciente, MedicoActivo medico, LocalDateTime fechaCita, DiasDeLaSemana dia) {
		super();
		this.idCita = idCita;
		this.medico = medico;
		this.paciente = paciente;
		this.fechaCita = LocalDateTime.of(fechaCita.getYear(),fechaCita.getMonth(),fechaCita.getDayOfMonth(),fechaCita.getHour(),0);
		this.dia = dia;
	}

	public LocalDateTime getFechaCita() {
		return fechaCita;
	}

	public void setFechaCita(LocalDateTime fechaCita) {
		this.fechaCita = fechaCita;
	}

	public String getIdCita() {
		return idCita;
	}

	public boolean isConfirmacionDeAsistencia() {
		return confirmacionDeAsistencia;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public Medico getMedico() {
		return medico;
	}

	public DiasDeLaSemana getDia() {
		return dia;
	}

}
