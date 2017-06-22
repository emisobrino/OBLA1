/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjuntoDePruebas;

/**
 *
 * @author michel.camarotta
 */
import ambulancias.pruebaBuscarAmbulancia;
import ambulancias.pruebaCambiarUbicacionAmbulancia;
import ambulancias.pruebaDeshabilitarAmbulancia;
import ambulancias.pruebaEliminarAmbulancia;
import ambulancias.pruebaHabilitarAmbulancia;
import ambulancias.pruebaInformeAmbulancia;
import ambulancias.pruebaInformeAmbulanciaPorCiudad;
import ambulancias.pruebaRegistrarAmbulancia;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    pruebaRegistrarAmbulancia.class,
    pruebaEliminarAmbulancia.class,
    pruebaDeshabilitarAmbulancia.class,
    pruebaHabilitarAmbulancia.class,
    pruebaBuscarAmbulancia.class,
    pruebaCambiarUbicacionAmbulancia.class,
    pruebaInformeAmbulancia.class,
    pruebaInformeAmbulanciaPorCiudad.class,})
public class ejecutarTodasLasPruebasDeAmbulancia {
    //normally, this is an empty class
}
