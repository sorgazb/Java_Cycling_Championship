package demo;

import java.util.HashMap;
import java.util.Map;

public class Ciclista {
	
	private String nombreCiclista;
	private Bicicleta bicicleta;
	private double habilidad;
	private double energia;
	private Map<String, Double> resultados;
	
	
	
	public Ciclista(String nombreCiclista, Bicicleta bicicleta, double habilidad, double energia) {
		this.nombreCiclista = nombreCiclista;
		this.bicicleta = bicicleta;
		this.habilidad = habilidad;
		this.energia = energia;
		this.resultados = new HashMap<String, Double>();
	}
	public String getNombreCiclista() {
		return nombreCiclista;
	}
	public void setNombreCiclista(String nombreCiclista) {
		this.nombreCiclista = nombreCiclista;
	}
	public Bicicleta getBicicleta() {
		return bicicleta;
	}
	public void setBicicleta(Bicicleta bicicleta) {
		this.bicicleta = bicicleta;
	}
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
	
	public boolean haAbandonado() {
		boolean haAbandonado=false;
		if(energia<=0) {
			haAbandonado=true;
		}
		return haAbandonado;
	}
	
	
}
