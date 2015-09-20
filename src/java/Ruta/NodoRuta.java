/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ruta;

/**
 *
 * @author allan
 */
public class NodoRuta {
    
    String ruta;
    NodoRuta anterior;
    NodoRuta siguiente;

    public NodoRuta(String idBus) {
        this.ruta = idBus;
        this.anterior = null;
        this.siguiente = null;
        
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public NodoRuta getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoRuta anterior) {
        this.anterior = anterior;
    }

    public NodoRuta getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoRuta siguiente) {
        this.siguiente = siguiente;
    }

    
    
}
