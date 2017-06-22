package TADCiudad;

import sistemaambulancia.dominio.Ciudad;

public class NodoListaCiudad {

    //Properties
    private Ciudad dato;
    private NodoListaCiudad siguiente;

    //Constructor
    public NodoListaCiudad(Ciudad dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    //Obtener dato
    public Ciudad getDato() {
        return dato;
    }

    //setear dato
    public void setDato(Ciudad dato) {
        this.dato = dato;
    }

    //Obtener siguiente
    public NodoListaCiudad getSiguiente() {
        return siguiente;
    }

    //Setear siguiente
    public void setSiguiente(NodoListaCiudad siguiente) {
        this.siguiente = siguiente;
    }

    //Eliminar
    void eliminar() {
        if (dato != null) {
            this.dato.eliminar();
        }
        dato = null;
    }

}
