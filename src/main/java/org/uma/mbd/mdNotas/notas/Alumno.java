package org.uma.mbd.mdNotas.notas;

import java.util.Objects;

public class Alumno {
	private String nombre;
	private String dni;
	private double nota;
	
	public Alumno(String d, String n, double c) throws AlumnoException {
		nombre = n;
		dni = d;
		if(c < 0)
			throw new AlumnoException("Calificación negativa.");
		nota = c;
	}
	
	public Alumno(String d, String n) throws AlumnoException {
		this(d,n,0);
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof Alumno al &&
				nombre.equals(al.nombre) &&
				dni.equalsIgnoreCase(al.dni);
	}
	
	public int hashCode() {
		return Objects.hash(nombre, dni.toLowerCase());
	}
	
	public String getNombre() {
		return nombre;
	}

	public String getDni() {
		return dni;
	}

	public double getCalificacion() {
		return nota;
	}
	
	public String toString() {
		return nombre + " " + dni;
	}
}
