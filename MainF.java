mport javax.swing.*;
import java.awt.*;

public class MainF {

    /**
     * @wbp.parser.entryPoint
     */
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            JPanel panel = new JPanel();
            panel.setBackground(new Color(13, 20, 38));
            panel.setLayout(new GridLayout(3, 1, 5, 10));

            JLabel titulo = new JLabel("¡BIENVENIDO A AI DETECTOR!");
            titulo.setFont(new Font("SansSerif", Font.BOLD, 18));
            titulo.setForeground(new Color(139, 125, 255));

            JLabel instruccion = new JLabel("Ingresa tu nombre para comenzar:");
            instruccion.setForeground(Color.WHITE);

            JTextField campoNombre = new JTextField(15);
            campoNombre.setFont(new Font("SansSerif", Font.PLAIN, 14));

            panel.add(titulo);
            panel.add(instruccion);
            panel.add(campoNombre);

            int opcion = JOptionPane.showConfirmDialog(
                    null,
                    panel,
                    "AI Detector | Inicio",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE
            );

            if (opcion == JOptionPane.OK_OPTION) {

                String nombre = campoNombre.getText().trim();

                if (nombre.isEmpty()) {
                    nombre = "Jugador Anónimo";
                }

                new Quiz(nombre);
            }
        });
    }
}