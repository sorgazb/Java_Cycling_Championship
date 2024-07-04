package demo;

import demo.enums.DificultadEtapa;
import demo.enums.DistanciaEtapa;

public class Etapa {
	//Atributos de la Clase Etapa:
	private String nombreEtapa;
	private DificultadEtapa dificultad;
	private DistanciaEtapa distancia;
	
	//Constructor parametrizado de la Clase Etapa:
	public Etapa(String nombreEtapa, DificultadEtapa dificultad, DistanciaEtapa distancia) {
		this.nombreEtapa = nombreEtapa;
		this.dificultad = dificultad;
		this.distancia = distancia;
	}
	
	//Métodos Getters & Setters de la Clase Etapa:
	public String getNombreEtapa() {
		return nombreEtapa;
	}
	public void setNombreEtapa(String nombreEtapa) {
		this.nombreEtapa = nombreEtapa;
	}
	public DificultadEtapa getDificultad() {
		return dificultad;
	}
	public void setDificultad(DificultadEtapa dificultad) {
		this.dificultad = dificultad;
	}
	public DistanciaEtapa getDistancia() {
		return distancia;
	}
	public void setDistancia(DistanciaEtapa distancia) {
		this.distancia = distancia;
	}

	//Funcionalidad de la Clase Etapa:
	
	//Método toString: nos permite mostrar las características de la Etapa:
	@Override
	public String toString() {
		return "<etapa:"+nombreEtapa+"> <dificultad:"+dificultad+"> <distancia:"+distancia+">";
	}
	
}
