/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package  ambulancias;

import sistemaambulancia.ISistema;
import sistemaambulancia.SistemaAmbulancia;
import org.junit.Test;
import static org.junit.Assert.*;
import utils.FuncionalidadesComunes;

/**
 *
 * @author michel.camarotta
 */
public class pruebaHabilitarAmbulancia {

    /**
     *
     *
     * Si la ambulancia ambulanciaID no existe en el sistema de emergencias,
     * deberá imprimir en pantalla: “No existe una ambulancia con identificador
     * ambulanciaID.”
     *
     * Si la ambulancia ambulanciaID está habilitada, deberá imprimir
     * enpantalla: “La ambulancia ambulanciaID ya está habilitada.”
     *
     *
     */
    
    
    @Test
    public void testHabilitarUnaAmbulanciaInexisteConNingunaAmbulanciaEnElSistema() {
        FuncionalidadesComunes.ImprimirComienzoDeTest();

        ISistema s = new SistemaAmbulancia();

        s.crearSistemaDeEmergencias(10);

        s.agregarCiudad("Ciudad1");
        s.agregarCiudad("Ciudad2");
        s.agregarCiudad("Ciudad2");

        assertEquals(ISistema.TipoRet.ERROR, s.habilitarAmbulancia("SBA1232"));

        FuncionalidadesComunes.ImprimirFinDeTest();

    }

    @Test
    public void testHabilitarUnaAmbulanciaInexisteConAlMenosUnaAmbulanciaEnElSistema() {
        FuncionalidadesComunes.ImprimirComienzoDeTest();

        ISistema s = new SistemaAmbulancia();

        s.crearSistemaDeEmergencias(10);

        s.agregarCiudad("Ciudad1");
        s.agregarCiudad("Ciudad2");
        s.agregarCiudad("Ciudad2");

        s.registrarAmbulancia("SBA1234", 2);
        assertEquals(ISistema.TipoRet.ERROR, s.habilitarAmbulancia("SBA1232"));

        FuncionalidadesComunes.ImprimirFinDeTest();

    }

    @Test
    public void testHabilitarUnaAmbulanciaYaHabilitadaEnElSistema() {
        FuncionalidadesComunes.ImprimirComienzoDeTest();

        ISistema s = new SistemaAmbulancia();

        s.crearSistemaDeEmergencias(10);

        s.agregarCiudad("Ciudad1");
        s.agregarCiudad("Ciudad2");
        s.agregarCiudad("Ciudad2");

        s.registrarAmbulancia("SBA1234", 2);
        assertEquals(ISistema.TipoRet.ERROR, s.habilitarAmbulancia("SBA1234"));

        FuncionalidadesComunes.ImprimirFinDeTest();

    }

    @Test
    public void testHabilitarUnaAmbulanciaValidaConVariasAmbulanciaEnElSistema() {
        FuncionalidadesComunes.ImprimirComienzoDeTest();

        ISistema s = new SistemaAmbulancia();

        s.crearSistemaDeEmergencias(10);

        s.agregarCiudad("Ciudad1");
        s.agregarCiudad("Ciudad2");
        s.agregarCiudad("Ciudad2");

        s.registrarAmbulancia("SBA1234", 1);
        s.registrarAmbulancia("SBA1235", 1);
        s.registrarAmbulancia("SBA1236", 1);
        s.registrarAmbulancia("SBA1237", 1);
        s.registrarAmbulancia("SBA1238", 1);
        s.registrarAmbulancia("SBA1239", 1);
        s.registrarAmbulancia("SBA1210", 1);
        s.registrarAmbulancia("SBA1211", 1);
        s.registrarAmbulancia("SBA1212", 2);
        s.registrarAmbulancia("SBA1213", 2);
        assertEquals(ISistema.TipoRet.OK, s.deshabilitarAmbulancia("SBA1234"));
        assertEquals(ISistema.TipoRet.OK, s.habilitarAmbulancia("SBA1234"));

        FuncionalidadesComunes.ImprimirFinDeTest();

    }

    @Test
    public void testHabilitarVariasAmbulanciasValidasConVariasAmbulanciaEnElSistema() {
        FuncionalidadesComunes.ImprimirComienzoDeTest();

        ISistema s = new SistemaAmbulancia();

        s.crearSistemaDeEmergencias(10);

        s.agregarCiudad("Ciudad1");
        s.agregarCiudad("Ciudad2");
        s.agregarCiudad("Ciudad2");

        s.registrarAmbulancia("SBA1234", 1);
        s.registrarAmbulancia("SBA1235", 1);
        s.registrarAmbulancia("SBA1236", 1);
        s.registrarAmbulancia("SBA1237", 1);
        s.registrarAmbulancia("SBA1238", 1);
        s.registrarAmbulancia("SBA1239", 1);
        s.registrarAmbulancia("SBA1210", 1);
        s.registrarAmbulancia("SBA1211", 1);
        s.registrarAmbulancia("SBA1212", 2);
        s.registrarAmbulancia("SBA1213", 2);
        assertEquals(ISistema.TipoRet.OK, s.deshabilitarAmbulancia("SBA1235"));
        assertEquals(ISistema.TipoRet.OK, s.deshabilitarAmbulancia("SBA1236"));
        assertEquals(ISistema.TipoRet.OK, s.deshabilitarAmbulancia("SBA1237"));
        assertEquals(ISistema.TipoRet.OK, s.deshabilitarAmbulancia("SBA1238"));
        assertEquals(ISistema.TipoRet.OK, s.habilitarAmbulancia("SBA1235"));
        assertEquals(ISistema.TipoRet.OK, s.habilitarAmbulancia("SBA1236"));
        assertEquals(ISistema.TipoRet.OK, s.habilitarAmbulancia("SBA1237"));
        assertEquals(ISistema.TipoRet.OK, s.habilitarAmbulancia("SBA1238"));

        FuncionalidadesComunes.ImprimirFinDeTest();

    }

}
