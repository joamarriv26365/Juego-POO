import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Quiz implements ActionListener {

    private Juego juego;
    private InfoJuego info = new InfoJuego();

    JFrame frame = new JFrame();
    JTextField textfield = new JTextField();
    JTextArea textarea = new JTextArea();
    JLabel etiquetaImagen = new JLabel();
    JButton button1 = new JButton();
    JButton button2 = new JButton();
    JLabel answer_label1 = new JLabel();
    JLabel answer_label2 = new JLabel();
    JLabel time_label = new JLabel();
    JLabel seconds_left = new JLabel();
    JTextField number_right = new JTextField();
    JTextField percentage = new JTextField();

    int seconds = 15;

    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            seconds--;
            seconds_left.setText(String.valueOf(seconds));
            if (seconds <= 0) {
                procesarRespuestaGUI(' '); // Tiempo agotado
            }
        }
    });

    public Quiz(String nombreJugador) {
        juego = new Juego(nombreJugador);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750, 850);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        textfield.setBounds(0, 0, 750, 50);
        textfield.setBackground(new Color(25, 25, 25));
        textfield.setForeground(new Color(25, 255, 0));
        textfield.setFont(new Font("Century Gothic", Font.PLAIN, 22));
        textfield.setBorder(BorderFactory.createBevelBorder(1));
        textfield.setHorizontalAlignment(JTextField.CENTER);
        textfield.setEditable(false);


        textarea.setBounds(25, 60, 685, 110);
        textarea.setBackground(new Color(25, 25, 25));
        textarea.setForeground(new Color(25, 255, 0));
        textarea.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        textarea.setLineWrap(true);
        textarea.setWrapStyleWord(true);
        textarea.setEditable(false);


        etiquetaImagen.setBounds(150, 180, 430, 260);
        etiquetaImagen.setBorder(BorderFactory.createBevelBorder(1));
        etiquetaImagen.setHorizontalAlignment(JLabel.CENTER);


        button1.setBounds(25, 460, 80, 50);
        button1.setFont(new Font("Century Gothic", Font.PLAIN, 25));
        button1.setFocusable(false);
        button1.addActionListener(this);
        button1.setText("1");

        button2.setBounds(25, 530, 80, 50);
        button2.setFont(new Font("Century Gothic", Font.PLAIN, 25));
        button2.setFocusable(false);
        button2.addActionListener(this);
        button2.setText("2");

        answer_label1.setBounds(120, 460, 560, 50);
        answer_label1.setBackground(new Color(50, 50, 50));
        answer_label1.setForeground(new Color(25, 255, 0));
        answer_label1.setFont(new Font("Century Gothic", Font.PLAIN, 18));

        answer_label2.setBounds(120, 530, 560, 50);
        answer_label2.setBackground(new Color(50, 50, 50));
        answer_label2.setForeground(new Color(25, 255, 0));
        answer_label2.setFont(new Font("Century Gothic", Font.PLAIN, 18));

        seconds_left.setBounds(585, 630, 100, 100);
        seconds_left.setBackground(new Color(25, 25, 25));
        seconds_left.setForeground(new Color(255, 0, 0));
        seconds_left.setFont(new Font("Century Gothic", Font.PLAIN, 50));
        seconds_left.setBorder(BorderFactory.createBevelBorder(1));
        seconds_left.setOpaque(true);
        seconds_left.setHorizontalAlignment(JTextField.CENTER);
        seconds_left.setText(String.valueOf(seconds));

        time_label.setBounds(585, 600, 100, 25);
        time_label.setBackground(new Color(50, 50, 50));
        time_label.setForeground(new Color(255, 0, 0));
        time_label.setFont(new Font("Century Gothic", Font.PLAIN, 14));
        time_label.setHorizontalAlignment(JTextField.CENTER);
        time_label.setText("timer");

        number_right.setBounds(175, 220, 380, 80);
        number_right.setBackground(new Color(25, 25, 25));
        number_right.setForeground(new Color(25, 255, 0));
        number_right.setFont(new Font("Century Gothic", Font.PLAIN, 35));
        number_right.setBorder(BorderFactory.createBevelBorder(1));
        number_right.setHorizontalAlignment(JTextField.CENTER);
        number_right.setEditable(false);

        percentage.setBounds(175, 330, 380, 80);
        percentage.setBackground(new Color(25, 25, 25));
        percentage.setForeground(new Color(25, 255, 0));
        percentage.setFont(new Font("Century Gothic", Font.PLAIN, 35));
        percentage.setBorder(BorderFactory.createBevelBorder(1));
        percentage.setHorizontalAlignment(JTextField.CENTER);
        percentage.setEditable(false);

        frame.add(time_label);
        frame.add(seconds_left);
        frame.add(etiquetaImagen);
        frame.add(answer_label1);
        frame.add(answer_label2);
        frame.add(button1);
        frame.add(button2);
        frame.add(textarea);
        frame.add(textfield);

        frame.setVisible(true);

        JOptionPane.showMessageDialog(
                frame,
                info.getAcercaDelProyecto(),
                "Acerca del Proyecto",
                JOptionPane.INFORMATION_MESSAGE
        );

        nextQuestion();
    }

    public void nextQuestion() {
        if (juego.estaFinalizado()) {
            results();
        } else {
            Pregunta p = juego.obtenerPreguntaActual();

            textfield.setText("Jugador: " + juego.getNombreJugador() + " | Pregunta " + (juego.getIndiceActual() + 1) + " de " + juego.getTotalPreguntas());
            textarea.setText(info.getInstruccionesPregunta());
            answer_label1.setText("1. Sí, fue generado por IA");
            answer_label2.setText("2. No, es una obra Humana");

            try {
                java.net.URL imgUrl = getClass().getResource(p.getRutaImagen());
                ImageIcon iconoOriginal = new ImageIcon(imgUrl);
                Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(430, 280, Image.SCALE_SMOOTH);
                etiquetaImagen.setIcon(new ImageIcon(imagenEscalada));
                etiquetaImagen.setText("");
            } catch (Exception ex) {
                etiquetaImagen.setIcon(null);
                etiquetaImagen.setText("[ Imagen no disponible ]");
                etiquetaImagen.setForeground(Color.LIGHT_GRAY);
            }

            timer.start();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
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

    private void procesarRespuestaGUI(char eleccion) {
        boolean respuestaUsuario = (eleccion == '1');
        boolean esCorrecta = false;

        if (eleccion == '1' || eleccion == '2') {
            esCorrecta = juego.evaluarRespuesta(respuestaUsuario);
        }

        Pregunta pActual = juego.obtenerPreguntaActual();

        int opcionElegida = JOptionPane.showOptionDialog(
                frame,
                (eleccion == ' ' ? "¡TIEMPO AGOTADO!\n" : (esCorrecta ? "¡CORRECTO! Has ganado 10 puntos.\n" : "INCORRECTO. No ganas nada.\n")) + "¿Qué deseas hacer ahora?",
                "Pregunta " + (juego.getIndiceActual() + 1) + "Hecha",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new Object[]{"Ver Explicación", "Siguiente Pregunta"},
                "Siguiente Pregunta"
        );

        if (opcionElegida == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(
                    frame,
                    pActual.getRetroalimentacion(),
                    "Retroalimentación",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }

        seconds = 15;
        seconds_left.setText(String.valueOf(seconds));
        button1.setEnabled(true);
        button2.setEnabled(true);

        juego.avanzarSiguientePregunta();

        if (!juego.estaFinalizado()) {
            nextQuestion();
        } else {
            results();
        }
    }

    public void results() {
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

        textfield.setText("FIN DE LA PARTIDA, " + juego.getNombreJugador().toUpperCase() +".");
        textarea.setText("RESULTADOS:");

        number_right.setText("Puntaje: " + puntajeFinal + " / " + totalMaximo + " pts");
        percentage.setText("Porcentaje de éxito: " + porcentaje + "%");

        frame.add(number_right);
        frame.add(percentage);
        frame.repaint();
    }
}