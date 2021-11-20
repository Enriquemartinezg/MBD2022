package org.uma.mbd.mdPartidos.partidos;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Elecciones {
    private List<Partido> partidos;

    static private Partido stringToPartido(String dato){
        try(Scanner sc = new Scanner(dato)){
            sc.useDelimiter("[,]+");
            String nomPartido = sc.next();
            int nVotos = sc.nextInt();
            Partido p = new Partido(nomPartido, nVotos);
            return p;
        } catch (InputMismatchException e) {
            throw new EleccionesException("ERROR: Valor numérico erróneo: " + dato);
        } catch (NoSuchElementException e) {
            throw new EleccionesException("ERROR: Faltan datos: " + dato);
        }
    }

    public void leeDatos(String [] datos){
        for (int i=0; i<datos.length; i++){
            Partido p = stringToPartido(datos[i]);
            partidos.add(p);
        }
    }

    public void leeDatos(String nombreFichero) throws IOException {
        for(String linea : Files.readAllLines(Paths.get(nombreFichero))){
            Partido p = stringToPartido(linea);
            partidos.add(p);
        }
    }

    public Map<Partido, Integer> generaResultados(CriterioSeleccion cs, int numEsc){
        Map<Partido,Integer> escaños = cs.ejecuta(partidos,numEsc);
        return escaños;
    }

    public void presentaResultados(String nombreFichero, Map<Partido,Integer> map) throws FileNotFoundException {
        try(PrintWriter pw = new PrintWriter(nombreFichero)){
            presentaResultados(pw, map);
        }
    }

    public void presentaResultados(PrintWriter pw, Map<Partido,Integer> map){
        for(Map.Entry<Partido,Integer> partido : map.entrySet()){
            Partido p = partido.getKey();
            int escaños = partido.getValue();
            if(escaños == 0)
                pw.println(p.getNombre()+" : "+p.getVotos()+" , Sin representación");
            pw.println(p.getNombre()+" : "+p.getVotos()+" , "+escaños);
        }
    }
}
