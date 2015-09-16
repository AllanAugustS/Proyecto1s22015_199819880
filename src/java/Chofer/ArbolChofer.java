/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Chofer;

/**
 *
 * @author allan
 */
public class ArbolChofer {
   public static ArbolChofer arbolchofer = new ArbolChofer();
     private NodoArbolChofer raiz;
    public ArbolChofer(){
    
    raiz = null;
    
    }
    
    public NodoArbolChofer obtenerRaiz(){
     return raiz;
    
    }
    //buscar un nodo
    public NodoArbolChofer buscar(int d, NodoArbolChofer r){
    
    if(raiz==null){
        return null;
    }else if(r.IdChofer == d){
        return r;   
    }else if(r.IdChofer<d){      
        return buscar(d,r.hijoDerecho);    
    }else{
        return buscar(d, r.hijoIzquierdo);
    }    
    }
    // metodo obtener factor de equilibrio
    
    public int obtenerFE(NodoArbolChofer x){
    
    if(x==null){
        return -1;
    }else{    
        return x.fe;
    }   
   }
    //rotacion simple izquierda
    
    public NodoArbolChofer rotacionIzquierda(NodoArbolChofer c){
        NodoArbolChofer aux= c.hijoIzquierdo;
        c.hijoIzquierdo= aux.hijoDerecho;
        aux.hijoDerecho= c;
        c.fe =Math.max(obtenerFE(c.hijoIzquierdo),obtenerFE(c.hijoDerecho))+1;
        aux.fe=Math.max(obtenerFE(aux.hijoIzquierdo),obtenerFE(aux.hijoDerecho))+1;
        
        return aux;    
    }
    // rotacion simple derecha
    public NodoArbolChofer rotacionDerecha(NodoArbolChofer c){
        NodoArbolChofer aux= c.hijoDerecho;
        c.hijoDerecho= aux.hijoIzquierdo;
        aux.hijoIzquierdo= c;
        c.fe =Math.max(obtenerFE(c.hijoIzquierdo),obtenerFE(c.hijoDerecho))+1;
        aux.fe=Math.max(obtenerFE(aux.hijoIzquierdo),obtenerFE(aux.hijoDerecho))+1;
        
        return aux;    
    }
    // rotacion doble a la izquierda
    
    public NodoArbolChofer rotacionDobleIzquierda(NodoArbolChofer c){
    
    NodoArbolChofer temporal;
    c.hijoIzquierdo = rotacionDerecha(c.hijoIzquierdo);
    temporal = rotacionIzquierda(c);
    return temporal;
    
    }
    
    // rotacion doble a la derecha
    
     public NodoArbolChofer rotacionDobleDerecha(NodoArbolChofer c){
    
    NodoArbolChofer temporal;
    c.hijoDerecho = rotacionIzquierda(c.hijoDerecho);
    temporal = rotacionDerecha(c);
    return temporal;
    
    }
     //metodo para insertar AVL
     public NodoArbolChofer insertarAVL(NodoArbolChofer nuevo, NodoArbolChofer subAr){
     
      NodoArbolChofer nuevoPadre = subAr;
      if(nuevo.IdChofer<subAr.IdChofer){
         if(subAr.hijoIzquierdo == null){
            subAr.hijoIzquierdo = nuevo;
         }else{
            subAr.hijoIzquierdo = insertarAVL(nuevo, subAr.hijoIzquierdo);
            if((obtenerFE(subAr.hijoIzquierdo)- obtenerFE(subAr.hijoDerecho)== 2)){
            
               if(nuevo.IdChofer<subAr.hijoIzquierdo.IdChofer){
               
                   nuevoPadre = rotacionIzquierda(subAr);
               }else{
                   nuevoPadre = rotacionDobleIzquierda(subAr);
               }
            }
         }
      
      }else if(nuevo.IdChofer>subAr.IdChofer){
          if(subAr.hijoDerecho == null){
          
             subAr.hijoDerecho = nuevo;
          }else{
             subAr.hijoDerecho = insertarAVL(nuevo, subAr.hijoDerecho);
             if((obtenerFE(subAr.hijoDerecho)-obtenerFE(subAr.hijoIzquierdo)==2)){
               if(nuevo.IdChofer>subAr.hijoDerecho.IdChofer){
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
     
     public void insertar(int clave, String nom, String ape,String contra){
     
     NodoArbolChofer nuevo = new NodoArbolChofer(clave,nom,ape,contra);
     if(raiz == null){
       raiz = nuevo;
     }else{
     
       raiz = insertarAVL(nuevo, raiz);
      
     }
     
     }
     //recorridos
     //metodo para recorrer el  arbol inOrden
     public String inOrden(NodoArbolChofer r){     
     String Resultado="";
     if(r !=null){     
     Resultado+=inOrden(r.hijoIzquierdo);     
     Resultado+= " Clave: " +r.IdChofer + " Nombre: "+ r.nombre + " apellido: " + r.apellido + " Contrasena: " + r.contrasena + "\n";
     Resultado+=inOrden(r.hijoDerecho);
     }  
     return Resultado;
     }
      public String inOrden2(NodoArbolChofer r){     
     String Respuesta="";
     if(r !=null){     
     Respuesta+=inOrden2(r.hijoIzquierdo);     
     Respuesta+=  r.IdChofer + "," ;
     Respuesta+=inOrden2(r.hijoDerecho);
     }     
     return Respuesta;
     }
     //metodo para recorrer el arbol preOrden
     public void preOrden(NodoArbolChofer r){     
     if(r !=null){    
     System.out.println("Clave: " +r.IdChofer + " Nombre: "+ r.nombre + " apellido: " + r.apellido + " Contrasena: " + r.contrasena);    
     preOrden(r.hijoIzquierdo);  
     preOrden(r.hijoDerecho);
     }     
     }
     // metodo para recorrer el arbol posOrden
     public void posOrden(NodoArbolChofer r){     
     if(r !=null){            
     preOrden(r.hijoIzquierdo);  
     preOrden(r.hijoDerecho);
     System.out.println(" Clave: " +r.IdChofer + " Nombre: "+ r.nombre + " apellido: " + r.apellido + " Contrasena: " + r.contrasena); 
     }     
     }
     
   // metodo eliminar un nodo
     
     public boolean eliminar(int d){
     
         NodoArbolChofer auxiliar = raiz;
         NodoArbolChofer padre = raiz;
         boolean esHijoIzq = true;
         while(auxiliar.IdChofer != d){
           padre = auxiliar;
           
           if(d<auxiliar.IdChofer){
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
         
             NodoArbolChofer reemplazo=obtenerNodoReemplazo(auxiliar);
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
     
     public NodoArbolChofer obtenerNodoReemplazo(NodoArbolChofer nodoreemp){
     
      NodoArbolChofer reemplazarPadre=nodoreemp;
      NodoArbolChofer reemplazo = nodoreemp;
      NodoArbolChofer auxiliar = nodoreemp.hijoDerecho;
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
     public NodoArbolChofer modificar_contrasena(int id,  String nombrenuevo,String apellidonuevo,String ContrasenaNueva){
        NodoArbolChofer nodo =buscar(id, raiz);
        
         if(nodo != null){
         
         nodo.contrasena = ContrasenaNueva;
         nodo.nombre = nombrenuevo;
         nodo.apellido = apellidonuevo;
         }
         return nodo;
      
     }
     
      
}
