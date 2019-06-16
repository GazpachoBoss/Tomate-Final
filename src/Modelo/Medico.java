package Modelo;

import java.io.Serializable;
import java.time.LocalTime;

public class Medico extends Persona implements Serializable{
	private Especialidades especialidad;
	private Horario horario;


	public Medico(String idPersona, String nombre, String direccion, String telefono, Especialidades especialidad) {
		super(idPersona, nombre, direccion, telefono);
		this.setEspecialidad(especialidad);
	}

	public Especialidades getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidades especialidad) {
		this.especialidad = especialidad;
	}
	
	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}
	
	public String horarioToString() {
		return horario.toString();
	}
}
