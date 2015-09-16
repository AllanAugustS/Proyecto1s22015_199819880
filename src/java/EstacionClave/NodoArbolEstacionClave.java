/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EstacionClave;



/**
 *
 * @author allan
 */
public class NodoArbolEstacionClave {
     int IdEstacionClave, fe;
    
    String contrasena, nombre,ruta;
  
    NodoArbolEstacionClave hijoIzquierdo, hijoDerecho;
    
    
    public NodoArbolEstacionClave(int clave, String nombre,String contrasena, String ruta){
      this.IdEstacionClave=clave;
      this.nombre=nombre;
      this.contrasena = contrasena;
      this.ruta=ruta;
      this.fe= 0;
      this.hijoIzquierdo= null;
      this.hijoDerecho=null;
      
    }
   
    
}
