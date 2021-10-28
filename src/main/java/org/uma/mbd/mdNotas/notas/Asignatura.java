package org.uma.mbd.mdNotas.notas;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Asignatura {
	private String nombre;
	private List<Alumno> alumnos;
	private List<String> errores;

	private static final double APROBADO = 5;
	private static final String DNI = "[0-9]{8}[A-Z&&[^IOU]]";

	public Asignatura(String nombreAsignatura) {
		nombre = nombreAsignatura;
		alumnos = new LinkedList<>();
		errores = new LinkedList<>();
	}

	public void leeDatos(String nombreFichero) throws IOException {
			for(String dato: Files.readAllLines(Paths.get(nombreFichero)))
				stringAAlumno(dato);
	}

	public void leeDatos(String[] datos) {
		for (String dato: datos)
			stringAAlumno(dato);
	}

	private void stringAAlumno(String linea) {
		try (Scanner sc = new Scanner(linea)) {
			sc.useDelimiter("[;]+");
			sc.useLocale(Locale.ENGLISH);
			String dni = sc.next();
			String n = sc.next();
			double calif = sc.nextDouble();
			Alumno al = new Alumno(dni, n, calif);
			alumnos.add(al);
		} catch (AlumnoException e) {
			errores.add("ERROR: "+ e.getMessage()+ ": "+ linea);
		} catch (InputMismatchException e) {
			errores.add("ERROR: Nota no numérica: " + linea);
		} catch (NoSuchElementException e) {
			errores.add("ERROR: Faltan datos: "+ linea);
		}
	}

	public double getCalificacion(Alumno al) throws AlumnoException {
 		int pos = alumnos.indexOf(al);
		if(pos < 0) throw new AlumnoException("El alumno no está: " + al);
 		return alumnos.get(pos).getCalificacion();
    }

	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public List<String> getErrores() {
		return errores;
	}

	public Set<String> getNombreAlumnos() {
		// COMPLETAR
		return null;
	}
	
	public double getMedia(CalculoMedia media) throws AlumnoException {
		return media.calcular(alumnos);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(nombre);
		sb.append(alumnos);
		sb.append(errores);
		return sb.toString();
	}
}
