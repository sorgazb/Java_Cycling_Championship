package demo;

import java.util.HashMap;
import java.util.Map;

public class Ciclista{
	
	//Atributos de la Clase Ciclista:
	private String nombreCiclista;
	private Bicicleta bicicleta;
	private double habilidad;
	private double energia;
	private Equipo equipo;
	public Map<String, Double> resultados;
	
	//Constructor de la Clase Ciclista:
	public Ciclista(String nombreCiclista, double habilidad, double energia, Equipo equipo){
		this.nombreCiclista = nombreCiclista;
		this.bicicleta = null;
		this.habilidad = habilidad;
		this.energia = energia;
		this.resultados = new HashMap<String, Double>();
		this.equipo=equipo;
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
	public Equipo getEquipo() {
		return equipo;
	}
	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	
	//Funcionalidades de la Clase Ciclista:

	//Metodo para comprobar si tiene bicicleta para participar en la etapa.
	public boolean tieneBicileta() {
		boolean tiene=true;
		if(getBicicleta()==null) {
			setEnergia(0);
			tiene=false;
		}
		return tiene;
	}
	
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
				System.out.println(getNombreCiclista()+" - Tiempo: "+resultados.get(etapa)+" minutos @@@");
			}
		}
	}
	
	//Metodo con el cual podemos obtener todas las estadisticas de los resultados del Ciclista:
	public void obtenerInformacionResultados() {
		int numeroEtapas=0;
		double tiempoAcumulado=0;
		String nombreEtapaAbandono="";
		for(String etapa:resultados.keySet()) {
			if(resultados.get(etapa)<0){
				numeroEtapas++;
				nombreEtapaAbandono=etapa;
			}else {
				numeroEtapas++;
				tiempoAcumulado+=resultados.get(etapa);
			}
		}
		System.out.println("Ha participado en "+numeroEtapas+" etapas.");
		System.out.println("Ha acumulado "+tiempoAcumulado+" minutos.");
		if(!nombreEtapaAbandono.equals("")) {
			System.out.println("Abandonó en la Etapa "+nombreEtapaAbandono+".");
		}
	}
	
	/*
	 * Metodo que nos permite usar la Bicicleta en la Etapa asignada, almacenando en el mapa de Resultados
	 * los distintos posibles resultados. 
	 */
	public void usarBicicletaEtapa(Bicicleta b, Etapa e) {;
		double tiempo=b.tiempoFinalizarEtapa(this, e);
		double scale = Math.pow(10, 2);
		tiempo = Math.ceil(tiempo * scale) / scale;
		setEnergia(getEnergia()-tiempo);
		this.energia=Math.ceil(getEnergia() * scale) / scale;
		if(haAbandonado()==true) {
			resultados.put(e.getNombreEtapa(), tiempo);
		}else {
			if(resultados.isEmpty()) {
				resultados.put(e.getNombreEtapa(), tiempo);
			}else {
				resultados.put(e.getNombreEtapa(), tiempo);
			}
		}
		System.out.println("+++ Con estas condiciones el ciclista "+getBicicleta()+" con la bicicleta "+b.getNombreBicicleta()+
				"alcanza una velocidad de "+b.obtenerVelocidadCiclista(this, e)+"km/hora +++");
		System.out.println("+++ "+getNombreCiclista()+" termina la etapa en "+tiempo+" minutos +++");
		System.out.println("+++ La energia del ciclista "+getNombreCiclista()+" tras la carrera es de "+getEnergia()+"+++");
	}
	
	public double obtenerTiempoAcumuladoSinAbandonar() {
		double tiempoAcumulado=0;
		for(String etapa:resultados.keySet()) {
			if(resultados.get(etapa)>0){
				tiempoAcumulado= tiempoAcumulado+resultados.get(etapa);
			}
		}
		double scale = Math.pow(10, 2);
		tiempoAcumulado = Math.ceil(tiempoAcumulado * scale) / scale;
		return tiempoAcumulado;
	}
	
	public void obtenerTodosResultados() {
		for(String etapa:resultados.keySet()) {
			System.out.println("Carrera("+etapa+") - Tiempo: "+resultados.get(etapa)+" minutos @@@");
		}
	}
	
	@Override
	public String toString() {
		return "<ciclista:"+nombreCiclista+"> <energia:"+energia+"> <habilidad:"+habilidad+"> <tiempo acumulado sin abandonar:"+obtenerTiempoAcumuladoSinAbandonar()+"> <abandonado:"+haAbandonado()+">";
	}
		
}
