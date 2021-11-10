package org.uma.mbd.mdIndicePalabrasV1.indices;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class IndiceLineas extends Indice{
    private Map<String, Set<Integer>> indice;

    public IndiceLineas(){
        indice = new TreeMap<>();
    }

    @Override
    public void resolver(String delimitadores, Collection<String> noSignificativas) {
        Set<String> noSig =
                new TreeSet<>(noSignificativas.stream().map(String::toLowerCase).collect(Collectors.toSet()));

        for(int i=0; i<texto.size(); i++){
            try(Scanner sc = new Scanner(texto.get(i))){
                sc.useDelimiter(delimitadores);
                while(sc.hasNext()){
                    String palabra = sc.next();
                    if(!noSig.contains(palabra.toLowerCase())){
                        Set<Integer> indices = indice.computeIfAbsent(palabra.toLowerCase(),k -> new TreeSet<>());
                        indices.add(i+1);
                    }
                }
            }

        }
    }

    @Override
    public void presentarIndiceConsola() {
        for(Map.Entry<String,Set<Integer>> palabra : indice.entrySet()){
            String clave = palabra.getKey();
            Set<Integer> lineas = palabra.getValue();
            System.out.println(clave+" \t\t "+lineas);
        }
    }
}
