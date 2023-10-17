/**
 * @author Nils Muralles
 * @version 1.0
 * @since 13/10/23
 * @modificationDate 16/10/23
 * @description Clase que funciona para el manejo de la persistencia de datos del CSV, lee y escribe jugadoresCSV
 */

// Importar las clases y objetos necesarios
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.BufferedReader;

public class Archivo { // Clase Archivo

    // Atributos de Archivo
    private File archivo;

    public Archivo(String nombreArchivo) {
        archivo = new File(nombreArchivo);
    }

    /**
     * @param jugadores
     * @throws Exception
     */
    public void escribir(ArrayList<Jugador> jugadores) throws Exception {

        // Escritor
        PrintWriter writer = new PrintWriter(new FileWriter(archivo, true));

        for (Jugador jugador : jugadores) { // Ciclo que recorre la lista de Jugadores y agrega la información al CSV

            String linea = jugador.getNombre() + "," + jugador.getPais() + "," + jugador.getErrores() + ","
                    + jugador.getAces() + "," + jugador.getServicios(); // Información de todos los jugadores

            switch (jugador.tipo) { // Agregar los datos específicos al CSV
                case "Libero": // Si el jugador es un Líbero
                    linea = linea + "," + ((Libero) jugador).getRecibos() + ",N/A,N/A,N/A,N/A,N/A," + jugador.getTipo()
                            + "," + jugador.getEfectividad();
                    writer.println(linea);
                    break;

                case "Auxiliar": // Si el jugador es un Auxiliar
                    linea = linea + ",N/A," + ((Auxiliar) jugador).getAtaques() + ","
                            + ((Auxiliar) jugador).getBloqueosEfectivos() + ","
                            + ((Auxiliar) jugador).getBloqueosFallidos() + ",N/A,N/A," + jugador.getTipo() + ","
                            + jugador.getEfectividad();
                    writer.println(linea);
                    break;

                case "Pasador": // Si el jugador es un Pasador
                    linea = linea + ",N/A,N/A,N/A,N/A," + ((Pasador) jugador).getPases() + ","
                            + ((Pasador) jugador).getFintas() + "," + jugador.getTipo() + ","
                            + jugador.getEfectividad();
                    writer.println(linea);
                    break;

                default:
                    break;

            }
        }
        writer.close();
    }

    /**
     * @return ArrayList<Jugador>
     * @throws Exception
     */
    public ArrayList<Jugador> leer() throws Exception {

        // Lista que contiene los datos por columna del CSV
        ArrayList<Jugador> jugadores = new ArrayList<Jugador>();

        // Lector
        BufferedReader br = new BufferedReader(new FileReader(archivo));

        String jugador;
        while ((jugador = br.readLine()) != null) {
            String[] datos = jugador.split(",");

            if (datos[datos.length - 2].equals("Libero")) {
                jugadores.add(new Libero(datos[0], datos[1], Integer.parseInt(datos[2]), Integer.parseInt(datos[3]),
                        Integer.parseInt(datos[4]), "Libero", Integer.parseInt(datos[5]),
                        Double.parseDouble(datos[datos.length - 1])));
            }

            if (datos[datos.length - 2].equals("Auxiliar")) {
                jugadores.add(new Auxiliar(datos[0], datos[1], Integer.parseInt(datos[2]), Integer.parseInt(datos[3]),
                        Integer.parseInt(datos[4]), "Auxiliar", Integer.parseInt(datos[6]), Integer.parseInt(datos[7]),
                        Integer.parseInt(datos[7]), Double.parseDouble(datos[datos.length - 1])));
            }

            if (datos[datos.length - 2].equals("Pasador")) {
                jugadores.add(new Pasador(datos[0], datos[1], Integer.parseInt(datos[2]), Integer.parseInt(datos[3]),
                        Integer.parseInt(datos[4]), "Pasador", Integer.parseInt(datos[9]), Integer.parseInt(datos[10]),
                        Double.parseDouble(datos[datos.length - 1])));
            }
        }

        br.close();
        return jugadores;
    }

}
