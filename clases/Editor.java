/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;
import java.util.ArrayList;
/**
 *
 * @author Matias
 */
public class Editor {
    private ArrayList<Usuario> usuarios;
    private ArrayList<Documento> documentos;

    /**
     *
     */
    public Editor() {
        this.usuarios = new ArrayList<>();
        this.documentos = new ArrayList<>();
    }

    /**
     *
     * @return
     */
    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    /**
     *
     * @return
     */
    public ArrayList<Documento> getDocumentos() {
        return documentos;
    }

    /**
     *
     * @return
     */
    public int getLastIdDoc(){
        if(getDocumentos().isEmpty()){
            return -1;
        }
        int i = getDocumentos().size() - 1;
        int j = getDocumentos().get(i).getIdDoc();
        return j;
    }
           
    /**
     *
     * @param usuarios
     */
    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    /**
     *
     * @param documentos
     */
    public void setDocumentos(ArrayList<Documento> documentos) {
        this.documentos = documentos;
    }

    @Override
    public String toString() {
        return "editor\n" + "usuarios:" + usuarios + ", documentos:" + documentos + '\n';
    }
    
}
