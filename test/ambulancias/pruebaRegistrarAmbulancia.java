/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ambulancias;

import sistemaambulancia.ISistema;
import sistemaambulancia.SistemaAmbulancia;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import utils.FuncionalidadesComunes;

/**
 *
 * @author docenteFI
 */
public class pruebaRegistrarAmbulancia {
    
    
    @Test
    public void testRegistrarUnaAmbulanciaYaExistenteEnLaMismaCiudad() {
       
        FuncionalidadesComunes.ImprimirComienzoDeTest();
        
        
        ISistema s = new SistemaAmbulancia();

        s.crearSistemaDeEmergencias(10);

        s.agregarCiudad("Ciudad1");
        s.agregarCiudad("Ciudad2");
        s.agregarCiudad("Ciudad3");

        
        assertEquals(ISistema.TipoRet.OK, s.registrarAmbulancia("SBA1234", 2));
        assertEquals(ISistema.TipoRet.ERROR, s.registrarAmbulancia("SBA1234", 2));

        FuncionalidadesComunes.ImprimirFinDeTest();

    }

    /**
     * También se espera que de error ya que puede existir una unica ambulancia
     * con el mismo id en el sistema.
     */
    @Test
    public void testRegistrarUnaAmbulanciaYaExistenteEnOtraCiudad() {
        FuncionalidadesComunes.ImprimirComienzoDeTest();
        ISistema s = new SistemaAmbulancia();

        s.crearSistemaDeEmergencias(10);

        s.agregarCiudad("Ciudad1");
        s.agregarCiudad("Ciudad2");
        s.agregarCiudad("Ciudad3");
         s.agregarCiudad("Ciudad4");

        assertEquals(ISistema.TipoRet.OK, s.registrarAmbulancia("SBA1234", 2));
        assertEquals(ISistema.TipoRet.ERROR, s.registrarAmbulancia("SBA1234", 3));

        FuncionalidadesComunes.ImprimirFinDeTest();

    }

    /**
     * También se espera que de error ya que puede existir una unica ambulancia
     * con el mismo id en el sistema.
     */
    @Test
    public void testRegistrarUnaAmbulanciaEnCiudadInexistente() {
       FuncionalidadesComunes.ImprimirComienzoDeTest();
        ISistema s = new SistemaAmbulancia();

        s.crearSistemaDeEmergencias(10);

        s.agregarCiudad("Ciudad1");
        s.agregarCiudad("Ciudad2");
        s.agregarCiudad("Ciudad3");

        assertEquals(ISistema.TipoRet.ERROR, s.registrarAmbulancia("SBA1234", 10));

        FuncionalidadesComunes.ImprimirFinDeTest();

    }

    @Test
    public void testRegistrarUnaAmbulancia() {
     FuncionalidadesComunes.ImprimirComienzoDeTest();
        ISistema s = new SistemaAmbulancia();

        s.crearSistemaDeEmergencias(10);

        s.agregarCiudad("Ciudad1");
        s.agregarCiudad("Ciudad2");

        assertEquals(ISistema.TipoRet.OK, s.registrarAmbulancia("SBA1234", 1));
        assertEquals(ISistema.TipoRet.OK, s.buscarAmbulancia("SBA1234"));

        FuncionalidadesComunes.ImprimirFinDeTest();

    }

    @Test
    public void testAgregarDiezAmbulancias() {

        FuncionalidadesComunes.ImprimirComienzoDeTest();
        ISistema s = new SistemaAmbulancia();

        s.crearSistemaDeEmergencias(10);

        s.agregarCiudad("Ciudad1");
        s.agregarCiudad("Ciudad2");

        s.registrarAmbulancia("SBA1234", 1);
        s.registrarAmbulancia("SBA1235", 1);
        s.registrarAmbulancia("SBA1236", 1);
        s.registrarAmbulancia("SBA1237", 1);
        s.registrarAmbulancia("SBA1238", 1);
        s.registrarAmbulancia("SBA1239", 1);
        s.registrarAmbulancia("SBA1210", 1);
        s.registrarAmbulancia("SBA1211", 1);
        s.registrarAmbulancia("SBA1212", 1);
        s.registrarAmbulancia("SBA1213", 1);

        assertEquals(ISistema.TipoRet.OK, s.buscarAmbulancia("SBA1234"));
        assertEquals(ISistema.TipoRet.OK, s.buscarAmbulancia("SBA1235"));
        assertEquals(ISistema.TipoRet.OK, s.buscarAmbulancia("SBA1236"));
        assertEquals(ISistema.TipoRet.OK, s.buscarAmbulancia("SBA1237"));
        assertEquals(ISistema.TipoRet.OK, s.buscarAmbulancia("SBA1238"));
        assertEquals(ISistema.TipoRet.OK, s.buscarAmbulancia("SBA1239"));
        assertEquals(ISistema.TipoRet.OK, s.buscarAmbulancia("SBA1210"));
        assertEquals(ISistema.TipoRet.OK, s.buscarAmbulancia("SBA1211"));
        assertEquals(ISistema.TipoRet.OK, s.buscarAmbulancia("SBA1212"));
        assertEquals(ISistema.TipoRet.OK, s.buscarAmbulancia("SBA1213"));

        FuncionalidadesComunes.ImprimirFinDeTest();

    }

}
