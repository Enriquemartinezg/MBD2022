package org.uma.mbd.mdPartidos.partidos;

import java.util.*;

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
       for(int i=0; i<numEsc; i++)
           tokens.add(it.next());
       return tokens;
    }

    public static Map<Partido, Integer> generaResultados(Set<Token> tks){
        Map<Partido,Integer> estanPartidos = new HashMap<>();
        for(Token t : tks){
            if(estanPartidos.containsKey(t.getPartido())){
                estanPartidos.put(t.getPartido(),estanPartidos.get(t.getPartido())+1);
            }else{
                estanPartidos.put(t.getPartido(),1);
            }
        }
        return estanPartidos;
    }
}
