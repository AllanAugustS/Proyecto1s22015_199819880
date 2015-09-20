/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ruta;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author allan
 */
public class ListaRuta {
    public static ListaRuta listadorutas = new ListaRuta();
    public NodoRuta Cabeza;
    public NodoRuta Fin;
    static int cantidad;

    public ListaRuta() {
    cantidad=0;
    Cabeza = null;
    Fin = null; 
        
    }
    public int getCantidad() {
        return cantidad;
    }
    public NodoRuta obtenerCabeza(){
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
    
    public void enlazar(NodoRuta nodoA, NodoRuta nodoB){
    
        nodoA.siguiente = nodoB;
        nodoB.anterior= nodoA;
    
    }
    //fin de metodo enlazar  
    
    //metodo insertar al final de la lista
    
    public String insertarFinal(String ruta){
    String Respuesta="";
    try{
    NodoRuta nuevo = new NodoRuta(ruta);
    if(EstaVacia()){
    Cabeza = nuevo;
    Fin = nuevo;
    Respuesta= "Se ingreso correctamente la ruta";
    }else{
    
    enlazar(Fin, nuevo);
    Fin = nuevo;
    Respuesta= "Se ingreso correctamente la ruta";
    }
    }catch(Exception e){
    Respuesta= "No se ingreso correctamente la ruta";
    }
    cantidad++;
    return Respuesta;
    }
    //fin de metodo insertar al final de la lista
   // metodo para eliminar al frente o al inicio de la lista
    
    public void EliminarInicio(){
    
        if(!EstaVacia()){
        
        NodoRuta primero = Cabeza.siguiente;
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
    NodoRuta ultimo = Fin.anterior;
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
    public NodoRuta Buscar(String ruta){
    
        NodoRuta buscado = null;
        NodoRuta iterador = Cabeza;
        while (buscado == null & iterador != null){
        if(iterador.ruta == ruta){
        buscado= iterador;
        }
        iterador = iterador.siguiente;
        }
    return buscado;
    }
    //fin de metodo buscar
    //metodo para mostrar la lista
    
    public void mostrar(){
    
    NodoRuta iterador = Cabeza;
    while(iterador != null){
    System.out.print(iterador.ruta +"\n");
    iterador = iterador.siguiente;
    }
    
    
    
    }
    //fin metodo mostrar lista
    //metodo eliminar nodo
    public void eliminar(String ruta){
    
    if(this.Cabeza.ruta==ruta){
        
        Cabeza= Cabeza.getSiguiente();
    }else{
    NodoRuta aux = this.Cabeza;
    while(aux!=null && aux.getSiguiente().ruta != ruta){ // error de  posible comparacion
    aux = aux.getSiguiente();
    }
    if (aux.getSiguiente().ruta== ruta){
    aux.setSiguiente(aux.getSiguiente().getSiguiente());
    
    
    }
    }
    }
    //fin de metodo eliminarnodo
    public void modificar(String parametro,String nom){
        
        if(this.Cabeza.ruta==parametro){       
            String ruta1 = this.Cabeza.ruta;           
            if(nom != null){
            ruta1 =nom;
            }
            Cabeza.setRuta(ruta1);
        }else{
        NodoRuta aux = this.Cabeza;
        while(aux !=null && aux.ruta!=parametro){ 
        aux = aux.getSiguiente();
        }
         if(aux.ruta == parametro){
         String ruta1= aux.ruta;
           if(nom != null){//posible error de comparacion
           ruta1= nom;
           }
           aux.setRuta(ruta1);
         }  
        }
    }
    //fin de metodo modificar
    
     public void Dibujar(){
    
    String Source="digraph G {\n rankdir=LR;node [shape = record, style=rounded];\n";
    Source = Source+this.Generar();
    FileWriter archivoDot = null;
    PrintWriter escritor = null;
    try{
    
    archivoDot=new FileWriter("SalidaListaRuta.dot");//poner imagen para lista
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
        NodoRuta temporal = Cabeza;
        while(temporal!=null){
           r=r+"struct"+cont+" [label=\"<f0>Ruta: "+temporal.ruta + "\"];\n";
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
