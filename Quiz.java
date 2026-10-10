
// Este programa es dinámico, se le pueden agregar
// preguntas sin problemas y va a correr igual

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

    public class Quiz implements ActionListener {

        //inicializar variables

        //Array con todas las preguntas
        String[] questions = {
                "Pregunta 1",
                "Pregunta 2",
                "Pregunta 3",
                "Pregunta 4",
                "Pregunta 5",
                "Pregunta 6",
                "Pregunta 7",
                "Pregunta 8",
                "Pregunta 9",
                "Pregunta 10"
        };

        //Array con las opciones
        String[][]opciones = {

                {"Es IA.", "No es IA."},
                {"Es IA.", "No es IA."},
                {"Es IA.", "No es IA."},
                {"Es IA.", "No es IA."},
                {"Es IA.", "No es IA."},
                {"Es IA.", "No es IA."},
                {"Es IA.", "No es IA."},
                {"Es IA.", "No es IA."},
                {"Es IA.", "No es IA."},
                {"Es IA.", "No es IA."}




        };

        //Array con las respuestas

        char [] answers = {

                'A',
                'B'

        };

        char guess;
        char answer;
        int index;
        int correct_guesses = 0;
        int total_questions = questions.length;// se adapta a la longitud del array
        int result;
        int seconds = 30;//timer

        JFrame frame = new JFrame();
        JTextField textfield = new JTextField();
        JTextArea textarea = new JTextArea();
        JButton buttonA = new JButton();
        JButton buttonB = new JButton();
        JButton buttonC = new JButton();
        JButton buttonD = new JButton();
        JLabel answer_labelA  = new JLabel();
        JLabel answer_labelB  = new JLabel();
        JLabel answer_labelC  = new JLabel();
        JLabel answer_labelD  = new JLabel();
        JLabel seconds_left = new JLabel();
        JTextField number_right = new JTextField();
        JTextField percentage = new JTextField();




        //constructor
        public Quiz(){
            //  Código que crea y edita la ventana que se abre cuando se corre el código.
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 800);
            frame.getContentPane().setBackground(new Color(114, 26, 149));
            frame.setLayout(null);
            frame.setResizable(false);
            frame.setVisible(true);

            //El texto de el frame
            textfield.setBounds(0,0, 800, 50);
            textfield.setBackground (new Color(2, 2, 2));
            textfield.setForeground(new Color(255, 255, 255));
            textfield.setFont(new Font("Serif", Font.PLAIN, 30));
            textfield.setBorder(BorderFactory.createBevelBorder(1));
            textfield.setHorizontalAlignment(JTextField.CENTER);
            textfield.setEditable(false);

            textarea.setBounds(0,50, 800, 50);
            textarea.setLineWrap(true);
            textarea.setWrapStyleWord(true);
            textarea.setBackground (new Color(2, 2, 2));
            textarea.setForeground(new Color(255, 255, 255));
            textarea.setFont(new Font("Serif", Font.PLAIN, 30));
            textarea.setBorder(BorderFactory.createBevelBorder(1));
            textarea.setEditable(false);

            buttonA.setBounds (0, 100, 100, 100);
            buttonA.setFont(new Font ("Papyrus", Font.PLAIN, 35));
            buttonA.setFocusable(false);
            buttonA.addActionListener(this);
            buttonA.setText("Pene");

            buttonB.setBounds (0, 200, 100, 100);
            buttonB.setFont(new Font ("Papyrus", Font.PLAIN, 35));
            buttonB.setFocusable(false);
            buttonB.addActionListener(this);
            buttonB.setText("Anos");

            buttonC.setBounds (0, 300, 100, 100);
            buttonC.setFont(new Font ("Papyrus", Font.PLAIN, 35));
            buttonC.setFocusable(false);
            buttonC.addActionListener(this);
            buttonC.setText("Bolas");

            buttonD.setBounds (0, 400, 100, 100);
            buttonD.setFont(new Font ("Papyrus", Font.PLAIN, 35));
            buttonD.setFocusable(false);
            buttonD.addActionListener(this);
            buttonD.setText("Más Anos");

            answer_labelA.setBounds(125,100,500,100);
            answer_labelA.setBackground(new Color (50,50,50));
            answer_labelA.setForeground(new Color (255, 255, 255));
            answer_labelA.setFont(new Font("Papyrus", Font.PLAIN, 35));
            answer_labelA.setText("ano");

            answer_labelB.setBounds(125,200,500,100);
            answer_labelB.setBackground(new Color (50,50,50));
            answer_labelB.setForeground(new Color (255, 255, 255));
            answer_labelB.setFont(new Font("Papyrus", Font.PLAIN, 35));
            answer_labelB.setText("ano");


            answer_labelC.setBounds(125,300,500,100);
            answer_labelC.setBackground(new Color (50,50,50));
            answer_labelC.setForeground(new Color (255, 255, 255));
            answer_labelC.setFont(new Font("Papyrus", Font.PLAIN, 35));
            answer_labelC.setText("ano");

            answer_labelD.setBounds(125,400,500,100);
            answer_labelD.setBackground(new Color (50,50,50));
            answer_labelD.setForeground(new Color (255, 255, 255));
            answer_labelD.setFont(new Font("Papyrus", Font.PLAIN, 35));
            answer_labelD.setText("ano");

            frame.add(answer_labelA);
            frame.add(answer_labelB);
            frame.add(answer_labelC);
            frame.add(answer_labelD);
            frame.add(buttonA);
            frame.add(buttonB);
            frame.add(buttonC);
            frame.add(buttonD);
            frame.add(textarea);
            frame.add(textfield);
            frame.setVisible(true);

        }
        //Método que sirve para moverse de pregunta en pregunta
        public void nextQuestion(){

        }
        //Todo lo relacionado con los clicks del ususario va a ir aqui.
        public void actionPerformed(ActionEvent e){

        }

        //Método que nos enseña la respuesta correcta
        public void displayAnswer() {

        }

        //Método que nos da los resultados finales
        public void results(){

        }
    }


