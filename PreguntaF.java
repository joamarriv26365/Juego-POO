Public class PreguntaF{
    private int numero;
    private String rutaImagen;
    private boolean esIA; // true = Es IA, false = Es Humano
    private String retroalimentacion;

    public Pregunta(int numero, String rutaImagen, boolean esIA, String retroalimentacion) {
        this.numero = numero;
        this.rutaImagen = rutaImagen;
        this.esIA = esIA;
        this.retroalimentacion = retroalimentacion;
    }

    public boolean esRespuestaCorrecta(boolean respuestaUsuario) {
        return this.esIA == respuestaUsuario;
    }

    public int getNumero() {
        return numero;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }
    public String getRetroalimentacion() {
        return retroalimentacion;
    }

    public ImageIcon getImagen() {
        java.net.URL ruta = getClass().getResource(rutaImagen);
        if (ruta == null) {
            System.out.println("No se encontró la imagen: " + rutaImagen);
            return null;
        }
        return new ImageIcon(ruta);
    }
}
