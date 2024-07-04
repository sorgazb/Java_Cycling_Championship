package demo;

public class Bicicleta implements Comparable<Bicicleta>{
	//Atributos de la Clase Bicicleta:
	private String nombreBicicleta;
	private double peso;
	
	//Constructor de la Clase Bicicleta:
	public Bicicleta(String nombreBicicleta, double peso) {
		this.nombreBicicleta = nombreBicicleta;
		this.peso = peso;
	}

	//Métodos Getters & Setters de la Clase Bicicleta:
	public String getNombreBicicleta() {
		return nombreBicicleta;
	}

	public void setNombreBicicleta(String nombreBicicleta) {
		this.nombreBicicleta = nombreBicicleta;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	//Funcionalidad de la Clase Bicicleta:
	
	/*
	 * Método para obtener la velocidad de la Bicicleta cuando es usada por un Ciclista en una
	 * Etapa.
	 * Fórmula:velocidad = (habilidad del Ciclista * 100) / ( peso de la Bicicleta * dificultad de la etapa)
	 */
	public double obtenerVelocidadCiclista(Ciclista c, Etapa e) {
		double velocidad=0;
		velocidad=(c.getHabilidad()*100)/(peso*e.getDificultad());
		double scale = Math.pow(10, 2);
		velocidad = Math.ceil(velocidad * scale) / scale;
		return velocidad;
	}
	
	/*
	 * Método para obtener el tiempo que tardará un Ciclista en acabar una Etapa usando una Bicicleta.
	 * Fórmula:tiempo = (distancia de la Etapa / velocidad ) * 60;
	 */
	public double tiempoFinalizarEtapa(Ciclista c, Etapa e) {
		double tiempoNecesario=0;
		tiempoNecesario=(e.getDistancia()/obtenerVelocidadCiclista(c, e))*60;
		return tiempoNecesario;
	}

	/*
	 * Método de comparación de Bicicletas por peso.
	 */
	@Override
	public int compareTo(Bicicleta otraBicicleta) {
		int comparacion=0;
		
		if(peso > otraBicicleta.peso) {
			comparacion=1;
		}
		if(peso < otraBicicleta.peso) {
			comparacion=-1;
		}
		if(comparacion==0) {
			return getNombreBicicleta().compareTo(otraBicicleta.getNombreBicicleta());
		}
		return comparacion;
	}
	
	//Método toString que nos permite visualizar la información de la Bicicleta:
	@Override
	public String toString() {
		return "<bicicleta:"+nombreBicicleta+"> <peso="+peso+">";
	}
}
