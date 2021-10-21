package org.uma.mbd.mdTren.tren;

public class Vagon {
    private int capacidad;
    private int carga;

    public Vagon(int capacidad){
        this.capacidad = capacidad;
        carga = 0;
    }

    public int carga(int ton){
        int cabe = capacidad-carga;
        int sobra = ton - (cabe);
        if (ton <= cabe)
            carga += ton;
        else
            carga = capacidad;
        return ton <= cabe ? 0: sobra;
    }

    public int descarga(int ton){
        int queda = ton - carga;
        if(ton < carga) {
            carga -= ton;
            return 0;
        }else {
            carga = 0;
            return queda;
        }
    }

    public int getCarga(){
        return carga;
    }

    public Integer getCapacidad(){
        int cabe = capacidad-carga;
        return cabe;
    }

    @Override
    public String toString(){
        return "V ("+carga+"/"+capacidad+")";
    }
}
