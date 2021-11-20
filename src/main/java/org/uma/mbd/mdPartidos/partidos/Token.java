package org.uma.mbd.mdPartidos.partidos;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Token implements Comparable<Token>{
    private Partido partido;
    private double ratio;

    public Token(Partido p, double r){
        partido = p;
        ratio = r;
    }

    public Partido getPartido() {
        return partido;
    }

    public double getRatio() {
        return ratio;
    }

    @Override
    public int compareTo(Token t) {
        int compara = -1 * Double.compare(ratio, t.ratio);
        if(compara == 0)
            compara = partido.getNombre().compareToIgnoreCase(t.partido.getNombre());
        return compara;
    }

    public static Set<Token> seleccioneTokens(Set<Token> tks, int numEsc){
       Set<Token> tokens = new TreeSet<>();
        Iterator<Token> it = tks.iterator();
        int i = 0;
       while(i< numEsc) {
           tokens.add(it.next());
           i++;
       }
       return tokens;
    }

    public static Map<Partido, Integer> generaResultados(Set<Token> tks){

    }
}
