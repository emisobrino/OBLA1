/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapa.caminos;

import ambulancias.*;
import sistemaambulancia.ISistema;
import sistemaambulancia.SistemaAmbulancia;
import utils.FuncionalidadesComunes;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author docenteFI
 */
public class pruebaRutaMasRapida {

    /**
     * Si ciudadOrigen no existe. Deberá imprimir en pantalla: “La ciudad
     * ciudadOrigen no existe.”
     *
     * Si ciudadDestino no existe. Deberá imprimir en pantalla: “La ciudad
     * ciudadDestino no existe.”
     */
    @Test
    public void testRutaMasRapidaConLasDosCiudadIdInexistente() {
        FuncionalidadesComunes.ImprimirComienzoDeTest();

        ISistema s = FuncionalidadesComunes.crearSistemaConCincoCiudadesDiezAmbulanciasSieteRutasCuatroChoferes();

        assertEquals(ISistema.TipoRet.ERROR, s.rutaMasRapida(10,10));

        FuncionalidadesComunes.ImprimirFinDeTest();

    }
    
    @Test
    public void testRutaMasRapidaConUnCiudadIdInexistentePrimerParametro() {
        FuncionalidadesComunes.ImprimirComienzoDeTest();

        ISistema s = FuncionalidadesComunes.crearSistemaConCincoCiudadesDiezAmbulanciasSieteRutasCuatroChoferes();

        assertEquals(ISistema.TipoRet.ERROR, s.rutaMasRapida(10,3));

        FuncionalidadesComunes.ImprimirFinDeTest();

    }
    
    @Test
    public void testRutaMasRapidaConUnCiudadIdInexistenteSegundoParametro() {
        FuncionalidadesComunes.ImprimirComienzoDeTest();

        ISistema s = FuncionalidadesComunes.crearSistemaConCincoCiudadesDiezAmbulanciasSieteRutasCuatroChoferes();

        assertEquals(ISistema.TipoRet.ERROR, s.rutaMasRapida(3,10));

        FuncionalidadesComunes.ImprimirFinDeTest();

    }

    @Test
    public void testRutaMasRapidaConCiudadIdExistentePeroSinRutaAlguna() {
        FuncionalidadesComunes.ImprimirComienzoDeTest();

        ISistema s = FuncionalidadesComunes.crearSistemaConXCiudadesUnaAmbulanciaPorCiudad(10);


        System.out.println("ESPERADO: 'No hay ruta'");
        assertEquals(ISistema.TipoRet.OK, s.rutaMasRapida(1,2));

        FuncionalidadesComunes.ImprimirFinDeTest();

    }
    
    @Test
    public void testRutaMasRapidaConCiudadIdExistentePeroSinRutaConUnaCiudadIntermediaMaximo() {
        FuncionalidadesComunes.ImprimirComienzoDeTest();

        ISistema s = FuncionalidadesComunes.crearSistemaConCincoCiudadesDiezAmbulanciasSieteRutasCuatroChoferes();

        s.agregarRuta(8, 5, 100);
        System.out.println("ESPERADO: Si bien hay ruta, hay que pasar por tres ciudades."
                + "Se espera 'No hay ruta'");
        assertEquals(ISistema.TipoRet.ERROR, s.rutaMasRapida(4,8));

        FuncionalidadesComunes.ImprimirFinDeTest();

    }
    
    @Test
    public void testRutaMasRapidaConCiudadIdExistentePeroSinRutaConUnaCiudadIntermediaMaximoConParametrosAlReves() {
        FuncionalidadesComunes.ImprimirComienzoDeTest();

        ISistema s = FuncionalidadesComunes.crearSistemaConCincoCiudadesDiezAmbulanciasSieteRutasCuatroChoferes();

        System.out.println("ESPERADO: Si bien hay ruta, hay que pasar por tres ciudades."
                + "Se espera 'No hay ruta'");
        assertEquals(ISistema.TipoRet.OK, s.rutaMasRapida(4,3));

        FuncionalidadesComunes.ImprimirFinDeTest();

    }

    @Test
    public void testRutaMasRapidaConRutaDirecta() {
        FuncionalidadesComunes.ImprimirComienzoDeTest();

        ISistema s = FuncionalidadesComunes.crearSistemaConDiezCiudadesDiezAmbulanciasSieteRutasCuatroChoferes();
        System.out.println("ESPERADO: Se espera Ciudad5 - 0, Ciudad2 - 140, Total 140");
        assertEquals(ISistema.TipoRet.OK, s.rutaMasRapida(5,2));

        FuncionalidadesComunes.ImprimirFinDeTest();

    }

   
    @Test
    public void testRutaMasRapidaConRutaNoDirectaSinPosibilidadDeConexionDeRutaDirecta() {
        FuncionalidadesComunes.ImprimirComienzoDeTest();

        ISistema s = FuncionalidadesComunes.crearSistemaConDiezCiudadesDiezAmbulanciasSieteRutasCuatroChoferes();

        s.agregarRuta(8,5,100);
        s.agregarRuta(8,4, 80);
        System.out.println("ESPERADO: Se espera Ciudad5 - 0, Ciudad1 - 120, Ciudad4 - 40, Total 160");

        assertEquals(ISistema.TipoRet.OK, s.rutaMasRapida(5,4));

        FuncionalidadesComunes.ImprimirFinDeTest();

    }
    
    @Test
    public void testRutaMasRapidaConRutaNoDirectaConPosibilidadDeConexionDeRutaDirecta() {
        FuncionalidadesComunes.ImprimirComienzoDeTest();

        ISistema s = FuncionalidadesComunes.crearSistemaConDiezCiudadesDiezAmbulanciasSieteRutasCuatroChoferes();

        s.agregarRuta(8,5,100);
        s.agregarRuta(8,4, 80);
        s.agregarRuta(5,4, 400);
        System.out.println("ESPERADO: Si bien hay ruta directa, es más corto ir por la ruta intermedia"
                + "Se espera Ciudad5 - 0, Ciudad1 - 120, Ciudad4 - 40, Total 160");

        assertEquals(ISistema.TipoRet.OK, s.rutaMasRapida(5,4));

        FuncionalidadesComunes.ImprimirFinDeTest();

    }
    
    

}
