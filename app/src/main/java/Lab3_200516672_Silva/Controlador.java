/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab3_200516672_Silva;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

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
    public void Menu() {
        Scanner myInput = new Scanner(System.in);
        Scanner paso1 = new Scanner(System.in);
        Scanner paso2 = new Scanner(System.in);
        Scanner paso3 = new Scanner(System.in);
        if (getOnlineUser() == "") {
            System.out.println("### EDITOR COLABORATIVO ###\n" +
                    "Escoja su opcion:\n" +
                    "1. Registrarse\n" +
                    "2. Logearse\n" +
                    "3. Visualizar la plataforma\n" +
                    "4. Cerrar el programa\n" +
                    "INTRODUZCA SU OPCION: _ ");
            int respuesta = 0;
            try {
                respuesta = myInput.nextInt();
            } catch (Exception e) {
                System.out.println("Debes ingresar una opcion numerica");

            }
            if (respuesta == 1 || respuesta == 2) {
                authentication(respuesta);
            } else if (respuesta == 3) {
                visualize();
            } else if (respuesta == 4) {
                myInput.close();
                paso1.close();
                paso2.close();
                paso3.close();
                return;
            }
            Menu();

        } else {
            System.out.println("### EDITOR COLABORATIVO ###\n" +
                    "## Registrado como: " + getOnlineUser() + " ##\n" +
                    "Escoja su opcion:\n" +
                    "1. Crear nuevo documento\n" +
                    "2. Compartir documento\n" +
                    "3. Agregar contenido a un documento\n" +
                    "4. Restaurar version de un documento\n" +
                    "5. Revocar acceso a un documento\n" +
                    "6. Buscar en los documentos\n" +
                    "7. Visualizar documentos\n" +
                    "8. Cerrar sesion\n" +
                    "9. Cerrar programa\n" +
                    "INTRODUZCA SU OPCION: _ ");
            int respuesta = 0;
            try {
                respuesta = myInput.nextInt();
            } catch (Exception e) {
                System.out.println("Debes ingresar una opcion numerica");
            }
            if (respuesta == 1) {
                System.out.println("### EDITOR COLABORATIVO ###\n" +
                        "Ingrese un nombre para el documento:\n");

                String nombreDoc = paso1.nextLine();
                System.out.println("### EDITOR COLABORATIVO ###\n" +
                        "Ingrese un texto para el documento:\n");
                String textoDoc = paso2.nextLine();
                create(nombreDoc, textoDoc);
            } else if (respuesta == 2) {
                System.out.println("### EDITOR COLABORATIVO ###\n" +
                        "Ingrese el nombre de algun usuario (Ingrese _ para terminar):\n");
                ArrayList<String> usuarios = new ArrayList<String>();
                while (paso1.hasNextLine()) {
                    String nombre = paso1.nextLine();
                    if (nombre.equals("_")) {
                        break;
                    }
                    usuarios.add(nombre);
                }
                System.out.println("### EDITOR COLABORATIVO ###\n" +
                        "Ingrese la id del documento:\n");
                int idDoc = paso2.nextInt();
                if (checkOwnership(idDoc)) {
                    System.out.println("### EDITOR COLABORATIVO ###\n" +
                            "Ingrese un permiso (Permisos disponibles: w: write, r: read, c: comment):\n");

                    String permiso = paso3.nextLine();
                    share(usuarios, idDoc, permiso);
                } else {
                    System.out.println("El documento no existe o no eres el duenio de ese documento.\n");
                }

            } else if (respuesta == 3) {
                System.out.println("### EDITOR COLABORATIVO ###\n" +
                        "Ingrese la id del documento:\n");
                int idDoc = paso1.nextInt();
                if (checkOwnership(idDoc) || checkWritePermission(idDoc)) {
                    System.out.println("### EDITOR COLABORATIVO ###\n" +
                            "Ingrese un texto a agregar:\n");
                    String texto = paso2.nextLine();
                    add(idDoc, texto);
                } else {
                    System.out.println("El documento no existe o no tienes permisos para escribir en el.\n");
                }
            } else if (respuesta == 4) {
                System.out.println("### EDITOR COLABORATIVO ###\n" +
                        "Ingrese la id del documento:\n");
                int idDoc = paso1.nextInt();
                if (checkOwnership(idDoc)) {
                    System.out.println("### EDITOR COLABORATIVO ###\n" +
                            "Ingrese la id de la version a restaurar:\n");
                    int idVersion = paso2.nextInt();
                    rollback(idDoc, idVersion);
                } else {
                    System.out.println("El documento no existe o no eres el duenio de este.\n");
                }

            } else if (respuesta == 5) {
                System.out.println("### EDITOR COLABORATIVO ###\n" +
                        "Ingrese la id del documento:\n");
                int idDoc = paso1.nextInt();
                if (checkOwnership(idDoc)) {
                    revokeAccess(idDoc);
                } else {
                    System.out.println("El documento no existe o no eres el duenio de este.\n");
                }
            } else if (respuesta == 6) {
                System.out.println("### EDITOR COLABORATIVO ###\n" +
                        "Ingrese el texto a buscar:\n");
                String Texto = paso1.nextLine();
                search(Texto);
            } else if (respuesta == 7) {
                visualize();
            } else if (respuesta == 8) {
                setOnlineUser("");
            }
            else if (respuesta == 9) {
                myInput.close();
                paso1.close();
                paso2.close();
                paso3.close();
                return;
            }
            else if (respuesta == 10) {
                System.out.println(plataforma.getDocumentos().toString());
                System.out.println(plataforma.getUsuarios().toString());
            }
            Menu();
        }
        myInput.close();
        paso1.close();
        paso2.close();
        paso3.close();
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
        if (respuesta == 1) {
            System.out.println("### EDITOR COLABORATIVO ###\n" +
                    "Ingrese un username:\n");
            Scanner paso1 = new Scanner(System.in);
            String usuario = paso1.nextLine();
            System.out.println("### EDITOR COLABORATIVO ###\n" +
                    "Ingrese una contrasena:\n");
            Scanner paso2 = new Scanner(System.in);
            String password = paso2.nextLine();
            ArrayList<Usuario> usuarios = plataforma.getUsuarios();
            for (int i = 0; i < usuarios.size(); i++) {
                if (usuarios.get(i).getUsername().equals(usuario)) {
                    System.out.println("ESE USUARIO YA EXISTE\n");
                    paso1.close();
                    paso2.close();
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
            Scanner paso1 = new Scanner(System.in);
            String usuario = paso1.nextLine();
            System.out.println("### EDITOR COLABORATIVO ###\n" +
                    "Ingrese su contrasena:\n");
            Scanner paso2 = new Scanner(System.in);
            String password = paso2.nextLine();
            for (int i = 0; i < usuarios.size(); i++) {
                if (usuarios.get(i).getUsername().equals(usuario) && usuarios.get(i).getPassword().equals(password)) {
                    onlineUser = usuario;
                    paso1.close();
                    paso2.close();
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
        for (int i = 0; i < usuarios.size(); i += 1) {
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
                                    .equals(plataforma.getDocumentos().get(j).getAccesos().get(k).getNombre())) {
                                if (permiso.equals("w")) {
                                    plataforma.getDocumentos().get(j).getAccesos().get(k).setEscritura(true);
                                    noExiste = true;
                                } else if (permiso.equals("r")) {
                                    plataforma.getDocumentos().get(j).getAccesos().get(k).setLectura(true);
                                    noExiste = true;
                                } else if (permiso.equals("c")) {
                                    plataforma.getDocumentos().get(j).getAccesos().get(k).setComentario(true);
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
                return output;
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
    public void PrintEditor(String Contenido){
        System.out.println(Contenido);
    }
    public void visualize(){
        PrintEditor(editorToString());
    }
}
