package TADAmbulancia;

import sistemaambulancia.dominio.Ambulancia;

public class ListaAmbulancia 
{
    //Properties
    private NodoListaAmbulancia inicio;
    private int cantActual;

    //Obtener inicio 
    public NodoListaAmbulancia getInicio() {
        return inicio;
    }

    //Obtener setter
    public void setInicio(NodoListaAmbulancia inicio) {
        this.inicio = inicio;
    }

    //Constructor
    public ListaAmbulancia() {
        this.inicio = null;
        this.cantActual = 0;

    }

    //Es vacia
    public boolean esVacia() {
        return this.inicio == null;
    }

    //Insertar en el inicio de la lista
    private void insertarInicio(Ambulancia ambulancia) {
        //Creo nodo de lista ambulancia
        NodoListaAmbulancia na = new NodoListaAmbulancia(ambulancia);
        
        //Establesco el nodo como inicio
        na.setSiguiente(inicio);
        inicio = na;
        this.cantActual++;
    }

    //Inicio dato
    public Ambulancia head() {
        return this.inicio.getDato();
    }

    //tail
    public ListaAmbulancia tail() {
        //ccreo lista ambulancia
        ListaAmbulancia lista = new ListaAmbulancia();
        //A la lista le establesco el inicio como el siguiente nodo y devuelvo la lista
        lista.setInicio(inicio.getSiguiente());
        return lista;
    }
    
    //Contains
    public boolean contains(String Id) {
        Ambulancia a;
        ListaAmbulancia aux;
        boolean encontre = false;
        aux = this;

        //Mientras no sea vacia ni alla encontrado nada
        while (!aux.esVacia() && !encontre) {
            //la ambulancia a , es igual a la ambulancia en el inicio de la lista
            a = aux.head();
            //Si es el id de la ambulancia es la que busco entonces devuelvo true 
            if (a.getId().equals(Id)) {
                encontre = true;
            } else {
                //si no uso tail para avanzar
                aux = aux.tail();
            }
        }
        return encontre;
    }

    public Ambulancia buscar(String Id) {

        Ambulancia a = null;
        ListaAmbulancia aux;
        boolean encontre = false;
        aux = this;

        //Mientras no sea vacia ni alla encontrado nada
        while (!aux.esVacia() && !encontre) {
            a = aux.head();
            //Si es el id de la ambulancia es la que busco entonces devuelvo true 
            if (a.getId().equals(Id)) {
                encontre = true;
            } else {
                //si no uso tail para avanzar
                aux = aux.tail();
                a = null;
            }
        }
        //Devuelvo ambulancia
        return a;

    }

    //Insertar ordenado
    public void insertarOrdenado(Ambulancia amb) {
        //Si la lista esta vacia inserto en el inicio
        if (this.esVacia()) {
            this.insertarInicio(amb);
        } else {
            //Guardo nodo inicio y mientras no sea vacio y el compare to vaya ordenando
            NodoListaAmbulancia aux = inicio;
            while (aux.getSiguiente() != null && aux.getSiguiente().getDato().getId().compareTo(amb.getId()) == -1) {
                aux = aux.getSiguiente();
            }
            //Creo nuevo nodo con la ambulancia 
            NodoListaAmbulancia na = new NodoListaAmbulancia(amb);
            na.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(na);
            this.cantActual++;  
        }
    }

    //Mostrar ambulancias
    public void mostrarAmbulancias() {
        //pre: se asume que la lista de ambulancias no es vacia
        //Referenceo al nodo inicio
        NodoListaAmbulancia aux = inicio;

        //Si el nodo inicio no esta vacio
        while (aux != null) {
            //Mostramos la ambulancia con el formato de informe
            System.out.println(aux.getDato().getId() + "> - <" + aux.getDato().getEstado()
                    + "> - <" + aux.getDato().getCiudad().getNombreCiudad() + ">"
            );

            //Obtengo valor del proximo nodo
            aux = aux.getSiguiente();
        }
    }

    //Mostrar ambulancias por ciudadID
    public void mostrarAmbulanciasPorCiudad(int ciudadID) {
        //pre: se asume que la lista de ambulancias no es vacia
        NodoListaAmbulancia aux = inicio;
        int cantidadAmbulanciasEnCiudad = 0; //Contador de ambulancias en ciudad dada por parametro

        //Mientras el nodo aux no sea vacio
        while (aux != null) {
            //Si la ambulancia que esta en el nodo, el id de su ciudad es igual al parametro
            if (aux.getDato().getCiudad().getId() == ciudadID) {
                //Mostramos la ambulancia con el formato de informe
                System.out.println("Ambulancia: \t \t" + aux.getDato().getId());

                //Agrego al contador cantidad de ambulancias en esa ciudad
                cantidadAmbulanciasEnCiudad++;
            }
            //Obtengo valor del proximo nodo
            aux = aux.getSiguiente();
        }

        //A lo ultimo muestro en pantalla cantidad total de ambulancias
        System.out.println("Total Ambulancias disponibles: " + cantidadAmbulanciasEnCiudad);
    }

    //Eliminar ambulancia
    public boolean eliminarAmbulancia(String ambulanciaID) {
        //Creo nodo que voy a usar para recorrer
        NodoListaAmbulancia nodoAnterior = inicio;

        //Si el nodo esta vacio entonces devuelvo false 
        if (nodoAnterior == null) {
            return false;
        } //Si la ambulancia que hay en el nodo es igual al ambulancia que me pasan por parametro
        //Entonces establesco el inicio como el siguiente
        else if (nodoAnterior.getDato() == buscar(ambulanciaID)) {
            inicio = inicio.getSiguiente();
            return true;
        }

        //Mientras sea verdadero
        while (true) {
            //Guardo valor del nodo siguiente
            NodoListaAmbulancia nodoSiguiente = nodoAnterior.getSiguiente();

            //Si el nodo esta vacio devuelvo falso y salgo de la funcion
            if (nodoSiguiente == null) {
                return false;
            } //Si la ambulancia que hay en el nodo siguiente es igual al que busco entonces salgo del while
            //Y voy a la parte de abajo del algoritmo
            else if (nodoSiguiente.getDato() == buscar(ambulanciaID)) {
                break;
            }

            //Guardo en nodoanterior el valor del proximo nodo, para seguir recorriendo la lista
            nodoAnterior = nodoSiguiente;
        }

        //Guardo de nuevo el valor del nodo siguiente
        NodoListaAmbulancia nodoSiguiente = nodoAnterior.getSiguiente();
        //Al nodo anterior le seteo el nuevo valor siguiente, que va ser el nodo que le sigue del que quiero borrar
        nodoAnterior.setSiguiente(nodoSiguiente.getSiguiente());
        //Al nodo que quiero borrar le seteo su siguiente como null, para que pierda enlaze con la lista
        nodoSiguiente.setSiguiente(null);

        //Recolector de Basura (Garbage Collection) 
        System.gc();
        //Devuelvo verdadero si se ejecuta correctamente la funcion
        return true;
    }

    //Eliminar ambulancia recursivo
    private void eliminarAmbulanciasRec(NodoListaAmbulancia nodo) {
        //Si el nodo distinto de null elimina al nodo
        if (nodo != null) {
            nodo.eliminar();
            eliminarAmbulanciasRec(nodo.getSiguiente());
        }
        nodo = null;
    }

    //Eliminar ambulancia llama a eliminar ambulancia recursivo
    public void eliminarAmbulancias() {

        eliminarAmbulanciasRec(inicio);

    }
}
