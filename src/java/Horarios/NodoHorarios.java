/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Horarios;

import java.util.Date;

/**
 *
 * @author allan
 */
public class NodoHorarios {
    
    String ruta, horarioInicio, horarioFinal;
    String fecha;
    int idBus,idChofer;
    NodoHorarios anterior;
    NodoHorarios siguiente;

    public NodoHorarios(String ruta, String horarioInicio, String horarioFinal, String fecha, int idBus, int idChofer) {
        this.ruta = ruta;
        this.horarioInicio = horarioInicio;
        this.horarioFinal = horarioFinal;
        this.fecha = fecha;
        this.idBus = idBus;
        this.idChofer = idChofer;
        this.siguiente=null;
        this.anterior=null;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(String horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public String getHorarioFinal() {
        return horarioFinal;
    }

    public void setHorarioFinal(String horarioFinal) {
        this.horarioFinal = horarioFinal;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    

    public int getIdBus() {
        return idBus;
    }

    public void setIdBus(int idBus) {
        this.idBus = idBus;
    }

    public int getIdChofer() {
        return idChofer;
    }

    public void setIdChofer(int idChofer) {
        this.idChofer = idChofer;
    }

    public NodoHorarios getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoHorarios anterior) {
        this.anterior = anterior;
    }

    public NodoHorarios getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoHorarios siguiente) {
        this.siguiente = siguiente;
    }

   

    
}
