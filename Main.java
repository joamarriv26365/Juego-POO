import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InfoJuego info = new InfoJuego();
        boolean ejecutando = true;

        while (ejecutando) {
            System.out.println("\n==================================================");
            System.out.println("   === EVALUADOR DE CONTENIDO GENERADO POR IA ===");
            System.out.println("==================================================");
            System.out.println("1. Iniciar Juego");
            System.out.println("2. Acerca del Proyecto");
            System.out.println("3. Salir");
            System.out.print("Elige una opción (1-3): ");

            int opcionMenu = 0;
            try {
                opcionMenu = scanner.nextInt();
                if (opcionMenu < 1 || opcionMenu > 3) {
                    System.out.println("[!] Esa no es una opción válida. Debe ser entre 1 y 3.");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("[!] ERROR: Entrada no válida. Ingresa únicamente un número.");
                scanner.nextLine(); // Limpiar búfer
                continue;
            }

            // OPCIÓN 1: INICIAR JUEGO
            if (opcionMenu == 1) {
                System.out.println("\n--- CONFIGURACIÓN DE LA PARTIDA ---");
                System.out.print("Ingresa tu nombre de jugador: ");
                scanner.nextLine(); // Limpiar salto de línea previo
                String nombre = scanner.nextLine();

                Juego partida = new Juego(nombre);
                boolean jugando = true;

                while (jugando) {
                    Pregunta pregunta = partida.obtenerPreguntaActual();

                    System.out.println("\n--------------------------------------------------");
                    System.out.println("Pregunta " + (partida.getIndiceActual() + 1) + " de " + partida.getTotalPreguntas());
                    System.out.println("Recurso visual a evaluar: " + pregunta.getRutaImagen());
                    System.out.println(info.getInstruccionesPregunta());

                    // VALIDACIÓN DE LA RESPUESTA
                    int opcionRespuesta = 0;
                    boolean respuestaValida = false;

                    while (!respuestaValida) {
                        System.out.print("Elige una opción (1 o 2): ");
                        try {
                            opcionRespuesta = scanner.nextInt();
                            if (opcionRespuesta == 1 || opcionRespuesta == 2) {
                                respuestaValida = true;
                            } else {
                                System.out.println("[!] Esa no es una opción válida. Por favor ingresa 1 o 2.");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("[!] ERROR: Entrada no válida (debes ingresar un número).");
                            scanner.nextLine();
                        }
                    }

                    boolean respuestaUsuario = (opcionRespuesta == 1);
                    boolean esCorrecta = partida.evaluarRespuesta(respuestaUsuario);

                    if (esCorrecta) {
                        System.out.println("\n[RESULTADO]: ¡CORRECTO! Has ganado 10 puntos.");
                    } else {
                        System.out.println("\n[RESULTADO]: INCORRECTO. No has sumado puntos.");
                    }

                    System.out.println("Puntaje acumulado de " + partida.getNombreJugador() + ": " + partida.getPuntaje() + " pts");

                    // VALIDACIÓN DE RETROALIMENTACIÓN
                    System.out.println("\n¿Deseas ver la retroalimentación e indicios de esta imagen?");
                    System.out.println("1. Sí");
                    System.out.println("2. No");

                    int verRetro = 0;
                    boolean retroValida = false;

                    while (!retroValida) {
                        System.out.print("Elige una opción (1 o 2): ");
                        try {
                            verRetro = scanner.nextInt();
                            if (verRetro == 1 || verRetro == 2) {
                                retroValida = true;
                            } else {
                                System.out.println("[!] Esa no es una opción válida. Por favor ingresa 1 o 2.");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("[!] ERROR: Entrada no válida (debes ingresar un número).");
                            scanner.nextLine();
                        }
                    }

                    if (verRetro == 1) {
                        System.out.println("\n--- RETROALIMENTACIÓN E INDICIOS ---");
                        System.out.println(pregunta.getRetroalimentacion());
                        System.out.println("-----------------------------------");
                    }

                    // AVANZAR O FINALIZAR
                    if (!partida.estaFinalizado()) {
                        partida.avanzarSiguientePregunta();
                        System.out.println("\nAvanzando a la siguiente pregunta...");
                    } else {
                        jugando = false;
                        System.out.println("\n==================================================");
                        System.out.println("¡LA PARTIDA HA FINALIZADO!");
                        System.out.println("Jugador: " + partida.getNombreJugador());
                        System.out.println("Puntaje Final Conseguido: " + partida.getPuntaje() + " / " + (partida.getTotalPreguntas() * 10) + " pts");
                        System.out.println("==================================================");
                    }
                }

            // OPCIÓN 2: ACERCA DEL PROYECTO
            } else if (opcionMenu == 2) {
                System.out.println("\n" + info.getAcercaDelProyecto());
                System.out.println("1. Volver al Menú Principal");
                
                boolean opcionAcercaValida = false;
                while (!opcionAcercaValida) {
                    System.out.print("Elige una opción (1): ");
                    try {
                        int optAcerca = scanner.nextInt();
                        if (optAcerca == 1) {
                            opcionAcercaValida = true;
                        } else {
                            System.out.println("[!] Esa no es una opción válida. Ingresa 1.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("[!] ERROR: Entrada no válida.");
                        scanner.nextLine();
                    }
                }

            // OPCIÓN 3: SALIR
            } else if (opcionMenu == 3) {
                System.out.println("\n¡Gracias por utilizar el evaluador! Hasta pronto.");
                ejecutando = false;
            }
        }

        scanner.close();
    }
}