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
public class pruebaCiudadesEnRadio {

    /**
     * Si ciudadID no existe. Deberá imprimir en pantalla: “La ciudad ciudadID
     * no existe.” Si duracionViaje es menor o igual a 0. Deberá imprimir en
     * pantalla: “La duración del viaje debe ser mayor que 0.”
     */
   
    @Test
    public void testCiudadesEnRadioConCiudadIdInexistente() {
        FuncionalidadesComunes.ImprimirComienzoDeTest();

        ISistema s = FuncionalidadesComunes.crearSistemaConCincoCiudadesDiezAmbulanciasSieteRutasCuatroChoferes();

        assertEquals(ISistema.TipoRet.ERROR, s.ciudadesEnRadio(10, 30));

        FuncionalidadesComunes.ImprimirFinDeTest();

    }

    @Test
    public void testCiudadesEnRadioConCiudadExistenteYMinutosEnCero() {
        FuncionalidadesComunes.ImprimirComienzoDeTest();

        ISistema s = FuncionalidadesComunes.crearSistemaConCincoCiudadesDiezAmbulanciasSieteRutasCuatroChoferes();

        assertEquals(ISistema.TipoRet.ERROR, s.ciudadesEnRadio(3, 0));

        FuncionalidadesComunes.ImprimirFinDeTest();

    }
    
     @Test
    public void testCiudadesEnRadioConCiudadExistenteYMinutosMenorQueCero() {
        FuncionalidadesComunes.ImprimirComienzoDeTest();

        ISistema s = FuncionalidadesComunes.crearSistemaConCincoCiudadesDiezAmbulanciasSieteRutasCuatroChoferes();

        assertEquals(ISistema.TipoRet.ERROR, s.ciudadesEnRadio(3, -1));

        FuncionalidadesComunes.ImprimirFinDeTest();

    }

    @Test
    public void testCiudadesEnRadioConCiudadIdExistentePeroSinRutaAlguna() {
        FuncionalidadesComunes.ImprimirComienzoDeTest();

        ISistema s = FuncionalidadesComunes.crearSistemaConXCiudadesUnaAmbulanciaPorCiudad(10);

        System.out.println("ESPERADO: 'No hay ruta'");
        assertEquals(ISistema.TipoRet.OK, s.ciudadesEnRadio(1, 2));

        FuncionalidadesComunes.ImprimirFinDeTest();

    }

    @Test
    public void testCiudadesEnRadioConCiudadIdExistenteConDosCiudadesFueraDeRadioYUnaDentroDelRadioPeroConDosCiudadesIntermedias() {
        FuncionalidadesComunes.ImprimirComienzoDeTest();

        ISistema s = FuncionalidadesComunes.crearSistemaConCincoCiudadesDiezAmbulanciasSieteRutasCuatroChoferes();

         s.agregarRuta(8, 5, 10);
         s.modificarDemora(5, 1, 20);
         s.modificarDemora(4, 1, 10);
        System.out.println("ESPERADO: No debe mostrar la ciudad 8 ya que está a dos ciudades intermedias"
                + "Muestra: Ciudad1 a 40, Ciudad5 a 160"); 
        assertEquals(ISistema.TipoRet.OK, s.ciudadesEnRadio(4,270));

        FuncionalidadesComunes.ImprimirFinDeTest();

    }

    @Test
    public void testCiudadesEnRadioConRutaDirectaUnaSolaCiudad() {
        FuncionalidadesComunes.ImprimirComienzoDeTest();

        ISistema s = FuncionalidadesComunes.crearSistemaConDiezCiudadesDiezAmbulanciasSieteRutasCuatroChoferes();
        System.out.println("ESPERADO: Se espera Ciudad1 - 120");
        assertEquals(ISistema.TipoRet.OK, s.ciudadesEnRadio(5, 120));

        FuncionalidadesComunes.ImprimirFinDeTest();

    }
    
    @Test
    public void testCiudadesEnRadioMasDeUnaRutaPosibleAUnaCiudadPeroConUnaQueEntraEnElRadioYOtraQueNo() {
        FuncionalidadesComunes.ImprimirComienzoDeTest();

        ISistema s = FuncionalidadesComunes.crearSistemaConDiezCiudadesDiezAmbulanciasSieteRutasCuatroChoferes();
        System.out.println("ESPERADO: Se espera Ciudad1 - 120m, Ciudad2 - 140m y con intermedias: Ciudad3 - 180m, Ciudad4 - 160m."
                + "No Debe imprimir Ciudad3 - 400m");
        assertEquals(ISistema.TipoRet.OK, s.ciudadesEnRadio(5, 200));

        FuncionalidadesComunes.ImprimirFinDeTest();

    }



}
