package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Cliente;
import modelo.MetodosNodo;
import vista.FRM_DepartamentoMigracion;

public class Controlador_FRM_DepartamentoMigracion implements ActionListener
{
    MetodosNodo metodosNodo;
    FRM_DepartamentoMigracion frm_Migracion;
    
    public Controlador_FRM_DepartamentoMigracion(FRM_DepartamentoMigracion fRM_Migracion) 
    {
        metodosNodo=new MetodosNodo();
        this.frm_Migracion=fRM_Migracion;
    }

   
    public void actionPerformed(ActionEvent e)
    {
        System.out.println("tome");
        if(e.getActionCommand().equalsIgnoreCase("Registrar"))
        {
            
            String[] informacion = frm_Migracion.getInformacionCliente();
            Cliente cliente=new Cliente(informacion[0],informacion[1],Integer.parseInt(informacion[3].trim()), informacion[2],informacion[4]);
            
            if(informacion[2].equalsIgnoreCase("Normal"))
            {
               metodosNodo.agregarCliente(cliente);
               frm_Migracion.resetGUI();
            }
                
            else
            {
                metodosNodo.agregarPrimerCliente(cliente);
                frm_Migracion.resetGUI();
            }
                
            
            
        }
        
        if(e.getActionCommand().equalsIgnoreCase("Cancelar"))
        {
            
            
            if(metodosNodo.consultar(frm_Migracion.getInformacionCliente()[0]))
            {
                metodosNodo.eliminar();
               
            }
            else
            {
                frm_Migracion.mensaje("el cliente no se encuentra registrado");
            }
                
            frm_Migracion.resetGUI();
        }
        
        
        
        
        
        
        if(e.getActionCommand().equalsIgnoreCase("Modificar"))
        {
            
            if(metodosNodo.consultar(frm_Migracion.getInformacionCliente()[0]))
            {
                metodosNodo.modificar(frm_Migracion.getInformacionCliente());
                
            }
            else
            {
                frm_Migracion.mensaje("El cliente no se encuentra registrado");
            }
                
            frm_Migracion.resetGUI();
        }
        
        if(e.getActionCommand().equalsIgnoreCase("Limpiar"))
        {
            
            
           frm_Migracion.limpiarPizarraReportes();
        }
        
        if(e.getActionCommand().equals("Atendiendo"))
        {
            if(metodosNodo.size()>0)
            {
                frm_Migracion.mostrarEnPantalla(metodosNodo.getPrimero().getInformacion());
                metodosNodo.eliminarAtendido();
            }
            else
            {
                frm_Migracion.mostrarEnPantalla("No hay más Clientes en la Fila");
            }
                
        }
        
         if(e.getActionCommand().equals("<"))
        {
            
            String arreglo[] = new String[5];
            metodosNodo.ordenarMenorAMayor();
            frm_Migracion.limpiarTabla();
            
            for (int i = 0; i < metodosNodo.size(); i++)
            {
                arreglo[0] = metodosNodo.getCliente(i).getCedula();
                arreglo[1] = metodosNodo.getCliente(i).getNombre();
                arreglo[2] = metodosNodo.getCliente(i).getEdad()+"";
                arreglo[3] = metodosNodo.getCliente(i).getFecha();
                arreglo[4] = metodosNodo.getCliente(i).getPrioridad();
                frm_Migracion.colocarFilas(arreglo);
            }  
        }
         
        if(e.getActionCommand().equals(">"))
        {
            String arreglo[] = new String[5];
            metodosNodo.ordenarMayorAMenor();
            frm_Migracion.limpiarTabla();
            for (int i = 0; i < metodosNodo.size(); i++)
            {
                arreglo[0] = metodosNodo.getCliente(i).getCedula();
                arreglo[1] = metodosNodo.getCliente(i).getNombre();
                arreglo[2] = metodosNodo.getCliente(i).getEdad()+"";
                arreglo[3] = metodosNodo.getCliente(i).getFecha();
                arreglo[4] = metodosNodo.getCliente(i).getPrioridad();
                frm_Migracion.colocarFilas(arreglo);
            }    
            
            if(e.getActionCommand().equalsIgnoreCase("Reporte"))
            {
                System.out.println("tome");

                if(metodosNodo.tamano()>0)
                {
                    System.out.println("tome1");
                    
                    frm_Migracion.insertarCantidadPersonas(metodosNodo.tamano()+"");
                    frm_Migracion.insertarCantidadPersonas(metodosNodo.getPromedioEdad()+"");
                    frm_Migracion.mostarReporte(metodosNodo.consultaGeneral());
                }
                else
                {
                    System.out.println("tome Fallido");
                    frm_Migracion.mensaje("No hay clientes en la fila");
                }

            }

        }

    }
    
}
