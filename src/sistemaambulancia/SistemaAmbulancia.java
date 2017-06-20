package sistemaambulancia;

import TADAmbulancia.ListaAmbulancia;
import TADChofer.ListaChofer;
import TADCiudad.ListaCiudad;
import sistemaambulancia.dominio.Ambulancia;
import sistemaambulancia.dominio.Chofer;
import sistemaambulancia.dominio.Ciudad;

public class SistemaAmbulancia implements ISistema {

    private int mapa[][];
    private ListaAmbulancia listaAmbulancias;
    private ListaChofer listaChoferes;
    private ListaCiudad listaCiudades;

    @Override
    public TipoRet crearSistemaDeEmergencias(int cantidadCiudades) {
        listaCiudades = new ListaCiudad(cantidadCiudades);

        if (cantidadCiudades <= 0) {
            System.out.println("La cantidad de ciudades es inferior a 1.");
            return TipoRet.ERROR;
        } else {
            mapa = new int[cantidadCiudades][cantidadCiudades];
            for (int i = 0; i < mapa.length; i++) {
                for (int j = 0; j < mapa[i].length; j++) {
                    if (i == j) {
                        mapa[i][j] = 0;
                    } else {
                        mapa[i][j] = -1;
                    }
                }
            }
            return TipoRet.OK;
        }
    }

    @Override
    public TipoRet eliminarAmbulancia(String ambulanciaID) {
        //Busco ambulancia
        Ambulancia ambu = listaAmbulancias.buscar(ambulanciaID);

        //Si no esta vacia entonces encontro la ambulancia
        if (ambu != null) {
            //Si no esta en estado de emergencia entonces borro la ambulancia
            if (ambu.getEstado() != Ambulancia.TipoEstado.ATENDIENDO_EMERGENCIA) {
                listaAmbulancias.eliminarAmbulancia(ambulanciaID);
                return TipoRet.OK;
            } else {
                System.out.println("No es posible eliminar la ambulancia ambulanciaID");
                return TipoRet.ERROR;
            }
        } else {
            System.out.println("No existe una ambulancia con identificador ambulanciaID");
            return TipoRet.ERROR;
        }
    }

    @Override
    public TipoRet destruirSistemaEmergencias() {
        //Pongo todo en null, entonces luego el sistema con el recolector de basura se encarga de destruir 
        this.listaAmbulancias = null;
        this.listaCiudades = null;
        this.mapa = null;
        this.listaChoferes = null;

        //Recolector de Basura (Garbage Collection) 
        System.gc();

        return TipoRet.OK;
    }

    @Override
    public TipoRet registrarAmbulancia(String ambulanciaID, int ciudadID) {
        //Si no existe el id de ambulancia en la listaAmbulancias entonces creo
        //la ciudad referenciada a ese ciudadId para enviar por parametro al crear la nueva ambulancia.
        if (!listaAmbulancias.contains(ambulanciaID)) {
            Ciudad ciu = listaCiudades.buscar(ciudadID);

            if (ciu != null) {
                Ambulancia ambu = new Ambulancia(ambulanciaID, ciu);
                listaAmbulancias.insertarOrdenado(ambu);
                ciu.getAmbulancias().insertarOrdenado(ambu);
                return TipoRet.OK;
            } else {
                System.out.println("La ciudad  ciudadID no existe.");
                return TipoRet.ERROR;
            }
        } else {
            System.out.println("Ya existe una ambulancia con identificador ambulanciaID");
            return TipoRet.ERROR;
        }
    }

    @Override
    public TipoRet deshabilitarAmbulancia(String ambulanciaID) {
        //Busco ambulancia
        Ambulancia ambu = listaAmbulancias.buscar(ambulanciaID);

        //Si no esta vacia entonces encontro la ambulancia
        if (ambu != null) {
            //Si la ambulancia no esta en emergencia
            if (ambu.getEstado() != Ambulancia.TipoEstado.ATENDIENDO_EMERGENCIA) {
                //Si la ambulancia no esta en estado no disponible entonces le asigno estado no disponible 
                if (ambu.getEstado() != Ambulancia.TipoEstado.NO_DISPONIBLE) {
                    ambu.setEstado(Ambulancia.TipoEstado.NO_DISPONIBLE);
                    return TipoRet.OK;
                } else {
                    System.out.println("La ambulancia ambulanciaID ya está en estado NO_DISPONIBLE.");
                    return TipoRet.ERROR;
                }
            } else {
                System.out.println("No es posible deshabilitar la ambulancia ambulanciaID.");
                return TipoRet.ERROR;
            }
        } else {
            System.out.println("No existe una ambulancia con identificador ambulanciaID");
            return TipoRet.ERROR;
        }
    }

