import java.util.List;
import java.util.ArrayList;

public class Grupo extends Objeto {
    private List<Jugador> jugadores;

    public Grupo(int id, String nombre) {
        super(id, nombre); 
        this.jugadores = new ArrayList<>();
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void agregarJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    public void eliminarJugador(Jugador jugador) throws JugadorNoEncontradoException {
        if (!jugadores.remove(jugador)) {
            throw new JugadorNoEncontradoException("El jugador no se encuentra en el grupo.");
        }
    }
    
    @Override 
    public String obtenerInformacion() {
	return super.obtenerInformacion() + ", Número de jugadores: " + jugadores.size(); 
    }
}
