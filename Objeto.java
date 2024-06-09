
abstract class Objeto {
    protected int id;
    protected String nombre;

    public Objeto(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void modificarNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String obtenerInformacion() {
	return "ID: " + id + ", Nombre: " + nombre; 
    }
}
