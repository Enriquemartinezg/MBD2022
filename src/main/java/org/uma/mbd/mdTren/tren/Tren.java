package org.uma.mbd.mdTren.tren;

import java.util.ArrayList;
import java.util.List;

public class Tren{
    private List<Vagon> vagones;
    private final int capComun;

    public Tren(int nVagones, int capComun){
        this.capComun = capComun;
        vagones = new ArrayList<>();
        if (nVagones == 0){
            throw new IllegalArgumentException("El nº de vagones no puede ser cero.");
        }

        for (int i = 0; i < nVagones; i++){
            vagones.add(new Vagon(capComun));
        }
    }

    public void carga(int ton){
        int i = 0;
        int sobra = ton;
        while(sobra > 0 && i < vagones.size()){
            sobra = vagones.get(i).carga(sobra);
            vagones.set(i,vagones.get(i));
            i++;
        }

        while(sobra > 0){
            vagones.add(new Vagon(capComun));
            sobra = vagones.get(i).carga(sobra);
            vagones.set(i,vagones.get(i));
        }
    }

    public void gasta(int ton) {
        int i = 0;
        int queda = ton;
        while (queda > 0 && i < vagones.size() ) {
            queda = vagones.get(i).descarga(queda);
            vagones.set(i, vagones.get(i));
            i++;
        }
        if (queda > 0) {
            throw new IllegalArgumentException("El numero de toneladas es mayor que el valor permitido");
        }
    }

    public void optimiza() {
        for (int nVagon = 0; nVagon < vagones.size() ; nVagon++) {
            if (vagones.get(nVagon).getCarga() == 0) {
                vagones.remove(vagones.get(nVagon));
            }
        }
    }

    public String toString(){
        return vagones.toString();
    }
}

