package Clases;

/**
 * Clase que representa un nodo en un grafo.
 * Cada nodo tiene un nombre único, un estado de visitado, una etiqueta,
 * un valor acumulado, y una referencia a su predecesor en un recorrido.
 * 
 * El propósito de esta clase es modelar las características de un nodo en el contexto de un grafo.
 * 
 * @author Jose H Elel
 */
public class Nodo {    
    private int nombre;        // Nombre único del nodo.
    private boolean visitado;  // Indica si el nodo ha sido visitado en algún recorrido.
    private boolean etiqueta;  // Etiqueta para propósitos específicos en el contexto del grafo.
    private double acumulado;  // Lleva el acumulado de algún valor asociado al nodo.
    private Nodo predecesor;   // Referencia al predecesor del nodo en un recorrido.

    /**
     * Constructor de la clase Nodo.
     * Inicializa las propiedades del nodo.
     */
    public Nodo(){
        this.nombre = -1;         // Se inicializa con un valor no válido.
        this.visitado = false;    // Se inicializa como no visitado.
        this.etiqueta = false;    // Se inicializa sin etiqueta.
        this.predecesor = null;   // Se inicializa sin predecesor.
        this.acumulado = 0;       // Se inicializa el acumulado en 0.
    }

    // Métodos para obtener los valores de las propiedades del nodo.

    public int getNombre() {
        return nombre;
    }

    public boolean isVisitado() {
        return visitado;
    }

    public boolean isEtiqueta() {
        return etiqueta;
    }

    public double getAcumulado() {
        return acumulado;
    }

    public Nodo getPredecesor() {
        return predecesor;
    }

    // Métodos para establecer los valores de las propiedades del nodo.

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    public void setEtiqueta(boolean etiqueta) {
        this.etiqueta = etiqueta;
    }

    public void setAcumulado(double acumulado) {
        this.acumulado = acumulado;
    }

    public void setPredecesor(Nodo predecesor) {
        this.predecesor = predecesor;
    }
}
