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
  }
}
