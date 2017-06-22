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

        return inicio.getDato();
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

    public void vaciarLista() {
        this.setInicio(null);
    }

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

//    public boolean eliminarChoferes() 
//    {
//        Si el nodo esta vacio entonces devuelvo false por que la lista esta vacia
//        if (inicio == null) return false;
//         
//        while(true)
//        {
//            Creo nodo que voy a usar para recorrer
//            NodoListaChofer nodoAnterior = inicio;
//        
//            nodoAnterior.setSiguiente(null);
//            
//            if(nodoAnterior.getSiguiente() == null)
//            {
//                nodoAnterior = null;
//                return true;
//            }
//        }
//    }
    private void eliminarChoferesRec(NodoListaChofer nodo) {
        if (nodo != null) {
            nodo.eliminar();
            eliminarChoferesRec(nodo.getSiguiente());
        }
        nodo = null;
    }

    public void eliminarChoferes() {

        eliminarChoferesRec(inicio);

    }
}
