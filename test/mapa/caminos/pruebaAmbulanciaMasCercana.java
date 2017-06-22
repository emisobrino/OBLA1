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
public class pruebaAmbulanciaMasCercana {

    /**
     * Si ciudadID no existe. Deberá imprimir en pantalla: “La ciudad ciudadID
     * no existe.”
     */
    @Test
    public void testAmbulanciaConCiudadIdInexistente() {
        FuncionalidadesComunes.ImprimirComienzoDeTest();

        ISistema s = FuncionalidadesComunes.crearSistemaConCincoCiudadesDiezAmbulanciasSieteRutasCuatroChoferes();

        assertEquals(ISistema.TipoRet.ERROR, s.ambulanciaMasCercana(50));

        FuncionalidadesComunes.ImprimirFinDeTest();

    }
    
    @Test
    public void testAmbulanciaConCiudadIdExistentePeroSinAmbulancias() {
        FuncionalidadesComunes.ImprimirComienzoDeTest();

        ISistema s = FuncionalidadesComunes.crearSistemaConCincoCiudadesDiezAmbulanciasSieteRutasCuatroChoferes();

        assertEquals(ISistema.TipoRet.ERROR, s.ambulanciaMasCercana(50));

        FuncionalidadesComunes.ImprimirFinDeTest();

    }

    @Test
    public void testAmbulanciaMasCercanaConRutaDirecta() {
        FuncionalidadesComunes.ImprimirComienzoDeTest();

        ISistema s = FuncionalidadesComunes.crearSistemaConDiezCiudadesDiezAmbulanciasSieteRutasCuatroChoferes();
        System.out.println("ESPERADO: Se espera que sea la ciudad 1 con 120 minutos");
        assertEquals(ISistema.TipoRet.OK, s.ambulanciaMasCercana(5));

        FuncionalidadesComunes.ImprimirFinDeTest();

    }
    
    @Test
    public void testAmbulanciaMasCercanaConRutaDirectaOtroTest() {
        FuncionalidadesComunes.ImprimirComienzoDeTest();

        ISistema s = FuncionalidadesComunes.crearSistemaConDiezCiudadesDiezAmbulanciasSieteRutasCuatroChoferes();
        System.out.println("ESPERADO: Se espera que sea la ciudad 1 con 40 minutos");
        assertEquals(ISistema.TipoRet.OK, s.ambulanciaMasCercana(4));

        FuncionalidadesComunes.ImprimirFinDeTest();

    }
    
    @Test
    public void testAmbulanciaMasCercanaConRutaNoDirecta() {
        FuncionalidadesComunes.ImprimirComienzoDeTest();

        ISistema s = FuncionalidadesComunes.crearSistemaConDiezCiudadesDiezAmbulanciasSieteRutasCuatroChoferes();
        
        //Elimino ambulancias asi no hay en la ciudad 1 para atender.
        s.eliminarAmbulancia("SBT6103");
        s.eliminarAmbulancia("SBT6104");
        s.eliminarAmbulancia("SBT6105");
        
        System.out.println("ESPERADO: Se espera que sea la ciudad 5 con 160 minutos pasando por la ciudad 1");
        

        assertEquals(ISistema.TipoRet.OK, s.ambulanciaMasCercana(4));

        FuncionalidadesComunes.ImprimirFinDeTest();

    }

}
