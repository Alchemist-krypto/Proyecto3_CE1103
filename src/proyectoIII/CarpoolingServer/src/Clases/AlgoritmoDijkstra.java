package Clases;

import static Ventanas.Inicio.PintarFiguras;
import static Ventanas.Inicio.jPanel1;
import java.awt.Color;

/**
 * Clase que implementa el algoritmo de Dijkstra para encontrar el camino más corto
 * desde un nodo de origen hasta un nodo de destino en un grafo ponderado dirigido.
 * 
 * @author Fabricio Mena
 */
public class AlgoritmoDijkstra {

    private final DatosGraficos arboles;  // Representa la estructura del grafo.
    private final Nodo[] nodos;  // Arreglo de nodos del grafo.
    private int subTope;  // Contador auxiliar para el bucle.
    private Nodo nodoActual;  // Nodo actual para recorrer el camino más corto.
    private double acumuladoAuxiliar;  // Acumulado auxiliar para comparaciones.
    private double subtotalAcumulado;  // Subtotal acumulado en el proceso.
    private final int tope;  // Número total de nodos en el grafo.
    private int origen;  // Nodo de origen para el algoritmo.
    private final int nodoFinal;  // Nodo de destino para el algoritmo.

    // Constante para valor arbitrariamente grande en comparaciones.
    private static final double VALOR_GRANDE = 2000000000.0;

    /**
     * Constructor de la clase AlgoritmoDijkstra.
     * Inicializa los datos necesarios para ejecutar el algoritmo.
     * 
     * @param arboles Estructura del grafo.
     * @param tope Número total de nodos en el grafo.
     * @param permanente Nodo de origen para el algoritmo.
     * @param nodoFin Nodo de destino para el algoritmo.
     */
    public AlgoritmoDijkstra(DatosGraficos arboles, int tope, int permanente, int nodoFin) {
        this.arboles = arboles;
        this.tope = tope;
        this.nodos = new Nodo[tope];
        this.origen = permanente;
        this.nodoFinal = nodoFin;
    }

    /**
     * Obtiene el acumulado del nodo de destino después de ejecutar el algoritmo.
     * 
     * @return Acumulado del nodo de destino.
     */
    public double getAcumulado() {
        return nodos[nodoFinal].getAcumulado();
    }

    /**
     * Obtiene el nombre del nodo de destino después de ejecutar el algoritmo.
     * 
     * @return Nombre del nodo de destino.
     */
    public int getNombre() {
        return nodos[nodoFinal].getNombre();
    }

    /**
     * Implementación del algoritmo de Dijkstra para encontrar el camino más corto
     * desde el nodo de origen hasta el nodo de destino.
     */
    public void dijkstra() {
        for (int i = 0; i < tope; i++) {
            nodos[i] = new Nodo();
        }
        
        jPanel1.paint(jPanel1.getGraphics());
        PintarFiguras(tope, arboles);
        PintanrDibujos.seleccionNodo(jPanel1.getGraphics(), 
                arboles.getCordeX(origen), 
                arboles.getCordeY(origen), null, Color.GREEN);

        nodos[origen].setVisitado(true);
        nodos[origen].setNombre(origen);

        do {
            subtotalAcumulado = 0;
            acumuladoAuxiliar = VALOR_GRANDE;

            nodos[origen].setEtiqueta(true);
            
            for (int j = 0; j < tope; j++) {
                if (arboles.getmAdyacencia(j, origen) == 1) {
                    subtotalAcumulado = nodos[origen].getAcumulado() + arboles.getmCoeficiente(j, origen);

                    if (subtotalAcumulado <= nodos[j].getAcumulado() && nodos[j].isVisitado() && !nodos[j].isEtiqueta()) {
                        nodos[j].setAcumulado(subtotalAcumulado);
                        nodos[j].setVisitado(true);
                        nodos[j].setNombre(j);
                        nodos[j].setPredecesor(nodos[origen]);
                    } else if (!nodos[j].isVisitado()) {
                        nodos[j].setAcumulado(subtotalAcumulado);
                        nodos[j].setVisitado(true);
                        nodos[j].setNombre(j);
                        nodos[j].setPredecesor(nodos[origen]);
                    }
                }
            }
            
            // Encontrando Camino más corto
            for (int i = 0; i < tope; i++) {
                if (nodos[i].isVisitado() && !nodos[i].isEtiqueta()) {
                    if (nodos[i].getAcumulado() <= acumuladoAuxiliar) {
                        origen = nodos[i].getNombre();
                        acumuladoAuxiliar = nodos[i].getAcumulado();
                    }
                }
            }
            
            subTope++;
        } while (subTope < tope + 1);

        nodoActual = nodos[nodoFinal];
        
        // Pintando caminos recorridos
        while (nodoActual.getPredecesor() != null) {
            PintanrDibujos.pinta_Camino(jPanel1.getGraphics(), 
                    arboles.getCordeX(nodoActual.getNombre()),
                    arboles.getCordeY(nodoActual.getNombre()),
                    arboles.getCordeX(nodoActual.getPredecesor().getNombre()), 
                    arboles.getCordeY(nodoActual.getPredecesor().getNombre()), Color.BLUE);
            
            PintanrDibujos.seleccionNodo(jPanel1.getGraphics(), 
                    arboles.getCordeX(nodoActual.getNombre()), 
                    arboles.getCordeY(nodoActual.getNombre()), null, Color.BLUE);
            
            nodoActual = nodoActual.getPredecesor();
        }
        
        // Pintando Nodo del destino
        PintanrDibujos.seleccionNodo(jPanel1.getGraphics(), 
                arboles.getCordeX(nodoFinal), 
                arboles.getCordeY(nodoFinal), null, Color.RED);
    }
}
/**
 * Codigo basado en el codigo de Jose H Elel
 */