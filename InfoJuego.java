public class InfoJuego {
    private String acercaDelProyecto;
    private String instruccionesPregunta;

    public InfoJuego() {
        this.acercaDelProyecto =
                "=========================================================================\n" +
                        "                    ACERCA DEL PROYECTO Y SU PROPÓSITO                    \n" +
                        "=========================================================================\n" +
                        "Bienvenido al Evaluador de Contenido Generado por Inteligencia Artificial.\n\n" +
                        "El objetivo de este proyecto no es lograr una inmunidad total ni pretender reconocer\n" +
                        "absolutamente todo lo generado por IA, ya que los modelos son cada vez más efectivos\n" +
                        " al replicar la realidad.\n\n" +
                        "El propósito de esta pequeña actividad es que comprendas qué situaciones y contextos\n" +
                        "deben encender tus alarmas para desarrollar el pensamiento crítico suficiente,\n" +
                        "aprender a dudar de lo que ves, lidiar con estas tecnologías y evitar problemas.\n\n" +
                        "¿Cómo funciona la evaluación?\n" +
                        "1. Observa la imagen.\n" +
                        "2. Analiza la posibilidad de que sea real o no.\n" +
                        "3. Elige la opción que consideres correcta..\n" +
                        "4. Ve la explicación detallada para comprender el contexto.\n" +
                        "-------------------------------------------------------------------------";
        this.instruccionesPregunta =
                "Para cada pregunta se le dara la opción de decidir si la imagen fue generada con IA o no y debe reponder:\n" +
                        "1. Sí (Es IA)\n" +
                        "2. No (Es Humano)";
    }

    public String getAcercaDelProyecto() {
        return acercaDelProyecto;
    }

    public String getInstruccionesPregunta() {
        return instruccionesPregunta;
    }

    public void setAcercaDelProyecto(String acercaDelProyecto) {
        this.acercaDelProyecto = acercaDelProyecto;
    }

    public void setInstruccionesPregunta(String instruccionesPregunta) {
        this.instruccionesPregunta = instruccionesPregunta;
    }
}
