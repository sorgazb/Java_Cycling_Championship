package demo;
import demo.comparadores.ComparatorEtapasDificultad;
import demo.datosIniciales.DatosCampeonatoAbandonos;
import demo.datosIniciales.DatosCampeonatoCompleto;
/**
 * Main simulation class. 
 * First, initial data are loaded. 
 * Then, while not end of the simulation, the actions will be performed.
 *
 * @author profesores DP 
 * @version 22/23
 */
public class CiclismoDemo{
    
    public static void main(String[] args)  throws java.io.IOException{
    	
        Organizacion organizacion=new Organizacion(new ComparatorEtapasDificultad());
        
        //Descomentar de las dos líneas siguientes, la prueba que se quiera ejecutar
        
		DatosCampeonatoCompleto initdata = new DatosCampeonatoCompleto(organizacion); 
		
        //DatosCampeonatoAbandonos initdata = new DatosCampeonatoAbandonos(organizacion); 
            
        organizacion.gestionarCampeonato();
    }    
}