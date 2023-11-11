import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cliente extends JFrame {
    XML registo = new XML();

    public Cliente() {
        // Configurar la ventana principal
        setTitle("Interfaz con Entradas de Texto y Botón");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);

        // Crear un panel
        JPanel panel = new JPanel();

        // Crear las entradas de texto
        JTextField textField1 = new JTextField(20);
        JTextField textField2 = new JTextField(20);

        // Crear un botón
        JButton boton = new JButton("Presionar");

        // Agregar un ActionListener al botón
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String texto1 = textField1.getText();
                String texto2 = textField2.getText();
                JOptionPane.showMessageDialog(Cliente.this, "Texto 1: " + texto1 + "\nTexto 2: " + texto2);
            }
        });

        // Agregar componentes al panel
        panel.add(new JLabel("ID:"));
        panel.add(textField1);
        panel.add(new JLabel("Calificacion:"));
        panel.add(textField2);
        panel.add(boton);

        // Configurar el diseño del panel
        panel.setLayout(new GridLayout(3, 2));

        // Agregar el panel al contenido de la ventana
        add(panel);

        // Hacer visible la ventana
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Cliente();
            }
        });
    }
}
