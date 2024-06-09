
import java.util.*;

public class ManejoDeTurnos {
    private static ArrayList<Turno> turnos = new ArrayList<>();
    private static ArrayList<Grupo> grupos = new ArrayList<>();
    private static ArrayList<Jugador> jugadores = new ArrayList<>();
    private static ArrayList<Cancha> canchas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        int[] listaGrupo = {};
        
        // Inicializar con datos para pruebas
        //Datos de canchas (ID, Nombre, Cantidad de jugadores)
        canchas.add(new Cancha(1, "La escondida1", 18));
        canchas.add(new Cancha(2, "Civechi1", 22));
        canchas.add(new Cancha(3, "Civechi2", 22));
        canchas.add(new Cancha(4, "UNOParquet", 10));
        canchas.add(new Cancha(5, "UNOAlfombra",12));
        
        // Datos de grupos (ID, Nombre)
        grupos.add(new Grupo(1, "Masters"));
        grupos.add(new Grupo(2, "AlterMasters"));
        grupos.add(new Grupo(3,"Regulares"));
        grupos.add(new Grupo(4,"Veteranos"));
        
        // Datos de turnos (ID, Cancha,Grupo, Dia, Hora, Cantidad de jugadores)
        turnos.add(new Turno(1, canchaConId(5), grupoConId(4), "2024-06-06", "10:00", canchaConId(5).getCapacidad()));
        turnos.add(new Turno(2, canchaConId(4), grupoConId(4), "2024-06-06", "11:00", canchaConId(4).getCapacidad()));
        
      
         // Datos de jugador (ID, nombre, telefono, edad)
        jugadores.add(new Jugador(1, "Juan Perez", "2916412222", 48));
        jugadores.add(new Jugador(2, "Esteban Lopez", "2914445533", 46));
        jugadores.add(new Jugador(3, "Martin Garcia", "2914445522", 53));
        jugadores.add(new Jugador(4, "Manuel Paez", "2914445599", 48));
        jugadores.add(new Jugador(5, "Cristian Dominguez", "2914445576", 47));
        jugadores.add(new Jugador(6, "Luis Ponce", "2914445534", 44));
        jugadores.add(new Jugador(7, "Marcos Mancini", "2914445323", 33));
        
    // **********************************************************************************
    // Menu principal:
    // **********************************************************************************
    // En este menu:
    //  la opcion 1 va a simular la llegada del mensaje de un jugador solicitando su alta o baja en 
    // alguno de los turnos activos.
    // Las demas opciones permitiran trabajar con los distintos objetos que forman parte de la aplicacion,
    // pudiendo agregar, modificar, eliminar ya sea un turno, un grupo, una cancha o un jugador en cada una 
    // de las listas creadas.
    
