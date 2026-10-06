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
  }
}
