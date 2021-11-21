package org.uma.mbd.mdPartidos.partidos;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Proporcional implements CriterioSeleccion{

    Set<Token> creaTokens(List<Partido> partidos, int numEsc){
        int votosTotal = 0;
        Set<Token> tokens = new TreeSet<>();

        for(Partido p : partidos){
            votosTotal += p.getVotos();
        }
        int vpe = votosTotal/numEsc;

        for(Partido p : partidos){
            for(int i=0; i<numEsc-1; i++)
                tokens.add(new Token(p, p.getVotos() - vpe*i));
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