    @Override
    public TipoRet habilitarAmbulancia(String ambulanciaID) {
        //Busco ambulancia
        Ambulancia ambu = listaAmbulancias.buscar(ambulanciaID);

        //Si no esta vacia entonces encontro la ambulancia
        if (ambu != null) {
            //Si la ambulancia no esta en estado  disponible entonces le asigno estado disponible 
            if (ambu.getEstado() != Ambulancia.TipoEstado.DISPONIBLE) {
                ambu.setEstado(Ambulancia.TipoEstado.DISPONIBLE);
                return TipoRet.OK;
            } else {
                System.out.println("La ambulancia ambulanciaID ya está habilitada.");
                return TipoRet.ERROR;
            }
        } else {
            System.out.println("No existe una ambulancia con identificador ambulanciaID");
            return TipoRet.ERROR;
        }
    }

    @Override
    public TipoRet buscarAmbulancia(String ambulanciaID) {
        //Busco ambulancia
        Ambulancia ambu = listaAmbulancias.buscar(ambulanciaID);

        //Sil la ambulancia no esta vacia entonces la encontro
        if (ambu != null) {
            //Imprimo en pantalla con el formato establecido en el tostring del objeto
            System.out.println(ambu.toString());
            return TipoRet.OK;
        } else {
            System.out.println("No existe una ambulancia con identificador ambulanciaID");
            return TipoRet.ERROR;
        }
    }

    @Override
    public TipoRet informeAmbulancia() {
        //Si la lista de ambulancias no esta vacia entonces llamo a mostrarAmbulancias
        if (!listaAmbulancias.esVacia()) {
            System.out.println("Listado de ambulancias:");
            listaAmbulancias.mostrarAmbulancias();
        } else {
            System.out.println("No se han ingresado ambulancias");
        }

        return TipoRet.OK;
    }

    //2.2.7 INFORME AMBULANCIAS POR CIUDAD
    @Override
    public TipoRet informeAmbulancia(int ciudadID) {
        //Busco ciudad
        Ciudad ciu = listaCiudades.buscar(ciudadID);

        //Sil la ciudad no esta vacia entonces  muestro ambulancias en esa ciudad
        if (ciu != null) {
            listaAmbulancias.mostrarAmbulanciasPorCiudad(ciudadID);
            return TipoRet.OK;
        } else {
            System.out.println("La ciudadID no existe.");
            return TipoRet.ERROR;
        }
    }

    @Override
    public TipoRet cambiarUbicacion(String ambulanciaID, int ciudadID) {
        //Busco ambulancia y ciudad
        Ambulancia ambu = listaAmbulancias.buscar(ambulanciaID);
        Ciudad ciuNueva = listaCiudades.buscar(ciudadID);
        //Guardo el valor de la ciudad de donde parte la ambulancia
        Ciudad ciuVieja = ambu.getCiudad();

        if (ambu != null) {
            if (ciuNueva != null) {
                ambu.setCiudad(ciuNueva);   //SETEO CIUDAD DE DESTINO
                ciuNueva.getAmbulancias().insertarOrdenado(ambu);  //A LA CIUDAD DE DESTINO LE AGREGO LA AMBULANCIA
                ciuVieja.getAmbulancias().eliminarAmbulancia(ambulanciaID);   //A LA CIUDAD VIEJA LE QUITO LA AMBULANCIA
                return TipoRet.OK;
            } else {
                System.out.println("La ciudad ciudadID no existe");
                return TipoRet.ERROR;
            }
        } else {
            System.out.println("No existe una ambulancia con identificador ambulanciaID");
            return TipoRet.ERROR;
        }
    }

