/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import Administrador.*;
import Bus.ListaBus;
import Chofer.ArbolChofer;
import Chofer.NodoArbolChofer;
import EstacionClave.ArbolEstacionClave;
import EstacionClave.NodoArbolEstacionClave;
import EstacionGeneral.ArbolEstacionGeneral;
import EstacionGeneral.NodoArbolEstacionGeneral;
import Horarios.ListaHorarios;
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
    @WebMethod(operationName = "ValidarAdmin")
    public boolean ValidarAdmin(@WebParam(name = "correo") String correo) {
        
        NodoArbolAVL r = ArbolAVL.listaadmin.obtenerRaiz();
        return ArbolAVL.listaadmin.Miembro(correo,  r);
        
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ValidarEstacionClave")
    public boolean ValidarEstacionClave(@WebParam(name = "clave") int clave) {
        //TODO write your implementation code here:
        NodoArbolEstacionClave r = ArbolEstacionClave.arbolestacionclave.obtenerRaiz();
        return ArbolEstacionClave.arbolestacionclave.Miembro(clave,  r);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "InsertarEstacionClave")
    public String InsertarEstacionClave(@WebParam(name = "clave") int clave, @WebParam(name = "nombre") String nombre, @WebParam(name = "pass") String pass, @WebParam(name = "ruta") String ruta) {
        //TODO write your implementation code here:
        String respuesta= ArbolEstacionClave.arbolestacionclave.insertar(clave, nombre,pass, ruta);
        return respuesta;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "InsertarChofer")
    public String InsertarChofer(@WebParam(name = "idChofer") int idChofer, @WebParam(name = "nombre") String nombre, @WebParam(name = "apellido") String apellido, @WebParam(name = "pass") String pass) {
      
        String respuesta= ArbolChofer.arbolchofer.insertar(idChofer, nombre, apellido , pass);
        return respuesta;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "MostrarChofer")
    public String MostrarChofer() {
       NodoArbolChofer r = ArbolChofer.arbolchofer.obtenerRaiz();
         String Respuesta =ArbolChofer.arbolchofer.inOrden(r);
         return Respuesta;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ValidarChofer")
    public boolean ValidarChofer(@WebParam(name = "IdChofer") int IdChofer) {
       
         NodoArbolChofer r = ArbolChofer.arbolchofer.obtenerRaiz();
        return ArbolChofer.arbolchofer.Miembro(IdChofer,  r);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "MostrarEstacionClave")
    public String MostrarEstacionClave() {
        
        NodoArbolEstacionClave r = ArbolEstacionClave.arbolestacionclave.obtenerRaiz();
         String Respuesta =ArbolEstacionClave.arbolestacionclave.inOrden(r);
         return Respuesta;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "InsertarEstacionGeneral")
    public String InsertarEstacionGeneral(@WebParam(name = "clave") int clave, @WebParam(name = "nombre") String nombre, @WebParam(name = "pass") String pass, @WebParam(name = "ruta") String ruta) {
        
        String respuesta= ArbolEstacionGeneral.arbolestaciongeneral.insertar( clave,nombre,pass,ruta);
        return respuesta;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "MostrarEstacionGeneral")
    public String MostrarEstacionGeneral() {
        
        NodoArbolEstacionGeneral r = ArbolEstacionGeneral.arbolestaciongeneral.obtenerRaiz();
         String Respuesta =ArbolEstacionGeneral.arbolestaciongeneral.inOrden(r);
         return Respuesta;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ValidarEstacionGeneral")
    public boolean ValidarEstacionGeneral(@WebParam(name = "clave") int clave) {
      NodoArbolEstacionGeneral r = ArbolEstacionGeneral.arbolestaciongeneral.obtenerRaiz();
        return ArbolEstacionGeneral.arbolestaciongeneral.Miembro(clave,  r); 
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "InsertarBus")
    public String InsertarBus(@WebParam(name = "idBus") int idBus) {
        
       String respuesta= ListaBus.listabuses.insertarFinal(idBus);
        return respuesta;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "MostrarBus")
    public String MostrarBus() {
       String Respuesta =ListaBus.listabuses.ordenaBurbuja();
         return Respuesta;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "AsignarBus")
    public String AsignarBus(@WebParam(name = "ruta") String ruta, @WebParam(name = "horainicio") String horainicio, @WebParam(name = "horafin") String horafin, @WebParam(name = "fecha") String fecha, @WebParam(name = "idbus") int idbus, @WebParam(name = "idchofer") int idchofer) {
    
        String respuesta= ListaHorarios.listaasignaciones.insertarFinal(ruta, horainicio, horafin, fecha, idbus, idchofer);
        return respuesta;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "MostrarAsignacion")
    public String MostrarAsignacion() {
       String Respuesta =ListaHorarios.listaasignaciones.mostrar();
         return Respuesta;
    }
}
