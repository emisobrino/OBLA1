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
import mapa.caminos.pruebaAmbulanciaMasCercana;
import mapa.caminos.pruebaCiudadesEnRadio;
import mapa.caminos.pruebaRutaMasRapida;
import mapa.pruebaAgregarCiudad;
import mapa.pruebaAgregarRutaAlMapa;
import mapa.pruebaInformeCiudades;
import mapa.pruebaListarCiudades;
import mapa.pruebaModificarDemoraDeViaje;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    pruebaAgregarCiudad.class,
    pruebaAgregarRutaAlMapa.class,
    pruebaInformeCiudades.class,
    pruebaListarCiudades.class,
    pruebaModificarDemoraDeViaje.class,
    pruebaAmbulanciaMasCercana.class,
    pruebaCiudadesEnRadio.class,
    pruebaRutaMasRapida.class})
public class ejecutarTodasLasPruebasDeMapaOCiudades {
    //normally, this is an empty class
}
