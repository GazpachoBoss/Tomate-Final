package panelComunes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.Especialidades;
import Modelo.Medico;
import Modelo.MedicoActivo;
import control.GestionHorario;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MAIN extends JFrame {

	private JPanel contentPane;
//	Seleccion select=new Seleccion();
//	Identificacion identi = new Identificacion();
	VistaCitaIssam citaIssam=new VistaCitaIssam();
	GestionHorario gestionHorario=new GestionHorario();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MAIN frame = new MAIN();
//					frame.add(citaIssam);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MAIN() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(citaIssam);
		setContentPane(contentPane);
		MedicoActivo medico= new MedicoActivo("1", "pepito", "mas", "642", Especialidades.AtencionPrimaria);
		MedicoActivo medico2= new MedicoActivo("1", "pepito", "mas", "642", Especialidades.AtencionPrimaria);
		gestionHorario.ocuparConsultaPrimaria(1, medico);
		gestionHorario.ocuparConsultaEspecialista(0, medico2);
		citaIssam.getCmbMedico().addItem(medico);
		citaIssam.getCmbMedico().addItem(medico2);
		JButton btnAplicar = new JButton("Aplicar");
		btnAplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MedicoActivo medicoMio=(MedicoActivo) citaIssam.getCmbMedico().getSelectedItem();
				limpiarBotonera();
				int []dias=new int[medicoMio.getHorarioConsulta().getDiaTrabajo().length];
				for (int i = 0; i < dias.length; i++) {
					dias[i]=medicoMio.getHorarioConsulta().getDiaTrabajo()[i].getValor()-1;
				}
				citaIssam.asignarLabels(dias, medicoMio.getHorarioConsulta().getHoraTrabajo());
				medicoMio.getHorarioConsulta().reservarDias();
				citaIssam.asignarHorario(medicoMio.getHorarioConsulta().getHorarioSemanal());
			}
		});
		for (int i = 0; i < citaIssam.botonera.length; i++) {
			for (int j = 0; j < citaIssam.botonera[i].length; j++) {
				citaIssam.botonera[i][j].addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						JButton boton = (JButton) e.getSource();
						MedicoActivo medicoMio=(MedicoActivo) citaIssam.getCmbMedico().getSelectedItem();
						int hora = Integer.valueOf(Character.toString(boton.getName().charAt(0)));
						int dia = Integer.valueOf(Character.toString(boton.getName().charAt(1)));
						medicoMio.getHorarioConsulta().seleccionarDia(hora, dia);
						citaIssam.asignarHorario(medicoMio.getHorarioConsulta().getHorarioSemanal());
					System.out.println(hora + " " + dia);
					}
				});
			}
		}
		contentPane.add(btnAplicar, BorderLayout.NORTH);
		
	}
	public void limpiarBotonera() {
		for (int i = 0; i < citaIssam.botonera.length; i++) {
			for (int j = 0; j < citaIssam.botonera[i].length; j++) {
				citaIssam.botonera[i][j].setBackground(new JButton().getBackground());
			}
	}
	}

}