public class Pregunta {
    private int numero;
    private String rutaImagen;
    private boolean esIA;
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

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public boolean isEsIA() {
        return esIA;
    }

    public void setEsIA(boolean esIA) {
        this.esIA = esIA;
    }

    public void setRetroalimentacion(String retroalimentacion) {
        this.retroalimentacion = retroalimentacion;
    }
}