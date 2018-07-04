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
public class CategoriaProd {
    private int idCategoriaProd;
    private String nomCategoria;
    private String descriCategoriaProd;

    public CategoriaProd(int idCategoriaProd, String nomCategoria, String descriCategoriaProd) {
        this.idCategoriaProd = idCategoriaProd;
        this.nomCategoria = nomCategoria;
        this.descriCategoriaProd = descriCategoriaProd;
    }

    public int getIdCategoriaProd() {
        return idCategoriaProd;
    }

    public void setIdCategoriaProd(int idCategoriaProd) {
        this.idCategoriaProd = idCategoriaProd;
    }

    public String getNomCategoria() {
        return nomCategoria;
    }

    public void setNomCategoria(String nomCategoria) {
        this.nomCategoria = nomCategoria;
    }

    public String getDescriCategoriaProd() {
        return descriCategoriaProd;
    }

    public void setDescriCategoriaProd(String descriCategoriaProd) {
        this.descriCategoriaProd = descriCategoriaProd;
    }

    
    @Override
    public String toString(){
        return this.nomCategoria;
    }
   
    
    

   
    
    
}
