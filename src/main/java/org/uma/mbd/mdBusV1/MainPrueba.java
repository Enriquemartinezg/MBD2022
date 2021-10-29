package org.uma.mbd.mdBusV1;

import org.uma.mbd.mdBusV1.buses.Servicio;

import java.io.IOException;

public class MainPrueba {
    public static void main(String[] args) {
        Servicio sv1 = new Servicio("Málaga");

        try{
            sv1.leeBuses("recursos/mdBusV1/buses.txt");
            System.out.println(sv1.getCiudad());
            for(int i=0; i<sv1.getBuses().size(); i++)
                System.out.printf("%5d: %10d%20s%5d%n",i,sv1.getBuses().get(i).getCodBus(),
                        sv1.getBuses().get(i).getMatricula(),
                        sv1.getBuses().get(i).getCodLinea());
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
