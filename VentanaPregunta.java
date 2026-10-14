
import javax.swing.*; // bibliotecas para utilizar una interfaz grafica 
import java.awt.*;

public class VentanaPregunta extends JFrame { // herencia, la clase madre de esta es JFrame, a continuacion se observan los atributos de la clase 
    private Juego partida;
    private InfoJuego info = new InfoJuego();

    public VentanaPregunta(Juego partida) {
        this.partida = partida;// Recibe y guarda la partida creada en la ventana de inicio
        
       
        setTitle("IA Detector - En Juego");// Configura el tamaño, título y posición de la ventana
        setSize(700, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        Pregunta p = partida.obtenerPreguntaActual();// Obtiene la pregunta que corresponde mostrar

        
        JLabel lblNum = new JLabel("Pregunta " + (partida.getNumpregunta() + 1) + " de " + partida.getTotalPreguntas()); // Muestra el número de pregunta y el total
        lblNum.setBounds(50, 10, 300, 30);
        add(lblNum);

        
        String rutaImagen = "img/" + p.getRutaImagen();// Carga la imagen, la ajusta a 400 × 300 píxeles y la muestra
        ImageIcon iconoOriginal = new ImageIcon(rutaImagen);
        Image imgEscalada = iconoOriginal.getImage().getScaledInstance(400, 300, Image.SCALE_SMOOTH);
        JLabel lblImg = new JLabel(new ImageIcon(imgEscalada));
        lblImg.setBounds(150, 45, 400, 300);
        add(lblImg);

        JLabel lblRecurso = new JLabel("Recurso a evaluar: " + p.getRutaImagen());// Muestra la ruta del recurso que se está evaluando
        lblRecurso.setBounds(50, 355, 400, 25);
        add(lblRecurso);

       
        JTextArea txtInstr = new JTextArea(info.getInstruccionesPregunta());// Muestra las instrucciones y evita que el usuario las modifique
        txtInstr.setEditable(false);
        txtInstr.setBounds(50, 385, 580, 50);
        add(txtInstr);

        JButton btnIA = new JButton ("Si (la imagén esta generada con inteligencia artificial)"); // Botón para responder que la imagen fue generada con IA
        btnIA.setBounds (120, 455, 180, 40);
        btnIA.addActionListener (e -> responder(true));// Al hacer clic, envía True como respuesta del usuario
        ass(btnIA);
    }

}
