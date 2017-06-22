package sistemaambulancia.dominio;

import TADChofer.ListaChofer;

public class Ambulancia {

    //PROPERTIES
    public enum TipoEstado {
        DISPONIBLE, NO_DISPONIBLE, ATENDIENDO_EMERGENCIA
    };

    private String id;
    private Integer cantidadViajes;
    private Ciudad ciudad;
    private ListaChofer choferes;
    private TipoEstado estado;

    //Constructor
    public Ambulancia(String id, Ciudad ciudad) {
        this.id = id;
        this.ciudad = ciudad;
        this.cantidadViajes = 0;
        this.choferes = new ListaChofer();
        this.estado = TipoEstado.DISPONIBLE;
    }

    //Obtener id
    public String getId() {
        return id;
    }

    //Setear id
    public void setId(String id) {
        this.id = id;
    }

    //Obtener cantidad viajes
    public Integer getCantidadViajes() {
        return cantidadViajes;
    }

    //Setear cantidad viajes
    public void setCantidadViajes(Integer cantidadViajes) {
        this.cantidadViajes = cantidadViajes;
    }

    //Obtener ciudad
    public Ciudad getCiudad() {
        return ciudad;
    }

    //Setear ciudad
    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    //Obtener choferes
    public ListaChofer getChoferes() {
        return choferes;
    }

    //Setear choferes
    public void setChoferes(ListaChofer choferes) {
        this.choferes = choferes;
    }

    //Obtener estado
    public TipoEstado getEstado() {
        return estado;
    }

    //Setear estado
    public void setEstado(TipoEstado Estado) {
        this.estado = Estado;
    }

    //Tostring con formato
    @Override
    public String toString() {
        return String.format("Datos ambulancia: %1$s\n Estado: %2$s\n Ciudad: %3$s\n #Emergencias: %4$d",
                this.id, this.estado, this.ciudad.getNombreCiudad(), this.cantidadViajes);
    }

    //Eliminar choferes
    public void eliminar() {
        this.choferes.eliminarChoferes();

    }
}