        while (!salir) {
            try {
                System.out.println("Menu Turnos:");
                System.out.println("1. Recibe mensaje");
                System.out.println("2. Agregar...(Turno, Grupo, Cancha, Jugador)");
                System.out.println("3. Modificar...(Turno, Grupo, Cancha, Jugador)");
                System.out.println("4. Eliminar...(Turno, Grupo, Cancha, Jugador)");
                System.out.println("5. Mostrar...(Turno, Grupo, Cancha, Jugador)");
                System.out.println("6. Salir");

                System.out.print("Seleccione una opción: ");
                int opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        recibirMensaje();
                        break;
                    case 2:
                        mostrarSubmenu("Agregar");
                        break;
                    case 3:
                        mostrarSubmenu("Modificar");
                        break;
                    case 4:
                        mostrarSubmenu("Eliminar");
                        break;
                    case 5:
                        mostrarSubmenuMostrar();
                        break;
                    case 6:
                        salir = true;
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un número.");
                scanner.next(); 
            } catch (OpcionInvalidaException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    // **********************************************************************************
    // Menu secundario:
    // **********************************************************************************
    public static void mostrarSubmenu(String accion) throws OpcionInvalidaException {
        Scanner scanner = new Scanner(System.in);
        System.out.println(accion + "...");
        System.out.println("1. Jugador");
        System.out.println("2. Turno");
        System.out.println("3. Grupo");
        System.out.println("4. Cancha");
        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                if (accion.equals("Agregar")) {
                    agregarJugador();
                } else if (accion.equals("Modificar")) {
                    modificarJugador();
                } else if (accion.equals("Eliminar")) {
                    eliminarJugador();
                }
                break;
            case 2:
                if (accion.equals("Agregar")) {
                    agregarTurno();
                } else if (accion.equals("Modificar")) {
                    modificarTurno();
                } else if (accion.equals("Eliminar")) {
                    eliminarTurno();
                }
                break;
            case 3:
                if (accion.equals("Agregar")) {
                    agregarGrupo();
                } else if (accion.equals("Modificar")) {
                    modificarGrupo();
                } else if (accion.equals("Eliminar")) {
                    eliminarGrupo();
                }
                break;
            case 4:
                if (accion.equals("Agregar")) {
                    agregarCancha();
                } else if (accion.equals("Modificar")) {
                    modificarCancha();
                } else if (accion.equals("Eliminar")) {
                    eliminarCancha();
                }
                break;
            default:
                throw new OpcionInvalidaException("Opción no válida en el submenú.");
        }
    }

    // **********************************************************************************
    // Menu para mostrar contenido de cada una de las listas:
    // **********************************************************************************
    public static void mostrarSubmenuMostrar() throws OpcionInvalidaException { 
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mostrar...");
        System.out.println("1. Jugadores");
        System.out.println("2. Turnos");
        System.out.println("3. Grupos");
        System.out.println("4. Canchas");
        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();
        
        switch (opcion) {
            case 1:
                System.out.println("Lista de Jugadores:");
                for (Jugador jugador : jugadores) {
                    System.out.println(jugador.obtenerInformacion());
                }
                break;
            case 2:
                System.out.println("Lista de Turnos:");
                for (Turno turno : turnos) {
                    System.out.println(turno.obtenerInformacion());
                    System.out.println("    Jugadores en el turno:");
                    
                    for (Jugador jugador : turno.getJugadores()) {
                        Jugador jugadorInfo = jugadorConId(jugador.getId());
                        if (jugadorInfo != null) {
                            System.out.println("    " + jugador.obtenerInformacion());
                        }
                    }
                }
                break;
            case 3:
                System.out.println("Lista de Grupos:");
                for (Grupo grupo : grupos) {
                    System.out.println(grupo.obtenerInformacion());
                    System.out.println("    Jugadores en el grupo:");
                    for (Jugador jugador : grupo.getJugadores()) {
                        Jugador jugadorInfo = jugadorConId(jugador.getId());
                        if (jugadorInfo != null) {
                            System.out.println("    " + jugador.obtenerInformacion());
                        }
                    }
                }
                break;
            case 4:
                System.out.println("Lista de Canchas:");
                for (Cancha cancha : canchas) {
                    System.out.println(cancha.obtenerInformacion());
                }
                break;
            default:
                throw new OpcionInvalidaException("Opción no válida en el submenú.");
        }
    }
    
    
    // Los siguientes metodos permiten que, pidiendo mediante un ID nos devuelva el objeto que tiene ese ID,
    // ya sea un turno, jugador, cancha o grupo
    
    // Devuelve el turno que coincide con el ID de la lista de turnos, caso contrario devuelve null
    public static Turno turnoConId(int id) {
        for (Turno turno : turnos) {
            if (turno.getId() == id) {
                return turno;
            }
        }
        return null;
    }
    // Devuelve el jugador que coincide con el ID de la lista de jugadores, caso contrario devuelve null
    public static Jugador jugadorConId(int id) {
        for (Jugador jugador : jugadores) {
            if (jugador.getId() == id) {
                return jugador;
            } 
        }
        return null;
    }
        // Devuelve la cancha que coincide con el ID de la lista de canchas, caso contrario devuelve null
    public static Cancha canchaConId(int id) {
        for (Cancha cancha : canchas) {
            if (cancha.getId() == id) {
                return cancha;
            }
        }
        return null;
    }
         // Devuelve el grupo que coincide con el ID de la lista de grupós, caso contrario devuelve null
    public static Grupo grupoConId(int id) {
        for (Grupo grupo : grupos) {
            if (grupo.getId() == id) {
                return grupo;
            }
       }
       return null;
    }
    
    // **********************************************************************************
    // Menu que permite ingresar los datos que llegarian en el mensaje del jugador:
    // **********************************************************************************
        public static void recibirMensaje() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione una opción:");
        System.out.println("1. Agregar jugador a turno");
        System.out.println("2. Eliminar jugador de turno");
        int opcion = scanner.nextInt();

        System.out.print("Ingrese el ID del turno: ");
        int idTurno = scanner.nextInt();
        System.out.print("Ingrese el ID del jugador: ");
        int idJugador = scanner.nextInt();

        Turno turnoSeleccionado = turnoConId(idTurno);

        if (turnoSeleccionado == null) {
            System.out.println("Turno no encontrado.");
            return;
        }

        Jugador jugadorSeleccionado = jugadorConId(idJugador);
        
        if (jugadorSeleccionado == null) {
            System.out.println("Jugador no encontrado.");
            return;
        }

        switch (opcion) {
            case 1:
                try {
                    turnoSeleccionado.agregarJugador(jugadorSeleccionado);
                    System.out.println("Jugador agregado al turno.");
                } catch (TurnoLlenoException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 2:
                try {
                    turnoSeleccionado.eliminarJugador(jugadorSeleccionado);
                    System.out.println("Jugador eliminado del turno.");
                } catch (JugadorNoEncontradoException e) {
                    System.out.println(e.getMessage());
                }
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }
    }
    
    
    // **********************************************************************************
    // Manejo de los jugadoress:
    // **********************************************************************************
    
    //Permite agregar un nuevo jugador a la lista de jugadores
    public static void agregarJugador() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del jugador: ");
        int id = scanner.nextInt();
        scanner.nextLine();  
        if (jugadorConId(id) != null) {
            System.out.println("Error: El ID del jugador ya existe.");
                return;
        }
                
        System.out.print("Ingrese el nombre del jugador: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el teléfono del jugador: ");
        String telefono = scanner.nextLine();
        System.out.print("Ingrese la edad del jugador: ");
        int edad = scanner.nextInt();
        Jugador nuevoJugador = new Jugador(id, nombre, telefono, edad);
        jugadores.add(nuevoJugador);
        System.out.println("Jugador agregado.");
    }
    
