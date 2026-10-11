public class InfoJuego { // Define la clase InfoJuego. Si se elimina, las demás clases no podrán encontrar esta definición estructural.
    private String acercaDelProyecto; // Declara una variable privada para el texto del proyecto. Si se elimina, no se podrá almacenar esta información.
    private String instruccionesPregunta; // Declara una variable privada para las instrucciones. Si se elimina, no se guardarán las directrices.

    public InfoJuego() { // Constructor de la clase que inicializa los textos. Si se elimina, la creación de instancias fallará.
        this.acercaDelProyecto =  // Asigna el texto descriptivo del proyecto. Si se elimina, la introducción institucional quedará vacía.
                "=========================================================================\n" +
                        "                    ACERCA DEL PROYECTO Y SU PROPÓSITO                    \n" +
                        "=========================================================================\n" +
                        "Bienvenido al Evaluador de Contenido Generado por Inteligencia Artificial.\n\n" +
                        "El objetivo principal de este proyecto es poner a prueba el criterio del usuario\n" +
                        "al identificar recursos e imágenes visuales creadas mediante algoritmos de IA\n" +
                        "generativa frente a fotografías e ilustraciones reales de origen humano.\n\n" +
                        "¿Cómo funciona la evaluación?\n" +
                        "1. Observa el recurso o imagen asignada en cada pregunta.\n" +
                        "2. Analiza patrones como sombras, texturas, simetría en rostros o bordes.\n" +
                        "3. Ingresa tu respuesta marcando la opción A (Es IA) o B (Es Humano).\n" +
                        "-------------------------------------------------------------------------";

        this.instruccionesPregunta =  // Asigna las instrucciones que se muestran en cada pregunta. Si se elimina, el texto guía no existirá.
                "¿Este contenido fue creado por Inteligencia Artificial?\n" +
                        "A. Sí (Es IA)\n" +
                        "B. No (Es Humano)";
    }

    public String getAcercaDelProyecto() { // Método getter para obtener el texto del proyecto. Si se elimina, el exterior no podrá leerlo.
        return acercaDelProyecto; // Devuelve la cadena almacenada. Si se elimina, el método retornará null.
    }

    public String getInstruccionesPregunta() { // Método getter para las instrucciones. Si se elimina, no se podrán consultar desde afuera.
        return instruccionesPregunta; // Devuelve la cadena de instrucciones. Si se elimina, el método retornará null.
    }
}
