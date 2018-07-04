/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pepivsky.sistema.pojos;

/**
 *
 * @author PP
 */
public class Proveedor {
    
    private int idProveedor;
    private String nomProveedor;
    private String dirProveedor;
    private String telefonoProveedor;
    private String emailProveedor;
    private String contactoProveedor;

    public Proveedor(int idProveedor, String nomProveedor, String dirProveedor, String telefonoProveedor, String emailProveedor, String contactoProveedor) {
        this.idProveedor = idProveedor;
        this.nomProveedor = nomProveedor;
        this.dirProveedor = dirProveedor;
        this.telefonoProveedor = telefonoProveedor;
        this.emailProveedor = emailProveedor;
        this.contactoProveedor = contactoProveedor;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNomProveedor() {
        return nomProveedor;
    }

    public void setNomProveedor(String nomProveedor) {
        this.nomProveedor = nomProveedor;
    }

    public String getDirProveedor() {
        return dirProveedor;
    }

    public void setDirProveedor(String dirProveedor) {
        this.dirProveedor = dirProveedor;
    }

    public String getTelefonoProveedor() {
        return telefonoProveedor;
    }

    public void setTelefonoProveedor(String telefonoProveedor) {
        this.telefonoProveedor = telefonoProveedor;
    }

    public String getEmailProveedor() {
        return emailProveedor;
    }

    public void setEmailProveedor(String emailProveedor) {
        this.emailProveedor = emailProveedor;
    }

    public String getContactoProveedor() {
        return contactoProveedor;
    }

    public void setContactoProveedor(String contactoProveedor) {
        this.contactoProveedor = contactoProveedor;
    }

    
    @Override
    public String toString(){
        return this.nomProveedor;
    }
   
    
    
    
}
