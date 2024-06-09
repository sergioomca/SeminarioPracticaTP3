import java.util.List;
import java.util.ArrayList;

public class Turno extends Objeto {
    private Cancha lugar;
    private int idGrupo;
    private String dia;
    private String hora;
    private List<Jugador> jugadores;
    private int nroJugadores;
    private int capacidadMaxima;
    private Grupo grupo;

    public Turno(int id, Cancha lugar, Grupo grupo, String dia, String hora, int capacidadMaxima) {
        super(id, lugar.getNombre()); 
        this.lugar = lugar;
        this.idGrupo = grupo.getId();
        this.dia = dia;
        this.hora = hora;
        this.jugadores = new ArrayList<>();
        this.capacidadMaxima = capacidadMaxima;
        this.nroJugadores = 0;
        this.grupo = grupo;
    }

    public Cancha getLugar() {
        return lugar;
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public String getDia() {
        return dia;
    }

    public String getHora() {
        return hora;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public int getNroJugadores() {
        return nroJugadores;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void agregarJugador(Jugador jugador) throws TurnoLlenoException {
        if (nroJugadores >= capacidadMaxima) {
            throw new TurnoLlenoException("El turno está lleno, no es posible agregar más jugadores.");
        }
        jugadores.add(jugador);
        nroJugadores++;
    }

    public void eliminarJugador(Jugador jugador) throws JugadorNoEncontradoException {
        if (!jugadores.remove(jugador)) {
            throw new JugadorNoEncontradoException("El jugador no se encuentra en el turno.");
        }
        nroJugadores--;
    }

    public void modificarLugar(Cancha lugar) {
        this.lugar = lugar;
    }

    public void modificarDia(String dia) {
        this.dia = dia;
    }

    public void modificarHora(String hora) {
        this.hora = hora;
    }

    public void modificarMaxJug(int capacidad) {
        this.capacidadMaxima = capacidad;
    }
    
    @Override 
    public String obtenerInformacion() { 
	return super.obtenerInformacion() + ", Lugar: " + lugar.getNombre() + ", Día: " + dia + ", Hora: " + hora + ", Número de jugadores: " + nroJugadores + ", Capacidad máxima: " + capacidadMaxima; 
    }
}
