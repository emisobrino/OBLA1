/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaGeneral;

import mapa.caminos.*;
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
public class pruebaGenerales {

    /**
     * Estos tests contienen prueba de sistema, estas son las pruebas que se corren invocando varias operaciones del sistema, 
     * cerciorandose que el sistema se comporta correctamente luego de cambiar su estado varias veces. O sea, que este siga siendo
     * consistente.
     */
   
    @Test
    public void testSistema1() {
        FuncionalidadesComunes.ImprimirComienzoDeTest();

        ISistema s = FuncionalidadesComunes.crearSistemaConDiezCiudadesDiezAmbulanciasSieteRutasCuatroChoferes();

        assertEquals(ISistema.TipoRet.OK,s.deshabilitarAmbulancia("SBT6100"));
        assertEquals(ISistema.TipoRet.OK,s.habilitarAmbulancia("SBT6100"));
        assertEquals(ISistema.TipoRet.OK,s.informeAmbulancia(5));
        assertEquals(ISistema.TipoRet.OK,s.buscarAmbulancia("SBT6100"));
        assertEquals(ISistema.TipoRet.ERROR,s.buscarAmbulancia("2222"));
        assertEquals(ISistema.TipoRet.OK,s.buscarAmbulancia("SBT6101"));
        assertEquals(ISistema.TipoRet.OK,s.deshabilitarAmbulancia("SBT6100"));
        assertEquals(ISistema.TipoRet.OK,s.deshabilitarAmbulancia("SBT6101"));
        assertEquals(ISistema.TipoRet.OK,s.deshabilitarAmbulancia("SBT6102"));
        assertEquals(ISistema.TipoRet.OK,s.informeAmbulancia());
        assertEquals(ISistema.TipoRet.OK, s.ciudadesEnRadio(5, 30));
        assertEquals(ISistema.TipoRet.OK, s.ciudadesEnRadio(5, 1000));
        assertEquals(ISistema.TipoRet.OK, s.rutaMasRapida(5, 1));
        assertEquals(ISistema.TipoRet.OK, s.rutaMasRapida(2, 1));
        assertEquals(ISistema.TipoRet.OK, s.rutaMasRapida(2, 1));
        assertEquals(ISistema.TipoRet.OK, s.informeCiudades());
        assertEquals(ISistema.TipoRet.OK, s.informeChoferes("SBT6100"));

        FuncionalidadesComunes.ImprimirFinDeTest();

    }

   


}
