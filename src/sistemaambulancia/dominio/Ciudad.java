package sistemaambulancia.dominio;

import TADAmbulancia.ListaAmbulancia;

public class Ciudad {
    
    private static int ultimoId = -1;
    private Integer id;
    private String nombreCiudad;
    private ListaAmbulancia ambulancias;

    public Ciudad(String nombreCiudad) 
    {
        this.nombreCiudad = nombreCiudad;
        ultimoId++;
        this.id = ultimoId;
        this.ambulancias = new ListaAmbulancia();
    }

    public void setId(Integer id) {
        this.ultimoId = id;
    }

    public Integer getId() {
        return id;
    }
    
    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public ListaAmbulancia getAmbulancias() {
        return ambulancias;
    }

    public void setAmbulancias(ListaAmbulancia ambulancias) {
        this.ambulancias = ambulancias;
    }

    @Override
    public String toString() {
        return String.format("%1$s > - <%2$s>", this.getId(), this.getNombreCiudad());
    }
    
    public void eliminar()
    {
       this.ambulancias.eliminarAmbulancias();
       setId(-1);
   }
}
