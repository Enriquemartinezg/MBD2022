package org.uma.mbd.mdAmigoInvisible.amigos;

import java.util.*;

public class ClubParejas extends Club{
    private Set<Pareja> parejas;

    public ClubParejas(){
        parejas = new HashSet<>();
    }

    @Override
    protected void creaSocioDesdeString(String nombre){
        String[] mParejas = nombre.split("[-]");
        Persona p1 = new Persona(mParejas[0]);
        socios.add(p1);

        if(mParejas.length == 2) {
            Persona p2 = new Persona(mParejas[1]);
            socios.add(p2);
            parejas.add(new Pareja(p1, p2));
        }
    }

    @Override
    protected void hacerAmigos() {
        super.hacerAmigos();
        for(int i=0; i<socios.size(); i++){
            Pareja amigosInv = new Pareja(socios.get(i), socios.get(i).getAmigo());
            if(parejas.contains(amigosInv))
                hacerAmigos();
        }
    }
}
