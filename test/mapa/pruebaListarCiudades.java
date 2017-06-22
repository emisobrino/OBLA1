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
public class pruebaListarCiudades {

    /**
     * No hay errores
     */
   
    @Test
    public void testListarListaVacia() {
     FuncionalidadesComunes.ImprimirComienzoDeTest();
        ISistema s = new SistemaAmbulancia();

        s.crearSistemaDeEmergencias(10);

        System.out.println("ESPERADO: Se espera listado vacio");
        assertEquals(ISistema.TipoRet.OK,s.listarCiudades());
   

        FuncionalidadesComunes.ImprimirFinDeTest();

    }

    @Test
    public void testListarUnaCiudad() {
     FuncionalidadesComunes.ImprimirComienzoDeTest();
        ISistema s = new SistemaAmbulancia();

        s.crearSistemaDeEmergencias(10);
        
        s.agregarCiudad("Ciudad1");

        System.out.println("ESPERADO: Se espera una ciudad");
        assertEquals(ISistema.TipoRet.OK,s.listarCiudades());
   

        FuncionalidadesComunes.ImprimirFinDeTest();

    }
    
    

    @Test
    public void testListarJustoLaCantidadMaximaDeCiudades() {

        FuncionalidadesComunes.ImprimirComienzoDeTest();
        ISistema s = new SistemaAmbulancia();

        s.crearSistemaDeEmergencias(5);

        assertEquals(ISistema.TipoRet.OK, s.agregarCiudad("Ciudad1"));
        assertEquals(ISistema.TipoRet.OK, s.agregarCiudad("Ciudad2"));
        assertEquals(ISistema.TipoRet.OK, s.agregarCiudad("Ciudad3"));
        assertEquals(ISistema.TipoRet.OK, s.agregarCiudad("Ciudad4"));
        assertEquals(ISistema.TipoRet.OK, s.agregarCiudad("Ciudad5"));
        
        System.out.println("ESPERADO: Se esperan 5 ciudades");
        assertEquals(ISistema.TipoRet.OK,s.listarCiudades());
     

        FuncionalidadesComunes.ImprimirFinDeTest();

    }
    
    

}
