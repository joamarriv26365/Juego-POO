public class Pregunta { // esta clase está enfocada en el proceso de las preguntas realizadas en el juego, a continuacion se observan todos los atributos de esta 
    private int numero;
    private String rutaImagen;
    private boolean esIA;
    private String retroalimentacion;

    public Pregunta(int numero, String rutaImagen, boolean esIA, String retroalimentacion) { // sobrecarga de atributos de la clase 
        this.numero = numero;
        this.rutaImagen = rutaImagen;
        this.esIA = esIA;
        this.retroalimentacion = retroalimentacion;
    }

    public boolean esRespuestaCorrecta(boolean respuestaUsuario) {
        return this.esIA == respuestaUsuario;// devuelve un boolean sobre la respuesta emitida por el usuario
    }

    public int getNumero() {
        return numero;// devuelve el numero de pregunta en la que se encuentra el jugador
    }

    public String getRutaImagen() {
        return rutaImagen; // devuelve la ruta de imagen que corresponde a la pregunta
    }

    public String getRetroalimentacion() {
        return retroalimentacion; // devuelve la retroalimentacion sobre la imagen emitida

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
