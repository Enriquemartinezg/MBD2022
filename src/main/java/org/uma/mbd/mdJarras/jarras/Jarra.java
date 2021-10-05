package org.uma.mbd.mdJarras.jarras;

public class Jarra {
    private int contenido, capacidad;
    public Jarra(int capInicial){
        capacidad = capInicial;
        contenido = 0;
    }

    public double getCapacidad() {
        return capacidad;
    }

    public double getContenido() {
        return contenido;
    }

    public void llena(){
        contenido = capacidad;
    }

    public void vacia(){
        contenido = 0;
    }

    public void llenaDesde(Jarra j){
         if(j.contenido >= (capacidad-contenido)){
            j.contenido -= (capacidad-contenido);
            contenido = capacidad;
        }else{
            contenido += j.contenido;
            j.contenido = 0;
        }
    }
    @Override
    public String toString() {
        return "J(" + capacidad + "," + contenido + ")";
    }
}
