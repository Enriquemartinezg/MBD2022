package org.uma.mbd.mdNotas.notas;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;

public class MediaSinExtremos implements CalculoMedia{
	private double min;
	private double max;
	
	public MediaSinExtremos(double min, double max){
		this.min = min;
		this.max = max;
	}

	@Override
	public double calcular(List<Alumno> als) throws AlumnoException{
		// COMPLETAR
		return 0;
	}
}
