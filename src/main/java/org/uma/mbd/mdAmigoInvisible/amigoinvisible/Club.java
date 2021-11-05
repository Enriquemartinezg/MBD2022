package org.uma.mbd.mdAmigoInvisible.amigoinvisible;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Club {
    protected List<Persona> socios;

    public Club(){
        if(socios.size() <= 2)
            throw new AmigoException("No se pueden asoaciar amigos con menos de 3 interantes");
        socios = new ArrayList<>();
    }

    public void lee(String fEntrada, String delim) throws IOException {
        for(String linea : Files.readAllLines(Paths.get(fEntrada))){
            leeSocios(linea,delim);
        }
    }

    public void leeSocios(String linea, String delim){
        try(Scanner sc = new Scanner(linea)){
            sc.useDelimiter(delim);
            String nombre = sc.next();
            Persona per = new Persona(nombre);
            creaSocioDesdeString(per.getNombre());
        } catch (InputMismatchException e) {
            System.err.println("ERROR: Valor numérico erróneo: " + linea);
        } catch (NoSuchElementException e) {
            System.err.println("ERROR: Faltan datos: " + linea);
        }
    }

    protected void creaSocioDesdeString(String nombre){
        Persona p = new Persona(nombre);
        socios.add(p);
    }

    protected void hacerAmigos(){
        while(hayCoincidendia()){
        }
    }

    private static boolean hayCoincidendia(List<Integer> lista){
        lista = new ArrayList<>();
        for(int i=0; i<socios.size(); i++)
    }
}
