package demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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
		etapas.sort(comparadorEtapa);
		mostrarEtapasCampeonato();
		equipos.sort(new ComparatorEquiposNombre());
		mostrarEquiposCampeonato();
		simularEtapas();
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
			mostrarCiclistasCompetirEtapa();
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("+++++++++++++++++++++++++ Comienza la carrera en "+etapa.getNombreEtapa()+" ++++++++++++++++++++++++++");
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			simularParticipacionCiclistaEtapa(etapa);
			contador++;
		}
	}
	
	public void mostrarCiclistasCompetirEtapa() {
		for(Ciclista ciclista:ciclistasCarrera) {
			System.out.println(ciclista);
		}
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
}
