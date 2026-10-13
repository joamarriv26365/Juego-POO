public class Pregunta {
    private int numero;
    private String rutaImagen;
    private boolean esIA; // true = Es IA, false = Es Humano
    private String retroalimentacion;

    public Pregunta(int numero, String rutaImagen, boolean esIA, String retroalimentacion) {
        this.numero = numero;
        this.rutaImagen = rutaImagen;
        this.esIA = esIA;
        this.retroalimentacion = retroalimentacion;
    }

    public boolean esRespuestaCorrecta(boolean respuestaUsuario) {
        return this.esIA == respuestaUsuario;
    }

    public int getNumero() {
        return numero;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public String getRetroalimentacion() {
        return retroalimentacion;
    }
}
