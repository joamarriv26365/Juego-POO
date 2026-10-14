import java.util.ArrayList;

public class Juego2{  // Datos de la partida, estos mismos son las propiedades de la clase 
    private String nombreJugador;
    private ArrayList<Pregunta> preguntas;
    private int indiceActual;
    private int puntaje;

    public Juego2(String nombreJugador) { // Al crear la partida, guarda el nombre, ademas comienza en la primera pregunta con cero puntos
        this.nombreJugador = nombreJugador;
        this.indiceActual = 0;
        this.puntaje = 0;
        this.preguntas = new ArrayList<>();

        cargarPreguntasReales();// Agrega las preguntas a la lista
    }

    private void cargarPreguntasReales() { // Cada Pregunta contiene: número, ruta de imagen, respuesta correcta (true = IA, false = humano) y explicación de la respuesta.
        preguntas.add(new Pregunta(1, "/imagenes/foto1.jpg", true, "Chivo: Estilisticamente, la imagén tiene esa suavidad caracterísitica que tienen muchas fotos con IA. \n" +
                "Además Donald Trump, a pesar de tener varios cargos penales, nunca se ha visto en una situación similar\n" +
                "Ya que el no representa el perfíl que ICE maneja para realizar sus arrestos."));
        preguntas.add(new Pregunta(2, "/imagenes/foto2.jpg", false, "Explicación 2: Contiene imperfecciones ópticas y profundidad de campo de una cámara real."));
        preguntas.add(new Pregunta(3, "/imagenes/foto3.jpg", true, "Explicación 3: Texturas y artefactos digitales de redes neuronales de difusión."));
        preguntas.add(new Pregunta(4, "/imagenes/foto4.jpg", false, "Explicación 4: Evidencia trazos físicos de pincel y origen completamente humano."));
        preguntas.add(new Pregunta(5, "/imagenes/foto5.jpg", true, "Explicación 5: Iluminación artificial compleja y rostros sintéticos creados por Midjourney."));
        preguntas.add(new Pregunta(6, "/imagenes/foto6.jpg", false, "Explicación 6: Fotografía urbana real capturada en condiciones de luz natural."));
        preguntas.add(new Pregunta(7, "/imagenes/foto7.jpg", true, "Explicación 7: Composición visual surrealista generada mediante algoritmos."));
        preguntas.add(new Pregunta(8, "/imagenes/foto8.jpg", false, "Explicación 8: Boceto artístico a lápiz realizado de forma manual."));
        preguntas.add(new Pregunta(9, "/imagenes/foto9.jpg", true, "Explicación 9: Patrones de renderizado automático con texturas repetitivas."));
        preguntas.add(new Pregunta(10, "/imagenes/foto10.jpg", false, "Explicación 10: Ilustración conceptual con estilo y trazo de diseño humano."));
    }

    public Pregunta obtenerPreguntaActual() {  // aca se busca la pregunta en la posición actual
        if (indiceActual < preguntas.size()) {
            return preguntas.get(indiceActual);
        }
        return null; // Si ya no hay una pregunta en esa posición, devuelve null
    }

    public boolean evaluarRespuesta(boolean respuestaUsuario) { // Obtiene la pregunta que el jugador está respondiendo
        Pregunta actual = obtenerPreguntaActual();
        if (actual != null) {// Compara respuestas
            boolean correcta = actual.esRespuestaCorrecta(respuestaUsuario);
            if (correcta) {
                this.puntaje += 10;// Si acierta, agrega 10 puntos
            }
            return correcta;// Devuelve true si acertó o false si se equivocó
        }
        return false; // Si no hay pregunta actual, no se puede evaluar la respuesta
    }

    public void avanzarSiguientePregunta() {
        if (indiceActual < preguntas.size() - 1) {// Aumenta el índice en 1, así hasta la ultima pregunta
            indiceActual++;
        }
    }

    public boolean estaFinalizado() { 
        return indiceActual >= preguntas.size() - 1;//cuando el índice llega a la última pregunta, incluso si esa última pregunta aún no se respondió, devolverá true
    }

    public int getPuntaje() { 
        return puntaje;// devuelve el puntaje obtenido 
    }

    public int getIndiceActual() { 
        return indiceActual;// Devuelve la posición de la pregunta actual
    }

    public int getTotalPreguntas() { 
        return preguntas.size();// Devuelve cuántas preguntas hay en la lista
    }

    public String getNombreJugador() {
        return nombreJugador; // Devuelve el nombre del jugador
    }

}
