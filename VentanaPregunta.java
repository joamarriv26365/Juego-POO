
import javax.swing.*;
import java.awt.*;

public class VentanaPregunta extends JFrame {
    private Juego partida;
    private InfoJuego info = new InfoJuego();

    public VentanaPregunta(Juego partida) {
        this.partida = partida;
        
       
        setTitle("IA Detector - En Juego");
        setSize(700, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        Pregunta p = partida.obtenerPreguntaActual();

        
        JLabel lblNum = new JLabel("Pregunta " + (partida.getNumpregunta() + 1) + " de " + partida.getTotalPreguntas());
        lblNum.setBounds(50, 10, 300, 30);
        add(lblNum);

        
        String rutaImagen = "img/" + p.getRutaImagen();
        ImageIcon iconoOriginal = new ImageIcon(rutaImagen);
        Image imgEscalada = iconoOriginal.getImage().getScaledInstance(400, 300, Image.SCALE_SMOOTH);
        JLabel lblImg = new JLabel(new ImageIcon(imgEscalada));
        lblImg.setBounds(150, 45, 400, 300);
        add(lblImg);

        JLabel lblRecurso = new JLabel("Recurso a evaluar: " + p.getRutaImagen());
        lblRecurso.setBounds(50, 355, 400, 25);
        add(lblRecurso);

       
        JTextArea txtInstr = new JTextArea(info.getInstruccionesPregunta());
        txtInstr.setEditable(false);
        txtInstr.setBounds(50, 385, 580, 50);
        add(txtInstr);

        JButton btnIA = new JButton ("Si (la imagén esta generada con inteligencia artificial)");
        btnIA.setBounds (120, 455, 180, 40);
        btnIA.addActionListener (e -> responder(true));
        ass(btnIA);
    }

}
