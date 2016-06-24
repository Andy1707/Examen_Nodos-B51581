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
public class Lista 
{
    protected Nodo primero, cola;
    Nodo nuevo;
    int tamano;  // ---------De YouTube------------
    public Lista() 
    {
        this.primero = null;
        tamano=0; //---------De YouTube------------
    }
    
    public void add(Cliente x)
    {
        nuevo=new Nodo(x);
        
        Nodo temporal=primero;
        //[]]--> []]--> []]--> []]
        if(temporal==null)
        {
            primero=nuevo;
            cola=nuevo;
        }
        else
        {
            cola.setEnlace(nuevo);
            cola=nuevo;
        }
        
        tamano++;   // ---------De YouTube------------
    }
    
    public void visualizar()
    {
        Nodo n;
        int k=0;
        n=primero;
        
        while(n !=null)
        {
            System.out.println(n.dato+" ");
            n=n.enlace;
            k++;
            System.out.println((k % 15 != 0 ? " " : "\n" ));
        }
    }
    
    
    public int size()
    {
     //---------De YouTube------------//
        return tamano;
    }

    
    public void remove(int posicion)
    {
        Nodo temporal=primero;
        //[]]--> []]--> []]--> []]--> []]
        // i=0
        for (int i = 0; i < tamano; i++) 
        {
            if (i==posicion-1)
            {
                temporal.setEnlace(temporal.getEnlace().getEnlace());
                temporal.getEnlace().setEnlace(null);
                System.out.println("Elimina");
                tamano--;
                break;
            }
            else if(posicion==0)
            {
                primero=temporal.getEnlace();
                temporal.setEnlace(null);
                System.out.println("Elimina");
                tamano--;
                break;
            }
            temporal=temporal.getEnlace();
        }
    }
    
    
    public Cliente get(int posicion)
    {
        Nodo temporal=primero;
        
        for (int i = 0; i < tamano; i++) 
        {
            if (i==posicion) 
                break;
            temporal=temporal.getEnlace();
        }
        return temporal.getDato();
    }
    
    public Nodo getNodo (int posicion)
    {
        Nodo temporal=primero;
        
        for (int i = 0; i < tamano; i++) 
        {
            if (i==posicion) 
                break;
            temporal=temporal.getEnlace();
        }
        return temporal;
    }
    
    public void addFirst(Cliente valor)
    {
        Nodo temporal=primero;
        Nodo nuevoElemento=new Nodo(valor);
        
        if(tamano==0)
        {
            primero=nuevoElemento;
            cola=nuevoElemento;
        }
        else
        {
            nuevoElemento.setEnlace(primero);
            primero=nuevoElemento;
        }
        tamano++;
    }
    
    public void set(int posicion, Nodo valor)
    {
        if(posicion<tamano)
        {
            Nodo temporal=primero;
            for (int i = 0; i < tamano; i++) 
            {
                if (i==posicion)
                {
                    if(posicion==0)
                    {
                        valor.enlace=temporal.enlace;
                        primero=valor;
                        temporal.enlace=null;
                    }
                    else    
                    {
                        valor.enlace=temporal.enlace;
                        Nodo aux=getNodo(i-1);
                        aux.enlace=valor;
                        temporal.enlace=null;
                    }
                    break;
                }
                temporal=temporal.getEnlace();
            }
        }
    }
    
//        if(posicion<tamano)
//        {
//            for (int i = 0; i < tamano; i++) 
//            {
//                if (i==posicion)
//                {
//                    //Este metodo va a funcionar cuando haya que colocar a una persona con una prioridad mayor
//                    //a los que ya estaban haciendo la cola
//                    //[21]]--> [4]]--> [23]]--> [24]]--> [100]
//                    if(posicion==0)
//                    {
//                        nuevoElemento.setEnlace(primero);
//                        primero=nuevoElemento;
//                    }
//                    else    
//                    {
//                        Nodo aux=getNodo(i-1);
//                        aux.enlace=nuevoElemento;
//                        nuevoElemento.enlace=temporal;
//                    }
//                    tamano++;
//                    break;
//                }
//                temporal=temporal.getEnlace();
//            }
//        }
//        else
//            throw  new Exception("Bounds Exception");
//   }
}
