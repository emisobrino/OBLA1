package sistemaambulancia.dominio;

import TADAmbulancia.ListaAmbulancia;

public class Ciudad {
    
    //Properties
    private static int ultimoId = -1;
    private Integer id;
    private String nombreCiudad;
    private ListaAmbulancia ambulancias;

    //Constructor
    public Ciudad(String nombreCiudad) 
    {
        this.nombreCiudad = nombreCiudad;
        ultimoId++;
        this.id = ultimoId;
        this.ambulancias = new ListaAmbulancia();
    }

    //Setear id
    public void setId(Integer id) {
        this.ultimoId = id;
    }

    //Obtener id
    public Integer getId() {
        return id;
    }
    
    //Otener nombre ciudad
    public String getNombreCiudad() {
        return nombreCiudad;
    }

    //Setear nombre ciudad
    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    //Obtener ambulancias
    public ListaAmbulancia getAmbulancias() {
        return ambulancias;
    }

    //Setear ambulancias
    public void setAmbulancias(ListaAmbulancia ambulancias) {
        this.ambulancias = ambulancias;
    }

    //Tostring
    @Override
    public String toString() {
        return String.format("%1$s > - <%2$s>", this.getId(), this.getNombreCiudad());
    }
    
    //Eliminar
    public void eliminar()
    {
       this.ambulancias.eliminarAmbulancias();
       setId(-1);
   }
}
