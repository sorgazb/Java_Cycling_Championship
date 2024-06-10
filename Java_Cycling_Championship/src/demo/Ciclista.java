package demo;

import java.util.HashMap;
import java.util.Map;

public class Ciclista {
	
	//Atributos de la Clase Ciclista:
	private String nombreCiclista;
	private Bicicleta bicicleta;
	private double habilidad;
	private double energia;
	private Map<String, Double> resultados;
	
	//Constructor de la Clase Ciclista:
	public Ciclista(String nombreCiclista, Bicicleta bicicleta, double habilidad, double energia) {
		this.nombreCiclista = nombreCiclista;
		this.bicicleta = bicicleta;
		this.habilidad = habilidad;
		this.energia = energia;
		this.resultados = new HashMap<String, Double>();
	}
	
	//Metodos Getters & Setters de la Clase Ciclista:
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
	
	//Funcionalidades de la Clase Ciclista:
	
	//Metodo que nos informa si el ciclista ha abandonado o no:
	public boolean haAbandonado() {
		boolean haAbandonado=false;
		if(energia<=0) {
			haAbandonado=true;
			setEnergia(0);
		}
		return haAbandonado;
	}
	
	//Metodo que nos devuelve el resultado de una Etapa en concreto:
	public void obtenerResultadoEtapa(Etapa e) {
		for(String etapa:resultados.keySet()) {
			if(etapa.equals(e.getNombreEtapa())) {
				System.out.println("Carrera("+etapa+") - Tiempo: "+resultados.get(etapa));
			}
		}
	}
	
	public void usarBicicletaEtapa(Bicicleta b, Etapa e) {
		double tiempo=b.tiempoFinalizarEtapa(this, e);
		setEnergia(getEnergia()-tiempo);
		if(haAbandonado()==true) {
			resultados.put(e.getNombreEtapa(), tiempo);
		}else {
			if(resultados.isEmpty()) {
				resultados.put(e.getNombreEtapa(), tiempo);
			}else {
				resultados.put(e.getNombreEtapa(), tiempo);
			}
		}
	}
	
}
