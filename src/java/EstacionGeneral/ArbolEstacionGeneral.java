/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EstacionGeneral;

/**
 *
 * @author allan
 */
public class ArbolEstacionGeneral {
     public static ArbolEstacionGeneral arbolitoEstacionGeneral = new ArbolEstacionGeneral();
     public NodoArbolEstacionGeneral raiz;
     
     public ArbolEstacionGeneral(){
    
    raiz = null;
    
    }
    
    public NodoArbolEstacionGeneral obtenerRaiz(){
     return raiz;
    
    }
    //buscar un nodo
    public NodoArbolEstacionGeneral buscar(int d, NodoArbolEstacionGeneral r){
    
    if(raiz==null){
        return r;
    }else if(r.idEstacionGeneral == d){
        return r;   
    }else if(r.idEstacionGeneral<d){      
        return buscar(d,r.hijoDerecho);
        
    }else{
        return buscar(d, r.hijoIzquierdo);
    }    
    }
    
    
    // metodo obtener factor de equilibrio
    
    public int obtenerFE(NodoArbolEstacionGeneral x){
    
    if(x==null){
        return -1;
    }else{    
        return x.fe;
    }   
   }
    //rotacion simple izquierda
    
    public NodoArbolEstacionGeneral rotacionIzquierda(NodoArbolEstacionGeneral c){
        NodoArbolEstacionGeneral aux= c.hijoIzquierdo;
        c.hijoIzquierdo= aux.hijoDerecho;
        aux.hijoDerecho= c;
        c.fe =Math.max(obtenerFE(c.hijoIzquierdo),obtenerFE(c.hijoDerecho))+1;
        aux.fe=Math.max(obtenerFE(aux.hijoIzquierdo),obtenerFE(aux.hijoDerecho))+1;
        
        return aux;    
    }
    // rotacion simple derecha
    public NodoArbolEstacionGeneral rotacionDerecha(NodoArbolEstacionGeneral c){
       NodoArbolEstacionGeneral aux= c.hijoDerecho;
        c.hijoDerecho= aux.hijoIzquierdo;
        aux.hijoIzquierdo= c;
        c.fe =Math.max(obtenerFE(c.hijoIzquierdo),obtenerFE(c.hijoDerecho))+1;
        aux.fe=Math.max(obtenerFE(aux.hijoIzquierdo),obtenerFE(aux.hijoDerecho))+1;
        
        return aux;    
    }
    // rotacion doble a la izquierda
    
    public NodoArbolEstacionGeneral rotacionDobleIzquierda(NodoArbolEstacionGeneral c){
    
    NodoArbolEstacionGeneral temporal;
    c.hijoIzquierdo = rotacionDerecha(c.hijoIzquierdo);
    temporal = rotacionIzquierda(c);
    return temporal;
    
    }
    
    // rotacion doble a la derecha
    
     public NodoArbolEstacionGeneral rotacionDobleDerecha(NodoArbolEstacionGeneral c){
    
    NodoArbolEstacionGeneral temporal;
    c.hijoDerecho = rotacionIzquierda(c.hijoDerecho);
    temporal = rotacionDerecha(c);
    return temporal;
    
    }
     //metodo para insertar AVL
     public NodoArbolEstacionGeneral insertarAVL(NodoArbolEstacionGeneral nuevo, NodoArbolEstacionGeneral subAr){
     
      NodoArbolEstacionGeneral nuevoPadre = subAr;
      if(nuevo.idEstacionGeneral<subAr.idEstacionGeneral){
         if(subAr.hijoIzquierdo == null){
            subAr.hijoIzquierdo = nuevo;
         }else{
            subAr.hijoIzquierdo = insertarAVL(nuevo, subAr.hijoIzquierdo);
            if((obtenerFE(subAr.hijoIzquierdo)- obtenerFE(subAr.hijoDerecho)== 2)){
            
               if(nuevo.idEstacionGeneral<subAr.hijoIzquierdo.idEstacionGeneral){
               
                   nuevoPadre = rotacionIzquierda(subAr);
               }else{
                   nuevoPadre = rotacionDobleIzquierda(subAr);
               }
            }
         }
      
      }else if(nuevo.idEstacionGeneral>subAr.idEstacionGeneral){
          if(subAr.hijoDerecho == null){
          
             subAr.hijoDerecho = nuevo;
          }else{
             subAr.hijoDerecho = insertarAVL(nuevo, subAr.hijoDerecho);
             if((obtenerFE(subAr.hijoDerecho)-obtenerFE(subAr.hijoIzquierdo)==2)){
               if(nuevo.idEstacionGeneral>subAr.hijoDerecho.idEstacionGeneral){
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
    NodoArbolEstacionGeneral nuevo = new NodoArbolEstacionGeneral(d,n,co);
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
    
     public String inOrden(NodoArbolEstacionGeneral r){ 
        String Respusta="";
     if(r !=null){     
     Respusta+=inOrden(r.hijoIzquierdo);     
     Respusta+=" id: " +r.idEstacionGeneral + " Nombre: "+ r.nombre + " Contraseña: " + r.contrasena + "\n";
     System.out.print(Respusta);
     Respusta+=inOrden(r.hijoDerecho);
     
     }
     return Respusta;
     }
     
     //metodo para recorrer el arbol preOrden
     public void preOrden(NodoArbolEstacionGeneral r){     
     if(r !=null){    
     System.out.println(" id: " +r.idEstacionGeneral + " Nombre: "+ r.nombre + " Contraseña: " + r.contrasena);    
     preOrden(r.hijoIzquierdo);  
     preOrden(r.hijoDerecho);
     }     
     }
     // metodo para recorrer el arbol posOrden
     public void posOrden(NodoArbolEstacionGeneral r){     
     if(r !=null){            
     preOrden(r.hijoIzquierdo);  
     preOrden(r.hijoDerecho);
     System.out.println(" id: " +r.idEstacionGeneral + " Nombre: "+ r.nombre + " Contraseña: " + r.contrasena); 
     }     
     }
     // verificar un nodo
    public boolean Miembro(int Codau, NodoArbolEstacionGeneral R){
		NodoArbolEstacionGeneral Aux = R;
		boolean miembro = false;
		while (Aux != null){
			if (Codau==Aux.idEstacionGeneral){
				miembro = true;
				Aux = null;
			}
			else{
				if (Codau>Aux.idEstacionGeneral)
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
     
         NodoArbolEstacionGeneral auxiliar = raiz;
         NodoArbolEstacionGeneral padre = raiz;
         boolean esHijoIzq = true;
         while(auxiliar.idEstacionGeneral != d){
           padre = auxiliar;
           
           if(d<auxiliar.idEstacionGeneral){
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
         
             NodoArbolEstacionGeneral reemplazo=obtenerNodoReemplazo(auxiliar);
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
     
     public NodoArbolEstacionGeneral obtenerNodoReemplazo(NodoArbolEstacionGeneral nodoreemp){
     
      NodoArbolEstacionGeneral reemplazarPadre=nodoreemp;
      NodoArbolEstacionGeneral reemplazo = nodoreemp;
      NodoArbolEstacionGeneral auxiliar = nodoreemp.hijoDerecho;
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
     public NodoArbolEstacionGeneral modificar_contrasena(int id, String nombrenuevo, String ContrasenaNueva){
        NodoArbolEstacionGeneral nodo = buscar(id, raiz);
        
         if(nodo != null){
         nodo.nombre = nombrenuevo;
         nodo.contrasena = ContrasenaNueva;
             
         }
         return nodo;
      
     }
}
