/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import clases.*;

/**
 *
 * @author Matias
 */
public class Controlador {
    private String onlineUser;
    private Editor plataforma;

    /**
     *
     */
    public Controlador() {
        plataforma = new Editor();
        onlineUser = "";
    }

    /**
     *
     * @return
     */
    public Editor getPlataforma() {
        return plataforma;
    }

    /**
     *
     * @return
     */
    public String getOnlineUser() {
        return onlineUser;
    }

    /**
     *
     * @param onlineUser
     */
    public void setOnlineUser(String onlineUser) {
        this.onlineUser = onlineUser;
    }

    /**
     *
     */

    public boolean checkIfExists(String nombre) {
        for (int i = 0; i < plataforma.getUsuarios().size(); i++) {
            if (plataforma.getUsuarios().get(i).getUsername().equals(nombre)) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param idDoc
     * @return
     */
    public boolean checkOwnership(int idDoc) {
        for (int i = 0; i < plataforma.getUsuarios().size(); i++) {
            if (plataforma.getUsuarios().get(i).getDocumentos().contains(idDoc)
                    && plataforma.getUsuarios().get(i).getUsername().equals(getOnlineUser())) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param idDoc
     * @return
     */
    public boolean checkWritePermission(int idDoc) {
        for (int i = 0; i < plataforma.getDocumentos().size(); i++) {
            for (int j = 0; j < plataforma.getDocumentos().get(i).getAccesos().size(); j++) {
                if (plataforma.getDocumentos().get(i).getAccesos().get(j).getNombre().equals(getOnlineUser())
                        && plataforma.getDocumentos().get(i).getAccesos().get(j).isEscritura()
                        && idDoc == plataforma.getDocumentos().get(i).getIdDoc()) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *
     * @param idDoc
     * @return
     */
    public String getOwnership(int idDoc) {
        for (int i = 0; i < plataforma.getUsuarios().size(); i++) {
            if (plataforma.getUsuarios().get(i).getDocumentos().contains(idDoc)) {
                return plataforma.getUsuarios().get(i).getUsername();
            }
        }
        return "";
    }

    /**
     *
     * @param idDoc
     * @return
     */
    public boolean checkAnyPermission(int idDoc) {
        for (int i = 0; i < plataforma.getDocumentos().size(); i++) {
            for (int j = 0; j < plataforma.getDocumentos().get(i).getAccesos().size(); j++) {
                if (plataforma.getDocumentos().get(i).getAccesos().get(j).getNombre().equals(getOnlineUser())
                        && (plataforma.getDocumentos().get(i).getAccesos().get(j).isEscritura()
                                || plataforma.getDocumentos().get(i).getAccesos().get(j).isLectura()
                                || plataforma.getDocumentos().get(i).getAccesos().get(j).isComentario())
                        && idDoc == plataforma.getDocumentos().get(i).getIdDoc()) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *
     * @param respuesta
     */
    public void authentication(int respuesta) {
        Scanner paso4 = new Scanner(System.in);
        Scanner paso5 = new Scanner(System.in);
        if (respuesta == 1) {
            System.out.println("### EDITOR COLABORATIVO ###\n" +
                    "Ingrese un username:\n");
            String usuario = paso4.nextLine();
            System.out.println("### EDITOR COLABORATIVO ###\n" +
                    "Ingrese una contrasena:\n");
            String password = paso5.nextLine();
            ArrayList<Usuario> usuarios = plataforma.getUsuarios();
            for (int i = 0; i < usuarios.size(); i++) {
                if (usuarios.get(i).getUsername().equals(usuario)) {
                    System.out.println("ESE USUARIO YA EXISTE\n");
                    return;
                }
            }
            Usuario newUser = new Usuario(usuario, password, new Date());
            usuarios.add(newUser);
            plataforma.setUsuarios(usuarios);
            
        } else {
            ArrayList<Usuario> usuarios = plataforma.getUsuarios();
            System.out.println("### EDITOR COLABORATIVO ###\n" +
                    "Ingrese su username:\n");
            String usuario = paso4.nextLine();
            System.out.println("### EDITOR COLABORATIVO ###\n" +
                    "Ingrese su contrasena:\n");
            String password = paso5.nextLine();
            for (int i = 0; i < usuarios.size(); i++) {
                if (usuarios.get(i).getUsername().equals(usuario) && usuarios.get(i).getPassword().equals(password)) {
                    setOnlineUser(usuario);
                    return;
                }
            }
            System.out.println("Usuario o contrasena incorrecta\n");
            
        }
        
    }

    /**
     *
     * @param nombreDoc
     * @param textoDoc
     */
    public void create(String nombreDoc, String textoDoc) {
        int i = plataforma.getLastIdDoc() + 1;
        Documento nuevoDoc = new Documento(i, nombreDoc, textoDoc, new Date(), new Date());
        ArrayList<Usuario> usuarios = plataforma.getUsuarios();
        for (int j = 0; j < usuarios.size(); j += 1) {
            if (usuarios.get(j).getUsername().equals(getOnlineUser())) {
                usuarios.get(j).getDocumentos().add(i);
            }
        }
        plataforma.getDocumentos().add(nuevoDoc);
    }

    /**
     *
     * @param usuarios
     * @param idDoc
     * @param permiso
     */
    public void share(ArrayList<String> usuarios, int idDoc, String permiso) {
        boolean noExiste;
        if (permiso.equals("w") || permiso.equals("r") || permiso.equals("c")) {
            for (int i = 0; i < usuarios.size(); i += 1) {
                if (checkIfExists(usuarios.get(i))) {
                    noExiste = false;
                    for (int j = 0; j < plataforma.getDocumentos().size(); j += 1) {
                        if (idDoc == plataforma.getDocumentos().get(j).getIdDoc()) {
                            if (plataforma.getDocumentos().get(j).getAccesos().isEmpty()) {
                                if (permiso.equals("w")) {
                                    Acceso newAcceso = new Acceso(usuarios.get(i), false, true, false);
                                    plataforma.getDocumentos().get(j).getAccesos().add(newAcceso);
                                } else if (permiso.equals("r")) {
                                    Acceso newAcceso = new Acceso(usuarios.get(i), true, false, false);
                                    plataforma.getDocumentos().get(j).getAccesos().add(newAcceso);
                                } else if (permiso.equals("c")) {
                                    System.out.print(usuarios.get(i) + "\n");
                                    Acceso newAcceso = new Acceso(usuarios.get(i), false, false, true);
                                    plataforma.getDocumentos().get(j).getAccesos().add(newAcceso);
                                }
                            } else {
                                for (int k = 0; k < plataforma.getDocumentos().get(j).getAccesos().size(); k += 1) {
                                    if (usuarios.get(i)
                                            .equals(plataforma.getDocumentos().get(j).getAccesos().get(k)
                                                    .getNombre())) {
                                        if (permiso.equals("w")) {
                                            plataforma.getDocumentos().get(j).getAccesos().get(k).setEscritura(true);
                                            plataforma.getDocumentos().get(j).getAccesos().get(k).setLectura(false);
                                            plataforma.getDocumentos().get(j).getAccesos().get(k).setComentario(false);
                                            noExiste = true;
                                        } else if (permiso.equals("r")) {
                                            plataforma.getDocumentos().get(j).getAccesos().get(k).setLectura(true);
                                            plataforma.getDocumentos().get(j).getAccesos().get(k).setComentario(false);
                                            plataforma.getDocumentos().get(j).getAccesos().get(k).setEscritura(false);
                                            noExiste = true;
                                        } else if (permiso.equals("c")) {
                                            plataforma.getDocumentos().get(j).getAccesos().get(k).setComentario(true);
                                            plataforma.getDocumentos().get(j).getAccesos().get(k).setEscritura(false);
                                            plataforma.getDocumentos().get(j).getAccesos().get(k).setLectura(false);
                                            noExiste = true;
                                        }
                                    }
                                }
                                if (noExiste == false) {
                                    if (permiso.equals("w")) {
                                        Acceso newAcceso = new Acceso(usuarios.get(i), false, true, false);
                                        plataforma.getDocumentos().get(j).getAccesos().add(newAcceso);
                                    } else if (permiso.equals("r")) {
                                        Acceso newAcceso = new Acceso(usuarios.get(i), true, false, false);
                                        plataforma.getDocumentos().get(j).getAccesos().add(newAcceso);
                                    } else if (permiso.equals("c")) {
                                        Acceso newAcceso = new Acceso(usuarios.get(i), false, false, true);
                                        plataforma.getDocumentos().get(j).getAccesos().add(newAcceso);
                                    }
                                }

                            }
                        }
                    }
                }
            }
        }
    }

    /**
     *
     * @param idDoc
     * @param Texto
     */
    public void add(int idDoc, String Texto) {
        for (int i = 0; i < plataforma.getDocumentos().size(); i++) {
            if (idDoc == plataforma.getDocumentos().get(i).getIdDoc()) {
                plataforma.getDocumentos().get(i).setFechaDeModificacion(new Date());
                plataforma.getDocumentos().get(i).getVersiones().add(plataforma.getDocumentos().get(i).getTextoDoc());
                plataforma.getDocumentos().get(i).setTextoDoc(plataforma.getDocumentos().get(i).getTextoDoc() + Texto);
            }
        }
    }

    /**
     *
     * @param idDoc
     * @param idVersion
     */
    public void rollback(int idDoc, int idVersion) {
        for (int i = 0; i < plataforma.getDocumentos().size(); i++) {
            if (idDoc == plataforma.getDocumentos().get(i).getIdDoc()) {
                plataforma.getDocumentos().get(i).setFechaDeModificacion(new Date());
                plataforma.getDocumentos().get(i).getVersiones().add(plataforma.getDocumentos().get(i).getTextoDoc());
                plataforma.getDocumentos().get(i)
                        .setTextoDoc(plataforma.getDocumentos().get(i).getVersiones().get(idVersion));
            }
        }
    }

    /**
     *
     * @param idDoc
     */
    public void revokeAccess(int idDoc) {
        for (int i = 0; i < plataforma.getDocumentos().size(); i++) {
            if (idDoc == plataforma.getDocumentos().get(i).getIdDoc()) {
                plataforma.getDocumentos().get(i).setAccesos(new ArrayList<Acceso>());
            }
        }
    }

    /**
     *
     * @param text
     */
    public void search(String text) {
        if (plataforma.getDocumentos().isEmpty()) {
            System.out.println("No existen documentos para buscar\n");
        } else {
            System.out.println("El texto ingresado se encuentra en: \n");
            for (int i = 0; i < plataforma.getDocumentos().size(); i++) {
                if (checkAnyPermission(plataforma.getDocumentos().get(i).getIdDoc())
                        || checkOwnership(plataforma.getDocumentos().get(i).getIdDoc())) {
                    if (plataforma.getDocumentos().get(i).getTextoDoc().contains(text)) {
                        System.out.println(plataforma.getDocumentos().get(i).getNombreDoc() + "\n");
                    }
                }
            }
        }
    }

    /**
     *
     * @return
     */
    public String editorToString() {
        String texto = "Documentos: \n";
        String output = "";
        if (getOnlineUser() == "") {
            if (plataforma.getDocumentos().isEmpty()) {
                return "Documentos: \n";
            } else {
                for (int i = 0; i < plataforma.getDocumentos().size(); i++) {
                    Documento doc = plataforma.getDocumentos().get(i);
                    output = texto.concat("ID: ").concat(String.valueOf(i)).concat("\nNombre del documento: ")
                            .concat(doc.getNombreDoc()).concat("\nPropietario: ").concat(getOwnership(i))
                            .concat("\nTexto: ").concat(doc.getTextoDoc()).concat("\nNumero de versiones: ")
                            .concat(String.valueOf(doc.getVersiones().size()))
                            .concat("\n");
                    texto = output;
                }
                return output;
            }
        } else {
            texto = "";
            for (int j = 0; j < plataforma.getUsuarios().size(); j++) {
                if (plataforma.getUsuarios().get(j).getUsername().equals(getOnlineUser())) {
                    Usuario user = plataforma.getUsuarios().get(j);
                    output = texto.concat("Usuario: ").concat(user.getUsername()).concat("\nFecha de creacion: ")
                            .concat(user.getDate().toString()).concat("\n");
                    texto = output;
                }
            }
            if (plataforma.getDocumentos().isEmpty()) {
                return output;
            } else {
                output = texto.concat("Documentos: \n");
                texto = output;
                for (int l = 0; l < plataforma.getDocumentos().size(); l++) {
                    if (checkOwnership(l) || checkAnyPermission(l)) {
                        Documento doc = plataforma.getDocumentos().get(l);
                        output = texto.concat("ID: ").concat(String.valueOf(l)).concat("\nNombre del documento: ")
                                .concat(doc.getNombreDoc()).concat("\nAccesos: \n");
                        texto = output;
                        for (int k = 0; k < doc.getAccesos().size(); k++) {
                            output = texto.concat(doc.getAccesos().get(k).toString());
                            texto = output;
                        }
                        output = texto.concat("\nTexto: ").concat(doc.getTextoDoc()).concat("\nNumero de versiones: ")
                                .concat(String.valueOf(doc.getVersiones().size()))
                                .concat("\n");
                        texto = output;
                    }
                }
                return output;
            }
        }
    }

    public void PrintEditor(String Contenido) {
        System.out.println(Contenido);
    }

    public void visualize() {
        PrintEditor(editorToString());
    }
}