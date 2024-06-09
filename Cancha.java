
public class Cancha extends Objeto {
    private int capacidad;

    public Cancha(int id, String nombre, int capacidad) {
        super(id, nombre); 
        this.capacidad = capacidad;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void modificarCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    
    public String obtenerInformacion() {
	return super.obtenerInformacion() + ", Capacidad: " + capacidad; 
    }
}

