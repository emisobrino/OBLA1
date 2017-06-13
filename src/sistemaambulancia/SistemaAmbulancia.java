
package sistemaambulancia;

import TADAmbulancia.ListaAmbulancia;
import TADChofer.ListaChofer;
import TADCiudad.ListaCiudad;
import sistemaambulancia.dominio.Ambulancia;
import sistemaambulancia.dominio.Ciudad;




public class SistemaAmbulancia implements ISistema {

    
    private int mapa [][];
    private ListaAmbulancia listaAmbulancias;
    private ListaChofer listaChoferes;
    private ListaCiudad listaCiudades;
    
    
    
    @Override
    public TipoRet crearSistemaDeEmergencias(int cantidadCiudades) {
        listaCiudades = new ListaCiudad(cantidadCiudades);
        if (cantidadCiudades<=0) {
            
            System.out.println("La cantidad de ciudades es inferior a 1.");
            return TipoRet.ERROR;
        }else{
            mapa= new int[cantidadCiudades][cantidadCiudades];
            for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[i].length; j++) {
                if (i==j) {
                    mapa[i][j]=0;
                }else{
                    mapa[i][j]=-1;
                }
            }
        }
            return TipoRet.OK;
        }
                
    }
    
    @Override
    public TipoRet eliminarAmbulancia(String ambulanciaID) {
        return TipoRet.NO_IMPLEMENTADA;

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
    public TipoRet registrarAmbulancia(String ambulanciaId, int ciudadId) 
    {
        //Si no existe el id de ambulancia en la listaAmbulancias entonces creo
        //la ciudad referenciada a ese ciudadId para enviar por parametro al crear la nueva ambulancia.
        if(!listaAmbulancias.contains(ambulanciaId))
        {
            Ciudad ciu = listaCiudades.buscar(ciudadId);
            
            if(ciu != null)
            {
                Ambulancia ambu = new Ambulancia(ambulanciaId, ciu);
                listaAmbulancias.insertarInicio(ambu);
                return TipoRet.OK;
            }
            else
            {
                System.out.println("La ciudad  ciudadID no existe.");
                return TipoRet.ERROR;
            }
        }
        else
        {
            System.out.println("Ya existe una ambulancia con identificador ambulanciaID");
            return TipoRet.ERROR;
        }
    }

    @Override
    public TipoRet deshabilitarAmbulancia(String ambulanciaId) {
        return TipoRet.NO_IMPLEMENTADA;
    }

    @Override
    public TipoRet habilitarAmbulancia(String ambulanciaID) {
        return TipoRet.NO_IMPLEMENTADA;
    }

    @Override
    public TipoRet buscarAmbulancia(String ambulanciaID) {
        return TipoRet.NO_IMPLEMENTADA;
    }

    @Override
    public TipoRet informeAmbulancia() {
        return TipoRet.NO_IMPLEMENTADA;
    }

    @Override
    public TipoRet informeAmbulancia(int ciudadID) {
        return TipoRet.NO_IMPLEMENTADA;
    }

    @Override
    public TipoRet cambiarUbicacion(String ambulanciaID, int ciudadID) {
        return TipoRet.NO_IMPLEMENTADA;
    }

    @Override
    public TipoRet agregarCiudad(String ciudadNombre) {
        return TipoRet.NO_IMPLEMENTADA;
    }

    @Override
    public TipoRet listarCiudades() {
        return TipoRet.NO_IMPLEMENTADA;
    }

    @Override
    public TipoRet agregarRuta(int ciudadOrigen, int ciudadDestino, int minutosViaje) {
        return TipoRet.NO_IMPLEMENTADA;
    }

    @Override
    public TipoRet modificarDemora(int ciudadOrigen, int ciudadDestino, int minutosViaje) {
        return TipoRet.NO_IMPLEMENTADA;
    }

    @Override
    public TipoRet ambulanciaMasCercana(int ciudadID) {
        return TipoRet.NO_IMPLEMENTADA;
    }

    @Override
    public TipoRet rutaMasRapida(int ciudadOrigen, int ciudadDestino) {
        return TipoRet.NO_IMPLEMENTADA;
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
        return TipoRet.NO_IMPLEMENTADA;
    }

    @Override
    public TipoRet eliminarChofer(String ambulanciaID, String cedula) {
        return TipoRet.NO_IMPLEMENTADA;
    }

    @Override
    public TipoRet informeChoferes(String ambulanciaID) {
        return TipoRet.NO_IMPLEMENTADA;
    }

    
    
}
