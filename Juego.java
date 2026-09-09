import java.util.ArrayList;

public class Juego {
    private String nombreJugador;
    private Pregunta[] preguntas;
    private int numpregunta;
    private int puntaje;

    public Juego(String nombreJugador) {
        this.nombreJugador = nombreJugador;
        this.numpregunta = 0;
        this.puntaje = 0;
        preguntas = new Pregunta[10];
        preguntas[0] = new Pregunta(1, "imagenes1.jpg", true, "Retroalimentación 1");
        preguntas[1] = new Pregunta(2, "imagenes2.jpg",false, "Retroalimentación 2");
        preguntas[2] = new Pregunta(3, "imagenes3.jpg",true,"Retroalimentación 3");
        preguntas[3] = new Pregunta(4, "imagenes4.jpg",true,"Retroalimentación 4");
        preguntas[4] = new Pregunta(5, "imagenes5.jpg",true,"Retroalimentación 5");
        preguntas[5] = new Pregunta(6, "imagenes6.jpg",true,"Retroalimentación 6");
        preguntas[6] = new Pregunta(7, "imagenes7.jpg",true,"Retroalimentación 7");
        preguntas[7] = new Pregunta(8, "imagenes8.jpg",true,"Retroalimentación 8");
        preguntas[8] = new Pregunta(9, "imagenes9.jpg",true,"Retroalimentación 9");
        preguntas[9] = new Pregunta(10, "imagenes10.jpg",true,"RetroalimentacióN 10");
    }

    public Pregunta obtenerPreguntaActual() {
        if (numpregunta < preguntas.length) {
            return preguntas[numpregunta];
        }
        return null;
    }

    public boolean evaluarRespuesta(boolean respuestaUsuario) {
        Pregunta actual = obtenerPreguntaActual();
        if (actual != null) {
            boolean correcta = actual.esRespuestaCorrecta(respuestaUsuario);
            if (correcta) {
                puntaje += 10;
            }
            return correcta;
        }
        return false;
    }

    public boolean avanzarSiguientePregunta() {
        if (numpregunta < preguntas.length - 1) {
            numpregunta++;
            return true;
        }
        return false;
    }

    public boolean estaFinalizado() {
        return numpregunta >= preguntas.length - 1;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public int getNumpregunta() {
        return numpregunta;
    }

    public int getTotalPreguntas() {
        return preguntas.length;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }
}
