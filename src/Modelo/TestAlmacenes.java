package Modelo;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

class TestAlmacenes{
	private AlmacenPacientes almacen = new AlmacenPacientes();
	private AlmacenMedicos almacenMedicos=new AlmacenMedicos();

	//funciona
	@Ignore
	void testGrabarPaciente() {

		Paciente paciente = new Paciente("1", "Jesuso sanchez", "calle nabo", "918384992", null);
		Paciente paciente2 = new Paciente("2", "issam el real", "calle rabano", "9289182829", null);

		assertTrue(almacen.grabar(paciente));
		assertTrue(almacen.grabar(paciente2));
		
		assertTrue(almacen.grabarMapa());
		assertNotNull(almacen.obetenerMapa());
	}

	//funciona, aunqu hay que sobreescribir el equals aunque depurando me devolvia el mismo objeto
	@Test
	void testLeerPaciente() {
		Paciente paciente=almacen.obtener("107");
		System.out.println(paciente.getCitas().size());
		ArrayList<MedicoActivo>medicos=almacenMedicos.obtenerListaMedicosActivos();
		for (int i = 0; i < medicos.get(1).getHorarioConsulta().getHorarioSemanal().length; i++) {
			for (int j = 0; j < medicos.get(1).getHorarioConsulta().getHorarioSemanal()[i].length; j++) {
				System.out.println(medicos.get(1).getHorarioConsulta().getHorarioSemanal()[i][j]);
			}
			
		}
	}

	//funciona
	@Ignore
	void testBorrarPaciente() {
		File file = new File("./FicherosPacientes/1.paciente");

		assertTrue(file.exists());

		almacen.borrar("1");

		assertFalse(file.exists());
	}
	
	//funciona
	@Ignore
	void testGrabarMapa() {
		assertTrue(almacen.grabarMapa());
		assertNotNull(almacen.obetenerMapa());
	}
	
	//funciona
	@Ignore
	void testCreacionFicherosMedicos() {
		File file1=new File("./Medicos/ListaMedicos.medico");
		File file2=new File("./Medicos/ListaMedicosActivos.medico");
		File file3=new File("./Medicos/ListaCirujanos.medico");
		
		Medico medico=new Medico("3", "benzema", "calle tortilla", "9882938", Especialidades.AtencionPrimaria);
		MedicoActivo medicoActivo=new MedicoActivo("4", "vinicius", "calle salmorejo", "81982829", Especialidades.Ginecologia);
		CirujanoActivo cirujano=new CirujanoActivo("5", "lopetegui", "avenida cocido", "92812928392", Especialidades.Cirujia);
		
		assertTrue(almacenMedicos.addMedico(medico));
		assertTrue(almacenMedicos.addMedicoActivo(medicoActivo));
		assertTrue(almacenMedicos.addCirujanoActivo(cirujano));
		
		assertTrue(file1.exists());
		assertTrue(file2.exists());
		assertTrue(file3.exists());
	}
	
	//funciona
	@Ignore
	void testEliminarMedicos() {
		MedicoActivo medicoActivo=new MedicoActivo("4", "vinicius", "calle salmorejo", "81982829", Especialidades.Ginecologia);
		CirujanoActivo cirujano=new CirujanoActivo("5", "lopetegui", "avenida cocido", "92812928392", Especialidades.Cirujia);
		
		assertFalse(almacenMedicos.eliminarMedicoActivo(medicoActivo));
		assertFalse(almacenMedicos.eliminarCirujano(cirujano));
		
		almacenMedicos.addCirujanoActivo(cirujano);
		almacenMedicos.addMedicoActivo(medicoActivo);
		
		assertTrue(almacenMedicos.eliminarMedicoActivo(medicoActivo));
		assertTrue(almacenMedicos.eliminarCirujano(cirujano));
	}
	
	//funciona y depurando funciona como es de esperar
	@Ignore
	void testObtenerListasMedicos() {
	//	ArrayList<Medico>medicos=almacenMedicos.obtenerListaMedicos();
	//	ArrayList<MedicoActivo>medicosActivos=almacenMedicos.obtenerListaMedicosActivos();
		ArrayList<CirujanoActivo>cirujanos=almacenMedicos.obtenerListaCirujanos();
		
		//assertFalse(medicos.isEmpty());
		//assertFalse(medicosActivos.isEmpty());
		assertFalse(cirujanos.isEmpty());
	}
	
	@Ignore
	void testHorario() {
		ArrayList<MedicoActivo> medicosActivos=almacenMedicos.obtenerListaMedicosActivos();
		
		for (MedicoActivo medicoActivo : medicosActivos) {
			int matriz[][]=medicoActivo.getHorario().getHorarioSemanal();
			for (int i = 0; i < matriz.length; i++) {
				for (int j = 0; j < matriz[i].length; j++) {
					System.out.println(matriz[i][j]);
				}
			}
		}
	}
}
