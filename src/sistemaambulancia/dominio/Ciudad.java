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
        return String.format("{0}> - <{1}>", this.getId(), this.getNombreCiudad());
    }
}
