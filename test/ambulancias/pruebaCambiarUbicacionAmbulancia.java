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
public class pruebaCambiarUbicacionAmbulancia {

    /**
     * Si ciudadID no existe. Deberá imprimir en pantalla: “La ciudad ciudadID
     * no existe.”      *
     * Si la ambulancia ambulanciaID no existe en el sistema de emergencias,
     * deberá imprimir en pantalla: “No existe una ambulancia con identificador
     * ambulanciaID.”
     */
    @Test
    public void testCambiarUbicaciónUnaAmbulanciaInexisteConNingunaAmbulanciaEnElSistema() {
        FuncionalidadesComunes.ImprimirComienzoDeTest();

        ISistema s = new SistemaAmbulancia();

        s.crearSistemaDeEmergencias(10);

        s.agregarCiudad("Ciudad1");
        s.agregarCiudad("Ciudad2");
        s.agregarCiudad("Ciudad2");

        assertEquals(ISistema.TipoRet.ERROR, s.cambiarUbicacion("SBA1232",1));

        FuncionalidadesComunes.ImprimirFinDeTest();

    }
    
    @Test
    public void testCambiarUbicaciónUnaCiudadInexisteConNingunaAmbulanciaEnElSistema() {
        FuncionalidadesComunes.ImprimirComienzoDeTest();

        ISistema s = new SistemaAmbulancia();

        s.crearSistemaDeEmergencias(10);

        s.agregarCiudad("Ciudad1");
        s.agregarCiudad("Ciudad2");
        s.agregarCiudad("Ciudad2");

        assertEquals(ISistema.TipoRet.ERROR, s.cambiarUbicacion("SBA1232",10));

        FuncionalidadesComunes.ImprimirFinDeTest();

    }

    @Test
    public void testCambiarUbicacionUnaAmbulanciaInexisteConAlMenosUnaAmbulanciaEnElSistema() {
        FuncionalidadesComunes.ImprimirComienzoDeTest();

        ISistema s = new SistemaAmbulancia();

        s.crearSistemaDeEmergencias(10);

        s.agregarCiudad("Ciudad1");
        s.agregarCiudad("Ciudad2");
        s.agregarCiudad("Ciudad2");

        s.registrarAmbulancia("SBA1234", 2);
        assertEquals(ISistema.TipoRet.ERROR, s.cambiarUbicacion("SBA1232",1));

        FuncionalidadesComunes.ImprimirFinDeTest();

    }

    

    @Test
    public void testCambiarUbicacionUnaAmbulanciaValidaConVariasAmbulanciaEnElSistema() {
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
        System.out.println("ESPERADO: Se espera que cambie la información que se imprime de ciudad1 a ciudad2");
        s.buscarAmbulancia("SBA1234");
        assertEquals(ISistema.TipoRet.OK, s.cambiarUbicacion("SBA1234",2));
        s.buscarAmbulancia("SBA1234");

        FuncionalidadesComunes.ImprimirFinDeTest();

    }

  

}
