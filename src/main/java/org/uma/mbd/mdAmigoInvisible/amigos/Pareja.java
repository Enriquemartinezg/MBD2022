package org.uma.mbd.mdAmigoInvisible.amigos;

import java.util.Objects;

public class Pareja {
    private Persona una;
    private Persona otra;
    
    public Pareja(Persona una, Persona otra){
        this.una = una;
        this.otra = otra;
    }

    @Override
    public boolean equals (Object obj){
        return obj instanceof Pareja p &&
                una.equals(p.otra) && p.una.equals(otra);
    }

    @Override
    public int hashCode(){
        return una.hashCode() + otra.hashCode();
    }

    @Override
    public String toString(){
        return "("+ una.getNombre() +","+otra.getNombre()+")";
    }
}
