package demo;

public class Etapa {
	//Atributos de la Clase Etapa:
	private String nombreEtapa;
	private double dificultad;
	private double distancia;
	
	//Constructor parametrizado de la Clase Etapa:
	public Etapa(String nombreEtapa, double dificultad, double distancia) {
		this.nombreEtapa = nombreEtapa;
		this.dificultad = dificultad;
		this.distancia = distancia;
	}
	
	//Metodos Getters & Setters de la Clase Etapa:
	public String getNombreEtapa() {
		return nombreEtapa;
	}
	public void setNombreEtapa(String nombreEtapa) {
		this.nombreEtapa = nombreEtapa;
	}
	public double getDificultad() {
		return dificultad;
	}
	public void setDificultad(double dificultad) {
		this.dificultad = dificultad;
	}
	public double getDistancia() {
		return distancia;
	}
	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	//Funcionalidad de la Clase Etapa:
	
	//Metodo toString: nos permite mostrar las caracteristicas de la Etapa:
	@Override
	public String toString() {
		return "<etapa:"+nombreEtapa+"> <dificultad:"+dificultad+"> <distancia:"+distancia+">";
	}
	
	
	
}
