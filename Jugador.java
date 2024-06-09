
public class Jugador extends Usuario {
    private int nivel;
    
    public Jugador(int id, String nombre, String telefono, int edad) {
        super(id, nombre, telefono, edad);
    }

    public int getNivel() {
        return nivel;
    }
    
    public void modificarNivel(int nivel) {
        this.nivel = nivel;
    }
    
    @Override
    public String obtenerInformacion() {
        return super.obtenerInformacion() + ", Nivel: " + nivel;
    }
 }
