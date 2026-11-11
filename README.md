
## Instrucciones de Ejecucion (USAR LOS CÓDIGOS SUBIDOS MÁS RECIENTEMENTE, PARA LA ENTREGA FINAL ES EL 11/11/26 igual con los txt)

1. Requisitos: Tener instalado el JDK 8 o superior en tu entorno de desarrollo (IntelliJ IDEA, Eclipse, etc.).
2. Estructura de archivos: Asegurate de que los siguientes elementos esten ubicados exactamente en la raiz del proyecto:
* Los archivos de codigo fuente (Main.java, Quiz.java, Juego.java, InfoJuego.java, Pregunta.java).
* El archivo de configuracion de texto info.txt (este debe ir al mismo nivel que src pero no dentro de src)
* El archivo de datos preguntas.txt (este debe ir al mismo nivel que src pero no dentro de src)
* La carpeta llamada imagenes.(esta carpeta si va a adentro de src)


3. Compilar y Ejecutar: Ejecuta la clase principal Main.java.

## Donde y en que formato colocar las Fotos

Para que el programa cargue las imagenes correctamente sin errores, sigue estas reglas:

1. Ubicacion exacta: Debes crear una carpeta llamada exactamente imagenes dentro de la carpeta principal (raiz) de tu proyecto de Java.
2. Formato obligatorio: Todas las fotografias deben tener obligatoriamente extension .jpg (o .JPEG). Evita usar formatos como .png o .webp a menos que modifiques el codigo.
3. Ruta en el archivo de texto (preguntas.txt): Cada vez que agregues una pregunta en tu archivo preguntas.txt, la ruta de la imagen debe declararse comenzando con /imagenes/ seguido del nombre exacto del archivo y su extension.

Ejemplo de como estructurar una pregunta en preguntas.txt:
---
## IMAGEN: /imagenes/foto1.JPG
ES_IA: true
RETRO: La imagen presenta texturas sinteticas e iluminacion compleja propia de modelos generativos.
---
IMAGEN: /imagenes/foto2.JPG
ES_IA: false
RETRO: Se aprecian imperfecciones opticas y profundidad de campo nativa de una camara real.
---
(cada que se agregue una pregunta hay que separar por lineas, como va a aparecer en los .txt que estan subidos)
