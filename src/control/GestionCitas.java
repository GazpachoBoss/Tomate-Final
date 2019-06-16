package control;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;

import Modelo.Cita;
import Modelo.DAO;
import Modelo.DiasDeLaSemana;
import Modelo.MedicoActivo;
import Modelo.Paciente;
import adaptadores.AdaptadorArraylist;

public class GestionCitas {
	private ArrayList<Cita> citasPendientes = new ArrayList<Cita>();
	private DAO daoCitas=new DAO();
	private String pathUltimoId="./Indentificadores/UltimoIdCita.cita";
	
	public Cita crearCita(Paciente paciente, MedicoActivo medico, LocalDateTime fechaCita, DiasDeLaSemana dia) {
		String id=obtenerUltimoId();
		
		Cita cita=new Cita(id, paciente, medico, fechaCita, dia);
		paciente.getCitas().add(cita);
		citasPendientes.add(cita);
		
		grabarUltimoId(id);
		
		return null;
	}

	private String obtenerUltimoId() {
		String id;
		File file=new File(pathUltimoId);
		
		if(!file.exists()) {
			grabarUltimoId("0");
		}
		id=(String) daoCitas.leer(pathUltimoId);
		
		return id;
	}
	
	private boolean grabarUltimoId(String id) {
		boolean grabado=true;
		int idNumero;
		
		idNumero=Integer.parseInt(id);
		idNumero++;
		id=Integer.toString(idNumero);
		
		if(!daoCitas.grabar(pathUltimoId, id)) {
			grabado=false;
		}
		
		return grabado;
	}

	public String[] getDatosCita(Cita cita, int[] campos) {
		String datos[] = { cita.getPaciente().getNombre(), cita.getMedico().getEspecialidad().name(),
				cita.getFechaCita().toString(), cita.getMedico().getNombre() };
		String[] retorno = new String[campos.length];
		for (int i = 0; i < campos.length; i++) {
			retorno[i] = datos[campos[i]];
		}
		return retorno;
	}

	public String[][] getDatos(ArrayList<Cita> lista, int[] campos) {
		String[][] retorno = new String[lista.size()][campos.length];
		int i = 0;
		for (Cita cita : lista) {
			retorno[i] = getDatosCita(cita, campos);
			i++;
		}
		return retorno;
	}

	public void eliminarCitasPasadas(LocalDateTime fechaActual) {
		ArrayList<Cita> citasEliminadas = new ArrayList<Cita>();
		for (Cita cita : citasPendientes) {
			if (cita.getFechaCita().isAfter(fechaActual)) {
				citasEliminadas.add(cita);
			}
		}
		citasPendientes.removeAll(citasEliminadas);
	}

	public ArrayList<Cita> getCitasPendientes() {
		return citasPendientes;
	}

	public void setCitasPendientes(ArrayList<Cita> citasPendientes) {
		this.citasPendientes = citasPendientes;
	}

}
