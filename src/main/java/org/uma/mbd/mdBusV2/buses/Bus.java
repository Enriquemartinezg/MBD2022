package org.uma.mbd.mdBusV2.buses;

import java.util.Objects;

public class Bus implements Comparable<Bus> {
    private int codBus;
    private int codLinea;
    private String matricula;

    public Bus(int cBus, String mat){
        codBus = cBus;
        matricula = mat;
    }

    public void setCodLinea(int codLinea){
        this.codLinea = codLinea;
    }

    public int getCodBus() {
        return codBus;
    }

    public int getCodLinea() {
        return codLinea;
    }

    public String getMatricula() {
        return matricula;
    }

    @Override
    public boolean equals(Object obj){
        return obj instanceof Bus b &&
                codBus == b.codBus &&
                matricula.equalsIgnoreCase(b.matricula);
    }

    @Override
    public int hashCode(){
        return Objects.hash(codBus, matricula.toLowerCase());
    }

    @Override
    public String toString(){
        return "Bus ("+codBus+","+matricula+","+codLinea+")";
    }


    @Override
    public int compareTo(Bus b) {
        int compara = Integer.compare(codLinea, b.codLinea);
        if(compara == 0)
            compara = Integer.compare(codBus, b.codBus);
        return compara;
    }
}
