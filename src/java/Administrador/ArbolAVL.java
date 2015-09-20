package Administrador;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author allan
 */
public class ArbolAVL {
    public static ArbolAVL listaadmin = new ArbolAVL();
    private NodoArbolAVL raiz;
    public ArbolAVL(){
    
    raiz = null;
    
    }
    
    public NodoArbolAVL obtenerRaiz(){
     return raiz;
    
    }
    //buscar un nodo
    public NodoArbolAVL buscar(String d, NodoArbolAVL r){
    
    if(raiz==null){
        return null;
    }else if(r.correo == d){
        return r;   
    }else if(r.correo.charAt(pos)<d.charAt(pos)){  //nuevo.correo.charAt(pos)<subAr.hijoIzquierdo.correo.charAt(pos)    
        return buscar(d,r.hijoDerecho);    
    }else{
        return buscar(d, r.hijoIzquierdo);
    }    
    }
    // metodo obtener factor de equilibrio
    
    public int obtenerFE(NodoArbolAVL x){
    
    if(x==null){
        return -1;
    }else{    
        return x.fe;
    }   
   }
    //rotacion simple izquierda
    
    public NodoArbolAVL rotacionIzquierda(NodoArbolAVL c){
        NodoArbolAVL aux= c.hijoIzquierdo;
        c.hijoIzquierdo= aux.hijoDerecho;
        aux.hijoDerecho= c;
        c.fe =Math.max(obtenerFE(c.hijoIzquierdo),obtenerFE(c.hijoDerecho))+1;
        aux.fe=Math.max(obtenerFE(aux.hijoIzquierdo),obtenerFE(aux.hijoDerecho))+1;
        
        return aux;    
    }
    // rotacion simple derecha
    public NodoArbolAVL rotacionDerecha(NodoArbolAVL c){
        NodoArbolAVL aux= c.hijoDerecho;
        c.hijoDerecho= aux.hijoIzquierdo;
        aux.hijoIzquierdo= c;
        c.fe =Math.max(obtenerFE(c.hijoIzquierdo),obtenerFE(c.hijoDerecho))+1;
        aux.fe=Math.max(obtenerFE(aux.hijoIzquierdo),obtenerFE(aux.hijoDerecho))+1;
        
        return aux;    
    }
    // rotacion doble a la izquierda
    
    public NodoArbolAVL rotacionDobleIzquierda(NodoArbolAVL c){
    
    NodoArbolAVL temporal;
    c.hijoIzquierdo = rotacionDerecha(c.hijoIzquierdo);
    temporal = rotacionIzquierda(c);
    return temporal;
    
    }
    
    // rotacion doble a la derecha
    
