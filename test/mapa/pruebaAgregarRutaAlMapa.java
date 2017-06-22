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
public class pruebaAgregarRutaAlMapa {

    /**
     * Si ciudadOrigen no existe. Deberá imprimir en pantalla: “La ciudad
     * ciudadOrigen no existe.”
     *
     * Si ciudadDestino no existe. Deberá imprimir en pantalla: “La ciudad
     * ciudadDestino no existe.”
     *
     * Si minutosViaje es menor o igual a 0. Deberá imprimir en pantalla: “La
     * duración del viaje debe ser mayor que 0.”
     */
    @Test
    public void testAgregarRutaConListaVaciaDeCiudades() {
        FuncionalidadesComunes.ImprimirComienzoDeTest();
        ISistema s = new SistemaAmbulancia();

        s.crearSistemaDeEmergencias(10);

        assertEquals(ISistema.TipoRet.ERROR, s.agregarRuta(1, 2, 10));

        FuncionalidadesComunes.ImprimirFinDeTest();

    }

    @Test
    public void testAgregarRutaConListaConVariasCiudadesPeroUnaDeLaRutaNoExistente() {
        FuncionalidadesComunes.ImprimirComienzoDeTest();
        ISistema s = new SistemaAmbulancia();

        s.crearSistemaDeEmergencias(10);

       s.agregarCiudad("Ciudad1");
        s.agregarCiudad("Ciudad2");
        s.agregarCiudad("Ciudad3");
        
        assertEquals(ISistema.TipoRet.ERROR, s.agregarRuta(1, 5, 10));

        FuncionalidadesComunes.ImprimirFinDeTest();

    }
    @Test
    public void testAgregarRutaConListaConVariasCiudadesYLasDosCiudadesExistentesPeroMinutosEnCero() {
        FuncionalidadesComunes.ImprimirComienzoDeTest();
        ISistema s = new SistemaAmbulancia();

        s.crearSistemaDeEmergencias(10);

       s.agregarCiudad("Ciudad1");
        s.agregarCiudad("Ciudad2");
        s.agregarCiudad("Ciudad3");
        
        assertEquals(ISistema.TipoRet.ERROR, s.agregarRuta(1, 2, 0));

        FuncionalidadesComunes.ImprimirFinDeTest();

    }
    @Test
    public void testAgregarRutaConListaConVariasCiudadesYLasDosCiudadesExistentesPeroMinutosMenorQueCero() {
        FuncionalidadesComunes.ImprimirComienzoDeTest();
        ISistema s = new SistemaAmbulancia();

        s.crearSistemaDeEmergencias(10);

       s.agregarCiudad("Ciudad1");
        s.agregarCiudad("Ciudad2");
        s.agregarCiudad("Ciudad3");
        
        assertEquals(ISistema.TipoRet.ERROR, s.agregarRuta(1, 2, -1));

        FuncionalidadesComunes.ImprimirFinDeTest();

    }
    
    @Test
    public void testAgregarRutaConListaConVariasCiudadesYLasDosCiudadesExistentes() {
        FuncionalidadesComunes.ImprimirComienzoDeTest();
        ISistema s = new SistemaAmbulancia();

        s.crearSistemaDeEmergencias(10);

        s.agregarCiudad("Ciudad1");
        s.agregarCiudad("Ciudad2");
        s.agregarCiudad("Ciudad3");
        
        assertEquals(ISistema.TipoRet.OK, s.agregarRuta(1, 2, 10));

        FuncionalidadesComunes.ImprimirFinDeTest();

    }

    @Test
    public void testAgregarVariasCiudadesVariasAmbulanciasVariasRutas() {
        FuncionalidadesComunes.ImprimirComienzoDeTest();
       
        ISistema s=FuncionalidadesComunes.crearSistemaConCincoCiudadesDiezAmbulanciasSieteRutasCuatroChoferes();
        
        assertEquals(ISistema.TipoRet.OK, s.agregarRuta(1, 2, 10));

        FuncionalidadesComunes.ImprimirFinDeTest();

    }

  

}
