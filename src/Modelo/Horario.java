package Modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Horario implements Serializable{
	private int horarioSemanal[][] = new int[4][5];
	private LocalTime horaTrabajo[];
	private DiasDeLaSemana diaTrabajo[];

	public Horario(LocalTime[] horaTrabajo, DiasDeLaSemana[] diaTrabajo) {
		super();
		this.horaTrabajo = horaTrabajo;
		this.diaTrabajo = diaTrabajo;
		for (int i = 0; i < diaTrabajo.length; i++) {
			for (int j = 0; j < horaTrabajo.length; j++) {
				horarioSemanal[horaTrabajo[j].getHour()%4][diaTrabajo[i].getValor()-1] = 1;
			}
		}
	}
	public LocalDateTime getFechaCita() {
		LocalTime hora;
		LocalDateTime dia;
		for (int i = 0; i < horarioSemanal.length; i++) {
			for (int j = 0; j < horarioSemanal[i].length; j++) {
				if(horarioSemanal[i][j]==2) {
					hora=horaTrabajo[i];
					dia=LocalDateTime.of(LocalDate.now().getYear(),LocalDate.now().getMonth(),0,hora.getHour(),hora.getMinute());
				}
			}
		}
		return null;
		}

	public int[][] getHorarioSemanal() {
		return horarioSemanal;
	}

	public LocalTime[] getHoraTrabajo() {
		return horaTrabajo;
	}

	public DiasDeLaSemana[] getDiaTrabajo() {
		return diaTrabajo;
	}
	private boolean canCita() {
		int contador=0;
		for (int i = 0; i < horarioSemanal.length; i++) {
			for (int j = 0; j < horarioSemanal.length; j++) {
				if (horarioSemanal[i][j]==2) {
					contador++;
				}
			}
		}
		return contador<1;
	}
	public void seleccionarDia (int x,int y) {
		if (horarioSemanal[x][y]!=2&&horarioSemanal[x][y]!=3&&canCita()) {
			horarioSemanal[x][y]=2;
		}else {
		horarioSemanal[x][y]=1;
		}
	}
	public void reservarDias() {
		for (int i = 0; i < horarioSemanal.length; i++) {
			for (int j = 0; j < horarioSemanal[i].length; j++) {
				if (horarioSemanal[i][j]==2) {
					horarioSemanal[i][j]=3;
				}
			}
		}
	}
	private void getDia(int x) {
		String retorno="";
		for (int i = 0; i < diaTrabajo.length; i++) {
			if(diaTrabajo[i].getValor()==x) {
			retorno=diaTrabajo[i].name();
			}
		}
	}
}