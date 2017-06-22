package sistemaambulancia.dominio;

import sistemaambulancia.ISistema;
import sistemaambulancia.SistemaAmbulancia;

public class Test
{
    public static void main(String[] args)
    {
        //Instanceo prueba
        Prueba p = new Prueba();

        //Instanceo sistema
        SistemaAmbulancia s = new SistemaAmbulancia();

        //Prueba nuestra
        pruebaObligatorio(s, p);
    }

    //Metodo que ejecuta las pruebas
    //Recibe por parametro al sistema y a la prueba que va testear el sistema
    public static void pruebaObligatorio(SistemaAmbulancia s, Prueba p)
    {
        //Creo sistema de emergencias con 5 ciudades
        p.ver(s.crearSistemaDeEmergencias(5), ISistema.TipoRet.OK, "Se crea el sistema para 5 ciudades.");

        //Listo ciudades para verificar que no hayan en el sistema
        p.ver(s.listarCiudades(), ISistema.TipoRet.OK, "Se notifica que no hay ciudades ingresadas en el mapa.");

        
        //Agrego ciudades
        p.ver(s.agregarCiudad("Montevideo"), ISistema.TipoRet.OK, "Se agrega Montevideo al sistema.");

        p.ver(s.agregarCiudad("Montevideo"), ISistema.TipoRet.ERROR, "Se intenta agregar Montevideo que ya existe.");

        p.ver(s.agregarCiudad("Maldonado"), ISistema.TipoRet.OK, "Se agrega Maldonado al sistema.");

        p.ver(s.agregarCiudad("San José"), ISistema.TipoRet.OK, "Se agrega San José al sistema.");

        p.ver(s.agregarCiudad("Canelones"), ISistema.TipoRet.OK, "Se agrega Canelones al sistema.");

        p.ver(s.agregarCiudad("Colonia"), ISistema.TipoRet.OK, "Se agrega Colonia al sistema.");

        p.ver(s.agregarCiudad("Salto"), ISistema.TipoRet.ERROR, "Se intenta agregar Salto y se sobrepasa el límite permitido.");

        
        //Listo las ciudades para ver si las agrego al sistema
        p.ver(s.listarCiudades(), ISistema.TipoRet.OK, "Se listan todas las ciudades del mapa.");

        //Se agregan rutas y se modifican demoras
        p.ver(s.agregarRuta(-1, 4, 46), ISistema.TipoRet.ERROR, "Se intenta agregar una ruta para la ciudad Origen -1.");

        p.ver(s.agregarRuta(1, -1, 46), ISistema.TipoRet.ERROR, "Se intenta agregar una ruta para la ciudad Destino -1.");

        p.ver(s.agregarRuta(1, 4, 0), ISistema.TipoRet.ERROR, "Se intenta agregar una ruta de duración 0 minutos.");

        
        p.ver(s.agregarRuta(1, 4, 46), ISistema.TipoRet.OK, "Se agrega la ruta entre ciudades 1 y 4 con 46 minutos.");

        p.ver(s.agregarRuta(1, 3, 93), ISistema.TipoRet.OK, "Se agrega la ruta entre ciudades 1 y 3 con 93 minutos.");

        p.ver(s.agregarRuta(1, 2, 134), ISistema.TipoRet.OK, "Se agrega la ruta entre ciudades 1 y 2 con 134 minutos.");

        p.ver(s.agregarRuta(2, 4, 155), ISistema.TipoRet.OK, "Se agrega la ruta entre ciudades 2 y 4 con 155 minutos.");

        p.ver(s.agregarRuta(3, 4, 47), ISistema.TipoRet.OK, "Se agrega la ruta entre ciudades 3 y 4 con 47 minutos.");

        p.ver(s.agregarRuta(3, 4, 108), ISistema.TipoRet.OK, "Se agrega la ruta entre ciudades 3 y 4 con 108 minutos.");

        p.ver(s.agregarRuta(0, 4, 151), ISistema.TipoRet.OK, "Se agrega la ruta entre ciudades 0 y 4 con 151 minutos.");

        p.ver(s.rutaMasRapida(3, 2), ISistema.TipoRet.OK, "Se busca la ruta más rápida entre las ciudades 3 y 2.");



        p.ver(s.agregarRuta(-1, 4, 46), ISistema.TipoRet.ERROR, "Se intenta modificar una demora para la ciudad Origen -1.");

        p.ver(s.agregarRuta(1, -1, 40), ISistema.TipoRet.ERROR, "Se intenta modificar una demora para la ciudad Destino -1.");

        p.ver(s.agregarRuta(1, 4, 0), ISistema.TipoRet.ERROR, "Se intenta modificar una demora de duración 0 minutos.");

        p.ver(s.modificarDemora(1, 3, 20), ISistema.TipoRet.OK, "Se modifica una demora entre ciudades 1 y 3 con 20 minutos.");

        p.ver(s.rutaMasRapida(3, 2), ISistema.TipoRet.OK, "Se busca la ruta más rápida entre las ciudades 3 y 2.");



        //Informe de ambulancias para verificar que no haya en el sistema

        p.ver(s.informeAmbulancia(), ISistema.TipoRet.OK, "No hay ambulancias para mostrar en el sistema de emergencias.");

        //Ambulancia mas cercana para verificar que no hay ninguna
        p.ver(s.ambulanciaMasCercana(2), ISistema.TipoRet.ERROR, "No hay ambulancias más cercanas a la ciudad 2 porque éstas no se han creado.");


        //Registro ambulancias
        p.ver(s.registrarAmbulancia("SAS0001", 0), ISistema.TipoRet.OK, "Se ingresa la ambulancia SAS0001 a la ciudad 1.");

        p.ver(s.registrarAmbulancia("SAS0002", 0), ISistema.TipoRet.OK, "Se ingresa la ambulancia SAS0002 a la ciudad 1.");

        p.ver(s.registrarAmbulancia("SAS0003", 0), ISistema.TipoRet.OK, "Se ingresa la ambulancia SAS0003 a la ciudad 1.");



        p.ver(s.registrarAmbulancia("SAS0001", 1), ISistema.TipoRet.ERROR, "Se intenta agregar la ambulancia SAS0001 a la ciudad 1, pero ésta ya fue ingresada anteriormente a esa ciudad.");

        p.ver(s.registrarAmbulancia("SAS0001", 2), ISistema.TipoRet.ERROR, "Se intenta agregar la ambulancia SAS0001 a la ciudad 2, pero ésta ya fue ingresada a la ciudad 1.");



        p.ver(s.registrarAmbulancia("B110004", 2), ISistema.TipoRet.OK, "Se ingresa la ambulancia B110004 a la ciudad 2.");

        p.ver(s.registrarAmbulancia("B110005", 2), ISistema.TipoRet.OK, "Se ingresa la ambulancia B110005 a la ciudad 2.");



        p.ver(s.registrarAmbulancia("MAS0006", 3), ISistema.TipoRet.OK, "Se ingresa la ambulancia MAS0006 a la ciudad 3.");



        p.ver(s.registrarAmbulancia("AAS0007", 4), ISistema.TipoRet.OK, "Se ingresa la ambulancia AAS0007 a la ciudad 4.");

        p.ver(s.registrarAmbulancia("AAS0008", 4), ISistema.TipoRet.OK, "Se ingresa la ambulancia AAS0008 a la ciudad 4.");



        p.ver(s.registrarAmbulancia("LAS0009", 2), ISistema.TipoRet.OK, "Se ingresa la ambulancia LAS0009 a la ciudad 5.");

        p.ver(s.registrarAmbulancia("LAS0010", 3), ISistema.TipoRet.OK, "Se ingresa la ambulancia LAS0010 a la ciudad 5.");

        
        //Informe de ambulancia para verificar que se hayan agregado
        p.ver(s.informeAmbulancia(), ISistema.TipoRet.OK, "Se detallan todas las ambulancias del sistema.");



        //Habilitar-deshabilirar ambulancias

        p.ver(s.deshabilitarAmbulancia("SAS0001"), ISistema.TipoRet.OK, "Se deshabilita la ambulancia SAS0001.");

        p.ver(s.informeAmbulancia(), ISistema.TipoRet.OK, "Se detallan todas las ambulancias del sistema.");



        p.ver(s.deshabilitarAmbulancia("SAS0001"), ISistema.TipoRet.ERROR, "La ambulancia SAS0001 ya está deshabilitada.");

        p.ver(s.deshabilitarAmbulancia("SAS3333"), ISistema.TipoRet.ERROR, "La ambulancia SAS3333 no existe, por lo tanto no se puede deshabilitar.");

        p.ver(s.habilitarAmbulancia("SAS0001"), ISistema.TipoRet.OK, "Se habilita la ambulancia SAS0001.");

        p.ver(s.informeAmbulancia(), ISistema.TipoRet.OK, "Se detallan todas las ambulancias del sistema.");



        //Buscar ambulancia - informe

        p.ver(s.buscarAmbulancia("SAS0001"), ISistema.TipoRet.OK, "Se encontró la ambulancia SAS0001. Detalles a continuación:");

        p.ver(s.buscarAmbulancia("SAS3333"), ISistema.TipoRet.ERROR, "La ambulancia SAS3333 no existe.");



        p.ver(s.informeAmbulancia(), ISistema.TipoRet.OK, "Se detallan todas las ambulancias del sistema.");

        p.ver(s.deshabilitarAmbulancia("SAS0001"), ISistema.TipoRet.OK, "Se deshabilita la ambulancia SAS0001.");

        p.ver(s.informeAmbulancia(0), ISistema.TipoRet.OK, "Se detallan todas las ambulancias disponibles para la ciudad 1.");

        p.ver(s.informeAmbulancia(6), ISistema.TipoRet.ERROR, "La ciudad 6 no existe en el sistema, por lo tanto no se puede obtener información de sus ambulancias..");



        //Eliminar ambulancia

        p.ver(s.eliminarAmbulancia("SAS0002"), ISistema.TipoRet.OK, "Se elimina la ambulancia SAS0002.");

        p.ver(s.eliminarAmbulancia("SAS3333"), ISistema.TipoRet.ERROR, "La ambulancia SAS3333 no existe, por lo tanto no se puede eliminar.");

        
        //Informe ambulancia para verificar que las elimino
        p.ver(s.informeAmbulancia(1), ISistema.TipoRet.OK, "Se detallan todas las ambulancias disponibles del sistema para la ciudad 1.");


        //Cambiar ubicación ambulancia

        p.ver(s.cambiarUbicacion("B110004", 3), ISistema.TipoRet.OK, "Se modificó la ubicación de la ambulancia B110004 para la ciudad 3.");

        p.ver(s.cambiarUbicacion("SAS3333", 3), ISistema.TipoRet.ERROR, "Esa ambulancia SAS3333 no existe, por lo tanto no se puede modificar su ubicación.");


        //Informe ambulancia para verificar cambios
        p.ver(s.informeAmbulancia(), ISistema.TipoRet.OK, "Se detallan todas las ambulancias del sistema.");

        p.ver(s.informeAmbulancia(2), ISistema.TipoRet.OK, "Se detallan todas las ambulancias disponibles del sistema para la ciudad 2.");

        p.ver(s.informeAmbulancia(3), ISistema.TipoRet.OK, "Se detallan todas las ambulancias disponibles del sistema para la ciudad 3.");


        //Ambulancia mas cercana y cambios de ubicacion
        p.ver(s.ambulanciaMasCercana(2), ISistema.TipoRet.OK, "Informa cuál es la ambulancia más cercana a la ciudad 2 y a cuántos minutos.");

        p.ver(s.cambiarUbicacion("B110005", 3), ISistema.TipoRet.OK, "Se modificó la ubicación de la ambulancia B11005 para la ciudad 3.");

        p.ver(s.ambulanciaMasCercana(2), ISistema.TipoRet.OK, "Informa cuál es la ambulancia más cercana y a cuánto.");



        //Camino mas corto entre 2 ciudades distintas

        p.ver(s.rutaMasRapida(2, 4), ISistema.TipoRet.OK, "Se busca la ruta más rápida entre las ciudades 2 y 4.");

        p.ver(s.rutaMasRapida(4, 1), ISistema.TipoRet.OK, "Se busca la ruta más rápida entre las ciudades 4 y 1.");



        //Ingreso de choferes

        p.ver(s.registrarChofer("SAS3333", "Diego Gómez", "23456789"), ISistema.TipoRet.ERROR, "La ambulancia SAS3333 no existe, por lo tanto no se le puede habilitar el chofer.");

        p.ver(s.registrarChofer("SAS0003", "Diego Gómez", "23456789"), ISistema.TipoRet.OK, "Se asigna chofer Diego Gómez(23456789) a la ambulancia SAS0003.");



        p.ver(s.registrarChofer("MAS0006", "Juan Pérez", "12345678"), ISistema.TipoRet.OK, "Se asigna chofer Juan Pérez(12345678) a la ambulancia MAS0006.");

        p.ver(s.registrarChofer("LAS0009", "Juan Pérez", "12345678"), ISistema.TipoRet.OK, "Se asigna el mismo chofer Juan Pérez(12345678) a otra ambulancia LAS0009");



        p.ver(s.registrarChofer("MAS0006", "Ana Alvez", "45678901"), ISistema.TipoRet.OK, "Se asigna chofer Ana Alvez(45678901) a la ambulancia MAS0006.");

        p.ver(s.registrarChofer("LAS0010", "Jorge Ramos", "34567890"), ISistema.TipoRet.OK, "Se asigna chofer Jorge Ramos(34567890) a la ambulancia LAS0010.");


        //Informe de choferes
        p.ver(s.informeChoferes("MAS0006"), ISistema.TipoRet.OK, "Se detallan todos los choferes de la ambulancia MAS0006.");

        p.ver(s.informeChoferes("AAS0008"), ISistema.TipoRet.OK, "No hay choferes asignados para la ambulancia AA0008.");

        p.ver(s.informeChoferes("SAS3333"), ISistema.TipoRet.ERROR, "No existe la ambulancia SAS3333, por lo tanto no se pueden detallar choferes.");



        //Eliminar chofer

        p.ver(s.informeChoferes("LAS0010"), ISistema.TipoRet.OK, "Se detallan todos los choferes de la ambulancia LAS0010.");

        p.ver(s.eliminarChofer("LAS0010", "34567890"), ISistema.TipoRet.OK, "Se elimina chofer 34567890 de la ambulancia LAS0010.");

        p.ver(s.eliminarChofer("SAS3333", "34567890"), ISistema.TipoRet.ERROR, "La ambulancia SAS3333 no existe, por lo tanto no se le puede eliminar el chofer 34567890.");

        //Informe chofer para verificar eliminacion
        p.ver(s.informeChoferes("LAS0010"), ISistema.TipoRet.OK, "Se detallan todos los choferes de la ambulancia LAS0010.");


        //Ciudad en radio
        p.ver(s.ciudadesEnRadio(6, 100), ISistema.TipoRet.ERROR, "La ciudad 6 no existe en el sistema.");

        p.ver(s.ciudadesEnRadio(1, 0), ISistema.TipoRet.ERROR, "La duración del viaje es menor o igual a 0.");

        p.ver(s.ciudadesEnRadio(1, 100), ISistema.TipoRet.OK, "Ciudades próximas a 1 en radio temporal máximo de 100: se pudo efectuar la operación exitosamente.");

        p.ver(s.ciudadesEnRadio(1, 10), ISistema.TipoRet.OK, "Ciudades próximas a 1 en radio temporal máximo de 10: no hay ciudades a menos del tiempo requerido.");


        //Informe ciudades-ambulancia
        p.ver(s.informeCiudades(), ISistema.TipoRet.OK, "Se imprime informe de todas las ciudades del sistema de emergencia.");

        //destruir sistema
        p.ver(s.destruirSistemaEmergencias(), ISistema.TipoRet.OK, "Sistema de emergencias destruido.");

        
        //Creo nuevo sistema para checkear que se inicializen las listas y halla quedado todo borrado
        p.ver(s.crearSistemaDeEmergencias(3), ISistema.TipoRet.OK, "Se crea el sistema para 3 ciudades.");

        //Listo ciudades y ambulancias para verificar que no hay
        p.ver(s.listarCiudades(), ISistema.TipoRet.OK, "Se notifica que no hay ciudades ingresadas en el mapa.");

        p.ver(s.informeAmbulancia(), ISistema.TipoRet.OK, "No hay ambulancias para mostrar.");

        p.ver(s.listarCiudades(), ISistema.TipoRet.OK, "Se notifica que no hay ciudades ingresadas en el mapa.");

        
        //Agrego ciudades y las listo
        p.ver(s.agregarCiudad("Montevideo"), ISistema.TipoRet.OK, "Se agrega Montevideo al sistema.");

        p.ver(s.agregarCiudad("Maldonado"), ISistema.TipoRet.OK, "Se agrega Maldonado al sistema.");

        p.ver(s.agregarCiudad("Artigas"), ISistema.TipoRet.OK, "Se agrega Artigas al sistema.");

        p.ver(s.listarCiudades(), ISistema.TipoRet.OK, "Se listan las ciudades del mapa.");


        //Informe de ambulancia para verificar que no hay
        //Agregar ambulancia y checkeo
        p.ver(s.informeAmbulancia(1), ISistema.TipoRet.OK, "No hay ambulancias ingresadas en el sistema.");

        p.ver(s.registrarAmbulancia("SAS0003", 1), ISistema.TipoRet.OK, "Se ingresa la ambulancia SAS0003 a la ciudad 1.");

        p.ver(s.informeAmbulancia(1), ISistema.TipoRet.OK, "Se muestra la lista de ambulancias para la ciudad 1.");

        p.ver(s.informeChoferes("SAS0003"), ISistema.TipoRet.OK, "No hay choferes asignados para esa ambulancia SAS0003.");


        //Agrego rutas
        p.ver(s.agregarRuta(3, 4, 108), ISistema.TipoRet.ERROR, "La ciudad 4 no existe, por lo tanto no se puede agregar ruta.");

        p.ver(s.agregarRuta(2, 1, 90), ISistema.TipoRet.OK, "Se agrega la ruta entre ciudades 3 y 1 con 90 minutos.");

        p.ver(s.ciudadesEnRadio(1, 100), ISistema.TipoRet.OK, "Ciudades próximas a 1 en radio temporal máximo de 100: se pudo efectuar la operación exitosamente.");


        //Imprimo resultados
        p.imprimirResultadosPrueba();

        //Mensaje fin de prueba
        p.imprimirComentario("\n---------FIN DE PRUEBA---------\n");
    }
}
