/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EstacionGeneral;

/**
 *
 * @author allan
 */
public class NodoArbolEstacionGeneral {
    int IdEstacionGeneral, fe;
    
    String contrasena, nombre, ruta;
  
    NodoArbolEstacionGeneral hijoIzquierdo, hijoDerecho;
   
    
    
    public NodoArbolEstacionGeneral(int clave, String nombre,String contrasena,String ruta){
      this.IdEstacionGeneral=clave;
      this.nombre=nombre;
      this.contrasena = contrasena;
      this.ruta = ruta;
      this.fe= 0;
      this.hijoIzquierdo= null;
      this.hijoDerecho=null;
      
    }
   
}
