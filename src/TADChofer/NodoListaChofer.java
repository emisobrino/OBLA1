package TADChofer;

import sistemaambulancia.dominio.Chofer;

public class NodoListaChofer {

    //Properties
    private Chofer dato;
    private NodoListaChofer siguiente;

    //Constructor
    public NodoListaChofer(Chofer dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    //Obtener dato
    public Chofer getDato() {
        return dato;
    }

    //Setear dato a nodo
    public void setDato(Chofer dato) {
        this.dato = dato;
    }

    //Obtener siguiente
    public NodoListaChofer getSiguiente() {
        return siguiente;
    }

    //Setear siguiente
    public void setSiguiente(NodoListaChofer siguiente) {
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
