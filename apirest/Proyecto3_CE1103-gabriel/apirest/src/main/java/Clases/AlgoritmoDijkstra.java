package Clases;

import static Ventanas.Inicio.PintarFiguras;
import static Ventanas.Inicio.jPanel1;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Clase que implementa el algoritmo de Dijkstra para encontrar el camino más corto en un grafo.
 * @author Fabricio Mena
 */
public class AlgoritmoDijkstra {

    private final DatosGraficos arboles; // Representación gráfica del grafo
    private final Nodo[] nodos; // Arreglo de nodos del grafo
    private int subTope;
    private final int tope; // Número total de nodos en el grafo
    private int origen; // Nodo de origen para el algoritmo
    private final int nodoFinal; // Nodo final o destino
    private static final double VALOR_GRANDE = 2000000000.0; // Valor grande para inicialización

    /**
     * Constructor de la clase AlgoritmoDijkstra.
     *
     * @param arboles    Representación gráfica del grafo.
     * @param tope       Número total de nodos en el grafo.
     * @param permanente Nodo de origen para el algoritmo.
     * @param nodoFin    Nodo final o destino.
     */
    public AlgoritmoDijkstra(DatosGraficos arboles, int tope, int permanente, int nodoFin) {
        this.arboles = arboles;
        this.tope = tope;
        this.nodos = new Nodo[tope];
        this.origen = permanente;
        this.nodoFinal = nodoFin;
    }

    /**
     * Obtiene el valor acumulado en el nodo final.
     *
     * @return El valor acumulado en el nodo final.
     */
    public double getAcumulado() {
        return nodos[nodoFinal].getAcumulado();
    }

    /**
     * Obtiene el nombre del nodo final.
     *
     * @return El nombre del nodo final.
     */
    public int getNombre() {
        return nodos[nodoFinal].getNombre();
    }

    /**
     * Obtiene el camino desde el nodo origen hasta el nodo final.
     *
     * @return Lista de nodos representando el camino.
     */
    public List<Nodo> obtenerCamino() {
        List<Nodo> camino = new ArrayList<>();
        Nodo nodoCamino = nodos[nodoFinal];

        while (nodoCamino != null) {
            camino.add(0, nodoCamino);
            nodoCamino = nodoCamino.getPredecesor();
        }

        return camino;
    }

