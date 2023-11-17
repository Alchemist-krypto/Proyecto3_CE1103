package Clases;

import java.awt.*;

/**
 * Clase que proporciona métodos estáticos para pintar elementos gráficos en un JPanel.
 * Estos métodos son utilizados para representar círculos, líneas, caminos y nodos recorridos.
 * 
 * @author Fabricio Mena Mejia
 */
public class PintanrDibujos {

    // Constantes para el tamaño del círculo, grosor del contorno, grosor de la línea y tamaño de la fuente.
    private static final int CIRCLE_RADIUS = 15;
    private static final int CIRCLE_OUTLINE_WIDTH = 2;
    private static final int LINE_WIDTH = 1;
    private static final int FONT_SIZE = 16;

    /**
     * Convierte un objeto Graphics a Graphics2D.
     * 
     * @param g Objeto Graphics a convertir.
     * @return Objeto Graphics2D resultante.
     */
    private static Graphics2D castToGraphics2D(Graphics g) {
        return (Graphics2D) g;
    }

    /**
     * Pinta un círculo en la posición especificada con un número.
     * 
     * @param g Objeto Graphics utilizado para dibujar.
     * @param x Coordenada X del centro del círculo.
     * @param y Coordenada Y del centro del círculo.
     * @param n Número a mostrar en el círculo.
     */
    public static void pinta_Circulo(Graphics g, int x, int y, String n) {
        Graphics2D g2d = castToGraphics2D(g);

        g2d.setColor(Color.ORANGE);
        g2d.setStroke(new BasicStroke(CIRCLE_OUTLINE_WIDTH));
        g2d.fillOval(x, y, CIRCLE_RADIUS, CIRCLE_RADIUS);

        g2d.setColor(Color.BLACK);
        g2d.drawOval(x, y, CIRCLE_RADIUS, CIRCLE_RADIUS);

        g2d.setColor(Color.BLUE);
        Font font = new Font("Monospaced", Font.BOLD, FONT_SIZE);
        g2d.setFont(font);
        g2d.drawString(n, x, y);
    }

    /**
     * Pinta una línea entre dos puntos indicando el peso del recorrido.
     * 
     * @param g Objeto Graphics utilizado para dibujar.
     * @param x1 Coordenada X del primer punto.
     * @param y1 Coordenada Y del primer punto.
     * @param x2 Coordenada X del segundo punto.
     * @param y2 Coordenada Y del segundo punto.
     * @param tam Valor de segundos en el centro de la línea.
     */
    public static void pinta_Linea(Graphics g, int x1, int y1, int x2, int y2, double tam) {
        Graphics2D g2d = castToGraphics2D(g);

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        BasicStroke stroke = new BasicStroke(LINE_WIDTH);
        g2d.setStroke(stroke);
        g2d.drawLine(x1 + CIRCLE_RADIUS, y1 + CIRCLE_RADIUS, x2 + CIRCLE_RADIUS, y2 + CIRCLE_RADIUS);

        int xAux = (x1 <= x2) ? ((x2 - x1) / 2) + x1 : ((x1 - x2) / 2) + x2;
        int yAux = (y1 < y2) ? ((y2 - y1) / 2) + y1 : ((y1 - y2) / 2) + y2;

        g2d.setColor(Color.BLUE);
        Font font = new Font("Monospaced", Font.PLAIN, FONT_SIZE);
        g2d.setFont(font);
        g2d.drawString(String.valueOf(tam), xAux, yAux);
    }

    /**
     * Pinta un camino entre dos puntos con un color específico.
     * 
     * @param g Objeto Graphics utilizado para dibujar.
     * @param x1 Coordenada X del primer punto.
     * @param y1 Coordenada Y del primer punto.
     * @param x2 Coordenada X del segundo punto.
     * @param y2 Coordenada Y del segundo punto.
     * @param color Color del camino.
     */
    public static void pinta_Camino(Graphics g, int x1, int y1, int x2, int y2, Color color) {
        Graphics2D g2d = castToGraphics2D(g);

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        BasicStroke stroke = new BasicStroke(3);
        g2d.setStroke(stroke);
        g2d.setColor(color);
        g2d.drawLine(x1 + CIRCLE_RADIUS, y1 + CIRCLE_RADIUS, x2 + CIRCLE_RADIUS, y2 + CIRCLE_RADIUS);
    }

