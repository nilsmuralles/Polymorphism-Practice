
/**
 * @author Nils Muralles
 * @version 1.0
 * @since 13/10/23
 * @modificationDate 16/10/23
 * @description Esta clase funciona como controlador del programa, única clase en la que se hacen los cálculos y la lógica del programa
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Torneo { // Clase Toreno

    // Atributos de Torneo
    private ArrayList<Jugador> jugadores;
    private Archivo jugadoresCSV;

    public Torneo() { // Constructor de Torneo
        jugadores = new ArrayList<Jugador>();
        jugadoresCSV = new Archivo("jugadores.CSV");
    }

    /**
     * @return ArrayList<Jugador>
     */
    // Setters y getters
    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    /**
     * @param jugadores
     */
    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    /**
     * @throws Exception
     */
    public void mostrarJugadores() throws Exception {
        for (Jugador jugador : jugadoresCSV.leer()) { // Recorre la lista de jugadores
            System.out.println(jugador.toString()); // Imprime a cada jugador
            System.out.println("");
        }
    }

    /**
     * @throws Exception
     */
    public void mejoresLiberos() throws Exception {
        List<Jugador> listaJugadores = jugadoresCSV.leer(); // Convierte el ArrayList en una lista

        Comparator<Jugador> comparadorEfectividad = (jugador1, jugador2) -> Double.compare(jugador2.getEfectividad(),
                jugador1.getEfectividad()); // Compara las efectividades de los jugadores, para saber si la del 2 es
                                            // mayor que la del 1

        Collections.sort(listaJugadores, comparadorEfectividad); // Ordena la lista de jugadores de mayor a menor

        int count = 0;
        for (Jugador jugador : listaJugadores) { // Recorre la lista de jugadores
            if (jugador instanceof Libero && count < 3) { // Verifica que el jugador sea un líbero y que el contador no
                                                          // haya llegado a 3
                System.out.println(((Libero) jugador).toString());
                System.out.println("");
                count++;
            }
        }

    }

    /**
     * @throws Exception
     */
    public void pasadoresEfectivos() throws Exception {
        List<Jugador> listaJugadores = jugadoresCSV.leer(); // Convierte el ArrayList en una lista

        Comparator<Jugador> comparadorEfectividad = (jugador1, jugador2) -> Double.compare(jugador2.getEfectividad(),
                jugador1.getEfectividad()); // Compara las efectividades de los jugadores, para saber si la del 2 es
                                            // mayor que la del 1

        Collections.sort(listaJugadores, comparadorEfectividad); // Ordena la lista de jugadores de mayor a menor

        for (Jugador jugador : listaJugadores) { // Recorre la lista de jugadores
            if (jugador instanceof Pasador && jugador.getEfectividad() >= 80) { // Verifica que el jugador sea un
                                                                                // pasador y tenga más de 80 de
                                                                                // efectividad
                System.out.println(((Pasador) jugador).toString());
                System.out.println("");
            }
        }
    }

    /**
     * @throws Exception
     */
    public void guardar() throws Exception {
        jugadoresCSV.escribir(jugadores);
    }

}
