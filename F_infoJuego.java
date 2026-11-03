import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class InfoJuego {
    private String acercaDelProyecto;
    private String instruccionesPregunta;
     private final String RUTA_TXT = "info.txt";

    public InfoJuego() {
        this.acercaDelProyecto = "Información institucional no cargada.";
        this.instruccionesPregunta = "¿Este contenido fue creado por Inteligencia Artificial?\nA. Sí\nB. No";
        cargarInfoDesdeTXT();
    }

    private void cargarInfoDesdeTXT() {
        File archivo = new File(RUTA_TXT);
        // Valida si el archivo existe antes de intentar leerlo
        if (!archivo.exists()) {
            System.out.println("No se encontró el archivo info.txt en la raíz del proyecto.");
            return;
        }
        // Lee el archivo línea por línea usando codificación UTF-8 para evitar errores con tildes
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(archivo), StandardCharsets.UTF_8))) {
            String linea;
            StringBuilder acercaBuilder = new StringBuilder();
            StringBuilder instBuilder = new StringBuilder();
            String seccionActual = "";

            while ((linea = br.readLine()) != null) {
                String lineaTrim = linea.trim();
                // Detecta las etiquetas para cambiar de sección según el contenido del archivo
                if (lineaTrim.equals("[ACERCA]")) {
                    seccionActual = "ACERCA";
                    continue;
                } else if (lineaTrim.equals("[INSTRUCCIONES]")) {
                    seccionActual = "INSTRUCCIONES";
                    continue;
                }
                // Agrega el texto a su respectivo acumulador según la sección activa
                if (seccionActual.equals("ACERCA")) {
                    acercaBuilder.append(linea).append("\n");
                } else if (seccionActual.equals("INSTRUCCIONES")) {
                    instBuilder.append(linea).append("\n");
                }
            }
            // Guarda el texto acumulado en las variables de la clase si contienen datos
            if (acercaBuilder.length() > 0) {
                this.acercaDelProyecto = acercaBuilder.toString().trim().replace("\\n", "\n");
            }
            if (instBuilder.length() > 0) {
                this.instruccionesPregunta = instBuilder.toString().trim().replace("\\n", "\n");
            }

        } catch (Exception e) {
            System.err.println("Error leyendo info.txt: " + e.getMessage());
        }
    }

    // Getters y Setters completos
    public String getAcercaDelProyecto() { return acercaDelProyecto; }
    public void setAcercaDelProyecto(String acercaDelProyecto) { this.acercaDelProyecto = acercaDelProyecto; }
    public void setInstruccionesPregunta(String instruccionesPregunta) { this.instruccionesPregunta = instruccionesPregunta; }
    public String getInstruccionesPregunta() { return instruccionesPregunta; }


}
