import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazRectanguloBoton extends JFrame {
    XML registo = new XML();
    private static final long serialVersionUID = 1L;

    public InterfazRectanguloBoton() {
        // Configurar la ventana principal
        setTitle("Interfaz con Entradas de Texto y Botón");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        // Crear un panel personalizado
        JPanel panel = new JPanel();

        // Crear tres entradas de texto
        JTextField textField1 = new JTextField(10);
        JTextField textField2 = new JTextField(10);
        JTextField textField3 = new JTextField(10);

        // Crear un botón
        JButton boton = new JButton("Presionar");

        // Agregar un ActionListener al botón
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String texto1 = textField1.getText();
                String texto2 = textField2.getText();
                String texto3 = textField3.getText();
                registo.EscribeXML(texto1, texto2, texto3, "driver");
                JOptionPane.showMessageDialog(InterfazRectanguloBoton.this, "Textos ingresados:\n" +
                        " Nombre: " + texto1 + "\nID: " + texto2 + "\nDireccion: " + texto3);
            }
        });

        // Agregar componentes al panel
        panel.add(new JLabel("Texto 1:"));
        panel.add(textField1);
        panel.add(new JLabel("Texto 2:"));
        panel.add(textField2);
        panel.add(new JLabel("Texto 3:"));
        panel.add(textField3);
        panel.add(boton);

        // Configurar el diseño del panel
        panel.setLayout(new GridLayout(4, 2));

        // Agregar el panel al contenido de la ventana
        add(panel);

        // Hacer visible la ventana
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new InterfazRectanguloBoton();
            }
        });
    }
}
