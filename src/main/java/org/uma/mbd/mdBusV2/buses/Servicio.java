package org.uma.mbd.mdBusV2.buses;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Servicio {
    private String ciudad;
    private Set<Bus> buses;

    public Servicio(String nomCiudad){
        ciudad = nomCiudad;
        buses = new TreeSet<>();
    }

    public String getCiudad() {
        return ciudad;
    }

    public Set<Bus> getBuses() {
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

    public Set<Bus> filtra(Criterio criterio, Comparator<Bus> comparator){
        Set<Bus> cumplenCrit = new TreeSet<>(comparator);

        for(Bus bus: buses){
            if(criterio.esSeleccionable(bus)){
                cumplenCrit.add(bus);
            }
        }
        return cumplenCrit;
    }

    public void guarda(String file, Comparator<Bus> cb, Criterio criterio) throws FileNotFoundException {
        try(PrintWriter prwr = new PrintWriter(file)){
            guarda(prwr, cb, criterio);
        }
    }

    public void guarda(PrintWriter prwr, Comparator<Bus> cb, Criterio criterio){
        Set<Bus> cumplenC = filtra(criterio, cb);
        prwr.println(criterio);
        for(Bus bus: cumplenC){
            prwr.println(bus);
        }
    }
}
