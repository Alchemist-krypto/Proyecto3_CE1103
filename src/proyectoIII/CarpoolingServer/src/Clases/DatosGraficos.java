package Clases;

public class DatosGraficos {

    private final double MatrizCoeficiente[][] = new double[51][51];
    private final int MatrizAdyacencia[][] = new int[51][51];
    private final int cordenadaX[] = new int[51];
    private final int cordenadaY[] = new int[51];
    private final String nombre[] = new String[51];
    private int enArbol[];

 /**
 * Constructor de la clase DatosGraficos.
 * Se inicializan las matrices y arreglos.
 * @author Jose H Elel
 */
public DatosGraficos() {

}

/**
 * Obtener el coeficiente entre los nodos i y j.
     * @param i
     * @param j
     * @return 
 */
public double getmCoeficiente(int i, int j) {
    return MatrizCoeficiente[i][j];
}

/**
 * Obtener la adyacencia entre los nodos i y j.
     * @param i
     * @param j
     * @return 
 */
public int getmAdyacencia(int i, int j) {
    return MatrizAdyacencia[i][j];
}

/**
 * Obtener la coordenada x del nodo i.
     * @param i
     * @return 
 */
public int getCordeX(int i) {
    return cordenadaX[i];
}

/**
 * Obtener la coordenada y del nodo i.
     * @param i
     * @return 
 */
public int getCordeY(int i) {
    return cordenadaY[i];
}

/**
 * Obtener el nombre del nodo i.
     * @param i
     * @return 
 */
public String getNombre(int i) {
    return nombre[i];
}

/**
 * Obtener el valor enArbol en la posición i.
     * @param i
     * @return 
 */
public int getEnArbol(int i) {
    return enArbol[i];
}

/**
 * Establecer el coeficiente entre los nodos i y j.
     * @param i
     * @param j
     * @param mCoeficiente
 */
public void setmCoeficiente(int i, int j, double mCoeficiente) {
    this.MatrizCoeficiente[i][j] = mCoeficiente;
}

/**
 * Establecer la adyacencia entre los nodos i y j.
     * @param i
     * @param j
     * @param mAdyacencia
 */
public void setmAdyacencia(int i, int j, int mAdyacencia) {
    this.MatrizAdyacencia[i][j] = mAdyacencia;
}

/**
 * Establecer la coordenada x del nodo i.
     * @param i
     * @param cordeX
 */
public void setCordeX(int i, int cordeX) {
    this.cordenadaX[i] = cordeX;
}

/**
 * Establecer la coordenada y del nodo i.
     * @param i
     * @param cordeY
 */
public void setCordeY(int i, int cordeY) {
    this.cordenadaY[i] = cordeY;
}

/**
 * Establecer el nombre del nodo i.
     * @param i
     * @param nombre
 */
public void setNombre(int i, String nombre) {
    this.nombre[i] = nombre;
}

/**
 * Establecer el valor enArbol en la posición i.
     * @param i
     * @param enArbol
 */
public void setEnArbol(int i, int enArbol) {
    this.enArbol[i] = enArbol;
}

/**
 * Crear un nuevo arreglo enArbol de longitud i.
     * @param i
 */
public void crearEnArbol(int i) {
    enArbol = new int[i];
}
}
/**
 * Codigo basado en el codigo de Jose H Elel
 */