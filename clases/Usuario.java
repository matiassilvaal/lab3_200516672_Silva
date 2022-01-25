/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;
import java.util.Date;
import java.util.ArrayList;
/**
 *
 * @author Matias
 */
public class Usuario {
    private String username;
    private String password;
    private Date date;
    private ArrayList<Integer>documentos;

    /**
     *
     * @param string
     * @param date
     * @param string1
     */
    public Usuario(String username, String password, Date date) {
        this.username = username;
        this.password = password;
        this.date = date;
        this.documentos = new ArrayList<>();
    }

    /**
     *
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @return
     */
    public Date getDate() {
        return date;
    }

    /**
     *
     * @return
     */
    public ArrayList<Integer> getDocumentos() {
        return documentos;
    }

    /**
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     *
     * @param documentos
     */
    public void setDocumentos(ArrayList<Integer> documentos) {
        this.documentos = documentos;
    }

    @Override
    public String toString() {
        return "Usuario:" + username + ", password:" + password + ", fecha:" + date + ", documentos:" + documentos + '\n';
    }

}
