/**
 * @author Nils Muralles
 * @version 1.0
 * @since 13/10/23
 * @modificationDate 16/10/23
 * @description Clase que modela a un Librero, el cual hereda sus atributos de
 *              Jugador y añade atributos específicos
 */

public class Libero extends Jugador { // Clase Líbero

    // Atributos de Líbero
    private int recibos;

    // Constructor de Líbero
    public Libero(String nombre, String pais, int errores, int aces, int servicios, String tipo, int recibos) {
        super(nombre, pais, errores, aces, servicios, tipo);
        this.recibos = recibos;
    }

    public Libero(String nombre, String pais, int errores, int aces, int servicios, String tipo, int recibos,
            double efectividad) {
        super(nombre, pais, errores, aces, servicios, tipo, efectividad);
        this.recibos = recibos;
    }

    /**
     * @return int
     */
    // Setters y getters
    public int getRecibos() {
        return recibos;
    }

    /**
     * @param recibos
     */
    public void setRecibos(int recibos) {
        this.recibos = recibos;
    }

    /**
     * @return double
     */
    @Override
    public double calcularEfectividad() {
        return ((recibos - errores) * 100 / (recibos + errores)) + aces * 100 / servicios;
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nTipo: " + tipo + "\nPaís: " + pais + "\nErrores: " + errores + "\nAces: " + aces
                + "\nServicios: "
                + servicios + "\nRecibos: " + recibos + "\nEfectividad: " + efectividad;
    }

}
