package sistemaambulancia.dominio;

public class Chofer 
{
    //Properties
    private String cedula;
    private String nombre;
    private String idAmbulancia;

    //Constructor
    public Chofer(String cedula, String nombre, String idAmbulancia) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.idAmbulancia= idAmbulancia;
    }

    //Obtener cedula
    public String getCedula() {
        return cedula;
    }

    //Setear cedula
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    //Obtener nombre
    public String getNombre() {
        return nombre;
    }

    //Setear nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    //Obtener id ambulancia en la que trabaja
    public String getIdAmbulancia(){
        return idAmbulancia;
    }
    
    //Setear id ambulancia a la que trabaja
    public void setIdAmbulancia(String idAmbulancia){
        this.idAmbulancia=idAmbulancia;
    }
}
