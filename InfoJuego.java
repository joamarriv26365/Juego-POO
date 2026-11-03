public class InfoJuego {
    private String acercaDelProyecto;
    private String instruccionesPregunta;
    private final String RUTA_TXT = "info.txt";

    public InfoJuego() {
        this.acercaDelProyecto = "";
        this.instruccionesPregunta = "";
        cargarInfoDesdeTXT();
    }
    

}
