package demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import demo.comparadores.ComparatorCiclistaEnergia;
import demo.comparadores.ComparatorCiclistaHabilidad;


public class Equipo {
	//Atributos de la Clase Equipo:
	private String nombreEquipo;
	public List<Ciclista> ciclistas;
	public List<Ciclista> ciclistasAbandonado;
	public List<Bicicleta> bicicletas;
	private String ordenCiclista;
	private String ordenBicicletas;
	
	//Constructor de la Clase Equipo:
	public Equipo(String nombreEquipo,String ordenCiclista,String ordenBicicletas) {
		this.nombreEquipo = nombreEquipo;
		ciclistas= new ArrayList<Ciclista>();
		ciclistasAbandonado=new LinkedList<Ciclista>();
		bicicletas= new ArrayList<Bicicleta>();
		this.ordenCiclista=ordenCiclista;
		this.ordenBicicletas=ordenBicicletas;
	}
	
	
	
	
	//Metodos de la Clase Equipo:
	
	public String getNombreEquipo() {
		return nombreEquipo;
	}




	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}




	//
	public void establecerOrdenCiclistas() {
		if(this.ordenCiclista.equals("Ordenados Ascendentemente por Habilidad")) {
			ordenarCiclistasHabilidad();
		}else if(this.ordenCiclista.equals("Ordenados Descendentemente por Habilidad")){
			ordenarCiclistasHabilidadInverso();
		}else if(this.ordenCiclista.equals("Ordenados Ascendentemente por Energia")){
			ordenarCiclistasEnergia();
		}else if(this.ordenCiclista.equals("Ordenados Descendentemente por Energia")) {
			ordenarCiclistasEnergiaInverso();
		}else {
			System.err.println("ERROR.No contemplamos ese criterio de ordenacion.");
		}
	}
	
	//
	public void ordenarCiclistasEnergia() {
		ComparatorCiclistaEnergia com= new ComparatorCiclistaEnergia();
		Collections.sort(ciclistas,com);
	}
	
	//
	public void ordenarCiclistasEnergiaInverso() {
		ComparatorCiclistaEnergia com= new ComparatorCiclistaEnergia();
		Collections.sort(ciclistas,com);
		Collections.reverse(ciclistas);
	}
	
	//
	public void ordenarCiclistasHabilidad() {
		ComparatorCiclistaHabilidad com= new ComparatorCiclistaHabilidad();
		Collections.sort(ciclistas,com);
	}
	
	//
	public void ordenarCiclistasHabilidadInverso() {
		ComparatorCiclistaHabilidad com= new ComparatorCiclistaHabilidad();
		Collections.sort(ciclistas,com);
		Collections.reverse(ciclistas);
	}
	
	//
	public void establecerOrdenBicicletas() {
		if(this.ordenCiclista.equals("Ordenadas Ascendentemente por Peso")) {
			ordenarBicicletasPeso();
		}else if(this.ordenCiclista.equals("Ordenadas Descendentemente por Peso")){
			ordenarBicicletasPesoInverso();
		}else {
			System.err.println("ERROR.No contemplamos ese criterio de ordenacion.");
		}
	}
	
	//
	public void ordenarBicicletasPeso() {
		Collections.sort(bicicletas);
	}
	
	//
	public void ordenarBicicletasPesoInverso() {
		Collections.sort(bicicletas);
		Collections.reverse(bicicletas);
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
	public double obtenerMediaMinutosSinAbandonar() {
		int numeroCiclista=0;
		double minutosAcumulados=0;
		for(Ciclista ciclista: ciclistas) {
			for(String etapa: ciclista.resultados.keySet()) {
				if(ciclista.resultados.get(etapa)!=null) {
					minutosAcumulados+=ciclista.resultados.get(etapa);
				}
				numeroCiclista++;
			}
		}
		double media=minutosAcumulados/numeroCiclista;
		return media;
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
	
	@Override
	public String toString() {
		return "%%%"+this.nombreEquipo+"%%% Media Minutos de Ciclistas sin abandonar "+obtenerMediaMinutosSinAbandonar()+"%%%";
	}
	
}
