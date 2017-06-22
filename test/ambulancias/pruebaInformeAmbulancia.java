/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ambulancias;

import sistemaambulancia.ISistema;
import sistemaambulancia.SistemaAmbulancia;
import utils.FuncionalidadesComunes;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author docenteFI
 */
public class pruebaInformeAmbulancia {

    /**
     * No hay errores posibles
     */
     @Test
    public void testInformeAmbulanciaConNingunaAmbulanciaEnElSistema() {
        FuncionalidadesComunes.ImprimirComienzoDeTest();

        ISistema s = new SistemaAmbulancia();

        s.crearSistemaDeEmergencias(10);

        s.agregarCiudad("Ciudad1");
        s.agregarCiudad("Ciudad2");
        s.agregarCiudad("Ciudad2");

        System.out.println("ESPERADO: Se espera el listado vacio");
        assertEquals(ISistema.TipoRet.OK, s.informeAmbulancia());

        FuncionalidadesComunes.ImprimirFinDeTest();

    }

    @Test
    public void testInformeAmbulanciaConAlMenosUnaAmbulanciaEnElSistema() {
        FuncionalidadesComunes.ImprimirComienzoDeTest();

        ISistema s = new SistemaAmbulancia();

        s.crearSistemaDeEmergencias(10);

        s.agregarCiudad("Ciudad1");
        s.agregarCiudad("Ciudad2");
        s.agregarCiudad("Ciudad2");

        s.registrarAmbulancia("SBA1234", 2);
        System.out.println("ESPERADO: Se espera una ambulancia en el listado habilitada");
        assertEquals(ISistema.TipoRet.OK, s.informeAmbulancia());

        FuncionalidadesComunes.ImprimirFinDeTest();

    }
    
    @Test
    public void testInformeAmbulanciaUnaAmbulanciaQueEsteDeshabilitadaEnElSistema() {
        FuncionalidadesComunes.ImprimirComienzoDeTest();

        ISistema s = new SistemaAmbulancia();

        s.crearSistemaDeEmergencias(10);

        s.agregarCiudad("Ciudad1");
        s.agregarCiudad("Ciudad2");
        s.agregarCiudad("Ciudad3");

        s.registrarAmbulancia("SBA1234", 2);
        s.registrarAmbulancia("SBA1233", 2);
        s.registrarAmbulancia("SBA1236", 2);
        s.registrarAmbulancia("SBA1237", 2);
        System.out.println("ESPERADO: Se espera una ambulancia en el listado deshabilitada");
        assertEquals(ISistema.TipoRet.OK, s.deshabilitarAmbulancia("SBA1234"));
        assertEquals(ISistema.TipoRet.OK, s.informeAmbulancia());

        FuncionalidadesComunes.ImprimirFinDeTest();

    }

    @Test
    public void testInformeAmbulanciaValidaConVariasAmbulanciaHabilitadasEnElSistema() {
        FuncionalidadesComunes.ImprimirComienzoDeTest();

        ISistema s = new SistemaAmbulancia();

        s.crearSistemaDeEmergencias(10);

        s.agregarCiudad("Ciudad1");
        s.agregarCiudad("Ciudad2");
        s.agregarCiudad("Ciudad3");

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
        
        System.out.println("ESPERADO: Se espera 10 ambulancias en el listado, todas habilitadas, con dos ciudades diferentes");
        assertEquals(ISistema.TipoRet.OK, s.informeAmbulancia());


        FuncionalidadesComunes.ImprimirFinDeTest();

    }

    @Test
    public void testInformeAmbulanciaVariasAmbulanciasHabilitadasYVariasAmbulanciaDeshabilitadasEnElSistema() {
        FuncionalidadesComunes.ImprimirComienzoDeTest();

        ISistema s = new SistemaAmbulancia();

        s.crearSistemaDeEmergencias(10);

        s.agregarCiudad("Ciudad1");
        s.agregarCiudad("Ciudad2");
        
        s.agregarCiudad("Ciudad3");
        s.agregarCiudad("Ciudad4");
        s.agregarCiudad("Ciudad5");

        s.registrarAmbulancia("SBA1234", 1);
        s.registrarAmbulancia("SBA1235", 1);
        s.registrarAmbulancia("SBA1236", 1);
        s.registrarAmbulancia("SBA1237", 1);
        s.registrarAmbulancia("SBA1238", 2);
        s.registrarAmbulancia("SBA1239", 2);
        s.registrarAmbulancia("SBA1210", 3);
        s.registrarAmbulancia("SBA1211", 3);
        s.registrarAmbulancia("SBA1212", 4);
        s.registrarAmbulancia("SBA1213", 4);
        
        
        System.out.println("ESPERADO: Se espera 10 ambulancias en el listado, 7 habilitadas y 3 deshabilitadas, con 4 ciudades diferentes");
        assertEquals(ISistema.TipoRet.OK, s.deshabilitarAmbulancia("SBA1234"));
        assertEquals(ISistema.TipoRet.OK, s.deshabilitarAmbulancia("SBA1235"));
        assertEquals(ISistema.TipoRet.OK, s.deshabilitarAmbulancia("SBA1236"));
        
        assertEquals(ISistema.TipoRet.OK, s.informeAmbulancia());

        FuncionalidadesComunes.ImprimirFinDeTest();

    }
    
    
    
    
}
