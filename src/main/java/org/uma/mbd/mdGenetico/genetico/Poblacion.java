package org.uma.mbd.mdGenetico.genetico;

public class Poblacion {
    private Individuo[] individuos;

    /**
     * @param tamaño   Número de individuos de la población.
     * @param longitud Tamaño de los cromosomas de los individuos de la población.
     * @param problema Problema a resolver.
     * @throws RuntimeException si el tamaño de la población o la longitud de los cromosomas
     *                          indicados no son válidos.
     */
    public Poblacion(int tamaño, int longitud, Problema problema) {
        individuos = new Individuo[tamaño];
        if (tamaño <= 0 || longitud <= 0)
            throw new RuntimeException("Tamaño o longitud incorrectos.");

        for (int i = 0; i < tamaño; i++) {
            individuos[i] = new Individuo(longitud, problema);
        }
    }

    /**
     * Devuelve el número de individuos.
     *
     * @return Número de individuos en la población.
     */
    public int numIndividuos() {
        return individuos.length;
    }

    /**
     * Devuelve el individuo con fitness mayor de la población.
     *
     * @return Individuo con mejor fitness.
     */
    public Individuo mejorIndividuo() {
        double fitness = 0;
        int indexOfBestFitness = 0;
        for (int i = 0; i < numIndividuos(); i++) {
            if (individuos[i].fitness() > fitness) {
                indexOfBestFitness = i;
            }
        }
        return individuos[indexOfBestFitness];
    }

    /**
     * Devuelve el i-ésimo individuo de la población.
     *
     * @param i Posición del individuo a devolver.
     * @return Individuo en la posición i.
     * @throws RuntimeException si el índice está fuera del rango de valores válidos.
     */
    public Individuo individuo(int i) {
        return individuos[i];
    }

    /**
     * Si el individuo que se pasa como argumento tienen mejor fitness que el
     * peor de los individuos de la población, entonces el peor es sustituido
     * por el que se pasa.
     *
     * @param ind Individuo con el que se sustituye el peor de los individuos si
     *            este es mejor.
     */
    public void reemplaza(Individuo ind) {
        int indexOfWorstFitness = 0;
        double worstFitness = individuos[0].fitness();
        for (int i = 0; i < individuos.length; i++) {
            if (individuos[i].fitness() < worstFitness) indexOfWorstFitness = i;

        }
        individuos[indexOfWorstFitness] = ind;
    }

}
