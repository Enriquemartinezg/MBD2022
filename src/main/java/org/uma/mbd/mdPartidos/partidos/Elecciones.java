package org.uma.mbd.mdPartidos.partidos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

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
}
