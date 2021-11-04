package org.uma.mbd.mdAlturasV2.alturas;

public record Pais(String nombre, String continente, double altura) implements Comparable<Pais>{
    @Override
    public int compareTo(Pais p){
        int compara = Double.compare(altura, p.altura);
        if(compara == 0)
            compara = nombre.compareTo(p.nombre);
        return compara;
    }
};
