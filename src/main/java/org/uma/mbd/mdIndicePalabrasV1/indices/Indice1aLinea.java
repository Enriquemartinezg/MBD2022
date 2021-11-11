package org.uma.mbd.mdIndicePalabrasV1.indices;

import java.util.*;
import java.util.stream.Collectors;

public class Indice1aLinea extends Indice{
    private Map<String, Integer> indice;

    public Indice1aLinea(){
        super();
        indice = new TreeMap<>();
    }

    @Override
    public void agregarLinea(String linea) {
        super.agregarLinea(linea);
        indice.clear();
    }

    @Override
    public void resolver(String delimitadores, Collection<String> noSignificativas) {
        Set<String> noSig =
                new TreeSet<>(noSignificativas.stream().map(String::toLowerCase).collect(Collectors.toSet()));

        for(int i=0; i<texto.size();i++){
            try(Scanner sc = new Scanner(texto.get(i))){
                sc.useDelimiter(delimitadores);
                while (sc.hasNext()) {
                    String palabra = sc.next();
                    if (!noSig.contains(palabra.toLowerCase())) {
                        indice.putIfAbsent(palabra.toLowerCase(), i + 1);
                    }
                }
            }catch(InputMismatchException e){
                System.err.println("ERROR: Se ha introducido un elemento incorrecto: " + i+1);
            }
        }
    }

    @Override
    public void presentarIndiceConsola() {
        for(Map.Entry<String,Integer> palabra : indice.entrySet()){
            String clave = palabra.getKey();
            int apareceLinea = palabra.getValue();
            System.out.printf("%-20s%10d%n",clave,apareceLinea);
        }
    }
}
