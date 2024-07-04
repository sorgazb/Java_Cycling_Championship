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
	
	//Métodos Getters & Setters de la Clase Equipo:
	public String getNombreEquipo() {
		return nombreEquipo;
	}

	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

	//Funcionalidad de la Clase Equipo:

	/*
	 * Método de ordenación de la Lista de Ciclistas según diferentes criterios de ordenación
	 * establecidos en la hoja de datos.
	 */
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
			System.err.println("ERROR.No contemplamos ese criterio de ordenación.");
		}
	}
	
	//Método que llama al Comparator de Energia y ordena el ArrayList.
	public void ordenarCiclistasEnergia() {
		ComparatorCiclistaEnergia com= new ComparatorCiclistaEnergia();
		Collections.sort(ciclistas,com);
	}
	
	//Método que llama al Comparator de Energia y ordena el ArrayList.(orden inverso)
	public void ordenarCiclistasEnergiaInverso() {
		ComparatorCiclistaEnergia com= new ComparatorCiclistaEnergia();
		Collections.sort(ciclistas,com);
		Collections.reverse(ciclistas);
	}
	
	//Método que llama al Comparator de Habilidad y ordena el ArrayList.
	public void ordenarCiclistasHabilidad() {
		ComparatorCiclistaHabilidad com= new ComparatorCiclistaHabilidad();
		Collections.sort(ciclistas,com);
	}
	
	//Método que llama al Comparator de Habilidad y ordena el ArrayList.(orden inverso)
	public void ordenarCiclistasHabilidadInverso() {
		ComparatorCiclistaHabilidad com= new ComparatorCiclistaHabilidad();
		Collections.sort(ciclistas,com);
		Collections.reverse(ciclistas);
	}
	
	/*
	 * Método de ordenación de la Lista de Bicicletas según diferentes criterios de ordenación
	 * establecidos en la hoja de datos.
	 */
	public void establecerOrdenBicicletas() {
		if(this.ordenBicicletas.equals("Ordenadas Ascendentemente por Peso")) {
			ordenarBicicletasPeso();
		}else if(this.ordenBicicletas.equals("Ordenadas Descendentemente por Peso")){
			ordenarBicicletasPesoInverso();
		}else {
			System.err.println("ERROR.No contemplamos ese criterio de ordenación.");
		}
	}
	
	//Método que llama al Comparator de Peso y ordena el ArrayList.)
	public void ordenarBicicletasPeso() {
		Collections.sort(bicicletas);
	}
	
	//Método que llama al Comparator de Peso y ordena el ArrayList.(orden inverso)
	public void ordenarBicicletasPesoInverso() {
		Collections.sort(bicicletas);
		Collections.reverse(bicicletas);
	}
	
	//Método que devuelve el tiempo total acumulado por el equipo.
	public double obtenerTiempoAcumuladorEquipo() {
		double tiempoAcumulado=0;
		//Primer bucle FOR EACH para obtener el tiempo acumulado por los ciclistas que estan participando actualmente.
		for(Ciclista ciclista: ciclistas) {
			for(String etapa: ciclista.resultados.keySet()) {
				tiempoAcumulado=tiempoAcumulado+ciclista.resultados.get(etapa);
			}
		}
		//Segundo bucle FOR EACH para obtener el tiempo acumulado por los ciclistas del equipo que han abandonado.
		for(Ciclista ciclista: ciclistasAbandonado) {
			for(String etapa: ciclista.resultados.keySet()) {
				if(ciclista.resultados.get(etapa)>0) {
					tiempoAcumulado=tiempoAcumulado+ciclista.resultados.get(etapa);
				}
			}
		}
		return tiempoAcumulado;
	}
	
	//Método que devuelve el la media de minutos de los Ciclistas del Equipo que no han Abandonado. 
	public double obtenerMediaMinutosSinAbandonar() {
		int numeroCiclista=0;
		double minutosAcumulados=0;
		for(Ciclista ciclista: ciclistas) {
			for(String etapa: ciclista.resultados.keySet()) {
				if(ciclista.resultados.get(etapa)!=null) {
					minutosAcumulados = minutosAcumulados+ciclista.resultados.get(etapa);
				}
			}
			numeroCiclista++;
		}
		double media=minutosAcumulados/numeroCiclista;
		double scale = Math.pow(10, 2);
		media = Math.ceil(media * scale) / scale;
		if(minutosAcumulados==0) {
			media=0.0;
		}
		return media;
	}
	
	//Método que asigna a cada Ciclista una Bicicleta, según los criterios de ordenacón establecidos.
	public void asignarBicicletasCiclista() {
		for (int i = 0; i < ciclistas.size(); i++) {
			if(!ciclistasAbandonado.contains(ciclistas.get(i))) {
				ciclistas.get(i).setBicicleta(bicicletas.get(i));
			}
		}
	}
	
	//Método para añadir una Bicicleta al ArrayList de Bicicletas.
	public void anadirBicicleta(Bicicleta b) {
		bicicletas.add(b);
	}
	
	//Método para añadir un Ciclista al ArrayList de Ciclistas.
	public void anadirCiclista(Ciclista c) {
		ciclistas.add(c);
	}
	
	//Método toString que nos permite obtener la información del Equipo que será mostrada por pantalla.
	@Override
	public String toString() {
		return "%%%"+this.nombreEquipo+"%%% Media Minutos de Ciclistas sin abandonar "+obtenerMediaMinutosSinAbandonar()+"%%%";
	}
	
}
