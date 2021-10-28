package org.uma.mbd.mdNotas.notas;

import java.util.List;
import java.util.OptionalDouble;

public class MediaAritmetica implements CalculoMedia {

	@Override
	public double calcular(List<Alumno> als) throws AlumnoException{
		if(als.isEmpty()) throw new AlumnoException("No hay alumnos.");
		double sum = 0;
		for(Alumno al : als)
			sum += al.getCalificacion();

		return sum/als.size();
	}
}
