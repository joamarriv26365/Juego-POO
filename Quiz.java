import java.awt.event.*; // Importa clases para el manejo de eventos de clic y acciones. Si se elimina, no se podrán procesar clics en botones.
import java.awt.*; // Importa herramientas gráficas de AWT como Color, Font e Image. Si se elimina, fallarán las definiciones visuales.
import javax.swing.*; // Importa componentes de interfaz gráfica de Java Swing (JFrame, JButton, JLabel, etc.). Si se elimina, la GUI no se dibujará.

public class Quiz implements ActionListener { // Define la clase Quiz implementando ActionListener para escuchar botones. Si se elimina, no se podrán registrar interacciones de usuario.

    private Juego juego; // Declara la instancia de la lógica del negocio. Si se elimina, la interfaz pierde acceso al modelo de datos.
    private InfoJuego info = new InfoJuego(); // Instancia la clase de textos institucionales. Si se elimina, no se podrán consultar las instrucciones.

    JFrame frame = new JFrame(); // Crea la ventana principal de la aplicación. Si se elimina, no existirá el contenedor gráfico.
    JTextField textfield = new JTextField(); // Crea el campo de texto superior para el número de pregunta. Si se elimina, no habrá barra de título.
    JTextArea textarea = new JTextArea(); // Crea el área de texto para las instrucciones. Si se elimina, el enunciado guía no se mostrará.
    JLabel etiquetaImagen = new JLabel(); // Crea la etiqueta contenedora para las fotos. Si se elimina, las imágenes no aparecerán en pantalla.
    JButton buttonA = new JButton(); // Crea el botón de opción A. Si se elimina, faltará la alternativa de respuesta A.
    JButton buttonB = new JButton(); // Crea el botón de opción B. Si se elimina, faltará la alternativa de respuesta B.
    JLabel answer_labelA = new JLabel(); // Crea la etiqueta de descripción para la opción A. Si se elimina, el texto del botón A no se verá.
    JLabel answer_labelB = new JLabel(); // Crea la etiqueta de descripción para la opción B. Si se elimina, el texto del botón B no se verá.
    JLabel time_label = new JLabel(); // Crea la etiqueta decorativa del temporizador. Si se elimina, no se mostrará el rótulo del cronómetro.
    JLabel seconds_left = new JLabel(); // Crea el cuadro numérico del tiempo restante. Si se elimina, el usuario no verá el reloj disminuir.
    JTextField number_right = new JTextField(); // Crea el campo para mostrar aciertos finales. Si se elimina, no se verán las estadísticas de cierre.
    JTextField percentage = new JTextField(); // Crea el campo para mostrar el porcentaje de efectividad. Si se elimina, no se calculará el porcentaje final.

    int seconds = 10; // Variable que almacena los segundos límite por pregunta (10s). Si se elimina, fallará la cuenta regresiva.

    Timer timer = new Timer(1000, new ActionListener() { // Configura un temporizador que se dispara cada 1000ms (1 segundo). Si se elimina, el cronómetro no correrá.
        @Override
        public void actionPerformed(ActionEvent e) { // Método ejecutado en cada pulso del timer. Si se elimina, no se actualizará el tiempo.
            seconds--; // Decrementa un segundo al contador. Si se elimina, el tiempo se quedará estático.
            seconds_left.setText(String.valueOf(seconds)); // Actualiza el texto visual del reloj. Si se elimina, la etiqueta no reflejará el cambio.
            if (seconds <= 0) { // Verifica si el tiempo se agotó (llegó a 0). Si se elimina, el tiempo pasaría a números negativos indefinidamente.
                procesarRespuestaGUI(' '); // Simula respuesta vacía por tiempo agotado. Si se elimina, el juego se trabaría al acabarse el tiempo.
            }
        }
    });

