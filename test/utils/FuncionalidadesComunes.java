package utils;

import sistemaambulancia.ISistema;
import sistemaambulancia.SistemaAmbulancia;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author docenteFI
 */
public class FuncionalidadesComunes {

    public static void ImprimirComienzoDeTest() {

        System.out.println("\n****************** COMIENZO *********************");
        //Retorna el nombre del metodo desde el cual se hace el llamado
        System.out.println(new Exception().getStackTrace()[1].getMethodName());      
        System.out.println("****************************************************\n");

    }
    
    public static void ImprimirFinDeTest() {

        System.out.println("\n***************************************************");
        //Retorna el nombre del metodo desde el cual se hace el llamado
        System.out.println(new Exception().getStackTrace()[1].getMethodName());      
        System.out.println("------------------------ FIN ------------------------\n");

    }

    public static ISistema crearSistemaConXCiudadesUnaAmbulanciaPorCiudad(int x) {

        ISistema s = new SistemaAmbulancia();

        s.crearSistemaDeEmergencias(x);

        for (int i = 1; i <= x; i++) {
            s.agregarCiudad("Ciudad" + i);
            s.registrarAmbulancia("Ambulancia" + i, i);
        }
        return s;

    }

    public static ISistema crearSistemaConCincoCiudadesDiezAmbulanciasSieteRutasCuatroChoferes() {

        ISistema s = new SistemaAmbulancia();

        s.crearSistemaDeEmergencias(10);

        for (int i = 1; i <= 6; i++) {
            s.agregarCiudad("Ciudad" + i);
        }

        s.registrarAmbulancia("SBT6100", 5);
        s.registrarAmbulancia("SBT6101", 5);
        s.registrarAmbulancia("SBT6102", 5);
        s.registrarAmbulancia("SBT6103", 1);
        s.registrarAmbulancia("SBT6104", 1);
        s.registrarAmbulancia("SBT6105", 1);
        s.registrarAmbulancia("SBT6106", 4);
        s.registrarAmbulancia("SBT6107", 4);
        s.registrarAmbulancia("SBT6108", 4);
        s.registrarAmbulancia("SBT6109", 3);

        s.agregarRuta(5, 1, 120);
        s.agregarRuta(5, 2, 140);
        s.agregarRuta(5, 3, 400);
        s.agregarRuta(1, 4, 40);
        s.agregarRuta(2, 3, 40);
        s.agregarRuta(2, 4, 400);

        s.registrarChofer("SBT6100", "Joselo", "12345678");
        s.registrarChofer("SBT6100", "Jacinto", "22345678");
        s.registrarChofer("SBT6100", "Romeo", "32345678");
        s.registrarChofer("SBT6101", "Julieta", "42345678");

        return s;
    }
    
    public static ISistema crearSistemaConDiezCiudadesDiezAmbulanciasSieteRutasCuatroChoferes() {

            ISistema s = new SistemaAmbulancia();

        s.crearSistemaDeEmergencias(11);

        for (int i = 1; i <= 11; i++) {
            s.agregarCiudad("Ciudad" + i);
        }

        s.registrarAmbulancia("SBT6100", 2);
        s.registrarAmbulancia("SBT6101", 2);
        s.registrarAmbulancia("SBT6102", 2);
        s.registrarAmbulancia("SBT6103", 1);
        s.registrarAmbulancia("SBT6104", 1);
        s.registrarAmbulancia("SBT6105", 1);
        s.registrarAmbulancia("SBT6106", 4);
        s.registrarAmbulancia("SBT6107", 4);
        s.registrarAmbulancia("SBT6108", 4);
        s.registrarAmbulancia("SBT6109", 3);

        s.agregarRuta(5, 1, 120);
        s.agregarRuta(5, 2, 140);
        s.agregarRuta(5, 3, 400);
        s.agregarRuta(1, 4, 40);
        s.agregarRuta(2, 3, 40);
        s.agregarRuta(2, 4, 400);

        s.registrarChofer("SBT6100", "Joselo", "12345678");
        s.registrarChofer("SBT6100", "Jacinto", "22345678");
        s.registrarChofer("SBT6100", "Romeo", "32345678");
        s.registrarChofer("SBT6101", "Julieta", "42345678");

        return s;
    }

}
