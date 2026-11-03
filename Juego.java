import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Juego {
    private String nombreJugador;
    private ArrayList<Pregunta> preguntas;
    private int indiceActual;
    private int puntaje;
    private final String RUTA_TXT = "preguntas.txt";

    public Juego(String nombreJugador) {
        this.nombreJugador = nombreJugador;
        this.indiceActual = 0;
        this.puntaje = 0;
        this.preguntas = new ArrayList<>();
        cargarPreguntasDesdeTXT();
    }

       private void cargarPreguntasDesdeTXT() {
        File archivo = new File(RUTA_TXT);
        if (!archivo.exists()) {
            System.out.println("No se encontró el archivo preguntas.txt en la raíz del proyecto.");
            return;
        }

        try {
            String contenidoTotal = new String(java.nio.file.Files.readAllBytes(archivo.toPath()), StandardCharsets.UTF_8);
            String[] bloques = contenidoTotal.split("---");
            int numPregunta = 1;

            for (String bloque : bloques) {
                bloque = bloque.trim();
                if (bloque.isEmpty()) {
                    continue;
                }

                String rutaImg = "";
                boolean esIa = false;
                StringBuilder retroBuilder = new StringBuilder();
                boolean leyendoRetro = false;

                String[] lineas = bloque.split("\n");
                for (String linea : lineas) {
                    String lineaTrim = linea.trim();

                    if (lineaTrim.startsWith("IMAGEN:")) {
                        rutaImg = lineaTrim.substring(7).trim();
                        leyendoRetro = false;
                    } else if (lineaTrim.startsWith("ES_IA:")) {
                        esIa = Boolean.parseBoolean(lineaTrim.substring(6).trim().toLowerCase());
                        leyendoRetro = false;
                    } else if (lineaTrim.startsWith("RETRO:")) {
                        retroBuilder.append(lineaTrim.substring(6).trim());
                        leyendoRetro = true;
                    } else if (leyendoRetro) {
                        if (retroBuilder.length() > 0) {
                            retroBuilder.append("\n");
                        }
                        retroBuilder.append(linea);
                    }
                }

                if (!rutaImg.isEmpty()) {
                    preguntas.add(new Pregunta(numPregunta++, rutaImg, esIa, retroBuilder.toString().trim().replace("\\n", "\n")));
                }
            }

        } catch (Exception e) {
            System.err.println("Error al leer preguntas.txt: " + e.getMessage());
        }
    }

      public Pregunta obtenerPreguntaActual() {
        if (indiceActual >= 0 && indiceActual < preguntas.size()) {
            return preguntas.get(indiceActual);
        }
        return null;
    }

     public boolean evaluarEleccionUsuario(char letraOpcion) {
        Pregunta actual = obtenerPreguntaActual();
        if (actual == null) return false;
        boolean respuestaUsuario = (Character.toUpperCase(letraOpcion) == 'A');
        boolean esCorrecta = actual.esRespuestaCorrecta(respuestaUsuario);
        if (esCorrecta) {
            this.puntaje += (100 / (preguntas.size() > 0 ? preguntas.size() : 1));
        }
        return esCorrecta;
    }

      public void avanzarJuego() {
        indiceActual++;
    }

    

}
