/**
 * @author Nils Muralles
 * @version 1.0
 * @since 13/10/23
 * @modificationDate 16/10/23
 * @description Esta clase funciona como la vista del usuario, en la que este realiza los inputs y visualiza la información
 */

// Importar las clases necesarias
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    /**
     * @param args
     */
    // Clase Main
    public static void main(String[] args) {

        // Objetos
        Scanner input = new Scanner(System.in);
        Torneo torneo = new Torneo();

        boolean seguir = true;
        while (seguir) { // Menú principal del programa
            System.out.println("");
            System.out.println("---BIENVENIDO---");
            System.out.println("1. Nuevo jugador");
            System.out.println("2. Ver jugadores inscritos");
            System.out.println("3. Ver a los 3 mejores líberos");
            System.out.println("4. Ver pasadores más efectivos");
            System.out.println("5. Salir");
            System.out.print("¿Qué desea hacer? ");
            String opcion = input.nextLine();

            try { // Validar que la opción sea un número
                int op = Integer.parseInt(opcion);

                switch (op) {
                    case 1: // Agregar a un nuevo jugador

                        System.out.println("");
                        System.out.println("---NUEVO JUGADOR---");

                        System.out.print("Ingrese el nombre del jugador: ");
                        String nombre = input.nextLine();

                        System.out.print("Ingrese el país de procedencia del jugador: ");
                        String pais = input.nextLine();

                        System.out.print("Ingrese la cantidad de errores del jugador: ");
                        String cantidadErrores = input.nextLine();

                        System.out.print("Ingrese la cantidad de aces del jugador: ");
                        String cantidadAces = input.nextLine();

                        System.out.print("Ingrese la cantidad de servicios del jugador: ");
                        String cantidadServicios = input.nextLine();

                        System.out.println("");
                        System.out.println("---TIPOS DE JUGADOR---");
                        System.out.println("1. Líbero");
                        System.out.println("2. Auxiliar");
                        System.out.println("3. Pasador");
                        System.out.print("Seleccione el tipo de jugador: ");
                        String tipoJugador = input.nextLine();
                        System.out.println("");

                        try { // Validar que se ingresen los datos correctamente
                            int errores = Integer.parseInt(cantidadErrores);
                            int aces = Integer.parseInt(cantidadAces);
                            int servicios = Integer.parseInt(cantidadServicios);
                            int tipo = Integer.parseInt(tipoJugador);

                            if (tipo < 1 || tipo > 3) { // Validar que el tipo sea válido
                                System.out.println("Ingreso inválido. Seleccione un tipo válido");

                            } else {
                                switch (tipo) {
                                    case 1: // Datos específicos del líbero
                                        System.out.print("Ingrese la cantidad de recibos del líbero: ");
                                        String cantidadRecibos = input.nextLine();

                                        try {
                                            Integer recibos = Integer.parseInt(cantidadRecibos);

                                            // Nuevo Líbero
                                            Libero nuevoLibero = new Libero(nombre, pais, errores, aces, servicios,
                                                    "Libero", recibos);
                                            nuevoLibero.setEfectividad(nuevoLibero.calcularEfectividad());

                                            System.out.println("¡Líbero creado exitosamente!");
                                            torneo.getJugadores().add(nuevoLibero);

                                        } catch (Exception NumberFormatException) {
                                            System.out.println("Ingreso de datos inválido. Verifique los datos");
                                        }

                                        break;

                                    case 2: // Datos específicos del Auxiliar
                                        System.out.print("Ingrese la cantidad de ataques del auxiliar: ");
                                        String cantidadAtaques = input.nextLine();

                                        System.out.print("Ingrese la cantidad de bloqueos efectivos del auxiliar: ");
                                        String cantidadBloqueosE = input.nextLine();

                                        System.out.print("Ingrese la cantidad de bloqueos fallidos del auxiliar: ");
                                        String cantidadBloqueosF = input.nextLine();

                                        try {
                                            Integer ataques = Integer.parseInt(cantidadAtaques);
                                            Integer bloqueosEfectivos = Integer.parseInt(cantidadBloqueosE);
                                            Integer bloqueosFallidos = Integer.parseInt(cantidadBloqueosF);

                                            Auxiliar nuevoAuxiliar = new Auxiliar(nombre, pais, errores, aces,
                                                    servicios,
                                                    "Auxiliar", ataques, bloqueosEfectivos, bloqueosFallidos);
                                            nuevoAuxiliar.setEfectividad(nuevoAuxiliar.calcularEfectividad());

                                            System.out.println("¡Auxiliar creado exitosamente!");
                                            torneo.getJugadores().add(nuevoAuxiliar);

                                        } catch (Exception NumberFormatException) {
                                            System.out.println("Ingreso de datos inválido. Verifique los datos");
                                        }

                                        break;

                                    case 3: // Datos específicos del Pasador
                                        System.out.print("Ingrese la cantidad de pases del pasador: ");
                                        String cantidadPases = input.nextLine();

                                        System.out.print("Ingrese la cantidad de fintas del pasador: ");
                                        String cantidadFintas = input.nextLine();

                                        try {
                                            Integer pases = Integer.parseInt(cantidadPases);
                                            Integer fintas = Integer.parseInt(cantidadFintas);

                                            Pasador nuevoPasador = new Pasador(nombre, pais, errores, aces, servicios,
                                                    "Pasador", pases, fintas);
                                            nuevoPasador.setEfectividad(nuevoPasador.calcularEfectividad());

                                            System.out.println("¡Pasador creado exitosamente!");
                                            torneo.getJugadores().add(nuevoPasador);

                                        } catch (Exception NumberFormatException) {
                                            System.out.println("Ingreso de datos inválido. Verifique los datos");
                                        }

                                        break;
                                    default:
                                        break;
                                }
                            }
                            torneo.guardar();
                            torneo.setJugadores(new ArrayList<Jugador>());

                        } catch (Exception NumberFormatException) {
                            System.out.println("Ingreso de datos inválido");
                        }
                        break;

                    case 2:
                        System.out.println("");
                        System.out.println("---JUGADORES INSCRITOS---");
                        torneo.mostrarJugadores();
                        break;

                    case 3:
                        System.out.println("");
                        System.out.println("---TOP 3 MEJORES LÍBEROS---");
                        torneo.mejoresLiberos();
                        break;

                    case 4:
                        System.out.println("");
                        System.out.println("---PASADORES MÁS EFECTIVOS---");
                        torneo.pasadoresEfectivos();
                        break;

                    case 5:
                        seguir = false;
                        break;

                    default:
                        break;

                }

            } catch (Exception NumberFormatException) { // Si no es un número
                System.out.println("Debe seleccionar un número");
            }
        }

        input.close();
    }
}
