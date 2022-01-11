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
    private boolean comentarios;

    public Acceso(String nombre, boolean lectura, boolean escritura, boolean comentarios) {
        this.nombre = nombre;
        this.lectura = lectura;
        this.escritura = escritura;
        this.comentarios = comentarios;
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

    public boolean isComentarios() {
        return comentarios;
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

    public void setComentarios(boolean comentarios) {
        this.comentarios = comentarios;
    }
    @Override
    public String toString() {
        String resultado1 = lectura ? "si" : "no";
        String resultado2 = escritura ? "si" : "no";
        String resultado3 = lectura ? "si" : "no";
        return "Acceso:" + nombre + ", lectura=" + resultado1 + ", escritura=" + resultado2 + ", comentarios=" + resultado3 + '\n';
    }
}
