package vista;

import java.util.ArrayList;
import java.util.Scanner;

import controlador.Controlador;

public class Menu {
    private Controlador controlador;

    public Menu() {
        this.controlador = new Controlador();
    }

    public Controlador getControlador() {
        return controlador;
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    public void usarMenu() {
        Scanner myInput = new Scanner(System.in);
        Scanner paso1 = new Scanner(System.in);
        Scanner paso2 = new Scanner(System.in);
        Scanner paso3 = new Scanner(System.in);
        if (controlador.getOnlineUser() == "") {
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
                controlador.authentication(respuesta);
            } else if (respuesta == 3) {
                controlador.visualize();
            } else if (respuesta == 4) {
                myInput.close();
                paso1.close();
                paso2.close();
                paso3.close();
                return;
            }
            usarMenu();

        } else {
            System.out.println("### EDITOR COLABORATIVO ###\n" +
                    "## Registrado como: " + controlador.getOnlineUser() + " ##\n" +
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
                controlador.create(nombreDoc, textoDoc);
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
                if (controlador.checkOwnership(idDoc)) {
                    System.out.println("### EDITOR COLABORATIVO ###\n" +
                            "Ingrese un permiso (Permisos disponibles: w: write, r: read, c: comment):\n");

                    String permiso = paso3.nextLine();
                    controlador.share(usuarios, idDoc, permiso);
                } else {
                    System.out.println("El documento no existe o no eres el duenio de ese documento.\n");
                }

            } else if (respuesta == 3) {
                System.out.println("### EDITOR COLABORATIVO ###\n" +
                        "Ingrese la id del documento:\n");
                int idDoc = paso1.nextInt();
                if (controlador.checkOwnership(idDoc) || controlador.checkWritePermission(idDoc)) {
                    System.out.println("### EDITOR COLABORATIVO ###\n" +
                            "Ingrese un texto a agregar:\n");
                    String texto = paso2.nextLine();
                    controlador.add(idDoc, texto);
                } else {
                    System.out.println("El documento no existe o no tienes permisos para escribir en el.\n");
                }
            } else if (respuesta == 4) {
                System.out.println("### EDITOR COLABORATIVO ###\n" +
                        "Ingrese la id del documento:\n");
                int idDoc = paso1.nextInt();
                if (controlador.checkOwnership(idDoc)) {
                    System.out.println("### EDITOR COLABORATIVO ###\n" +
                            "Ingrese la id de la version a restaurar:\n");
                    int idVersion = paso2.nextInt();
                    controlador.rollback(idDoc, idVersion);
                } else {
                    System.out.println("El documento no existe o no eres el duenio de este.\n");
                }

            } else if (respuesta == 5) {
                System.out.println("### EDITOR COLABORATIVO ###\n" +
                        "Ingrese la id del documento:\n");
                int idDoc = paso1.nextInt();
                if (controlador.checkOwnership(idDoc)) {
                    controlador.revokeAccess(idDoc);
                } else {
                    System.out.println("El documento no existe o no eres el duenio de este.\n");
                }
            } else if (respuesta == 6) {
                System.out.println("### EDITOR COLABORATIVO ###\n" +
                        "Ingrese el texto a buscar:\n");
                String Texto = paso1.nextLine();
                controlador.search(Texto);
            } else if (respuesta == 7) {
                controlador.visualize();
            } else if (respuesta == 8) {
                controlador.setOnlineUser("");
            } else if (respuesta == 9) {
                return;
            }
            usarMenu();
        }
        myInput.close();
        paso1.close();
        paso2.close();
        paso3.close();
    }
}