    public Quiz(String nombreJugador) { // Constructor que recibe el nombre y construye la interfaz gráfica. Si se elimina, la ventana no podrá inicializarse.
        juego = new Juego(nombreJugador); // Inicializa el objeto de lógica con el nombre del usuario. Si se elimina, la partida quedará sin motor de datos.

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Configura la operación al cerrar la ventana para finalizar el programa. Si se elimina, la app seguirá en segundo plano.
        frame.setSize(650, 750); // Establece las dimensiones de la ventana (650x750 px). Si se elimina, la ventana iniciará con tamaño mínimo predeterminado.
        frame.getContentPane().setBackground(new Color(50, 50, 50)); // Establece el color de fondo gris oscuro uniforme. Si se elimina, mostrará el gris estándar de sistema.
        frame.setLayout(null); // Desactiva layouts automáticos para posicionamiento absoluto. Si se elimina, los componentes se amontonarán.
        frame.setResizable(false); // Impide que el usuario redimensione la ventana. Si se elimina, se alterará el diseño visual al estirarla.

        textfield.setBounds(0, 0, 650, 50); // Ubica y dimensiona la barra superior de progreso. Si se elimina, el título superior no se dibujará.
        textfield.setBackground(new Color(25, 25, 25)); // Color de fondo casi negro para la barra. Si se elimina, tendrá fondo blanco.
        textfield.setForeground(new Color(25, 255, 0)); // Color de texto verde neón. Si se elimina, la letra será negra y se perderá con el fondo.
        textfield.setFont(new Font("Century Gothic", Font.PLAIN, 22)); // Define la fuente Century Gothic en estilo plano (sin negritas). Si se elimina, usará fuente por defecto.
        textfield.setBorder(BorderFactory.createBevelBorder(1)); // Añade un borde con relieve en bisel. Si se elimina, se verá como un cuadro plano sin profundidad.
        textfield.setHorizontalAlignment(JTextField.CENTER); // Centra el texto de la barra. Si se elimina, se alineará a la izquierda.
        textfield.setEditable(false); // Bloquea la edición manual del campo. Si se elimina, el usuario podría escribir en la barra de títulos.

        textarea.setBounds(20, 60, 600, 60); // Ubica y dimensiona el cuadro de instrucciones. Si se elimina, no se verá la guía textual.
        textarea.setBackground(new Color(25, 25, 25)); // Fondo oscuro del área de texto. Si se elimina, será blanco.
        textarea.setForeground(new Color(25, 255, 0)); // Letra verde neón brillante. Si se elimina, el texto será negro.
        textarea.setFont(new Font("Century Gothic", Font.PLAIN, 15)); // Tipografía Century Gothic plana. Si se elimina, usará fuente estándar del sistema.
        textarea.setLineWrap(true); // Activa el salto de línea automático. Si se elimina, el texto se saldrá de los límites laterales.
        textarea.setWrapStyleWord(true); // Evita cortar palabras a la mitad al saltar de línea. Si se elimina, partirá las palabras bruscamente.
        textarea.setEditable(false); // Impide que el usuario edite el texto de instrucciones. Si se elimina, se podrá modificar el enunciado.

        etiquetaImagen.setBounds(150, 130, 350, 220); // Coordenadas y dimensiones fijas para renderizar la foto. Si se elimina, el espacio visual no existirá.
        etiquetaImagen.setBorder(BorderFactory.createBevelBorder(1)); // Borde con relieve tridimensional. Si se elimina, la imagen flotará sin contorno visible.
        etiquetaImagen.setHorizontalAlignment(JLabel.CENTER); // Centra el contenido dentro de la etiqueta. Si se elimina, se alineará a la izquierda.

        buttonA.setBounds(20, 370, 80, 60); // Posición y tamaño del botón A. Si se elimina, el botón A no se mostrará en pantalla.
        buttonA.setFont(new Font("Century Gothic", Font.PLAIN, 25)); // Tipografía plana del botón A. Si se elimina, usará la fuente predeterminada.
        buttonA.setFocusable(false); // Remueve el recuadro de enfoque al hacer clic. Si se elimina, se verá un borde punteado molesto al presionarlo.
        buttonA.addActionListener(this); // Conecta el botón al escuchador de eventos. Si se elimina, hacer clic en A no producirá ninguna acción.
        buttonA.setText("A"); // Asigna la letra "A" al botón. Si se elimina, el botón quedará completamente vacío.

        buttonB.setBounds(20, 450, 80, 60); // Posición y tamaño del botón B. Si se elimina, el botón B no se mostrará en pantalla.
        buttonB.setFont(new Font("Century Gothic", Font.PLAIN, 25)); // Tipografía plana del botón B. Si se elimina, usará la fuente predeterminada.
        buttonB.setFocusable(false); // Remueve el recuadro de enfoque al hacer clic. Si se elimina, mostrará marco de selección al cliquear.
        buttonB.addActionListener(this); // Conecta el botón B al escuchador de eventos. Si se elimina, hacer clic en B no generará ninguna acción.
        buttonB.setText("B"); // Asigna la letra "B" al botón. Si se elimina, el botón quedará sin texto.

        answer_labelA.setBounds(115, 370, 500, 60); // Posición de la etiqueta descriptiva A. Si se elimina, no se verá el texto explicativo de la opción A.
        answer_labelA.setBackground(new Color(50, 50, 50)); // Fondo de la etiqueta descriptiva. Si se elimina, se transparentará con el panel.
        answer_labelA.setForeground(new Color(25, 255, 0)); // Texto verde brillante. Si se elimina, el texto por defecto será negro.
        answer_labelA.setFont(new Font("Century Gothic", Font.PLAIN, 18)); // Tipografía Century Gothic plana. Si se elimina, usará fuente predeterminada.

        answer_labelB.setBounds(115, 450, 500, 60); // Posición de la etiqueta descriptiva B. Si se elimina, no se verá el texto de la opción B.
        answer_labelB.setBackground(new Color(50, 50, 50)); // Fondo de la etiqueta descriptiva. Si se elimina, se transparentará.
        answer_labelB.setForeground(new Color(25, 255, 0)); // Texto verde brillante. Si se elimina, el texto por defecto será negro.
        answer_labelB.setFont(new Font("Century Gothic", Font.PLAIN, 18)); // Tipografía Century Gothic plana. Si se elimina, usará fuente predeterminada.

        seconds_left.setBounds(510, 550, 100, 100); // Ubicación y tamaño del contador numérico de tiempo. Si se elimina, el reloj no se mostrará.
        seconds_left.setBackground(new Color(25, 25, 25)); // Fondo oscuro del contador numérico. Si se elimina, el fondo será blanco.
        seconds_left.setForeground(new Color(255, 0, 0)); // Color rojo de alerta para el tiempo. Si se elimina, el número será negro.
        seconds_left.setFont(new Font("Century Gothic", Font.PLAIN, 50)); // Tipografía grande para los segundos. Si se elimina, el número se verá minúsculo.
        seconds_left.setBorder(BorderFactory.createBevelBorder(1)); // Borde con relieve tridimensional. Si se elimina, se verá plano.
        seconds_left.setOpaque(true); // Permite pintar el color de fondo en un JLabel. Si se elimina, el fondo no se pintará y se verá transparente.
        seconds_left.setHorizontalAlignment(JTextField.CENTER); // Centra el número de segundos. Si se elimina, se alineará a la izquierda.
        seconds_left.setText(String.valueOf(seconds)); // Muestra el valor inicial de los segundos (10). Si se elimina, la caja iniciará completamente vacía.

        time_label.setBounds(510, 520, 100, 25); // Ubicación del rótulo decorativo del timer. Si se elimina, no se mostrará el texto superior del reloj.
        time_label.setBackground(new Color(50, 50, 50)); // Fondo del rótulo decorativo. Si se elimina, se transparentará.
        time_label.setForeground(new Color(255, 0, 0)); // Color rojo del texto. Si se elimina, el texto por defecto será negro.
        time_label.setFont(new Font("Century Gothic", Font.PLAIN, 14)); // Tipografía pequeña y plana. Si se elimina, usará fuente por defecto.
        time_label.setHorizontalAlignment(JTextField.CENTER); // Centra el texto del rótulo. Si se elimina, se alineará a la izquierda.
        time_label.setText("timer >:D"); // Texto decorativo del reloj. Si se elimina, la etiqueta quedará vacía.

        number_right.setBounds(145, 180, 360, 80); // Posición del cuadro de puntaje final. Si se elimina, no se ubicará correctamente en la pantalla de cierre.
        number_right.setBackground(new Color(25, 25, 25)); // Fondo oscuro del marcador final. Si se elimina, será blanco.
        number_right.setForeground(new Color(25, 255, 0)); // Texto verde neón brillante. Si se elimina, el texto será negro.
        number_right.setFont(new Font("Century Gothic", Font.PLAIN, 35)); // Tipografía plana grande. Si se elimina, la letra se verá pequeña.
        number_right.setBorder(BorderFactory.createBevelBorder(1)); // Borde con relieve tridimensional. Si se elimina, se verá plano.
        number_right.setHorizontalAlignment(JTextField.CENTER); // Centra el texto del marcador. Si se elimina, se alineará a la izquierda.
        number_right.setEditable(false); // Bloquea la edición del campo. Si se elimina, el usuario podría alterar su puntuación manualmente.

        percentage.setBounds(145, 280, 360, 80); // Posición del cuadro de porcentaje de efectividad. Si se elimina, no se ubicará en la pantalla de cierre.
        percentage.setBackground(new Color(25, 25, 25)); // Fondo oscuro del porcentaje. Si se elimina, será blanco.
        percentage.setForeground(new Color(25, 255, 0)); // Texto verde neón brillante. Si se elimina, el texto será negro.
        percentage.setFont(new Font("Century Gothic", Font.PLAIN, 35)); // Tipografía plana grande. Si se elimina, la letra se verá pequeña.
        percentage.setBorder(BorderFactory.createBevelBorder(1)); // Borde con relieve tridimensional. Si se elimina, se verá plano.
        percentage.setHorizontalAlignment(JTextField.CENTER); // Centra el porcentaje. Si se elimina, se alineará a la izquierda.
        percentage.setEditable(false); // Bloquea la edición del porcentaje. Si se elimina, se podría sobrescribir el resultado.

        frame.add(time_label); // Añade el rótulo del timer a la ventana. Si se elimina, no se renderizará gráficamente.
        frame.add(seconds_left); // Añade el contador numérico del tiempo a la ventana. Si se elimina, no se renderizará.
        frame.add(etiquetaImagen); // Añade el contenedor de fotos a la ventana. Si se elimina, la imagen nunca aparecerá.
        frame.add(answer_labelA); // Añade la descripción de la opción A a la ventana. Si se elimina, no se renderizará.
        frame.add(answer_labelB); // Añade la descripción de la opción B a la ventana. Si se elimina, no se renderizará.
        frame.add(buttonA); // Añade el botón A a la ventana. Si se elimina, no se renderizará.
        frame.add(buttonB); // Añade el botón B a la ventana. Si se elimina, no se renderizará.
        frame.add(textarea); // Añade el área de texto de instrucciones a la ventana. Si se elimina, no se renderizará.
        frame.add(textfield); // Añade la barra superior a la ventana. Si se elimina, no se renderizará.

        frame.setVisible(true); // Hace visible la ventana del quiz en la pantalla. Si se elimina, el programa correrá en memoria pero nada se dibujará.

        JOptionPane.showMessageDialog(
                frame,
                info.getAcercaDelProyecto(),
                "Acerca del Proyecto",
                JOptionPane.INFORMATION_MESSAGE
        );

        nextQuestion(); // Carga la primera pregunta para iniciar la partida. Si se elimina, el juego iniciará con la pantalla en blanco.
    }

