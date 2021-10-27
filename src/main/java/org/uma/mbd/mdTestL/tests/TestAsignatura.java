package org.uma.mbd.mdTestL.tests;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class TestAsignatura {
    private String nombre;
    private List<Test> tests;
    private double vA;
    private double vE;
    private static final int APROBADO = 5;

    public TestAsignatura(String n, double vAcierto, double vError, List<String> datos){
        if(vAcierto < 0 || vError > 0)
            throw new RuntimeException("Valoraciones erróneas.");
        nombre = n;
        vA = vAcierto;
        vE = vError;
        tests = new ArrayList<>();
        extraerDatos(datos);
    }

    public TestAsignatura(String n, List<String> datos){
        this(n,1,0,datos);
    }

    public TestAsignatura(String n, double vAc, double vEr, String fichero) throws IOException {
        nombre = n;
        vA = vAc;
        vE = vEr;
        tests = new ArrayList<>();
        for(String datoEstudiantes : Files.readAllLines(Paths.get(fichero)))
            stringToTest(datoEstudiantes);
    }

    private void extraerDatos(List<String> datos){
        for(String datosEstudiantes : datos) {
            stringToTest(datosEstudiantes);
        }
    }

    private void stringToTest(String datosEstudiantes){
            try(Scanner sc = new Scanner(datosEstudiantes)){
                sc.useDelimiter("[:+]");
                String n = sc.next();
                int ac = sc.nextInt();
                int er = sc.nextInt();
                Test test = new Test(n,ac,er);
                tests.add(test);
            }catch (InputMismatchException e) {
                System.out.println("Línea con aciertos o fallos erróneos" + datosEstudiantes);
            }catch (NoSuchElementException e){
                System.out.println("Línea con falta de datos "+ datosEstudiantes);
            }
    }

    public String getNombre() {
        return nombre;
    }

    public int aprobados(){
        int numAp = 0;
        for(Test test: tests){
            if(test.calificacion(vA, vE) >= APROBADO)
                numAp++;
        }
        return numAp;
    }

    public double notaMedia(){
        if(tests.isEmpty())
            throw new RuntimeException("No hay alumnos para evaluar.");

        double sum = 0;
        for(Test test:tests){
            sum += test.calificacion(vA,vE);
        }
        return sum/ tests.size();
    }
}