    @Override
    public TipoRet agregarCiudad(String ciudadNombre) {
        //controlar que el mapa no este lleno  y no se puedan agregar mas ciudades

        //verifica que el mapa no este vacio, que la lista de ciudades no este llena
        if (mapa.length > 0 && !listaCiudades.estaLlena()) {
            //compruebo que no exista esa ciudad con ese nombre  
            if (listaCiudades.contains(ciudadNombre)) {
                System.out.println("Ya existe una ciudad con ese nombre");
                return TipoRet.ERROR;
            } else {
                //inserto ciudad a la lista de ciudades
                Ciudad c = new Ciudad(ciudadNombre);
                listaCiudades.insertarOrdenado(c);
                return TipoRet.OK;

            }
        } else {
            System.out.println("“No se pueden ingresar la ciudadNombre al sistema por no tener más capacidad.");
            return TipoRet.ERROR;

        }

    }

    @Override
    public TipoRet listarCiudades() {

        if (listaCiudades.esVacia()) {
            System.out.println("No existen ciudades en el mapa.");
        } else {
            System.out.println("Ciudades en el mapa" + "\n");
            listaCiudades.mostrarCiudades();
        }
        return TipoRet.OK;

    }

    @Override
    public TipoRet agregarRuta(int ciudadOrigen, int ciudadDestino, int minutosViaje) {

        //se fija si las ciudades con sus ids existen en la lista de ciudades y que la duracion sea mayor a 0
        if (this.listaCiudades.buscar(ciudadOrigen) == null) {
            System.out.println("La ciudad " + ciudadOrigen + " no existe.");
            return TipoRet.ERROR;
        } else if (this.listaCiudades.buscar(ciudadDestino) == null) {
            System.out.println("La ciudad " + ciudadDestino + " no existe.");
            return TipoRet.ERROR;
        } else if (minutosViaje <= 0) {
            System.out.println("La duración del viaje debe ser mayor que 0.");
            return TipoRet.ERROR;
            // comprueba que la ciudad no sea la misma    
        } else if (ciudadDestino == ciudadOrigen) {
            System.out.println("La ciudad Origen es igual a la ciudad Destino");
            return TipoRet.ERROR;
        } else {
            //existen las 2 ciudades y la duracion es mayor a 0
            mapa[ciudadOrigen][ciudadDestino] = minutosViaje;
            mapa[ciudadDestino][ciudadOrigen] = minutosViaje;
            return TipoRet.OK;
        }
    }

    @Override
    public TipoRet modificarDemora(int ciudadOrigen, int ciudadDestino, int minutosViaje) {

        //se fija si las ciudades con sus ids existen en la lista de ciudades y que la duracion sea mayor a 0
        if (this.listaCiudades.buscar(ciudadOrigen) == null) {
            System.out.println("La ciudad " + ciudadOrigen + " no existe.");
            return TipoRet.ERROR;
        } else if (this.listaCiudades.buscar(ciudadDestino) == null) {
            System.out.println("La ciudad " + ciudadDestino + " no existe.");
            return TipoRet.ERROR;
        } else if (minutosViaje <= 0) {
            System.out.println("La duración del viaje debe ser mayor que 0.");
            return TipoRet.ERROR;
            // comprueba que la ciudad no sea la misma    
        } else if (ciudadDestino == ciudadOrigen) {
            System.out.println("La ciudad Origen es igual a la ciudad Destino");
            return TipoRet.ERROR;
        } else {
            //existen las 2 ciudades y la duracion es mayor a 0
            //se fija si la posicion a modificar nunca fue agregada,
            //si es -1, es decir que nunca se agrego llama a agregar ruta, sino la agrega.
            if (mapa[ciudadOrigen][ciudadDestino] == -1) {
                agregarRuta(ciudadOrigen, ciudadDestino, minutosViaje);
                return TipoRet.OK;
            } else {
                mapa[ciudadOrigen][ciudadDestino] = minutosViaje;
                mapa[ciudadDestino][ciudadOrigen] = minutosViaje;
                return TipoRet.OK;
            }
        }
    }

