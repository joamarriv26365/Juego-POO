import javax.swing.JOptionPane; // Importa diálogos emergentes gráficos. Si se elimina, no se podrá pedir el nombre mediante ventana.
import java.util.Scanner; //lee entrada de datos del usuario

public class Main { // Clase principal ejecutable del programa. Si se elimina, la aplicación no tendrá punto de arranque.

    public static void main(String[] args) { // Método estricto main requerido por Java. Si se elimina, el IDE no podrá ejecutar el sistema.
        Scanner scanner = new Scanner(System.in);
        String nombre = JOptionPane.showInputDialog(null, "Ingresa tu nombre:", "Inicio", JOptionPane.QUESTION_MESSAGE); // Pide el nombre en una ventana emergente. Si se elimina, no se solicitará nombre.
        javax.swing.SwingUtilities.invokeLater(() -> new Quiz(nombre != null && !nombre.trim().isEmpty() ? nombre : "Jugador Anónimo")); // Lanza la interfaz gráfica de forma segura en el hilo de Swing. Si se elimina, la ventana nunca se abrirá.
        String rutaArchivo = "preguntas.csv"; //Define la variable de tipo String que almacena el nombre o la ruta del archivo CSV desde el cual se van a cargar las preguntas del juego.
        Juego partida = new Juego(rutaArchivo);

        if (partida.getCantidadPreguntas() == 0) {
            System.out.println("Error: No se pudieron cargar preguntas desde " + rutaArchivo);
            return;
        }
        Juego partida = new Juego(rutaArchivo);

        if (partida.getCantidadPreguntas() == 0) {
            System.out.println("Error: No se pudieron cargar preguntas desde " + rutaArchivo);
            return;
        }
        
        System.out.println("=========================================");
        System.out.println("   BIENVENIDO AL JUEGO DE ANÁLISIS IA   ");
        System.out.println("=========================================");

         boolean jugando = true;
    
    
    }
}
