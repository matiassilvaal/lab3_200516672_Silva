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
public class Controlador{
    private String onlineUser;
    private Editor plataforma;
    public Controlador() {
        plataforma = new Editor();
        onlineUser = "";
    }

    public Editor getPlataforma() {
        return plataforma;
    }
    public String getOnlineUser() {
        return onlineUser;
    }
    public void setOnlineUser(String onlineUser) {
        this.onlineUser = onlineUser;
    }
    public void Menu(){
        if(getOnlineUser() == ""){
            System.out.println("### EDITOR COLABORATIVO ###\n" +
                            "Escoja su opcion:\n" +
                            "1. Registrarse\n" +
                            "2. Logearse\n" +
                            "3. Cerrar el programa\n" +
                            "INTRODUZCA SU OPCION: _ ");
            int respuesta = 0;
            try{
                Scanner myInput = new Scanner( System.in );
                respuesta = myInput.nextInt();
            }
            catch(Exception e){
                System.out.println("Debes ingresar una opcion numerica");
            }
            if(respuesta == 1 || respuesta == 2){
                authentication(respuesta);
                Menu();
            }
            else if(respuesta == 3){
                
                return ;
            }
            else{
                System.out.println(respuesta);
                Menu();
            }
        }
        else{
            System.out.println("### EDITOR COLABORATIVO ###\n" +
                            "## Registrado como: "+ getOnlineUser()+ " ##\n" +
                            "Escoja su opcion:\n" +
                            "1. Crear nuevo documento\n" +
                            "2. Compartir documento\n" +
                            "3. Agregar contenido a un documento\n" +
                            "4. Restaurar versión de un documento\n" +
                            "5. Revocar acceso a un documento\n" +
                            "6. Buscar en los documentos\n" +
                            "7. Visualizar documentos\n" +
                            "8. Cerrar sesión\n" +
                            "9. Logout\n" +
                            "INTRODUZCA SU OPCION: _ ");
            int respuesta = 0;
            try{
                Scanner myInput = new Scanner( System.in );
                respuesta = myInput.nextInt();
            }
            catch(Exception e){
                System.out.println("Debes ingresar una opcion numerica");
            }
            if(respuesta == 1){
                System.out.println("### EDITOR COLABORATIVO ###\n" +
                            "Ingrese un nombre para el documento:\n");
                Scanner paso1 = new Scanner( System.in );
                String nombreDoc = paso1.nextLine();
                System.out.println("### EDITOR COLABORATIVO ###\n" +
                                "Ingrese un texto para el documento:\n");
                Scanner paso2 = new Scanner( System.in );
                String textoDoc = paso2.nextLine();
                create(nombreDoc, textoDoc);
            }
            else if(respuesta == 2){
                
            }
            if(respuesta == 10){
                System.out.println(plataforma.getDocumentos().toString());
            }
            Menu();
        }
        
    }

    public void authentication(int respuesta) {
        if(respuesta == 1){
            System.out.println("### EDITOR COLABORATIVO ###\n" +
                            "Ingrese un username:\n");
            Scanner paso1 = new Scanner( System.in );
            String usuario = paso1.nextLine();
            System.out.println("### EDITOR COLABORATIVO ###\n" +
                            "Ingrese una contrasena:\n");
            Scanner paso2 = new Scanner( System.in );
            String password = paso2.nextLine();
            ArrayList<Usuario> usuarios = plataforma.getUsuarios();
            
            for(int i=0; i<usuarios.size();i++){
                if(usuarios.get(i).getUsername().equals(usuario)){
                    System.out.println("ESE USUARIO YA EXISTE\n");
                    return ;
                }
            }
            Usuario newUser = new Usuario(usuario,password,new Date());
            usuarios.add(newUser);
            plataforma.setUsuarios(usuarios);
        }
        else{
            ArrayList<Usuario> usuarios = plataforma.getUsuarios();
            System.out.println("### EDITOR COLABORATIVO ###\n" +
                            "Ingrese su username:\n");
            Scanner paso1 = new Scanner( System.in );
            String usuario = paso1.nextLine();
            System.out.println("### EDITOR COLABORATIVO ###\n" +
                            "Ingrese su contrasena:\n");
            Scanner paso2 = new Scanner( System.in );
            String password = paso2.nextLine();
            for(int i=0; i<usuarios.size();i++){
                if(usuarios.get(i).getUsername().equals(usuario) && usuarios.get(i).getPassword().equals(password)){
                    onlineUser = usuario;
                    return ;
                }
            }
            System.out.println("Usuario o contrasena incorrecta\n");
        }
    }
    public void create(String nombreDoc, String textoDoc) {
        int i = plataforma.getLastIdDoc()+1;
        Documento nuevoDoc = new Documento(i, nombreDoc, textoDoc, new Date(), new Date());
        plataforma.getDocumentos().add(nuevoDoc);
    }
    public void share(ArrayList<String>usuarios, int idDoc, String permiso){
        for(int i=1; i < usuarios.size(); i+=1){
            for(int j=0; j < plataforma.getDocumentos().size(); j+=1){
                if(idDoc == plataforma.getDocumentos().get(i).getIdDoc()){
                    if(plataforma.getDocumentos().get(i).getAccesos().isEmpty()){
                        if(permiso.equals("w")){
                            Acceso newAcceso = new Acceso(getOnlineUser(), true, false, false);
                            plataforma.getDocumentos().get(i).getAccesos().add(newAcceso);
                            return ;
                        }
                        else if(permiso.equals("r")){
                            Acceso newAcceso = new Acceso(getOnlineUser(), false, true, false);
                            plataforma.getDocumentos().get(i).getAccesos().add(newAcceso);
                            return ;
                        }
                        if(permiso.equals("c")){
                            Acceso newAcceso = new Acceso(getOnlineUser(), false, false, true);
                            plataforma.getDocumentos().get(i).getAccesos().add(newAcceso);
                            return ;
                        }
                    }
                    for(int k=0; k < plataforma.getDocumentos().get(i).getAccesos().size(); k+=1){
                        if(getOnlineUser() == plataforma.getDocumentos().get(i).getAccesos().get(k).getNombre()){
                            if(permiso.equals("w")){
                                plataforma.getDocumentos().get(i).getAccesos().get(k).setEscritura(true);
                                return ;
                            }
                            else if(permiso.equals("r")){
                                plataforma.getDocumentos().get(i).getAccesos().get(k).setLectura(true);
                                return ;
                            }
                            else if(permiso.equals("c")){
                                plataforma.getDocumentos().get(i).getAccesos().get(k).setComentario(true);
                                return ;
                            }
                        }
                    }
                    if(permiso.equals("w")){
                        Acceso newAcceso = new Acceso(getOnlineUser(), true, false, false);
                        plataforma.getDocumentos().get(i).getAccesos().add(newAcceso);
                        return ;
                    }
                    else if(permiso.equals("r")){
                        Acceso newAcceso = new Acceso(getOnlineUser(), false, true, false);
                        plataforma.getDocumentos().get(i).getAccesos().add(newAcceso);
                        return ;
                    }
                    if(permiso.equals("c")){
                        Acceso newAcceso = new Acceso(getOnlineUser(), false, false, true);
                        plataforma.getDocumentos().get(i).getAccesos().add(newAcceso);
                        return ;
                    }
                }
            }
        }
    }
}
