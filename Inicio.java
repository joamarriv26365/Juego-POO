import javax.swing.*;
public class Inicio extends JFrame{
  private infojuego info = new infojuego(); 
  private JText txtNombre;// Campo donde el usuario escribe su nombre

  public Inicio(){ // Configura la ventana de inicio
    setTitle("IA detector - Inicio");
    setSize(600,500);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLayout(null);
    setLocationRelativeTo(null);

    JLabel titulo = new JLabel(" IA Detector ", SwingConstants.CENTER); // Muestra el título
    titulo.setBounds(150, 20, 300, 30);
    add(titulo);

    JTextArea areaInfo = new JTextArea(info.getAcercaDelProyecto()); // Muestra la información del proyecto en un área con desplazamiento
    areaInfo.setLineWrap(true);
    areaInfo.setWrapStyleWord(true);
    areInfo.setEditable(false);
    JScrollPane scroll = new JScrollPane(areaInfo);
    scroll.setBound(50, 60, 500, 240);
    add(scroll);

    JLabel lblNombre = new JLabel("Ingresa tu usuario: ");  // Solicita el nombre del usuario
    lblNombre.setBound(50, 320, 150, 30);
    add(lblNombre);

    txtNombre = new JTextField();
    txtNombre.setBounds(180, 320, 220, 30);
    add(txtNombre);

    JButton btnIniciar = new JButton("1. Iniciar Juego"); // Comprueba que se ingresó un nombre antes de iniciar el juego
    btnIniciar.setBounds(50, 380, 160, 35);
    btnIniciar.addActionListener(e -> {
      String nombre = txtNombre.getText().trim();
      if(nombre.isEmpty()){
        JOptionPane.showMessageDiaLOG(this, "Ingrese su usuario para continuar");
        return;
      }
      Juego partida = new Juego(nombre);  // Crea la partida, abre la primera pregunta y cierra esta ventana
      new VentanaPregunta(partida).setVisible(true);
      dispose();
    });
    add(btnIniciar);
    JButton btnSalir = new JButton("3. Salir");
    btnSalir.setBounds(400, 380, 120, 35);
    btnSalir.addActionListener(e -> System.exit(0));
    add(btnSalir);
  }

  public static void main(String[] args){
    SwingUtilities.invokeLater(() -> new Inicio89.setVisible(true));
  }
}
