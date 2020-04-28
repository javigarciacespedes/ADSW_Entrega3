package es.upm.dit.adsw.practica3;

public class Tarea extends Thread{
	
	
	private Vehiculo coche;
	private Vector destino;
	private int vueltas;
	
	public Tarea(Vector destino, int vueltas, Vehiculo coche) {
		this.destino = destino;
		this.vueltas = vueltas;
		this.coche = coche;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Vector pos_inicial = coche.getPos();
		
		if(vueltas == 1) {
			coche.irA(destino);
		}
		else if(vueltas == 2) {
			coche.irA(destino);
			coche.irA(pos_inicial);
		}else if(vueltas > 2 && vueltas%2 == 1){
				int num_idas = Math.round(vueltas/2); //irA => destino
				int num_vueltas = vueltas - num_idas; //irA => pos_inicial
				while(vueltas>0) {
					if(num_idas>num_vueltas) {
						coche.irA(destino);
					}
					if(num_idas == num_vueltas) {
						coche.irA(pos_inicial);
					}
					if(vueltas%2 == 1) {
						num_idas--;
					}else {
						num_vueltas--;
					}
					vueltas--;
				}
		}
		else if(vueltas > 2 && vueltas%2 == 0) {
			int num_idas = vueltas/2;
			int num_vueltas = num_idas;
			while(vueltas>0) {
				if(num_idas == num_vueltas) {
					coche.irA(destino);
				}
				if(num_vueltas>num_idas) {
					coche.irA(pos_inicial);
				}
				if(vueltas%2 == 0) {
					num_idas--;
				}
				else {
					num_vueltas--;
				}
				vueltas--;
			}
		}
		
		/*
		int caso = 0;
		switch(caso) {
		case(1):
			coche.irA(destino);
			break;
		case(2):
			coche.irA(destino);
			coche.irA(pos_actual);
			break;
		case(3):
			coche.irA(destino);
			coche.irA(pos_actual);
			coche.irA(destino);
			break;
		case(4):
			coche.irA(destino);
			coche.irA(pos_actual);
			coche.irA(destino);
			coche.irA(pos_actual);
			break;
		}
		*/
	}
	
	
	
}

