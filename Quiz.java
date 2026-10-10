import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Quiz implements ActionListener {

    //inicializar.
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
    //constructor
    public Quiz(){
    }
    //Método que sirve para moverse de pregunta en pregunta
    public void nextQuestion(){

    }
//Todo lo relacionado con los clicks del ususario va a ir aqui.
    public actionPerformed(ActionEvent e){

    }

    //Método que nos enseña la respuesta correcta
    public void displayAnswer() {

    }

    //Método que nos da los resultados finales
    public void results(){

    }
}
