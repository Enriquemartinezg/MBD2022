package org.uma.mbd.mdPartidos.partidos;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class DHontSimple implements CriterioSeleccion{

    private Set<Token> creaTokens(List<Partido> partidos, int numEsc){
        Set<Token> tokens = new TreeSet<>();
        for(Partido p : partidos){
            for(int i=1; i<numEsc; i++){
                Token t = new Token(p, p.getVotos()/i);
                tokens.add(t);
            }
        }
        return tokens;
    }

    @Override
    public Map<Partido, Integer> ejecuta(List<Partido> partidos, int numEsc) {
        Set<Token> tokensTotal = creaTokens(partidos, numEsc);
        Set<Token> tks = Token.seleccioneTokens(tokensTotal, numEsc);
        Map<Partido, Integer> tienenEscaño = Token.generaResultados(tks);
        return tienenEscaño;
    }
}
