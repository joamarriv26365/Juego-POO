public class Infojuego {// Define la clase InfoJuego. Si se elimina, las demás clases no podrán encontrar esta definición estructural.
  private String acercaDelProyecto; // Declara un atributo privado para el texto del proyecto. Si se elimina, no se podrá almacenar esta información.
  private String instruccionesPregunta; // Declara un atributo privado para las instrucciones. Si se elimina, no se guardarán las directrices.

  public Infojuego(){ // Constructor de la clase que inicializa los textos. Si se elimina, la creación de instancias fallará.
    this.acercaDelProyecto =  // muestra y almacena el texto e instrucciones para el usuario. Si se elimina, la introducción del programa quedará vacía.
                        "                    ACERCA DEL PROYECTO Y SU PROPÓSITO                    \n" +
                        "Bienvenido al Evaluador de Contenido Generado por Inteligencia Artificial.\n\n" +
                        "El objetivo principal de este proyecto es poner a prueba el criterio del usuario\n" +
                        "al identificar recursos e imágenes visuales creadas mediante algoritmos de IA\n" +
                        "generativa frente a fotografías e ilustraciones reales de origen humano.\n\n" +
                        "¿Cómo funciona la evaluación?\n" +
                        "1. Observa el recurso o imagen asignada en cada pregunta.\n" +
                        "2. Analiza patrones como sombras, texturas, simetría en rostros o bordes.\n" +
                        "3. Ingresa tu respuesta marcando la opción 1 (Es IA) o 2 (Es Humano).\n";
  // muestra y almacena la pregunta y sus dos opciones de respuesta. Si se elimina, el texto guía no existirá.
        this.instruccionesPregunta =
                "¿Este contenido fue creado por Inteligencia Artificial?\n" +
                        "1. Sí (Es IA)\n" +
                        "2. No (Es Humano)";
    }
   
    public String getAcercaDelProyecto() { // Método getter para obtener el texto del proyecto. Si se elimina, el usuario no podrá leerlo.
        return acercaDelProyecto; // Devuelve lo almacenado. Si se elimina, el método retornará null.
    }
  
    public String getInstruccionesPregunta() { // Método getter para las instrucciones. Si se elimina, el usuario no podrá leerlo.
        return instruccionesPregunta; // Devuelve la pregunta almacenada. Si se elimina, el método retornará null.
    }
}