    @Override
    public TipoRet ambulanciaMasCercana(int ciudadID) {

        if (this.listaCiudades.buscar(ciudadID) != null) {
            //terminar
        } else {
            System.out.println("La ciudad " + ciudadID + " no existe.");
        }

        return TipoRet.NO_IMPLEMENTADA;
    }

    @Override
    public TipoRet rutaMasRapida(int ciudadOrigen, int ciudadDestino) {
        //Busco ciudades
        Ciudad ciuOrigen = listaCiudades.buscar(ciudadOrigen);
        Ciudad ciuDestino = listaCiudades.buscar(ciudadDestino);

        if (ciuOrigen != null) {
            if (ciuDestino != null) {
                int camino = 0;
                int columnas = mapa[0].length;
                int columna = 0;
                int suma;
                int minimo = 9999;

                for (int i = 0; i < columnas; i++) {
                    if (mapa[ciudadOrigen][i] != 0 && mapa[ciudadDestino][i] != 0) {
                        suma = mapa[ciudadOrigen][i] + mapa[ciudadDestino][i];
                        if (suma < minimo) {
                            minimo = suma;
                            columna = i;
                        }
                    }
                }
                
                System.out.println("ciudad origen : " + ciudadOrigen 
                    +  "Escala : " + columna + "  destino :" + ciudadDestino + "  duracion :" + minimo
                );
                return TipoRet.OK;
            } else {
                System.out.println("La ciudad ciudadDestino no existe");
                return TipoRet.ERROR;
            }
        } else {
            System.out.println("La ciudad ciudadOrigen no existe");
            return TipoRet.ERROR;
        }
    }

    @Override
    public TipoRet informeCiudades() {

        return TipoRet.NO_IMPLEMENTADA;
    }

    @Override
    public TipoRet ciudadesEnRadio(int ciudadID, int duracionViaje) {
        return TipoRet.NO_IMPLEMENTADA;
    }

    @Override
    public TipoRet registrarChofer(String ambulanciaID, String nombre, String cedula) {
        //Busco ambulancia
        Ambulancia ambu = listaAmbulancias.buscar(ambulanciaID);

        //Si la ambulancia no esta vacia entonces encontro la ambulancia
        if (ambu != null) {
            //Si no existe ya un chofer con esa cedula 
            if (!listaChoferes.contains(cedula)) {
                //Creo chofer y lo agrego a la lista
                Chofer chofer = new Chofer(cedula, nombre, ambulanciaID);
                listaChoferes.insertarOrdenado(chofer);
                return TipoRet.OK;
            } else {
                System.out.println("Ya existe un chofer con esa cedula habilitado para conducir una ambulancia");
                return TipoRet.ERROR;
            }
        } else {
            System.out.println("No existe una ambulancia con identificador ambulanciaID");
            return TipoRet.ERROR;
        }
    }

    @Override
    public TipoRet eliminarChofer(String ambulanciaID, String cedula) {
        //Busco ambulancia
        Ambulancia ambu = listaAmbulancias.buscar(ambulanciaID);
        //Busco chofer
        Chofer chofer = listaChoferes.buscar(cedula);

        //Si la ambulancia no esta vacia entonces encontro la ambulancia
        if (ambu != null) {
            if (chofer != null) {
                //Lo elimino de la lista de choferes haiblitados para esta ambulancia
                ambu.getChoferes().eliminarChofer(cedula);
                return TipoRet.OK;
            } else {
                System.out.println("No existe ese chofer con esa cedula");
                return TipoRet.ERROR;
            }
        } else {
            System.out.println("No existe una ambulancia con identificador ambulanciaID");
            return TipoRet.ERROR;
        }
    }

    @Override
    public TipoRet informeChoferes(String ambulanciaID) {
        //Busco ambulancia
        Ambulancia ambu = listaAmbulancias.buscar(ambulanciaID);

        //Si la ambulancia no esta vacia entonces encontro la ambulancia
        if (ambu != null) {
            System.out.println("Informe choferes de <" + ambulanciaID + ">");

            //Muestro lista de choferes habilitados en esta ambulancia 
            ambu.getChoferes().mostrarChoferes();
            return TipoRet.OK;
        } else {
            System.out.println("No existe una ambulancia con identificador ambulanciaID");
            return TipoRet.ERROR;
        }
    }
}
