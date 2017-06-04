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
    
    public ListaChofer tail(){
        
    ListaChofer lista = new ListaChofer();
    lista.setInicio(inicio.getSiguiente());
    return lista;
    }
    
    public boolean contains (String cedula){
    
        Chofer c;
        ListaChofer aux;
        boolean encontre=false;
        aux=this;
        
        while (!aux.esVacia()&& !encontre) {            
            c=aux.head();
            if (c.getCedula().equals(cedula)) {
                encontre=true;
            }else{
            aux=aux.tail();
                    
            }
        }
        return encontre;
    
    }
    
     public Chofer buscar(String  cedula){
    
        Chofer c=null;
        ListaChofer aux;
        boolean encontre=false;
        aux= this;
        
        while (!aux.esVacia()&& !encontre) {            
            c= aux.head();
            if (c.getCedula().equals(cedula)) {
                encontre=true;
            }else{
            aux=aux.tail();
            c=null;
            }
        }
        
        return c;
                
    }
     
       public void insertarOrdenado(Chofer ch){
         
         if (this.esVacia()) {
             this.insertarInicio(ch);
         }else{
             NodoListaChofer aux =inicio;
             while (aux.getSiguiente()!=null && aux.getSiguiente().getDato().getCedula().compareTo(ch.getCedula())==-1 ) {                 
              aux=aux.getSiguiente() ;
             }
             NodoListaChofer nc= new NodoListaChofer(ch);
             nc.setSiguiente(aux.getSiguiente());
             aux.setSiguiente(nc);
             
         }
     }

    
}
