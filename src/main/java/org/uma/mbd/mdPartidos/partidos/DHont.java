package org.uma.mbd.mdPartidos.partidos;

import org.uma.mbd.mdAlturas.alturas.Pais;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DHont extends DHontSimple{
    private double minPor;

    public DHont(double mp){
        if(mp<0 || mp > 15)
            throw new EleccionesException("Porcentaje erróneo");
        minPor = mp;
    }

    private List<Partido> filtraPartidos(List<Partido> partidos){
        int votosTotal = 0;
        Iterator<Partido> it = partidos.iterator();
        for(Partido p : partidos){
            votosTotal += p.getVotos();
        }

        while(it.hasNext()){
            if(it.next().getVotos() < votosTotal*(minPor/100))
                it.remove();
        }
        return partidos;
    }

    @Override
    public Map<Partido, Integer> ejecuta(List<Partido> partidos, int numEsc) {
        return super.ejecuta(filtraPartidos(partidos), numEsc);
    }
}