    /**
     * Implementación del algoritmo de Dijkstra para encontrar el camino más corto en un grafo.
     * 
     */
    public void calcularCaminoMasCorto() {
        // Inicializa los nodos del grafo
        for (int i = 0; i < tope; i++) {
            nodos[i] = new Nodo();
        }

        jPanel1.paint(jPanel1.getGraphics());
        PintarFiguras(tope, arboles);
        PintanrDibujos.seleccionNodo(jPanel1.getGraphics(), arboles.getCordeX(origen), arboles.getCordeY(origen), null,
                Color.GREEN);

        nodos[origen].setVisitado(true);
        nodos[origen].setNombre(origen);

        do {
            double subtotalAcumulado = 0;
            double acumuladoAuxiliar = VALOR_GRANDE;
            nodos[origen].setEtiqueta(true);

            for (int j = 0; j < tope; j++) {
                if (arboles.getmAdyacencia(j, origen) == 1) {
                    subtotalAcumulado = nodos[origen].getAcumulado() + arboles.getmCoeficiente(j, origen);

                    if (subtotalAcumulado <= nodos[j].getAcumulado() && nodos[j].isVisitado()
                            && !nodos[j].isEtiqueta()) {
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
    }
    /**
     * 
     * Este método inicializa el proceso y gestiona la visualización del recorrido.
     */
    public void realizarAnimacion() {
        List<Nodo> camino = obtenerCamino();
        // Dibuja el camino completo en azul antes de comenzar la animación
        for (int i = 0; i < camino.size() - 1; i++) {
            Nodo nodoActual = camino.get(i);
            Nodo siguienteNodo = camino.get(i + 1);

            PintanrDibujos.pinta_Camino(jPanel1.getGraphics(),
                    arboles.getCordeX(nodoActual.getNombre()),
                    arboles.getCordeY(nodoActual.getNombre()),
                    arboles.getCordeX(siguienteNodo.getNombre()),
                    arboles.getCordeY(siguienteNodo.getNombre()), Color.BLUE);
        }
        // Calcula el tiempo total del recorrido en milisegundos
        long tiempoTotalRecorrido = (long) (getAcumulado() * 1000);
        int totalPasos = (camino.size() - 1) * 10; // Asumiendo 10 pasos entre cada par de nodos
        long tiempoPorPaso = tiempoTotalRecorrido / totalPasos;

        int xUltimaPosicion = -1;
        int yUltimaPosicion = -1;

        for (int i = 0; i < camino.size() - 1; i++) {
            Nodo nodoActual = camino.get(i);
            Nodo siguienteNodo = camino.get(i + 1);

            int pasos = 10;
            for (int paso = 1; paso <= pasos; paso++) {
                double dx = (arboles.getCordeX(siguienteNodo.getNombre()) - arboles.getCordeX(nodoActual.getNombre()))
                        / (double) pasos;
                double dy = (arboles.getCordeY(siguienteNodo.getNombre()) - arboles.getCordeY(nodoActual.getNombre()))
                        / (double) pasos;
                int xIntermedio = arboles.getCordeX(nodoActual.getNombre()) + (int) (dx * paso);
                int yIntermedio = arboles.getCordeY(nodoActual.getNombre()) + (int) (dy * paso);

                if (xUltimaPosicion != -1 && yUltimaPosicion != -1) {
                    PintanrDibujos.borra_Auto(jPanel1.getGraphics(), xUltimaPosicion, yUltimaPosicion, Color.WHITE);
                }

                xUltimaPosicion = xIntermedio - 10;
                yUltimaPosicion = yIntermedio - 10;

                PintarFiguras(tope, arboles);
                PintanrDibujos.pinta_Auto(jPanel1.getGraphics(), xIntermedio - 10, yIntermedio - 10, null);
                // Redibuja el grafo, el camino en azul y el auto en la nueva posición
                PintarFiguras(tope, arboles);

                // Redibuja el camino en azul
                for (int j = 0; j < camino.size() - 1; j++) {
                    Nodo nodo = camino.get(j);
                    Nodo nodoSig = camino.get(j + 1);

                    PintanrDibujos.pinta_Camino(jPanel1.getGraphics(),
                            arboles.getCordeX(nodo.getNombre()),
                            arboles.getCordeY(nodo.getNombre()),
                            arboles.getCordeX(nodoSig.getNombre()),
                            arboles.getCordeY(nodoSig.getNombre()), Color.BLUE);
                }

                // Dibuja el auto en la nueva posición
                PintanrDibujos.pinta_Auto(jPanel1.getGraphics(), xIntermedio - 10, yIntermedio - 10, null);
                try {
                    Thread.sleep(tiempoPorPaso);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
           
        }

        PintarFiguras(tope, arboles);
        if (xUltimaPosicion != -1 && yUltimaPosicion != -1) {
            PintanrDibujos.borra_Auto(jPanel1.getGraphics(), xUltimaPosicion, yUltimaPosicion, Color.WHITE);
        }

        Nodo nodoFinal = camino.get(camino.size() - 1);
        PintanrDibujos.pinta_Auto(jPanel1.getGraphics(), arboles.getCordeX(nodoFinal.getNombre()) - 10,
                arboles.getCordeY(nodoFinal.getNombre()) - 10, String.valueOf(nodoFinal.getNombre()));
        // Al finalizar la animación, muestra un cuadro de diálogo
        JOptionPane.showMessageDialog(jPanel1, "Viaje finalizado!\nPuede Calificar al conductor", "Fin del Viaje",
                JOptionPane.INFORMATION_MESSAGE);

    }

}
