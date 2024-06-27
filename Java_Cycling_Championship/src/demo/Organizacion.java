package demo;

import java.util.List;

public class Organizacion {
	private List<Etapa> etapas;
	private List<Equipo> equipos;
	private List<Ciclista> ciclistas;

	public void anadirEtapa(Etapa e) {
		etapas.add(e);
	}
	
	public void inscribirEquipo(Equipo e) {
		equipos.add(e);
	}
}
