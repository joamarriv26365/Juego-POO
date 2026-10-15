import java.awt.event.*; // permite la interaccion del usuario con la pagina
import java.awt.*; // permite el diseño de interfaz grafica
import javax.swing.*; // biblioteca de interfaz principal

public class Quiz implements ActionListener {

    private Juego juego;
    private InfoJuego info = new InfoJuego();
    // toda la parte grafica del proyecto se encuentra aca
    private JFrame frame = new JFrame();//
    private JTextField textfield = new JTextField();// Titulos
    private JTextArea textarea = new JTextArea();// texto con instrucciones etc
    private JLabel etiquetaImagen = new JLabel();
    private JButton button1 = new JButton(); // botones de respuesta
    private JButton button2 = new JButton(); // botones de respuesta
    private JLabel answer_label1 = new JLabel(); // texto del boton 1 de respuesta
    private JLabel answer_label2 = new JLabel(); // texto del boton 2 de respuesta
    private JLabel time_label = new JLabel(); // timer
    private JLabel seconds_left = new JLabel(); // numeros que aparecen en cuenta regresiva
    private JTextField number_right = new JTextField(); //puntaje final ubicado al lado derecho de la pantalla
    private JTextField percentage = new JTextField(); // porcentaje de aciertos en la partida

    int seconds = 15; // numero de segundos para responder cada pregunta

    Timer timer = new Timer(1000, new ActionListener() {

        public void actionPerformed(ActionEvent e) {
            seconds--;
            seconds_left.setText(String.valueOf(seconds));// cuenta regresiva
            if (seconds <= 0) {
                procesarRespuestaGUI(' ');
            }
        }
    });

