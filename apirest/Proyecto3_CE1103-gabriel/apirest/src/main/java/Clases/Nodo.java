package Clases;

/**
 * Clase que representa un nodo en un grafo.
 * Cada nodo tiene un nombre único, un estado de visitado, una etiqueta,
 * un valor acumulado, y una referencia a su predecesor en un recorrido.
 * 
 * El propósito de esta clase es modelar las características de un nodo en el contexto de un grafo.
 * 
 * @author Fabricio Mena
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

    /**
     *
     * @return
     */

    public int getNombre() {
        return nombre;
    }

    /**
     *
     * @return
     */
    public boolean isVisitado() {
        return visitado;
    }

    /**
     *
     * @return
     */
    public boolean isEtiqueta() {
        return etiqueta;
    }

    /**
     *
     * @return
     */
    public double getAcumulado() {
        return acumulado;
    }

    /**
     *
     * @return
     */
    public Nodo getPredecesor() {
        return predecesor;
    }

    // Métodos para establecer los valores de las propiedades del nodo.

    /**
     *
     * @param nombre
     */

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @param visitado
     */
    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    /**
     *
     * @param etiqueta
     */
    public void setEtiqueta(boolean etiqueta) {
        this.etiqueta = etiqueta;
    }

    /**
     *
     * @param acumulado
     */
    public void setAcumulado(double acumulado) {
        this.acumulado = acumulado;
    }

    /**
     *
     * @param predecesor
     */
    public void setPredecesor(Nodo predecesor) {
        this.predecesor = predecesor;
    }
}
