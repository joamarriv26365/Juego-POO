import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
public class Quiz implements ActionListener {
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

    public Quiz(String nombreJugador) {
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

        JLabel seccion = crearEtiqueta("ANÁLISIS DE IMAGEN", 10, CELESTE, true);
        JLabel pregunta = crearEtiqueta("¿REAL O GENERADA POR IA?", 21, TEXTO, true);
        JLabel instruccion = crearEtiqueta(
                "Observa los detalles antes de elegir tu respuesta.",
                12, TEXTO_SECUNDARIO, false);

        seccion.setAlignmentX(Component.CENTER_ALIGNMENT);
        pregunta.setAlignmentX(Component.CENTER_ALIGNMENT);
        instruccion.setAlignmentX(Component.CENTER_ALIGNMENT);

        preguntaPanel.add(seccion);
        preguntaPanel.add(Box.createVerticalStrut(7));
        preguntaPanel.add(pregunta);
        preguntaPanel.add(Box.createVerticalStrut(5));
        preguntaPanel.add(instruccion);

        JPanel imagenContenedor = new JPanel(new GridBagLayout());
        imagenContenedor.setBackground(new Color(10, 16, 31));
        imagenContenedor.setBorder(BorderFactory.createLineBorder(
                new Color(57, 75, 111), 1));

        etiquetaImagen = crearEtiqueta("Cargando imagen...", 14, TEXTO_SECUNDARIO, false);
        etiquetaImagen.setHorizontalAlignment(SwingConstants.CENTER);
        imagenContenedor.add(etiquetaImagen);

        // Temporizador 
        JPanel estadoPanel = new JPanel(new BorderLayout());
        estadoPanel.setOpaque(false);

        etiquetaEstado = crearEtiqueta(
                "  Elige una opción para continuar", 12, TEXTO_SECUNDARIO, false);
        JPanel tiempoPanel = new JPanel(new BorderLayout(10, 5));
        tiempoPanel.setOpaque(false);

        JPanel tiempoTexto = new JPanel(new BorderLayout());
        tiempoTexto.setOpaque(false);
        tiempoTexto.add(crearEtiqueta("TIEMPO RESTANTE", 9, TEXTO_SECUNDARIO, true),
                BorderLayout.WEST);

        etiquetaTemporizador = crearEtiqueta("15 s", 20, CELESTE, true);
        etiquetaTemporizador.setHorizontalAlignment(SwingConstants.RIGHT);
        tiempoTexto.add(etiquetaTemporizador, BorderLayout.EAST);

        barraTiempo = new JProgressBar(0, 15);
        barraTiempo.setValue(15);
        barraTiempo.setPreferredSize(new Dimension(110, 6));
        barraTiempo.setBorderPainted(false);
        barraTiempo.setForeground(CELESTE);
        barraTiempo.setBackground(SUPERFICIE_CLARA);

        tiempoPanel.add(tiempoTexto, BorderLayout.NORTH);
        tiempoPanel.add(barraTiempo, BorderLayout.SOUTH);

        estadoPanel.add(etiquetaEstado, BorderLayout.WEST);
        estadoPanel.add(tiempoPanel, BorderLayout.EAST);

        tarjeta.add(preguntaPanel, BorderLayout.NORTH);
        tarjeta.add(imagenContenedor, BorderLayout.CENTER);
        tarjeta.add(estadoPanel, BorderLayout.SOUTH);

        // Botones para responder
        JPanel respuestas = new JPanel(new GridLayout(1, 2, 16, 0));
        respuestas.setOpaque(false);
        button1 = crearBoton("SÍ, ES IA", MORADO, TEXTO);
        button2 = crearBoton("NO, ES HUMANO", SUPERFICIE_CLARA, TEXTO);

        button1.addActionListener(this);
        button2.addActionListener(this);

        respuestas.add(button1);
        respuestas.add(button2);

        JPanel pie = new JPanel(new BorderLayout(0, 9));
        pie.setOpaque(false);

        JLabel nota = crearEtiqueta(
                "CONSEJO: analiza sombras, texturas, proporciones y pequeños detalles.",
                11, TEXTO_SECUNDARIO, false);
        nota.setHorizontalAlignment(SwingConstants.CENTER);

        pie.add(respuestas, BorderLayout.CENTER);
        pie.add(nota, BorderLayout.SOUTH);

        centro.add(progresoPanel, BorderLayout.NORTH);
        centro.add(tarjeta, BorderLayout.CENTER);
        centro.add(pie, BorderLayout.SOUTH);

        principal.add(encabezado, BorderLayout.NORTH);
        principal.add(centro, BorderLayout.CENTER);

        frame.setContentPane(principal);
    }

