import javax.swing.JOptionPane; // Importa diálogos emergentes gráficos. Si se elimina, no se podrá pedir el nombre mediante ventana.

public class Main { // Clase principal ejecutable del programa. Si se elimina, la aplicación no tendrá punto de arranque.

    public static void main(String[] args) { // Método estricto main requerido por Java. Si se elimina, el IDE no podrá ejecutar el sistema.
        String nombre = JOptionPane.showInputDialog(null, "Ingresa tu nombre:", "Inicio", JOptionPane.QUESTION_MESSAGE); // Pide el nombre en una ventana emergente. Si se elimina, no se solicitará nombre.
        javax.swing.SwingUtilities.invokeLater(() -> new Quiz(nombre != null && !nombre.trim().isEmpty() ? nombre : "Jugador Anónimo")); // Lanza la interfaz gráfica de forma segura en el hilo de Swing. Si se elimina, la ventana nunca se abrirá.
    }
}