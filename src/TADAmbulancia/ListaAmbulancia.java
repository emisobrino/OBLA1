
package TADAmbulancia;

import sistemaambulancia.dominio.Ambulancia;


public class ListaAmbulancia {
    
    private NodoListaAmbulancia inicio;

    
    //Getter Setter
    public NodoListaAmbulancia getInicio() {
        return inicio;
    }

    public void setInicio(NodoListaAmbulancia inicio) {
        this.inicio = inicio;
    }

    
    //Constructor
    public ListaAmbulancia() {
        this.inicio=null;
    }
    
    //Metodos
    public boolean esVacia (){
        
        return this.inicio==null;
    }
    
    public void insertarInicio(Ambulancia ambulancia){
        NodoListaAmbulancia na= new NodoListaAmbulancia(ambulancia);
        na.setSiguiente(inicio);
        inicio=na;
    }
    
    //pre lista no es Vacia
    public Ambulancia head(){
        
    return inicio.getSiguiente().getDato();
    
    }
    
    //pre lista no es Vacia
    public ListaAmbulancia tail(){
    
        ListaAmbulancia lista= new ListaAmbulancia();
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
    public boolean contains(String  Id){
    
        Ambulancia a;
        ListaAmbulancia aux;
        boolean encontre=false;
        aux= this;
        
        while (!aux.esVacia()&& !encontre) {            
            a= aux.head();
            if (a.getId().equals(Id)) {
                encontre=true;
            }else{
            aux=aux.tail();
            }
        }
        
        return encontre;
        
        
    }
    
    
     public Ambulancia buscar(String  Id){
    
        Ambulancia a=null;
        ListaAmbulancia aux;
        boolean encontre=false;
        aux= this;
        
        while (!aux.esVacia()&& !encontre) {            
            a= aux.head();
            if (a.getId().equals(Id)) {
                encontre=true;
            }else{
            aux=aux.tail();
            a=null;
            }
        }
        
        return a;
        
    }
    // pre lista ordenada
     public void insertarOrdenado(Ambulancia amb){
         
         if (this.esVacia()) {
             this.insertarInicio(amb);
         }else{
             NodoListaAmbulancia aux =inicio;
             while (aux.getSiguiente()!=null && aux.getSiguiente().getDato().getId().compareTo(amb.getId())==-1 ) {                 
              aux=aux.getSiguiente() ;
             }
             NodoListaAmbulancia na= new NodoListaAmbulancia(amb);
             na.setSiguiente(aux.getSiguiente());
             aux.setSiguiente(na);
             
         }
     }
     
     
    
}
