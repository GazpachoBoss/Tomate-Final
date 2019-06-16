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

	public int[][] getHorarioSemanal() {
		return horarioSemanal;
	}

	public LocalTime[] getHoraTrabajo() {
		return horaTrabajo;
	}

	public DiasDeLaSemana[] getDiaTrabajo() {
		return diaTrabajo;
	}

	public void seleccionarDia (int x,int y) {
		if (horarioSemanal[x][y]!=2&&horarioSemanal[x][y]!=3) {
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
	
	public String toString() {
		return horaTrabajo[0].toString();
	}
}
