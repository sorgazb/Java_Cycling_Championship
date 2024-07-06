package demo;
import java.util.HashMap;
import java.util.Map;

import demo.enums.HabilidadCiclista;

public class Ciclista{
	
	//Atributos de la Clase Ciclista:
	private String nombreCiclista;
	private Bicicleta bicicleta;
	private HabilidadCiclista habilidad;
	private double energia;
	private Equipo equipo;
	public Map<String, Double> resultados;
	
	//Constructor de la Clase Ciclista:
	public Ciclista(String nombreCiclista, HabilidadCiclista habilidad, double energia, Equipo equipo){
		this.nombreCiclista = nombreCiclista;
		this.bicicleta = null;
		this.habilidad = habilidad;
		this.energia = energia;
		this.resultados = new HashMap<String, Double>();
		this.equipo=equipo;
	}
	
	//Métodos Getters & Setters de la Clase Ciclista:
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
	public HabilidadCiclista getHabilidad() {
		return habilidad;
	}
	public void setHabilidad(HabilidadCiclista habilidad) {
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

	//Método para comprobar si tiene bicicleta para participar en la etapa.
	public boolean tieneBicileta() {
		boolean tiene=true;
		if(getBicicleta()==null) {
			setEnergia(0);
			tiene=false;
		}
		return tiene;
	}
	
	//Método que nos informa si el ciclista ha abandonado o no:
	public boolean haAbandonado() {
		boolean haAbandonado=false;
		if(energia<=0) {
			haAbandonado=true;
			setEnergia(0);
		}
		return haAbandonado;
	}
	
	//Método que nos devuelve el resultado de una Etapa en concreto:
	public void obtenerResultadoEtapa(Etapa e) {
		if(haAbandonado()==false) {
			for(String etapa:resultados.keySet()) {
				if(etapa.equals(e.getNombreEtapa())) {
					System.out.println(getNombreCiclista()+" - Tiempo: "+resultados.get(etapa)+" minutos @@@");
				}
			}
		}else {
			for(String etapa:resultados.keySet()) {
				if(etapa.equals(e.getNombreEtapa())) {
					
					double resultado=resultados.get(etapa);
					double scale = Math.pow(10, 2);
					resultado = Math.ceil(resultado * scale) / scale;
					System.out.println(getNombreCiclista()+" - Tiempo: "+resultado+" -Además ha abandonado para el resto del campeonato !!!");;
				}
			}
		}

	}
	
	//Método que nos devuelve el tiempo concreto que tardó el Ciclista en acabar la Etapa:
	public double obtenerResultadoEtapaTiempo(Etapa e) {
		double tiempo=0;
		for(String etapa:resultados.keySet()) {
			if(etapa.equals(e.getNombreEtapa())) {
				tiempo=resultados.get(etapa);
			}
		}
		return tiempo;
	}
	
	//Método con el cual podemos obtener todas las estadésticas de los resultados del Ciclista:
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
	 * Método que nos permite usar la Bicicleta en la Etapa asignada, almacenando en el mapa de Resultados
	 * los distintos posibles resultados. 
	 */
	public void usarBicicletaEtapa(Bicicleta b, Etapa e) {
		double energiaInicial=energia;
		double tiempo=b.tiempoFinalizarEtapa(this, e);
		double scale = Math.pow(10, 2);
		tiempo = Math.ceil(tiempo * scale) / scale;
		setEnergia(getEnergia()-tiempo);
		this.energia=Math.ceil(getEnergia() * scale) / scale;
		if(haAbandonado()==true) {
			resultados.put(e.getNombreEtapa(), (energiaInicial-tiempo));
		}else {
			if(resultados.isEmpty()) {
				resultados.put(e.getNombreEtapa(), tiempo);
			}else {
				resultados.put(e.getNombreEtapa(), tiempo);
			}
		}
		double energiaNegativa=(energiaInicial-tiempo);
		System.out.println("+++ Con estas condiciones el ciclista "+getNombreCiclista()+" con la bicicleta "+b.getNombreBicicleta()+
				"alcanza una velocidad de "+b.obtenerVelocidadCiclista(this, e)+"km/hora +++");
		if(haAbandonado()==false) {
			System.out.println("+++ "+getNombreCiclista()+" termina la etapa en "+tiempo+" minutos +++");
		}else {
			System.out.println(tiempo);
			System.out.println("!!! El ciclista "+nombreCiclista+" se quedó sin energía a falta de "+"   "+" minutos para terminar !!!");
			System.out.println("!!! En el momento de quedarse sin energía llevaba en la carrera "+(tiempo-(-(energiaNegativa))) +" minutos !!!");
		}
		if(energia==0) {
			energiaNegativa = Math.ceil(energiaNegativa * scale) / scale;
			System.out.println("+++ La energía del ciclista "+getNombreCiclista()+" tras la carrera es de "+energiaNegativa+"+++");
		}else {
			System.out.println("+++ La energía del ciclista "+getNombreCiclista()+" tras la carrera es de "+getEnergia()+"+++");
		}
	}
	
	
	//Método que nos devuelve el tiempo total que ha realizado el Ciclista sin contar abandonos.
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
	
	//Método que nos devuelve todos los resultados del Ciclista almacenados en el Mapa de ResultadosÑ
	public void obtenerTodosResultados() {
		for(String etapa:resultados.keySet()) {
			double resultado=resultados.get(etapa);
			double scale = Math.pow(10, 2);
			resultado = Math.ceil(resultado * scale) / scale;
			System.out.println("Carrera("+etapa+") - Tiempo: "+resultado+" minutos @@@");
		}
	}
	
	//
	public double obtenerDestreza() {
		double destreza=0;
		return destreza;
	}
	
	//Método toString que devuelve por pantalla toda la información del Ciclista.
	@Override
	public String toString() {
		return "<ciclista:"+nombreCiclista+"> <energía:"+energia+"> <habilidad:"+habilidad+"> <tiempo acumulado sin abandonar:"+obtenerTiempoAcumuladoSinAbandonar()+"> <abandonado:"+haAbandonado()+">";
	}
		
}
