package Ventanas;

import Clases.DatosGraficos;
import Clases.PintanrDibujos;
import Clases.AlgoritmoDijkstra;
import javax.swing.JOptionPane;

import java.util.Random;

/**
 * Clase que representa la ventana principal de la aplicación.
 * Contiene métodos para pintar figuras en un JPanel y gestiona la
 * inicialización de la interfaz gráfica.
 * La interfaz incluye opciones para seleccionar nodos de origen y destino, y
 * buscar caminos en un grafo.
 * 
 * @author Fabricio Mena Mejia
 */
public class Inicio extends javax.swing.JFrame {

    // Número de nodos en el grafo
    private int Numerotope = 0;

    // Objeto que almacena la información del grafo
    DatosGraficos arboles = new DatosGraficos();

    /**
     * Pinta las figuras gráficas (líneas y círculos) en un JPanel en base a la
     * información del grafo.
     * 
     * @param tope    Número total de nodos.
     * @param arboles Objeto DatosGraficos que contiene la información del grafo.
     */
    public static void PintarFiguras(int tope, DatosGraficos arboles) {
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
                            arboles.getmCoeficiente(j, k));
                }
            }
        }

        // Pinta círculos en las posiciones de los nodos y muestra sus nombres.
        for (int j = 0; j < tope; j++) {
            PintanrDibujos.pinta_Circulo(
                    jPanel1.getGraphics(),
                    arboles.getCordeX(j),
                    arboles.getCordeY(j),
                    arboles.getNombre(j));
        }
    }

    /**
     * Constructor de la clase Inicio. Inicializa los componentes de la interfaz
     * gráfica.
     * Configura opciones iniciales, como la inhabilitación de ciertos controles.
     */
    public Inicio() {
        initComponents();
        // Inicialización de la interfaz: deshabilita ciertos controles
        EleccionDestino.setEnabled(false);
        EleccionOrigen.setEnabled(false);
        BuscarCamino.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MostrarCaminos = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        ImgMapa = new javax.swing.JLabel();
        CalificacionesBoton = new javax.swing.JButton();
        TopBoton = new javax.swing.JButton();
        Añadirboton = new javax.swing.JButton();
        EleccionDestino = new javax.swing.JComboBox<>();
        BuscarCamino = new javax.swing.JButton();
        EleccionOrigen = new javax.swing.JComboBox<>();
        txtDestino = new javax.swing.JLabel();
        kmRecorridos = new javax.swing.JLabel();
        kmRecorridos1 = new javax.swing.JLabel();
        LateralSuperior1 = new javax.swing.JLabel();
        kmRecorridos2 = new javax.swing.JLabel();
        txtOrigen = new javax.swing.JLabel();
        BotonSalir = new javax.swing.JButton();
        LateralSuperior2 = new javax.swing.JLabel();
        colorOrigen = new javax.swing.JLabel();
        txtColorOrigen = new javax.swing.JLabel();
        colorDestino = new javax.swing.JLabel();
        txtColorDestino = new javax.swing.JLabel();
        colorNodoVisitado = new javax.swing.JLabel();
        txtColorNodoRecorrido = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();
        LateralSuperior = new javax.swing.JLabel();
        LateralSuperior3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MostrarCaminos.setBackground(new java.awt.Color(255, 255, 204));
        MostrarCaminos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        MostrarCaminos.setForeground(new java.awt.Color(0, 0, 204));
        MostrarCaminos.setText("Mostrar Caminos");
        MostrarCaminos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MostrarCaminosActionPerformed(evt);
            }
        });
        getContentPane().add(MostrarCaminos, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 220, 50));

        jPanel1.setBackground(new java.awt.Color(255, 255, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ImgMapa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/mapa.jpeg"))); // NOI18N
        jPanel1.add(ImgMapa, new org.netbeans.lib.awtextra.AbsoluteConstraints(-290, 60, 1760, 970));

        CalificacionesBoton.setText("Calificar");
        CalificacionesBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalificacionesBotonActionPerformed(evt);
            }
        });
        jPanel1.add(CalificacionesBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, 80, 40));

        TopBoton.setText("Top 5");
        TopBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TopBotonActionPerformed(evt);
            }
        });
        jPanel1.add(TopBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 10, 80, 40));

        Añadirboton.setText("Añadir amigo");
        Añadirboton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AñadirbotonActionPerformed(evt);
            }
        });
        jPanel1.add(Añadirboton, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 10, 80, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 850, 690));

        EleccionDestino.setBackground(new java.awt.Color(0, 153, 51));
        EleccionDestino.setFont(new java.awt.Font("Recinto", 1, 18));
        EleccionDestino.setForeground(new java.awt.Color(0, 0, 153));
        EleccionDestino.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Recinto", "Nodo 1", "Nodo 2",
                "Nodo 3", "Nodo 4", "Nodo 5", "Nodo 6", "Nodo 7", "Nodo 8", "Nodo 9", "Nodo 10", "Nodo 11", "Nodo 12",
                "Nodo 13", "Nodo 14", "Nodo 15", "Nodo 16", "Nodo 17", "Nodo 18", "Nodo 19", "Nodo 20", "Nodo 21",
                "Nodo 22", "Nodo 23", "Nodo 24", "Nodo 25", "Nodo 26", "Nodo 27", "Nodo 28", "Nodo 29" }));
        EleccionDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EleccionDestinoActionPerformed(evt);
            }
        });
        getContentPane().add(EleccionDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 170, 460, 40));

        BuscarCamino.setBackground(new java.awt.Color(0, 153, 51));
        BuscarCamino.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BuscarCamino.setForeground(new java.awt.Color(51, 0, 204));
        BuscarCamino.setText("Buscar Camino mas corto");
        BuscarCamino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarCaminoActionPerformed(evt);
            }
        });
        getContentPane().add(BuscarCamino, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 490, 60));

        EleccionOrigen.setBackground(new java.awt.Color(0, 153, 51));
        EleccionOrigen.setFont(new java.awt.Font("Recinto", 1, 18));
        EleccionOrigen.setForeground(new java.awt.Color(0, 0, 153));
        EleccionOrigen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Recinto", "Nodo 1", "Nodo 2",
                "Nodo 3", "Nodo 4", "Nodo 5", "Nodo 6", "Nodo 7", "Nodo 8", "Nodo 9", "Nodo 10", "Nodo 11", "Nodo 12",
                "Nodo 13", "Nodo 14", "Nodo 15", "Nodo 16", "Nodo 17", "Nodo 18", "Nodo 19", "Nodo 20", "Nodo 21",
                "Nodo 22", "Nodo 23", "Nodo 24", "Nodo 25", "Nodo 26", "Nodo 27", "Nodo 28", "Nodo 29" }));
        EleccionOrigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EleccionOrigenActionPerformed(evt);
            }
        });
        getContentPane().add(EleccionOrigen, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 460, 40));

        txtDestino.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtDestino.setForeground(new java.awt.Color(200, 55, 255));
        txtDestino.setText("Selecciona el destino:");
        getContentPane().add(txtDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 260, 40));

        kmRecorridos.setBackground(new java.awt.Color(255, 255, 102));
        kmRecorridos.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        kmRecorridos.setForeground(new java.awt.Color(0, 0, 153));
        kmRecorridos.setOpaque(true);
        getContentPane().add(kmRecorridos, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 280, 240, 30));

        kmRecorridos1.setBackground(new java.awt.Color(255, 255, 102));
        kmRecorridos1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        kmRecorridos1.setForeground(new java.awt.Color(0, 0, 153));
        kmRecorridos1.setOpaque(true);
        getContentPane().add(kmRecorridos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, 140, 40));

        LateralSuperior1.setBackground(new java.awt.Color(255, 255, 102));
        LateralSuperior1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        LateralSuperior1.setForeground(new java.awt.Color(0, 0, 153));
        LateralSuperior1.setOpaque(true);
        getContentPane().add(LateralSuperior1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 700, 560, 30));

        kmRecorridos2.setBackground(new java.awt.Color(255, 255, 102));
        kmRecorridos2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        kmRecorridos2.setForeground(new java.awt.Color(0, 0, 153));
        kmRecorridos2.setText("                         Tiempo estimado de viaje:");
        kmRecorridos2.setOpaque(true);
        getContentPane().add(kmRecorridos2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-70, 280, 510, 30));

        txtOrigen.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtOrigen.setForeground(new java.awt.Color(255, 0, 0));
        txtOrigen.setText("Selecciona el origen:");
        getContentPane().add(txtOrigen, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 250, 40));

        BotonSalir.setBackground(new java.awt.Color(255, 51, 51));
        BotonSalir.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BotonSalir.setForeground(new java.awt.Color(255, 255, 255));
        BotonSalir.setText("X");
        BotonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonSalirActionPerformed(evt);
            }
        });
        getContentPane().add(BotonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, 50, 50));

        LateralSuperior2.setBackground(new java.awt.Color(255, 255, 102));
        LateralSuperior2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        LateralSuperior2.setForeground(new java.awt.Color(0, 0, 153));
        LateralSuperior2.setText("                            Bienvenido al sistema");
        LateralSuperior2.setOpaque(true);
        getContentPane().add(LateralSuperior2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 840, 30));

        colorOrigen.setBackground(new java.awt.Color(255, 0, 0));
        colorOrigen.setOpaque(true);
        getContentPane().add(colorOrigen, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 210, 20, 20));

        txtColorOrigen.setBackground(new java.awt.Color(255, 255, 102));
        txtColorOrigen.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtColorOrigen.setForeground(new java.awt.Color(51, 0, 204));
        txtColorOrigen.setText("Origen--------------->");
        txtColorOrigen.setOpaque(true);
        getContentPane().add(txtColorOrigen, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 200, 350, 40));

        colorDestino.setBackground(new java.awt.Color(51, 255, 51));
        colorDestino.setOpaque(true);
        getContentPane().add(colorDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 250, 20, 20));

        txtColorDestino.setBackground(new java.awt.Color(255, 255, 102));
        txtColorDestino.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtColorDestino.setForeground(new java.awt.Color(51, 0, 204));
        txtColorDestino.setText("Destino-------------->");
        txtColorDestino.setOpaque(true);
        getContentPane().add(txtColorDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 240, 340, 30));

        colorNodoVisitado.setBackground(new java.awt.Color(0, 51, 255));
        colorNodoVisitado.setOpaque(true);
        getContentPane().add(colorNodoVisitado, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 280, 20, 20));

        txtColorNodoRecorrido.setBackground(new java.awt.Color(255, 255, 102));
        txtColorNodoRecorrido.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtColorNodoRecorrido.setForeground(new java.awt.Color(51, 0, 204));
        txtColorNodoRecorrido.setText("Nodo Recorrido ---->");
        txtColorNodoRecorrido.setOpaque(true);
        getContentPane().add(txtColorNodoRecorrido,
                new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 270, 330, 40));

        Fondo.setBackground(new java.awt.Color(255, 255, 153));
        Fondo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo.jpg"))); // NOI18N
        Fondo.setOpaque(true);
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 600, 740));

        LateralSuperior.setBackground(new java.awt.Color(255, 255, 102));
        LateralSuperior.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        LateralSuperior.setForeground(new java.awt.Color(0, 0, 153));
        LateralSuperior.setOpaque(true);
        getContentPane().add(LateralSuperior, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 730));

        LateralSuperior3.setBackground(new java.awt.Color(255, 255, 102));
        LateralSuperior3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        LateralSuperior3.setForeground(new java.awt.Color(0, 0, 153));
        LateralSuperior3.setText("                            Bienvenido al sistema");
        LateralSuperior3.setOpaque(true);
        getContentPane().add(LateralSuperior3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 530, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AñadirbotonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_AñadirbotonActionPerformed
        EnviarAmigo.main(new String[] {}); // TODO add your handling code here:
    }// GEN-LAST:event_AñadirbotonActionPerformed

    private void EleccionDestinoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_EleccionDestinoActionPerformed
        BuscarCamino.setEnabled(true);
    }// GEN-LAST:event_EleccionDestinoActionPerformed

    private void EleccionOrigenActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_EleccionOrigenActionPerformed
        EleccionDestino.setEnabled(true);
    }// GEN-LAST:event_EleccionOrigenActionPerformed

    private void BuscarCaminoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_BuscarCaminoActionPerformed
        int origen = 0, destino = 0;
        String nombreOrigen, nombreDestino;
        nombreOrigen = (String) EleccionOrigen.getSelectedItem();
        nombreDestino = (String) EleccionDestino.getSelectedItem();

        if ("Recinto".equals(nombreOrigen)) {
            origen = 0;
        }
        if ("Nodo 1".equals(nombreOrigen)) {
            origen = 1;
        }
        if ("Nodo 2".equals(nombreOrigen)) {
            origen = 2;
        }
        if ("Nodo 3".equals(nombreOrigen)) {
            origen = 3;
        }
        if ("Nodo 4".equals(nombreOrigen)) {
            origen = 4;
        }
        if ("Nodo 5".equals(nombreOrigen)) {
            origen = 5;
        }
        if ("Nodo 6".equals(nombreOrigen)) {
            origen = 6;
        }
        if ("Nodo 7".equals(nombreOrigen)) {
            origen = 7;
        }
        if ("Nodo 8".equals(nombreOrigen)) {
            origen = 8;
        }
        if ("Nodo 9".equals(nombreOrigen)) {
            origen = 9;
        }
        if ("Nodo 10".equals(nombreOrigen)) {
            origen = 10;
        }
        if ("Nodo 11".equals(nombreOrigen)) {
            origen = 11;
        }
        if ("Nodo 12".equals(nombreOrigen)) {
            origen = 12;
        }
        if ("Nodo 13".equals(nombreOrigen)) {
            origen = 13;
        }
        if ("Nodo 14".equals(nombreOrigen)) {
            origen = 14;
        }
        if ("Nodo 15".equals(nombreOrigen)) {
            origen = 15;
        }
        if ("Nodo 16".equals(nombreOrigen)) {
            origen = 16;
        }
        if ("Nodo 17".equals(nombreOrigen)) {
            origen = 17;
        }
        if ("Nodo 18".equals(nombreOrigen)) {
            origen = 18;
        }
        if ("Nodo 19".equals(nombreOrigen)) {
            origen = 19;
        }
        if ("Nodo 20".equals(nombreOrigen)) {
            origen = 20;
        }
        if ("Nodo 21".equals(nombreOrigen)) {
            origen = 21;
        }
        if ("Nodo 22".equals(nombreOrigen)) {
            origen = 22;
        }
        if ("Nodo 23".equals(nombreOrigen)) {
            origen = 23;
        }
        if ("Nodo 24".equals(nombreOrigen)) {
            origen = 24;
        }
        if ("Nodo 25".equals(nombreOrigen)) {
            origen = 25;
        }
        if ("Nodo 26".equals(nombreOrigen)) {
            origen = 26;
        }
        if ("Nodo 27".equals(nombreOrigen)) {
            origen = 27;
        }
        if ("Nodo 28".equals(nombreOrigen)) {
            origen = 28;
        }
        if ("Nodo 29".equals(nombreOrigen)) {
            origen = 29;
        }

        if ("Recinto".equals(nombreDestino)) {
            destino = 0;
        }
        if ("Nodo 1".equals(nombreDestino)) {
            destino = 1;
        }
        if ("Nodo 2".equals(nombreDestino)) {
            destino = 2;
        }
        if ("Nodo 3".equals(nombreDestino)) {
            destino = 3;
        }
        if ("Nodo 4".equals(nombreDestino)) {
            destino = 4;
        }
        if ("Nodo 5".equals(nombreDestino)) {
            destino = 5;
        }
        if ("Nodo 6".equals(nombreDestino)) {
            destino = 6;
        }
        if ("Nodo 7".equals(nombreDestino)) {
            destino = 7;
        }
        if ("Nodo 8".equals(nombreDestino)) {
            destino = 8;
        }
        if ("Nodo 9".equals(nombreDestino)) {
            destino = 9;
        }
        if ("Nodo 10".equals(nombreDestino)) {
            destino = 10;
        }
        if ("Nodo 11".equals(nombreDestino)) {
            destino = 11;
        }
        if ("Nodo 12".equals(nombreDestino)) {
            destino = 12;
        }
        if ("Nodo 13".equals(nombreDestino)) {
            destino = 13;
        }
        if ("Nodo 14".equals(nombreDestino)) {
            destino = 14;
        }
        if ("Nodo 15".equals(nombreDestino)) {
            destino = 15;
        }
        if ("Nodo 16".equals(nombreDestino)) {
            destino = 16;
        }
        if ("Nodo 17".equals(nombreDestino)) {
            destino = 17;
        }
        if ("Nodo 18".equals(nombreDestino)) {
            destino = 18;
        }
        if ("Nodo 19".equals(nombreDestino)) {
            destino = 19;
        }
        if ("Nodo 20".equals(nombreDestino)) {
            destino = 20;
        }
        if ("Nodo 21".equals(nombreDestino)) {
            destino = 21;
        }
        if ("Nodo 22".equals(nombreDestino)) {
            destino = 22;
        }
        if ("Nodo 23".equals(nombreDestino)) {
            destino = 23;
        }
        if ("Nodo 24".equals(nombreDestino)) {
            destino = 24;
        }
        if ("Nodo 25".equals(nombreDestino)) {
            destino = 25;
        }
        if ("Nodo 26".equals(nombreDestino)) {
            destino = 26;
        }
        if ("Nodo 27".equals(nombreDestino)) {
            destino = 27;
        }
        if ("Nodo 28".equals(nombreDestino)) {
            destino = 28;
        }
        if ("Nodo 29".equals(nombreDestino)) {
            destino = 29;
        }
        if (origen == destino) {
            JOptionPane.showMessageDialog(null, "Estas en:" + nombreOrigen);
        } else {
            AlgoritmoDijkstra Dijkstra = new AlgoritmoDijkstra(arboles, Numerotope, origen, destino);
            Dijkstra.dijkstra();
            kmRecorridos.setText(Dijkstra.getAcumulado() + "segundos");
        }
    }// GEN-LAST:event_BuscarCaminoActionPerformed

    private void BotonSalirActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_BotonSalirActionPerformed
        System.exit(0); // TODO add your handling code here:
    }// GEN-LAST:event_BotonSalirActionPerformed

    private void MostrarCaminosActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_MostrarCaminosActionPerformed
        // jMenuItem2.setEnabled(false);
        EleccionOrigen.setEnabled(true);
        MostrarCaminos.setEnabled(false);
        MostrarCaminos.setVisible(false);

        // Se crea la matriz con las ubicaciones fijas para cada nodo
        int Matriz[][] = {
                // 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29
                // 30
                { 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 }, // 1
                { 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0 }, // 2
                { 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0 }, // 3
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, // 4
                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, // 5
                { 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, // 6
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 7
                { 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 8
                { 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 }, // 9
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 10
                { 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0 }, // 11
                { 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 12
                { 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 13
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 }, // 14
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 15
                { 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 16
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, // 17
                { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 18
                { 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0 }, // 19
                { 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 }, // 20
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 21
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 22
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1 }, // 23
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, // 24
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 25
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0 }, // 26
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0 }, // 27
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0 }, // 28
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0 }, // 29
                { 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 }// 30
        };

        // Se crea la matriz con los tiempos aleatorios
        double coe[][] = new double[30][30];
        Random random = new Random();
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 30; j++) {
                coe[i][j] = random.nextInt(10) + 1;
            }
        }

        // Se define la posicion en x de cada nodo
        int xx1[] = { 425, 375, 280, 540, 440, 425, 275, 260, 350, 170, 600, 450, 470, 160, 140, 315, 110, 375, 220,
                190, 200, 525, 400, 100, 109, 230, 210, 170, 150, 300, 230 };
        // Se define la posicion en y de cada nodo
        int yy1[] = { 405, 485, 540, 550, 185, 530, 430, 630, 550, 370, 425, 550, 615, 520, 585, 565, 480, 630, 535,
                605, 510, 485, 400, 200, 130, 270, 210, 110, 180, 100, 160 };
        // Se definen los nombres de cada nodo
        String nom[] = { "Recinto", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15",
                "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29" };
        // Se configuran las posiciones (x, y) y nombres de los nodos en el objeto
        // 'arboles'.
        for (int j = 0; j < 30; j++) {
            arboles.setCordeX(j, xx1[j]);
            arboles.setCordeY(j, yy1[j]);
            arboles.setNombre(j, nom[j]);
        }
        // Establece la relacion entre los valores de adyacencia y peso en el objeto
        // 'arboles'
        for (int j = 0; j < 30; j++) {
            for (int k = 0; k < 30; k++) {
                arboles.setmAdyacencia(j, k, Matriz[j][k]);
                arboles.setmCoeficiente(j, k, coe[j][k]);
            }
        }
        // Numero maximo de elementos de la matriz
        Numerotope = 30;
        PintarFiguras(Numerotope, arboles);
    }// GEN-LAST:event_MostrarCaminosActionPerformed

    private void CalificacionesBotonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_CalificacionesBotonActionPerformed
        Calificaciones.main(new String[] {});
    }// GEN-LAST:event_CalificacionesBotonActionPerformed

    private void TopBotonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_TopBotonActionPerformed
        Top5.main(new String[] {});

    }// GEN-LAST:event_TopBotonActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Inicio().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Añadirboton;
    private javax.swing.JButton BotonSalir;
    private javax.swing.JButton BuscarCamino;
    private javax.swing.JButton CalificacionesBoton;
    private javax.swing.JComboBox<String> EleccionDestino;
    private javax.swing.JComboBox<String> EleccionOrigen;
    private javax.swing.JLabel Fondo;
    private javax.swing.JLabel ImgMapa;
    private javax.swing.JLabel LateralSuperior;
    private javax.swing.JLabel LateralSuperior1;
    private javax.swing.JLabel LateralSuperior2;
    private javax.swing.JLabel LateralSuperior3;
    private javax.swing.JButton MostrarCaminos;
    private javax.swing.JButton TopBoton;
    private javax.swing.JLabel colorDestino;
    private javax.swing.JLabel colorNodoVisitado;
    private javax.swing.JLabel colorOrigen;
    public static javax.swing.JPanel jPanel1;
    private javax.swing.JLabel kmRecorridos;
    private javax.swing.JLabel kmRecorridos1;
    private javax.swing.JLabel kmRecorridos2;
    private javax.swing.JLabel txtColorDestino;
    private javax.swing.JLabel txtColorNodoRecorrido;
    private javax.swing.JLabel txtColorOrigen;
    private javax.swing.JLabel txtDestino;
    private javax.swing.JLabel txtOrigen;
    // End of variables declaration//GEN-END:variables
}
/**
 * Codigo basado en el codigo de Jose H Elel
 */