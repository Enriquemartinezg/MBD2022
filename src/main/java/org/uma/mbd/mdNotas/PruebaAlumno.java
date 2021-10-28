package org.uma.mbd.mdNotas;

import org.uma.mbd.mdNotas.notas.Alumno;
import org.uma.mbd.mdNotas.notas.AlumnoException;

public class PruebaAlumno {
    public static void main(String[] args) {
        try {
            Alumno al1 = new Alumno("22456784F", "Gonzalez Perez, Juan", 5.5);
            Alumno al2 = new Alumno("33456777S", "Gonzalez Perez, Julian", 3.4);

            System.out.printf("%5d: %-30s%5.2f%n",1,al1.getNombre(),al1.getCalificacion());
            System.out.printf("%5d: %-30s%5.2f%n",2,al2.getNombre(),al2.getCalificacion());
            System.out.println(al1.equals(al2));
        }catch(AlumnoException e){
            System.out.println(e.getMessage());
        }
    }
}
