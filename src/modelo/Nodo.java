/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Lanfor
 */
public class Nodo {
    Cliente dato;
    Nodo enlace;

    public Nodo(Cliente x) 
    {
        this.dato = x;
        enlace=null;
    }

    public Cliente getDato() 
    {
        return dato;
    }

    public void setDato(Cliente dato) {
        this.dato = dato;
    }


    public Nodo getEnlace() 
    {
        return enlace;
    }

    public void setEnlace(Nodo enlace) 
    {
        this.enlace = enlace;
    }
    
    
}
