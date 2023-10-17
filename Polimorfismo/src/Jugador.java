/**
 * @author Nils Muralles
 * @version 1.0
 * @since 13/10/23
 * @modificationDate 16/10/23
 * @description Clase que modela a un Jugador, esta hereda tanto a Librero como
 *              a Auxiliar y Pasador
 */

public class Jugador { // Clase Jugador

    // Atributos de Jugador
    protected String nombre;
    protected String pais;
    protected int errores;
    protected int aces;
    protected int servicios;
    protected String tipo;
    protected double efectividad;

    // Constructor de Jugador
    public Jugador(String nombre, String pais, int errores, int aces, int servicios, String tipo) {
        this.nombre = nombre;
        this.pais = pais;
        this.errores = errores;
        this.aces = aces;
        this.servicios = servicios;
        this.tipo = tipo;
        efectividad = 0.0;
    }

    public Jugador(String nombre, String pais, int errores, int aces, int servicios, String tipo, double efectividad) {
        this.nombre = nombre;
        this.pais = pais;
        this.errores = errores;
        this.aces = aces;
        this.servicios = servicios;
        this.tipo = tipo;
        this.efectividad = efectividad;
    }

    /**
     * @return String
     */
    // Setters y getters
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return String
     */
    public String getPais() {
        return pais;
    }

    /**
     * @param pais
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * @return int
     */
    public int getErrores() {
        return errores;
    }

    /**
     * @param errores
     */
    public void setErrores(int errores) {
        this.errores = errores;
    }

    /**
     * @return int
     */
    public int getAces() {
        return aces;
    }

    /**
     * @param aces
     */
    public void setAces(int aces) {
        this.aces = aces;
    }

    /**
     * @return int
     */
    public int getServicios() {
        return servicios;
    }

    /**
     * @param servicios
     */
    public void setServicios(int servicios) {
        this.servicios = servicios;
    }

    /**
     * @return String
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return double
     */
    public double getEfectividad() {
        return efectividad;
    }

    /**
     * @param efectividad
     */
    public void setEfectividad(double efectividad) {
        this.efectividad = efectividad;
    }

    /**
     * @return double
     */
    public double calcularEfectividad() {
        return 0.0;
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        return "Jugador [nombre=" + nombre + ", pais=" + pais + ", errores=" + errores + ", aces=" + aces
                + ", servicios=" + servicios + ", tipo=" + tipo + ", efectividad=" + efectividad + "]";
    }

}
