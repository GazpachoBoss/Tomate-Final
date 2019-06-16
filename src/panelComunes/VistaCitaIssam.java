package panelComunes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Stack;

public class VistaCitaIssam extends JPanel {

	private JPanel panel;
	private JButton boton;
	private JButton[][]botonera = new JButton[4][5];
	private JComboBox cmbMedico;
	private JLabel lblHoraUno;
	private JLabel lblHoraDos;
	private JLabel lblHora3;
	private JLabel lblHora4;
	public VistaCitaIssam() {
		setBounds(100, 100, 750, 485);
		JLabel lblTipo = new JLabel("Medico");
		cmbMedico = new JComboBox();
		panel = new JPanel();
		crearBotonera();
		JLabel lblLunes = new JLabel("Lunes");
		
		JLabel lblMartes = new JLabel("Martes");
		
		JLabel lblMiercoles = new JLabel("Miercoles");
		
		JLabel lblJueves = new JLabel("Jueves");
		
		JLabel lblViernes = new JLabel("Viernes");
		
		lblHoraUno = new JLabel("8:00");
		
		lblHoraDos = new JLabel("9:00");
		
		lblHora4 = new JLabel("11:00");
		
		lblHora3 = new JLabel("10:00");
		GroupLayout gl_contentPane = new GroupLayout(this);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTipo)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(cmbMedico, 0, 232, Short.MAX_VALUE)
					.addGap(439))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(157)
							.addComponent(lblLunes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(45)
							.addComponent(lblMartes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(35)
							.addComponent(lblMiercoles, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(40)
							.addComponent(lblJueves, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(50)
							.addComponent(lblViernes, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(83)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblHoraUno)
								.addComponent(lblHora4)
								.addComponent(lblHora3)
								.addComponent(lblHoraDos))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)))
					.addGap(198))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTipo)
						.addComponent(cmbMedico, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(38)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblViernes)
								.addComponent(lblLunes)
								.addComponent(lblMartes)
								.addComponent(lblMiercoles)
								.addComponent(lblJueves))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
							.addGap(129))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(70)
							.addComponent(lblHoraUno, GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
							.addGap(39)
							.addComponent(lblHoraDos, GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
							.addGap(42)
							.addComponent(lblHora3, GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
							.addGap(38)
							.addComponent(lblHora4, GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
							.addGap(141))))
		);
		panel.setLayout(new GridLayout(4, 5, 0, 0));
		this.setLayout(gl_contentPane);
	}
	private void crearBotonera() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 5; j++) {
				boton=new JButton();
				botonera[i][j]=boton;
				panel.add(boton);
			}
			
		}
		}
	
	public void asignarHorario(int[][]matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j]==0) {
                    botonera[i][j].setVisible(false);
                }
            }
        }
    }
	
	public JComboBox getCmbMedico() {
		return cmbMedico;
	}
	public JLabel getLblHoraUno() {
		return lblHoraUno;
	}
	public JLabel getLblHoraDos() {
		return lblHoraDos;
	}
	public JLabel getLblHora3() {
		return lblHora3;
	}
	public JLabel getLblHora4() {
		return lblHora4;
	}
	
	
}
