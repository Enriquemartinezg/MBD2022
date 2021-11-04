package org.uma.mbd.mdAmigoInvisible.amigoinvisible;

import java.util.Objects;

public class Persona implements Comparable<Persona>{
    private String nombre;
    private Persona amigo;

    public Persona(String nombre){
        this.nombre = nombre;
    }

    public void setAmigo(Persona am){
        amigo = am;
    }

    public String getNombre() {
        return nombre;
    }

    public Persona getAmigo() {
        return amigo;
    }

    @Override
    public boolean equals(Object o){
        return o instanceof Persona p &&
                nombre.equalsIgnoreCase(p.nombre);
    }

    @Override
    public int hashCode(){
        Objects.hashCode(nombre.toLowerCase());
    }

    @Override
    public int compareTo(Persona p) {
        return nombre.compareToIgnoreCase(p.nombre);
    }

    @Override
    public String toString(){
        return nombre+" --> "+amigo.nombre;
    }
}
