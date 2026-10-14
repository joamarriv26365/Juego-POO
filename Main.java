import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) { 

      
        String nombre = JOptionPane.showInputDialog(null, "Ingresa tu nombre:", "Inicio - IA Detector", JOptionPane.QUESTION_MESSAGE);

        if (nombre == null || nombre.trim().isEmpty()) {
            nombre = "Jugador Anónimo";
        }

   
        new Quiz(nombre);
    }
}
