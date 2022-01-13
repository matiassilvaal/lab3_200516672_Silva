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

    public String getOnlineUser() {
        return onlineUser;
    }

    public void setOnlineUser(String onlineUser) {
        this.onlineUser = onlineUser;
    }
    public void Menu(){
        if(getOnlineUser() == ""){
            System.out.println("### EDITOR COLABORATIVO ###\n" +
                            "Escoja su opción:\n" +
                            "1. Registrarse\n" +
                            "2. Logearse\n" +
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
            else{
                Menu();
            }
        }
        else{
            System.out.println("### EDITOR COLABORATIVO ###\n" +
                            "## Registrado como: "+ getOnlineUser()+ " ##\n" +
                            "Escoja su opción:\n" +
                            "1. Crear nuevo documento\n" +
                            "2. Compartir documento\n" +
                            "3. Agregar contenido a un documento\n" +
                            "4. Restaurar versión de un documento\n" +
                            "5. Revocar acceso a un documento\n" +
                            "6. Buscar en los documentos\n" +
                            "7. Visualizar documentos\n" +
                            "8. Cerrar sesión\n" +
                            "9. Cerrar el programa\n" +
                            "INTRODUZCA SU OPCION: _ ");
            Scanner myInput = new Scanner( System.in );
        }
        
    }

    private void authentication(int respuesta) {
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
        }
    }    
}
