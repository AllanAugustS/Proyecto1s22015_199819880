/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bus;

/**
 *
 * @author allan
 */
public class NodoBus {
    
    int idBus;
    NodoBus anterior;
    NodoBus siguiente;

    public NodoBus(int idBus) {
        this.idBus = idBus;
        this.anterior = null;
        this.siguiente = null;
        
    }

    public int getIdBus() {
        return idBus;
    }

    public void setIdBus(int idBus) {
        this.idBus = idBus;
    }

    public NodoBus getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoBus anterior) {
        this.anterior = anterior;
    }

    public NodoBus getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoBus siguiente) {
        this.siguiente = siguiente;
    }
    
    
    
    
    
}
