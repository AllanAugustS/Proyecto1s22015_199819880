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
    int idEstacionClave, fe;
    String nombre, contrasena;
    NodoArbolEstacionClave hijoIzquierdo, hijoDerecho;

    public NodoArbolEstacionClave(int idEstacionClave, String nombre, String contrasena) {
        this.idEstacionClave = idEstacionClave;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.fe= 0;
        this.hijoIzquierdo= null;
        this.hijoDerecho=null;
    }
    
    
}
