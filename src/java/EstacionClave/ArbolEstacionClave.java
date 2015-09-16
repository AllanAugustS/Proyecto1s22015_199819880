/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EstacionClave;

/**
 *
 * @author allan
 */
public class ArbolEstacionClave {
     public static ArbolEstacionClave arbolestacionclave = new ArbolEstacionClave();
     private NodoArbolEstacionClave raiz;
    public ArbolEstacionClave(){
    
    raiz = null;
    
    }
    
    public NodoArbolEstacionClave obtenerRaiz(){
     return raiz;
    
    }
    //buscar un nodo
    public NodoArbolEstacionClave buscar(int d, NodoArbolEstacionClave r){
    
    if(raiz==null){
        return null;
    }else if(r.IdEstacionClave == d){
        return r;   
    }else if(r.IdEstacionClave<d){      
        return buscar(d,r.hijoDerecho);    
    }else{
        return buscar(d, r.hijoIzquierdo);
    }    
    }
    // metodo obtener factor de equilibrio
    
    public int obtenerFE(NodoArbolEstacionClave x){
    
    if(x==null){
        return -1;
    }else{    
        return x.fe;
    }   
   }
    //rotacion simple izquierda
    
    public NodoArbolEstacionClave rotacionIzquierda(NodoArbolEstacionClave c){
        NodoArbolEstacionClave aux= c.hijoIzquierdo;
        c.hijoIzquierdo= aux.hijoDerecho;
        aux.hijoDerecho= c;
        c.fe =Math.max(obtenerFE(c.hijoIzquierdo),obtenerFE(c.hijoDerecho))+1;
        aux.fe=Math.max(obtenerFE(aux.hijoIzquierdo),obtenerFE(aux.hijoDerecho))+1;
        
        return aux;    
    }
    // rotacion simple derecha
    public NodoArbolEstacionClave rotacionDerecha(NodoArbolEstacionClave c){
        NodoArbolEstacionClave aux= c.hijoDerecho;
        c.hijoDerecho= aux.hijoIzquierdo;
        aux.hijoIzquierdo= c;
        c.fe =Math.max(obtenerFE(c.hijoIzquierdo),obtenerFE(c.hijoDerecho))+1;
        aux.fe=Math.max(obtenerFE(aux.hijoIzquierdo),obtenerFE(aux.hijoDerecho))+1;
        
        return aux;    
    }
    // rotacion doble a la izquierda
    
    public NodoArbolEstacionClave rotacionDobleIzquierda(NodoArbolEstacionClave c){
    
    NodoArbolEstacionClave temporal;
    c.hijoIzquierdo = rotacionDerecha(c.hijoIzquierdo);
    temporal = rotacionIzquierda(c);
    return temporal;
    
    }
    
    // rotacion doble a la derecha
    
     public NodoArbolEstacionClave rotacionDobleDerecha(NodoArbolEstacionClave c){
    
    NodoArbolEstacionClave temporal;
    c.hijoDerecho = rotacionIzquierda(c.hijoDerecho);
    temporal = rotacionDerecha(c);
    return temporal;
    
    }
     //metodo para insertar AVL
     public NodoArbolEstacionClave insertarAVL(NodoArbolEstacionClave nuevo, NodoArbolEstacionClave subAr){
     
      NodoArbolEstacionClave nuevoPadre = subAr;
      if(nuevo.IdEstacionClave<subAr.IdEstacionClave){
         if(subAr.hijoIzquierdo == null){
            subAr.hijoIzquierdo = nuevo;
         }else{
            subAr.hijoIzquierdo = insertarAVL(nuevo, subAr.hijoIzquierdo);
            if((obtenerFE(subAr.hijoIzquierdo)- obtenerFE(subAr.hijoDerecho)== 2)){
            
               if(nuevo.IdEstacionClave<subAr.hijoIzquierdo.IdEstacionClave){
               
                   nuevoPadre = rotacionIzquierda(subAr);
               }else{
                   nuevoPadre = rotacionDobleIzquierda(subAr);
               }
            }
         }
      
      }else if(nuevo.IdEstacionClave>subAr.IdEstacionClave){
          if(subAr.hijoDerecho == null){
          
             subAr.hijoDerecho = nuevo;
          }else{
             subAr.hijoDerecho = insertarAVL(nuevo, subAr.hijoDerecho);
             if((obtenerFE(subAr.hijoDerecho)-obtenerFE(subAr.hijoIzquierdo)==2)){
               if(nuevo.IdEstacionClave>subAr.hijoDerecho.IdEstacionClave){
                 nuevoPadre = rotacionDerecha(subAr);
               }else{
                 nuevoPadre = rotacionDobleDerecha(subAr);
               }
             }
          }
      
      }else{
      
       System.out.println("Nodo Duplicado");
      }
     //Actualizando la altura
      
      if((subAr.hijoIzquierdo == null) && (subAr.hijoDerecho != null)){
         subAr.fe = subAr.hijoDerecho.fe+1;
      }else if((subAr.hijoDerecho == null)&&(subAr.hijoIzquierdo != null)){
         subAr.fe = subAr.hijoIzquierdo.fe+1;
      
      }else{
         subAr.fe = Math.max(obtenerFE(subAr.hijoIzquierdo), obtenerFE(subAr.hijoDerecho))+1;
      }
      return nuevoPadre;
   }
     
