package Modelo;

import java.io.File;
import java.util.ArrayList;

public class AlmacenMedicos{
	private ArrayList <Medico> medicos;
	private ArrayList <MedicoActivo> medicosActivos;
	private ArrayList<CirujanoActivo> cirujanos;
	private String pathMedicos;
	private String pathMedicosActivos;
	private String pathCirujanos;
	
	private DAO daoMedicos;
	
	public AlmacenMedicos() {
		medicos=new ArrayList<Medico>();
		medicosActivos=new ArrayList<MedicoActivo>();
		cirujanos=new ArrayList<CirujanoActivo>();
		daoMedicos=new DAO();
		pathMedicos="./Medicos/ListaMedicos.medico";
		pathMedicosActivos="./Medicos/ListaMedicosActivos.medico";
		pathCirujanos="./Medicos/ListaCirujanos.medico";
	}
	
	public void volcarDatosMedicosActivos() {
		File file=new File(pathMedicosActivos);
		if(file.canRead()) {
			medicosActivos=(ArrayList<MedicoActivo>) daoMedicos.leer(pathMedicosActivos);
		}
	}
	
	public void volcarDatosCirujanos() {
		File file=new File(pathCirujanos);
		if(file.canRead()) {
			cirujanos=(ArrayList<CirujanoActivo>) daoMedicos.leer(pathCirujanos);
		}
		
	}

	public boolean addMedico(Medico medico) {
		boolean anadido=true;
		
		anadido=medicos.add(medico);
		if(!daoMedicos.grabar(pathMedicos, medicos)) {
			medicos.remove(medico);
			anadido=false;
		}
		
		return anadido;
	}
	
	public boolean addMedicoActivo(MedicoActivo medicoActivo) {
		boolean anadido=true;
		
		anadido=medicosActivos.add(medicoActivo);
		if(!daoMedicos.grabar(pathMedicosActivos, medicosActivos)) {
			medicosActivos.remove(medicoActivo);
			anadido=false;
		}
		
		return anadido;
	}
	
	public boolean addCirujanoActivo(CirujanoActivo cirujano) {
		boolean anadido=true;
		
		anadido=cirujanos.add(cirujano);
		if(!daoMedicos.grabar(pathCirujanos, cirujanos)) {
			cirujanos.remove(cirujano);
			anadido=false;
		}
		
		return anadido;
	}
	
	public boolean eliminarMedicoActivo(MedicoActivo medicoActivo) {
		boolean eliminado=false;
		
		eliminado=medicosActivos.remove(medicoActivo);
		System.out.println(eliminado);
		if(!daoMedicos.grabar(pathMedicosActivos, medicoActivo) && eliminado) {
			medicosActivos.add(medicoActivo);
			eliminado=false;
		}
		
		if(medicosActivos.isEmpty()) {
			daoMedicos.borrarFile(pathMedicosActivos);
		}
		
		return eliminado;
	}
	
	public boolean eliminarCirujano(CirujanoActivo cirujano) {
		boolean eliminado=false;
		System.out.println(cirujanos.contains(cirujano));
		
		
		eliminado=cirujanos.remove(cirujano);
		System.out.println(eliminado);
		if(!daoMedicos.grabar(pathCirujanos, cirujanos) && eliminado) {
			cirujanos.add(cirujano);
			eliminado=false;
		}
		if(cirujanos.isEmpty()) {
			daoMedicos.borrarFile(pathCirujanos);
		}
		
		return eliminado;
	}
	
	public ArrayList<Medico> obtenerListaMedicos(){
		medicos= (ArrayList<Medico>) daoMedicos.leer(pathMedicos);
		return medicos;
	}
	
	public ArrayList<MedicoActivo> obtenerListaMedicosActivos(){
		File file= new File(pathMedicosActivos);
		
		if(file.canRead()) {
			medicosActivos= (ArrayList<MedicoActivo>) daoMedicos.leer(pathMedicosActivos);
		}
		
		return medicosActivos;
	}
	
	public ArrayList<CirujanoActivo> obtenerListaCirujanos(){
		File file=new File(pathCirujanos);
		
		if(file.canRead()) {
			cirujanos= (ArrayList<CirujanoActivo>) daoMedicos.leer(pathCirujanos);
		}
		
		return cirujanos;
	}
}
