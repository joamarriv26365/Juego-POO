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

    public QuizF(String nombreJugador) {
        juego = new Juego(nombreJugador);

        frame = new JFrame("AI Detector | Desafío visual");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 790);
        frame.setMinimumSize(new Dimension(760, 700));
        frame.setLocationRelativeTo(null);

        construirInterfaz();

        timer = new Timer(1000, e -> {
            seconds--;
            actualizarTemporizador();

            if (seconds <= 0) {
                timer.stop();
                procesarRespuestaGUI(' ');
            }
        });

        frame.setVisible(true);

        JOptionPane.showMessageDialog(frame,
                info.getAcercaDelProyecto(),
                "Acerca del proyecto",
                JOptionPane.INFORMATION_MESSAGE);

        nextQuestion();
    }

    private JLabel crearEtiqueta(String texto, int tamano, Color color, boolean negrita) {
        JLabel etiqueta = new JLabel(texto);
        etiqueta.setFont(new Font("SansSerif",
                negrita ? Font.BOLD : Font.PLAIN, tamano));
        etiqueta.setForeground(color);
        return etiqueta;
    }

    private void construirInterfaz() {
        principal = new JPanel(new BorderLayout(0, 18));
        principal.setBackground(FONDO);
        principal.setBorder(new EmptyBorder(24, 34, 26, 34));

        // Encabezado
        JPanel encabezado = new JPanel(new BorderLayout());
        encabezado.setOpaque(false);

        JPanel marca = new JPanel();
        marca.setOpaque(false);
        marca.setLayout(new BoxLayout(marca, BoxLayout.Y_AXIS));

        marca.add(crearEtiqueta("AI DETECTOR", 25, TEXTO, true));
        marca.add(Box.createVerticalStrut(4));
        marca.add(crearEtiqueta("DESAFÍO DE IDENTIFICACIÓN VISUAL", 10, CELESTE, true));

        JPanel datos = new JPanel();
        datos.setOpaque(false);
        datos.setLayout(new BoxLayout(datos, BoxLayout.Y_AXIS));

        etiquetaJugador = crearEtiqueta("", 13, TEXTO, true);
        etiquetaPuntaje = crearEtiqueta("PUNTAJE  0 pts", 11, AMARILLO, true);
        etiquetaPuntaje.setAlignmentX(Component.RIGHT_ALIGNMENT);

        datos.add(etiquetaJugador);
        datos.add(Box.createVerticalStrut(7));
        datos.add(etiquetaPuntaje);

        encabezado.add(marca, BorderLayout.WEST);
        encabezado.add(datos, BorderLayout.EAST);

        // Área central
        JPanel centro = new JPanel(new BorderLayout(0, 14));
        centro.setOpaque(false);

        JPanel progresoPanel = new JPanel(new BorderLayout(0, 8));
        progresoPanel.setOpaque(false);

        etiquetaProgreso = crearEtiqueta("", 12, TEXTO_SECUNDARIO, true);

        barraProgreso = new JProgressBar(0, 10);
        barraProgreso.setPreferredSize(new Dimension(100, 7));
        barraProgreso.setBorderPainted(false);
        barraProgreso.setForeground(CELESTE);
        barraProgreso.setBackground(SUPERFICIE_CLARA);

        progresoPanel.add(etiquetaProgreso, BorderLayout.WEST);
        progresoPanel.add(barraProgreso, BorderLayout.SOUTH);

        // Tarjeta de pregunta
        JPanel tarjeta = new JPanel(new BorderLayout(0, 14));
        tarjeta.setBackground(SUPERFICIE);
        tarjeta.setBorder(new EmptyBorder(22, 24, 22, 24));

        JPanel preguntaPanel = new JPanel();
        preguntaPanel.setOpaque(false);
        preguntaPanel.setLayout(new BoxLayout(preguntaPanel, BoxLayout.Y_AXIS));
}
