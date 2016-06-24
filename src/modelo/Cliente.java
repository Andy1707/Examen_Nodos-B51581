package modelo;

/**
 *
 * @author Lanfor
 */
public class Cliente 
{
    String cedula, nombre, fecha, prioridad;
    int edad;

    public Cliente(String cedula, String nombre, int edad, String prioridad, String fecha) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.prioridad = prioridad;
        this.edad = edad;
        this.fecha=fecha;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
   
    public String getInformacion()
    {
        return "Nombre: "+nombre+"\nCádula: "+cedula+"\nEdad: "+edad+"\nFecha "+fecha+"\nPrioridad: "+prioridad;
    }
    
}
