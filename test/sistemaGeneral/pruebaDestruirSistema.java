/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaGeneral;

import sistemaambulancia.ISistema;
import sistemaambulancia.SistemaAmbulancia;
import org.junit.Test;
import static org.junit.Assert.*;
import utils.FuncionalidadesComunes;

/**
 *
 * @author docenteFI
 */
public class pruebaDestruirSistema {
    
    public pruebaDestruirSistema() {
    }

  @Test
  public void testDestruirSistemaConSistemaVacio() {
        ISistema s = new SistemaAmbulancia();
        s.crearSistemaDeEmergencias(10);
        assertEquals(ISistema.TipoRet.OK,s.destruirSistemaEmergencias());
  }
  
  @Test
  public void testDestruirSistemaConSistemaConAmbulancias() {
        ISistema s= FuncionalidadesComunes.crearSistemaConXCiudadesUnaAmbulanciaPorCiudad(100);
        assertEquals(ISistema.TipoRet.OK,s.destruirSistemaEmergencias());
  }
  @Test
  public void testDestruirSistemaConSistemaConAmbulanciasYRutas() {
        ISistema s= FuncionalidadesComunes.crearSistemaConCincoCiudadesDiezAmbulanciasSieteRutasCuatroChoferes();
        assertEquals(ISistema.TipoRet.OK,s.destruirSistemaEmergencias());
  }
  
  @Test
  public void testDestruirSistemaConSistemaConAmbulanciasChoferesYRutas() {
        ISistema s = new SistemaAmbulancia();
        s.crearSistemaDeEmergencias(10);
        assertEquals(ISistema.TipoRet.OK,s.destruirSistemaEmergencias());
  }
  
}