     public NodoArbolAVL rotacionDobleDerecha(NodoArbolAVL c){
    
    NodoArbolAVL temporal;
    c.hijoDerecho = rotacionIzquierda(c.hijoDerecho);
    temporal = rotacionDerecha(c);
    return temporal;
    
    }
     //metodo para insertar AVL
     int pos=0;
     public NodoArbolAVL insertarAVL(NodoArbolAVL nuevo, NodoArbolAVL subAr){
     
      NodoArbolAVL nuevoPadre = subAr;
        if(nuevo.correo.equals(subAr.correo)){
                System.out.print("nodo duplicado\n");
        }else if(nuevo.correo.length()==subAr.correo.length()){
            if(nuevo.correo.charAt(pos)<subAr.correo.charAt(pos)){                  
                if(subAr.hijoIzquierdo==null){                                            
                    subAr.hijoIzquierdo=nuevo;  
                }else{                                                              
                    subAr.hijoIzquierdo=insertarAVL(nuevo,subAr.hijoIzquierdo);
                    if(obtenerFE(subAr.hijoIzquierdo)-obtenerFE(subAr.hijoDerecho)==2){
                        try{
                        if(nuevo.correo.charAt(pos)<subAr.hijoIzquierdo.correo.charAt(pos))
                            nuevoPadre=rotacionIzquierda(subAr);
                        }catch(Exception e){
                            nuevoPadre=rotacionDobleIzquierda(subAr);
                        }
                    }
                }
            }else if(nuevo.correo.charAt(pos)>subAr.correo.charAt(pos)){
                if(subAr.hijoDerecho==null){
                    subAr.hijoDerecho=nuevo;
                }else{
                    subAr.hijoDerecho=insertarAVL(nuevo,subAr.hijoDerecho);
                    if(obtenerFE(subAr.hijoDerecho)-obtenerFE(subAr.hijoIzquierdo)==2){
                        try{
                            if(nuevo.correo.charAt(pos)>subAr.hijoDerecho.correo.charAt(pos))
                                nuevoPadre=rotacionDerecha(subAr);
                        }catch(Exception e){
                            nuevoPadre=rotacionDobleDerecha(subAr);
                        }

                    }
                }
            }else{
                pos++;
                nuevoPadre=insertarAVL(nuevo, subAr);
            }
        }else if(nuevo.correo.length()<subAr.correo.length()){                  //el nuevo es mas corto que el guardado
            if(nuevo.correo.length()>pos){                                      //puede que sea mas grande que la pos
                if(nuevo.correo.charAt(pos)<subAr.correo.charAt(pos)){                  
                    if(subAr.hijoIzquierdo==null){                                            
                        subAr.hijoIzquierdo=nuevo;                                            
                    }else{                                                              
                        subAr.hijoIzquierdo=insertarAVL(nuevo,subAr.hijoIzquierdo);
                        if(obtenerFE(subAr.hijoIzquierdo)-obtenerFE(subAr.hijoDerecho)==2){
                            try{
                                if(nuevo.correo.charAt(pos)<subAr.hijoIzquierdo.correo.charAt(pos)){
                                    nuevoPadre=rotacionIzquierda(subAr);
                                }
                            }catch(Exception e)
                                {
                                nuevoPadre=rotacionDobleIzquierda(subAr);
                            }
                        }
                    }
                }else if(nuevo.correo.charAt(pos)>subAr.correo.charAt(pos)){
                    if(subAr.hijoDerecho==null){
                        subAr.hijoDerecho=nuevo;
                    }else{
                        subAr.hijoDerecho=insertarAVL(nuevo,subAr.hijoDerecho);
                        if(obtenerFE(subAr.hijoDerecho)-obtenerFE(subAr.hijoIzquierdo)==2){
                            try{
                                if(nuevo.correo.charAt(pos)>subAr.hijoDerecho.correo.charAt(pos))
                                    nuevoPadre=rotacionDerecha(subAr);
                            }catch(Exception e){
                                nuevoPadre=rotacionDobleDerecha(subAr);
                            }

                        }
                    }
                }else if(nuevo.correo==subAr.correo){
                    System.out.print("nodo duplicado\n");
                }else{
                    pos++;
                    nuevoPadre=insertarAVL(nuevo, subAr);
                }
            }else{                                             //no solo es el mas pequeño, sino el mas corto
                if(subAr.hijoIzquierdo==null){
                    subAr.hijoIzquierdo=nuevo;
                }else{
                    subAr.hijoIzquierdo=insertarAVL(nuevo,subAr.hijoIzquierdo);
                    if(obtenerFE(subAr.hijoIzquierdo)-obtenerFE(subAr.hijoDerecho)==2){
                        if(pos<subAr.correo.length()){
                            try{
                                if(nuevo.correo.charAt(pos)<subAr.hijoIzquierdo.correo.charAt(pos))
                                    nuevoPadre=rotacionIzquierda(subAr);
                            }catch(Exception e){
                                nuevoPadre=rotacionDobleIzquierda(subAr);
                            }
                        }else{
                            
                        }
                    }
                }
            }
        }else{
            if(subAr.correo.length()>pos){                                      //puede que sea mas grande que la pos
                if(nuevo.correo.charAt(pos)<subAr.correo.charAt(pos)){                  
                    if(subAr.hijoIzquierdo==null){                                            
                        subAr.hijoIzquierdo=nuevo;                                            
                    }else{                                                              
                        subAr.hijoIzquierdo=insertarAVL(nuevo,subAr.hijoIzquierdo);
                        if(obtenerFE(subAr.hijoIzquierdo)-obtenerFE(subAr.hijoDerecho)==2){
                            try{
                                if(nuevo.correo.charAt(pos)<subAr.hijoIzquierdo.correo.charAt(pos))
                                    nuevoPadre=rotacionIzquierda(subAr);
                            }catch(Exception e){
                                nuevoPadre=rotacionDobleIzquierda(subAr);
                            }
                        }
                    }
                }else if(nuevo.correo.charAt(pos)>subAr.correo.charAt(pos)){
                    if(subAr.hijoDerecho==null){
                        subAr.hijoDerecho=nuevo;
                    }else{
                        subAr.hijoDerecho=insertarAVL(nuevo,subAr.hijoDerecho);
                        if(obtenerFE(subAr.hijoDerecho)-obtenerFE(subAr.hijoIzquierdo)==2){
                            try{
                            if(nuevo.correo.charAt(pos)>subAr.hijoDerecho.correo.charAt(pos))
                                nuevoPadre=rotacionDerecha(subAr);
                            }catch(Exception e){
                                nuevoPadre=rotacionDobleDerecha(subAr);
                            }

                        }
                    }
                }else if(nuevo.correo==subAr.correo){
                    System.out.print("nodo duplicado\n");
                }else{
                    pos++;
                    nuevoPadre=insertarAVL(nuevo, subAr);
                }
            }else{                                             //no solo es el mas pequeño, sino el mas corto
                if(subAr.hijoDerecho==null){
                    subAr.hijoDerecho=nuevo;
                }else{
                    subAr.hijoDerecho=insertarAVL(nuevo,subAr.hijoDerecho);
                    if(obtenerFE(subAr.hijoDerecho)-obtenerFE(subAr.hijoIzquierdo)==2){
                        try{
                            if(nuevo.correo.charAt(pos)>subAr.hijoDerecho.correo.charAt(pos))
                                nuevoPadre=rotacionDerecha(subAr);
                        }catch(Exception e){
                            nuevoPadre=rotacionDobleDerecha(subAr);
                        }
                    }
                }
            }
        }
        //actualizando la altura
        if((subAr.hijoIzquierdo==null)&&(subAr.hijoDerecho!=null)){
            subAr.fe=subAr.hijoDerecho.fe+1;
        }else if((subAr.hijoDerecho==null)&&(subAr.hijoIzquierdo!=null)){
            subAr.fe=subAr.hijoIzquierdo.fe+1;
        }else{
            subAr.fe=Math.max(obtenerFE(subAr.hijoDerecho),obtenerFE(subAr.hijoIzquierdo))+1;
        }return nuevoPadre;
   }
     
