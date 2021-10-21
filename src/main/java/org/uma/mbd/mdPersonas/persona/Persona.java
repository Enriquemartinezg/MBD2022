package org.uma.mbd.mdPersonas.persona;

import java.util.Locale;

public class Persona {
    private String nombre;
    private int edad;

    public Persona(String nom, int e){
        nombre = nom;
        e = edad;
    }

    @Override
    public boolean equals(Object o){
        return (o instanceof Persona p)
                && (edad == p.edad)
                && ( nombre.equals(p.nombre));
    }

    @Override
    public int hashCode(){
        return nombre.toLowerCase().hashCode()+Integer.hashCode(edad);
        // toLowerCase o toUpperCase en caso de que no nos importen las mayusculas o minusculas a la hora de
        //comparar dos elementos. No es el mismo hashCode en "Juan" que "juan".
    }
}
