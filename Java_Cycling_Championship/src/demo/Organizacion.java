package demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import demo.comparadores.ComparatorCiclistaEnergia;
import demo.comparadores.ComparatorCiclistasTiempoSinAbandonar;
import demo.comparadores.ComparatorEquiposNombre;

public class Organizacion {
	private Comparator<Etapa> comparadorEtapa;
	private List<Etapa> etapas;
	private List<Equipo> equipos;
	private List<Ciclista> ciclistasCarrera;

	public Organizacion(Comparator<Etapa> comparadorEtapa) {
		this.comparadorEtapa = comparadorEtapa;
		this.etapas=new ArrayList<Etapa>();
		this.equipos=new ArrayList<Equipo>();
		this.ciclistasCarrera=new ArrayList<Ciclista>();
	}

	public void anadirEtapa(Etapa e) {
		etapas.add(e);
	}
	
	public void inscribirEquipo(Equipo e) {
		equipos.add(e);
	}
	
	public void gestionarCampeonato() {
		for(Equipo equipo:equipos) {
			equipo.establecerOrdenCiclistas();
			equipo.establecerOrdenBicicletas();
		}
		etapas.sort(comparadorEtapa);
		mostrarEtapasCampeonato();
		equipos.sort(new ComparatorEquiposNombre());
		mostrarEquiposCampeonato();
		simularEtapas();
		obtenerResultadoFinalCampeonatoCiclistas();
		obtenerResultadosFinalCampeonatoEquipos();
	}
	
	public void inscribirCiclistasCarrera() {
		for(Equipo equipo:equipos) {
			equipo.asignarBicicletasCiclista();
			for(Ciclista ciclista:equipo.ciclistas) {
				if(ciclista.haAbandonado()==false) {
					ciclistasCarrera.add(ciclista);
				}
			}
		}
	}
	
	public void mostrarEtapasCampeonato() {
		System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		System.out.println("||||||||||||||||||| ETAPAS DEL CAMPEONATO ||||||||||||||||||||||");
		System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		for(Etapa etapa:etapas) {
			System.out.println(etapa);
		}
		System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||\n");
	}
	
	public void mostrarEquiposCampeonato() {
		inscribirCiclistasCarrera();
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println("%%%%%%%%% EQUIPOS DEL CAMPEONATO %%%%%%%%%%");
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		for(Equipo equipo:equipos) {
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
			System.out.println(equipo+"\n");
			for(Ciclista ciclista:equipo.ciclistas) {
				System.out.println(ciclista);
			}
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		}
		System.out.println("\n");
	}
	
	public void simularEtapas() {
		int contador=1;
		for(Etapa etapa:etapas) {
			System.out.println("********************************************************************************************************");
			System.out.println("************* CARRERA<"+contador+"> EN "+etapa+" *************");
			System.out.println("********************************************************************************************************");
			System.out.println("********************************************************************************************************");
			System.out.println("************************** Ciclistas que van a competir en"+ etapa.getNombreEtapa() +" *************************");
			System.out.println("********************************************************************************************************");
			ordenarCiclistasTiempoSinAbandonar();
			mostrarCiclistasCompetirEtapa();
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("+++++++++++++++++++++++++ Comienza la carrera en "+etapa.getNombreEtapa()+" ++++++++++++++++++++++++++");
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			simularParticipacionCiclistaEtapa(etapa);
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("+++++++++++++++++ Clasificación final de la carrera en "+etapa.getNombreEtapa()+" ++++++++++++++++++");
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			obtenerClasificacionEtapa(etapa);
			contador++;
		}
	}
	
	public void mostrarCiclistasCompetirEtapa() {
		for(Ciclista ciclista:ciclistasCarrera) {
			System.out.println(ciclista);
		}
	}
	
	public void ordenarCiclistasTiempoSinAbandonar() {
		ComparatorCiclistasTiempoSinAbandonar com= new ComparatorCiclistasTiempoSinAbandonar();
		Collections.sort(ciclistasCarrera,com);
		Collections.reverse(ciclistasCarrera);
	}
	
	public void simularParticipacionCiclistaEtapa(Etapa e) {
		int contadorTotalCiclistas=ciclistasCarrera.size();
		int contadoCiclista=1;
		for(Ciclista ciclista:ciclistasCarrera) {
			System.out.println("@@@ ciclista "+contadoCiclista+" de "+contadorTotalCiclistas);
			System.out.println(ciclista+" con bicicleta");
			System.out.println(ciclista.getBicicleta()+" en etapa "+e.getNombreEtapa());
			ciclista.usarBicicletaEtapa(ciclista.getBicicleta(), e);
			System.out.println("@@@");
			contadoCiclista++;
		}
	}
	
	public void obtenerClasificacionEtapa(Etapa e) {
	    Ciclista aux;
	    for(int i = 0;i < ciclistasCarrera.size()-1;i++){
	        for(int j = 0;j < ciclistasCarrera.size()-i-1;j++){
	            if(ciclistasCarrera.get(j+1).obtenerResultadoEtapaTiempo(e) <  ciclistasCarrera.get(j).obtenerResultadoEtapaTiempo(e)){    
	                aux = ciclistasCarrera.get(j+1);
	                ciclistasCarrera.set(j+1,ciclistasCarrera.get(j));
	                ciclistasCarrera.set(j,aux);
	            }
	        }
	    }
		int posicion=1;
		for(Ciclista ciclista:ciclistasCarrera) {
			System.out.print("@@@ Posicion("+posicion+") : ");
			ciclista.obtenerResultadoEtapa(e);
			posicion++;
		}
		System.out.println("\n");
	}
	
	public void obtenerResultadoFinalCampeonatoCiclistas() {
		System.out.println("****************************************************");
		System.out.println("**************** FIN DEL CAMPEONATO ****************");
		System.out.println("****************************************************");
		System.out.println("********** CLASIFICACIÓN FINAL DE CICLISTAS ********");
		System.out.println("****************************************************");
		int posicion=1;
		for(Ciclista ciclista:ciclistasCarrera) {
			System.out.println("@@@ Posicion("+posicion+") "+ciclista.getNombreCiclista()+" - Tiempo Total: "+ciclista.obtenerTiempoAcumuladoSinAbandonar()+" @@@");
			ciclista.obtenerTodosResultados();
			posicion++;
			System.out.println("\n");
		}
	}
	
	public void obtenerResultadosFinalCampeonatoEquipos() {
		System.out.println("****************************************************");
		System.out.println("******** CLASIFICACIÓN FINAL DE EQUIPOS *********");
		System.out.println("****************************************************");
		Equipo aux;
	    for(int i = 0;i < equipos.size()-1;i++){
	        for(int j = 0;j < equipos.size()-i-1;j++){
	            if(equipos.get(j+1).obtenerMediaMinutosSinAbandonar() <  equipos.get(j).obtenerMediaMinutosSinAbandonar()){    
	                aux = equipos.get(j+1);
	                equipos.set(j+1,equipos.get(j));
	                equipos.set(j,aux);
	            }
	        }
	    }
		int posicion=1;
		for(Equipo equipo:equipos) {
			System.out.println("@@@ Posicion("+posicion+") "+equipo.getNombreEquipo()+" con "+equipo.obtenerMediaMinutosSinAbandonar()+" minutos de media @@@");
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
			System.out.println("%%% "+equipo.getNombreEquipo()+" %%% Media Minutos de Ciclistas sin abandonar "+equipo.obtenerMediaMinutosSinAbandonar()+ "%%%\n");
			for(Ciclista ciclista:equipo.ciclistas) {
				System.out.println(ciclista);
			}
			System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
			posicion++;
		}
	}
}
