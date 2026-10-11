public class Pregunta { // Define la clase Pregunta para modelar cada ítem. Si se elimina, el sistema pierde la estructura de datos individual.
    private int numero; // Variable para almacenar el número de orden de la pregunta. Si se elimina, no se podrá rastrear su posición.
    private String rutaImagen; // Variable para guardar la ruta del archivo de imagen. Si se elimina, la GUI no sabrá qué archivo buscar.
    private boolean esIA; // Bandera booleana (true si es IA, false si es Humano). Si se elimina, no habrá respuesta correcta definida.
    private String retroalimentacion; // Texto explicativo de la respuesta. Si se elimina, no se mostrará el porqué de la respuesta.

    public Pregunta(int numero, String rutaImagen, boolean esIA, String retroalimentacion) { // Constructor para inicializar los atributos de la pregunta. Si se elimina, no se podrán crear instancias con datos.
        this.numero = numero; // Asigna el parámetro número al atributo de la clase. Si se elimina, el número no se guardará.
        this.rutaImagen = rutaImagen; // Asigna la ruta de la imagen. Si se elimina, la ruta se perderá.
        this.esIA = esIA; // Asigna el valor booleano de verificación. Si se elimina, la solución correcta no se registrará.
        this.retroalimentacion = retroalimentacion; // Asigna la explicación detallada. Si se elimina, la retroalimentación quedará vacía.
    }

    public boolean esRespuestaCorrecta(boolean respuestaUsuario) { // Método para evaluar si la respuesta del usuario coincide con la realidad. Si se elimina, no se podrá validar el acierto.
        return this.esIA == respuestaUsuario; // Compara la respuesta interna con la del usuario y retorna el resultado. Si se elimina, no habrá validación.
    }

    public int getNumero() { // Método para consultar el número de pregunta. Si se elimina, no se podrá leer externamente.
        return numero; // Retorna el valor entero. Si se elimina, no habrá retorno.
    }

    public String getRutaImagen() { // Método para obtener la ruta de la imagen. Si se elimina, la interfaz no podrá cargar el archivo gráfico.
        return rutaImagen; // Retorna la cadena de texto de la ruta. Si se elimina, retornará null.
    }

    public String getRetroalimentacion() { // Método para obtener la explicación. Si se elimina, no se podrá mostrar la justificación.
        return retroalimentacion; // Retorna la cadena de retroalimentación. Si se elimina, retornará null.
    }
}
