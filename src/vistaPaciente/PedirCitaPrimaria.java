package vistaPaciente;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import Modelo.Cita;
import panelComunes.Mensaje;
import panelComunes.Seleccion;
import panelComunes.VistaCitaIssam;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.BorderLayout;

public class PedirCitaPrimaria extends JPanel {
	Mensaje mensaje;
	Seleccion seleccion;
	VistaCitaIssam horario;

	/**
	 * Create the panel.
	 */
	public PedirCitaPrimaria() {
		seleccion = new Seleccion();
		horario= new VistaCitaIssam();
		Mensaje mensaje = new Mensaje();
		
		JLabel lblNewLabel = new JLabel("Cita Atencion Primaria");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(horario, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 513, Short.MAX_VALUE)
						.addComponent(seleccion, GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
						.addComponent(lblNewLabel)
						.addComponent(mensaje, GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(seleccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(horario, GroupLayout.PREFERRED_SIZE, 318, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(mensaje, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		setLayout(groupLayout);

	}
	
	public Mensaje getMensajePedirCitaPrimaria() {
		return mensaje;
	}

	public void setMensajePedirCitaPrimaria(Mensaje mensaje) {
		this.mensaje = mensaje;
	}

	public String getTextField() {
		return mensaje.getTextField().getText();
	}

	public Seleccion getSeleccion() {
		return seleccion;
	}

	public VistaCitaIssam getHorario() {
		return horario;
	}

}
