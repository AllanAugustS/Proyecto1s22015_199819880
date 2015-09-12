package Administrador;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author allan
 */
public class NodoArbolAVL {
    int  fe;
    String contrasena, correo;
    NodoArbolAVL hijoIzquierdo, hijoDerecho;
    
    public NodoArbolAVL( String n,String co){
      this.contrasena = n;
      this.correo = co;
      this.fe= 0;
      this.hijoIzquierdo= null;
      this.hijoDerecho=null;
    
    }
}
