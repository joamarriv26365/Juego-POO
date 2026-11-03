import javax.swing.*; // esta biblioteca nos permite importar los componentes de Swing utilizados para construir la interfaz: JPanel, JLabel, JTextField, JOptionPane y SwingUtilities.
import java.awt.*; // biblioteca para poder importar herramientas gráficas como Color, Font y GridLayout.

public class MainF {

  
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {//Crea un panel que agrupa los elementos de bienvenida.  
            //JPanel funciona como un contenedor: permite presentar
            // varios componentes juntos dentro del cuadro de diálogo. A diferencia de un Actionlistener, este programa un tare apara ejecutarla 
            

            JPanel panel = new JPanel(); // Determinante del color del panel principal
            panel.setBackground(new Color(13, 20, 38));//
            panel.setLayout(new GridLayout(3, 1, 5, 10));// 

            JLabel titulo = new JLabel("¡BIENVENIDO A AI DETECTOR!");// Titulo, su tipo de letra, tamaño y color 
            titulo.setFont(new Font("SansSerif", Font.BOLD, 18));
            titulo.setForeground(new Color(139, 125, 255));

            JLabel instruccion = new JLabel("Ingresa tu nombre para comenzar:"); // panel que pide informacion del jugador
            instruccion.setForeground(Color.WHITE);

            JTextField campoNombre = new JTextField(15);// Espacio donde el jugador pueda ingresar su nombre
            campoNombre.setFont(new Font("SansSerif", Font.PLAIN, 14));

            panel.add(titulo); // en estas tres lineas, se agragan los componentes que muestras el titulo, intrucciones y el nombre. 
            panel.add(instruccion);//
            panel.add(campoNombre);// 

            int opcion = JOptionPane.showConfirmDialog( 
            null,
                    panel,
                    "AI Detector | Inicio",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE
            ); /*Muestra un cuadro de diálogo de confirmación.
             * null:
             * No se proporciona una ventana padre explícita;
             * el diálogo se coloca normalmente en el centro de la pantalla.
            
             * panel:
             * Es el contenido que aparecerá dentro del diálogo.
            
             * "AI Detector | Inicio":
             * Es el título de la ventana.
            
             * JOptionPane.OK_CANCEL_OPTION:
             * Solicita los botones de aceptar y cancelar.
             
             * JOptionPane.PLAIN_MESSAGE:
             * Evita mostrar un icono de mensaje predeterminado.
             
             * El método espera hasta que el usuario acepte, cancele
             * o cierre la ventana. Su elección se guarda en "opcion".
             *//
                    

            if (opcion == JOptionPane.OK_OPTION) {

                String nombre = campoNombre.getText().trim();
                /*
             * Continúa únicamente si el usuario presionó aceptar.
             *
             * Se utiliza la constante OK_OPTION para expresar
             * claramente qué respuesta se está comprobando.
             *
             * Si cancela o cierra la ventana, no se crea el Quiz.
             */

                if (nombre.isEmpty()) {
                    nombre = "Jugador Anónimo";
                }
                /* Crea un objeto de la clase Quiz y entrega el nombre "Jugador Anonimo"
                 * a su constructor.
                 
                 * Para que compile, debe existir una clase Quiz
                 * accesible con un constructor compatible, por ejemplo:
                    public Quiz(String nombre) { ... }
                
                 * Si ese constructor configura y muestra la ventana
                 * del cuestionario, el cuestionario aparecerá aquí.
                 */

                new Quiz(nombre);
            }
        });
    }
}
