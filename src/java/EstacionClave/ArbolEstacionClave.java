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
    public static ArbolEstacionClave arbolitoEstacionClave = new ArbolEstacionClave();
     public NodoArbolEstacionClave raiz;
    public ArbolEstacionClave(){
    
    raiz = null;
    
    }
    
    public NodoArbolEstacionClave obtenerRaiz(){
     return raiz;
    
    }
    //buscar un nodo
    public NodoArbolEstacionClave buscar(int d, NodoArbolEstacionClave r){
    
    if(raiz==null){
        return r;
    }else if(r.idEstacionClave == d){
        return r;   
    }else if(r.idEstacionClave<d){      
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
      if(nuevo.idEstacionClave<subAr.idEstacionClave){
         if(subAr.hijoIzquierdo == null){
            subAr.hijoIzquierdo = nuevo;
         }else{
            subAr.hijoIzquierdo = insertarAVL(nuevo, subAr.hijoIzquierdo);
            if((obtenerFE(subAr.hijoIzquierdo)- obtenerFE(subAr.hijoDerecho)== 2)){
            
               if(nuevo.idEstacionClave<subAr.hijoIzquierdo.idEstacionClave){
               
                   nuevoPadre = rotacionIzquierda(subAr);
               }else{
                   nuevoPadre = rotacionDobleIzquierda(subAr);
               }
            }
         }
      
      }else if(nuevo.idEstacionClave>subAr.idEstacionClave){
          if(subAr.hijoDerecho == null){
          
             subAr.hijoDerecho = nuevo;
          }else{
             subAr.hijoDerecho = insertarAVL(nuevo, subAr.hijoDerecho);
             if((obtenerFE(subAr.hijoDerecho)-obtenerFE(subAr.hijoIzquierdo)==2)){
               if(nuevo.idEstacionClave>subAr.hijoDerecho.idEstacionClave){
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
     
     public String insertar(int d, String n, String co){
     
    String respuesta= " ";
    try{
     NodoArbolEstacionClave nuevo = new NodoArbolEstacionClave(d,n,co);
     if(raiz == null){
       raiz = nuevo;
       respuesta="registro exitoso";
     }else{     
       raiz = insertarAVL(nuevo, raiz);
       respuesta="registro exitoso";
     }  
    }catch(Exception e){
    respuesta="no se registro usuario";
    }
     return respuesta;
    }
     //recorridos
     //metodo para recorrer el  arbol inOrden
    
     public String inOrden(NodoArbolEstacionClave r){ 
        String Respusta="";
     if(r !=null){     
     Respusta+=inOrden(r.hijoIzquierdo);     
     Respusta+=" id: " +r.idEstacionClave + " Nombre: "+ r.nombre + " Contraseña: " + r.contrasena + "\n";
     System.out.print(Respusta);
     Respusta+=inOrden(r.hijoDerecho);
     
     }
     return Respusta;
     }
     
     //metodo para recorrer el arbol preOrden
     public void preOrden(NodoArbolEstacionClave r){     
     if(r !=null){    
     System.out.println(" id: " +r.idEstacionClave + " Nombre: "+ r.nombre + " Contraseña: " + r.contrasena);    
     preOrden(r.hijoIzquierdo);  
     preOrden(r.hijoDerecho);
     }     
     }
     // metodo para recorrer el arbol posOrden
     public void posOrden(NodoArbolEstacionClave r){     
     if(r !=null){            
     preOrden(r.hijoIzquierdo);  
     preOrden(r.hijoDerecho);
     System.out.println(" id: " +r.idEstacionClave + " Nombre: "+ r.nombre + " Contraseña: " + r.contrasena); 
     }     
     }
     // verificar un nodo
    public boolean Miembro(int Codau, NodoArbolEstacionClave R){
		NodoArbolEstacionClave Aux = R;
		boolean miembro = false;
		while (Aux != null){
			if (Codau==Aux.idEstacionClave){
				miembro = true;
				Aux = null;
			}
			else{
				if (Codau>Aux.idEstacionClave)
					Aux = Aux.hijoDerecho;
                                        
				else{
					Aux = Aux.hijoIzquierdo;
					if (Aux == null)
						miembro = false;
				}
			}
		}
		return miembro;
	}
    // metodo eliminar un nodo
     
     public boolean eliminar(int d){
     
         NodoArbolEstacionClave auxiliar = raiz;
         NodoArbolEstacionClave padre = raiz;
         boolean esHijoIzq = true;
         while(auxiliar.idEstacionClave != d){
           padre = auxiliar;
           
           if(d<auxiliar.idEstacionClave){
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
     
     //metodo encargado de devolvernos el nodo reemplazo del metodo eliminar
     
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
     public NodoArbolEstacionClave modificar_contrasena(int id, String nombrenuevo, String ContrasenaNueva){
        NodoArbolEstacionClave nodo = buscar(id, raiz);
        
         if(nodo != null){
         nodo.nombre = nombrenuevo;
         nodo.contrasena = ContrasenaNueva;
             
         }
         return nodo;
      
     }
}
