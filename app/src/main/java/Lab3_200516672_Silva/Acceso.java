/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab3_200516672_Silva;

/**
 *
 * @author Matias
 */
public class Acceso {
    private String nombre;
    private boolean lectura;
    private boolean escritura;
    private boolean comentario;

    /**
     *
     * @param nombre
     * @param lectura
     * @param escritura
     * @param comentario
     */
    public Acceso(String nombre, boolean lectura, boolean escritura, boolean comentario) {
        this.nombre = nombre;
        this.lectura = lectura;
        this.escritura = escritura;
        this.comentario = comentario;
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @return
     */
    public boolean isLectura() {
        return lectura;
    }

    /**
     *
     * @return
     */
    public boolean isEscritura() {
        return escritura;
    }

    /**
     *
     * @return
     */
    public boolean isComentario() {
        return comentario;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @param lectura
     */
    public void setLectura(boolean lectura) {
        this.lectura = lectura;
    }

    /**
     *
     * @param escritura
     */
    public void setEscritura(boolean escritura) {
        this.escritura = escritura;
    }

    /**
     *
     * @param comentario
     */
    public void setComentario(boolean comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "Acceso:" + "nombre:" + nombre + ", lectura:" + lectura + ", escritura:" + escritura + ", comentario:" + comentario + '\n';
    }

}
