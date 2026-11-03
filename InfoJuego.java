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
        this.acercaDelProyecto = "";
        this.instruccionesPregunta = "";
        cargarInfoDesdeTXT();
    }
    
    private void cargarInfoDesdeTXT() {
        File archivo = new File(RUTA_TXT);
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(archivo),
                        StandardCharsets.UTF_8))) {

            String linea;
            StringBuilder acercaBuilder = new StringBuilder();
            StringBuilder instBuilder = new StringBuilder();
            String seccionActual = "";

            while ((linea = br.readLine()) != null) {
                String lineaTrim = linea.trim();
                
                if (lineaTrim.equals("[ACERCA]")) {
                    seccionActual = "ACERCA";
                    continue;
                    
                } else if (lineaTrim.equals("[INSTRUCCIONES]")) {
                    seccionActual = "INSTRUCCIONES";
                    continue;
                }

                if (seccionActual.equals("ACERCA")) {
                    acercaBuilder.append(linea).append("\n");

                } else if (seccionActual.equals("INSTRUCCIONES")) {
                    instBuilder.append(linea).append("\n");

                }

            }

            this.acercaDelProyecto = acercaBuilder.toString().trim().replace("\\n", "\n");
            this.instruccionesPregunta = instBuilder.toString().trim().replace("\\n", "\n");

        } catch (Exception e) {

            System.err.println("Error leyendo info.txt: " + e.getMessage());

        }

    }
    public String getAcercaDelProyecto() {
        return acercaDelProyecto;
    }

    public String getInstruccionesPregunta() {
        return instruccionesPregunta;
    }
    

}
