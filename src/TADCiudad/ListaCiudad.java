package TADCiudad;

import sistemaambulancia.dominio.Ciudad;

public class ListaCiudad {

    //Properties
    private NodoListaCiudad inicio;
    private int topeCiudades;
    private int cantActual;

    //Constructor
    public ListaCiudad(int tope) {
        this.inicio = null;
        this.topeCiudades = tope;
        this.cantActual = 0;
    }

    //Obtener tope
    public int getTopeCiudades() {
        return topeCiudades;
    }

    //Setear tope
    public void setTopeCiudades(int topeCiudades) {
        this.topeCiudades = topeCiudades;
    }

    //Obtener cantidad actual
    public int getCantActual() {
        return cantActual;
    }

    //setear cantidad actual
    public void setCantActual(int cantActual) {
        this.cantActual = cantActual;
    }

    //Obtener inicio
    public NodoListaCiudad getInicio() {
        return inicio;
    }

    //Setear inicio
    public void setInicio(NodoListaCiudad inicio) {
        this.inicio = inicio;
    }

    //Es vacia
    public boolean esVacia() {
        return this.inicio == null;
    }

    //Insertar inicio
    public void insertarInicio(Ciudad ciudad) {
        NodoListaCiudad ci = new NodoListaCiudad(ciudad);
        ci.setSiguiente(inicio);
        inicio = ci;
        cantActual++;
    }

    //Dato en inicio
    public Ciudad head() {
        return inicio.getDato();
    }

    //Tail
    public ListaCiudad tail() {
        ListaCiudad lista = new ListaCiudad(this.topeCiudades - 1);
        lista.setInicio(inicio.getSiguiente());
        return lista;
    }

    //Contains
    public boolean contains(String nombre) {
        Ciudad c;
        ListaCiudad aux;
        boolean encontre = false;
        aux = this;

        while (!aux.esVacia() && !encontre) {
            c = aux.head();
            if (c.getNombreCiudad().equals(nombre)) {
                encontre = true;
            } else {
                aux = aux.tail();
            }
        }
        return encontre;
    }

    //Buscar
    public Ciudad buscar(int id) {
        Ciudad c = null;
        ListaCiudad aux;
        boolean encontre = false;
        aux = this;

        while (!aux.esVacia() && !encontre) {
            c = aux.head();
            if (c.getId() == id) {
                encontre = true;
            } else {
                aux = aux.tail();
                c = null;
            }
        }
        return c;
    }

    //pre no estar llena
    //Insertar ordenado
    public void insertarOrdenado(Ciudad c) {

        if (this.esVacia()) {
            this.insertarInicio(c);
        } else {
            NodoListaCiudad aux = inicio;
            while (aux.getSiguiente() != null && aux.getSiguiente().getDato().getId().compareTo(c.getId()) == -1) {
                aux = aux.getSiguiente();
            }
            NodoListaCiudad nc = new NodoListaCiudad(c);
            nc.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(nc);
            cantActual++;
        }

    }

    //Esta llena la lista
    public boolean estaLlena() {
        return cantActual >= topeCiudades;
    }

    //Mostrar ciudades
    public void mostrarCiudades() {
        //pre: se asume que la lista de ciudades no es vacia
        NodoListaCiudad aux = inicio;
        while (aux != null) {
            System.out.println(aux.getDato().toString());//mostramos el dato
            aux = aux.getSiguiente();
        }
    }

    
    //Eliminar ciudades recursivo
    private void eliminarCiudadRec(NodoListaCiudad nodo) {
        if (nodo != null) {
            nodo.eliminar();
            eliminarCiudadRec(nodo.getSiguiente());
        }
        nodo = null;
    }

    //Eliminar ciudades llama a eliminar ciudades recursivo
    public void eliminarCiudades() {
        eliminarCiudadRec(inicio);
        this.topeCiudades = 0;
        this.cantActual = 0;
    }
}
