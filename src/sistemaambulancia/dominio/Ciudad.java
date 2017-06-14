
package sistemaambulancia.dominio;

import TADAmbulancia.ListaAmbulancia;


public class Ciudad {
    
    private static Integer id=-1;
    public String nombreCiudad;
    private ListaAmbulancia ambulancias;

    public Ciudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
        this.id=id++;
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
    
    
    
}
