import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Juego {
    private String nombreJugador;
    private ArrayList<Pregunta> preguntas;
    private int indiceActual;
    private int puntaje;
    private final String RUTA_TXT = "preguntas.txt";
