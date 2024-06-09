package demo;

import java.util.List;
import java.util.Map;

public class Ciclista {
	
	private String nombreCiclista;
	private Bicicleta bicicleta;
	private double habilidad;
	private double energia;
	private Map<String, Double> resultados;
	
	
	public double getHabilidad() {
		return habilidad;
	}
	public void setHabilidad(double habilidad) {
		this.habilidad = habilidad;
	}
	public double getEnergia() {
		return energia;
	}
	public void setEnergia(double energia) {
		this.energia = energia;
	}
	
	
}
