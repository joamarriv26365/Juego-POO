import java.util.ArrayList;

public class Juego {
    private String nombreJugador;
    private ArrayList<Pregunta> preguntas;
    private int indiceActual;
    private int puntaje;

    public Juego(String nombreJugador) {
        this.nombreJugador = nombreJugador;
        this.indiceActual = 0;
        this.puntaje = 0;
        this.preguntas = new ArrayList<>();

        cargarPreguntasReales();
    }

    private void cargarPreguntasReales() {
        preguntas.add(new Pregunta(1, "/imagenes/foto1.jpg", true, "" +
                "Explicación: Esta imagén se viralizo en 2023 por mostrar al Papa con un look poco convencial para ser la cabeza de la iglesa católica.\n"+
                "El hecho de que la imagén fuera una generación de IA fue de gran sorpresa para muchos ya que la imagén contiene cierto nivel de realismo.\n"+
                "En esta ocasión pude ser diversión inocente, pero hay que tener en cuenta lo siguiente:\n"+
                "Es posible generar a quien sea de caulquier forma, entonces que algo se vea real, no significa que lo seá. Ser cauteloso es una buena práctica.\n"
        ));
        preguntas.add(new Pregunta(2, "/imagenes/foto2.jpg", false, "Explicación: Por más extraño que parezca, esa es una foto real del acutal presidente\n"
                +"de los Estados Unidos, Donald Trump, con el difunto convicto por tráfico sexual de menores Jeffrey Epstein. La foto, aunque antigua deja claro una cosa.\n" +
                "En uan época donde la manipulación de imagénes es facil y la evidencia fotográfica se desvance, que algo pueda ser descartado cómo falso no significa que deba de serlo.\n"));
        preguntas.add(new Pregunta(3, "/imagenes/foto3.jpg", true, "Explicación: En medio de una crísis de incendios en la Patagonia.\n" +
                "El presidente Milei de Argentina republicó una imagén que lo muestra saludando brigadistas comabtiendo fuego en el area.\n" +
                "En realidad el presidente Milei nunca fue a los incendios forestales, es más,\n" +
                "el presupuesto de 2026 para Argentina indicaba una reducción del 78% en los fondas al Servicio Nacional de Manejo del Fuego, i.e., \n" +
                "la IA puede ser usada como táctica de manipulación si así se deséa.  "));
        preguntas.add(new Pregunta(4, "/imagenes/foto4.jpg", true, "Explicación: Esta es una imagen que fue parte del \"trend\" de 2024 donde gente le pedía a una IA\n" +
                "que convirtiera sus fotos en versiones editadas al estilo del estudio Ghibli.\n" +
                "Muchas tendencias similares han surgido posteriormente.\n" +
                "El principal problema con la ghiblificación por IA es la apropiación no autorizada del trabajo artístico,\n" +
                "el impacto ambiental y la desvalorización de la animación tradicional artesanal."));
        preguntas.add(new Pregunta(5, "/imagenes/foto5.jpg", true, "Explicación: En esta imagen se observa un anuncio publicitario engañoso generado por IA de tazas hechas con minerales.\n" +
                "Los anuncios falsos creados con IA son peligrosos porque engañan a los consumidores vendiendo productos inexistentes,\n" +
                "facilitan estafas financieras y robos de datos bancarios en tiendas fraudulentas,\n" +
                "y minan la confianza del público en el comercio electrónico y la publicidad digital.\n" +
                "Si algo se ve demasiado cool para ser real, es posible que lo sea."));
        preguntas.add(new Pregunta(6, "/imagenes/foto6.jpg", false, "Explicación: Esta imagen es un meme famoso donde Barack Obama se otorga una medalla a sí mismo.\n" +
                "No fue generada por Inteligencia Artificial, sino mediante edición y fotomontaje digital tradicional por un humano.\n" +
                "Nos recuerda que la edición de imágenes ha existido desde mucho antes de la IA\n" +
                "y demuestra que el trabajo, la creatividad y el humor humano siguen teniendo un valor insustituible."));
        preguntas.add(new Pregunta(7, "/imagenes/foto7.jpg", true, "Explicación: Esta imagen generada por IA muestra una representación de Jesús abrazando a Donald Trump.\n" +
                "Muestra cómo la IA facilita la manipulación emocional y política al apelar a dogmas o símbolos religiosos,\n" +
                "buscando generar simpatía o devoción automática en las personas.\n" +
                "Además, este tipo de generación masiva le quita oportunidades e ingresos a artistas reales,\n" +
                "quienes dedican años a desarrollar su técnica y estilo de manera artesanal."));
        preguntas.add(new Pregunta(8, "/imagenes/foto8.jpg", false, "Explicación: Esta imagen es la famosa pintura 'La noche estrellada' realizada en 1889 por el artista humano Vincent van Gogh.\n" +
                "No fue creada por IA, pero al estar expuestos a una saturación constante de contenido sintético,\n" +
                "corremos el riesgo de desensibilizarnos y dudar de obras de arte históricas reales,\n" +
                "asumiendo erróneamente que sus patrones estilizados o pinceladas expresivas fueron generados por un algoritmo."));
        preguntas.add(new Pregunta(9, "/imagenes/foto9.jpg", true, "Explicación: Esta imagen es un retrato femenino hiperrealista generado sintéticamente por IA.\n" +
                "El desarrollo irrestricto de este contenido amplifica la misoginia al perpetuar sesgos de género,\n" +
                "promover la cosificación mediante estándares estéticos inalcanzables y sexualizados,\n" +
                "y facilitar la creación no consensuada de imágenes explícitas que vulneran la dignidad de las mujeres."));
        preguntas.add(new Pregunta(10, "/imagenes/foto10.jpg", false, "Explicación: Si tu respuesta fue sí, sientete avergonzado, este es un clásico, deberías salir menos."));
    }

    public Pregunta obtenerPreguntaActual() {
        if (indiceActual < preguntas.size()) {
            return preguntas.get(indiceActual);
        }
        return null;
    }

    public boolean evaluarRespuesta(boolean respuestaUsuario) {
        Pregunta actual = obtenerPreguntaActual();
        if (actual != null) {
            boolean correcta = actual.esRespuestaCorrecta(respuestaUsuario);
            if (correcta) {
                this.puntaje += 10;
            }
            return correcta;
        }
        return false;
    }

    public void avanzarSiguientePregunta() {
        if (indiceActual < preguntas.size() - 1) {
            indiceActual++;
        }
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