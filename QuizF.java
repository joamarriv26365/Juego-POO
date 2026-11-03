import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
public class QuizF implements ActionListener {
    private Juego juego;
    private InfoJuego info = new InfoJuego();
    private JFrame frame;
    private JPanel principal;
    private JLabel etiquetaJugador, etiquetaTemporizador, etiquetaImagen;
    private JLabel etiquetaEstado, etiquetaPuntaje, etiquetaProgreso;
    private JProgressBar barraProgreso, barraTiempo;
    private JButton button1, button2;
    private int seconds = 15;
    private boolean respuestaProcesada = false;
    private Timer timer;
    private final Color FONDO = new Color(13, 20, 38);
    private final Color SUPERFICIE = new Color(24, 34, 58);
    private final Color SUPERFICIE_CLARA = new Color(34, 47, 76);
    private final Color MORADO = new Color(139, 125, 255);
    private final Color CELESTE = new Color(65, 205, 232);
    private final Color TEXTO = new Color(245, 247, 255);
    private final Color TEXTO_SECUNDARIO = new Color(177, 190, 215);
    private final Color VERDE = new Color(77, 205, 151);
    private final Color AMARILLO = new Color(255, 193, 92);
    private final Color ROJO = new Color(255, 112, 112);
}
