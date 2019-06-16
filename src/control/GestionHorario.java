package control;

import java.time.LocalTime;
import java.util.ArrayList;

import Modelo.Consulta;
import Modelo.DiasDeLaSemana;
import Modelo.Especialidades;
import Modelo.Horario;
import Modelo.Medico;
import Modelo.MedicoActivo;

public class GestionHorario {
	private DiasDeLaSemana[] diaTrabajoPrimaria = { DiasDeLaSemana.Monday, DiasDeLaSemana.Tuesday, DiasDeLaSemana.Wednesday,
			DiasDeLaSemana.ThursDay, DiasDeLaSemana.Friday };
	private DiasDeLaSemana[] diaEspecilistaPar = new DiasDeLaSemana[2];
	private DiasDeLaSemana[] diaEspecilistaImpar = new DiasDeLaSemana[3];
	/*Este vector te indica cuantas consultas hay en la posicion 0 se guarda la mañana y la 1 se 
	 * guarda las consultas de la tarde*/
	private int[] consultasPrimaria = new int[2];
	private int[] consultasEpecialistas = new int[2];
	private Horario[] horariosPrimaria = new Horario[2];
	private Horario[] horariosEspecialista = new Horario[2];

	public GestionHorario() {
		super();
		iniciarHorarioPrimaria();
		asignarDias();
		int ultimaHora = 8;
		LocalTime[] horas = new LocalTime[2];
		for (int j = 0; j < 2; j++) {
			horas[j] = horas[j].of(ultimaHora++, 0);
		}
		horariosEspecialista[0] = new Horario(horas, diaEspecilistaPar);
		horariosEspecialista[1] = new Horario(horas, diaEspecilistaImpar);

	}
	/**Esta funcion crea los horarios de Especialista
	 * @return*/
	private void asignarDias() {
		int indicePar=0;
		int indice=0;
		for (int i = 0; i < diaTrabajoPrimaria.length; i++) {
			if (i % 2 == 0) {
				diaEspecilistaImpar[indice] = diaTrabajoPrimaria[i];
				indice++;
			} else {
				diaEspecilistaPar[indicePar] = diaTrabajoPrimaria[i];
				indicePar++;
			}
		}
	}

	public int[] getConsultasPrimaria() {
		return consultasPrimaria;
	}

	public int[] getConsultasEpecialistas() {
		return consultasEpecialistas;
	}
	
	public void ocuparConsultaEspecialista(int turno, MedicoActivo medico) {
		consultasEpecialistas[turno] += 1;
		medico.setHorario(horariosEspecialista[turno]);
	}

	public void ocuparConsultaPrimaria(int turno, MedicoActivo medico) {
		consultasPrimaria[turno] += 1;
		System.out.println(horariosPrimaria[turno+1]);
		medico.setHorario(horariosPrimaria[turno]);
	}
	public boolean consultaDisponibleEspecialista(int turno) {
		return consultasEpecialistas[turno]<2;
	}
	public boolean turnoDisponible(int turno) {
		return consultasPrimaria[turno] < 4;
	}
/**Crea el horario de Los medicos de atencion primaria
 @return
 */
	private void iniciarHorarioPrimaria() {
		int ultimaHora = 8;
		for (int i = 0; i < horariosPrimaria.length; i++) {
			LocalTime[] horas = new LocalTime[4];
			for (int j = 0; j < 4; j++) {
				horas[j] = horas[j].of(ultimaHora++, 0);
			}
			horariosPrimaria[i] = new Horario(horas, diaTrabajoPrimaria);
		}
	}

//public boolean contratarMedico(Medico medico,ArrayList<Consulta> consulta) {
//	boolean stop=false;
//	for (Consulta i : consulta) {
//		if (i.puestoLibre()&&!stop) {
//			i.contratarMedico(medico);
//			stop=true;
//		}
//	}
//	return stop;
//}

}
