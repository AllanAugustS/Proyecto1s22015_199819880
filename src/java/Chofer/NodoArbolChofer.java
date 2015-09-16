/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Chofer;

/**
 *
 * @author allan
 */
public class NodoArbolChofer {
     int IdChofer, fe;
    String contrasena, nombre,apellido;
  
    NodoArbolChofer hijoIzquierdo, hijoDerecho;
    
    public NodoArbolChofer(int clave, String nombre,String apellido,String contrasena){
      this.IdChofer=clave;
      this.nombre=nombre;
      this.apellido=apellido;
      this.contrasena = contrasena;
      this.fe= 0;
      this.hijoIzquierdo= null;
      this.hijoDerecho=null;
      
    }

    public int getIdChofer() {
        return IdChofer;
    }

    public void setIdChofer(int IdChofer) {
        this.IdChofer = IdChofer;
    }

    public NodoArbolChofer getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public void setHijoIzquierdo(NodoArbolChofer hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public NodoArbolChofer getHijoDerecho() {
        return hijoDerecho;
    }

    public void setHijoDerecho(NodoArbolChofer hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }
   
}
