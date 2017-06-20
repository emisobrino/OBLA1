package TADAmbulancia;

import sistemaambulancia.dominio.Ambulancia;

public class NodoListaAmbulancia {
   
    private Ambulancia dato;
    private NodoListaAmbulancia siguiente;

    public NodoListaAmbulancia(Ambulancia dato) {
        this.dato = dato;
        this.siguiente=null;
    }

    public Ambulancia getDato() {
        return dato;
    }

    public void setDato(Ambulancia dato) {
        this.dato = dato;
    }

    public NodoListaAmbulancia getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoListaAmbulancia siguiente) {
        this.siguiente = siguiente;
    }
}
