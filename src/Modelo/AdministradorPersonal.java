package Modelo;

import java.io.File;

public class AdministradorPersonal {
	private DAO daoMedicos=new DAO();
	private String path="./Indentificadores/UltimoIdPersona.persona";
	
	public MedicoActivo darDeAltaMedicoActivo(String nombre, String telefono, String direccion, Especialidades especialidad) {
		String id=obtenerUltimoId();
		MedicoActivo medico = new MedicoActivo(obtenerUltimoId(), nombre, direccion, telefono, especialidad);
		
		grabarUltimoId(id);
		return medico;
	}
	
	public CirujanoActivo darDeAltaCirujanoActivo(String nombre, String telefono, String direccion, Especialidades especialidad) {
		String id=obtenerUltimoId();
		CirujanoActivo cirujano=new CirujanoActivo(id, nombre, direccion, telefono, especialidad);
		
		grabarUltimoId(id);
		return cirujano;
	}
	
	
	private String obtenerUltimoId() {
		String id;
		File file=new File(path);
		
		if(!file.exists()) {
			grabarUltimoId("0");
		}
		id=(String) daoMedicos.leer(path);
		
		return id;
	}
	
	private boolean grabarUltimoId(String id) {
		boolean grabado=true;
		int idNumero;
		
		idNumero=Integer.parseInt(id);
		idNumero++;
		id=Integer.toString(idNumero);
		
		if(!daoMedicos.grabar(path, id)) {
			grabado=false;
		}
		
		return grabado;
	}
	
}


