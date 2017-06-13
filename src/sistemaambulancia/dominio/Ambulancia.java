package sistemaambulancia.dominio;

import TADChofer.ListaChofer;

public class Ambulancia {
    
    private enum TipoEstado {DISPONIBLE, NO_DISPONIBLE, ATENDIENDO_EMERGENCIA};
    
    private String id;
    private Integer cantidadViajes;
    private Ciudad ciudad;
    private ListaChofer choferes;
    private TipoEstado estado;

    public Ambulancia(String id, Ciudad ciudad) 
    {
        this.id = id;
        this.ciudad = ciudad;
        this.cantidadViajes = 0;
        this.choferes= new ListaChofer();
        this.estado= TipoEstado.DISPONIBLE;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getCantidadViajes() {
        return cantidadViajes;
    }

    public void setCantidadViajes(Integer cantidadViajes) {
        this.cantidadViajes = cantidadViajes;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public ListaChofer getChoferes() {
        return choferes;
    }

    public void setChoferes(ListaChofer choferes) {
        this.choferes = choferes;
    }
}
