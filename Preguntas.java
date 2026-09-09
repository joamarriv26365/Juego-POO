public class Preguntas {
    private int numero;
    private String rutaImagen;
    private boolean esIA; // Un true significa que si es ia, y el false es humano
    private String retroalimentacion;

    public Preguntas(int numero, String rutaImagen, boolean esIA, String retroalimentacion) {
        this.numero = numero;
        this.rutaImagen = rutaImagen;
        this.esIA = esIA;
        this.retroalimentacion = retroalimentacion;
    }

    public boolean verRespuesta(boolean respuesta) {
        return respuesta == respuestacorr;
    }

    public void Operation10() {
    }

    public void setNumPregunta(int newnumpregunta) {
        numpregunta = newnumpregunta;
    }

    public int getNumPregunta() {
        return numpregunta;
    }

    public void setImagenRut(String newimagenrut) {
        imagenrut = newimagenrut;
    }

    public String getImagenRut() {
        return imagenrut;
    }

    public void setRespuestaCorr(boolean newrespuestacorr) {
        respuestacorr = newrespuestacorr;
    }

    public boolean getRespuestaCorr() {
        return respuestacorr;
    }

    public void setRetroalimentacion(String newretroalimentacion) {
        retroalimentacion = newretroalimentacion;
    }

    public String getRetroalimentacion() {
        return retroalimentacion;
    }
}
