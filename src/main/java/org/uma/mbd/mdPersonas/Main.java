package org.uma.mbd.mdPersonas;

import org.uma.mbd.mdPersonas.persona.Persona;

public class Main {

    public static void main(String[] args) {
        Persona p1 = new Persona("juan", 24);
        Persona p2 = new Persona("juan", 24);

        System.out.println(p1.equals(p2));
    }
}
