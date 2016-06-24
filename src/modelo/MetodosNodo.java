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
public class MetodosNodo
{
    Lista array;
    int pos;
    String arregloInformacionConsultada[]=new String[5];
    public  MetodosNodo()
    {
        array=new Lista();
    }
    
    public void agregarCliente(Cliente objeto)
    {
        array.add(objeto);
        System.out.println(objeto.getInformacion());
        
    }
    
    public void agregarPrimerCliente(Cliente objeto)
    {
        array.addFirst(objeto);
        System.out.println(objeto.getInformacion());
    }
    public boolean consultar(String cedula)
    {
        boolean existe=false;
        
        for (int i = 0; i < array.size(); i++) 
        {
            if(array.get(i).getCedula().equalsIgnoreCase(cedula))
            {
                existe=true;
                pos=i;
            }
        }
        return existe;
    }
    
    public void modificar(String[] info)
    {
        array.get(pos).setNombre(info[1]);
        array.get(pos).setPrioridad(info[2]);
        array.get(pos).setEdad(Integer.parseInt(info[3]));
        array.get(pos).setFecha(info[4]);
    }
    public Cliente getPrimero()
    {
        return array.get(0);
    }
    
    public void eliminar()
    {
        array.remove(pos);
    }
    public  String[] getArregloInfoConsultada()
    {
        return arregloInformacionConsultada;
    }
    public void eliminarAtendido()
    {
        array.remove(0);
    }
    
    public int size()
    {
       return array.size();
    }

    public void ordenarMayorAMenor()
    {
        int cantidadNodos=array.size();
        Cliente datoTemporal;
        Nodo auxiliar=array.primero;
        for(int contador=0;contador<cantidadNodos;contador++)
        {
            auxiliar=array.primero;
            while(auxiliar.enlace!=null)
            {
                if(auxiliar.dato.getEdad()<auxiliar.enlace.dato.getEdad())
                {
                    datoTemporal=auxiliar.dato;
                    auxiliar.dato=auxiliar.enlace.dato;
                    auxiliar.enlace.dato=datoTemporal;
                }
                auxiliar=auxiliar.enlace;
            }
        }
    }
    public void ordenarMenorAMayor()
    {
        int cantidadNodos=array.size();
        Cliente datoTemporal;
        Nodo auxiliar=array.primero;
        for(int contador=0;contador<cantidadNodos;contador++)
        {
            auxiliar=array.primero;
            while(auxiliar.enlace!=null)
            {
                if(auxiliar.dato.getEdad()>auxiliar.enlace.dato.getEdad())
                {
                    datoTemporal=auxiliar.dato;
                    auxiliar.dato=auxiliar.enlace.dato;
                    auxiliar.enlace.dato=datoTemporal;
                }
                auxiliar=auxiliar.enlace;
            }
        }
    }
    //Tenga Cuidado Ojo Lo ven porque la caga
    public int getPromedioEdad()
    {
        int promedio=0;
        for (int i = 0; i < array.size(); i++) 
        {
            promedio+=getCliente(i).getEdad();
        }
        promedio=promedio/tamano();
        
        return promedio;
        
    }
    public int tamano()
    {
        return array.size();
    }
    public String consultaGeneral()
    {
        String msj = "";
        for (int i = 0; i < array.size(); i++) 
        {
            msj+=array.get(i).getInformacion()+"\n\n";
        }
        
        return msj;
    }
    public Cliente getCliente(int posicion)
    {
        return array.get(posicion);
    }
}
