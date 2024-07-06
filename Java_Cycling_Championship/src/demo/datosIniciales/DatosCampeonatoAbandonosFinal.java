package demo.datosIniciales;

import demo.Bicicleta;
import demo.BicicletaPrototipo;
import demo.BicicletaRapida;
import demo.CiclistaEstrella;
import demo.CiclistaExperimentado;
import demo.CiclistaNovato;
import demo.Equipo;
import demo.Etapa;
import demo.Organizacion;
import demo.enums.DificultadEtapa;
import demo.enums.DistanciaEtapa;
import demo.enums.HabilidadCiclista;
import demo.enums.PesoBicicleta;

public class DatosCampeonatoAbandonosFinal
{
    
    public DatosCampeonatoAbandonosFinal(Organizacion organizacion)
    {
        System.out.println("*********************************************************************************************************");
        System.out.println("*****************ESTA SIMULACIÓN CONCLUYE NORMALMENTE COMPLETANDOSE TODAS LAS CARRERAS PERO CON ABANDONOS*******************");
        System.out.println("*********************************************************************************************************\n");
        
        initData(organizacion);
    }
    
     private void initData(Organizacion organizacion)
    {
        //constructor de etapas pide ( String nombre, Dificultad dificultad, Distancia distancia)
        Etapa etapa1 = new Etapa("sencilla larga",DificultadEtapa.SENCILLA,DistanciaEtapa.LARGA);
        Etapa etapa2 = new Etapa("compleja intermedia", DificultadEtapa.COMPLEJA, DistanciaEtapa.INTERMEDIA);
        Etapa etapa3 = new Etapa("normal intermedia", DificultadEtapa.NORMAL,DistanciaEtapa.INTERMEDIA);
        Etapa etapa4 = new Etapa("sencilla intermedia", DificultadEtapa.SENCILLA, DistanciaEtapa.INTERMEDIA);
        Etapa etapa5 = new Etapa("compleja larga", DificultadEtapa.COMPLEJA, DistanciaEtapa.LARGA);
        Etapa etapa6 = new Etapa("normal larga",DificultadEtapa.NORMAL, DistanciaEtapa.LARGA);
        organizacion.anadirEtapa(etapa1);
        organizacion.anadirEtapa(etapa2);
        organizacion.anadirEtapa(etapa3);
        organizacion.anadirEtapa(etapa4);
        organizacion.anadirEtapa(etapa5);
        organizacion.anadirEtapa(etapa6);
        

        //constructor de equipos pide (String nombre, comparador de ciclistas y si orden ascendente o descendente, comparador de bicicletas y si orden ascendente o descendente)
        Equipo movistarWomen = new Equipo("Movistar Women", "Ordenados Ascendentemente por Habilidad", "Ordenadas Ascendentemente por Peso");
        Equipo dSMWomen= new Equipo("DSM Women","Ordenados Ascendentemente por Energia","Ordenadas Ascendentemente por Peso");
        Equipo trekSegafredoWomen = new Equipo("Trek Segafredo Women","Ordenados Descendentemente por Habilidad", "Ordenadas Descendentemente por Peso");
        
        organizacion.inscribirEquipo(movistarWomen);
        organizacion.inscribirEquipo(trekSegafredoWomen);
        organizacion.inscribirEquipo(dSMWomen);
                
		//constructor de bicicletas pide ( String nombre, Peso peso)
		//constructor de bicicletas rápidas pide ( String nombre, Peso peso, double velocidad extra)
        dSMWomen.anadirBicicleta(new BicicletaRapida("SCOTT CONTESSA ADDICT eRIDE 15",PesoBicicleta.LIGERA, 0.3)); 
        dSMWomen.anadirBicicleta(new BicicletaPrototipo("SCOTT CONTESSA ADDICT 15",PesoBicicleta.NORMAL));
        dSMWomen.anadirBicicleta(new Bicicleta("SCOTT CONTESSA ADDICT RC 15",PesoBicicleta.PESADA));
        //constructor de ciclistas pide (String nombre , Habilidad habilidad , double energia, Equipo equipo)
        dSMWomen.anadirCiclista(new CiclistaNovato("WIEBES",  HabilidadCiclista.NORMAL, 1190, dSMWomen));
        dSMWomen.anadirCiclista(new CiclistaEstrella("LIPPERT", HabilidadCiclista.LENTA, 1160, dSMWomen));
        dSMWomen.anadirCiclista(new CiclistaExperimentado("LABOUS", HabilidadCiclista.BUENA, 1150, dSMWomen));
     
		//constructor de bicicletas pide ( String nombre, Peso peso)
		//constructor de bicicletas rápidas pide ( String nombre, Peso peso, double velocidad extra)
        trekSegafredoWomen.anadirBicicleta(new Bicicleta("TREK Madone SLR 9 eTap Gen 7",PesoBicicleta.LIGERA));
        trekSegafredoWomen.anadirBicicleta(new BicicletaRapida("TREK Emonda SLR 9 eTap",PesoBicicleta.NORMAL, 0.5));
        trekSegafredoWomen.anadirBicicleta(new BicicletaPrototipo("TREK Domane SLR 9 eTap Gen 4",PesoBicicleta.PESADA));
        //constructor de ciclistas pide (String nombre , Habilidad habilidad , double energia, Equipo equipo)
        trekSegafredoWomen.anadirCiclista(new CiclistaEstrella("BALSAMO", HabilidadCiclista.LENTA,1180, trekSegafredoWomen));
        trekSegafredoWomen.anadirCiclista(new CiclistaExperimentado("LONGO-BORGHINI", HabilidadCiclista.NORMAL,1175, trekSegafredoWomen));
        trekSegafredoWomen.anadirCiclista(new CiclistaNovato("CORDON-RAGOT", HabilidadCiclista.BUENA, 1120, trekSegafredoWomen));
        
		//constructor de bicicletas pide ( String nombre, Peso peso)
		//constructor de bicicletas rápidas pide ( String nombre, Peso peso, double velocidad extra)
        movistarWomen.anadirBicicleta(new BicicletaRapida("CANYON Ultimate CFR eTap",PesoBicicleta.LIGERA, 0.4));
        movistarWomen.anadirBicicleta(new Bicicleta("CANYON Aeroad CF SLX 8 Disc Di2",PesoBicicleta.NORMAL));
        movistarWomen.anadirBicicleta(new BicicletaPrototipo("CANYON Endurace CF SLX 9 Di2",PesoBicicleta.PESADA));
        //constructor de ciclistas pide (String nombre , Habilidad habilidad , double energia, Equipo equipo)
        movistarWomen.anadirCiclista(new CiclistaEstrella("VAN VLEUTEN", HabilidadCiclista.BUENA,1200, movistarWomen));
        movistarWomen.anadirCiclista(new CiclistaExperimentado("NORSGAARD", HabilidadCiclista.NORMAL,1145, movistarWomen));
        movistarWomen.anadirCiclista(new CiclistaNovato("SIERRA", HabilidadCiclista.LENTA, 1110, movistarWomen));   
    }

}
