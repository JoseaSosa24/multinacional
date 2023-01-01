
package multinacional;


public class Persona {
    private int ident;
    private String nombre;
    private String apellido;
    private String direccion;
    private int telefono;
    private int celular;
    
    public Persona(){
        
    }
    
    public Persona(int id, String nom, String ape, String dir, int tel, int cel){
        ident = id;
        nombre = nom;
        apellido = ape;
        direccion = dir;
        telefono = tel;
        celular = cel;
    }

    public int getIdent() {
        return ident;
    }

    public void setIdent(int ident) {
        this.ident = ident;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }


    @Override
    public String toString() 
    {
       
       String mensaje= "EMPLEADO [" + "Identificación: " + ident + ", Nombre: " + nombre + ", Apellido: " + apellido + ", Direccion: " + direccion + ", Telefono: " + telefono + ", Celular: " + celular + ']';
      
       return mensaje;
    }
    
    
    public String toString2() 
    {
       
         String mensaje="CLIENTE [" + "Identificación: " + ident + ", Nombre: " + nombre + ", Apellido: " + apellido + ", Direccion: " + direccion + ", Telefono: " + telefono + ", Celular: " + celular + ']'; 
         
         return mensaje;
    }
}