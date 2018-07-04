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
public class DetalleVenta {
    private int idDetalleVEnta;
    private int idVenta;
    private int idProd;
    private Double cantidadVendida;

    public DetalleVenta(int idDetalleVEnta, int idVenta, int idProd, Double cantidadVendida) {
        this.idDetalleVEnta = idDetalleVEnta;
        this.idVenta = idVenta;
        this.idProd = idProd;
        this.cantidadVendida = cantidadVendida;
    }

    public Double getCantidadVendida() {
        return cantidadVendida;
    }

    public void setCantidadVendida(Double cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }

    public int getIdDetalleVEnta() {
        return idDetalleVEnta;
    }

    public void setIdDetalleVEnta(int idDetalleVEnta) {
        this.idDetalleVEnta = idDetalleVEnta;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdProd() {
        return idProd;
    }

    public void setIdProd(int idProd) {
        this.idProd = idProd;
    }

    
    
    
}
