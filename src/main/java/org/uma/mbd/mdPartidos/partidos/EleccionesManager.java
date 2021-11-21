package org.uma.mbd.mdPartidos.partidos;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class EleccionesManager {
    private String [] datos;
    private int numEsc;
    private CriterioSeleccion cs;
    private Elecciones elecciones;
    private String fEntrada;
    private String fSalida;
    private boolean consola;

    public EleccionesManager(Elecciones elecciones){
        this.elecciones = elecciones;
    }
    public EleccionesManager setDatos(String[] datos ){
        this.datos = datos;
        return this;
    }
    public EleccionesManager setCriterioSeleccion(CriterioSeleccion cr){
        cs = cr;
        return this;
    }
    public EleccionesManager setNumEsc(int numEsc){
        this.numEsc = numEsc;
        return this;
    }
    public EleccionesManager setEntrada(String fEntrada){
        this.fEntrada = fEntrada;
        return this ;
    }
    public EleccionesManager setSalida(String fSalida){
        this.fSalida = fSalida;
        return this ;
    }
    public EleccionesManager setConsola(boolean consola){
        this.consola = consola;
        return this;
    }

    private void verify(){
        if(fEntrada == null && datos == null)
            throw new EleccionesException("No hay fichero de entrada ni array de datos.");
        if(cs == null)
            throw new EleccionesException("No se ha elegido ningún criterio de selección.");
        if(numEsc<=0)
            throw new EleccionesException("El numero de escaños debe ser positivo.");
        if(fSalida == null && !consola)
            throw new EleccionesException("No hay ninguna via de representación de los datos de salida.");
    }

    public void build() throws IOException{
        verify();
        if(datos == null){
            elecciones.leeDatos(fEntrada);
        }else{
            elecciones.leeDatos(datos);
        }
        Map<Partido,Integer> resultado = elecciones.generaResultados(cs, numEsc);
        if(consola){
            elecciones.presentaResultados(new PrintWriter(System.out, true),resultado);
        }
        if(fSalida != null)
            elecciones.presentaResultados(fSalida, resultado);
    }
}
