/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ambulancias;

import sistemaambulancia.ISistema;
import sistemaambulancia.SistemaAmbulancia;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import utils.FuncionalidadesComunes;

/**
 *
 * @author docenteFI
 */
public class pruebaInformeAmbulanciaPorCiudad {

    /**
     * Si ciudadID no existe. Deberá imprimir en pantalla: “La ciudad ciudadID
     * no existe.”
     */
    @Test
    public void testInformeAmbulanciaPorCiudadConNingunaCiudadEnElSistema() {
        FuncionalidadesComunes.ImprimirComienzoDeTest();

        ISistema s = new SistemaAmbulancia();

        s.crearSistemaDeEmergencias(10);

        assertEquals(ISistema.TipoRet.ERROR, s.informeAmbulancia(1));

        FuncionalidadesComunes.ImprimirFinDeTest();

    }

    @Test
    public void testInformeAmbulanciaPorCiudadConUnaCiudadInexistenteEnElSistema() {
        FuncionalidadesComunes.ImprimirComienzoDeTest();

        ISistema s = new SistemaAmbulancia();

        s.crearSistemaDeEmergencias(10);

        s.agregarCiudad("Ciudad1");
        s.agregarCiudad("Ciudad2");
        s.agregarCiudad("Ciudad2");

        assertEquals(ISistema.TipoRet.ERROR, s.informeAmbulancia(10));

        FuncionalidadesComunes.ImprimirFinDeTest();

    }

    @Test
    public void testInformeAmbulanciaConNingunaAmbulanciaEnElSistema() {
        FuncionalidadesComunes.ImprimirComienzoDeTest();

        ISistema s = new SistemaAmbulancia();

        s.crearSistemaDeEmergencias(10);

        s.agregarCiudad("Ciudad1");
        s.agregarCiudad("Ciudad2");
        s.agregarCiudad("Ciudad3");

        System.out.println("ESPERADO: Se espera el listado vacio");
        assertEquals(ISistema.TipoRet.OK, s.informeAmbulancia(2));

        FuncionalidadesComunes.ImprimirFinDeTest();

    }

    @Test
    public void testInformeAmbulanciaPorCiudadConCiudadSinAmbulanciasPeroConAlMenosUnaAmbulanciaEnElSistema() {
        FuncionalidadesComunes.ImprimirComienzoDeTest();

        ISistema s = new SistemaAmbulancia();

        s.crearSistemaDeEmergencias(10);

        s.agregarCiudad("Ciudad1");
        s.agregarCiudad("Ciudad2");
        s.agregarCiudad("Ciudad2");

        s.registrarAmbulancia("SBA1234", 2);
        System.out.println("ESPERADO: Se espera el listado vacio");
        assertEquals(ISistema.TipoRet.OK, s.informeAmbulancia(1));

        FuncionalidadesComunes.ImprimirFinDeTest();

    }

    @Test
    public void testInformeAmbulanciaPorCiudadConCiudadConAlMenosUnaAmbulanciaEnLaCiudad() {
        FuncionalidadesComunes.ImprimirComienzoDeTest();

        ISistema s = new SistemaAmbulancia();

        s.crearSistemaDeEmergencias(10);

        s.agregarCiudad("Ciudad1");
        s.agregarCiudad("Ciudad2");
        s.agregarCiudad("Ciudad3");

        s.registrarAmbulancia("SBA1234", 2);
        System.out.println("ESPERADO: Se espera una ambulancia en el listado habilitada");
        assertEquals(ISistema.TipoRet.OK, s.informeAmbulancia(2));

        FuncionalidadesComunes.ImprimirFinDeTest();

    }

    @Test
    public void testInformeAmbulanciaPorCiudadConUnaAmbulanciaQueEsteDeshabilitadaEnElLaCiudad() {
        FuncionalidadesComunes.ImprimirComienzoDeTest();

        ISistema s = new SistemaAmbulancia();

        s.crearSistemaDeEmergencias(10);

        s.agregarCiudad("Ciudad1");
        s.agregarCiudad("Ciudad2");
        s.agregarCiudad("Ciudad3");
        s.agregarCiudad("Ciudad4");

        s.registrarAmbulancia("SBA1234", 2);
        s.registrarAmbulancia("SBA1233", 2);
        s.registrarAmbulancia("SBA1236", 2);
        s.registrarAmbulancia("SBA1237", 2);
        System.out.println("ESPERADO: Se espera 3 ambulancia en el listado, ya que una está deshabilitada");
        assertEquals(ISistema.TipoRet.OK, s.deshabilitarAmbulancia("SBA1234"));
        assertEquals(ISistema.TipoRet.OK, s.informeAmbulancia(2));

        FuncionalidadesComunes.ImprimirFinDeTest();

    }

    @Test
    public void testInformeAmbulanciaPorCiudadValidaConVariasAmbulanciaHabilitadasEnElSistema() {
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

        System.out.println("ESPERADO: Se espera 8 ambulancias en el listado");
        assertEquals(ISistema.TipoRet.OK, s.informeAmbulancia(1));

        FuncionalidadesComunes.ImprimirFinDeTest();

    }

    @Test
    public void testInformeAmbulanciaPorCiudadVariasAmbulanciasHabilitadasYVariasAmbulanciaDeshabilitadasEnElSistema() {
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

        System.out.println("ESPERADO: Se espera 2 ambulancias en el listado - SBA1236 y SBA1237");
        assertEquals(ISistema.TipoRet.OK, s.deshabilitarAmbulancia("SBA1234"));
        assertEquals(ISistema.TipoRet.OK, s.deshabilitarAmbulancia("SBA1235"));


        assertEquals(ISistema.TipoRet.OK, s.informeAmbulancia(1));

        FuncionalidadesComunes.ImprimirFinDeTest();

    }

}
