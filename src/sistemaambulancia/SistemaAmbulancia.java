
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
    public TipoRet destruirSistemaEmergencias() 
    {
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
    public TipoRet registrarAmbulancia(String ambulanciaID, int ciudadID) 
    {
        //Si no existe el id de ambulancia en la listaAmbulancias entonces creo
        //la ciudad referenciada a ese ciudadId para enviar por parametro al crear la nueva ambulancia.
        if(!listaAmbulancias.contains(ambulanciaID))
        {
            Ciudad ciu = listaCiudades.buscar(ciudadID);
            
            if(ciu != null)
            {
                Ambulancia ambu = new Ambulancia(ambulanciaID, ciu);
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
    public TipoRet deshabilitarAmbulancia(String ambulanciaID) 
    {
        //Busco ambulancia
        Ambulancia ambu = listaAmbulancias.buscar(ambulanciaID);
        
        //Si no esta vacia entonces encontro la ambulancia
        if(ambu != null)
        {
            //Si la ambulancia no esta en emergencia
            if(ambu.Estado != Ambulancia.TipoEstado.ATENDIENDO_EMERGENCIA)
            {
                //Si la ambulancia no esta en estado no disponible entonces le asigno estado no disponible 
                if(ambu.Estado != Ambulancia.TipoEstado.NO_DISPONIBLE)
                {
                    Ambulancia.TipoEstado ambEstado = ambu.Estado.NO_DISPONIBLE;
                    return TipoRet.OK;
                }else
                {
                    System.out.println("La ambulancia ambulanciaID ya está en estado NO_DISPONIBLE.");
                    return TipoRet.ERROR;
                }
            }else
            {
                System.out.println("No es posible deshabilitar la ambulancia ambulanciaID.");
                return TipoRet.ERROR;
            }
        }else
        {
            System.out.println("No existe una ambulancia con identificador ambulanciaID");
            return TipoRet.ERROR;
        }
    }

    @Override
    public TipoRet habilitarAmbulancia(String ambulanciaID) {
        //Busco ambulancia
        Ambulancia ambu = listaAmbulancias.buscar(ambulanciaID);
        
        //Si no esta vacia entonces encontro la ambulancia
        if(ambu != null)
        {
            //Si la ambulancia no esta en estado  disponible entonces le asigno estado disponible 
            if(ambu.Estado != Ambulancia.TipoEstado.DISPONIBLE)
            {
                Ambulancia.TipoEstado ambEstado = ambu.Estado.DISPONIBLE;
                return TipoRet.OK;
            }else
            {
                System.out.println("La ambulancia ambulanciaID ya está habilitada.");
                return TipoRet.ERROR;
            }
        }else
        {
            System.out.println("No existe una ambulancia con identificador ambulanciaID");
            return TipoRet.ERROR;
        }
    }

    @Override
    public TipoRet buscarAmbulancia(String ambulanciaID) 
    {
        //Busco ambulancia
        Ambulancia ambu = listaAmbulancias.buscar(ambulanciaID);
        
        //Sil la ambulancia no esta vacia entonces la encontro
        if(ambu !=null)
        {
            //Imprimo en pantalla con el formato establecido en el tostring del objeto
            System.out.println(ambu.toString());
            return TipoRet.OK;
        }else
        {
            System.out.println("No existe una ambulancia con identificador ambulanciaID");
            return TipoRet.ERROR;
        }
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
       //controlar que el mapa no este lleno  y no se puedan agregar mas ciudades
       
       
       //verifica que el mapa no este vacio, que la lista de ciudades no este llena
       if (mapa.length>0 && !listaCiudades.estaLlena()) {
          //compruebo que no exista esa ciudad con ese nombre  
           if (listaCiudades.contains(ciudadNombre)) {
                System.out.println("Ya existe una ciudad con ese nombre");
                return TipoRet.ERROR;
           }else{
               //inserto ciudad a la lista de ciudades
                Ciudad c= new Ciudad(ciudadNombre);
                listaCiudades.insertarInicio(c);
                return TipoRet.OK;
                
            }
        }else{
           System.out.println("“No se pueden ingresar la ciudadNombre al sistema por no tener más capacidad.");
           return TipoRet.ERROR;
           
       }
        
    }

    @Override
    public TipoRet listarCiudades() {
        
        if (listaCiudades.esVacia()) {
            System.out.println("No existen ciudades en el mapa.");
        }else{
            System.out.println("Ciudades en el mapa");
            listaCiudades.mostrarOrdenado();
        }
        return TipoRet.OK;
        
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
