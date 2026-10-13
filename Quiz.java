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

}
