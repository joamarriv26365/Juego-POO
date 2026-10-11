import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Quiz implements ActionListener {

    // 10 preguntas sobre el tema con la estructura del video
    String[] questions = {
            "1. ¿Esta pintura fue realizada por un artista o por Midjourney?",
            "2. ¿Este retrato fotorrealista fue generado por una IA?",
            "3. ¿Esta ilustración digital es una obra de un diseñador humano?",
            "4. ¿Este paisaje abstracto pertenece a una Inteligencia Artificial?",
            "5. ¿Esta fotografía urbana nocturna fue tomada por una cámara real?",
            "6. ¿Este diseño de videojuego 3D fue renderizado por IA?",
            "7. ¿Este boceto en lápiz fue dibujado por un estudiante humano?",
            "8. ¿Esta composición fotográfica fue generada mediante DALL-E?",
            "9. ¿Este cartel publicitario minimalista fue hecho por un humano?",
            "10. ¿Esta imagen con estilo renacentista fue creada por una IA?"
    };

    // Opciones A y B para cada una de las 10 preguntas
    String[][] options = {
            {"Artista Humano", "Midjourney"},
            {"Sí, es de IA", "No, es real"},
            {"Diseñador Humano", "Generado por IA"},
            {"Inteligencia Artificial", "Pintura al óleo"},
            {"Cámara real", "Generada por IA"},
            {"Renderizado por IA", "Modelado a mano"},
            {"Estudiante humano", "Generado por IA"},
            {"DALL-E", "Artista clásico"},
            {"Diseñador gráfico", "Algoritmo de IA"},
            {"Creada por una IA", "Óleo renacentista"}
    };

    // Respuestas correctas para las 10 preguntas[cite: 1]
    char[] answers = {
            'A',
            'B',
            'A',
            'A',
            'A',
            'A',
            'A',
            'A',
            'A',
            'A'
    };

    char guess;
    char answer;
    int index;
    int correct_guesses = 0;
    int total_questions = questions.length;
    int result;
    int seconds = 10; // Temporizador de 10 segundos por pregunta[cite: 1]

    JFrame frame = new JFrame();
    JTextField textfield = new JTextField();
    JTextArea textarea = new JTextArea();
    JButton buttonA = new JButton();
    JButton buttonB = new JButton();
    JLabel answer_labelA = new JLabel();
    JLabel answer_labelB = new JLabel();
    JLabel time_label = new JLabel();
    JLabel seconds_left = new JLabel();
    JTextField number_right = new JTextField();
    JTextField percentage = new JTextField();

    // Configuración del Timer idéntica a la del tutorial[cite: 1]
    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            seconds--;
            seconds_left.setText(String.valueOf(seconds));
            if (seconds <= 0) {
                displayAnswer();
            }
        }
    });

    public Quiz() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 650);
        frame.getContentPane().setBackground(new Color(50, 50, 50)); // Fondo gris oscuro temático[cite: 1]
        frame.setLayout(null);
        frame.setResizable(false);

        // Barra superior de la pregunta[cite: 1]
        textfield.setBounds(0, 0, 650, 50);
        textfield.setBackground(new Color(25, 25, 25));
        textfield.setForeground(new Color(25, 255, 0)); // Verde neón[cite: 1]
        textfield.setFont(new Font("Century Gothic", Font.PLAIN, 25));
        textfield.setBorder(BorderFactory.createBevelBorder(1));
        textfield.setHorizontalAlignment(JTextField.CENTER);
        textfield.setEditable(false);

        // Cuadro de texto para el enunciado[cite: 1]
        textarea.setBounds(0, 50, 650, 100);
        textarea.setBackground(new Color(25, 25, 25));
        textarea.setForeground(new Color(25, 255, 0));
        textarea.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        textarea.setLineWrap(true);
        textarea.setWrapStyleWord(true);
        textarea.setEditable(false);

        // Botón A[cite: 1]
        buttonA.setBounds(0, 200, 100, 100);
        buttonA.setFont(new Font("Century Gothic", Font.PLAIN, 35));
        buttonA.setFocusable(false);
        buttonA.addActionListener(this);
        buttonA.setText("A");

        // Botón B[cite: 1]
        buttonB.setBounds(0, 320, 100, 100);
        buttonB.setFont(new Font("Century Gothic", Font.PLAIN, 35));
        buttonB.setFocusable(false);
        buttonB.addActionListener(this);
        buttonB.setText("B");

        // Etiquetas de las opciones[cite: 1]
        answer_labelA.setBounds(125, 200, 500, 100);
        answer_labelA.setBackground(new Color(50, 50, 50));
        answer_labelA.setForeground(new Color(25, 255, 0));
        answer_labelA.setFont(new Font("Century Gothic", Font.PLAIN, 28));

        answer_labelB.setBounds(125, 320, 500, 100);
        answer_labelB.setBackground(new Color(50, 50, 50));
        answer_labelB.setForeground(new Color(25, 255, 0));
        answer_labelB.setFont(new Font("Century Gothic", Font.PLAIN, 28));

        // Contador de segundos[cite: 1]
        seconds_left.setBounds(535, 510, 100, 100);
        seconds_left.setBackground(new Color(25, 25, 25));
        seconds_left.setForeground(new Color(255, 0, 0));
        seconds_left.setFont(new Font("Century Gothic", Font.PLAIN, 50));
        seconds_left.setBorder(BorderFactory.createBevelBorder(1));
        seconds_left.setOpaque(true);
        seconds_left.setHorizontalAlignment(JTextField.CENTER);
        seconds_left.setText(String.valueOf(seconds));

        // Etiqueta del temporizador[cite: 1]
        time_label.setBounds(535, 475, 100, 25);
        time_label.setBackground(new Color(50, 50, 50));
        time_label.setForeground(new Color(255, 0, 0));
        time_label.setFont(new Font("Century Gothic", Font.PLAIN, 15));
        time_label.setHorizontalAlignment(JTextField.CENTER);
        time_label.setText("timer >:D");

        // Campos para resultados finales[cite: 1]
        number_right.setBounds(225, 225, 200, 100);
        number_right.setBackground(new Color(25, 25, 25));
        number_right.setForeground(new Color(25, 255, 0));
        number_right.setFont(new Font("Century Gothic", Font.PLAIN, 40));
        number_right.setBorder(BorderFactory.createBevelBorder(1));
        number_right.setHorizontalAlignment(JTextField.CENTER);
        number_right.setEditable(false);

        percentage.setBounds(225, 325, 200, 100);
        percentage.setBackground(new Color(25, 25, 25));
        percentage.setForeground(new Color(25, 255, 0));
        percentage.setFont(new Font("Century Gothic", Font.PLAIN, 40));
        percentage.setBorder(BorderFactory.createBevelBorder(1));
        percentage.setHorizontalAlignment(JTextField.CENTER);
        percentage.setEditable(false);

        frame.add(time_label);
        frame.add(seconds_left);
        frame.add(answer_labelA);
        frame.add(answer_labelB);
        frame.add(buttonA);
        frame.add(buttonB);
        frame.add(textarea);
        frame.add(textfield);
        frame.setVisible(true);

        nextQuestion();
    }

    // Método para avanzar entre preguntas de forma dinámica[cite: 1]
    public void nextQuestion() {
        if (index >= total_questions) {
            results();
        } else {
            textfield.setText("Pregunta " + (index + 1));
            textarea.setText(questions[index]);
            answer_labelA.setText(options[index][0]);
            answer_labelB.setText(options[index][1]);
            timer.start();
        }
    }

    // Manejo de eventos de clic en los botones[cite: 1]
    @Override
    public void actionPerformed(ActionEvent e) {
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);

        if (e.getSource() == buttonA) {
            answer = 'A';
            if (answer == answers[index]) {
                correct_guesses++;
            }
        }
        if (e.getSource() == buttonB) {
            answer = 'B';
            if (answer == answers[index]) {
                correct_guesses++;
            }
        }
        displayAnswer();
    }

    // Método para mostrar respuestas correctas/incorrectas con colores[cite: 1]
    public void displayAnswer() {
        timer.stop();
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);

        if (answers[index] != 'A') answer_labelA.setForeground(new Color(255, 0, 0));
        if (answers[index] != 'B') answer_labelB.setForeground(new Color(255, 0, 0));

        Timer pause = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answer_labelA.setForeground(new Color(25, 255, 0));
                answer_labelB.setForeground(new Color(25, 255, 0));

                answer = ' ';
                seconds = 10;
                seconds_left.setText(String.valueOf(seconds));
                buttonA.setEnabled(true);
                buttonB.setEnabled(true);
                index++;
                nextQuestion();
            }
        });
        pause.setRepeats(false);
        pause.start();
    }

    // Método de resultados finales[cite: 1]
    public void results() {
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);

        result = (int) ((double) correct_guesses / total_questions * 100);

        textfield.setText("RESULTADOS");
        textarea.setText("");
        answer_labelA.setText("");
        answer_labelB.setText("");

        number_right.setText("(" + correct_guesses + "/" + total_questions + ")");
        percentage.setText(result + "%");

        frame.add(number_right);
        frame.add(percentage);
    }
}
