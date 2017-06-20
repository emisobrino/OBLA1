package TADChofer;

import sistemaambulancia.dominio.Chofer;

public class NodoListaChofer {
    
    private Chofer dato;
    private NodoListaChofer siguiente;

    public NodoListaChofer(Chofer dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public Chofer getDato() {
        return dato;
    }

    public void setDato(Chofer dato) {
        this.dato = dato;
    }

    public NodoListaChofer getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoListaChofer siguiente) {
        this.siguiente = siguiente;
    }
}
