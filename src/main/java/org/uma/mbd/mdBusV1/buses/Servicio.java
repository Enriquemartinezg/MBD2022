package org.uma.mbd.mdBusV1.buses;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Servicio {
    private String ciudad;
    private List<Bus> buses;

    public Servicio(String nomCiudad){
        ciudad = nomCiudad;
        buses = new ArrayList<>();
    }

    public String getCiudad() {
        return ciudad;
    }

    public List<Bus> getBuses() {
        return buses;
    }

    public void leeBuses(String file) throws IOException{
        for(String linea: Files.readAllLines(Paths.get(file)))
            stringABus(linea);
    }

    private void stringABus(String linea){
        try(Scanner sc = new Scanner(linea)){
            sc.useDelimiter("[,]");
            int cB = sc.nextInt();
            String mat = sc.next();
            int cL = sc.nextInt();
            Bus bus = new Bus(cB, mat);
            bus.setCodLinea(cL);
            buses.add(bus);
        } catch (InputMismatchException e) {
            System.err.println("ERROR: Valor numérico erróneo: " + linea);
        } catch (NoSuchElementException e) {
            System.err.println("ERROR: Faltan datos: "+ linea);
        }
    }

    public List<Bus> filtra(Criterio criterio){
        List<Bus> cumplenCrit = new ArrayList<>();

        for(Bus bus: buses){
            if(criterio.esSeleccionable(bus)){
                cumplenCrit.add(bus);
            }
        }
        return cumplenCrit;
    }

    public void guarda(String file, Criterio criterio) throws FileNotFoundException {
        try(PrintWriter prwr = new PrintWriter(file)){
            guarda(prwr, criterio);
        }
    }

    public void guarda(PrintWriter prwr, Criterio criterio){
        List<Bus> cumplenC = filtra(criterio);
        prwr.println(criterio);
        for(Bus bus: cumplenC){
            prwr.println(bus);
        }
    }
}
