package Ventanas;

/**
 * Clase que proporciona un método estático para pintar elementos gráficos en un JPanel.
 * Utiliza la clase PintanrDibujos para pintar líneas y círculos en base a los datos de un objeto DatosGraficos.
 * 
 * @author Fabricio Mena
 */
import Clases.DatosGraficos;
import Clases.PintanrDibujos;
import static Ventanas.Inicio.jPanel1;

/**
 *
 * @author boyfa
 */
public class MostrarDibujos {
    
    /**
     * Pinta líneas y círculos en el JPanel usando la información proporcionada por el objeto DatosGraficos.
     * 
     * @param tope Número total de nodos.
     * @param arboles Objeto DatosGraficos que contiene la información del grafo.
     */
    public static void R_repaint(int tope, DatosGraficos arboles) {
        // Pinta las líneas entre nodos conectados en el grafo.
        for (int j = 0; j < tope; j++) {
            for (int k = 0; k < tope; k++) {
                if (arboles.getmAdyacencia(j, k) == 1) {
                    PintanrDibujos.pinta_Linea(
                        jPanel1.getGraphics(),
                        arboles.getCordeX(j),
                        arboles.getCordeY(j),
                        arboles.getCordeX(k),
                        arboles.getCordeY(k),
                        arboles.getmCoeficiente(j, k)
                    );
                }
            }
        }
        
        // Pinta círculos en las posiciones de los nodos y muestra sus nombres.
        for (int j = 0; j < tope; j++) {
            PintanrDibujos.pinta_Circulo(
                jPanel1.getGraphics(),
                arboles.getCordeX(j),
                arboles.getCordeY(j),
                String.valueOf(arboles.getNombre(j))
            );
        }
    }
}

/**
 * Codigo basado en el codigo de Jose H Elel
 */