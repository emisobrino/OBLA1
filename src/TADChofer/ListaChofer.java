package TADChofer;

import sistemaambulancia.dominio.Chofer;

public class ListaChofer {

    //Properties
    private NodoListaChofer inicio;

    //Constructor
    public ListaChofer() {
        this.inicio = null;
    }
    
    //Obtener inicio
    public NodoListaChofer getInicio() {
        return inicio;
    }

    //Setear inicio
    public void setInicio(NodoListaChofer inicio) {
        this.inicio = inicio;
    }

    //Es vacia
    public boolean esVacia() {

        return this.inicio == null;
    }

    //Insertar inicio
    public void insertarInicio(Chofer chofer) {
        //Creo nodo con chofer y le seteo inicio
        NodoListaChofer ch = new NodoListaChofer(chofer);
        ch.setSiguiente(inicio);
        inicio = ch;
    }

    //Dato del inicio
    public Chofer head() {
        return inicio.getDato();
    }

    //Tail
    public ListaChofer tail() {
        //Creo lista chofer y seteo al inicio como el siguiente del inicio
        ListaChofer lista = new ListaChofer();
        lista.setInicio(inicio.getSiguiente());
        return lista;
    }

    //Contains
    public boolean contains(String cedula) {
        Chofer c;
        ListaChofer aux;
        boolean encontre = false;
        aux = this;

        //Mientras no sea vacia y no alla encontrado
        while (!aux.esVacia() && !encontre) {
            //Chofer igual al inicio
            c = aux.head();
            //Si la cedula del chofer es igual a la que busco
            if (c.getCedula().equals(cedula)) {
                encontre = true;
            } else {
                aux = aux.tail();
            }
        }
        return encontre;
    }

    //Buscar
    public Chofer buscar(String cedula) {
        Chofer c = null;
        ListaChofer aux;
        boolean encontre = false;
        aux = this;

        //Mientras no sea vacia y no alla encontrado
        while (!aux.esVacia() && !encontre) {
            //Chofer igual al inicio
            c = aux.head();
            //Si la cedula del chofer es igual a la que busco
            if (c.getCedula().equals(cedula)) {
                encontre = true;
            } else {
                aux = aux.tail();
                c = null;
            }
        }
        return c;
    }

    //Insertar ordenado
    public void insertarOrdenado(Chofer ch) {
        //Si la lista esta vacia , inserto en el inicio al chofer
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
    public boolean eliminarChofer(String cedula) {
        //Creo nodo que voy a usar para recorrer
        NodoListaChofer nodoAnterior = inicio;

        //Si el nodo esta vacio entonces devuelvo false 
        if (nodoAnterior == null) {
            return false;
        } //Si el chofer que hay en el nodo es igual al chofer que busco por cedula
        //Entonces establesco el inicio como el siguiente
        else if (nodoAnterior.getDato() == buscar(cedula)) {
            inicio = inicio.getSiguiente();
            return true;
        }

        //Mientras sea verdadero
        while (true) {
            //Guardo valor del nodo siguiente
            NodoListaChofer nodoSiguiente = nodoAnterior.getSiguiente();

            //Si el nodo esta vacio devuelvo falso y salgo de la funcion
            if (nodoSiguiente == null) {
                return false;
            } //Si el chofer que hay en el nodo siguiente es igual al que busco por cedula entonces salgo del while
            //Y voy a la parte de abajo del algoritmo
            else if (nodoSiguiente.getDato() == buscar(cedula)) {
                break;
            }

            //Guardo en nodoanterior el valor del proximo nodo, para seguir recorriendo la lista
            nodoAnterior = nodoSiguiente;
        }

        //Guardo de nuevo el valor del nodo siguiente
        NodoListaChofer nodoSiguiente = nodoAnterior.getSiguiente();
        //Al nodo anterior le seteo el nuevo valor siguiente, que va ser el nodo que le sigue del que quiero borrar
        nodoAnterior.setSiguiente(nodoSiguiente.getSiguiente());
        //Al nodo que quiero borrar le seteo su siguiente como null, para que pierda enlaze con la lista
        nodoSiguiente.setSiguiente(null);

        //Recolector de Basura (Garbage Collection) 
        System.gc();
        //Devuelvo verdadero si se ejecuta correctamente la funcion
        return true;
    }
    
    //Eliminar choferes recursivo
    private void eliminarChoferesRec(NodoListaChofer nodo) {
        //Si el nodo distinto de null, lo elimino
        if (nodo != null) {
            nodo.eliminar();
            eliminarChoferesRec(nodo.getSiguiente());
        }
        nodo = null;
    }

    //Eliminar choferes llama a eliminar choferes recursivo 
    public void eliminarChoferes() {
        eliminarChoferesRec(inicio);
    }
}
