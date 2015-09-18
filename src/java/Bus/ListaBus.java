/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bus;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author allan
 */
public class ListaBus {
    
     NodoBus Cabeza;
    NodoBus Fin;
    static int cantidad;
 public static ListaBus listabuses = new ListaBus();
    public ListaBus() {
    cantidad=0;
    Cabeza = null;
    Fin = null; 
        
    }
    public int size() {
        return cantidad;
    }
    
    // metodo para indicar que la lista esta vacia
    
    private boolean EstaVacia(){
    
    boolean vacia = false;
    if(Cabeza == null){
    
    vacia = true;
    }
    return vacia;
         
    }
    //fin de metodo estavacia
    // metodo enlaza los dos nodos mediante enlace doble
    
    private void enlazar(NodoBus nodoA, NodoBus nodoB){
    
        nodoA.siguiente = nodoB;
        nodoB.anterior= nodoA;
    
    }
    //fin de metodo enlazar  
    
    //metodo insertar al final de la lista
    
    public String insertarFinal(int id){
    String Respuesta="";
    try{
    NodoBus nuevo = new NodoBus(id);
    if(EstaVacia()){
    Cabeza = nuevo;
    Fin = nuevo;
    Respuesta= "Se ingreso correctamente  el Bus";
    }else{
    
    enlazar(Fin, nuevo);
    Fin = nuevo;
    Respuesta= "Se ingreso correctamente  el Bus";
    }
    }catch(Exception e){
    Respuesta= "No se ingreso correctamente  el Bus";
    }
    cantidad++;
    return Respuesta;
    }
    //fin de metodo insertar al final de la lista
   // metodo para eliminar al frente o al inicio de la lista
    
    public void EliminarInicio(){
    
        if(!EstaVacia()){
        
        NodoBus primero = Cabeza.siguiente;
        if(primero == null){
        Cabeza=null;
        Fin = null;
        }else{
        
        primero.anterior= null;
        Cabeza = primero;
        }
        }
    
    }
    //fin de metodo eliminar al inicio de la lista
    //metodo eliminar al final de la lista
    public void EliminarFinal(){
    if(!EstaVacia()){
    NodoBus ultimo = Fin.anterior;
    if(ultimo == null){
    Cabeza= null;
    Fin = null;
    }else{
    ultimo.siguiente= null;
    Fin = ultimo;
    }
    }
    }
    //fin de metodo elimianr al final de la lista
    //metodo buscar, devuelve una referencia al nodo buscado sino se encuentra devuelve null
    public NodoBus Buscar(int id){
    
        NodoBus buscado = null;
        NodoBus iterador = Cabeza;
        while (buscado == null & iterador != null){
        if(iterador.idBus == id){
        buscado= iterador;
        }
        iterador = iterador.siguiente;
        }
    return buscado;
    }
    //fin de metodo buscar
    //metodo para mostrar la lista
    
