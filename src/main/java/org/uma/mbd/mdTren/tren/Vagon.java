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
        if (ton <= cabe) // cabe ton en el vagon
            carga += ton; // carga es la carga que hubiera + ton
        else // no cabe ton
            carga = capacidad; // vagon se llena
        return ton <= cabe ? 0: sobra;
    }

    public int descarga(int ton){
        int queda = ton - carga; // cantidad que se queda del consumo
        if(ton < carga) { //se quema menos de lo que hay en vagon
            carga -= ton; // carga que hubiera menos consumo
            return 0;
        }else { //se quema mas de lo que hay en el vagon
            carga = 0; // vagon vacio
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
