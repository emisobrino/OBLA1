package TADCiudad;

import sistemaambulancia.dominio.Ciudad;

public class ListaCiudad {

    private NodoListaCiudad inicio;

    public ListaCiudad() {
        this.inicio = null;
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
    }

    public Ciudad head() {
        return inicio.getSiguiente().getDato();
    }

    public ListaCiudad tail() {

        ListaCiudad lista = new ListaCiudad();
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
             
         }

}
    
    
    
    
    
    
}