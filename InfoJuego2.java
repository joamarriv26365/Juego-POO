public class InfoJuego {

    private String acercaDelProyecto;
    private String instruccionesPregunta;

    public InfoJuego() {
        this.acercaDelProyecto = 
            "=========================================================================\n" +
            "                ¿CÓMO INICIAR A JUGAR?                 \n" +
            "=========================================================================\n" +
            "¡Bienvenido a IAdetector!\n\n" +
            "El objetivo principal de este proyecto es poner a prueba el criterio del usuario\n" +
            "al identificar recursos e imágenes visuales creadas mediante IA\n" +
            "generativa compararadas con fotografías e ilustraciones reales de origen humano.\n\n" +
            "¿Cómo funciona la evaluación?\n" +
            "1. Observa el recurso o imagen asignada en cada pregunta.\n" +
            "2. Analiza patrones como sombras, texturas, simetría en rostros o bordes.\n" +
            "3. Ingresa tu respuesta marcando únicamente la opción 1 (Es IA) o 2 (Es contenido real).\n" +
            "4. En caso de ingresar una opción distinta o un caracter no permitido, el programa\n" +
            "   te indicará que la opción no es válida y te permitirá responder de nuevo\n" +
            "   SIN afectarte la puntuación ni marcar la pregunta como incorrecta.\n\n" +
            "¡Aprende a identificar indicios visuales y mejora tus habilidades de análisis!\n" ;

        this.instruccionesPregunta = 
            "¿Este contenido fue creado por Inteligencia Artificial?\n" +
            "1. Sí (Es IA)\n" +
            "2. No (es contenido real)";
    }

    public String getAcercaDelProyecto() {
        return acercaDelProyecto;
    }

    public String getInstruccionesPregunta() {
        return instruccionesPregunta;
    }
}