    public Quiz(String nombreJugador) { // metodo con cosntructor
        juego = new Juego(nombreJugador);// crea nuevo objeto con el nombre del jugador

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// cierra el programa cuando se cierra el juego
        frame.setSize(750, 850); // tamaño visual de la pagina
        frame.getContentPane().setBackground(new Color(50, 50, 50));// Caracteristicas de estilo
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        textfield.setBounds(0, 0, 750, 50);
        textfield.setBackground(new Color(25, 25, 25));
        textfield.setForeground(new Color(25, 255, 0));
        textfield.setFont(new Font("Century Gothic", Font.PLAIN, 22)); // tipo de letra de titulos proyectada en la pagina
        textfield.setBorder(BorderFactory.createBevelBorder(1));
        textfield.setHorizontalAlignment(JTextField.CENTER);
        textfield.setEditable(false);
        // forma visual del texto dentro de la pagina
        textarea.setBounds(25, 60, 685, 110);
        textarea.setBackground(new Color(25, 25, 25));
        textarea.setForeground(new Color(25, 255, 0));
        textarea.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        textarea.setLineWrap(true);
        textarea.setWrapStyleWord(true);
        textarea.setEditable(false);
        // forma en que se proyectan las imagenes
        etiquetaImagen.setBounds(150, 180, 430, 260);
        etiquetaImagen.setBorder(BorderFactory.createBevelBorder(1));
        etiquetaImagen.setHorizontalAlignment(JLabel.CENTER);
        // caracteristicas visuales del boton de respuesta 1
        button1.setBounds(25, 460, 80, 50);
        button1.setFont(new Font("Century Gothic", Font.PLAIN, 25));
        button1.setFocusable(false);
        button1.addActionListener(this);
        button1.setText("1");
        // caracteristicas visuales del boton de respuesta 2
        button2.setBounds(25, 530, 80, 50);
        button2.setFont(new Font("Century Gothic", Font.PLAIN, 25));
        button2.setFocusable(false);
        button2.addActionListener(this);
        button2.setText("2");
        // caracterisiticas visuales del texto dentro del boton 1
        answer_label1.setBounds(120, 460, 560, 50);
        answer_label1.setBackground(new Color(50, 50, 50));
        answer_label1.setForeground(new Color(25, 255, 0));
        answer_label1.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        // caracterisiticas visuales del texto dentro del boton 1
        answer_label2.setBounds(120, 530, 560, 50);
        answer_label2.setBackground(new Color(50, 50, 50));
        answer_label2.setForeground(new Color(25, 255, 0));
        answer_label2.setFont(new Font("Century Gothic", Font.PLAIN, 18));
        // caracterisiticas visuales de la caja del contador
        seconds_left.setBounds(585, 630, 100, 100);
        seconds_left.setBackground(new Color(25, 25, 25));
        seconds_left.setForeground(new Color(255, 0, 0));
        seconds_left.setFont(new Font("Century Gothic", Font.PLAIN, 50));
        seconds_left.setBorder(BorderFactory.createBevelBorder(1));
        seconds_left.setOpaque(true);
        seconds_left.setHorizontalAlignment(JTextField.CENTER);
        seconds_left.setText(String.valueOf(seconds));
        // caracteristicas visuales de los numeros contenidos en la caja del contador
        time_label.setBounds(585, 600, 100, 25);
        time_label.setBackground(new Color(50, 50, 50));
        time_label.setForeground(new Color(255, 0, 0));
        time_label.setFont(new Font("Century Gothic", Font.PLAIN, 14));
        time_label.setHorizontalAlignment(JTextField.CENTER);
        time_label.setText("timer");
        // caracteristicas visuales de el puntaje final
        number_right.setBounds(175, 220, 630, 80);
        number_right.setBackground(new Color(25, 25, 25));
        number_right.setForeground(new Color(25, 255, 0));
        number_right.setFont(new Font("Century Gothic", Font.PLAIN, 28));
        number_right.setBorder(BorderFactory.createBevelBorder(1));
        number_right.setHorizontalAlignment(JTextField.CENTER);
        number_right.setEditable(false);
        // caractersiticas visuales del porcentaje poryecto al final de la pagina
        percentage.setBounds(50, 330, 630, 80);
        percentage.setBackground(new Color(25, 25, 25));
        percentage.setForeground(new Color(25, 255, 0));
        percentage.setFont(new Font("Century Gothic", Font.PLAIN, 35));
        percentage.setBorder(BorderFactory.createBevelBorder(1));
        percentage.setHorizontalAlignment(JTextField.CENTER);
        percentage.setEditable(false);

        frame.add(time_label); // constructores
        frame.add(seconds_left);
        frame.add(etiquetaImagen);
        frame.add(answer_label1);
        frame.add(answer_label2);
        frame.add(button1);
        frame.add(button2);
        frame.add(textarea);
        frame.add(textfield);

        frame.setVisible(true); // da visibilidad a todo el proyecto

        JOptionPane.showMessageDialog( // pagina emergente la cual informa sobre el poryecto
                frame,
                info.getAcercaDelProyecto(),
                "Acerca del Proyecto",
                JOptionPane.INFORMATION_MESSAGE
        );

        nextQuestion();
    }

    public void nextQuestion() {
        // CORRECCIÓN 1: Valida al inicio si ya terminó antes de intentar cargar elementos
        if (juego.estaFinalizado()) {
            results();
            return;
        }

        Pregunta p = juego.obtenerPreguntaActual();

        textfield.setText("Jugador: " + juego.getNombreJugador() + " | Pregunta " + (juego.getIndiceActual() + 1) + " de " + juego.getTotalPreguntas());
        textarea.setText(info.getInstruccionesPregunta());
        answer_label1.setText("1. Sí, fue generado por IA");
        answer_label2.setText("2. No, es una obra Humana");
        // este parte se encarga de cargar y mostrar cada imagen en cada pregunta, asi mismo, en caso no se pueda presentar y/o procesar un archivo esta parte hará que no se rompa el programa.
        try { // como dice su nombre, trata de ejecutar las isntrucciones sobre la carga de la imagen
            java.net.URL imgUrl = getClass().getResource(p.getRutaImagen()); // consulta la ruta del archivo y lo busca dentro de los recursos
            ImageIcon iconoOriginal = new ImageIcon(imgUrl); // toma la ruta encontrada y crea el objeto para que se reconozca como grafico
            Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(430, 280, Image.SCALE_SMOOTH); // redimeciona la imagen original
            etiquetaImagen.setIcon(new ImageIcon(imagenEscalada)); // la imagen redimensionada la envuelve en forma de icono para luego asignar como componente visual
            etiquetaImagen.setText(""); // limpia texto colado en la etiqueta de la imagen
        } catch (Exception ex) { // en caso haya un fallo esta linea se encargará de no matar el programa
            etiquetaImagen.setIcon(null);
            etiquetaImagen.setText("[ Imagen no disponible ]"); // muestra al usuario
            etiquetaImagen.setForeground(Color.LIGHT_GRAY);
        }

        timer.start();
    }


