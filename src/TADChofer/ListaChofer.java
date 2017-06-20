package TADChofer;

import sistemaambulancia.dominio.Chofer;

public class ListaChofer {

    private NodoListaChofer inicio;

    public NodoListaChofer getInicio() {
        return inicio;
    }

    public void setInicio(NodoListaChofer inicio) {
        this.inicio = inicio;
    }

    //Constructor
    public ListaChofer() {
        this.inicio = null;
    }

    public boolean esVacia() {

        return this.inicio == null;
    }

    public void insertarInicio(Chofer chofer) {
        NodoListaChofer ch = new NodoListaChofer(chofer);
        ch.setSiguiente(inicio);
        inicio = ch;
    }

    public Chofer head() {

        return inicio.getSiguiente().getDato();
    }

    public ListaChofer tail() {

        ListaChofer lista = new ListaChofer();
        lista.setInicio(inicio.getSiguiente());
        return lista;
    }

    public boolean contains(String cedula) {

        Chofer c;
        ListaChofer aux;
        boolean encontre = false;
        aux = this;

        while (!aux.esVacia() && !encontre) {
            c = aux.head();
            if (c.getCedula().equals(cedula)) {
                encontre = true;
            } else {
                aux = aux.tail();

            }
        }
        return encontre;

    }

    public Chofer buscar(String cedula) {

        Chofer c = null;
        ListaChofer aux;
        boolean encontre = false;
        aux = this;

        while (!aux.esVacia() && !encontre) {
            c = aux.head();
            if (c.getCedula().equals(cedula)) {
                encontre = true;
            } else {
                aux = aux.tail();
                c = null;
            }
        }

        return c;

    }

    public void insertarOrdenado(Chofer ch) {

        if (this.esVacia()) {
            this.insertarInicio(ch);
        } else {
            NodoListaChofer aux = inicio;
            while (aux.getSiguiente() != null && aux.getSiguiente().getDato().getCedula().compareTo(ch.getCedula()) == -1) {
                aux = aux.getSiguiente();
            }
            NodoListaChofer nc = new NodoListaChofer(ch);
            nc.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(nc);

        }
    }

    //Muestro choferes
    public void mostrarChoferes() {
        NodoListaChofer aux = inicio;

        //Mientras el nodo aux no sea vacio 
        while (aux != null) {
            //Escribo en pantalla con el formato de chofer
            System.out.println("Nombre: <" + aux.getDato().getNombre() + ">, Cedula: <" + aux.getDato().getCedula() + ">");

            //Obtengo valor del proximo nodo
            aux = aux.getSiguiente();
        }
    }

    //Eliminar chofer
//    public void eliminarChofer(String cedula) {
//        NodoListaChofer aux = inicio;
//        NodoListaChofer nodoAnteriorAChoferEliminar;
//        NodoListaChofer nodoSiguienteAChoferEliminar;
//
//        while (aux != null) {
//            if (aux.getDato().getCedula() == cedula) {
//                nodoSiguienteAChoferEliminar = aux.getSiguiente();
//                aux.setSiguiente(null);
//            }
//
//            aux = aux.getSiguiente();
//        }
//    }

    public boolean eliminarChofer(String cedula) 
    {
        //Creo nodo que voy a usar para recorrer
        NodoListaChofer nodoAnterior = inicio;
        
        //Si el nodo esta vacio entonces devuelvo eliminado = false
        if (nodoAnterior == null) 
        { 
            return false;
        } 
        
        //Si el chofer que hay en el nodo es igual al chofer que busco por cedula
        //Entonces establesco el inicio como el siguiente
        else if (nodoAnterior.getDato() == buscar(cedula)) 
        {
            inicio = inicio.getSiguiente();
            return true;
        }
        
        //Mientras sea verdadero
        while (true) 
        {
            //Guardo valor del nodo siguiente
            NodoListaChofer nodoSiguiente = nodoAnterior.getSiguiente();
                    
            //Si el nodo esta vacio devuelvo falso y salgo de la funcion
            if (nodoSiguiente == null) 
            { 
                return false;
            } 
            //Si el chofer que hay en el nodo siguiente es igual al que busco por cedula entonces salgo del while
            //Y voy a la parte de abajo del algoritmo
            else if (nodoSiguiente.getDato() == buscar(cedula)) 
            {
                break;
            }
            
            nodoAnterior = nodoSiguiente;
        }
        
        //Guardo de nuevo el valor del nodo siguiente
        NodoListaChofer nodoSiguiente = nodoAnterior.getSiguiente();
        
        //Al nodo anterior le seteo el nuevo valor siguiente, que va ser el nodo que le sigue del que quiero borrar
        nodoAnterior.setSiguiente(nodoSiguiente.getSiguiente());
        
        //Al nodo que quiero borrar le seteo su siguiente como null, para que pierda enlaze con la lista
        nodoSiguiente.setSiguiente(null);
        
        return true;
    }
}
