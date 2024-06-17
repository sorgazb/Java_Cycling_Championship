package demo.comparadores;

import java.util.Comparator;

import demo.Bicicleta;

public class ComparatorBicicletaNombre implements Comparator<Bicicleta>{
	@Override
	public int compare(Bicicleta o1, Bicicleta o2) {
		return o1.getNombreBicicleta().compareTo(o2.getNombreBicicleta());
	}

}
