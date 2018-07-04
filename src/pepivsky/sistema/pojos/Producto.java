/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pepivsky.sistema.pojos;

import java.io.File;

/**
 *
 * @author PP
 */
public class Producto {
    private String idProducto;
    private String nombreProducto;
    private String descripcionProducto;
    private double stockProducto;
    private File fotoProducto;
    private String unidadProducto;
    private double precioCompaProducto;
    private double precioVentaProducto;
    private double existenciasProducto;
    
    private int idCategoriaProd;
    private int idProveedor;

    public Producto(String idProducto, String nombreProducto, String descripcionProducto, double stockProducto,  File fotoProducto
            , String unidadProducto, double precioCompaProducto, double precioVentaProducto, double existenciasProducto, 
            int idCategoriaProd,int idProveedor) {
        
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.descripcionProducto = descripcionProducto;
        this.stockProducto = stockProducto;
        this.fotoProducto = fotoProducto;
        this.unidadProducto = unidadProducto;
        this.precioCompaProducto = precioCompaProducto;
        this.precioVentaProducto = precioVentaProducto;
        this.existenciasProducto = existenciasProducto;
        this.idCategoriaProd = idCategoriaProd;
        this.idProveedor = idProveedor;
    }
// File fotoProducto,
    

    

    public double getExistenciasProducto() {
        return existenciasProducto;
    }

    public void setExistenciasProducto(double existenciasProducto) {
        this.existenciasProducto = existenciasProducto;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public double getStockProducto() {
        return stockProducto;
    }

    public void setStockProducto(double stockProducto) {
        this.stockProducto = stockProducto;
    }

    public File getFotoProducto() {
        return fotoProducto;
    }

    public void setFotoProducto(File fotoProducto) {
        this.fotoProducto = fotoProducto;
    }

    public String getUnidadProducto() {
        return unidadProducto;
    }

    public void setUnidadProducto(String unidadProducto) {
        this.unidadProducto = unidadProducto;
    }

    public double getPrecioCompaProducto() {
        return precioCompaProducto;
    }

    public void setPrecioCompaProducto(double precioCompaProducto) {
        this.precioCompaProducto = precioCompaProducto;
    }

    public double getPrecioVentaProducto() {
        return precioVentaProducto;
    }

    public void setPrecioVentaProducto(double precioVentaProducto) {
        this.precioVentaProducto = precioVentaProducto;
    }
    
    public int getIdCategoriaProd() {
        return idCategoriaProd;
    }

    public void setIdCategoriaProd(int idCategoriaProd) {
        this.idCategoriaProd = idCategoriaProd;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }
    
    @Override
    public String toString(){
        return this.idProducto;
    }

    
    
    
    
}
