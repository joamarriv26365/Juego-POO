public class juego {
    private Preguntas pregunta;
    private int preguntaactual;
    private Preguntas[] preguntas;
    private Usuario[] usuarios;
    private Usuario usuarioActual;
    private int cantidadUsuarios;

    public juego() {
        infojuego informacion = new infojuego();
        preguntas = informacion.cargarPreg();
        preguntaactual = 0;
        pregunta = preguntas[preguntaactual];
        usuarios = new Usuario[10];
        cantidadUsuarios = 0;
        usuarioActual = null;
    }

    public boolean agregarUsuario(String nombre) {
        if (cantidadUsuarios < usuarios.length) {
            usuarios[cantidadUsuarios] = new Usuario(nombre);
            cantidadUsuarios++;
            return true;
        } 
        else {
            return false;
        }
    }

    public Usuario obtenerUsuario(int posicion) {
        if (posicion >= 0 && posicion < cantidadUsuarios) {
            return usuarios[posicion];
        }
        return null;
    }

    public boolean iniciarUsuario(int posicion) {
        if (posicion >= 0 && posicion < cantidadUsuarios) {
            usuarioActual = usuarios[posicion];
            preguntaactual = 0;
            pregunta = preguntas[preguntaactual];
            return true;
        }
        else{
            return false;
        }
    }

    public Preguntas obtenerPreguntaActual() {
        return pregunta;
    }

    public boolean respuesta(boolean respuesta) {
        return pregunta.verRespuesta(respuesta);
    }

    public void aumentarPuntaje() {
        if (usuarioActual != null) {
            usuarioActual.aumentarPuntaje();
        }
    }

    public boolean siguiente() {
        preguntaactual++;
        if (preguntaactual < preguntas.length) {
            pregunta = preguntas[preguntaactual];
            return true;
        } 
        else {
            return false;
        }
    }

    public boolean fin() {
        return preguntaactual >= preguntas.length;
    }

    public int getPuntaje() {
        if (usuarioActual != null) {
            return usuarioActual.getPuntaje();
        }
        return 0;
    }

    public int getPreguntaActual() {
        return preguntaactual;
    }

    public Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public Usuario[] getUsuarios() {
        return usuarios;
    }

    public int getCantidadUsuarios() {
        return cantidadUsuarios;
    }
}