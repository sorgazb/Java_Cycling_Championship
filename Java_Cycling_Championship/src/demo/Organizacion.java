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
}
