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
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import sistemaGeneral.pruebaGenerales;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ejecutarTodasLasPruebasDeAmbulancia.class, 
        ejecutarTodasLasPruebasDeMapaOCiudades.class,
        ejecutarTodasLasPruebasDeSistema.class,
        pruebaGenerales.class
})
public class ejecutarTodasLasPruebasJuntas {
	//normally, this is an empty class
}