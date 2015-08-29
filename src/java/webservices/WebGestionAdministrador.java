/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import Administrador.*;
/**
 *
 * @author allan

*/

@WebService(serviceName = "WebGestionAdministrador")
public class WebGestionAdministrador {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "InsertarAdministrador")
    public String InsertarAdministrador(@WebParam(name = "id") int id, @WebParam(name = "contrasena") String contrasena, @WebParam(name = "correo") String correo) {
        //TODO write your implementation code here:
        
         
        String respuesta=ArbolAVL.arbolito.insertar(id, contrasena, correo);
        return respuesta;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "MostrarAdmin")
    public String MostrarAdmin() {
        //TODO write your implementation code here:
        NodoArbolAVL r = ArbolAVL.arbolito.raiz;
         String Respuesta =ArbolAVL.arbolito.inOrden(r);
         return Respuesta;
      }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "VerificarNodo")
    public boolean VerificarNodo(@WebParam(name = "id") int id) {
        
        NodoArbolAVL r = ArbolAVL.arbolito.raiz;
        return ArbolAVL.arbolito.Miembro(id,  r);
        
    }
}
