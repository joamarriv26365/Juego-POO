import java.util.ArrayList; // Importa la clase ArrayList para manejar colecciones dinámicas. Si se elimina, no se podrá crear la lista de preguntas.

public class Juego { // Define la clase principal de la lógica del negocio. Si se elimina, la aplicación pierde la gestión de estado y reglas.
    private String nombreJugador; // Almacena el nombre del usuario actual. Si se elimina, el sistema no recordará quién está jugando.
    private ArrayList<Pregunta> preguntas; // Lista que almacena el conjunto de objetos Pregunta. Si se elimina, el cuestionario no tendrá banco de preguntas.
    private int indiceActual; // Controla en qué pregunta va el usuario. Si se elimina, el flujo de preguntas se descontrolará.
    private int puntaje; // Acumulador de puntos del jugador. Si se elimina, el marcador no funcionará.

    public Juego(String nombreJugador) { // Constructor que inicializa los valores de la partida. Si se elimina, no se podrá instanciar el juego.
        this.nombreJugador = nombreJugador; // Asigna el nombre recibido. Si se elimina, el nombre no se guardará.
        this.indiceActual = 0; // Configura el inicio en la primera pregunta (índice 0). Si se elimina, el índice inicial sería impredecible.
        this.puntaje = 0; // Inicializa el puntaje en cero. Si se elimina, la puntuación contendrá valores erróneos.
        this.preguntas = new ArrayList<>(); // Instancia el arreglo dinámico de preguntas. Si se elimina, lanzará error al intentar agregar elementos.
        cargarPreguntasReales(); // Llama al método que llena las preguntas. Si se elimina, el juego no tendrá contenido.
    }

    private void cargarPreguntasReales() { // Método privado para poblar las 10 preguntas y sus rutas. Si se elimina, la lista de preguntas estará vacía.
        preguntas.add(new Pregunta(1, "/imagenes/foto1.jpg", true, "Explicación 1..."));
        preguntas.add(new Pregunta(2, "/imagenes/foto2.jpg", false, "Explicación 2..."));
        preguntas.add(new Pregunta(3, "/imagenes/foto3.jpg", true, "Explicación 3..."));
        preguntas.add(new Pregunta(4, "/imagenes/foto4.jpg", false, "Explicación 4..."));
        preguntas.add(new Pregunta(5, "/imagenes/foto5.jpg", true, "Explicación 5..."));
        preguntas.add(new Pregunta(6, "/imagenes/foto6.jpg", false, "Explicación 6..."));
        preguntas.add(new Pregunta(7, "/imagenes/foto7.jpg", true, "Explicación 7..."));
        preguntas.add(new Pregunta(8, "/imagenes/foto8.jpg", false, "Explicación 8..."));
        preguntas.add(new Pregunta(9, "/imagenes/foto9.jpg", true, "Explicación 9..."));
        preguntas.add(new Pregunta(10, "/imagenes/foto10.jpg", false, "Explicación 10..."));
    }

    public Pregunta obtenerPreguntaActual() { // Método para obtener la pregunta activa según el índice. Si se elimina, la vista no sabrá qué mostrar.
        if (indiceActual < preguntas.size()) { // Verifica que el índice no rebase el tamaño de la lista. Si se elimina, puede causar desbordamiento de memoria.
            return preguntas.get(indiceActual); // Retorna el objeto Pregunta actual. Si se elimina, no habrá devolución de datos.
        }
        return null; // Retorna nulo si ya no hay preguntas. Si se elimina, fallará la validación de fin de juego.
    }

    public boolean evaluarEleccionUsuario(char letraOpcion) { // Evalúa la letra elegida ('A' o 'B') y actualiza el puntaje. Si se elimina, no se sabrá si acertó.
        Pregunta actual = obtenerPreguntaActual(); // Obtiene la pregunta en curso. Si se elimina, no habrá objeto que evaluar.
        if (actual == null) return false; // Si es nulo, retorna falso por seguridad. Si se elimina, lanzará error de apuntador nulo.

        boolean respuestaUsuario = (Character.toUpperCase(letraOpcion) == 'A'); // Traduce 'A' a true (Es IA) y 'B' a false (Es Humano). Si se elimina, no se interpretará la opción.
        boolean esCorrecta = actual.esRespuestaCorrecta(respuestaUsuario); // Comprueba el acierto. Si se elimina, no se validará la respuesta.

        if (esCorrecta) { // Si el usuario acertó. Si se elimina, no se sumarán puntos.
            this.puntaje += 10; // Suma 10 puntos al acumulador. Si se elimina, el puntaje se quedará en cero.
        }
        return esCorrecta; // Retorna si fue correcta o no. Si se elimina, no habrá valor de retorno.
    }

    public void avanzarJuego() { // Incrementa el índice para pasar a la siguiente pregunta. Si se elimina, el juego se quedará estancado.
        if (indiceActual < preguntas.size() - 1) { // Verifica si aún hay más preguntas. Si se elimina, se intentarán buscar índices inexistentes.
            indiceActual++; // Suma uno al índice. Si se elimina, la partida no avanzará.
        }
    }

    public boolean estaFinalizado() { // Método para comprobar si se llegó al final del cuestionario. Si se elimina, la app no sabrá cuándo terminar.
        return indiceActual >= preguntas.size() - 1; // Retorna true si el índice alcanzó el límite. Si se elimina, el juego no terminará nunca.
    }

    public int getPuntaje() { return puntaje; } // Getter del puntaje. Si se elimina, la pantalla final no podrá leer los puntos.
    public int getIndiceActual() { return indiceActual; } // Getter del índice actual. Si se elimina, no se podrá calcular el progreso.
    public int getTotalPreguntas() { return preguntas.size(); } // Getter del total de preguntas. Si se elimina, se desconoce el tamaño del juego.
    public String getNombreJugador() { return nombreJugador; } // Getter del nombre. Si se elimina, las vistas no podrán saludar al usuario.
}