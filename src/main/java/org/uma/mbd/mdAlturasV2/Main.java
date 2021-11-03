package org.uma.mbd.mdAlturasV2;

import org.uma.mbd.mdAlturas.alturas.*;
import org.uma.mbd.mdAlturasV2.alturas.ComparadorPorAltura;
import org.uma.mbd.mdNotas.notas.Alumno;

import java.io.IOException;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String args[]) throws IOException {
        Mundo paises = new Mundo();
        paises.leePaises("recursos/mdAlturas/alturas.txt");
        Set<Pais> porAltura = new TreeSet<Pais>(new Comparator<Pais>() {
            @Override
            public int compare(Pais o1, Pais o2) {
                return Double.compare(o1.altura() , o2.altura());
            }
        });
        porAltura.addAll(paises.selecciona(new MayoresQue(0)));
        for(Pais pais: porAltura){
            System.out.println(pais);
        }
    }
}
