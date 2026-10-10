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

    String answers = {


    };
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