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

/**
 *
 * @author docenteFI
 */
public class pruebaCrearSistema {
    
    public pruebaCrearSistema() {
    }

    @Test
    public void testCrearSistemaConCeroCiudades() {
        ISistema s = new SistemaAmbulancia();
        assertEquals(ISistema.TipoRet.ERROR,s.crearSistemaDeEmergencias(0));
    }
    @Test
    public void testCrearSistemaConNumeroNegativoCiudades() {
        ISistema s = new SistemaAmbulancia();
        assertEquals(ISistema.TipoRet.ERROR,s.crearSistemaDeEmergencias(-100));
    }
    
    @Test
    public void testCrearSistemaConUnoCiudades() {
        ISistema s = new SistemaAmbulancia();
        assertEquals(ISistema.TipoRet.OK,s.crearSistemaDeEmergencias(1));
    }
    
    @Test
    public void testCrearSistemaConMayorAUnoCiudades() {
        ISistema s = new SistemaAmbulancia();
        assertEquals(ISistema.TipoRet.OK,s.crearSistemaDeEmergencias(1000));
    }
    

}
