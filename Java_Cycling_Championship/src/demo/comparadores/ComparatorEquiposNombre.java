package demo.comparadores;

import java.util.Comparator;

import demo.Ciclista;
import demo.Equipo;

public class ComparatorEquiposNombre implements Comparator<Equipo>{
	@Override
	public int compare(Equipo e1, Equipo e2) {
		return e1.getNombreEquipo().compareTo(e2.getNombreEquipo());
	}
}
