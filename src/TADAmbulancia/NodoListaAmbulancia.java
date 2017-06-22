package TADAmbulancia;

import sistemaambulancia.dominio.Ambulancia;

public class NodoListaAmbulancia {

    //Properties
    private Ambulancia dato;
    private NodoListaAmbulancia siguiente;

    //Constructor
    public NodoListaAmbulancia(Ambulancia dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    //Obtener dato
    public Ambulancia getDato() {
        return dato;
    }

    //Setear dato al nodo
    public void setDato(Ambulancia dato) {
        this.dato = dato;
    }

    //Obtener siguiente
    public NodoListaAmbulancia getSiguiente() {
        return siguiente;
    }

    //Establecer siguiente
    public void setSiguiente(NodoListaAmbulancia siguiente) {
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
