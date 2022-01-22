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
    private ArrayList<String> versiones;
    private ArrayList<Acceso> accesos;

    /**
     *
     * @param IdDoc
     * @param nombreDoc
     * @param textoDoc
     * @param fechaDeCreacion
     * @param fechaDeModificacion
     */
    public Documento(int IdDoc, String nombreDoc, String textoDoc, Date fechaDeCreacion, Date fechaDeModificacion) {
        this.IdDoc = IdDoc;
        this.nombreDoc = nombreDoc;
        this.textoDoc = textoDoc;
        this.fechaDeCreacion = fechaDeCreacion;
        this.fechaDeModificacion = fechaDeModificacion;
        this.versiones = new ArrayList<>();
        this.accesos = new ArrayList<>();
    }

    /**
     *
     * @return
     */
    public int getIdDoc() {
        return IdDoc;
    }

    /**
     *
     * @return
     */
    public String getNombreDoc() {
        return nombreDoc;
    }

    /**
     *
     * @return
     */
    public String getTextoDoc() {
        return textoDoc;
    }

    /**
     *
     * @return
     */
    public Date getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    /**
     *
     * @return
     */
    public Date getFechaDeModificacion() {
        return fechaDeModificacion;
    }

    /**
     *
     * @return
     */
    public ArrayList<String> getVersiones() {
        return versiones;
    }

    /**
     *
     * @return
     */
    public ArrayList<Acceso> getAccesos() {
        return accesos;
    }
    
    /**
     *
     * @param IdDoc
     */
    public void setIdDoc(int IdDoc) {
        this.IdDoc = IdDoc;
    }

    /**
     *
     * @param nombreDoc
     */
    public void setNombreDoc(String nombreDoc) {
        this.nombreDoc = nombreDoc;
    }

    /**
     *
     * @param textoDoc
     */
    public void setTextoDoc(String textoDoc) {
        this.textoDoc = textoDoc;
    }

    /**
     *
     * @param fechaDeCreacion
     */
    public void setFechaDeCreacion(Date fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    /**
     *
     * @param fechaDeModificacion
     */
    public void setFechaDeModificacion(Date fechaDeModificacion) {
        this.fechaDeModificacion = fechaDeModificacion;
    }

    /**
     *
     * @param versiones
     */
    public void setVersiones(ArrayList<String> versiones) {
        this.versiones = versiones;
    }

    /**
     *
     * @param accesos
     */
    public void setAccesos(ArrayList<Acceso> accesos) {
        this.accesos = accesos;
    }

    @Override
    public String toString() {
        return "Documento:" + IdDoc + ", Nombre del documento:" + nombreDoc + ", Texto:" + textoDoc + ", Fecha de creacion:" + fechaDeCreacion + ", fecha de modificacion:" + fechaDeModificacion + ", versiones:" + versiones + ", accesos:" + accesos + '\n';
    }

    
    
}
