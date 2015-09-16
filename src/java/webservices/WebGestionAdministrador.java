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
    public String InsertarAdministrador( @WebParam(name = "contrasena") String contrasena, @WebParam(name = "correo") String correo) {
        //TODO write your implementation code here:
        
         
        String respuesta= ArbolAVL.listaadmin.insertar( contrasena, correo);
        return respuesta;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "MostrarAdmin")
    public String MostrarAdmin() {
        //TODO write your implementation code here:
        NodoArbolAVL r = ArbolAVL.listaadmin.obtenerRaiz();
         String Respuesta =ArbolAVL.listaadmin.inOrden(r);
         return Respuesta;
      }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "VerificarNodo")
    public boolean VerificarNodo(@WebParam(name = "correo") String correo) {
        
        NodoArbolAVL r = ArbolAVL.listaadmin.obtenerRaiz();
        return ArbolAVL.listaadmin.Miembro(correo,  r);
        
    }
}
