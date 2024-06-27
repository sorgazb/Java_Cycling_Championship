package demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import demo.comparadores.ComparatorBicicletaNombre;
import demo.comparadores.ComparatorBicicletaPeso;
import demo.comparadores.ComparatorCiclistaEnergia;
import demo.comparadores.ComparatorCiclistaHabilidad;
import demo.comparadores.ComparatorCiclistaNombre;

public class Equipo {
	//Atributos de la Clase Equipo:
	private String nombreEquipo;
	public List<Ciclista> ciclistas;
	public List<Ciclista> ciclistasAbandonado;
	public List<Bicicleta> bicicletas;
	
	//Constructor de la Clase Equipo:
	public Equipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
		ciclistas= new ArrayList<Ciclista>();
		ciclistasAbandonado=new LinkedList<Ciclista>();
		bicicletas= new ArrayList<Bicicleta>();
	}
	
	
	//Metodos de la Clase Equipo:
	
	//
	public void ordenarCiclistasNombre() {
		ComparatorCiclistaNombre com= new ComparatorCiclistaNombre();
		Collections.sort(ciclistas,com);
	}
	
	//
	public void ordenarCiclistasEnergia() {
		ComparatorCiclistaEnergia com= new ComparatorCiclistaEnergia();
		Collections.sort(ciclistas,com);
	}
	
	//
	public void ordenarCiclistasHabilidad() {
		ComparatorCiclistaHabilidad com= new ComparatorCiclistaHabilidad();
		Collections.sort(ciclistas,com);
	}
	
	//
	public void ordenarBicicletasNombre() {
		ComparatorBicicletaNombre com= new ComparatorBicicletaNombre();
		Collections.sort(bicicletas,com);
	}
	
	//
	public void ordenarBicicletasPeso() {
		ComparatorBicicletaPeso com= new ComparatorBicicletaPeso();
		Collections.sort(bicicletas,com);
	}
	
	//
	public double obtenerTiempoAcumuladorEquipo() {
		double tiempoAcumulado=0;
		//Primer bucle FOR EACH para obtener el tiempo acumulado por los ciclistas que estan participando actualmente.
		for(Ciclista ciclista: ciclistas) {
			for(String etapa: ciclista.resultados.keySet()) {
				tiempoAcumulado+=ciclista.resultados.get(etapa);
			}
		}
		//Segundo bucle FOR EACH para obtener el tiempo acumulado por los ciclistas del equipo que han abandonado.
		for(Ciclista ciclista: ciclistasAbandonado) {
			for(String etapa: ciclista.resultados.keySet()) {
				if(ciclista.resultados.get(etapa)>0) {
					tiempoAcumulado+=ciclista.resultados.get(etapa);
				}
			}
		}
		return tiempoAcumulado;
	}
	
	//
	public void asignarBicicletasCiclista() {
		for (int i = 0; i < ciclistas.size(); i++) {
			if(!ciclistasAbandonado.contains(ciclistas.get(i))) {
				ciclistas.get(i).setBicicleta(bicicletas.get(i));
				}
		}
	}
	
	public void anadirBicicleta(Bicicleta b) {
		bicicletas.add(b);
	}
	
	public void anadirCiclista(Ciclista c) {
		ciclistas.add(c);
	}
	
}
