package demo.comparadores;

import java.util.Comparator;

import demo.Etapa;

public class ComparatorEtapasDificultad implements Comparator<Etapa>{
	@Override
	public int compare(Etapa e1, Etapa e2) {
		int comparacion= Double.compare(e1.getDificultad(), e2.getDificultad());
		if(comparacion==0) {
			return e1.getNombreEtapa().compareTo(e2.getNombreEtapa());
		}
		return comparacion;
	}
}
