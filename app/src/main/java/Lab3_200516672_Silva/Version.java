/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab3_200516672_Silva;

/**
 *
 * @author Matias
 */
public class Version {
    private int IdVersion;
    private String textoVersion;

    /**
     *
     * @param IdVersion
     * @param textoVersion
     */
    public Version(int IdVersion, String textoVersion) {
        this.IdVersion = IdVersion;
        this.textoVersion = textoVersion;
    }

    /**
     *
     * @return
     */
    public int getIdVersion() {
        return IdVersion;
    }

    /**
     *
     * @return
     */
    public String getTextoVersion() {
        return textoVersion;
    }

    /**
     *
     * @param IdVersion
     */
    public void setIdVersion(int IdVersion) {
        this.IdVersion = IdVersion;
    }

    /**
     *
     * @param textoVersion
     */
    public void setTextoVersion(String textoVersion) {
        this.textoVersion = textoVersion;
    }

    @Override
    public String toString() {
        return "Version:" + IdVersion + ", Texto=" + textoVersion + '\n';
    }
    
}