    private JButton crearBoton(String texto, Color fondo, Color colorTexto) {
        JButton boton = new JButton(texto);
        boton.setFont(new Font("SansSerif", Font.BOLD, 14));
        boton.setForeground(colorTexto);
        boton.setBackground(fondo);
        boton.setFocusPainted(false);
        boton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(fondo.brighter()),
                new EmptyBorder(15, 12, 15, 12)));
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton.setOpaque(true);
        return boton;
    }

    public void nextQuestion() {
        if (juego.estaFinalizado()) {
            results();
            return;
        }

        respuestaProcesada = false;
        Pregunta p = juego.obtenerPreguntaActual();

        etiquetaJugador.setText("JUGADOR  |  " + juego.getNombreJugador());
        etiquetaProgreso.setText("PROGRESO  " + (juego.getIndiceActual() + 1)
                + " / " + juego.getTotalPreguntas());

        barraProgreso.setMaximum(juego.getTotalPreguntas());
        barraProgreso.setValue(juego.getIndiceActual());

        etiquetaPuntaje.setText("PUNTAJE  " + juego.getPuntaje() + " pts");
        etiquetaEstado.setText("  Elige una opción para continuar");
        etiquetaEstado.setForeground(TEXTO_SECUNDARIO);
        cargarImagen(p);

        button1.setEnabled(true);
        button2.setEnabled(true);

        seconds = 15;
        actualizarTemporizador();
        timer.start();
    }


	private void cargarImagen(Pregunta pregunta) {
	
	    try {
	
	        URL url = getClass().getResource(pregunta.getRutaImagen());
	
	        if (url == null) {
	            throw new Exception("No se encontró la imagen.");
	        }
	
	        ImageIcon imagen = new ImageIcon(url);
	
	        int ancho = imagen.getIconWidth();
	        int alto = imagen.getIconHeight();
	
	        int anchoDisponible = etiquetaImagen.getParent().getWidth() - 30;
	        int altoDisponible = etiquetaImagen.getParent().getHeight() - 30;
	
	        double escala = Math.min(
	                (double) anchoDisponible / ancho,
	                (double) altoDisponible / alto
	        );
	
	        escala = Math.min(escala, 1.0);
	
	        Image ajustada = imagen.getImage().getScaledInstance(
	                (int) (ancho * escala),
	                (int) (alto * escala),
	                Image.SCALE_SMOOTH
	        );
	
	        etiquetaImagen.setIcon(new ImageIcon(ajustada));
	        etiquetaImagen.setText("");
	
	    } catch (Exception ex) {
	
	        etiquetaImagen.setIcon(null);
	        etiquetaImagen.setText("Imagen no disponible");
	
	        System.out.println(ex.getMessage());
	    }
	}


    private void actualizarTemporizador() {
        etiquetaTemporizador.setText(seconds + " s");
        barraTiempo.setValue(seconds);

        Color color = seconds <= 5 ? ROJO : CELESTE;
        etiquetaTemporizador.setForeground(color);
        barraTiempo.setForeground(color);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (respuestaProcesada) {
            return;
        }

        timer.stop();
        button1.setEnabled(false);
        button2.setEnabled(false);

        char eleccion = (e.getSource() == button1) ? '1' : '2';
        procesarRespuestaGUI(eleccion);
    }

    private void procesarRespuestaGUI(char eleccion) {
        if (respuestaProcesada) {
            return;
        }
		respuestaProcesada = true;
        button1.setEnabled(false);
        button2.setEnabled(false);

        boolean esCorrecta = false;

        if (eleccion == '1' || eleccion == '2') {
            esCorrecta = juego.evaluarRespuesta(eleccion == '1');
        }

        Pregunta actual = juego.obtenerPreguntaActual();

        String mensaje;
        String titulo;

        if (eleccion == ' ') {
            mensaje = "Se terminó el tiempo. No sumaste puntos.";
            titulo = "Tiempo agotado";
            etiquetaEstado.setText("  TIEMPO AGOTADO");
            etiquetaEstado.setForeground(AMARILLO);

        } else if (esCorrecta) {
            mensaje = "¡Correcto! Has ganado 10 puntos.";
            titulo = "Respuesta correcta";
            etiquetaEstado.setText("  ¡RESPUESTA CORRECTA!  +10 PUNTOS");
            etiquetaEstado.setForeground(VERDE);

        } else {
            mensaje = "Respuesta incorrecta. No has sumado puntos.";
            titulo = "Respuesta incorrecta";
            etiquetaEstado.setText("  RESPUESTA INCORRECTA");
            etiquetaEstado.setForeground(ROJO);
        }

        Object[] opciones = {"Ver explicación", "Siguiente pregunta"};

        int opcion = JOptionPane.showOptionDialog(frame,
                mensaje + "\n\n¿Qué deseas hacer?",
                titulo,
                JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null, opciones, opciones[1]);

        if (opcion == 0 && actual != null) {
            JOptionPane.showMessageDialog(frame,
                    actual.getRetroalimentacion(),
                    "Análisis de la imagen",
                    JOptionPane.INFORMATION_MESSAGE);
        }

        etiquetaPuntaje.setText("PUNTAJE  " + juego.getPuntaje() + " pts");

        juego.avanzarSiguientePregunta();

        if (juego.getIndiceActual() < juego.getTotalPreguntas()) {
            nextQuestion();
        } else {
            results();
        }
    }

    public void results() {
        if (timer != null) {
            timer.stop();
        }

        principal.removeAll();
        principal.setLayout(new GridBagLayout());

        int puntajeFinal = juego.getPuntaje();
        int totalMaximo = juego.getTotalPreguntas() * 10;
        int porcentaje = totalMaximo == 0 ? 0
                : (int) ((double) puntajeFinal / totalMaximo * 100);

        JPanel tarjeta = new JPanel();
        tarjeta.setBackground(SUPERFICIE);
        tarjeta.setBorder(new EmptyBorder(38, 48, 38, 48));
        tarjeta.setLayout(new BoxLayout(tarjeta, BoxLayout.Y_AXIS));

        JLabel insignia = crearEtiqueta("MISIÓN COMPLETADA", 11, CELESTE, true);
        JLabel titulo = crearEtiqueta(
                "¡Buen trabajo, " + juego.getNombreJugador() + "!", 25, TEXTO, true);
        JLabel descripcion = crearEtiqueta(
                "Has terminado el desafío de identificación visual.",
                12, TEXTO_SECUNDARIO, false);
        JLabel puntaje = crearEtiqueta(
                puntajeFinal + " / " + totalMaximo, 48, AMARILLO, true);
        JLabel puntosTexto = crearEtiqueta(
                "PUNTOS OBTENIDOS", 10, TEXTO_SECUNDARIO, true);
        JLabel mensaje = crearEtiqueta(
                obtenerMensajeFinal(porcentaje), 13, TEXTO, false);

        JLabel[] etiquetas = {
            insignia, titulo, descripcion, puntaje, puntosTexto, mensaje
        };

        for (JLabel etiqueta : etiquetas) {
            etiqueta.setAlignmentX(Component.CENTER_ALIGNMENT);
        }
		JProgressBar resultadoBarra = new JProgressBar(0, 100);
        resultadoBarra.setValue(porcentaje);
        resultadoBarra.setString(porcentaje + "% de efectividad");
        resultadoBarra.setStringPainted(true);
        resultadoBarra.setForeground(VERDE);
        resultadoBarra.setBackground(SUPERFICIE_CLARA);
        resultadoBarra.setBorderPainted(false);
        resultadoBarra.setMaximumSize(new Dimension(360, 22));
        resultadoBarra.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton salir = crearBoton("CERRAR JUEGO", MORADO, TEXTO);
        salir.setAlignmentX(Component.CENTER_ALIGNMENT);
        salir.addActionListener(e -> frame.dispose());

        tarjeta.add(insignia);
        tarjeta.add(Box.createVerticalStrut(16));
        tarjeta.add(titulo);
        tarjeta.add(Box.createVerticalStrut(8));
        tarjeta.add(descripcion);
        tarjeta.add(Box.createVerticalStrut(30));
        tarjeta.add(puntaje);
        tarjeta.add(Box.createVerticalStrut(2));
        tarjeta.add(puntosTexto);
        tarjeta.add(Box.createVerticalStrut(20));
        tarjeta.add(resultadoBarra);
        tarjeta.add(Box.createVerticalStrut(20));
        tarjeta.add(mensaje);
        tarjeta.add(Box.createVerticalStrut(30));
        tarjeta.add(salir);

        principal.add(tarjeta);
        principal.revalidate();
        principal.repaint();
    }

    private String obtenerMensajeFinal(int porcentaje) {
        if (porcentaje >= 90) {
            return "¡Excelente observación! Tienes un gran ojo para los detalles.";
        } else if (porcentaje >= 70) {
            return "¡Muy buen resultado! Sigue afinando tu capacidad de análisis.";
        } else if (porcentaje >= 50) {
            return "Buen intento. Practicar te ayudará a reconocer más señales.";
        }

        return "¡Sigue practicando! Distinguir imágenes de IA puede ser un reto.";
    }

}