    public void actionPerformed(ActionEvent e) { // actividad cuando se presiona un boton
        timer.stop();
        button1.setEnabled(false);
        button2.setEnabled(false);

        char eleccion = ' ';
        if (e.getSource() == button1) {
            eleccion = '1';
        } else if (e.getSource() == button2) {
            eleccion = '2';
        }

        procesarRespuestaGUI(eleccion);
    }

    private void procesarRespuestaGUI(char eleccion) { // guardar la informacion obtenida durante la pregunta
        boolean respuestaUsuario = (eleccion == '1');
        boolean esCorrecta = false;

        if (eleccion == '1' || eleccion == '2') {
            esCorrecta = juego.evaluarRespuesta(respuestaUsuario);
        }

        Pregunta pActual = juego.obtenerPreguntaActual();

        int opcionElegida = JOptionPane.showOptionDialog(
                frame,
                (eleccion == ' ' ? "¡TIEMPO AGOTADO!\n" : (esCorrecta ? "¡CORRECTO! Has ganado 10 puntos.\n" : "INCORRECTO. No ganas nada.\n")) + "¿Qué deseas hacer ahora?",
                "Pregunta " + (juego.getIndiceActual() + 1) + " Hecha",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new Object[]{"Ver Explicación", "Siguiente Pregunta"},
                "Siguiente Pregunta"
        ); // Toda esta parte muestra la reaccion textual del programa ante la accion tomada o no tomada

        if (opcionElegida == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(
                    frame,
                    pActual.getRetroalimentacion(),
                    "Retroalimentación",
                    JOptionPane.INFORMATION_MESSAGE
            ); // esta parte muestra la reaccion textual del programa en caso se precione la opcion de retroalimetacion luego de una respuesta
        }

        // para la siguiente pregunta reinicia el timer y los botones
        seconds = 15;
        seconds_left.setText(String.valueOf(seconds));
        button1.setEnabled(true);
        button2.setEnabled(true);

        juego.avanzarSiguientePregunta();// permite avanzar o terminar con la partida en caso esta haya recorrido todas la spreguntas

        if (juego.estaFinalizado()) {
            results();
        } else {
            nextQuestion();
        }
    }

    public void results() { // metodo que muestra toda la parte de resultados obtenidos por el usuario
        button1.setVisible(false);
        button2.setVisible(false);
        answer_label1.setVisible(false);
        answer_label2.setVisible(false);
        etiquetaImagen.setVisible(false);
        seconds_left.setVisible(false);
        time_label.setVisible(false);

        int puntajeFinal = juego.getPuntaje();
        int totalMaximo = juego.getTotalPreguntas() * 10;
        int porcentaje = (int) ((double) puntajeFinal / totalMaximo * 100);

        textfield.setText("FIN DE LA PARTIDA, " + juego.getNombreJugador().toUpperCase() + ".");
        textarea.setText("RESULTADOS:");

        number_right.setText("Puntaje: " + puntajeFinal + " / " + totalMaximo + " pts");
        percentage.setText("Porcentaje de éxito: " + porcentaje + "%");

        frame.add(number_right);
        frame.add(percentage);
        frame.repaint();
    }
}