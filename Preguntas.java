public class Preguntas {
    private int numpregunta;
    private String imagenrut;
    private boolean respuestacorr;
    private String retroalimentacion;

    public Preguntas() {
        numpregunta = 0;
        imagenrut = "";
        respuestacorr = false;
        retroalimentacion = "";
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
