/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapa;

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
public class pruebaInformeCiudades {

    /**
     * No hay errores
     */
    @Test
    public void testInformeCiudadesListaVacia() {
        FuncionalidadesComunes.ImprimirComienzoDeTest();
        ISistema s = new SistemaAmbulancia();

        s.crearSistemaDeEmergencias(10);

        System.out.println("ESPERADO: Se espera listado vacio - NO SE PEDIA");
        assertEquals(ISistema.TipoRet.OK, s.informeCiudades());

        FuncionalidadesComunes.ImprimirFinDeTest();

    }

    @Test
    public void testInformeCiudadesUnaCiudadSinAmbulancias() {
        FuncionalidadesComunes.ImprimirComienzoDeTest();
        ISistema s = new SistemaAmbulancia();

        s.crearSistemaDeEmergencias(10);

        s.agregarCiudad("Ciudad1");

        System.out.println("ESPERADO: Se espera una ciudad sin ambulancias");
        assertEquals(ISistema.TipoRet.OK, s.informeCiudades());

        FuncionalidadesComunes.ImprimirFinDeTest();

    }

    @Test
    public void testInformeCiudadesConVariasCiudadesConAmbulanciasYUnaDeshabilitada() {
        FuncionalidadesComunes.ImprimirComienzoDeTest();
        ISistema s = FuncionalidadesComunes.crearSistemaConDiezCiudadesDiezAmbulanciasSieteRutasCuatroChoferes();

        /*
         * Informe Ciudad: <ciudadID>
         *      Ruta directa a <ciudadID>, minutos <minutos_viaje>
         *      Ambulancias disponibles: <cant_ambulancias_disponibles>
         *      Ambulancias no disponibles: <cant_ambulancias_no_disponibles>
         */
        s.deshabilitarAmbulancia("SBT6100");
        System.out.println("ESPERADO: 10 Ciudades, la ciudad2 con una ambulancia deshabilitada, y 2 habilitadas\n"
                + "La ciudad1 con tres ambulancias habilitadas\n"
                + "La ciudad4 con tres ambulancias habilitadas\n"
                + "La ciudad3 con una ambulancia habilitada\n"
                + "Y Ruta\n"
                + "Desde Ciudad1: a 4(40m) y 5(120m), e indirecta a 3(520m) y 2(260)\n"
                + "Desde Ciudad2: a 5(140m), 3(40m), 4(400m) e indirecta a 1(260m)\n"
                + "Desde Ciudad3: a 5(400m), 2(40m), e indirecta a 1(520m) y 4 (440m)\n"
                + "Desde Ciudad4: a 1 (40m), 2(400m), e indirecta a 5(160m) y 3(440m)\n"
                + "Desde Ciudad5: a 1 (120m), 2(140m), 3(400m) e indirecta 4(160m)\n");
        
        
        assertEquals(ISistema.TipoRet.OK, s.informeCiudades());

        FuncionalidadesComunes.ImprimirFinDeTest();

    }

}