    //Permite modificar un jugador de la lista de jugadores.
    public static void modificarJugador() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del jugador a modificar: ");
        int idJugador = scanner.nextInt();
        scanner.nextLine(); 

        Jugador jugadorSeleccionado = jugadorConId(idJugador);
        
        if (jugadorSeleccionado == null) {
            System.out.println("El jugador no existe.");
            return;
        }

        System.out.println("¿Qué desea modificar?");
        System.out.println("1. Nombre");
        System.out.println("2. Telefono");
        System.out.println("3. Edad");
        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); 

        switch (opcion) {
            case 1:
                System.out.print("Ingrese el nuevo nombre del jugador: ");
                String nuevoNombre = scanner.nextLine();
                jugadorSeleccionado.modificarNombre(nuevoNombre);
                break;
            case 2:
                System.out.print("Ingrese el nuevo telefono del jugador: ");
                String nuevoTelefono = scanner.nextLine();
                jugadorSeleccionado.modificarTelefono(nuevoTelefono);
                break;
            case 3:
                System.out.print("Ingrese la nueva edad del jugador: ");
                int nuevaEdad = scanner.nextInt();
                jugadorSeleccionado.modificarEdad(nuevaEdad);
                break;
            default:
                System.out.println("Opción no válida.");
        }

        System.out.println("Jugador actualizado.");
    }
    
    //Permite eliminar un jugador de la lista de jugadores.
    public static void eliminarJugador() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del jugador: ");
        int id = scanner.nextInt();

        Jugador jugadorSeleccionado = jugadorConId(id);
        
        if (jugadorSeleccionado != null) {
            jugadores.remove(jugadorSeleccionado);
            System.out.println("Jugador eliminado.");
        } else {
            System.out.println("Jugador no encontrado.");
        }
    }

    // **********************************************************************************
    // Manejo de los turnos:
    // **********************************************************************************
    // Permite agregar un nuevo turno a la lista de turnos
    public static void agregarTurno() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del turno: ");
        int id = scanner.nextInt();
        scanner.nextLine();
         //Valida si el ID del turno ya existe
        if (turnoConId(id) != null ) {
            System.out.println("Error: El ID del turno ya existe.");
                return;
        }
       
        System.out.print("Ingrese ID del lugar del turno: ");
        int idLugar = scanner.nextInt();
        Cancha lugar = canchaConId(idLugar);
        System.out.print("Ingrese el ID del Grupo al que pertenece el turno: ");
        int idGrupo = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese el día del turno: ");
        String dia = scanner.nextLine();
        System.out.print("Ingrese la hora del turno: ");
        String hora = scanner.nextLine();
        System.out.print("Ingrese el máximo de jugadores del turno: ");
        int maxJugadores = scanner.nextInt();
        turnos.add(new Turno(id, lugar,grupoConId(idGrupo), dia, hora, maxJugadores));
        System.out.println("Turno agregado.");
    }
    
    // Permite modificar un turno de la lista de turnos
    public static void modificarTurno() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del turno a modificar: ");
        int idTurno = scanner.nextInt();
        scanner.nextLine(); 
        Turno turnoSeleccionado = null;
        
        for (Turno turno : turnos) {
            if (turno.getId() == idTurno) {
                turnoSeleccionado = turno;
                break;
            }
        }

        if (turnoSeleccionado == null) {
            System.out.println("El turno no existe.");
            return;
        }

        System.out.println("¿Qué desea modificar?");
        System.out.println("1. Lugar");
        System.out.println("2. Día");
        System.out.println("3. Hora");
        System.out.println("4. Máximo de jugadores");
        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); 

        switch (opcion) {
            case 1:
                System.out.print("Ingrese el id de la nueva cancha del turno: ");
                int nuevoLugar = scanner.nextInt();
                
                turnoSeleccionado.modificarLugar(canchaConId(nuevoLugar));
                break;
            case 2:
                System.out.print("Ingrese el nuevo día del turno: ");
                String nuevoDia = scanner.nextLine();
                turnoSeleccionado.modificarDia(nuevoDia);
                break;
            case 3:
                System.out.print("Ingrese la nueva hora del turno: ");
                String nuevaHora = scanner.nextLine();
                turnoSeleccionado.modificarHora(nuevaHora);
                break;
            case 4:
                System.out.print("Ingrese el nuevo máximo de jugadores del turno: ");
                int nuevoMaxJugadores = scanner.nextInt();
                turnoSeleccionado.modificarMaxJug(nuevoMaxJugadores);
                break;
            default:
                System.out.println("Opción no válida.");
        }

        System.out.println("Turno modificado.");
    }

    // Permite eliminar un turno de la lista de turnos
    public static void eliminarTurno() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del turno: ");
        int id = scanner.nextInt();

        Turno turnoSeleccionado = turnoConId(id);
        
        if (turnoSeleccionado != null) {
            turnos.remove(turnoSeleccionado);
            System.out.println("Turno eliminado.");
        } else {
            System.out.println("Turno no encontrado.");
        }
    }

    // **********************************************************************************
    // Manejo de los grupos:
    // **********************************************************************************
    
    // Permite agregar un nuevo grupo a la lista de grupos
    public static void agregarGrupo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del grupo: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        //Valida si el ID del grupo ya existe
        if ( grupoConId(id) != null )  {
            System.out.println("Error: El ID del grupo ya existe.");
                return;
        }
        
        System.out.print("Ingrese el nombre del grupo: ");
        String nombre = scanner.nextLine();
        grupos.add(new Grupo(id, nombre));
        System.out.println("Grupo agregado.");
    }

    // Permite modificar un grupo de la lista de grupos
    public static void modificarGrupo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del grupo a modificar: ");
        int idGrupo = scanner.nextInt();
        scanner.nextLine(); 
        Grupo grupoSeleccionado = grupoConId(idGrupo);
        
        if ( grupoSeleccionado == null ) {
            System.out.println("El grupo no existe.");
            return;
        }
        
        System.out.println("¿Qué desea modificar?");
        System.out.println("1. Nombre");
        System.out.println("2. Agregar Jugador al grupo");
        System.out.println("3. Eliminar Jugador del grupo");
        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); 
                
        switch (opcion) {
            case 1:
                System.out.print("Ingrese el nuevo nombre del grupo: ");
                String nuevoNombre = scanner.nextLine();
                grupoSeleccionado.modificarNombre(nuevoNombre);
                break;
            case 2:
                System.out.print("Ingrese id del jugador a agregar al grupo: ");
                int idJugador = scanner.nextInt();
                grupoSeleccionado.agregarJugador(jugadorConId(idJugador));
                break;
            case 3:
                System.out.print("Ingrese id del jugador a eliminar del grupo: ");
                idJugador = scanner.nextInt();
                try
                {
                    grupoSeleccionado.eliminarJugador(jugadorConId(idJugador));
                }
                catch (JugadorNoEncontradoException jnee)
                {
                    jnee.printStackTrace();
                }
                break;
            default:
                System.out.println("Opción no válida.");
        }

        System.out.println("Grupo modificado.");
    }

    //Permite eliminar un grupo de la lista de grupos
    public static void eliminarGrupo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del grupo: ");
        int id = scanner.nextInt();

        Grupo grupoSeleccionado = grupoConId(id);
        
        if (grupoSeleccionado != null) {
            grupos.remove(grupoSeleccionado);
            System.out.println("Grupo eliminado.");
        } else {
            System.out.println("Grupo no encontrado.");
        }
    }

    // **********************************************************************************
    // Manejo de los canchas:
    // **********************************************************************************
    // Permite agregar una nueva cancha a la lista de canchas
    public static void agregarCancha() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del cancha: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        if (canchaConId(id) != null) {
                System.out.println("Error: El ID del cancha ya existe.");
                return;
            }
                
        System.out.print("Ingrese el nombre de la cancha: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el capacidad de la cancha: ");
        int capacidad = scanner.nextInt();
        canchas.add(new Cancha(id, nombre,capacidad));
        System.out.println("Cancha agregado.");
    }
    // Permite modificar una cancha existente
        public static void modificarCancha() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del cancha a modificar: ");
        int idCancha = scanner.nextInt();
        scanner.nextLine(); 
        Cancha canchaSeleccionado = canchaConId(idCancha);
        
        if (canchaSeleccionado == null) {
            System.out.println("El cancha no existe.");
            return;
        }

        System.out.println("¿Qué desea modificar?");
        System.out.println("1. Nombre");
        System.out.println("2. Capacidad");
        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); 

        switch (opcion) {
            case 1:
                System.out.print("Ingrese el nuevo nombre de la cancha: ");
                String nuevoNombre = scanner.nextLine();
                canchaSeleccionado.modificarNombre(nuevoNombre);
                break;
            case 2:
                System.out.print("Ingrese la capacidad de la cancha: ");
                int nuevoCapacidad = scanner.nextInt();
                canchaSeleccionado.modificarCapacidad(nuevoCapacidad);
                break;
            default:
                System.out.println("Opción no válida.");
        }

        System.out.println("Cancha modificada.");
    }
    // Permite eliminar una cancha existente
    public static void eliminarCancha() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID de la cancha: ");
        int id = scanner.nextInt();

        Cancha canchaSeleccionada = canchaConId(id);
        
        if (canchaSeleccionada != null) {
            canchas.remove(canchaSeleccionada);
            System.out.println("Cancha eliminada.");
        } else {
            System.out.println("Cancha no encontrada.");
        }
    }
}