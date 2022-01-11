/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab3_200516672_Silva;
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

    public Usuario(String username, String password, Date date) {
        this.username = username;
        this.password = password;
        this.date = date;
        this.documentos = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Date getDate() {
        return date;
    }

    public ArrayList<Integer> getDocumentos() {
        return documentos;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDocumentos(ArrayList<Integer> documentos) {
        this.documentos = documentos;
    }

    @Override
    public String toString() {
        return "Usuario:" + username + ", password:" + password + ", fecha:" + date + ", documentos:" + documentos + '\n';
    }

}
