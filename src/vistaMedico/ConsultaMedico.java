package vistaMedico;

import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import panelComunes.Identificacion;
import panelComunes.Mensaje;
import panelComunes.Seleccion;

import javax.swing.LayoutStyle.ComponentPlacement;

public class ConsultaMedico extends JPanel {

	private JTextField altaEspecialidad;
	private JTextField altaHorario;
	private Seleccion seleccion;

	Identificacion identificacion;

	/**
	 * Create the frame.
	 */
	public ConsultaMedico() {
		setBounds(100, 100, 653, 419);

		JLabel lblConsultaMedico = new JLabel("Consulta Medico");
		lblConsultaMedico.setBounds(12, 13, 172, 29);
		lblConsultaMedico.setFont(new Font("Tahoma", Font.PLAIN, 24));

		JLabel lblEspecialidad = new JLabel("Especialidad");
		lblEspecialidad.setBounds(132, 300, 70, 16);

		JLabel lblHorario = new JLabel("Horario");
		lblHorario.setBounds(132, 333, 42, 16);

		altaEspecialidad = new JTextField();
		altaEspecialidad.setBounds(214, 297, 162, 22);
		altaEspecialidad.setEditable(false);
		altaEspecialidad.setColumns(10);

		altaHorario = new JTextField();
		altaHorario.setBounds(214, 330, 162, 22);
		altaHorario.setEditable(false);
		altaHorario.setColumns(10);
		seleccion = new Seleccion();
		seleccion.setBounds(122, 66, 395, 48);
		identificacion = new Identificacion();
		identificacion.getTxtNacimiento().setVisible(false);
		identificacion.getLblNacimiento().setVisible(false);

		identificacion.setBounds(122, 127, 478, 160);
		int[] camposDeshabilitados = { 0, 1, 2, 3, 4 };
		identificacion.deshabilitarCampo(camposDeshabilitados);
		setLayout(null);
		add(lblEspecialidad);
		add(altaEspecialidad);
		add(lblHorario);
		add(altaHorario);
		add(lblConsultaMedico);
		add(identificacion);
		add(seleccion);
	}

	public Seleccion getSeleccion() {
		return seleccion;
	}

	public Identificacion getIdentificacionConsultaMedico() {
		return identificacion;
	}

	public void setIdentificacionConsultaMedico(Identificacion identificacion) {
		this.identificacion = identificacion;
	}

	public String getTxtNombre() {
		return identificacion.getTextNombre().getText();
	}

	public void setTextApellidos(String apellidos) {
		identificacion.getTextApellidos().setText(apellidos);
	}

	public void setTextNombre(String nombre) {
		identificacion.getTextNombre().setText(nombre);
	}

	public void setTextDireccion(String direccion) {
		identificacion.getTextDireccion().setText(direccion);
	}

	public void setTextTelefono(String telefono) {
		identificacion.getTextTelefono().setText(telefono);
	}

	public void setTextNacimiento(String nacimiento) {
		identificacion.getTxtNacimiento().setText(nacimiento);
	}

	public void setTextEspecialidad(String especialidad) {
		altaEspecialidad.setText(especialidad);
	}

	public String getTextApellidos() {
		return identificacion.getTextApellidos().getText();
	}

	public String getTextDireccion() {
		return identificacion.getTextDireccion().getText();
	}

	public String getTextTelefono() {
		return identificacion.getTextTelefono().getText();
	}

	public String getTxtNacimiento() {
		return identificacion.getTxtNacimiento().getText();
	}

	public JTextField getAltaEspecialidad() {
		return altaEspecialidad;
	}

	public void setAltaEspecialidad(JTextField altaEspecialidad) {
		this.altaEspecialidad = altaEspecialidad;
	}

	public JTextField getAltaHorario() {
		return altaHorario;
	}

	public void setAltaHorario(JTextField altaHorario) {
		this.altaHorario = altaHorario;
	}
}
