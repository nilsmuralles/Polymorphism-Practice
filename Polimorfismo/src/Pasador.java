/**
 * @author Nils Muralles
 * @version 1.0
 * @since 13/10/23
 * @modificationDate 16/10/23
 * @description Clase que modela a un Pasador, el cual hereda sus atributos de
 *              Jugador y añade atributos específicos
 */

public class Pasador extends Jugador { // Clase Pasador

    // Atributos de Pasador
    private int pases;
    private int fintas;

    // Constructor de Pasador
    public Pasador(String nombre, String pais, int errores, int aces, int servicios, String tipo, int pases,
            int fintas) {
        super(nombre, pais, errores, aces, servicios, tipo);
        this.pases = pases;
        this.fintas = fintas;
    }

    public Pasador(String nombre, String pais, int errores, int aces, int servicios, String tipo, int pases,
            int fintas, double efectividad) {
        super(nombre, pais, errores, aces, servicios, tipo, efectividad);
        this.pases = pases;
        this.fintas = fintas;
    }

    /**
     * @return int
     */
    // Setters y getters
    public int getPases() {
        return pases;
    }

    /**
     * @param pases
     */
    public void setPases(int pases) {
        this.pases = pases;
    }

    /**
     * @return int
     */
    public int getFintas() {
        return fintas;
    }

    /**
     * @param fintas
     */
    public void setFintas(int fintas) {
        this.fintas = fintas;
    }

    /**
     * @return double
     */
    @Override
    public double calcularEfectividad() {
        return ((pases + fintas - errores) * 100 / (pases + fintas + errores)) + aces * 100 / servicios;
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nTipo: " + tipo + "\nPaís: " + pais + "\nErrores: " + errores + "\nAces: " + aces
                + "\nServicios: "
                + servicios + "\nPases: " + pases + "\nFintas: " + fintas + "\nEfectividad: " + efectividad;
    }

}
