/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author allan
 */
public class NodoArbolAVL {
    int dato, fe;
    String contrasena, correo;
    NodoArbolAVL hijoIzquierdo, hijoDerecho;
    
    public NodoArbolAVL(int d, String n,String co){
      this.contrasena = n;
      this.correo = co;
      this.dato = d;
      this.fe= 0;
      this.hijoIzquierdo= null;
      this.hijoDerecho=null;
    
    }
}