     //metodo insertar
     
     public String insertar( String n, String co){
     String Respuesta="";
     try{
     NodoArbolAVL nuevo = new NodoArbolAVL(n,co);
     if(raiz == null){
       raiz = nuevo;
       Respuesta ="Se registro Correctamente el Administrador";
     }else{
     
       raiz = insertarAVL(nuevo, raiz);
      Respuesta ="Se registro Correctamente el Administrador";
     }
     }catch(Exception e){
     Respuesta="No se registro elAdministrador";
     }
     return Respuesta;
     }
     //recorridos
     //metodo para recorrer el  arbol inOrden
     public String inOrden(NodoArbolAVL r){     
     String Respuesta="";
     if(r !=null){     
     Respuesta+= inOrden(r.hijoIzquierdo);     
     Respuesta+= " Correo: "+ r.correo + " Contraseña: " + r.contrasena + "\n";
     Respuesta+=inOrden(r.hijoDerecho);
     } 
     return Respuesta;
     }
     //metodo para recorrer el arbol preOrden
     public void preOrden(NodoArbolAVL r){     
     if(r !=null){    
     System.out.println(" Correo: "+ r.correo + " Contraseña: " + r.contrasena);    
     preOrden(r.hijoIzquierdo);  
     preOrden(r.hijoDerecho);
     }     
     }
     // metodo para recorrer el arbol posOrden
     public void posOrden(NodoArbolAVL r){     
     if(r !=null){            
     preOrden(r.hijoIzquierdo);  
     preOrden(r.hijoDerecho);
     System.out.println(" Correo: "+ r.correo + " Contraseña: " + r.contrasena); 
     }     
     }
     
   // metodo eliminar un nodo
     
     public boolean eliminar(String d){
     
         NodoArbolAVL auxiliar = raiz;
         NodoArbolAVL padre = raiz;
         boolean esHijoIzq = true;
         while(auxiliar.correo != d){
           padre = auxiliar;
           
           if(d.charAt(pos)<auxiliar.correo.charAt(pos)){
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
         
             NodoArbolAVL reemplazo=obtenerNodoReemplazo(auxiliar);
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
     
     public NodoArbolAVL obtenerNodoReemplazo(NodoArbolAVL nodoreemp){
     
      NodoArbolAVL reemplazarPadre=nodoreemp;
      NodoArbolAVL reemplazo = nodoreemp;
      NodoArbolAVL auxiliar = nodoreemp.hijoDerecho;
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
     public NodoArbolAVL modificar_contrasena(String correo, String ContrasenaNueva){
        NodoArbolAVL nodo =buscar(correo, raiz);
        
         if(nodo != null){
         
         nodo.contrasena = ContrasenaNueva;
            
         }
         return nodo;
      
     }
     public boolean Miembro(String correo, NodoArbolAVL R){	
         NodoArbolAVL Aux = R;
         if(Aux==null){
        listaadmin.insertar("admin","admin@hotmail.com");
          
         }
		
		while (Aux != null){
			if (correo.charAt(pos)==Aux.correo.charAt(pos) ){
				return true;
			
			}
			else{
				if (correo.charAt(pos)>Aux.correo.charAt(pos) )
					Aux = Aux.hijoDerecho;
				else{
					Aux = Aux.hijoIzquierdo;
					
						
				}
			}
		}
		return false;
	}

     //agregale el get y set de raiz
     //aqu simon

    public NodoArbolAVL getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArbolAVL raiz) {
        this.raiz = raiz;
    }
 
}
