import javax.swing.*;
public class Inicio extends JFrame{
  private infojuego info = new infojuego();
  private JText txtNombre;

  public Inicio(){
    setTitle("IA detector - Inicio");
    setSize(600,500);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLayout(null);
    setLocationRelativeTo(null);

    JLabel titulo = new JLabel(" IA Detector ", SwingConstants.CENTER);
    titulo.setBounds(150, 20, 300, 30);
    add(titulo);

    JTextArea areaInfo = new JTextArea(info.getAcercaDelProyecto());
    areaInfo.setLineWrap(true);
    areaInfo.setWrapStyleWord(true);
    areInfo.setEditable(false);
    JScrollPane scroll = new JScrollPane(areaInfo);
    scroll.setBound(50, 60, 500, 240);
    add(scroll);

    JLabel lblNombre = new JLabel("Ingresa tu usuario: ");
    lblNombre.setBound(50, 320, 150, 30);
    add(lblNombre);

    txtNombre = new JTextField();
    txtNombre.setBounds(180, 320, 220, 30);
    add(txtNombre);

    JButton btnIniciar = new JButton("1. Iniciar Juego");
    btnIniciar.setBounds(50, 380, 160, 35);
    btnIniciar.addActionListener(e -> {
      String nombre = txtNombre.getText().trim();
      if(nombre.isEmpty()){
        JOptionPane.showMessageDiaLOG(this, "Ingrese su usuario para continuar");
        return;
      }
      Juego partida = new Juego(nombre);
      new VentanaPregunta(partida).setVisible(true);
      dispose();
    });
    add(btnIniciar);
    JButton btnSalir = new JButton("3. Salir");
    btnSalir.setBounds(400, 380, 120, 35);
    btnSalir.addActionListener(e -> System.exit(0));
    add(btnSalir);
  }
}
