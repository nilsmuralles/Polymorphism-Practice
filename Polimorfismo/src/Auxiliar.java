/**
 * @author Nils Muralles
 * @version 1.0
 * @since 13/10/23
 * @modificationDate 16/10/23
 * @description Clase que modela a un Auxiliar, el cual hereda sus atributos de
 *              Jugador y añade atributos específicos
 */

public class Auxiliar extends Jugador { // Clase Auxiliar

    // Atributos de Auxiliar
    private int ataques;
    private int bloqueosEfectivos;
    private int bloqueosFallidos;

    // Constructor de Auxiliar
    public Auxiliar(String nombre, String pais, int errores, int aces, int servicios, String tipo, int ataques,
            int bloqueosEfectivos, int bloqueosFallidos) {
        super(nombre, pais, errores, aces, servicios, tipo);
        this.ataques = ataques;
        this.bloqueosEfectivos = bloqueosEfectivos;
        this.bloqueosFallidos = bloqueosFallidos;
    }

    public Auxiliar(String nombre, String pais, int errores, int aces, int servicios, String tipo, int ataques,
            int bloqueosEfectivos, int bloqueosFallidos, double efectividad) {
        super(nombre, pais, errores, aces, servicios, tipo, efectividad);
        this.ataques = ataques;
        this.bloqueosEfectivos = bloqueosEfectivos;
        this.bloqueosFallidos = bloqueosFallidos;
    }

    /**
     * @return int
     */
    // Setters y getters
    public int getAtaques() {
        return ataques;
    }

    /**
     * @param ataques
     */
    public void setAtaques(int ataques) {
        this.ataques = ataques;
    }

    /**
     * @return int
     */
    public int getBloqueosEfectivos() {
        return bloqueosEfectivos;
    }

    /**
     * @param bloqueosEfectivos
     */
    public void setBloqueosEfectivos(int bloqueosEfectivos) {
        this.bloqueosEfectivos = bloqueosEfectivos;
    }

    /**
     * @return int
     */
    public int getBloqueosFallidos() {
        return bloqueosFallidos;
    }

    /**
     * @param bloqueosFallidos
     */
    public void setBloqueosFallidos(int bloqueosFallidos) {
        this.bloqueosFallidos = bloqueosFallidos;
    }

    /**
     * @return double
     */
    @Override
    public double calcularEfectividad() {
        return ((ataques + bloqueosEfectivos - bloqueosFallidos - errores) * 100
                / (ataques + bloqueosEfectivos + bloqueosFallidos + errores)) + aces * 100 / servicios;
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nTipo: " + tipo + "\nPaís: " + pais + "\nErrores: " + errores + "\nAces: " + aces
                + "\nServicios: "
                + servicios + "\nAtaques: " + ataques + "\nBloqueos Efectivos: " + bloqueosEfectivos
                + "\nBloqueos Fallidos: " + bloqueosFallidos + "\nEfectividad: " + efectividad;
    }

}
