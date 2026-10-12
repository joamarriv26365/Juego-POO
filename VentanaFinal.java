package iadetector;

import javax.swing.*;

public class VentanaFinal extends JFrame {

    public VentanaFinal(Juego partida) {
        // 1. Configuración de la ventana
        setTitle("IA Detector - Fin de la Partida");
        setSize(500, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        // 2. Textos de Resultados
        JLabel lblFin = new JLabel("=== FIN DE LA PARTIDA ===", SwingConstants.CENTER);
        lblFin.setBounds(100, 20, 300, 30);
        add(lblFin);

        JLabel lblJugador = new JLabel("Jugador: " + partida.getNombreJugador());
        lblJugador.setBounds(50, 70, 400, 30);
        add(lblJugador);

        int puntajeMaximo = partida.getTotalPreguntas() * 10;
        JLabel lblPuntos = new JLabel("Puntaje Final: " + partida.getPuntaje() + " / " + puntajeMaximo + " pts");
        lblPuntos.setBounds(50, 110, 400, 30);
        add(lblPuntos);
        
        String veredicto = partida.getPuntaje() >= 60 ? "¡Aprobado! Eres un buen detector de IA." : "Reprobado. Sigue practicando tu ojo crítico.";
        JLabel lblVeredicto = new JLabel("Resultado: " + veredicto);
        lblVeredicto.setBounds(50, 150, 400, 30);
        add(lblVeredicto);

        
    }
}
