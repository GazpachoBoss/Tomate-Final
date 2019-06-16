package vistaMedico;

import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import panelComunes.Identificacion;
import panelComunes.Mensaje;

public class AltaMedico extends JPanel {
	private JComboBox altaEspecialidad;
	
	Identificacion identificacion;
	Mensaje mensaje;
	private JComboBox cmbHorarioMedico;

	/**
	 * Create the frame.
	 */
	public AltaMedico() {
		setBounds(100, 100, 657, 475);

		JLabel lblEspecialidad = new JLabel("Especialidad");

		altaEspecialidad = new JComboBox();
		
		altaEspecialidad.addItem("AtencionPrimaria");
		altaEspecialidad.addItem("Traumatologia");
		altaEspecialidad.addItem("Ginecologia");
		altaEspecialidad.addItem("Oncologia");
		altaEspecialidad.addItem("Cirujia");

		JLabel lblHorario = new JLabel("Horario");

		JLabel lblAltaMedico = new JLabel("Alta Medico");
		lblAltaMedico.setFont(new Font("Tahoma", Font.PLAIN, 24));

		identificacion = new Identificacion();
		identificacion.getTxtNacimiento().setVisible(false);
		identificacion.getLblNacimiento().setVisible(false);
		mensaje = new Mensaje();
		
		cmbHorarioMedico = new JComboBox();
		
		cmbHorarioMedico.addItem("1");
		cmbHorarioMedico.addItem("2");
		
		GroupLayout gl_contentPane = new GroupLayout(this);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(31)
					.addComponent(lblAltaMedico)
					.addContainerGap(504, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(101)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(identificacion, GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(9)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblEspecialidad)
										.addComponent(lblHorario))
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(cmbHorarioMedico, 0, 379, Short.MAX_VALUE)
										.addComponent(altaEspecialidad, 0, 379, Short.MAX_VALUE)))
								.addComponent(mensaje, GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE))
							.addGap(92))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(19)
					.addComponent(lblAltaMedico)
					.addGap(52)
					.addComponent(identificacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(altaEspecialidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEspecialidad))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHorario)
						.addComponent(cmbHorarioMedico, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addComponent(mensaje, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addGap(48))
		);
		this.setLayout(gl_contentPane);
	}
	
	
	public JComboBox getComboBoxHorario() {
		return cmbHorarioMedico;
	}


	public Identificacion getIdentificacionAltaMedico() {
		return identificacion;
	}

	public void setIdentificacionAltaMedico(Identificacion identificacion) {
		this.identificacion = identificacion;
	}

	public Mensaje getMensajeAltaMedico() {
		return mensaje;
	}

	public void setMensajeAltaMedico(Mensaje mensaje) {
		this.mensaje = mensaje;
	}

	public String getTxtNombre() {
		return identificacion.getTextNombre().getText();
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

	public String getTextField() {
		return mensaje.getTextField().getText();
	}

	
	

	public Identificacion getIdentificacion() {
		return identificacion;
	}

	public Mensaje getMensaje() {
		return mensaje;
	}

	public JComboBox getAltaEspecialidad() {
		return altaEspecialidad;
	}

	public void setAltaEspecialidad(JComboBox altaEspecialidad) {
		this.altaEspecialidad = altaEspecialidad;
	}
}