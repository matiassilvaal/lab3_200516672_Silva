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
public class Documento {
    private int IdDoc;
    private String nombreDoc;
    private String textoDoc;
    private Date fechaDeCreacion;
    private Date fechaDeModificacion;
    private ArrayList<Version> versiones;
    private ArrayList<Acceso> accesos;

    public Documento(int IdDoc, String nombreDoc, String textoDoc, Date fechaDeCreacion, Date fechaDeModificacion) {
        this.IdDoc = IdDoc;
        this.nombreDoc = nombreDoc;
        this.textoDoc = textoDoc;
        this.fechaDeCreacion = fechaDeCreacion;
        this.fechaDeModificacion = fechaDeModificacion;
        this.versiones = new ArrayList<>();
        this.accesos = new ArrayList<>();
    }

    public int getIdDoc() {
        return IdDoc;
    }

    public String getNombreDoc() {
        return nombreDoc;
    }

    public String getTextoDoc() {
        return textoDoc;
    }

    public Date getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public Date getFechaDeModificacion() {
        return fechaDeModificacion;
    }

    public ArrayList<Version> getVersiones() {
        return versiones;
    }

    public ArrayList<Acceso> getAccesos() {
        return accesos;
    }

    public void setIdDoc(int IdDoc) {
        this.IdDoc = IdDoc;
    }

    public void setNombreDoc(String nombreDoc) {
        this.nombreDoc = nombreDoc;
    }

    public void setTextoDoc(String textoDoc) {
        this.textoDoc = textoDoc;
    }

    public void setFechaDeCreacion(Date fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public void setFechaDeModificacion(Date fechaDeModificacion) {
        this.fechaDeModificacion = fechaDeModificacion;
    }

    public void setVersiones(ArrayList<Version> versiones) {
        this.versiones = versiones;
    }

    public void setAccesos(ArrayList<Acceso> accesos) {
        this.accesos = accesos;
    }

    @Override
    public String toString() {
        return "Documento:" + IdDoc + ", Nombre del documento:" + nombreDoc + ", Texto:" + textoDoc + ", Fecha de creacion:" + fechaDeCreacion + ", fecha de modificacion:" + fechaDeModificacion + ", versiones:" + versiones + ", accesos:" + accesos + '\n';
    }

    
    
}
