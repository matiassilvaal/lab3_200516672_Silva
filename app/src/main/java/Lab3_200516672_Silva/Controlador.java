/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab3_200516672_Silva;
import java.util.Scanner;

/**
 *
 * @author Matias
 */
public class Controlador extends Editor{
    private String onlineUser;
    public Controlador() {
        super();
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
                            "INTRODUZCA SU OPCIÓN: _ ");
            Scanner myInput = new Scanner( System.in );
            int respuesta = myInput.nextInt();
            if(respuesta == 1 || respuesta == 2){
                authentication(respuesta);
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
                            "INTRODUZCA SU OPCIÓN: _ ");
            Scanner myInput = new Scanner( System.in );
        }
        
    }

    private void authentication(int respuesta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }



    
}
