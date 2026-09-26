
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
    }

}
