/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Horarios;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 *
 * @author allan
 */
public class ListaHorarios {
    public static ListaHorarios listaasignaciones = new ListaHorarios();
    public NodoHorarios Cabeza;
    public NodoHorarios Fin;
    static int cantidad;

    public ListaHorarios() {
    cantidad=0;
    Cabeza = null;
    Fin = null; 
        
    }
    public int size() {
        return cantidad;
    }
    public NodoHorarios obtenerCabeza(){
     return Cabeza;
    
    }
    
    // metodo para indicar que la lista esta vacia
    
   public boolean EstaVacia(){
    
    boolean vacia = false;
    if(Cabeza == null){
    
    vacia = true;
    }
    return vacia;
         
    }
    //fin de metodo estavacia
    // metodo enlaza los dos nodos mediante enlace doble
    
    public void enlazar(NodoHorarios nodoA, NodoHorarios nodoB){
    
        nodoA.siguiente = nodoB;
        nodoB.anterior= nodoA;
    
    }
    //fin de metodo enlazar  
    
    //metodo insertar al final de la lista
    
    public String insertarFinal(String rut,String horaI,String horaF, String fec,int clavebus,int claveChofer){
    String Respuesta="";
    try{
    NodoHorarios nuevo = new NodoHorarios(rut,horaI,horaF,fec,clavebus,claveChofer);
    if(EstaVacia()){
    Cabeza = nuevo;
    Fin = nuevo;
    Respuesta= "Se asigno correctamente el bus";
    }else{
    
    enlazar(Fin, nuevo);
    Fin = nuevo;
    Respuesta= "Se asigno correctamente el bus";
    }
    }catch(Exception e){
    Respuesta= "No se asigno correctamente  el Bus";
    }
    cantidad++;
    return Respuesta;
    }
    //fin de metodo insertar al final de la lista
   // metodo para eliminar al frente o al inicio de la lista
    
    public void EliminarInicio(){
    
        if(!EstaVacia()){
        
        NodoHorarios primero = Cabeza.siguiente;
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
    NodoHorarios ultimo = Fin.anterior;
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
    public NodoHorarios Buscar(String fecha){
    
        NodoHorarios buscado = null;
        NodoHorarios iterador = Cabeza;
        while (buscado == null & iterador != null){
        if(iterador.fecha == fecha){
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
    NodoHorarios iterador = Cabeza;
    while(iterador != null){
    respuesta+= "Ruta: " + iterador.ruta + " Hora Inicial:" + iterador.horarioInicio + " Hora Final: " + iterador.horarioFinal + " Fecha: " + iterador.fecha + " id Bus: " + iterador.idBus + " id Chofer : " + iterador.idChofer + "\n";
    iterador = iterador.siguiente;
    }
    return respuesta;
    }
    //metodo ordenamiento de bus  por burbuja
    
//  
    public void eliminar(String fecha){
    
    if(this.Cabeza.fecha==fecha){
        
        Cabeza= Cabeza.getSiguiente();
    }else{
    NodoHorarios aux = this.Cabeza;
    while(aux!=null && aux.getSiguiente().fecha != fecha){ // error de  posible comparacion
    aux = aux.getSiguiente();
    }
    if (aux.getSiguiente().fecha== fecha){
    aux.setSiguiente(aux.getSiguiente().getSiguiente());
    
    
    }
    }
    }
    //fin de metodo eliminarnodo
    public void modificar(String parametro,String Fec){
        
        if(this.Cabeza.fecha==parametro){       
            String fecha1 = this.Cabeza.fecha;           
            if(Fec != null){
            fecha1 =Fec;
            }
            Cabeza.setFecha(fecha1);
        }else{
        NodoHorarios aux = this.Cabeza;
        while(aux !=null && aux.fecha!=parametro){ 
        aux = aux.getSiguiente();
        }
         if(aux.fecha == parametro){
         String fecha1= aux.fecha;
           if(Fec != null){//posible error de comparacion
           fecha1= Fec;
           }
           aux.setFecha(fecha1);
         }  
        }
    }
    //fin de metodo modificar
    //metodo get para recorrer la lista
    public NodoHorarios get(int pIndex){
        NodoHorarios frst = null;
        NodoHorarios next = null; 
        NodoHorarios Last = null;
        NodoHorarios cmdin = Cabeza;
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
                    if(cmdin.getSiguiente() == null){
                        Last = cmdin.getAnterior();
                    
                    }else {
                        Last = cmdin;
                    }
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
    
    archivoDot=new FileWriter("SalidaListaHorarios.dot");//poner imagen para lista
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
        NodoHorarios temporal = Cabeza;
        while(temporal!=null){
           r=r+"struct"+cont+" [label=\"<f0>Fecha: "+temporal.fecha + "\"];\n";
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
