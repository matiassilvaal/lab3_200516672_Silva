/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 * Clase que representa los accesos (permisos) de los documentos
 * Cada acceso tiene la posibilidad de tener lectura, escritura y comentarios o varios al mismo tiempo
 * @author Matias
 */
public class Acceso {
    private String nombre;
    private boolean lectura;
    private boolean escritura;
    private boolean comentario;

    /**
     * 
     * @param nombre Usuario al que pertenece el acceso
     * @param lectura Tiene o no tiene permiso lectura
     * @param escritura Tiene o no tiene permiso escritura
     * @param comentario Tiene o no tiene permiso comentario
     */
    public Acceso(String nombre, boolean lectura, boolean escritura, boolean comentario) {
        this.nombre = nombre;
        this.lectura = lectura;
        this.escritura = escritura;
        this.comentario = comentario;
    }

    /**
     * Obtiene el usuario de un acceso
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene si el acceso tiene lectura
     * @return
     */
    public boolean isLectura() {
        return lectura;
    }

    /**
     * Obtiene si el acceso tiene escritura
     * @return
     */
    public boolean isEscritura() {
        return escritura;
    }

    /**
     * Obtiene si el acceso tiene comentario
     * @return
     */
    public boolean isComentario() {
        return comentario;
    }

    /**
     * Cambia el nombre del usuario en el acceso
     * @param nombre Nombre de usuario
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Cambia el permiso de lectura de un usuario
     * @param lectura True or false
     */
    public void setLectura(boolean lectura) {
        this.lectura = lectura;
    }

    /**
     * Cambia el permiso de escritura de un usuario
     * @param escritura True or false
     */
    public void setEscritura(boolean escritura) {
        this.escritura = escritura;
    }

    /**
     * Cambia el permiso de comentario de un usuario
     * @param comentario True or false
     */
    public void setComentario(boolean comentario) {
        this.comentario = comentario;
    }
     /**
     * Obtiene el acceso en modo String
     * @return String del acceso pasado a texto
     */
    @Override
    public String toString() {
        String r1 = lectura ? "Si" : "No";
        String r2 = escritura ? "Si" : "No";
        String r3 = comentario ? "Si" : "No";
        return "Usuario:" + nombre + ", Lectura:" + r1 + ", Escritura:" + r2 + ", Comentario:" + r3 + '\n';
    }

}
