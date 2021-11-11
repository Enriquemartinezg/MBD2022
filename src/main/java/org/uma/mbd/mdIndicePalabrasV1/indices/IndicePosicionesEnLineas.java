package org.uma.mbd.mdIndicePalabrasV1.indices;

import java.util.*;
import java.util.stream.Collectors;

public class IndicePosicionesEnLineas extends Indice{
    private Map<String, Map<Integer, Set<Integer>>> indice;

    public IndicePosicionesEnLineas(){
        super();
        indice = new TreeMap<>();
    }

    @Override
    public void resolver(String delimitadores, Collection<String> noSignificativas) {
        Set<String> noSig =
                new TreeSet<>(noSignificativas.stream().map(String::toLowerCase).collect(Collectors.toSet()));

        for(int i=0; i<texto.size(); i++){
            int cont = 0;
            try(Scanner sc = new Scanner(texto.get(i))){
                sc.useDelimiter(delimitadores);
                while(sc.hasNext()){
                    String palabra = sc.next();
                    if(!noSig.contains(palabra.toLowerCase())){
                        Map<Integer,Set<Integer>> indices =
                                indice.computeIfAbsent(palabra.toLowerCase(), k -> new TreeMap<>());
                        Set<Integer> apareceEnPosicion = indices.computeIfAbsent(i+1,y -> new TreeSet<>());
                        apareceEnPosicion.add(cont+1);
                    }
                    cont++;
                }
            }
        }
    }

    @Override
    public void presentarIndiceConsola() {
        for(Map.Entry<String,Map<Integer,Set<Integer>>> palabra : indice.entrySet()){
            String clave = palabra.getKey();
            Map<Integer,Set<Integer>> lineas = palabra.getValue();
            System.out.println(clave+" \t\t "+lineas);
        }
    }
}
