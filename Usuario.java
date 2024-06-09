
abstract class Usuario {
    private int id;
    private String nombre;
    private String telefono;
    private int edad;
    
    public int getId() {
        return id;
    }   
    
    public Usuario(int id, String nombre, String telefono, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public int getEdad() {
        return edad;
    }
    
    public void modificarNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void modificarTelefono(String telefono){
        this.telefono = telefono;
    }
    
    public void modificarEdad(int edad){
        this.edad = edad;
    }
    
    public String obtenerInformacion() { 
	return "ID: " + id + ", Nombre: " + nombre + ", Telefono: " + telefono + ", Edad: " + edad; 
    }
}