    public void nextQuestion() { // Método para preparar y mostrar la siguiente pregunta en la interfaz. Si se elimina, el flujo se detiene.
        if (juego.estaFinalizado() && juego.getIndiceActual() >= juego.getTotalPreguntas() - 1) { // Comprueba si ya se concluyeron todas las preguntas. Si se elimina, entraría en bucle.
            results(); // Muestra la pantalla de resultados finales. Si se elimina, el juego no terminará al concluir el ciclo.
        } else {
            Pregunta p = juego.obtenerPreguntaActual(); // Obtiene el objeto Pregunta actual desde el modelo. Si se elimina, no habrá datos que mostrar.

            textfield.setText("Pregunta " + (juego.getIndiceActual() + 1) + " de " + juego.getTotalPreguntas()); // Actualiza el texto superior con el progreso (ej. 1 de 10). Si se elimina, la barra no se actualizará.
            textarea.setText(info.getInstruccionesPregunta()); // Muestra las instrucciones de evaluación. Si se elimina, el cuadro guía quedará vacío.
            answer_labelA.setText("A) Sí, fue generado por Inteligencia Artificial"); // Asigna texto descriptivo a la opción A. Si se elimina, la alternativa A no tendrá texto.
            answer_labelB.setText("B) No, es una obra o foto de origen Humano"); // Asigna texto descriptivo a la opción B. Si se elimina, la alternativa B no tendrá texto.
            try {
                // Carga segura usando el ClassLoader de Java
                java.net.URL imgUrl = getClass().getResource(p.getRutaImagen());
                ImageIcon iconoOriginal = new ImageIcon(imgUrl);
                Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(350, 220, Image.SCALE_SMOOTH);
                etiquetaImagen.setIcon(new ImageIcon(imagenEscalada));
                etiquetaImagen.setText("");
            } catch (Exception ex) {
                etiquetaImagen.setIcon(null);
                etiquetaImagen.setText("[ Imagen no disponible: " + p.getRutaImagen() + " ]");
                etiquetaImagen.setForeground(Color.LIGHT_GRAY);
            }

            try {
                ImageIcon iconoOriginal = new ImageIcon(p.getRutaImagen()); // Carga la imagen desde la ruta configurada en el disco. Si falla, genera excepción capturada en catch.
                Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(350, 220, Image.SCALE_SMOOTH); // Redimensiona la foto al espacio exacto de la etiqueta (350x220) con alta calidad. Si se elimina, la foto saldrá sobredimensionada o deforme.
                etiquetaImagen.setIcon(new ImageIcon(imagenEscalada)); // Asigna la imagen escalada a la etiqueta gráfica. Si se elimina, la foto no se proyectará.
                etiquetaImagen.setText(""); // Limpia cualquier mensaje de texto de error previo. Si se elimina, el texto de error podría sobreponerse a la imagen.
            } catch (Exception ex) {
                etiquetaImagen.setIcon(null); // Remueve cualquier icono defectuoso. Si se elimina, se mantendría un gráfico roto.
                etiquetaImagen.setText("[ Imagen no disponible: " + p.getRutaImagen() + " ]"); // Muestra aviso en texto si falta el archivo en la carpeta. Si se elimina, el espacio se verá en blanco sin explicación.
                etiquetaImagen.setForeground(Color.LIGHT_GRAY); // Establece color claro para el texto de error. Si se elimina, el texto de error sería negro e invisible.
            }

            timer.start(); // Inicia el temporizador de cuenta regresiva para esta pregunta. Si se elimina, el cronómetro no correrá.
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) { // Método que intercepta los clics en los botones A y B. Si se elimina, la clase deja de implementar ActionListener y falla la compilación.
        timer.stop(); // Detiene el cronómetro al momento de responder. Si se elimina, el tiempo seguiría descontando en segundo plano.
        buttonA.setEnabled(false); // Desactiva temporalmente el botón A para evitar doble clic. Si se elimina, el usuario podría presionar varias veces seguidas.
        buttonB.setEnabled(false); // Desactiva temporalmente el botón B. Si se elimina, el usuario podría alterar el flujo.

        char eleccion = ' '; // Variable auxiliar para guardar la letra elegida. Si se elimina, no se sabrá qué botón se presionó.
        if (e.getSource() == buttonA) { // Verifica si se hizo clic en el botón A. Si se elimina, no se diferenciará de B.
            eleccion = 'A'; // Asigna la letra A. Si se elimina, no se registrará la elección.
            answer_labelA.setForeground(new Color(255, 0, 0)); // Cambia temporalmente el color de la etiqueta a rojo. Si se elimina, no habrá feedback visual.
        } else if (e.getSource() == buttonB) { // Verifica si se hizo clic en el botón B. Si se elimina, no se capturará la opción B.
            eleccion = 'B'; // Asigna la letra B. Si se elimina, no se registrará la elección.
            answer_labelB.setForeground(new Color(255, 0, 0)); // Cambia temporalmente el color de la etiqueta a rojo. Si se elimina, no habrá feedback visual.
        }

        procesarRespuestaGUI(eleccion); // Envía la opción elegida para su procesamiento visual y lógico. Si se elimina, la respuesta no se evaluará.
    }

    private void procesarRespuestaGUI(char eleccion) { // Método privado que gestiona la evaluación visual y el diálogo de explicación. Si se elimina, se duplicaría código de transición.
        timer.stop(); // Asegura la parada del temporizador. Si se elimina, el timer podría seguir corriendo.
        buttonA.setEnabled(false); // Mantiene los botones bloqueados durante la pausa. Si se elimina, se podría hacer clic durante la transición.
        buttonB.setEnabled(false); // Mantiene los botones bloqueados. Si se elimina, se podría interrumpir la pausa.

        boolean esCorrecta = juego.evaluarEleccionUsuario(eleccion); // Delega la evaluación de la respuesta al modelo de negocio. Si se elimina, el puntaje no se calculará.
        Pregunta pActual = juego.obtenerPreguntaActual(); // Obtiene la pregunta evaluada para extraer su explicación. Si se elimina, no se podrá consultar la retroalimentación.

        int opcionElegida = JOptionPane.showOptionDialog( // Muestra una ventana emergente interactiva con opciones. Si se elimina, el programa pasaría de largo sin preguntar.
                frame,
                (esCorrecta ? "¡CORRECTO! Has ganado 10 puntos.\n" : "INCORRECTO. No has sumado puntos.\n") + "¿Qué deseas hacer ahora?",
                "Pregunta " + (juego.getIndiceActual() + 1) + " Evaluada",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new Object[]{"Ver Explicación", "Siguiente Pregunta"},
                "Siguiente Pregunta"
        );

        if (opcionElegida == JOptionPane.YES_OPTION) { // Verifica si el usuario eligió ver la explicación detallada. Si se elimina, el diálogo pasará de largo.
            JOptionPane.showMessageDialog(
                    frame,
                    pActual.getRetroalimentacion(), // Extrae el texto de retroalimentación de la pregunta. Si se elimina, se mostrará un cuadro vacío.
                    "Retroalimentación e Indicios Visuales",
                    JOptionPane.INFORMATION_MESSAGE
            );
        }

        answer_labelA.setForeground(new Color(25, 255, 0)); // Restaura el color original verde neón de la etiqueta A. Si se elimina, se quedaría en rojo permanente.
        answer_labelB.setForeground(new Color(25, 255, 0)); // Restaura el color original verde neón de la etiqueta B. Si se elimina, se quedaría en rojo permanente.

        seconds = 10; // Restablece el temporizador a 10 segundos para la siguiente ronda. Si se elimina, la siguiente pregunta empezará con tiempo agotado.
        seconds_left.setText(String.valueOf(seconds)); // Actualiza la etiqueta visual del reloj. Si se elimina, el número en pantalla no volverá a 10.
        buttonA.setEnabled(true); // Rehabilita el botón A para la próxima pregunta. Si se elimina, el botón A quedará inservible para el resto de la partida.
        buttonB.setEnabled(true); // Rehabilita el botón B para la próxima pregunta. Si se elimina, el botón B quedará bloqueado permanentemente.

        if (!juego.estaFinalizado()) { // Verifica si aún hay preguntas por delante. Si se elimina, intentará avanzar de más y lanzará error por índice fuera de rango.
            juego.avanzarJuego(); // Avanza el índice interno en la lógica del juego. Si se elimina, la partida repetirá siempre la misma pregunta.
            nextQuestion(); // Carga los datos de la siguiente pregunta en la interfaz. Si se elimina, la pantalla no se actualizará.
        } else {
            results(); // Llama a la pantalla de resultados si ya se completaron las 10 preguntas. Si se elimina, al acabar la última pregunta la app no hará nada.
        }
    }

    public void results() { // Método para desplegar la pantalla final con las estadísticas de cierre. Si se elimina, el usuario nunca verá su nota final.
        buttonA.setVisible(false); // Oculta el botón A de la interfaz. Si se elimina, el botón flotará sobre la pantalla de resultados.
        buttonB.setVisible(false); // Oculta el botón B de la interfaz. Si se elimina, el botón flotará sobre la pantalla de resultados.
        answer_labelA.setVisible(false); // Oculta la etiqueta descriptiva A. Si se elimina, estorbará visualmente en la pantalla de cierre.
        answer_labelB.setVisible(false); // Oculta la etiqueta descriptiva B. Si se elimina, estorbará visualmente.
        etiquetaImagen.setVisible(false); // Oculta el contenedor de la foto. Si se elimina, la última foto seguirá visible en el centro de la pantalla final.
        seconds_left.setVisible(false); // Oculta el contador numérico de tiempo. Si se elimina, el reloj se quedará estorbando en la esquina.
        time_label.setVisible(false); // Oculta la etiqueta decorativa del temporizador. Si se elimina, seguirá visible de forma innecesaria.

        int puntajeFinal = juego.getPuntaje(); // Obtiene el puntaje total acumulado del modelo. Si se elimina, no se podrá calcular la puntuación final.
        int totalMaximo = juego.getTotalPreguntas() * 10; // Calcula el puntaje máximo posible (10 preguntas * 10 pts = 100 pts). Si se elimina, fallará el cálculo del porcentaje.
        int porcentaje = (int) ((double) puntajeFinal / totalMaximo * 100); // Calcula la efectividad en porcentaje. Si se elimina, no se sabrá el porcentaje de acierto.

        textfield.setText("¡PARTIDA FINALIZADA, " + juego.getNombreJugador().toUpperCase() + "!"); // Muestra saludo personalizado de cierre con el nombre. Si se elimina, la barra superior no indicará el fin.
        textarea.setText("Evaluación completada con éxito. Revisa tu rendimiento general a continuación:"); // Muestra mensaje descriptivo de cierre. Si se elimina, el área de texto quedará en blanco.

        number_right.setText("Puntaje: " + puntajeFinal + " / " + totalMaximo + " pts"); // Muestra los puntos conseguidos sobre el total. Si se elimina, no se verá la puntuación numérica.
        percentage.setText("Efectividad: " + porcentaje + "%"); // Muestra el porcentaje de éxito obtenido. Si se elimina, no se verá el porcentaje en pantalla.

        frame.add(number_right); // Agrega el cuadro de puntaje a la ventana final. Si se elimina, no se renderizará el marcador de puntos.
        frame.add(percentage); // Agrega el cuadro de porcentaje a la ventana final. Si se elimina, no se renderizará la efectividad.
        frame.repaint(); // Redibuja el contenedor para aplicar los cambios visuales de cierre. Si se elimina, los componentes nuevos podrían no verse hasta redimensionar la ventana.
    }
}