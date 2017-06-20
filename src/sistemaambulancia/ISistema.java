package sistemaambulancia;

public interface ISistema {

    public enum TipoRet {OK, NO_IMPLEMENTADA, ERROR;}

    
    public TipoRet crearSistemaDeEmergencias(int cantidadCiudades);

    public TipoRet destruirSistemaEmergencias();
    
    public TipoRet registrarAmbulancia(String ambulanciaID, int ciudadID);

    public TipoRet eliminarAmbulancia(String ambulanciaID);
    
    public TipoRet deshabilitarAmbulancia(String ambulanciaID);

    public TipoRet habilitarAmbulancia(String ambulanciaID);

    public TipoRet buscarAmbulancia(String ambulanciaID);

    public TipoRet informeAmbulancia();

    public TipoRet informeAmbulancia(int ciudadID);

    public TipoRet cambiarUbicacion(String ambulanciaID, int ciudadID);

    public TipoRet agregarCiudad(String ciudadNombre);

    public TipoRet listarCiudades();

    public TipoRet agregarRuta(int ciudadOrigen, int ciudadDestino, int minutosViaje);

    public TipoRet modificarDemora(int ciudadOrigen, int ciudadDestino, int minutosViaje);

    public TipoRet ambulanciaMasCercana(int ciudadID);

    public TipoRet rutaMasRapida(int ciudadOrigen, int ciudadDestino);

    public TipoRet informeCiudades();

    public TipoRet ciudadesEnRadio(int ciudadID, int duracionViaje);

    public TipoRet registrarChofer(String ambulanciaID, String nombre, String cedula);

    public TipoRet eliminarChofer(String ambulanciaID, String cedula);

    public TipoRet informeChoferes(String ambulanciaID);
}

