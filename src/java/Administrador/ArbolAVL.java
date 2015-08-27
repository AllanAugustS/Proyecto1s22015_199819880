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
    public static ArbolAVL arbolito = new ArbolAVL();
     public NodoArbolAVL raiz;
    public ArbolAVL(){
    
    raiz = null;
    
    }
    
    public NodoArbolAVL obtenerRaiz(){
     return raiz;
    
    }
    //buscar un nodo
    public NodoArbolAVL buscar(int d, NodoArbolAVL r){
    
    if(raiz==null){
        return r;
    }else if(r.dato == d){
        return r;   
    }else if(r.dato<d){      
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
     public NodoArbolAVL insertarAVL(NodoArbolAVL nuevo, NodoArbolAVL subAr){
     
      NodoArbolAVL nuevoPadre = subAr;
      if(nuevo.dato<subAr.dato){
         if(subAr.hijoIzquierdo == null){
            subAr.hijoIzquierdo = nuevo;
         }else{
            subAr.hijoIzquierdo = insertarAVL(nuevo, subAr.hijoIzquierdo);
            if((obtenerFE(subAr.hijoIzquierdo)- obtenerFE(subAr.hijoDerecho)== 2)){
            
               if(nuevo.dato<subAr.hijoIzquierdo.dato){
               
                   nuevoPadre = rotacionIzquierda(subAr);
               }else{
                   nuevoPadre = rotacionDobleIzquierda(subAr);
               }
            }
         }
      
      }else if(nuevo.dato>subAr.dato){
          if(subAr.hijoDerecho == null){
          
             subAr.hijoDerecho = nuevo;
          }else{
             subAr.hijoDerecho = insertarAVL(nuevo, subAr.hijoDerecho);
             if((obtenerFE(subAr.hijoDerecho)-obtenerFE(subAr.hijoIzquierdo)==2)){
               if(nuevo.dato>subAr.hijoDerecho.dato){
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
     NodoArbolAVL nuevo = new NodoArbolAVL(d,n,co);
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
    
     public String inOrden(NodoArbolAVL r){ 
        String Respusta="";
     if(r !=null){     
     Respusta+=inOrden(r.hijoIzquierdo);     
     Respusta+=" id: " +r.dato + " Correo: "+ r.correo + " Contraseña: " + r.contrasena + "\n";
     System.out.print(Respusta);
     Respusta+=inOrden(r.hijoDerecho);
     
     }
     return Respusta;
     }
     
     //metodo para recorrer el arbol preOrden
     public void preOrden(NodoArbolAVL r){     
     if(r !=null){    
     System.out.println(" id: " +r.dato + " Correo: "+ r.correo + " Contraseña: " + r.contrasena);    
     preOrden(r.hijoIzquierdo);  
     preOrden(r.hijoDerecho);
     }     
     }
     // metodo para recorrer el arbol posOrden
     public void posOrden(NodoArbolAVL r){     
     if(r !=null){            
     preOrden(r.hijoIzquierdo);  
     preOrden(r.hijoDerecho);
     System.out.println(" id: " +r.dato + " Correo: "+ r.correo + " Contraseña: " + r.contrasena); 
     }     
     }
}
