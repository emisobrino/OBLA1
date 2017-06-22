package sistemaambulancia.dominio;

import sistemaambulancia.ISistema.TipoRet;

public class Prueba
{
    //Properties
    private static int cantCorrectas;
    private static int cantIncorrectas;
    private static int cantNoImplementadas;

    //Setear valores 0 a las propiedades 
    void inicializarResultadosPrueba()
    {
        cantCorrectas = cantIncorrectas = cantNoImplementadas = 0;
    }

    //Ver en pantalla
    public void ver(TipoRet TipoRet, TipoRet TipoRetEsperado, String comentario)
    {
        System.out.println();

        System.out.println("----------------------------- Testeo --------------------------------");

        imprimirComentario(comentario);

        imprimirTipoRet(TipoRet, TipoRetEsperado);

        System.out.println("---------------------------------------------------------------------");
        System.out.println();

        if (TipoRet.equals(TipoRetEsperado)) {
            cantCorrectas++;
        } else {
            if (TipoRet.equals(TipoRet.NO_IMPLEMENTADA)) {
                cantNoImplementadas++;
            } else {
                cantIncorrectas++;
            }

        }
    }

    //Imprimir comentario
    void imprimirComentario(String comentario) {
        if (comentario != null || !comentario.isEmpty()) {
            System.out.println("\n  Comentario: " + comentario);
            System.out.println();
        }
    }

    //Imprimir tiporetorno
    public void imprimirTipoRet(TipoRet TipoRet, TipoRet TipoRetEsperado) {
        System.out.println("  TipoRet de la app.: " + TipoRet + " ->\t" + getStringTipoRet(TipoRet));

        if (TipoRet == TipoRetEsperado) {
            System.out.println("\t\t.........OK.........");
        } else {
            System.out.println("  Se esperaba.......: " + TipoRetEsperado + " ->\t" + getStringTipoRet(TipoRetEsperado));
        }
    }

    //Obtener string tiporet
    public String getStringTipoRet(TipoRet TipoRet) {
        switch (TipoRet) {
            case OK:
                return "OK";
            case ERROR:
                return "ERROR";
            case NO_IMPLEMENTADA:
                return "NO_IMPLEMENTADA";
            default:
                return "NO_IMPLEMENTADA";
        }
    }

    //Imprimir resultado de pruebas
    void imprimirResultadosPrueba() {
        System.out.println();
        System.out.println("  +------------------------------+");
        System.out.println("    RESULTADOS DE LA PRUEBA    ");
        System.out.println("    Pruebas Correctas: " + cantCorrectas);
        System.out.println("    Pruebas Incorrectas: " + cantIncorrectas);
        System.out.println("    Pruebas NI: " + cantNoImplementadas);
        System.out.println("  +------------------------------+");
        System.out.println();
    }
}
