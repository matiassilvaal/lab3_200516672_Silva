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

    public Acceso(String nombre, boolean lectura, boolean escritura, boolean comentario) {
        this.nombre = nombre;
        this.lectura = lectura;
        this.escritura = escritura;
        this.comentario = comentario;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isLectura() {
        return lectura;
    }

    public boolean isEscritura() {
        return escritura;
    }

    public boolean isComentario() {
        return comentario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setLectura(boolean lectura) {
        this.lectura = lectura;
    }

    public void setEscritura(boolean escritura) {
        this.escritura = escritura;
    }

    public void setComentario(boolean comentario) {
        this.comentario = comentario;
    }
    @Override
    public String toString() {
        String resultado1 = lectura ? "si" : "no";
        String resultado2 = escritura ? "si" : "no";
        String resultado3 = lectura ? "si" : "no";
        return "Acceso:" + nombre + ", lectura=" + resultado1 + ", escritura=" + resultado2 + ", comentarios=" + resultado3 + '\n';
    }
}
