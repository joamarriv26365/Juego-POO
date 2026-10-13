public class Infojuego {
  private String acercaDelProyecto;
  private String instruccionesPregunta;

  public Infojuego(){
    this.acercaDelProyecto = "=========================================================================\n" +  // muestra el texto 
                        "                    ACERCA DEL PROYECTO Y SU PROPÓSITO                    \n" +
                        "=========================================================================\n" +
                        "Bienvenido al Evaluador de Contenido Generado por Inteligencia Artificial.\n\n" +
                        "El objetivo principal de este proyecto es poner a prueba el criterio del usuario\n" +
                        "al identificar recursos e imágenes visuales creadas mediante algoritmos de IA\n" +
                        "generativa frente a fotografías e ilustraciones reales de origen humano.\n\n" +
                        "¿Cómo funciona la evaluación?\n" +
                        "1. Observa el recurso o imagen asignada en cada pregunta.\n" +
                        "2. Analiza patrones como sombras, texturas, simetría en rostros o bordes.\n" +
                        "3. Ingresa tu respuesta marcando la opción 1 (Es IA) o 2 (Es Humano).\n" +
                        "-------------------------------------------------------------------------";
  // muestra la pregunta y sus dos opciones de respuesta
        this.instruccionesPregunta =
                "¿Este contenido fue creado por Inteligencia Artificial?\n" +
                        "1. Sí (Es IA)\n" +
                        "2. No (Es Humano)";
    }
    // Cambia la visibilidad del atributo  y devuelve el texto que explica el proyecto
    public String getAcercaDelProyecto() {
        return acercaDelProyecto;
    }
    // Cambia la visibilidad del atributo devuelve el texto que explica las intrucciones del proyecto
    public String getInstruccionesPregunta() {
        return instruccionesPregunta;
    }
}