    public String mostrar(){
    String respuesta="";
    NodoBus iterador = Cabeza;
    while(iterador != null){
    respuesta+="Id Bus: " + iterador.idBus +"\n";
    iterador = iterador.siguiente;
    } 
    return respuesta;
    }
    //fin metodo mostrar lista
    // metodo mostrar ordenado por burbuja 
   public String ordenaBurbuja(){
        NodoBus iterador = Cabeza;
        NodoBus iterador2= Cabeza;
        while(iterador.anterior !=null){
             iterador = iterador.anterior;
        }
        NodoBus s = null;
        NodoBus p = null;
        int temporal1;
        int burbuja= 1;
        while(burbuja!=0){
        burbuja=0;
        p=iterador;
          while(p!=null){
           s=p;
           p=p.siguiente;
           if(p!= null){
            if(s.idBus>p.idBus){
               temporal1 = p.idBus;
               p.idBus=s.idBus;
               s.idBus=temporal1;
               burbuja++;
            }
           }
          
          }
        }
    
     String respuesta="";
   
    while(iterador2 != null){
    respuesta+="Id Bus: " + iterador2.idBus +"\n";
    iterador2 = iterador2.siguiente;
    } 
    return respuesta;
    }
    //fin de metodo mostrar ordenado burbuja
    //metodo eliminar nodo
    public void eliminar(int id){
    
    if(this.Cabeza.getIdBus()==id){
        
        Cabeza= Cabeza.getSiguiente();
    }else{
    NodoBus aux = this.Cabeza;
    while(aux!=null && aux.getSiguiente().getIdBus() != id){ // error de  posible comparacion
    aux = aux.getSiguiente();
    }
    if (aux.getSiguiente().getIdBus()== id){
    aux.setSiguiente(aux.getSiguiente().getSiguiente());
    
    
    }
    }
    }
    //fin de metodo eliminarnodo
    public void modificar(int parametro,int nom){
        
        if(this.Cabeza.getIdBus()==parametro){       
            int bus1 = this.Cabeza.getIdBus();           
            if(nom != 0){//posible error de comparacion
            bus1 =nom;
            }
            Cabeza.setIdBus(bus1);
        }else{
        NodoBus aux = this.Cabeza;
        while(aux !=null && aux.getIdBus()!=parametro){ //posiboe error de comparacion
        aux = aux.getSiguiente();
        }
         if(aux.getIdBus() == parametro){
         int bus1= aux.getIdBus();
           if(nom != 0){//posible error de comparacion
           bus1= nom;
           }
           aux.setIdBus(bus1);
         }  
        }
    }
    //fin de metodo modificar
    //metodo get para recorrer mi lista
    public NodoBus get(int pIndex){
        NodoBus frst = null;
        NodoBus next = null; 
        NodoBus Last = null;
        NodoBus cmdin = Cabeza;
        
        if(pIndex==0){
            Last=Cabeza;
        }else if(pIndex ==(cantidad-1)){
            Last = Fin;
        }else if(pIndex > 0){                     
            for(int i = 1; i<=(cantidad-1);i++){
                next = cmdin.getSiguiente();            
                cmdin= next;
                if(i==pIndex){
                    Last = cmdin;
//                    if(cmdin.getSiguiente() == null){
//                        Last = cmdin.getAnterior();                    
//                    }else {
//                        Last = cmdin;
//                    }
                }          
            }
        }
        return Last;
    }
    //termina el metodo get para recorrer
     public void Dibujar(){
    
    String Source="digraph G {\n rankdir=LR;node [shape = record, style=rounded];\n";
    Source = Source+this.Generar();
    FileWriter archivoDot = null;
    PrintWriter escritor = null;
    try{
    
    archivoDot=new FileWriter("SalidaListaBus.dot");//poner imagen para lista
    escritor = new PrintWriter(archivoDot);
    escritor.println(Source);
    }catch(IOException e){
     e.printStackTrace();
    
    }finally{
        try{
            if(archivoDot!=null){
            archivoDot.close();
            }
        }catch(Exception ex){
           ex.printStackTrace();
        }
    }
    
    }
    
    public void GenerarPNG(){
    
        try{
            String doPath="C:\\Program Files\\Graphviz2.38\\bin\\dot.exe";
            String archivoDot="C:\\Users\\allan\\Documents\\NetBeansProjects\\Practica1s22015_199819880\\Salida.dot";
            String archivoPNG="C:\\Users\\allan\\Documents\\NetBeansProjects\\Practica1s22015_199819880\\reporte.png";
            String tParam="-Tpng";
            String oParam="-o";
            
            String[] command= new String[5];
            command[0]=doPath;
            command[1]=tParam;
            command[2]=archivoDot;
            command[3]=oParam;
            command[4]=archivoPNG;
            
            Runtime runtime = Runtime.getRuntime();
            runtime.exec(command);
        }catch(Exception e){
        e.printStackTrace();
        }finally{
        }
    
    }
    
    public String Generar(){
    
        String r="";
        String enlaces="";
        int cont=0;
        if(!EstaVacia()){
        NodoBus temporal = Cabeza;
        while(temporal!=null){
           r=r+"struct"+cont+" [label=\"<f0>IdBus: "+temporal.idBus + "\"];\n";
           cont++;
           temporal = temporal.getSiguiente();
        }
        for(int i=0;i<cont-1;i++){
          enlaces = enlaces+"struct"+i+":f1->struct"+(i+1)+":f0;\n";
        }
        
        }
    r=r+enlaces+"}";
    return r;
    }
}
