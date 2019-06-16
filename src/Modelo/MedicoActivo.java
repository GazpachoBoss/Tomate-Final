package Modelo;

import java.io.Serializable;

public class MedicoActivo extends Medico implements Serializable{
	private Consulta consulta;
	private Horario horarioConsulta;
	
	public MedicoActivo(String idPersona, String nombre, String direccion, String telefono, Especialidades especialidad) {
		super(idPersona, nombre, direccion, telefono, especialidad);
		
	}
	public void setHorario(Horario horario) {
		horarioConsulta=horario;
	}

	public Consulta getConsulta() {
		return consulta;
	}

	public Horario getHorarioConsulta() {
		return horarioConsulta;
	}

	public void setHorarioConsulta(Horario horarioConsulta) {
		this.horarioConsulta = horarioConsulta;
	}
	
	
}
