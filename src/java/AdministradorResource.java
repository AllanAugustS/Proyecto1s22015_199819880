
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author allan
 */
@Stateless
@Path("/Administrador")
public class AdministradorResource {
    
     
    @POST
    @Consumes({"application/xml"})    
    public Response insertar(@QueryParam("d")int d,@QueryParam("n") String n, @QueryParam("co")String co){
        ArbolAVL arbol = new ArbolAVL();   
         NodoArbolAVL nuevo = new NodoArbolAVL(d,n,co);
     if(arbol.raiz == null){
       arbol.raiz = nuevo;
     }else{
     
       arbol.raiz = arbol.insertarAVL(nuevo, arbol.raiz);
     }
        
        return Response.ok(nuevo).build();
    
    }
    
    @GET
    @Produces({"application/xml"})
    public void leer(NodoArbolAVL r){     
     if(r !=null){     
     leer(r.hijoIzquierdo);     
     System.out.println(" id: " +r.dato + " Correo: "+ r.correo + " Contraseña: " + r.contrasena);
     leer(r.hijoDerecho);
     }     
     }
     
     
     
    
}