     //metodo insertar
     
     public void insertar(int clave, String nom, String contra, String rut){
     
     NodoArbolEstacionClave nuevo = new NodoArbolEstacionClave(clave,nom,contra,rut);
     if(raiz == null){
       raiz = nuevo;
     }else{
     
       raiz = insertarAVL(nuevo, raiz);
      
     }
     
     }
     //recorridos
     //metodo para recorrer el  arbol inOrden
     public void inOrden(NodoArbolEstacionClave r){     
     if(r !=null){     
     inOrden(r.hijoIzquierdo);     
     System.out.println("IdEstacionClave: " +r.IdEstacionClave + " Nombre: "+ r.nombre + " Contrasena: " + r.contrasena );
     inOrden(r.hijoDerecho);
     }     
     }
     //metodo para recorrer el arbol preOrden
     public void preOrden(NodoArbolEstacionClave r){     
     if(r !=null){    
     System.out.println("IdEstacionClave: " +r.IdEstacionClave + " Nombre: "+ r.nombre + " Contrasena: " + r.contrasena);    
     preOrden(r.hijoIzquierdo);  
     preOrden(r.hijoDerecho);
     }     
     }
     // metodo para recorrer el arbol posOrden
     public void posOrden(NodoArbolEstacionClave r){     
     if(r !=null){            
     preOrden(r.hijoIzquierdo);  
     preOrden(r.hijoDerecho);
     System.out.println("IdEstacionClave: " +r.IdEstacionClave + " Nombre: "+ r.nombre + " Contrasena: " + r.contrasena); 
     }     
     }
     
   // metodo eliminar un nodo
     
     public boolean eliminar(int d){
     
         NodoArbolEstacionClave auxiliar = raiz;
         NodoArbolEstacionClave padre = raiz;
         boolean esHijoIzq = true;
         while(auxiliar.IdEstacionClave != d){
           padre = auxiliar;
           
           if(d<auxiliar.IdEstacionClave){
             esHijoIzq = true;
             auxiliar= auxiliar.hijoIzquierdo;
               
           }else{
           
             esHijoIzq = false;
             auxiliar = auxiliar.hijoDerecho;
           }
            if(auxiliar== null){
            
              return false;
            }
         }//fin de while
                 
         if(auxiliar.hijoIzquierdo ==null && auxiliar.hijoDerecho==null){
         
            if(auxiliar== raiz){
            
                raiz=null;
            }else if(esHijoIzq){
               
                padre.hijoIzquierdo = null;
            }else{
               padre.hijoDerecho = null;
            }
         }else if(auxiliar.hijoDerecho == null){
          if(auxiliar== raiz){
            
                raiz=auxiliar.hijoIzquierdo;
            }else if(esHijoIzq){
               
                padre.hijoIzquierdo = auxiliar.hijoIzquierdo;
            }else{
               padre.hijoDerecho = auxiliar.hijoIzquierdo;
            }
             
         }else if(auxiliar.hijoIzquierdo == null){
               if(auxiliar== raiz){
            
                raiz=auxiliar.hijoDerecho;
            }else if(esHijoIzq){
               
                padre.hijoIzquierdo = auxiliar.hijoDerecho;
            }else{
               padre.hijoDerecho = auxiliar.hijoIzquierdo;
            }
         }else{
         
             NodoArbolEstacionClave reemplazo=obtenerNodoReemplazo(auxiliar);
             if(auxiliar == raiz){
                raiz = reemplazo;
             }else if(esHijoIzq){
               padre.hijoIzquierdo = reemplazo;
             
             }else{
               padre.hijoDerecho= reemplazo;
             }
             reemplazo.hijoIzquierdo = auxiliar.hijoIzquierdo;
         }
         return true;
     }
     
     //metodo encargado de devolvernos el nodo reemplazo
     
     public NodoArbolEstacionClave obtenerNodoReemplazo(NodoArbolEstacionClave nodoreemp){
     
      NodoArbolEstacionClave reemplazarPadre=nodoreemp;
      NodoArbolEstacionClave reemplazo = nodoreemp;
      NodoArbolEstacionClave auxiliar = nodoreemp.hijoDerecho;
      while(auxiliar != null){
          reemplazarPadre = reemplazo;
          reemplazo=auxiliar;
          auxiliar = auxiliar.hijoIzquierdo;
      
      }
       if(reemplazo != nodoreemp.hijoDerecho){
          reemplazarPadre.hijoIzquierdo = reemplazo.hijoDerecho;
          reemplazo.hijoDerecho=nodoreemp.hijoDerecho;
       
       }
       
       return reemplazo;
       
     }
     
     //metodo modificar nodo
     public NodoArbolEstacionClave modificar_contrasena(int id,  String nombrenuevo,String ContrasenaNueva){
        NodoArbolEstacionClave nodo =buscar(id, raiz);
        
         if(nodo != null){
         
         nodo.contrasena = ContrasenaNueva;
         nodo.nombre = nombrenuevo;
         
         }
         return nodo;
      
     }
     
}