    /**
     * Pinta un nodo seleccionado con un color específico.
     * 
     * @param g Objeto Graphics utilizado para dibujar.
     * @param x Coordenada X del centro del círculo.
     * @param y Coordenada Y del centro del círculo.
     * @param n Número a mostrar en el círculo.
     * @param co Color del nodo seleccionado.
     */
    public static void seleccionNodo(Graphics g, int x, int y, String n, Color co) {
        Graphics2D g2d = castToGraphics2D(g);

        g2d.setColor(co);
        g2d.setStroke(new BasicStroke(CIRCLE_OUTLINE_WIDTH));
        g2d.fillOval(x, y, CIRCLE_RADIUS, CIRCLE_RADIUS);

        g2d.setColor(Color.BLUE);
        g2d.drawOval(x, y, CIRCLE_RADIUS, CIRCLE_RADIUS);
    }
    /**
     * Pinta un cuadrado en la posición especificada con un número.
     * 
     * @param g Objeto Graphics utilizado para dibujar.
     * @param x Coordenada X de la esquina superior izquierda del cuadrado.
     * @param y Coordenada Y de la esquina superior izquierda del cuadrado.
     * @param lado Longitud del lado del cuadrado.
     * @param n Número a mostrar en el cuadrado.
     */
    public static void pinta_Cuadrado(Graphics g, int x, int y, int lado, String n) {
        Graphics2D g2d = (Graphics2D) g;

        // Dibuja el cuadrado
        g2d.setColor(Color.MAGENTA); // Color del cuadrado
        g2d.fillRect(x, y, lado, lado); // Rellena el cuadrado

        // Dibuja el borde del cuadrado
        g2d.setColor(Color.BLACK); // Color del borde
        g2d.drawRect(x, y, lado, lado); // Dibuja el borde

        // Dibuja el número
        if (n != null) {
            g2d.setColor(Color.WHITE); // Color del número
            Font font = new Font("Monospaced", Font.BOLD, 16);
            g2d.setFont(font);
            g2d.drawString(n, x + lado/2 - 5, y + lado/2 + 5); // Ajusta la posición del número
        }
    }

    /**
     *
     * @param g
     * @param x
     * @param y
     * @param size
     * @param colorFondo
     */
    public static void borra_Cuadrado(Graphics g, int x, int y, int size, Color colorFondo) {
        Color colorActual = g.getColor();
        g.setColor(colorFondo);
        g.fillRect(x, y, size, size);
        g.setColor(colorActual);
    }

    /**
     *
     * @param g
     * @param x
     * @param y
     * @param n
     */
    public static void pinta_Auto(Graphics g, int x, int y, String n) {
        Graphics2D g2d = (Graphics2D) g;

        // Dibuja el cuerpo del auto
        g2d.setColor(Color.RED); // Color del auto
        g2d.fillRect(x, y, 30, 15); // Rectángulo para el cuerpo
        
        g2d.setColor(Color.GREEN); // Color del auto
        g2d.fillRect(x, y, 20, 10); // Rectángulo para el cuerpo

        // Dibuja las ruedas del auto
        g2d.setColor(Color.BLACK); // Color de las ruedas
        g2d.fillOval(x + 0, y + 10, 10, 10); // Rueda delantera
        g2d.fillOval(x + 20, y + 10, 10, 10); // Rueda trasera

        // Dibuja el número
        if (n != null) {
            g2d.setColor(Color.WHITE); // Color del número
            Font font = new Font("Monospaced", Font.BOLD, 12);
            g2d.setFont(font);
            g2d.drawString(n, x + 15, y + 15); // Posición del número en el cuerpo del auto
        }
    }

    /**
     *
     * @param g
     * @param x
     * @param y
     * @param colorFondo
     */
    public static void borra_Auto(Graphics g, int x, int y, Color colorFondo) {
        Color colorActual = g.getColor();
        g.setColor(colorFondo);
        g.fillRect(x, y, 50, 30); // Ajustar según el tamaño del auto
        g.setColor(colorActual);
    }
}
