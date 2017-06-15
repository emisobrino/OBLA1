package TADCiudad;
//prueba git


import sistemaambulancia.dominio.Ciudad;

public class ListaCiudad {

    private NodoListaCiudad inicio;
    private int topeCiudades;
    private int cantActual;
    
    

    public ListaCiudad(int tope) {
        this.inicio = null;
        this.topeCiudades= tope;
        this.cantActual=0;
    }

    
    public int getTopeCiudades() {
        return topeCiudades;
    }

    public void setTopeCiudades(int topeCiudades) {
        this.topeCiudades = topeCiudades;
    }

    public int getCantActual() {
        return cantActual;
    }

    public void setCantActual(int cantActual) {
        this.cantActual = cantActual;
    }
    
    public NodoListaCiudad getInicio() {
        return inicio;
    }

    public void setInicio(NodoListaCiudad inicio) {
        this.inicio = inicio;
    }

    public boolean esVacia() {

        return this.inicio == null;
    }

    public void insertarInicio(Ciudad ciudad) {
        NodoListaCiudad ci = new NodoListaCiudad(ciudad);
        ci.setSiguiente(inicio);
        inicio = ci;
        cantActual++;
    }

    public Ciudad head() {
        return inicio.getSiguiente().getDato();
    }

    public ListaCiudad tail() {

        ListaCiudad lista = new ListaCiudad(this.topeCiudades-1);
        lista.setInicio(inicio.getSiguiente());
        return lista;

    }

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
    
    public Ciudad buscar(int id){
    
        Ciudad c= null;
        ListaCiudad aux;
        boolean encontre=false;
        aux= this;
        
        while (!aux.esVacia()&& !encontre) {            
            c= aux.head();
            if (c.getId()==id) {
                encontre=true;
            }else{
            aux=aux.tail();
            c=null;
            }
        }
        return c;
    }
    
    //pre no estar llena
    public void insertarOrdenado(Ciudad c){
         
        if (this.esVacia()) {
            this.insertarInicio(c);
        }else{
            NodoListaCiudad aux =inicio;
            while (aux.getSiguiente()!=null && aux.getSiguiente().getDato().getId().compareTo(c.getId())==-1 ) {                 
             aux=aux.getSiguiente() ;
            }
            NodoListaCiudad nc= new NodoListaCiudad(c);
            nc.setSiguiente(aux.getSiguiente());
            aux.setSiguiente(nc);
            cantActual++;
        }

}
    
    public boolean estaLlena(){
        return cantActual>=topeCiudades;
    }

    
    public void mostrarCiudades() {
    //pre: se asume que la lista de ciudades no es vacia
       
    NodoListaCiudad aux=inicio;
    while(aux!=null){
            System.out.println(aux.getDato().toString());//mostramos el dato
            aux=aux.getSiguiente();
        }
    }
    
    
    
}
