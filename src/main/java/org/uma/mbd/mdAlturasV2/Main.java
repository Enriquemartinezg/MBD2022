package org.uma.mbd.mdAlturasV2;



import org.uma.mbd.mdAlturasV2.alturas.ComparadorPorAltura;
import org.uma.mbd.mdAlturasV2.alturas.MayoresQue;
import org.uma.mbd.mdAlturasV2.alturas.Mundo;
import org.uma.mbd.mdAlturasV2.alturas.Pais;

import java.io.IOException;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String args[]) throws IOException {
        Mundo paises = new Mundo();
        paises.leePaises("recursos/mdAlturas/alturas.txt");
        /*
        Manera menos eficiente
        Set<Pais> porAltura = new TreeSet<>(new ComparadorPorAltura());
        porAltura.addAll(paises.selecciona(new MayoresQue(0)));
        for(Pais pais: porAltura){
            System.out.println(pais);
        }
         */

        Comparator<Pais> cAlt = Comparator.comparingDouble(p -> p.altura());
        Comparator<Pais>  cAlf = Comparator.comparing(p -> p.nombre());
        Comparator<Pais>  cCont = Comparator.comparing(p -> p.continente());

        //Paises ordenados por altura, menor a mayor
        Set<Pais> porAltura = new TreeSet<>(cAlt);
        porAltura.addAll(paises.selecciona(new MayoresQue(0)));
        System.out.println("ALTURA\n");
        for(Pais pais: porAltura){
            System.out.println(pais);
        }

        //Paises ordenados alfabeticamente
        Set<Pais> alfabeto = new TreeSet<>(cAlf);
        alfabeto.addAll(paises.getPaises());
        System.out.println("ALFABETICAMENTE\n");
        for(Pais pais: alfabeto){
            System.out.println(pais);
        }

        //Paises ordenador por continente, a igualda, alfabeticamente
        Set<Pais> porContAlf = new TreeSet<>(cCont.thenComparing(cAlf));
        porContAlf.addAll(paises.getPaises());
        System.out.println("CONTINENTE / ALFABETICAMENTE\n");
        for(Pais pais: porContAlf){
            System.out.println(pais);
        }

        Set<Pais> porContAlfInv = new TreeSet<>(cCont.thenComparing(cAlf.reversed()));
        porContAlfInv.addAll(paises.getPaises());
        System.out.println("CONTINENTE / ALFABETICAMENTE INVERSO\n");
        for(Pais pais: porContAlfInv){
            System.out.println(pais);
        }

        Set<Pais> ordenNatural = new TreeSet<>(Comparator.naturalOrder());
        ordenNatural.addAll(paises.getPaises());
        System.out.println("CRDEN NATURAL\n");
        for(Pais pais: ordenNatural){
            System.out.println(pais);
        }

        Set<Pais> alturaOrdNat = new TreeSet<>(cCont.thenComparing(Comparator.naturalOrder()));
        alturaOrdNat.addAll(paises.getPaises());
        System.out.println("CONTINENTE / ORDEN NATURAL\n");
        for(Pais pais: alturaOrdNat){
            System.out.println(pais);
        }
    }
}
