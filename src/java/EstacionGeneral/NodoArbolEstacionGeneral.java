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
    int idEstacionGeneral, fe;
    String nombre, contrasena;
    NodoArbolEstacionGeneral hijoIzquierdo, hijoDerecho;

    public NodoArbolEstacionGeneral(int idEstacionGeneral, String nombre, String contrasena) {
        this.idEstacionGeneral = idEstacionGeneral;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.fe= 0;
        this.hijoIzquierdo= null;
        this.hijoDerecho=null;
    }
    
    
}
