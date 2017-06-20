package TADAmbulancia;

import sistemaambulancia.dominio.Ambulancia;

public class ListaAmbulancia {

    private NodoListaAmbulancia inicio;
    private int cantActual;

    //Getter Setter
    public NodoListaAmbulancia getInicio() {
        return inicio;
    }

    public void setInicio(NodoListaAmbulancia inicio) {
        this.inicio = inicio;
    }

    //Constructor
    public ListaAmbulancia() {
        this.inicio = null;
        this.cantActual = 0;

    }

    //Metodos
    public boolean esVacia() {

        return this.inicio == null;
    }

    public void insertarInicio(Ambulancia ambulancia) {
        NodoListaAmbulancia na = new NodoListaAmbulancia(ambulancia);
        na.setSiguiente(inicio);
        inicio = na;
        this.cantActual++;
    }

    //pre lista no es Vacia
    public Ambulancia head() {

        return inicio.getSiguiente().getDato();

    }

    //pre lista no es Vacia
    public ListaAmbulancia tail() {

        ListaAmbulancia lista = new ListaAmbulancia();
        lista.setInicio(inicio.getSiguiente());
        return lista;
    }

    /*
    while(!list.esVacia()&&!encontre)
    Ambulancia a = list.head()
    if(a.getId==id)
    encontre =true

    list=list.tail
     */
    //se le puede pasar el tipo ambulancia tmb
    public boolean contains(String Id) {

        Ambulancia a;
        ListaAmbulancia aux;
        boolean encontre = false;
        aux = this;

        while (!aux.esVacia() && !encontre) {
            a = aux.head();
            if (a.getId().equals(Id)) {
                encontre = true;
            } else {
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

        while (!aux.esVacia() && !encontre) {
            a = aux.head();
            if (a.getId().equals(Id)) {
                encontre = true;
            } else {
                aux = aux.tail();
                a = null;
            }
        }

        return a;

    }

    // pre lista ordenada
    public void insertarOrdenado(Ambulancia amb) {

        if (this.esVacia()) {
            this.insertarInicio(amb);
        } else {
            NodoListaAmbulancia aux = inicio;
            while (aux.getSiguiente() != null && aux.getSiguiente().getDato().getId().compareTo(amb.getId()) == -1) {
                aux = aux.getSiguiente();
            }
            NodoListaAmbulancia na = new NodoListaAmbulancia(amb);
            na.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(na);
            this.cantActual++;

        }
    }

    public void mostrarAmbulancias() {
        //pre: se asume que la lista de ambulancias no es vacia

        NodoListaAmbulancia aux = inicio;

        //Si el nodo inicio no esta vacio
        while (aux != null) {
            //Mostramos la ambulancia con el formato de informe
            System.out.println(aux.getDato().getId() + "> - <" + aux.getDato().getEstado()
                    + "> - <" + aux.getDato().getCiudad() + ">"
            );

            //Obtengo valor del proximo nodo
            aux = aux.getSiguiente();
        }
    }
    
    public void mostrarAmbulanciasPorCiudad(int ciudadID) {
        //pre: se asume que la lista de ambulancias no es vacia
        NodoListaAmbulancia aux = inicio;
        int cantidadAmbulanciasEnCiudad = 0; //Contador de ambulancias en ciudad dada por parametro
        
        //Mientras el nodo aux no sea vacio
        while (aux != null) {
            //Si la ambulancia que esta en el nodo, el id de su ciudad es igual al parametro
            if(aux.getDato().getCiudad().getId() == ciudadID)
            {
                //Mostramos la ambulancia con el formato de informe
                System.out.println("Ambulancia: \t \t" + aux.getDato().getId());

                //Agrego al contador cantidad de ambulancias en esa ciudad
                cantidadAmbulanciasEnCiudad++;
                
                //Obtengo valor del proximo nodo
                aux = aux.getSiguiente();
            }
        }
        
        //A lo ultimo muestro en pantalla cantidad total de ambulancias
        System.out.println("Total Ambulancias disponibles: " + cantidadAmbulanciasEnCiudad);
    }

    public void borrarAmbulancia(){
        //recordar bajar contador
        
    }
}
