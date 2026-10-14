import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {

        String nombre = JOptionPane.showInputDialog(null, "Ingresa tu nombre:", "Inicio - IA Detector", JOptionPane.QUESTION_MESSAGE);


        javax.swing.SwingUtilities.invokeLater(() -> {
            String nombreFinal = (nombre != null && !nombre.trim().isEmpty()) ? nombre : "Jugador Anónimo";
            new Quiz(nombreFinal);
        });
    }
}