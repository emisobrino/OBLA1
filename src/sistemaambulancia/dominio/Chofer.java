
package sistemaambulancia.dominio;


public class Chofer {
    private String cedula;
    private String nombre;
    private String idAmbulancia;

    public Chofer(String cedula, String nombre, String idAmbulancia) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.idAmbulancia= idAmbulancia;
                
    }

    
    
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getIdAmbulancia(){
        return idAmbulancia;
    }
    public void setIdAmbulancia(String idAmbulancia){
        this.idAmbulancia=idAmbulancia;
    }
    
}
