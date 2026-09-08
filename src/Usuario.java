public class Usuario {
    private String nombre;
    private int puntaje;

    public Usuario() {
        nombre = "";
        puntaje = 0;
    }

    public Usuario(String nombre) {
        this.nombre = nombre;
        puntaje = 0;
    }

    public void setNombre(String newnombre) {
        nombre = newnombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void aumentarPuntaje() {
        puntaje++;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int newpuntaje) {
        puntaje = newpuntaje;
    }
}