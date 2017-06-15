package sistemaambulancia.dominio;

import TADChofer.ListaChofer;

public class Ambulancia {
    
    public enum TipoEstado {DISPONIBLE, NO_DISPONIBLE, ATENDIENDO_EMERGENCIA};
    
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
        this.choferes = new ListaChofer();
        this.estado = TipoEstado.DISPONIBLE;
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

    public TipoEstado getEstado() {
        return estado;
    }

    public void setEstado(TipoEstado Estado) {
        this.estado = Estado;
    }
    
    @Override
    public String toString()
    {
        return String.format("Datos ambulancia: {0}\n Estado: {1}\n Ciudad: {2}\n #Emergencias: {3}", 
            this.id, this.estado, this.ciudad.nombreCiudad, this.cantidadViajes);
    }
}
