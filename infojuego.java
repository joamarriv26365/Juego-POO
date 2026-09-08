public class infojuego {

    private String archivo;
    private Preguntas[] preguntas;

    public infojuego() {

        archivo = "preguntas.txt";

        preguntas = new Preguntas[10];

        preguntas[0] = new Preguntas();
        preguntas[0].setNumPregunta(1);
        preguntas[0].setImagenRut("imagen1.jpg");
        preguntas[0].setRespuestaCorr(true);
        preguntas[0].setRetroalimentacion(
            "La imagen fue generada por inteligencia artificial."
        );

        preguntas[1] = new Preguntas();
        preguntas[1].setNumPregunta(2);
        preguntas[1].setImagenRut("imagen2.jpg");
        preguntas[1].setRespuestaCorr(false);
        preguntas[1].setRetroalimentacion(
            "La imagen corresponde a una fotografía real."
        );

        preguntas[2] = new Preguntas();
        preguntas[2].setNumPregunta(3);
        preguntas[2].setImagenRut("imagen3.jpg");
        preguntas[2].setRespuestaCorr(true);
        preguntas[2].setRetroalimentacion(
            "La imagen fue creada mediante inteligencia artificial."
        );

        preguntas[3] = new Preguntas();
        preguntas[3].setNumPregunta(4);
        preguntas[3].setImagenRut("imagen4.jpg");
        preguntas[3].setRespuestaCorr(false);
        preguntas[3].setRetroalimentacion(
            "La imagen es una fotografía real."
        );

        preguntas[4] = new Preguntas();
        preguntas[4].setNumPregunta(5);
        preguntas[4].setImagenRut("imagen5.jpg");
        preguntas[4].setRespuestaCorr(true);
        preguntas[4].setRetroalimentacion(
            "Esta imagen fue generada por inteligencia artificial."
        );

        preguntas[5] = new Preguntas();
        preguntas[5].setNumPregunta(6);
        preguntas[5].setImagenRut("imagen6.jpg");
        preguntas[5].setRespuestaCorr(false);
        preguntas[5].setRetroalimentacion(
            "Esta imagen es real."
        );

        preguntas[6] = new Preguntas();
        preguntas[6].setNumPregunta(7);
        preguntas[6].setImagenRut("imagen7.jpg");
        preguntas[6].setRespuestaCorr(true);
        preguntas[6].setRetroalimentacion(
            "Esta imagen fue generada por IA."
        );

        preguntas[7] = new Preguntas();
        preguntas[7].setNumPregunta(8);
        preguntas[7].setImagenRut("imagen8.jpg");
        preguntas[7].setRespuestaCorr(false);
        preguntas[7].setRetroalimentacion(
            "Esta imagen corresponde a una fotografía real."
        );

        preguntas[8] = new Preguntas();
        preguntas[8].setNumPregunta(9);
        preguntas[8].setImagenRut("imagen9.jpg");
        preguntas[8].setRespuestaCorr(true);
        preguntas[8].setRetroalimentacion(
            "Esta imagen fue generada utilizando IA."
        );

        preguntas[9] = new Preguntas();
        preguntas[9].setNumPregunta(10);
        preguntas[9].setImagenRut("imagen10.jpg");
        preguntas[9].setRespuestaCorr(false);
        preguntas[9].setRetroalimentacion(
            "Esta imagen es una fotografía real."
        );
    }

    public Preguntas[] cargarPreg() {
        return preguntas;
    }
}