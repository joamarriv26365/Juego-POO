    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InfoJuego info = new InfoJuego();
        boolean ejecutando = true;

        while (ejecutando) {
            System.out.println("\n==================================================");
            System.out.println("   === IA detector ===");
            System.out.println("==================================================");
            System.out.println("1. Iniciar Juego");
            System.out.println("2. Acerca del Proyecto");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");

            int opcionMenu = 0;
            try {
                opcionMenu = scanner.nextInt();
                if (opcionMenu < 1 || opcionMenu > 3) {
                    System.out.println(" Esa no es una opción válida. elige un numero del 1 al 3");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("ERROR: Entrada no válida. Ingresa únicamente un número.");
                scanner.nextLine(); 
                continue;
            }

           
            if (opcionMenu == 1) {
                System.out.println("\n--- CONFIGURACIÓN DE LA PARTIDA ---");
                System.out.print("Ingresa tu usuario: ");
                scanner.nextLine(); 
                String nombre = scanner.nextLine();

                Juego partida = new Juego(nombre);
                boolean jugando = true;

                while (jugando) {
                    Pregunta pregunta = partida.obtenerPreguntaActual();

                    System.out.println("\n--------------------------------------------------");
                    System.out.println("Pregunta " + (partida.getNumPregunta() + 1) + " de " + partida.getTotalPreguntas());
                    System.out.println("Recurso visual a evaluar: " + pregunta.getRutaImagen());
                    System.out.println(info.getInstruccionesPregunta());

                    
                    int opcionRespuesta = 0;
                    boolean respuestaValida = false;

                    while (!respuestaValida) {
                        System.out.print("Elige una opción (1 o 2): ");
                        try {
                            opcionRespuesta = scanner.nextInt();
                            if (opcionRespuesta == 1 || opcionRespuesta == 2) {
                                respuestaValida = true;
                            } else {
                                System.out.println(" Esa no es una opción válida. Por favor ingresa 1 o 2.");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("ERROR: Entrada no válida (debes ingresar un número).");
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
                                System.out.println("Esa no es una opción válida. Por favor ingresa 1 o 2.");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("ERROR: Entrada no válida (debes ingresar un número).");
                            scanner.nextLine();
                        }
                    }

                    if (verRetro == 1) {
                        System.out.println("\n--- RETROALIMENTACIÓN ---");
                        System.out.println(pregunta.getRetroalimentacion());
                        System.out.println("-----------------------------------");
                    }

                
                    if (!partida.estaFinalizado()) {
                        partida.avanzarSiguientePregunta();
                        System.out.println("\nSiguiente pregunta");
                    } else {
                        jugando = false;
                        System.out.println("\n==================================================");
                        System.out.println("FIN DE LA PARTIDA.");
                        System.out.println("Jugador: " + partida.getNombreJugador());
                        System.out.println("Puntaje Final Conseguido: " + partida.getPuntaje() + " / " + (partida.getTotalPreguntas() * 10) + " pts");
                        System.out.println("==================================================");
                    }
                }

           
            } else if (opcionMenu == 2) {
                System.out.println("\n" + info.getAcercaDelProyecto());
                System.out.println("1. Volver al Menú Principal");
                
                boolean opcionAcercaValida = false;
                while (!opcionAcercaValida) {
                    System.out.print("Elige una opción: ");
                    try {
                        int optAcerca = scanner.nextInt();
                        if (optAcerca == 1) {
                            opcionAcercaValida = true;
                        } else {
                            System.out.println("Esa no es una opción válida. Ingresa 1.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("ERROR: Entrada no válida.");
                        scanner.nextLine();
                    }
                }

            } else if (opcionMenu == 3) {
                System.out.println("\n¡Gracias por jugar!");
                ejecutando = false;
            }
        }

        scanner.close();
    }
