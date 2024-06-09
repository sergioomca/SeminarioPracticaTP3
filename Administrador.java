
public class Administrador extends Usuario {
    private String rol;
    
    public Administrador(int id, String nombre, String telefono, int edad, String rol) {
        super(id, nombre, telefono, edad);
        this.rol = rol;
    }

    public String getRol() {
        return rol;
    }
    
    public void modificarRol(String rol) {
        this.rol = rol;
    }
    
    @Override
    public String obtenerInformacion() {
        return super.obtenerInformacion() + ", Rol: " + rol;
    }
}