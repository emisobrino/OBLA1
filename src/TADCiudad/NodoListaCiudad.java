
package TADCiudad;

import sistemaambulancia.dominio.Ciudad;


public class NodoListaCiudad {
    
    private Ciudad dato;
    private NodoListaCiudad siguiente;

    public NodoListaCiudad(Ciudad dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    
    
    public Ciudad getDato() {
        return dato;
    }

    public void setDato(Ciudad dato) {
        this.dato = dato;
    }

    public NodoListaCiudad getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoListaCiudad siguiente) {
        this.siguiente = siguiente;
    }
    
        
    
    
}
