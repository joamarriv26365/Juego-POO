/// Herramientas para manejar archivos, codificación de texto y listas.
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Juego { // propiedades de la clase 
    private String nombreJugador;
    private ArrayList<Pregunta> preguntas;
    private int indiceActual;
    private int puntaje;
    private final String RUTA_TXT = "preguntas.txt"; // Ruta relativa al directorio desde el que se ejecuta el programa.

    public Juego(String nombreJugador) { // Prepara una partida y carga las preguntas.
        this.nombreJugador = nombreJugador;
        this.indiceActual = 0;
        this.puntaje = 0;
        this.preguntas = new ArrayList<>();
        cargarPreguntasDesdeTXT();
    }

    private void cargarPreguntasDesdeTXT() { // Lee el archivo y convierte cada bloque en un objeto Pregunta.
        File archivo = new File(RUTA_TXT);
        if (!archivo.exists()) {
            System.out.println("No se encontró el archivo preguntas.txt en la raíz del proyecto.");
            return;
        }

        try { // Lee los bytes y los interpreta como texto UTF-8. Esto, permite representar texto en prácticamente cualquier idioma del mundo.
            // toPath() proporciona la ruta que necesita readAllBytes(). toPath, es permite que UTF-8 se lleve a cabo 
            String contenidoTotal = new String(java.nio.file.Files.readAllBytes(archivo.toPath()), StandardCharsets.UTF_8);
            String[] bloques = contenidoTotal.split("---");   // Cada "---" separa una pregunta de la siguiente.
            int numPregunta = 1;

            for (String bloque : bloques) {
                bloque = bloque.trim();
                if (bloque.isEmpty()) {  // Ignora bloques sin contenido
                    continue;
                }

                String rutaImg = "";    // Datos temporales de cada pregunta.

                boolean esIa = false;
                StringBuilder retroBuilder = new StringBuilder();
                boolean leyendoRetro = false;

                String[] lineas = bloque.split("\n");
                for (String linea : lineas) {
                    String lineaTrim = linea.trim();

                    if (lineaTrim.startsWith("IMAGEN:")) {
                        rutaImg = lineaTrim.substring(7).trim(); // Extrae el texto después de "IMAGEN:".
                        leyendoRetro = false;
                    } else if (lineaTrim.startsWith("ES_IA:")) { // Convierte el valor leído a true o false.
                        esIa = Boolean.parseBoolean(lineaTrim.substring(6).trim().toLowerCase());
                        leyendoRetro = false;
                    } else if (lineaTrim.startsWith("RETRO:")) {  // Comienza a guardar la retroalimentación.
                        retroBuilder.append(lineaTrim.substring(6).trim());
                        leyendoRetro = true;
                    } else if (leyendoRetro) { // Agrega las siguientes líneas de la explicación.
                        if (retroBuilder.length() > 0) {
                            retroBuilder.append("\n");
                        }
                        retroBuilder.append(linea);
                    }
                }

                if (!rutaImg.isEmpty()) { // Agrega la pregunta si tiene una ruta de imagen.
                    preguntas.add(new Pregunta(numPregunta++, rutaImg, esIa, retroBuilder.toString().trim().replace("\\n", "\n"))); // Convierte el texto acumulado en String y
                        // reemplaza los "\n" escritos por saltos reales.
                }
            }

        } catch (Exception e) {  // Informa en consola si ocurre un error durante la carga.
            System.err.println("Error al leer preguntas.txt: " + e.getMessage());
        }
    }

    public Pregunta obtenerPreguntaActual() { // Devuelve la pregunta actual o null si el índice no es válido
        if (indiceActual >= 0 && indiceActual < preguntas.size()) {
            return preguntas.get(indiceActual);
        }
        return null;
    }

    public boolean evaluarRespuesta(boolean respuestaUsuario) {// Comprueba la respuesta y suma puntos si es correcta
        Pregunta actual = obtenerPreguntaActual();
        if (actual != null) {
            boolean correcta = actual.esRespuestaCorrecta(respuestaUsuario);
            if (correcta) {// Reparte 100 puntos entre las preguntas.
                // La división entera descarta los decimales
                this.puntaje += (100 / (preguntas.size() > 0 ? preguntas.size() : 1));
            }
            return correcta;
        }
        return false;
    }

    public void avanzarSiguientePregunta() {//Cambia el índice para pasar a la siguiente pregunta
        indiceActual++;
    }

    public boolean estaFinalizado() {
        return indiceActual >= preguntas.size();
    }

    public int getPuntaje() {
        return puntaje;
    }

    public int getIndiceActual() {
        return indiceActual;
    }

    public int getTotalPreguntas() {
        return preguntas.size();
    }

    public String getNombreJugador() {
        return nombreJugador;
    }
}
